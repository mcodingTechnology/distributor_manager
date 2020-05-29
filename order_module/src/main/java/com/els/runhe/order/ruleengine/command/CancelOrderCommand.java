package com.els.runhe.order.ruleengine.command;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.els.base.core.exception.CommonException;
import com.els.base.utils.SpringContextHolder;
import com.els.base.workflow.common.service.WorkFlowService;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderExample;
import com.els.runhe.order.ruleengine.OrderCommand;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.state.DeliveryStatus;
import com.els.runhe.order.ruleengine.state.SubmitStatus;
import com.els.runhe.order.service.OrderService;
import com.els.runhe.order.utils.OrderConstants;
import com.els.runhe.order.utils.OrderSendWxMsgUtils;

public class CancelOrderCommand implements OrderCommand {
	
	private static Logger logger = LoggerFactory.getLogger(CancelOrderCommand.class);
	
	protected static OrderService orderService = SpringContextHolder.getOneBean(OrderService.class);
	protected static WorkFlowService workFlowService = SpringContextHolder.getOneBean(WorkFlowService.class);
	private List<String> orderIds;

	public CancelOrderCommand(List<String> orderIds) {
		this.orderIds = orderIds;
	}

	@Override
	public void execute(OrderRuleEngine context) {
		OrderExample exampleTmp = new OrderExample();
    	exampleTmp.createCriteria()
    	    .andIdIn(orderIds)
    	    .andDeliveryStatusNotEqualTo(DeliveryStatus.UN_SENT.getCode());
    	
    	if (CollectionUtils.isNotEmpty(orderService.queryAllObjByExample(exampleTmp))) {
    		throw new CommonException("存在已发货的订单，无法取消");
		}
    	
    	OrderExample example = new OrderExample();
    	example.createCriteria().andIdIn(orderIds).andStatusNotEqualTo(SubmitStatus.CANCEL.getCode());
    	List<Order> orderList = orderService.queryAllObjByExample(example);
    	
    	if (CollectionUtils.isEmpty(orderList)) {
    		logger.warn("要取消订单，状态都已经是取消了，不用操作");
    		return;
    	}
    	
    	//解冻库存
    	for(Order order: orderList){
    		context.invoke(new UnFreezeStockCommand(order.getId()));
    	}
    	
    	Order record = new Order();
    	record.setStatus(SubmitStatus.CANCEL.getCode());
		orderService.modifyObjByExample(record , example);
		
		for(Order order: orderList){
			workFlowService.stopProcess(OrderConstants.ORDER_PROCESS_KEY, order.getOrderNo());
		}
		
		OrderSendWxMsgUtils.sendMsg(OrderSendWxMsgUtils.ORDER_STATUS_CANCEL, orderList);

	}

}
