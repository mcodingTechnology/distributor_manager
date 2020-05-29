package com.els.runhe.market.event.design.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.els.runhe.market.entity.design.MarketDesignApply;
import com.els.runhe.market.event.design.MarketDesignApplyEvent;
import com.els.runhe.market.event.design.MarketDesignStatusEnum;
import com.els.runhe.market.utils.MarketDesignSendWxMsgUtils;

@Component
public class DesignSendWxMessageListener implements ApplicationListener<MarketDesignApplyEvent>{

	@Override
	public void onApplicationEvent(MarketDesignApplyEvent event) {
		MarketDesignApply marketDesignApply = (MarketDesignApply)event.getSource();
		
		//MarketDesignSendWxMsgUtils.sendMsg(MarketDesignStatusEnum.UN_CONFIRM, marketDesignApply);
		
	}

}
