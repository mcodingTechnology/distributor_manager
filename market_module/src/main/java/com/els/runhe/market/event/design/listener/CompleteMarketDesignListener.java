package com.els.runhe.market.event.design.listener;

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
import com.els.runhe.market.entity.design.MarketDesignApply;
import com.els.runhe.market.event.design.MarketDesignStatusEnum;
import com.els.runhe.market.service.design.MarketDesignApplyService;

@Component
public class CompleteMarketDesignListener implements ApplicationListener<TaskOperateEvent>{

	private static final Logger logger = LoggerFactory.getLogger(CompleteMarketDesignListener.class);
	
	@Resource
	protected MarketDesignApplyService marketDesignApplyService;
	
	@Override
	public void onApplicationEvent(TaskOperateEvent event) {
		String processKey = event.getProcessDefinitionKey();
		if(!StartMarketDesignProcessListener.MARKET_DESIGN_PROCESS_KEY.equals(processKey)){
			return;
		}
		
		if(!event.isFinished()){
			return;
		}
		
		String designApplyId = (String)event.getCurrentProcess().getProcessVariables().get("designApplyId");
		Integer id = (Integer)event.getCurrentProcess().getProcessVariables().get(ProcessVariableNameEnum.BUSINESS_ID.getVarName());
		
		if(StringUtils.isBlank(designApplyId)){
			throw new CommonException("流程执行失败，流程中的designApplyId的参数为空！");
		}
		
		MarketDesignApply temp = this.marketDesignApplyService.queryObjById(id);

		if (event.isPass()) {
			temp.setApprovalStatus(ApproveStatusEnum.PASS.getValue());
			temp.setStatus(MarketDesignStatusEnum.TO_BE_DESIGNED.getCode());
		}else {
			temp.setApprovalStatus(ApproveStatusEnum.REJECT.getValue());
			//temp.setStatus(MarketDesignStatusEnum.UN_ADD.getCode());
		}
		
		marketDesignApplyService.modifyObj(temp);
		logger.info("市场平面设计申请审批通过，更改状态为通过[{}]", ApproveStatusEnum.PASS.getValue());
		
		
	}
}
