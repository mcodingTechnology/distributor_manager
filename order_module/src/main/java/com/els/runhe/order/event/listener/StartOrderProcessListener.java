package com.els.runhe.order.event.listener;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

import com.els.base.workflow.common.service.WorkFlowService;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.event.OrderSubmitEvent;
import com.els.runhe.order.utils.OrderConstants;

//@Component("startOrderProcessListener")
public class StartOrderProcessListener implements ApplicationListener<OrderSubmitEvent> {
	
	private static final Logger logger = LoggerFactory.getLogger(StartOrderProcessListener.class);

//	@Resource
//	protected ActivitiService activitiService;
	
	@Resource
	protected WorkFlowService workFlowService;
	
	@Override
	public void onApplicationEvent(OrderSubmitEvent event) {
		Order order = (Order) event.getSource();

		Map<String, Object> processMap = new HashMap<>();
		processMap.put(ProcessVariableNameEnum.START_USER.getVarName(), order.getUserName());
		processMap.put(ProcessVariableNameEnum.BUSINESS_ID.getVarName(), order.getId());
		processMap.put(ProcessVariableNameEnum.COMPANY_NAME.getVarName(), order.getPurCompanyName());
		processMap.put(ProcessVariableNameEnum.TITLE.getVarName(), "订单审批流程");
		
		this.workFlowService.startProcess(OrderConstants.ORDER_PROCESS_KEY, order.getOrderNo(), processMap);
		logger.info("订单成功开启审批流程");
	}
	

}
