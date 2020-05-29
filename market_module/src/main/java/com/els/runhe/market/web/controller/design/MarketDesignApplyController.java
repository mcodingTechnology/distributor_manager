package com.els.runhe.market.web.controller.design;

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
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.market.entity.design.MarketDesignApply;
import com.els.runhe.market.entity.design.MarketDesignApplyExample;
import com.els.runhe.market.event.design.MarketDesignApplyEvent;
import com.els.runhe.market.event.design.MarketDesignStatusEnum;
import com.els.runhe.market.service.design.MarketDesignApplyService;
import com.els.runhe.market.service.train.MarketTrainApplyService;
import com.els.runhe.market.utils.GetStatusEnum;
import com.els.runhe.market.utils.MarketDesignSendWxMsgUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="市场平面设计申请")
@Controller
@RequestMapping("marketDesignApply")
public class MarketDesignApplyController {
    @Resource
    protected MarketDesignApplyService marketDesignApplyService;
    
    @Resource
    protected MarketTrainApplyService marketTrainApplyService;
    
    @Autowired
    private UserRoleMapper userRoleMapper;

    @ApiOperation(httpMethod="POST", value="创建平面设计申请")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody MarketDesignApply marketDesignApply) {
    	
    	//赋值  ：用户id、用户名称
    	marketDesignApply.setUserId(SpringSecurityUtils.getLoginUserId());
    	marketDesignApply.setUserName(SpringSecurityUtils.getLoginUserName());
    	
        this.marketDesignApplyService.addObj(marketDesignApply);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑平面设计申请")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody MarketDesignApply marketDesignApply) {
        if (marketDesignApply.getId() == null || marketDesignApply.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.marketDesignApplyService.modifyObj(marketDesignApply);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除平面设计申请")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.marketDesignApplyService.deleteObjById(id);
        return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="取消平面设计申请")
    @RequestMapping("service/cancleMarketDesign")
    @ResponseBody
    public ResponseResult<String> cancleMarketDesign(@RequestBody List<String> designApplyId) {
    	if (CollectionUtils.isEmpty(designApplyId)) {
            throw new CommonException("选择的申请单行为空！");
        }
    	
    	MarketDesignApplyExample exampleTmp = new MarketDesignApplyExample();
    	exampleTmp.createCriteria().andDesignApplyIdIn(designApplyId).andStatusEqualTo(MarketDesignStatusEnum.TO_BE_DESIGNED.getCode());
    	if(CollectionUtils.isNotEmpty(this.marketDesignApplyService.queryAllObjByExample(exampleTmp))){
    		throw new CommonException("存在待设计的市场平面设计申请，无法取消");
    	}
    	
    	MarketDesignApplyExample example = new MarketDesignApplyExample();
    	example.createCriteria().andDesignApplyIdIn(designApplyId);
    	MarketDesignApply record= new MarketDesignApply();
    	record.setStatus(MarketDesignStatusEnum.CANCLE.getCode());
    	this.marketDesignApplyService.modifyObjByExample(record, example);
    	
    	List<MarketDesignApply> marketDesignList =this.marketDesignApplyService.queryAllObjByExample(example);
    	MarketDesignSendWxMsgUtils.sendMsg(MarketDesignStatusEnum.CANCLE, marketDesignList);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询平面设计申请")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 MarketDesignApply", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<MarketDesignApply>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        MarketDesignApplyExample example = new MarketDesignApplyExample();
        example.setPageView(new PageView<MarketDesignApply>(pageNo, pageSize));
        
        if (wapper != null) {
            MarketDesignApplyExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
            // 如果是大区经理只看到自己的数据，大区经理可以看到自己管理的所有区域经理的申请信息。
            UserRoleExample userRoleExample = new UserRoleExample();
            userRoleExample.createCriteria().andUserIdEqualTo(SpringSecurityUtils.getLoginUserId());
            List<UserRole> roleList = userRoleMapper.selectByExample(userRoleExample);
            String userId = null;
    		if (CollectionUtils.isNotEmpty(roleList) && roleList.size() == 1) {
    			if (roleList.get(0).getRoleId().equals("20180108095402-59e16359b5fd43909")) {
    				userId = SpringSecurityUtils.getLoginUserId();
    			}
    		}
    		if (StringUtils.isNotEmpty(userId)) {
    			criteria.andUserIdEqualTo(userId);
    		} else {
    			List<String> ids = this.marketTrainApplyService.returnAreaList();
    			if (CollectionUtils.isNotEmpty(ids)) {
    				criteria.andUserIdIn(ids);
    			}else{
    				return ResponseResult.success(new PageView<MarketDesignApply>(pageNo, pageSize));
    			}
    		}
    		// 根据状态判断相应角色可以看到的申请单
    		List<Role> rolesList = SpringSecurityUtils.getLoginUserRoleList();
    		List<Integer> statusList = new ArrayList<>();
     		if (CollectionUtils.isNotEmpty(rolesList) && rolesList.size() == 1) {
    			if (rolesList.get(0).getRoleCode().equals("sales_manager")) { // 区域销售经理
    				statusList.add(0);
    				statusList.add(1);
    				statusList.add(2);
    				statusList.add(3);
    				criteria.andStatusIn(statusList);
    			}else if (rolesList.get(0).getRoleCode().equals("designer")) { // 企划主管
    				statusList.add(1);
    				statusList.add(2);
    				statusList.add(3);
    				criteria.andStatusIn(statusList);
    			}else if (rolesList.get(0).getRoleCode().equals("graphic_designer")) { // 设计师
    				statusList.add(2);
    				statusList.add(3);
    				criteria.andStatusIn(statusList);
    			}else {
    				criteria.andStatusNotEqualTo(5);
    			}
    		}
        }
        example.setOrderByClause("id DESC");
        PageView<MarketDesignApply> pageData = this.marketDesignApplyService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(httpMethod="POST", value="市场设计")
    @RequestMapping("service/marketDesigning")
    @ResponseBody
    public ResponseResult<String> marketDesigning(@RequestBody MarketDesignApply marketDesignApply){
//    	if(CollectionUtils.isEmpty(designApplyId)){
//    		throw new CommonException("选择的申请单为空！");
//    	}
    	
    	MarketDesignApplyExample example = new MarketDesignApplyExample();
    	example.createCriteria().andDesignApplyIdEqualTo(marketDesignApply.getDesignApplyId());
    	
    	//判断所选参数的状态
    	List<MarketDesignApply> designApplyList =this.marketDesignApplyService.queryAllObjByExample(example);
    	for(MarketDesignApply record: designApplyList){
    		if(record.getStatus() != MarketDesignStatusEnum.TO_BE_DESIGNED.getCode()){
    			String message = new GetStatusEnum().getTrainStatus(record.getStatus());
    			throw new CommonException("只有待设计的申请单可以进行设计，选择行中存在"+message+"的申请单，不可进行设计");
    		}
    	}
    	
    	MarketDesignApply marketDesign = new MarketDesignApply();
    	marketDesign.setStatus(MarketDesignStatusEnum.HAS_BEEN_DESIGNED.getCode());
    	marketDesign.setExt1(marketDesignApply.getExt1()); // 批注
        marketDesign.setExpectCompleteTime(marketDesignApply.getExpectCompleteTime()); // 预计完成时间
    	this.marketDesignApplyService.modifyObjByExample(marketDesign, example);
    	
    	return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="市场设计验收")
    @RequestMapping("service/marketDesignAcceptance")
    @ResponseBody
    public ResponseResult<String> marketDesignAcceptance(@RequestBody List<String> designApplyId){
    	if(CollectionUtils.isEmpty(designApplyId)){
    		throw new CommonException("选择的申请单为空！");
    	}
    	
    	MarketDesignApplyExample example = new MarketDesignApplyExample();
    	example.createCriteria().andDesignApplyIdIn(designApplyId);
    	
    	//判断所选参数的状态
    	List<MarketDesignApply> designApplyList =this.marketDesignApplyService.queryAllObjByExample(example);
    	for(MarketDesignApply record: designApplyList){
    		if(record.getStatus() != MarketDesignStatusEnum.HAS_BEEN_DESIGNED.getCode()){
    			String message = new GetStatusEnum().getTrainStatus(record.getStatus());
    			throw new CommonException("只有已设计的申请单可以进行设计，选择行中存在"+message+"的申请单，不可进行已设计");
    		}
    	}
    	
    	MarketDesignApply marketDesignApply = new MarketDesignApply();
    	marketDesignApply.setStatus(MarketDesignStatusEnum.UN_FINISHED.getCode());
    	this.marketDesignApplyService.modifyObjByExample(marketDesignApply, example);
    	
    	return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="市场平面设计申请提交审批")
    @RequestMapping("service/submitApproval")
    @ResponseBody
    public ResponseResult<String> submitApproval(@RequestBody MarketDesignApply marketDesignApply){
    	if(StringUtils.isEmpty(marketDesignApply.getDesignApplyId())){
    		//赋值  ：用户id、用户名称
        	marketDesignApply.setUserId(SpringSecurityUtils.getLoginUserId());
        	marketDesignApply.setUserName(SpringSecurityUtils.getLoginUserName());
        	
            this.marketDesignApplyService.addObj(marketDesignApply);
    	}else{
    		this.marketDesignApplyService.modifyObj(marketDesignApply);
    	}
    	
    	MarketDesignApply record = this.marketDesignApplyService.queryByDesignApplyId(marketDesignApply.getDesignApplyId());
    	//判断参数申请单状态,新增则发起审批
    	if(record.getStatus().equals(MarketDesignStatusEnum.UN_ADD.getCode())){
    		SpringContextHolder.getApplicationContext().publishEvent(new MarketDesignApplyEvent(record));
    	}else{
    		throw new CommonException("该申请单已提交审批！");
    	}
    	
    	return ResponseResult.success();
    }
}