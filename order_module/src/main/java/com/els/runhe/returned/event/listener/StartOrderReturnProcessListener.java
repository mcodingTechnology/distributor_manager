package com.els.runhe.returned.event.listener;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.workflow.common.service.WorkFlowService;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.returned.entity.OrderReturn;
import com.els.runhe.returned.event.OrderReturnCreatedEvent;
import com.els.runhe.returned.event.OrderReturnStatusEnum;
import com.els.runhe.returned.service.OrderReturnService;

@Component("startOrderReturnProcessListener")
public class StartOrderReturnProcessListener implements ApplicationListener<OrderReturnCreatedEvent>{

	private static final Logger logger = LoggerFactory.getLogger(StartOrderReturnProcessListener.class);
	public static final String ORDER_RETURN_PROCESS_KEY ="order_return_approve_process";
	
	@Resource
	protected WorkFlowService workFlowService;
	
	@Resource
	protected OrderReturnService orderReturnService;
	
	
	@Override
	public void onApplicationEvent(OrderReturnCreatedEvent event) {
		OrderReturn orderReturn = (OrderReturn) event.getSource();
		
		Map<String, Object> processMap = new HashMap<>();
		processMap.put(ProcessVariableNameEnum.START_USER.getVarName(), orderReturn.getUserName());
		processMap.put(ProcessVariableNameEnum.BUSINESS_ID.getVarName(), orderReturn.getId());
		processMap.put(ProcessVariableNameEnum.COMPANY_NAME.getVarName(), orderReturn.getPurCompanyName());
		processMap.put(ProcessVariableNameEnum.TITLE.getVarName(), "退货单审批流程");
		//退货单编号
		processMap.put("orderReturnNo", orderReturn.getOrderReturnNo());
		//修改退货单状态
		orderReturn.setOrderReturnStatus(OrderReturnStatusEnum.UN_CONFIRM.getCode());
		
		this.workFlowService.startProcess(ORDER_RETURN_PROCESS_KEY, orderReturn.getOrderReturnNo(), processMap);
		
		orderReturnService.modifyObj(orderReturn);
		logger.info("退货单成功开启审批流程");
		
	}

}
