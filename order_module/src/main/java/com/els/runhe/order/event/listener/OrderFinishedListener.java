package com.els.runhe.order.event.listener;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.core.exception.CommonException;
import com.els.base.core.service.user.UserService;
import com.els.base.workflow.common.event.TaskOperateEvent;
import com.els.base.workflow.common.utils.ApproveStatusEnum;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.command.UnFreezeStockCommand;
import com.els.runhe.order.ruleengine.state.ApprovalStatus;
import com.els.runhe.order.ruleengine.state.SubmitStatus;
import com.els.runhe.order.service.OrderService;
import com.els.runhe.order.utils.OrderConstants;
import com.els.runhe.order.utils.OrderSendWxMsgUtils;

@Component
public class OrderFinishedListener implements ApplicationListener<TaskOperateEvent> {
	
	private static Logger logger = LoggerFactory.getLogger(OrderFinishedListener.class);
	
	@Resource
	protected OrderService orderService;

	@Resource
	private UserService userService;
	
	@Resource
	private OrderRuleEngine ruleEngine;
	
	@Override
	public void onApplicationEvent(TaskOperateEvent event) {
		String processKey = event.getProcessDefinitionKey();
		if (!OrderConstants.ORDER_PROCESS_KEY.equals(processKey)) {
			return;
		}
		
		String orderId = (String) event.getCurrentProcess().getProcessVariables().get(ProcessVariableNameEnum.BUSINESS_ID.getVarName());
		if (StringUtils.isBlank(orderId)) {
			throw new CommonException("流程执行失败，流程中orderId的参数为空");
		}
		
		Order order = this.orderService.queryObjById(orderId);
		if (order == null) {
			throw new CommonException("流程执行失败，流程中orderId在数据库没有数据");
		}
		
		Order temp = new Order();
		temp.setId(orderId);
		
		if (event.isPass()) {
			//如果审批通过
			if (!event.isFinished()) {
				//订单未结束，运营人员审批通过
				temp.setApprovalStatus(ApprovalStatus.OPERATOR_PASS.getCode());
				
			}else {
				//订单结束，财务人员审批通过
				temp.setApprovalStatus(ApprovalStatus.FINANCIAL_PASS.getCode());
				temp.setStatus(SubmitStatus.PAID.getCode());
				OrderSendWxMsgUtils.sendMsg(OrderSendWxMsgUtils.ORDER_STATUS_UN_SENT, order);
			}
			
			orderService.modifyObj(temp);
			logger.info("订单审批结束，更改状态为[{}]", temp.getApprovalStatus());
			
		}else {
			
			//如果审批没通过，释放库存
			this.ruleEngine.invoke(new UnFreezeStockCommand(orderId));
			
			if (order.getApprovalStatus().equals(ApprovalStatus.UN_APPROVAL.getCode())) {
				// 营运人员审批不通过
				temp.setApprovalStatus(ApprovalStatus.OPERATOR_UNPASS.getCode());
			}else if(order.getApprovalStatus().equals(ApprovalStatus.OPERATOR_PASS.getCode())) {
				// 财务人员审批不通过
				temp.setApprovalStatus(ApproveStatusEnum.REJECT.getValue());
			}
			orderService.modifyObj(temp);
			logger.info("订单审批结束，更改状态为[{}]", temp.getApprovalStatus());
			
		}
		
		
	}

}
