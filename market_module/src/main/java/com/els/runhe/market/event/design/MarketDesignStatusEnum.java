package com.els.runhe.market.event.design;

public enum MarketDesignStatusEnum {

	UN_ADD(0,"待提交"),
	UN_CONFIRM(1,"待审批"),
	TO_BE_DESIGNED(2,"待设计"),
	HAS_BEEN_DESIGNED(3,"已设计"),
	UN_FINISHED(4,"已完成"),
	CANCLE(5,"作废");
	
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
	
	private MarketDesignStatusEnum(Integer code,String name){
		this.code=code;
		this.name=name;
	}
}
