package com.els.runhe.order.event.listener;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.core.service.user.UserService;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.event.OrderSubmitEvent;
import com.els.runhe.order.utils.OrderSendWxMsgUtils;

@Component
public class SendWxMessageListener implements ApplicationListener<OrderSubmitEvent> {
	
	@Resource
	private UserService userService;

	@Override
	public void onApplicationEvent(OrderSubmitEvent event) {
		Order order = (Order) event.getSource();
		OrderSendWxMsgUtils.sendMsg(OrderSendWxMsgUtils.ORDER_STATUS_UN_PAID, order);
	}
	
}
