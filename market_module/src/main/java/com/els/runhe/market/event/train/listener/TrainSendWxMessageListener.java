package com.els.runhe.market.event.train.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.runhe.market.entity.train.MarketTrainApply;
import com.els.runhe.market.event.train.MarketTrainApplyEvent;
import com.els.runhe.market.event.train.MarketTrainStatusEnum;
import com.els.runhe.market.utils.MarketTrainSendWxMsgUtils;

@Component
public class TrainSendWxMessageListener implements ApplicationListener<MarketTrainApplyEvent>{

	@Override
	public void onApplicationEvent(MarketTrainApplyEvent event) {
		MarketTrainApply marketTrainApply = (MarketTrainApply)event.getSource();
		
		//MarketTrainSendWxMsgUtils.sendMsg(MarketTrainStatusEnum.UN_CONFIRM, marketTrainApply);
		
	}

}
