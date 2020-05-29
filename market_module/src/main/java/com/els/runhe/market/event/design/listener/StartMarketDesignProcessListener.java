package com.els.runhe.market.event.design.listener;

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
import com.els.runhe.market.entity.design.MarketDesignApply;
import com.els.runhe.market.event.design.MarketDesignApplyEvent;
import com.els.runhe.market.event.design.MarketDesignStatusEnum;
import com.els.runhe.market.service.design.MarketDesignApplyService;

@Component("startMarketDesignProcessListener")
public class StartMarketDesignProcessListener implements ApplicationListener<MarketDesignApplyEvent>{

	private static final Logger logger = LoggerFactory.getLogger(StartMarketDesignProcessListener.class);
	public static final String MARKET_DESIGN_PROCESS_KEY = "market_design_approve_process";
	
	@Resource
	protected WorkFlowService workFlowService;
	
	@Resource
	protected MarketDesignApplyService marketDesignApplyService;
	@Override
	public void onApplicationEvent(MarketDesignApplyEvent event) {
		MarketDesignApply marketDesignApply = (MarketDesignApply) event.getSource();
		
		Map<String, Object> processMap = new HashMap<>();
		processMap.put(ProcessVariableNameEnum.START_USER.getVarName(), marketDesignApply.getUserName());
		processMap.put(ProcessVariableNameEnum.BUSINESS_ID.getVarName(), marketDesignApply.getId());
//		processMap.put(ProcessVariableNameEnum.COMPANY_NAME.getVarName(), marketDesignApply.());
		processMap.put(ProcessVariableNameEnum.TITLE.getVarName(), "市场平面设计申请审批流程");
		//设计申请信息id
		processMap.put("designApplyId", marketDesignApply.getDesignApplyId());
		//修改申请单状态
		marketDesignApply.setStatus(MarketDesignStatusEnum.UN_CONFIRM.getCode());
		marketDesignApply.setUpdateTime(new Date());
		
		this.workFlowService.startProcess(MARKET_DESIGN_PROCESS_KEY, marketDesignApply.getDesignApplyId(), processMap);
		
		this.marketDesignApplyService.modifyObj(marketDesignApply);
		logger.info("市场平面设计申请成功开启审批流程");
	}
	
}
