package com.els.runhe.market.web.controller.train;

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
import com.els.runhe.market.entity.train.MarketTrainApply;
import com.els.runhe.market.entity.train.MarketTrainApplyExample;
import com.els.runhe.market.event.train.MarketTrainApplyEvent;
import com.els.runhe.market.event.train.MarketTrainStatusEnum;
import com.els.runhe.market.service.train.MarketTrainApplyService;
import com.els.runhe.market.utils.GetStatusEnum;
import com.els.runhe.market.utils.MarketTrainSendWxMsgUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="市场培训申请")
@Controller
@RequestMapping("marketTrainApply")
public class MarketTrainApplyController {
    @Resource
    protected MarketTrainApplyService marketTrainApplyService;
    
    @Autowired
    private UserRoleMapper userRoleMapper;

    
    @ApiOperation(httpMethod="POST", value="创建市场培训申请信息")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody MarketTrainApply marketTrainApply) {
    	
    	//赋值  ：用户id、用户名称
    	marketTrainApply.setUserId(SpringSecurityUtils.getLoginUserId());
    	marketTrainApply.setUserName(SpringSecurityUtils.getLoginUserName());
    	
        this.marketTrainApplyService.addObj(marketTrainApply);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑市场培训申请信息")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody MarketTrainApply marketTrainApply) {
        if (marketTrainApply.getId() == null || marketTrainApply.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.marketTrainApplyService.modifyObj(marketTrainApply);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除市场培训申请信息")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.marketTrainApplyService.deleteObjById(id);
        return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="取消市场培训申请")
    @RequestMapping("service/cancleMarketTrain")
    @ResponseBody
    public ResponseResult<String> cancleMarketTrain(@RequestBody List<Integer> id) {
    	if (CollectionUtils.isEmpty(id)) {
            throw new CommonException("选择的申请单行为空！");
        }
    	
    	MarketTrainApplyExample exampleTmp = new MarketTrainApplyExample();
    	exampleTmp.createCriteria().andIdIn(id).andStatusEqualTo(MarketTrainStatusEnum.TO_BE_TRAIN.getCode());
    	if(CollectionUtils.isNotEmpty(this.marketTrainApplyService.queryAllObjByExample(exampleTmp))){
    		throw new CommonException("存在待培训的市场培训申请，无法取消");
    	}
    	
    	MarketTrainApplyExample example = new MarketTrainApplyExample();
    	example.createCriteria().andIdIn(id);
    	MarketTrainApply record= new MarketTrainApply();
    	record.setStatus(MarketTrainStatusEnum.CANCLE.getCode());
    	this.marketTrainApplyService.modifyObjByExample(record, example);
    	
    	List<MarketTrainApply> marketTrainList =this.marketTrainApplyService.queryAllObjByExample(example);
    	MarketTrainSendWxMsgUtils.sendMsg(MarketTrainStatusEnum.CANCLE, marketTrainList);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询市场培训申请信息")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 MarketTrainApply", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<MarketTrainApply>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        MarketTrainApplyExample example = new MarketTrainApplyExample();
        example.setPageView(new PageView<MarketTrainApply>(pageNo, pageSize));
        
        if (wapper != null) {
            MarketTrainApplyExample.Criteria criteria = example.createCriteria();
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
    				return ResponseResult.success(new PageView<MarketTrainApply>(pageNo, pageSize));
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
    			}else if (rolesList.get(0).getRoleCode().equals("sales_director")) { // 大区销售总监
    				statusList.add(1);
    				statusList.add(2);
    				statusList.add(3);
    				criteria.andStatusIn(statusList);
    			}else if (rolesList.get(0).getRoleCode().equals("trainer")) { // 培训主管
    				statusList.add(2);
    				statusList.add(3);
    				criteria.andStatusIn(statusList);
    			}else {
    				criteria.andStatusNotEqualTo(5);
    			}
    		}
        }
        example.setOrderByClause("id DESC");
        PageView<MarketTrainApply> pageData = this.marketTrainApplyService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(httpMethod="POST", value="市场培训")
    @RequestMapping("service/marketTraining")
    @ResponseBody
    public ResponseResult<String> marketTraining(@RequestBody MarketTrainApply marketTrainApply){
//    	if(CollectionUtils.isEmpty(trainApplyId)){
//    		throw new CommonException("选择的申请单为空！");
//    	}
    	
    	MarketTrainApplyExample example = new MarketTrainApplyExample();
    	example.createCriteria().andTrainApplyIdEqualTo(marketTrainApply.getTrainApplyId());
    	
    	//判断所选参数的状态
    	List<MarketTrainApply> trainApplyList =this.marketTrainApplyService.queryAllObjByExample(example);
    	for(MarketTrainApply record: trainApplyList){
    		if(record.getStatus() != MarketTrainStatusEnum.TO_BE_TRAIN.getCode()){
    			String message = new GetStatusEnum().getTrainStatus(record.getStatus());
    			throw new CommonException("只有待培训的申请单可以进行培训，选择行中存在"+message+"的申请单，不可进行培训");
    		}
    	}
    	
    	MarketTrainApply marketTrain = new MarketTrainApply();
    	marketTrain.setStatus(MarketTrainStatusEnum.HAS_BEEN_TRAIN.getCode());
    	marketTrain.setExt1(marketTrainApply.getExt1()); // 批注
    	this.marketTrainApplyService.modifyObjByExample(marketTrain, example);
    	
    	return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="市场培训验收")
    @RequestMapping("service/marketTrainAcceptance")
    @ResponseBody
    public ResponseResult<String> marketTrainAcceptance(@RequestBody List<String> trainApplyId){
    	if(CollectionUtils.isEmpty(trainApplyId)){
    		throw new CommonException("选择的申请单为空！");
    	}
    	
    	MarketTrainApplyExample example = new MarketTrainApplyExample();
    	example.createCriteria().andTrainApplyIdIn(trainApplyId);
    	
    	//判断所选参数的状态
    	List<MarketTrainApply> trainApplyList =this.marketTrainApplyService.queryAllObjByExample(example);
    	for(MarketTrainApply record: trainApplyList){
    		if(record.getStatus() != MarketTrainStatusEnum.HAS_BEEN_TRAIN.getCode()){
    			String message = new GetStatusEnum().getTrainStatus(record.getStatus());
    			throw new CommonException("只有已培训的申请单可以进行验收，选择行中存在"+message+"的申请单，不可进行验收");
    		}
    	}
    	
    	MarketTrainApply marketTrainApply = new MarketTrainApply();
    	marketTrainApply.setStatus(MarketTrainStatusEnum.UN_FINISHED.getCode());
    	this.marketTrainApplyService.modifyObjByExample(marketTrainApply, example);
    	
    	return ResponseResult.success();
    }
    
    
    @ApiOperation(httpMethod="POST", value="市场培训申请提交审批")
    @RequestMapping("service/submitApproval")
    @ResponseBody
    public ResponseResult<String> submitApproval(@RequestBody MarketTrainApply marketTrainApply){
    	if(StringUtils.isEmpty(marketTrainApply.getTrainApplyId())){
    		//赋值  ：用户id、用户名称
    		marketTrainApply.setUserId(SpringSecurityUtils.getLoginUserId());
    		marketTrainApply.setUserName(SpringSecurityUtils.getLoginUserName());
        	
            this.marketTrainApplyService.addObj(marketTrainApply);
    	}else{
    		this.marketTrainApplyService.modifyObj(marketTrainApply);
    	}
    	
    	MarketTrainApply record = this.marketTrainApplyService.queryByTrainApplyId(marketTrainApply.getTrainApplyId());
    	//判断参数申请单状态,新增则发起审批
    	if(record.getStatus().equals(MarketTrainStatusEnum.UN_ADD.getCode())){
    		SpringContextHolder.getApplicationContext().publishEvent(new MarketTrainApplyEvent(record));
    	}else{
    		throw new CommonException("该申请单已提交审批！");
    	}
    	return ResponseResult.success();
    }
}