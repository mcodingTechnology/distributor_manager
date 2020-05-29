package com.els.runhe.returned.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.auth.entity.Role;
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
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.returned.entity.OrderReturn;
import com.els.runhe.returned.entity.OrderReturnExample;
import com.els.runhe.returned.event.OrderReturnCreatedEvent;
import com.els.runhe.returned.event.OrderReturnStatusEnum;
import com.els.runhe.returned.service.OrderReturnService;
import com.els.runhe.returned.utils.GetStatusEnum;
import com.els.runhe.returned.utils.OrderReturnSendWxMsgUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;

@Api(value="退货单")
@Controller
@RequestMapping("orderReturn")
public class OrderReturnController {
    @Resource
    protected OrderReturnService orderReturnService;
    
    @Resource
    protected CompanyService companyService;
    
    @Resource
    protected UserService userService;

    @ApiOperation(httpMethod="POST", value="创建退货单")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<OrderReturn> create(@RequestBody OrderReturn orderReturn) {
    	
    	//赋值  ：用户id、用户名称
    	orderReturn.setAddTime(new Date());
    	orderReturn.setUserId(SpringSecurityUtils.getLoginUserId());
    	orderReturn.setUserName(SpringSecurityUtils.getLoginUserName());
    	
        this.orderReturnService.addObj(orderReturn);
        return ResponseResult.success(orderReturn);
    }

    @ApiOperation(httpMethod="POST", value="编辑退货单")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<OrderReturn> edit(@RequestBody OrderReturn orderReturn) {
        if (orderReturn.getId() == null || orderReturn.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        
        if(orderReturn.getOrderReturnStatus()!=OrderReturnStatusEnum.UN_ADD.getCode()){
        	String message = new GetStatusEnum().getName(orderReturn.getOrderReturnStatus());
        	throw new CommonException(message+"的退货单不能进行修改！");
        }
        
        this.orderReturnService.modifyObj(orderReturn);
        return ResponseResult.success(orderReturn);
    }

    /*@ApiOperation(httpMethod="POST", value="删除退货单")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String orderReturnNo) {
        this.orderReturnService.deleteObjByOrderReturnNo(orderReturnNo);
        return ResponseResult.success();
    }*/
    
    @ApiOperation(httpMethod="POST",value="取消退货单")
    @RequestMapping("service/cancleOrderReturn")
    @ResponseBody
    public ResponseResult<String> cancleOrderReturn(@RequestBody List<String> orderReturnNo){
    	if(CollectionUtils.isEmpty(orderReturnNo)){
    		throw new CommonException("选择的退货单为空！");
    	}
    	
    	OrderReturnExample exampleTmp = new OrderReturnExample();
    	exampleTmp.createCriteria().andOrderReturnNoIn(orderReturnNo).andOrderReturnStatusEqualTo(OrderReturnStatusEnum.UN_RECEIVED.getCode());
    	if(CollectionUtils.isNotEmpty(this.orderReturnService.queryAllObjByExample(exampleTmp))){
    		throw new CommonException("存在待收货的退货单，无法取消");
    	}
    	
    	OrderReturnExample example = new OrderReturnExample();
    	example.createCriteria().andOrderReturnNoIn(orderReturnNo);
    	
    	//将退货单状态改为取消
    	OrderReturn record = new OrderReturn();
    	record.setOrderReturnStatus(OrderReturnStatusEnum.CANCLE.getCode());
    	this.orderReturnService.modifyObjByExample(record, example);
    	
    	List<OrderReturn> orderReturnList = this.orderReturnService.queryAllObjByExample(example);
    	OrderReturnSendWxMsgUtils.sendMsg(OrderReturnStatusEnum.CANCLE, orderReturnList);
    	return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询退货单")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderReturn", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<OrderReturn>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OrderReturnExample example = new OrderReturnExample();
        example.setPageView(new PageView<OrderReturn>(pageNo, pageSize));
        
        OrderReturnExample.Criteria criteria = example.createCriteria();
        CriteriaUtils.addCriterion(criteria, wapper);
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
    	
    	// 根据状态判断相应角色可以看到的订单
		List<Role> rolesList = SpringSecurityUtils.getLoginUserRoleList();
		List<Integer> statusList = new ArrayList<>();
 		if (CollectionUtils.isNotEmpty(rolesList) && rolesList.size() == 1) {
 			if (rolesList.get(0).getRoleCode().equals("distributor") || rolesList.get(0).getRoleCode().equals("distributor_manager")) { // 经销商
				statusList.add(0);
				statusList.add(1);
				statusList.add(2);
				statusList.add(3);
				statusList.add(4);
				criteria.andOrderReturnStatusIn(statusList);
			}else if (rolesList.get(0).getRoleCode().equals("business") || rolesList.get(0).getRoleCode().equals("business_manager")) { // 营运
				statusList.add(1);
				statusList.add(2);
				statusList.add(3);
				statusList.add(4);
				criteria.andOrderReturnStatusIn(statusList);
			}else if (rolesList.get(0).getRoleCode().equals("warehouse_specialist") || rolesList.get(0).getRoleCode().equals("warehouse_manager")) { // 仓库
				statusList.add(2);
				statusList.add(3);
				statusList.add(4);
				criteria.andOrderReturnStatusIn(statusList);
			}else {
				criteria.andOrderReturnStatusNotEqualTo(5);
			}
		}
        example.setOrderByClause("add_time DESC");
        PageView<OrderReturn> pageData = this.orderReturnService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(httpMethod="POST", value="查询业务退货单")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderReturn", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPageForDealer")
    @ResponseBody
    public ResponseResult<PageView<OrderReturn>> findByPageForDealer( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OrderReturnExample example = new OrderReturnExample();
        example.setPageView(new PageView<OrderReturn>(pageNo, pageSize));
        
        OrderReturnExample.Criteria criteria = example.createCriteria();
        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        criteria.andPurCompanyIdEqualTo(CompanyUtils.currentCompanyId());
        example.setOrderByClause("add_time DESC");
        PageView<OrderReturn> pageData = this.orderReturnService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(httpMethod="POST",value="退货单发货")
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "logisticsNo",required = false,value = "物流单号", paramType = "query", dataType = "String"),
    	@ApiImplicitParam( name = "orderReturnNo", required = false, value = "退货单号", paramType = "body", dataType = "List<String>" )
    })
    @RequestMapping("service/orderReturnDeliver")
    @ResponseBody
    public ResponseResult<String> orderReturnDeliver(
    		@RequestParam String logisticsNo,
    		@RequestBody List<String> orderReturnNo){
    	if(CollectionUtils.isEmpty(orderReturnNo)){
    		throw new CommonException("选择的退货单为空！");
    	}
    	
    	OrderReturnExample example = new OrderReturnExample();
    	example.createCriteria().andOrderReturnNoIn(orderReturnNo);
    	
    	//判断所选参数的状态
    	List<OrderReturn> orderReturnList =this.orderReturnService.queryAllObjByExample(example);
    	for(OrderReturn record: orderReturnList){
    		if(record.getOrderReturnStatus() != OrderReturnStatusEnum.UN_DELIVERED.getCode()){
    			String message = new GetStatusEnum().getName(record.getOrderReturnStatus());
    			throw new CommonException("只有待发货的退货单可以发货，选择行中存在"+message+"的退货单，不可进行发货");
    		}
    	}
    	
    	OrderReturn orderReturn= new OrderReturn();
    	//输入物流单号
    	if(StringUtils.isNotBlank(logisticsNo)){
    		orderReturn.setLogisticsNo(logisticsNo);
    	}
    	orderReturn.setOrderReturnStatus(OrderReturnStatusEnum.UN_RECEIVED.getCode());
    	this.orderReturnService.modifyObjByExample(orderReturn, example);
    	
    	return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST",value="退货单收货")
    @RequestMapping("service/orderReturnFinished")
    @ResponseBody
    public ResponseResult<String> orderReturnFinished(@RequestBody List<String> orderReturnNo){
    	if(CollectionUtils.isEmpty(orderReturnNo)){
    		throw new CommonException("选择的退货单为空！");
    	}
    	
    	OrderReturnExample example = new OrderReturnExample();
    	example.createCriteria().andOrderReturnNoIn(orderReturnNo);
    	
    	//判断所选参数的状态
    	List<OrderReturn> orderReturnList =this.orderReturnService.queryAllObjByExample(example);
    	for(OrderReturn record: orderReturnList){
    		if(record.getOrderReturnStatus() != OrderReturnStatusEnum.UN_RECEIVED.getCode()){
    			String message = new GetStatusEnum().getName(record.getOrderReturnStatus());
    			throw new CommonException("只有待收货的退货单可以收货，选择行中存在"+message+"的退货单，不可进行收货");
    		}
    	}
    	
    	OrderReturn orderReturn= new OrderReturn();
    	orderReturn.setOrderReturnStatus(OrderReturnStatusEnum.UN_FINISHED.getCode());
    	this.orderReturnService.modifyObjByExample(orderReturn, example);
    	
    	List<OrderReturn> list=this.orderReturnService.queryAllObjByExample(example);
    	for(OrderReturn temp :list){
    		if(temp.getReturnOrderType().equals("2")){
    			OrderReturnSendWxMsgUtils.sendMsg(OrderReturnStatusEnum.UN_FINISHED, temp);
    		}
    	}    	
    	return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="退货单提交审批")
    @RequestMapping("service/submitApproval")
    @ResponseBody
    public ResponseResult<String> submitApproval(@RequestBody OrderReturn orderReturn) {
    	
    	if(StringUtils.isEmpty(orderReturn.getOrderReturnNo())){
    		//赋值  ：用户id、用户名称
        	orderReturn.setAddTime(new Date());
        	orderReturn.setUserId(SpringSecurityUtils.getLoginUserId());
        	orderReturn.setUserName(SpringSecurityUtils.getLoginUserName());
        	
            this.orderReturnService.addObj(orderReturn);
    	}else{
    		this.orderReturnService.modifyObj(orderReturn);
    	}
    	
    	OrderReturn record = this.orderReturnService.queryByOrderReturnNo(orderReturn.getOrderReturnNo());
    	//判断参数退货单状态,新增则发起审批
    	if(record.getOrderReturnStatus().equals(OrderReturnStatusEnum.UN_ADD.getCode())){
    		SpringContextHolder.getApplicationContext().publishEvent(new OrderReturnCreatedEvent(record));
    	}else{
    		throw new CommonException("该退货单已提交审批！");
    	}
    	
        return ResponseResult.success();
    }
}