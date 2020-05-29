package com.els.runhe.order.ruleengine.command;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.els.base.utils.SpringContextHolder;
import com.els.base.workflow.common.service.WorkFlowService;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.state.OrderStateCheckable;
import com.els.runhe.order.utils.OrderConstants;

/**
 * 开启订单审核流程的命令
 * @author hzy
 *
 */
public class StartApprovalCommand implements OrderStateCheckable {
	
	private static final Logger logger = LoggerFactory.getLogger(StartApprovalCommand.class);
	protected static WorkFlowService workFlowService = SpringContextHolder.getOneBean(WorkFlowService.class);
	private Order order;

	public StartApprovalCommand(Order order) {
		this.order = order;
	}

	@Override
	public void execute(OrderRuleEngine context) {
		
		Map<String, Object> processMap = new HashMap<>();
		processMap.put(ProcessVariableNameEnum.START_USER.getVarName(), order.getUserName());
		processMap.put(ProcessVariableNameEnum.BUSINESS_ID.getVarName(), order.getId());
		processMap.put(ProcessVariableNameEnum.COMPANY_NAME.getVarName(), order.getPurCompanyName());
		processMap.put(ProcessVariableNameEnum.TITLE.getVarName(), "订单审批流程");
		
		workFlowService.startProcess(OrderConstants.ORDER_PROCESS_KEY, order.getOrderNo(), processMap);
		logger.info("订单[{}]成功开启审批流程", order.getOrderNo());
	}

	@Override
	public Order getOrder() {
		return this.order;
	}

}
