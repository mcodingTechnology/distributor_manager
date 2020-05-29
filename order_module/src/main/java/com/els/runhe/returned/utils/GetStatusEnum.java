package com.els.runhe.returned.utils;

import com.els.runhe.returned.event.OrderReturnStatusEnum;


public class GetStatusEnum {

	public String getName(Integer code){
		String name ="";
		switch(code){
		case 0:
			name=OrderReturnStatusEnum.UN_ADD.getName();
			break;
		case 1:
			name=OrderReturnStatusEnum.UN_CONFIRM.getName();
			break;
		case 2:
			name=OrderReturnStatusEnum.UN_DELIVERED.getName();
			break;
		case 3:
			name=OrderReturnStatusEnum.UN_RECEIVED.getName();
			break;
		case 4:
			name=OrderReturnStatusEnum.UN_FINISHED.getName();	
			break;
		case 5:
			name=OrderReturnStatusEnum.CANCLE.getName();
			break;
		default:
			name="";	
			break;
		}
		return name;
	}
}
