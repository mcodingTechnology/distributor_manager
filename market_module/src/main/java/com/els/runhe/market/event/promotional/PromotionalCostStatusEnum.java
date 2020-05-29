package com.els.runhe.market.event.promotional;

public enum PromotionalCostStatusEnum {

	UN_ADD(0,"待提交"),
	UN_CONFIRM(1,"待审批"),
	TO_BE_DESIGNED(2,"待结案"),
	HAS_BEEN_DESIGNED(3,"结案待审批"),
	UN_FINISHED(4,"结案完成"),
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
	
	private PromotionalCostStatusEnum(Integer code,String name){
		this.code=code;
		this.name=name;
	}
}
