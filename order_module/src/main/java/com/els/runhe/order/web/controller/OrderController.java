package com.els.runhe.order.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.auth.dao.UserRoleMapper;
import com.els.base.auth.entity.Role;
import com.els.base.auth.entity.UserRole;
import com.els.base.auth.entity.UserRoleExample;
import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.company.entity.Company;
import com.els.base.company.entity.CompanyExample;
import com.els.base.company.entity.UserArea;
import com.els.base.company.service.CompanyService;
import com.els.base.company.utils.CompanyUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.entity.user.User;
import com.els.base.core.exception.CommonException;
import com.els.base.core.service.user.UserService;
import com.els.base.core.utils.Assert;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.project.ProjectUtils;
import com.els.base.core.utils.query.QueryParam;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderExample;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.entity.OrderProductExample;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.command.CancelOrderCommand;
import com.els.runhe.order.ruleengine.command.CreateOrderCommand;
import com.els.runhe.order.ruleengine.command.DeliverOrderCommand;
import com.els.runhe.order.ruleengine.command.ModifyOrderCommand;
import com.els.runhe.order.ruleengine.command.SaveSerialNumberCommand;
import com.els.runhe.order.ruleengine.command.SubmitBatchOrderComand;
import com.els.runhe.order.ruleengine.command.SubmitOrderComand;
import com.els.runhe.order.ruleengine.state.DeliveryStatus;
import com.els.runhe.order.service.OrderProductService;
import com.els.runhe.order.service.OrderSaleSupportRecordService;
import com.els.runhe.order.service.OrderService;
import com.els.runhe.order.utils.OrderSendWxMsgUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;

@Api(value="订单")
@Controller
@RequestMapping("order")
public class OrderController {
    @Resource
    protected OrderService orderService;
    
    @Resource
    protected OrderProductService orderProductService;
    
    @Resource
    protected OrderRuleEngine orderRuleEngine;
    
    @Resource
    protected CompanyService companyService;
    
    @Resource
    protected UserService userService;
    
    @Resource
    protected OrderSaleSupportRecordService saleSupportRecordService;
    
    @Autowired
    private UserRoleMapper userRoleMapper;

    @ApiOperation(httpMethod="POST", value="保存订单")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody Order order) {
    	this.orderRuleEngine.invoke(new CreateOrderCommand(order));
        return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="提交订单")
    @RequestMapping("service/submit")
    @ResponseBody
    public ResponseResult<String> submit(@RequestBody Order order) {
    	
    	this.orderRuleEngine.invoke(new SubmitOrderComand(order) );
        return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="批量提交订单")
    @RequestMapping("service/submitForBatch")
    @ResponseBody
    public ResponseResult<String> submitForBatch(@RequestBody List<String> orderIds) {
    	Assert.isNotEmpty(orderIds, "订单id列表不能为空");
    	
    	this.orderRuleEngine.invoke(new SubmitBatchOrderComand(orderIds));
    	return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="预创建订单")
    @ApiImplicitParams({ 
	    @ApiImplicitParam( name = "purCompanyId",required = false,value = "经销商id", paramType = "query", dataType = "String" )  
    }) 
    @RequestMapping("service/preview")
    @ResponseBody
    public ResponseResult<Order> preview(String purCompanyId){

		if (CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果是供货商 润禾
			Order order = new Order();
	    	order.setSupCompanyId(CompanyUtils.currentCompanyId());
	    	order.setSupCompanyName(CompanyUtils.currentCompany().getCompanyFullName());
	    	order.setRemark("无");
	    	
	    	if (StringUtils.isNotEmpty(purCompanyId)) {
	    		Company company = this.companyService.queryObjById(purCompanyId);
	    		order.setPurCompanyId(company.getId());
	    		order.setPurCompanyName(company.getCompanyFullName());
	    		order.setPayType(company.getClearingForm());
	    		order.setSaleAndMarketSupport(this.saleSupportRecordService.calculateByOrderId(purCompanyId));
			}
	    	
			return ResponseResult.success(order);
		}
		
    	
    	Order order = new Order();
    	
    	String supCompanyId = ProjectUtils.getProject().getCompanyId();
    	Company supCompany = this.companyService.queryObjById(supCompanyId);
    	order.setSupCompanyId(supCompany.getId());
    	order.setSupCompanyName(supCompany.getCompanyFullName());
    	
    	order.setPurCompanyId(CompanyUtils.currentCompanyId());
    	order.setPurCompanyName(CompanyUtils.currentCompany().getCompanyFullName());
    	order.setRemark("无");
    	order.setPayType(CompanyUtils.currentCompany().getClearingForm());
    	order.setSaleAndMarketSupport(this.saleSupportRecordService.calculateByOrderId(CompanyUtils.currentCompanyId()));
    	
    	return ResponseResult.success(order);
    }
    
    /*private BigDecimal getAmountPayForAllOrder(String companyId){
    	OrderExample example = new OrderExample();
		example.createCriteria().andPurCompanyIdEqualTo(CompanyUtils.currentCompanyId());
		
		List<Order> orderList = this.orderService.queryAllObjByExample(example);
		
		BigDecimal totalPay = BigDecimal.ZERO;
		for(Order order: orderList){
			totalPay = totalPay.add(order.getAmountPay());
		}
		
		return totalPay;
    }*/
    
    @ApiOperation(httpMethod="POST", value="编辑订单")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody Order order) {
        if (StringUtils.isBlank(order.getId())) {
            throw new CommonException("id 为空，保存失败");
        }
        this.orderRuleEngine.invoke(new ModifyOrderCommand(order));
        return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="订单发货")
    @RequestMapping("service/deliverOrder")
    @ResponseBody
    public ResponseResult<String> deliverOrder(@RequestBody List<String> orderIds, String deliveryCode) {
    	if (CollectionUtils.isEmpty(orderIds)) {
			throw new CommonException("选择的订单为空");
		}
    	
    	this.orderRuleEngine.invoke(new DeliverOrderCommand(orderIds, deliveryCode));
    	
    	return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="保存订单流水号")
    @RequestMapping("service/saveOrderSerialNum")
    @ResponseBody
    public ResponseResult<String> saveOrderSerialNum(@RequestBody Order order) {
    	if (CollectionUtils.isEmpty(order.getOrderItems())) {
    		throw new CommonException("输入的数据为空");
    	}
    	
    	this.orderRuleEngine.invoke(new SaveSerialNumberCommand(order));
    	
    	return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="订单收货")
    @RequestMapping("service/finishOrder")
    @ResponseBody
    public ResponseResult<String> finishOrder(@RequestBody List<String> orderIds) {
    	if (CollectionUtils.isEmpty(orderIds)) {
    		throw new CommonException("选择的订单为空");
    	}
    	
    	OrderExample example = new OrderExample();
    	example.createCriteria()
    	    .andIdIn(orderIds)
    	    .andDeliveryStatusNotEqualTo(DeliveryStatus.UN_RECEIVED.getCode());
    	if (CollectionUtils.isNotEmpty(this.orderService.queryAllObjByExample(example))) {
			throw new CommonException("订单中未发货或者已收货的订单，无法操作");
		}
    	
    	example.clear();
    	example.createCriteria().andIdIn(orderIds);
    	
    	Order record = new Order();
    	record.setDeliveryStatus(DeliveryStatus.FININSH.getCode());
		this.orderService.modifyObjByExample(record , example);
		
		List<Order> orderList = this.orderService.queryAllObjByExample(example);
		OrderSendWxMsgUtils.sendMsg(OrderSendWxMsgUtils.ORDER_STATUS_FININSH, orderList);
    	return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="取消订单")
    @RequestMapping("service/cancleOrder")
    @ResponseBody
    public ResponseResult<String> cancelOrder(@RequestBody List<String> orderIds) {
    	if (CollectionUtils.isEmpty(orderIds)) {
    		throw new CommonException("选择的订单为空");
    	}
    	
    	CancelOrderCommand cancelOrderCommand = new CancelOrderCommand(orderIds);
    	this.orderRuleEngine.invoke(cancelOrderCommand);
    	
    	return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询订单")
    @ApiImplicitParams({ 
	    @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	    @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	    @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Order", paramType = "body", dataType = "QueryParamWapper" ),  
	    @ApiImplicitParam( name = "product", required = false, value = "产品名称", paramType = "query", dataType = "string" )  
    }) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<Order>> findByPage(
    		@RequestParam(defaultValue="0") int pageNo, 
    		@RequestParam(defaultValue="10") int pageSize, 
    		@RequestBody(required=false) QueryParamWapper wapper,
    		@RequestParam(required=false) String product) {
    	
    	List<String> orderIds = new ArrayList<>();
    	if (StringUtils.isNotBlank(product)) {
    		try {
				product = URLDecoder.decode(product,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
    		OrderProductExample orderProductExample = new OrderProductExample();
    		orderProductExample.createCriteria().andProductNameLike("%"+product+"%");
    		List<OrderProduct> orderList = this.orderProductService.queryAllObjByExample(orderProductExample);
    		
    		for(int i=0; CollectionUtils.isNotEmpty(orderList) && i<orderList.size(); i++){
    			orderIds.add(orderList.get(i).getOrderId());
    		}
    	}
    	
        OrderExample example = new OrderExample();
        example.setPageView(new PageView<Order>(pageNo, pageSize));
        
        OrderExample.Criteria criteria = example.createCriteria();
        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        if (CollectionUtils.isNotEmpty(orderIds)) {
			criteria.andIdIn(orderIds);
		}
        String orderNo = "";
        if (wapper != null && CollectionUtils.isNotEmpty(wapper.getQueryParams())) {
        	for (QueryParam item : wapper.getQueryParams()) {
        		if (item.getProperty().equals("orderNo") && StringUtils.isNotEmpty(item.getValue())) {
        			orderNo = item.getValue();
        			break;
        		}
        	}
        }
        // 如果订单编号不为空这不进行区域控制数据
        if (StringUtils.isEmpty(orderNo)) {
        	// 查询当前用户所分配的区域
        	String userId = SpringSecurityUtils.getLoginUserId();
        	if(StringUtils.isNotEmpty(userId)){
        		User user = this.userService.queryObjById(userId);
        		if(StringUtils.isNotEmpty(user.getUserArea())){
        			List<UserArea> userAreas = new ArrayList<UserArea>();
        			JSONArray jsonArray = JSONArray.fromObject(user.getUserArea());
        			userAreas = (List<UserArea>) jsonArray.toCollection(jsonArray, UserArea.class);
        			List<String> strings = new ArrayList<>();
        			for(UserArea values : userAreas){
        				strings.add(values.getId());
        			}
        			if(strings.size() > 0 ){
        				String areaIds = strings.toString();
        				areaIds = areaIds.substring(1, areaIds.length()-1);
        				CompanyExample paramExample = new CompanyExample();
        				CompanyExample.Criteria companyCriteria = paramExample.createCriteria(); 
        				companyCriteria.andAreaOrId("AREA IN ("+areaIds+") OR CITY IN ("+areaIds+") OR PROVINCE IN ("+areaIds+") OR DISTRICT IN("+areaIds+")");
        				List<Company> companyList = companyService.queryAllObjByExample(paramExample);
        				List<String> companyStrings = new ArrayList<String>();
        				for(Company company:companyList){
        					companyStrings.add(company.getId());
        				}
        				if(companyStrings.size() > 0){
        					criteria.andPurCompanyIdIn(companyStrings);
        				}else {
        					criteria.andNotPurCompanyId();
        				}
        			}else {
        				criteria.andNotPurCompanyId();
        			}
        		}else{
        			criteria.andNotPurCompanyId();
        		}
        	}else {
        		criteria.andNotPurCompanyId();
        	}
        }
        
        // 如果是仓库主管，只显示通过财务审批的单据，其他不显示
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(SpringSecurityUtils.getLoginUserId());
        List<UserRole> roleList = userRoleMapper.selectByExample(userRoleExample);
		/*if (CollectionUtils.isNotEmpty(roleList) && roleList.size() == 1) {
			if (roleList.get(0).getRoleId().equals("20171130040401-faf024cad1ce470ea") || 
					roleList.get(0).getRoleId().equals("20180108094725-4c62feb0c55143a6a")) {
				criteria.andStatusEqualTo(700); // 已支付
				criteria.andApprovalStatusEqualTo(200); // 审批通过
				criteria.andDeliveryStatusEqualTo(300); // 待发货
			}
		}*/
		// 根据状态判断相应角色可以看到的订单
		List<Role> rolesList = SpringSecurityUtils.getLoginUserRoleList();
		List<Integer> statusList = new ArrayList<>(); // 状态
		List<Integer> approvalStatusList = new ArrayList<>(); // 审批状态
		List<Integer> deliveryStatusList = new ArrayList<>(); // 发货状态
		List<Integer> typeList = new ArrayList<>(); // 订单类型
 		if (CollectionUtils.isNotEmpty(rolesList) && rolesList.size() == 1) {
			if (rolesList.get(0).getRoleCode().equals("distributor") || rolesList.get(0).getRoleCode().equals("distributor_manager")) { // 经销商
				statusList.add(100);
				statusList.add(200);
				statusList.add(700);
				criteria.andStatusIn(statusList);
			}else if (rolesList.get(0).getRoleCode().equals("business") || rolesList.get(0).getRoleCode().equals("business_manager")) { // 营运
				statusList.add(100);
				statusList.add(200);
				statusList.add(700);
				criteria.andStatusIn(statusList);
			}else if (rolesList.get(0).getRoleCode().equals("financial") || rolesList.get(0).getRoleCode().equals("financial_account")) { // 财务
				statusList.add(200);
				statusList.add(700);
				approvalStatusList.add(150);
				approvalStatusList.add(200);
				approvalStatusList.add(300);
				criteria.andStatusIn(statusList);
				criteria.andApprovalStatusIn(approvalStatusList);
			}else if (rolesList.get(0).getRoleCode().equals("warehouse_specialist") || rolesList.get(0).getRoleCode().equals("warehouse_manager")) { // 仓库
				statusList.add(700);
				criteria.andStatusIn(statusList);
			}else if (rolesList.get(0).getRoleCode().equals("channel_supervisor")) { // 渠道主管
				deliveryStatusList.add(400);
				typeList.add(1);
				typeList.add(2);
				criteria.andDeliveryStatusIn(deliveryStatusList);
				criteria.andTypeIn(typeList);
			}else {
				criteria.andStatusNotEqualTo(600);
			}
		}
        example.setOrderByClause("delivery_status ASC,add_time DESC"); // 完成了的订单排在最后
        PageView<Order> pageData = this.orderService.queryObjByPage(example);
        
        return ResponseResult.success(pageData);
    }
    
    
    @ApiOperation(httpMethod="POST", value="经销商查询订单")
    @ApiImplicitParams({ 
    	@ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
    	@ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
    	@ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Order", paramType = "body", dataType = "QueryParamWapper" )  ,  
	    @ApiImplicitParam( name = "product", required = false, value = "产品名称", paramType = "query", dataType = "string" )  
    }) 
    @RequestMapping("service/findByPageForDealer")
    @ResponseBody
    public ResponseResult<PageView<Order>> findByPageForDealer(
    		@RequestParam(defaultValue="0") int pageNo, 
    		@RequestParam(defaultValue="10") int pageSize, 
    		@RequestBody(required=false) QueryParamWapper wapper,
    		@RequestParam(required=false) String product) {
    	
    	List<String> orderIds = new ArrayList<>();
        if (StringUtils.isNotBlank(product)) {
        	OrderProductExample orderProductExample = new OrderProductExample();
        	orderProductExample.createCriteria()
        	    .andProductNameLike("%"+product+"%")
        	    .andCompanyIdEqualTo(CompanyUtils.currentCompanyId());
        	
        	List<OrderProduct> orderList = this.orderProductService.queryAllObjByExample(orderProductExample);
        	
        	for(int i=0; CollectionUtils.isNotEmpty(orderList) && i<orderList.size(); i++){
        		orderIds.add(orderList.get(i).getId());
        	}
        }
    	
    	OrderExample example = new OrderExample();
    	example.setPageView(new PageView<Order>(pageNo, pageSize));
    	
    	OrderExample.Criteria criteria = example.createCriteria();
    	if (wapper != null) {
    		CriteriaUtils.addCriterion(criteria, wapper);
    	}
    	// String userId = SpringSecurityUtils.getLoginUserId();
    	// criteria.andUserIdEqualTo(userId);
    	criteria.andTypeEqualTo(0); // 订单类型为产品订单
    	criteria.andPurCompanyIdEqualTo(CompanyUtils.currentCompanyId());
    	example.setOrderByClause("delivery_status ASC,add_time DESC");
    	PageView<Order> pageData = this.orderService.queryObjByPage(example);
    	
    	
    	return ResponseResult.success(pageData);
    }
    
}