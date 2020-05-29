package com.els.runhe.returned.event.listener;

import javax.annotation.Resource;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.base.core.service.user.UserService;
import com.els.runhe.returned.entity.OrderReturn;
import com.els.runhe.returned.event.OrderReturnCreatedEvent;
import com.els.runhe.returned.event.OrderReturnStatusEnum;
import com.els.runhe.returned.utils.OrderReturnSendWxMsgUtils;

@Component
public class ReturnSendWxMessageListener implements ApplicationListener<OrderReturnCreatedEvent>{

	@Resource
	private UserService UserService;

	@Override
	public void onApplicationEvent(OrderReturnCreatedEvent event) {
		OrderReturn OrderReturn = (OrderReturn) event.getSource();
		//OrderReturnSendWxMsgUtils.sendMsg(OrderReturnStatusEnum.UN_CONFIRM, OrderReturn);
		
	}
	
}
