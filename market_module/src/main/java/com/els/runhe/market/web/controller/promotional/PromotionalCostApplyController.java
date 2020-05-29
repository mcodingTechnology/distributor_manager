package com.els.runhe.market.web.controller.promotional;

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
import com.els.runhe.market.entity.promotional.PromotionalCostApply;
import com.els.runhe.market.entity.promotional.PromotionalCostApplyExample;
import com.els.runhe.market.entity.promotional.PromotionalCostProject;
import com.els.runhe.market.event.promotional.PromotionalCostApplyEvent;
import com.els.runhe.market.event.promotional.PromotionalCostStatusEnum;
import com.els.runhe.market.service.promotional.PromotionalCostApplyService;
import com.els.runhe.market.service.train.MarketTrainApplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="促销活动费用申请表")
@Controller
@RequestMapping("promotionalCostApply")
public class PromotionalCostApplyController {
    @Resource
    protected PromotionalCostApplyService promotionalCostApplyService;
    
    @Resource
    protected MarketTrainApplyService marketTrainApplyService;
    
    @Autowired
    private UserRoleMapper userRoleMapper;

    @ApiOperation(httpMethod="POST", value="创建促销活动费用申请表")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody PromotionalCostApply promotionalCostApply) {
        this.promotionalCostApplyService.addObj(promotionalCostApply);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑促销活动费用申请表")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody PromotionalCostApply promotionalCostApply) {
        if (promotionalCostApply.getId() == null || promotionalCostApply.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.promotionalCostApplyService.modifyObj(promotionalCostApply);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除促销活动费用申请表")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.promotionalCostApplyService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询促销活动费用申请表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 PromotionalCostApply", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<PromotionalCostApply>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        PromotionalCostApplyExample example = new PromotionalCostApplyExample();
        example.setPageView(new PageView<PromotionalCostApply>(pageNo, pageSize));
        
        if (wapper != null) {
            PromotionalCostApplyExample.Criteria criteria = example.createCriteria();
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
    				return ResponseResult.success(new PageView<PromotionalCostApply>(pageNo, pageSize));
    			}
    		}
    		
    		// 根据状态判断相应角色可以看到的申请单
    		List<Role> rolesList = SpringSecurityUtils.getLoginUserRoleList();
    		List<Integer> statusList = new ArrayList<>();
    		List<Integer> approvalStatusList = new ArrayList<>(); // 审批状态
     		if (CollectionUtils.isNotEmpty(rolesList) && rolesList.size() == 1) {
    			if (rolesList.get(0).getRoleCode().equals("sales_manager")) { // 区域销售经理
    				statusList.add(0);
    				statusList.add(1);
    				statusList.add(2);
    				statusList.add(3);
    				statusList.add(4);
    				criteria.andStatusIn(statusList);
    			}else if (rolesList.get(0).getRoleCode().equals("sales_director")) { // 大区销售总监
    				statusList.add(1);
    				statusList.add(2);
    				statusList.add(3);
    				statusList.add(4);
    				criteria.andStatusIn(statusList);
    			}else if (rolesList.get(0).getRoleCode().equals("channel_supervisor")) { // 渠道主管
    				statusList.add(1);
    				statusList.add(2);
    				statusList.add(3);
    				statusList.add(4);
    				approvalStatusList.add(150);
    				approvalStatusList.add(170);
    				approvalStatusList.add(175);
    				approvalStatusList.add(180);
    				approvalStatusList.add(185);
    				approvalStatusList.add(200);
    				approvalStatusList.add(300);
    				criteria.andStatusIn(statusList);
    				criteria.andApprovalStatusIn(approvalStatusList);
    			}else if (rolesList.get(0).getRoleCode().equals("financial") || 
    					rolesList.get(0).getRoleCode().equals("financial_account") || 
    					rolesList.get(0).getRoleCode().equals("business") || 
    					rolesList.get(0).getRoleCode().equals("business_manager") || 
    					rolesList.get(0).getRoleCode().equals("marketing vp")) { // 财务人员，营运人员，营销主管
    				statusList.add(2);
    				statusList.add(3);
    				statusList.add(4);
    				approvalStatusList.add(170);
    				approvalStatusList.add(180);
    				approvalStatusList.add(185);
    				approvalStatusList.add(200);
    				approvalStatusList.add(300);
    				criteria.andStatusIn(statusList);
    				criteria.andApprovalStatusIn(approvalStatusList);
    			}else {
    				criteria.andStatusNotEqualTo(5);
    			}
    		}
        }
        example.setOrderByClause("id DESC");
        PageView<PromotionalCostApply> pageData = this.promotionalCostApplyService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(httpMethod="POST", value="促销活动费用申请提交审批")
    @RequestMapping("service/submitApproval")
    @ResponseBody
    public ResponseResult<String> submitApproval(@RequestBody PromotionalCostApply promotionalCostApply){
    	boolean flag = false;
    	if(StringUtils.isEmpty(promotionalCostApply.getPromotionalCostNo())){
    		//赋值  ：用户id、用户名称
    		promotionalCostApply.setUserId(SpringSecurityUtils.getLoginUserId());
    		promotionalCostApply.setUserName(SpringSecurityUtils.getLoginUserName());
        	
            this.promotionalCostApplyService.addObj(promotionalCostApply);
    	}else{
    		for(PromotionalCostProject project:promotionalCostApply.getCostProjectList()){
        		if(project.getType().equals("actual")){
        			flag = true;
        			break;
        		}
        	}
    		if(flag){
        		//结案时修改状态
        		promotionalCostApply.setStatus(PromotionalCostStatusEnum.HAS_BEEN_DESIGNED.getCode());
        	}
    		this.promotionalCostApplyService.modifyObj(promotionalCostApply);
    	}
    	if (!flag) {
    		PromotionalCostApply record = this.promotionalCostApplyService.queryByPromotionalCostNo(promotionalCostApply.getPromotionalCostNo());
        	//判断参数申请单状态,新增则发起审批
        	if(record.getStatus().equals(PromotionalCostStatusEnum.UN_ADD.getCode())){
        		SpringContextHolder.getApplicationContext().publishEvent(new PromotionalCostApplyEvent(record));
        	}else{
        		throw new CommonException("该申请单已提交审批！");
        	}
    	}
    	
    	return ResponseResult.success();
    }
}