package com.els.runhe.market.event.promotional.listener;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.core.exception.CommonException;
import com.els.base.workflow.common.event.TaskOperateEvent;
import com.els.base.workflow.common.utils.ApproveStatusEnum;
import com.els.runhe.market.entity.promotional.PromotionalCostApply;
import com.els.runhe.market.event.promotional.PromotionalApproveStatus;
import com.els.runhe.market.event.promotional.PromotionalCostStatusEnum;
import com.els.runhe.market.service.promotional.PromotionalCostApplyService;

@Component
public class CompletePromotionalCostListener implements ApplicationListener<TaskOperateEvent>{

	private static final Logger logger = LoggerFactory.getLogger(CompletePromotionalCostListener.class);
	
	@Resource
	protected PromotionalCostApplyService promotionalCostApplyService;
	
	@Override
	public void onApplicationEvent(TaskOperateEvent event) {
		String processKey = event.getProcessDefinitionKey();
		if(!StartPromotionalCostProcessListener.PROMOTIONAL_COST_PROCESS_KEY.equals(processKey)){
			return;
		}
		
		String promotionalCostNo = (String) event.getCurrentProcess().getProcessVariables().get("promotionalCostNo");
		if(StringUtils.isBlank(promotionalCostNo)){
			throw new CommonException("流程执行失败，流程中的申请编号promotionalCostNo的参数为空！");
		}
		
		PromotionalCostApply temp = this.promotionalCostApplyService.queryByPromotionalCostNo(promotionalCostNo);
		
		if (event.isPass()) {
			// 审批通过,申请单审批未完成
			if (!event.isFinished()) {
				if (temp.getApprovalStatus().equals(PromotionalApproveStatus.UN_PASS.getCode())) { // 待审批
					// 大区经理审批通过
					temp.setApprovalStatus(PromotionalApproveStatus.DIRECTOR_PASS.getCode());
				} else if (temp.getApprovalStatus().equals(PromotionalApproveStatus.DIRECTOR_PASS.getCode())) { // 大区经理审批通过
					// 渠道主管审批通过,计划费用审批完成,申请单状态变为待结案
					temp.setApprovalStatus(PromotionalApproveStatus.CHANNEL_PASS.getCode());
					temp.setStatus(PromotionalCostStatusEnum.TO_BE_DESIGNED.getCode());	
				} else if (temp.getApprovalStatus().equals(PromotionalApproveStatus.CHANNEL_PASS.getCode())
						|| temp.getApprovalStatus().equals(PromotionalApproveStatus.DIRECTOR_END_UNPASS.getCode())
						|| temp.getApprovalStatus().equals(PromotionalApproveStatus.REJECT.getCode())) { 
					// 渠道主管审批通过、大区经理结案审批不通过、渠道主管结案审批不通过退回大区经理审批
					// 大区经理结案审批通过
					temp.setApprovalStatus(PromotionalApproveStatus.DIRECTOR_END_PASS.getCode());
				}
			}else {
				// 申请单审批结束，渠道主管结案审批通过,申请单状态变为结案完成
				temp.setApprovalStatus(PromotionalApproveStatus.VP_PASS.getCode());
				temp.setStatus(PromotionalCostStatusEnum.UN_FINISHED.getCode());	
			}
		}else { //审批不通过
			if (temp.getApprovalStatus().equals(PromotionalApproveStatus.UN_PASS.getCode())) {
				// 大区经理审批不通过
				temp.setApprovalStatus(PromotionalApproveStatus.DIRECTOR_UNPASS.getCode());
			}else if (temp.getApprovalStatus().equals(PromotionalApproveStatus.DIRECTOR_PASS.getCode())) {
				// 渠道主管审批不通过
				temp.setApprovalStatus(PromotionalApproveStatus.CHANNEL_UNPASS.getCode());
			}else if (temp.getApprovalStatus().equals(PromotionalApproveStatus.CHANNEL_PASS.getCode())
					|| temp.getApprovalStatus().equals(PromotionalApproveStatus.DIRECTOR_END_UNPASS.getCode())
					|| temp.getApprovalStatus().equals(PromotionalApproveStatus.REJECT.getCode())) {
				// 大区经理结案审批不通过：退回区域经理修改，重新提交结案
				temp.setApprovalStatus(PromotionalApproveStatus.DIRECTOR_END_UNPASS.getCode());
				temp.setStatus(PromotionalCostStatusEnum.TO_BE_DESIGNED.getCode());
			}else if (temp.getApprovalStatus().equals(PromotionalApproveStatus.DIRECTOR_END_PASS.getCode())) {
				// 渠道主管结案审批不通过：退回大区经理审批
				temp.setApprovalStatus(PromotionalApproveStatus.REJECT.getCode());
			}
		}
		
		promotionalCostApplyService.modifyObj(temp);
		logger.info("促销活动费用申请审批通过，更改状态为通过[{}]", temp.getApprovalStatus());
		
	}

}
