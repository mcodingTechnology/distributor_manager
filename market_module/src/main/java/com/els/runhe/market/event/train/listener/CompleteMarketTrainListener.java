package com.els.runhe.market.event.train.listener;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.core.exception.CommonException;
import com.els.base.workflow.common.event.TaskOperateEvent;
import com.els.base.workflow.common.utils.ApproveStatusEnum;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.market.entity.train.MarketTrainApply;
import com.els.runhe.market.event.train.MarketTrainStatusEnum;
import com.els.runhe.market.service.train.MarketTrainApplyService;

@Component
public class CompleteMarketTrainListener implements ApplicationListener<TaskOperateEvent>{

	private static final Logger logger = LoggerFactory.getLogger(CompleteMarketTrainListener.class);
	
	@Resource
	protected MarketTrainApplyService marketTrainApplyService;
	
	@Override
	public void onApplicationEvent(TaskOperateEvent event) {
		String processKey = event.getProcessDefinitionKey();
		if(!StartMarketTrainProcessListener.MARKET_TRAIN_PROCESS_KEY.equals(processKey)){
			return;
		}
		
		if(!event.isFinished()){
			return;
		}
		
		Integer id = (Integer)event.getCurrentProcess().getProcessVariables().get(ProcessVariableNameEnum.BUSINESS_ID.getVarName());
		
		if(StringUtils.isBlank(id.toString())){
			throw new CommonException("流程执行失败，流程中的designApplyId的参数为空！");
		}
		MarketTrainApply temp = this.marketTrainApplyService.queryObjById(id);

		if (event.isPass()) {
			temp.setApprovalStatus(ApproveStatusEnum.PASS.getValue());
			temp.setStatus(MarketTrainStatusEnum.TO_BE_TRAIN.getCode());
		}else {
			temp.setApprovalStatus(ApproveStatusEnum.REJECT.getValue());
			//temp.setStatus(MarketTrainStatusEnum.UN_ADD.getCode());
		}
		
		marketTrainApplyService.modifyObj(temp);
		logger.info("市场培训申请审批通过，更改状态为通过[{}]", ApproveStatusEnum.PASS.getValue());
		
		
	}
}
