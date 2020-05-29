package com.els.runhe.market.event.train.listener;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.workflow.common.service.WorkFlowService;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.market.entity.train.MarketTrainApply;
import com.els.runhe.market.event.train.MarketTrainApplyEvent;
import com.els.runhe.market.event.train.MarketTrainStatusEnum;
import com.els.runhe.market.service.train.MarketTrainApplyService;

@Component("startMarketTrainProcessListener")
public class StartMarketTrainProcessListener implements ApplicationListener<MarketTrainApplyEvent>{

	private static final Logger logger = LoggerFactory.getLogger(StartMarketTrainProcessListener.class);
	public static final String MARKET_TRAIN_PROCESS_KEY = "market_train_approve_process";
	
	@Resource
	protected WorkFlowService workFlowService;
	
	@Resource
	protected MarketTrainApplyService marketTrainApplyService;
	
	@Override
	public void onApplicationEvent(MarketTrainApplyEvent event) {
		MarketTrainApply marketTrainApply = (MarketTrainApply) event.getSource();
		
		Map<String, Object> processMap = new HashMap<>();
		processMap.put(ProcessVariableNameEnum.START_USER.getVarName(), marketTrainApply.getUserName());
		processMap.put(ProcessVariableNameEnum.BUSINESS_ID.getVarName(), marketTrainApply.getId());
//		processMap.put(ProcessVariableNameEnum.COMPANY_NAME.getVarName(), marketDesignApply.());
		processMap.put(ProcessVariableNameEnum.TITLE.getVarName(), "市场培训申请审批流程");
		//提交审批，修改申请单状态
		marketTrainApply.setStatus(MarketTrainStatusEnum.UN_CONFIRM.getCode());
		marketTrainApply.setUpdateTime(new Date()); //提交审批时间
		
		this.workFlowService.startProcess(MARKET_TRAIN_PROCESS_KEY, marketTrainApply.getTrainApplyId(), processMap);
		
		this.marketTrainApplyService.modifyObj(marketTrainApply);
		logger.info("市场培训申请成功开启审批流程");
	}

}
