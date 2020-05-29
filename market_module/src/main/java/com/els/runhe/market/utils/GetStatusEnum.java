package com.els.runhe.market.utils;

import com.els.runhe.market.event.design.MarketDesignStatusEnum;
import com.els.runhe.market.event.train.MarketTrainStatusEnum;

public class GetStatusEnum {

	/**
	 * 市场培训申请根据状态code获取状态名称
	 * @param code
	 * @return
	 */
	public String getTrainStatus(Integer code){
		String name ="";
		switch(code){
		case 0:
			name=MarketTrainStatusEnum.UN_ADD.getName();
			break;
		case 1:
			name=MarketTrainStatusEnum.UN_CONFIRM.getName();
			break;
		case 2:
			name=MarketTrainStatusEnum.TO_BE_TRAIN.getName();
			break;
		case 3:
			name=MarketTrainStatusEnum.HAS_BEEN_TRAIN.getName();
			break;
		case 4:
			name=MarketTrainStatusEnum.UN_FINISHED.getName();	
			break;
		case 5:
			name=MarketTrainStatusEnum.CANCLE.getName();
			break;
		default:
			name="";	
			break;
		}
		return name;
	}
	
	/**
	 * 市场平面设计根据状态code获取状态名称
	 * @param code
	 * @return
	 */
	public String getDesignStatus(Integer code){
		String name ="";
		switch(code){
		case 0:
			name=MarketDesignStatusEnum.UN_ADD.getName();
			break;
		case 1:
			name=MarketDesignStatusEnum.UN_CONFIRM.getName();
			break;
		case 2:
			name=MarketDesignStatusEnum.TO_BE_DESIGNED.getName();
			break;
		case 3:
			name=MarketDesignStatusEnum.HAS_BEEN_DESIGNED.getName();
			break;
		case 4:
			name=MarketDesignStatusEnum.UN_FINISHED.getName();	
			break;
		case 5:
			name=MarketDesignStatusEnum.CANCLE.getName();
			break;
		default:
			name="";	
			break;
		}
		return name;
	}
}
