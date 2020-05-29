package com.els.runhe.returned.event;

public enum OrderReturnStatusEnum {

	UN_ADD(0,"待提交"),
	UN_CONFIRM(1,"待确认"),
	UN_DELIVERED(2,"待发货"),
	UN_RECEIVED(3,"待收货"),
	UN_FINISHED(4,"已完成"),
	CANCLE(5, "已取消");
	
	private Integer code;
	private String name;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private OrderReturnStatusEnum(Integer code,String name){
		this.code=code;
		this.name=name;
	}
}
