package com.els.runhe.market.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.els.runhe.market.entity.train.MarketTrainApply;
import com.els.runhe.market.event.train.MarketTrainStatusEnum;

/**
 * 市场培训申请触发微信消息工具
 * @author wbin
 *
 */
public class MarketTrainSendWxMsgUtils {

	public static void sendMsg(MarketTrainStatusEnum marketTrainStatus, MarketTrainApply marketTrainApply){
		Set<String> userIdList = new HashSet<>();
		userIdList.add(marketTrainApply.getUserId());
		
		String trainContactUserId = MarketDesignSendWxMsgUtils.getUserByPhone(marketTrainApply.getTrainContactPhone());
		if(StringUtils.isNotBlank(trainContactUserId)){
			userIdList.add(trainContactUserId);
		}
		
		MarketTrainSendWxMsgUtils.sendMsg(marketTrainStatus, userIdList, marketTrainApply);
	}
	
	public static void sendMsg(MarketTrainStatusEnum marketTrainStatus, List<MarketTrainApply> marketTrainApplyList){
		if(CollectionUtils.isNotEmpty(marketTrainApplyList)){
			for(int i=0;i<marketTrainApplyList.size();i++){
				MarketTrainSendWxMsgUtils.sendMsg(marketTrainStatus, marketTrainApplyList.get(i));
			}
		}
	}
	
	public static void sendMsg(MarketTrainStatusEnum marketTrainStatus, Set<String> receiverIdList, Object data){
		switch(marketTrainStatus) {
		case UN_CONFIRM:
			MarketDesignSendWxMsgUtils.sendMsg(receiverIdList, "TASK_STATUS_OPERATE", data);
			break;
		default:
			break;
		}
	}
}
