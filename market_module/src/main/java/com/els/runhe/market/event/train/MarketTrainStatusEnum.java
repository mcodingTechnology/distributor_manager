package com.els.runhe.market.event.train;

public enum MarketTrainStatusEnum {

	UN_ADD(0,"待提交"),
	UN_CONFIRM(1,"待审批"),
	TO_BE_TRAIN(2,"待培训"),
	HAS_BEEN_TRAIN(3,"已培训"),
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
	
	private MarketTrainStatusEnum(Integer code,String name){
		this.code=code;
		this.name=name;
	}
}
