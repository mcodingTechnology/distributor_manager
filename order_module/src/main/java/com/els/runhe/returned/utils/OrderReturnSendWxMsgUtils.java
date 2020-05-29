package com.els.runhe.returned.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.els.runhe.order.utils.OrderSendWxMsgUtils;
import com.els.runhe.returned.entity.OrderReturn;
import com.els.runhe.returned.event.OrderReturnStatusEnum;

/**
 * 退货单触发微信消息工具
 * @author zbw
 *
 */
public abstract class OrderReturnSendWxMsgUtils {

	private static Logger logger = LoggerFactory.getLogger(OrderReturnSendWxMsgUtils.class);
	
	public static void sendMsg(OrderReturnStatusEnum orderReturnStatus, OrderReturn orderReturn){
		Set<String> userIdList = new HashSet<>();
		userIdList.add(orderReturn.getUserId());
		
		String orderReturnUserId = OrderSendWxMsgUtils.getUserByPhone(orderReturn.getOrderReturnPhone());
		if(StringUtils.isNotBlank(orderReturnUserId)){
			userIdList.add(orderReturnUserId);
		}
		
		String addressUserId = OrderSendWxMsgUtils.getUserByPhone(orderReturn.getAddressPhone());
		if(StringUtils.isNotBlank(addressUserId)){
			userIdList.add(addressUserId);
		}
		
		OrderReturnSendWxMsgUtils.sendMsg(orderReturnStatus, userIdList, orderReturn);
	}
	
	public static void sendMsg(OrderReturnStatusEnum orderReturnStatus, List<OrderReturn> orderReturnList){
		if(CollectionUtils.isNotEmpty(orderReturnList)){
			for(int i=0;i<orderReturnList.size();i++){
				OrderReturnSendWxMsgUtils.sendMsg(orderReturnStatus, orderReturnList.get(i));
			}
		}
	}
	
	public static void sendMsg(OrderReturnStatusEnum orderReturnStatus, Set<String> receiverIdList, Object data){
		switch(orderReturnStatus) {
		case UN_CONFIRM:
			OrderSendWxMsgUtils.sendMsg(receiverIdList, "TASK_STATUS_OPERATE", data);
			break;
		default:
			break;
		}
	}
	
}
