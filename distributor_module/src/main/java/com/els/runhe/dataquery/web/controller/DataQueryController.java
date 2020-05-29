package com.els.runhe.dataquery.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.auth.entity.Role;
import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.company.entity.Company;
import com.els.base.company.entity.CompanyExample;
import com.els.base.company.entity.UserArea;
import com.els.base.company.service.CompanyService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.entity.user.User;
import com.els.base.core.entity.user.UserExample;
import com.els.base.core.service.user.UserService;
import com.els.base.utils.SpringContextHolder;
import com.els.base.workflow.common.entity.WorkOrderVo;
import com.els.base.workflow.common.service.WorkFlowService;
import com.els.runhe.market.dao.design.MarketDesignApplyMapper;
import com.els.runhe.market.dao.promotional.PromotionalCostApplyMapper;
import com.els.runhe.market.dao.train.MarketTrainApplyMapper;
import com.els.runhe.market.entity.design.MarketDesignApply;
import com.els.runhe.market.entity.design.MarketDesignApplyExample;
import com.els.runhe.market.entity.promotional.PromotionalCostApply;
import com.els.runhe.market.entity.promotional.PromotionalCostApplyExample;
import com.els.runhe.market.entity.train.MarketTrainApply;
import com.els.runhe.market.entity.train.MarketTrainApplyExample;
import com.els.runhe.market.event.promotional.PromotionalCostStatusEnum;
import com.els.runhe.order.dao.OrderMapper;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderExample;
import com.els.runhe.region.dao.RegionMapper;
import com.els.runhe.region.entity.Region;
import com.els.runhe.region.entity.RegionExample;
import com.els.runhe.returned.dao.OrderReturnMapper;
import com.els.runhe.returned.entity.OrderReturn;
import com.els.runhe.returned.entity.OrderReturnExample;
import com.els.runhe.warehouse.dao.StockAdjustMapper;
import com.els.runhe.warehouse.dao.StockCheckMapper;
import com.els.runhe.warehouse.entity.StockAdjust;
import com.els.runhe.warehouse.entity.StockAdjustExample;
import com.els.runhe.warehouse.entity.StockCheck;
import com.els.runhe.warehouse.entity.StockCheckExample;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;

@Api(value = "地区")
@Controller
@RequestMapping("dataQuery")
public class DataQueryController {
	
	@Resource
    protected CompanyService companyService;
    
    @Resource
    protected UserService userService;
    
    @Resource
    protected OrderMapper orderMapper;
    
    @Resource
    protected OrderReturnMapper orderReturnMapper;
    
    @Resource
    protected MarketTrainApplyMapper marketTrainApplyMapper;
    
    @Resource
    protected RegionMapper regionMapper;
    
    @Resource
    protected MarketDesignApplyMapper marketDesignApplyMapper;
    
    @Resource
    protected PromotionalCostApplyMapper promotionalCostApplyMapper;
    
    @Resource
    protected StockCheckMapper stockCheckMapper;
    
    @Resource
    protected StockAdjustMapper stockAdjustMapper;

	@ApiOperation(httpMethod = "GET", value = "查找当前角色的任务")
    @ApiImplicitParams({ 
	    @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "1" ),  
	    @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	    @ApiImplicitParam( name = "businessKey", required = false, value = "业务编码", paramType = "query", dataType = "String")  
	}) 
	@RequestMapping("service/findTodoTask")
	@ResponseBody
	private ResponseResult<PageView<WorkOrderVo>> findTodoTask(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="10") int pageSize,
			String businessKey ) {
		List<Role> roleList = SpringSecurityUtils.getLoginUserRoleList();
		
		if (CollectionUtils.isEmpty(roleList)) {
			return ResponseResult.success(new PageView<WorkOrderVo>(pageNo, pageSize));
		}
		
		WorkFlowService workFlowService = SpringContextHolder.getOneBean(WorkFlowService.class);
		
		List<WorkOrderVo> subTaskList = workFlowService.findAllTodoTask(roleList, businessKey);
		
		List<String> orderIds = new ArrayList<String>(); // 订单
		List<String> returnOrderIds = new ArrayList<String>(); // 退货单
		List<String> marketTrainApplyIds = new ArrayList<String>(); 
		List<String> marketDesignApproveIds = new ArrayList<String>();
		List<String> promotionalCostIds = new ArrayList<String>();
		List<String> stockCheckIds = new ArrayList<String>(); // 库存盘点单
		List<String> stockAdjustIds = new ArrayList<String>(); // 库存调整单
		
		List<String> companyIds = new ArrayList<String>(); // 查询经销商ID
		List<String> userIds = new ArrayList<String>(); // 查询用户ID
		
		if (CollectionUtils.isNotEmpty(subTaskList)) {
			for (WorkOrderVo vo : subTaskList) {
				if ("order_approve_process".equals(vo.getProcessDefinitionKey())) {
					orderIds.add(vo.getBusinessKey());
				}else if ("order_return_approve_process".equals(vo.getProcessDefinitionKey())) {
					returnOrderIds.add(vo.getBusinessKey());
				}else if ("market_train_approve_process".equals(vo.getProcessDefinitionKey())) {
					marketTrainApplyIds.add(vo.getBusinessKey());
				}else if ("market_design_approve_process".equals(vo.getProcessDefinitionKey())) {
					marketDesignApproveIds.add(vo.getBusinessKey());
				}else if ("promotional_cost_approve_process".equals(vo.getProcessDefinitionKey())
						|| "promotional_costs_approve_process".equals(vo.getProcessDefinitionKey())) {
					promotionalCostIds.add(vo.getBusinessKey());
				}else if ("stock_check_approve_process".equals(vo.getProcessDefinitionKey())) {
					stockCheckIds.add(vo.getBusinessKey());
				}else if ("stock_adjust_approve_process".equals(vo.getProcessDefinitionKey())) {
					stockAdjustIds.add(vo.getBusinessKey());
				}
			}
		}
		
		if (CollectionUtils.isNotEmpty(orderIds) || CollectionUtils.isNotEmpty(returnOrderIds)) {
			companyIds = this.queryCompanyIds(SpringSecurityUtils.getLoginUserId());
		}
		
		if (CollectionUtils.isNotEmpty(marketTrainApplyIds) 
				|| CollectionUtils.isNotEmpty(marketDesignApproveIds) 
				||  CollectionUtils.isNotEmpty(promotionalCostIds)
				||  CollectionUtils.isNotEmpty(stockCheckIds)
				||  CollectionUtils.isNotEmpty(stockAdjustIds)) {
			userIds = this.returnUserIds();
		}
		
		if (CollectionUtils.isNotEmpty(orderIds) && CollectionUtils.isNotEmpty(companyIds)) {
			OrderExample example = new OrderExample();
			OrderExample.Criteria criteria = example.createCriteria();
			criteria.andPurCompanyIdIn(companyIds);
			criteria.andOrderNoIn(orderIds);
			List<Order> list = this.orderMapper.selectByExample(example);
			orderIds = new ArrayList<String>();
			if (CollectionUtils.isNotEmpty(list)) {
				for (Order model : list) {
					orderIds.add(model.getOrderNo());
				}
			}
		}else{
			orderIds = new ArrayList<String>();
		}
		
		if (CollectionUtils.isNotEmpty(returnOrderIds) && CollectionUtils.isNotEmpty(companyIds)) {
			OrderReturnExample example = new OrderReturnExample();
			OrderReturnExample.Criteria criteria = example.createCriteria();
			criteria.andPurCompanyIdIn(companyIds);
			criteria.andOrderReturnNoIn(returnOrderIds);
			List<OrderReturn> list = this.orderReturnMapper.selectByExample(example);
			returnOrderIds = new ArrayList<String>();
			if (CollectionUtils.isNotEmpty(list)) {
				for (OrderReturn model : list) {
					returnOrderIds.add(model.getOrderReturnNo());
				}
			}
		}else{
			returnOrderIds = new ArrayList<String>();
		}
		
		if (CollectionUtils.isNotEmpty(marketTrainApplyIds) && CollectionUtils.isNotEmpty(userIds)) {
			MarketTrainApplyExample example = new MarketTrainApplyExample();
			MarketTrainApplyExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdIn(userIds);
			criteria.andTrainApplyIdIn(marketTrainApplyIds);
			List<MarketTrainApply> list = this.marketTrainApplyMapper.selectByExample(example);
			marketTrainApplyIds = new ArrayList<String>();
			if (CollectionUtils.isNotEmpty(list)) {
				for (MarketTrainApply model : list) {
					marketTrainApplyIds.add(model.getTrainApplyId());
				}
			}
		}else{
			marketTrainApplyIds = new ArrayList<String>();
		}
		
		if (CollectionUtils.isNotEmpty(marketDesignApproveIds) && CollectionUtils.isNotEmpty(userIds)) {
			MarketDesignApplyExample example = new MarketDesignApplyExample();
			MarketDesignApplyExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdIn(userIds);
			criteria.andDesignApplyIdIn(marketDesignApproveIds);
			List<MarketDesignApply> list =this.marketDesignApplyMapper.selectByExample(example);
			marketDesignApproveIds = new ArrayList<String>();
			if (CollectionUtils.isNotEmpty(list)) {
				for (MarketDesignApply model : list) {
					marketDesignApproveIds.add(model.getDesignApplyId());
				}
			}
		}else{
			marketDesignApproveIds = new ArrayList<String>();
		}
		
		if (CollectionUtils.isNotEmpty(promotionalCostIds)  && CollectionUtils.isNotEmpty(userIds)) {
			PromotionalCostApplyExample example = new PromotionalCostApplyExample();
			PromotionalCostApplyExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdIn(userIds);
			criteria.andPromotionalCostNoIn(promotionalCostIds);
			criteria.andStatusNotEqualTo(PromotionalCostStatusEnum.TO_BE_DESIGNED.getCode());
			List<PromotionalCostApply> list = this.promotionalCostApplyMapper.selectByExample(example);
			promotionalCostIds = new ArrayList<String>();
			if (CollectionUtils.isNotEmpty(list)) {
				for (PromotionalCostApply model : list) {
					promotionalCostIds.add(model.getPromotionalCostNo());
				}
			}
		}else{
			promotionalCostIds = new ArrayList<String>();
		}
		
		if (CollectionUtils.isNotEmpty(stockCheckIds) && CollectionUtils.isNotEmpty(userIds)) {
			StockCheckExample example = new StockCheckExample();
			StockCheckExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdIn(userIds);
			criteria.andIdIn(stockCheckIds);
			List<StockCheck> list = this.stockCheckMapper.selectByExample(example);
			stockCheckIds = new ArrayList<String>();
			if (CollectionUtils.isNotEmpty(list)) {
				for (StockCheck model : list) {
					stockCheckIds.add(model.getId());
				}
			}
		}else{
			stockCheckIds = new ArrayList<String>();
		}
		
		if (CollectionUtils.isNotEmpty(stockAdjustIds) && CollectionUtils.isNotEmpty(userIds)) {
			StockAdjustExample example = new StockAdjustExample();
			StockAdjustExample.Criteria criteria = example.createCriteria();
			criteria.andUserIdIn(userIds);
			criteria.andIdIn(stockAdjustIds);
			List<StockAdjust> list = this.stockAdjustMapper.selectByExample(example);
			stockAdjustIds = new ArrayList<String>();
			if (CollectionUtils.isNotEmpty(list)) {
				for (StockAdjust model : list) {
					stockAdjustIds.add(model.getId());
				}
			}
		}else{
			stockAdjustIds = new ArrayList<String>();
		}
		
		List<WorkOrderVo> workOrderVoList = new ArrayList<>();
		
		if (CollectionUtils.isNotEmpty(subTaskList)) {
			for (WorkOrderVo vo : subTaskList) {
				if ("order_approve_process".equals(vo.getProcessDefinitionKey()) && CollectionUtils.isNotEmpty(orderIds)) {
					for (int i = 0; i < orderIds.size(); i++) {
						if (orderIds.get(i).equals(vo.getBusinessKey())) {
							workOrderVoList.add(vo);
							orderIds.remove(i);
							break;
						}
					}
				}else if ("order_return_approve_process".equals(vo.getProcessDefinitionKey()) && CollectionUtils.isNotEmpty(returnOrderIds)) {
					for (int i = 0; i < returnOrderIds.size(); i++) {
						if (returnOrderIds.get(i).equals(vo.getBusinessKey())) {
							workOrderVoList.add(vo);
							returnOrderIds.remove(i);
							break;
						}
					}
				}else if ("market_train_approve_process".equals(vo.getProcessDefinitionKey()) && CollectionUtils.isNotEmpty(marketTrainApplyIds)) {
					for (int i = 0; i < marketTrainApplyIds.size(); i++) {
						if (marketTrainApplyIds.get(i).equals(vo.getBusinessKey())) {
							workOrderVoList.add(vo);
							marketTrainApplyIds.remove(i);
							break;
						}
					}
				}else if ("market_design_approve_process".equals(vo.getProcessDefinitionKey()) && CollectionUtils.isNotEmpty(marketDesignApproveIds)) {
					for (int i = 0; i < marketDesignApproveIds.size(); i++) {
						if (marketDesignApproveIds.get(i).equals(vo.getBusinessKey())) {
							workOrderVoList.add(vo);
							marketDesignApproveIds.remove(i);
							break;
						}
					}
				}else if ("promotional_cost_approve_process".equals(vo.getProcessDefinitionKey()) 
						|| "promotional_costs_approve_process".equals(vo.getProcessDefinitionKey())
						&& CollectionUtils.isNotEmpty(promotionalCostIds)) {
					for (int i = 0; i < promotionalCostIds.size(); i++) {
						if (promotionalCostIds.get(i).equals(vo.getBusinessKey())) {
							workOrderVoList.add(vo);
							promotionalCostIds.remove(i);
							break;
						}
					}
				}else if ("stock_check_approve_process".equals(vo.getProcessDefinitionKey()) && CollectionUtils.isNotEmpty(stockCheckIds)) {
					for (int i = 0; i < stockCheckIds.size(); i++) {
						if (stockCheckIds.get(i).equals(vo.getBusinessKey())) {
							workOrderVoList.add(vo);
							stockCheckIds.remove(i);
							break;
						}
					}
				}else if ("stock_adjust_approve_process".equals(vo.getProcessDefinitionKey()) && CollectionUtils.isNotEmpty(stockAdjustIds)) {
					for (int i = 0; i < stockAdjustIds.size(); i++) {
						if (stockAdjustIds.get(i).equals(vo.getBusinessKey())) {
							workOrderVoList.add(vo);
							stockAdjustIds.remove(i);
							break;
						}
					}
				}
			}
		}
		
		PageView<WorkOrderVo> pageView = new PageView<>(pageNo, pageSize);
		pageView.setRowCount(workOrderVoList.size());
		List<WorkOrderVo> list = new ArrayList<>(pageView.getPageSize());
		for(WorkOrderVo vo: workOrderVoList.subList(pageView.getStartRowNo(), pageView.getEndRowNo())){
			list.add(vo);
		}
		pageView.setQueryResult(list);
		return ResponseResult.success(pageView);
	}
	
	public List<String> queryCompanyIds(String userId){
		List<String> companyIds = new ArrayList<String>();
		if(StringUtils.isNotEmpty(userId)){
    		User user = this.userService.queryObjById(userId);
    		if(StringUtils.isNotEmpty(user.getUserArea())){
    			List<UserArea> userAreas = new ArrayList<UserArea>();
    			JSONArray jsonArray = JSONArray.fromObject(user.getUserArea());
    			userAreas = (List<UserArea>) jsonArray.toCollection(jsonArray, UserArea.class);
    			List<String> strings = new ArrayList<>();
    			if (CollectionUtils.isNotEmpty(userAreas)) {
    				for(UserArea values : userAreas){
    					strings.add(values.getId());
    				}
    			}
    			if(strings.size() > 0 ){
    				String areaIds = strings.toString();
    				areaIds = areaIds.substring(1, areaIds.length()-1);
    				
    				CompanyExample paramExample = new CompanyExample();
        			CompanyExample.Criteria companyCriteria = paramExample.createCriteria(); 
        			companyCriteria.andAreaOrId("AREA IN ("+areaIds+") OR CITY IN ("+areaIds+") OR PROVINCE IN ("+areaIds+") OR DISTRICT IN("+areaIds+")");
        			List<Company> companyList = companyService.queryAllObjByExample(paramExample);
        			
        			if (CollectionUtils.isNotEmpty(companyList)) {
        				for(Company company:companyList){
        					companyIds.add(company.getId());
        				}
        				
        			}
    			}
    		}
    	}
		return companyIds;
	}
	
	public List<String> returnUserIds() {
    	List<Integer> ids = new ArrayList<Integer>();
    	List<String> userIds = new ArrayList<String>();
    	List<Integer> bigAreaIds = new ArrayList<Integer>();
    	String userId = SpringSecurityUtils.getLoginUserId();
    	if(StringUtils.isNotEmpty(userId)){
    		User user = this.userService.queryObjById(userId);
    		if(StringUtils.isNotEmpty(user.getUserArea())){
    			List<UserArea> userAreas = new ArrayList<UserArea>();
    			JSONArray jsonArray = JSONArray.fromObject(user.getUserArea());
    			userAreas = (List<UserArea>) jsonArray.toCollection(jsonArray, UserArea.class);
    			for(UserArea values : userAreas){
    				if ("1".equals(values.getId())) {
    					ids.add(370000);
    					ids.add(320000);
    					ids.add(340000);
    					ids.add(360000);
    					ids.add(310000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("2".equals(values.getId())) {
    					ids.add(440000);
    					ids.add(450000);
    					ids.add(460000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("3".equals(values.getId())) {
    					ids.add(420000);
    					ids.add(430000);
    					ids.add(410000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("4".equals(values.getId())) {
    					ids.add(110000);
    					ids.add(120000);
    					ids.add(130000);
    					ids.add(140000);
    					ids.add(150000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("5".equals(values.getId())) {
    					ids.add(640000);
    					ids.add(650000);
    					ids.add(630000);
    					ids.add(610000);
    					ids.add(620000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("6".equals(values.getId())) {
    					ids.add(510000);
    					ids.add(530000);
    					ids.add(520000);
    					ids.add(540000);
    					ids.add(500000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("7".equals(values.getId())) {
    					ids.add(210000);
    					ids.add(220000);
    					ids.add(230000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else if ("9".equals(values.getId())) {
    					ids.add(330000);
    					ids.add(350000);
    					bigAreaIds.add(Integer.parseInt(values.getId()));
    				}else{
    					ids.add(Integer.parseInt(values.getId()));
    				}
    			}
    			List<Integer> regionIds = new ArrayList<Integer>();
    			regionIds.addAll(ids);
    			boolean flag = true;
    			while (flag) {
    				RegionExample example = new RegionExample();
    				RegionExample.Criteria criteria = example.createCriteria();
    				criteria.andParentIdIn(regionIds);
    				List<Region> regionList = regionMapper.selectByExample(example);
    				regionIds = new ArrayList<Integer>();
    				int size = ids.size();
    				if (CollectionUtils.isNotEmpty(regionList)){
    					for (Region region : regionList) {
    						if (!ids.contains(region.getId())) {
    							ids.add(region.getId());
    							regionIds.add(region.getId());
    						}
    					}
    					if (size == ids.size()) {
    						flag = false;
    					}
    				}else {
    					flag = false;
    				}
    			}
    			if (CollectionUtils.isNotEmpty(bigAreaIds)){
    				for (Integer id : bigAreaIds) {
						ids.add(id);
					}
    			}
    			String str = new String();
                if (CollectionUtils.isNotEmpty(ids)){
                	for (Integer id : ids) {
                		str += '"'+"id"+'"' + ":" +'"' +id+ '"'+"|";
                	}
                	if(str.length()>1){
                		str = str.substring(0, str.length()-1);
                    }
                	UserExample userExample = new UserExample();
                	UserExample.Criteria criteria = userExample.createCriteria();
                	criteria.andUserAreaREGEXP(str);
                	List<User> userList = this.userService.queryAllObjByExample(userExample);
                	if (CollectionUtils.isNotEmpty(userList)){
                		for (User model : userList) {
                			userIds.add(model.getId());
                		}
                	}
                }
    		}
    	}
    	return userIds;
    }
}