package com.els.runhe.market.event.promotional;

public enum PromotionalApproveStatus {

	UN_PASS(100,"待审批"),
	DIRECTOR_PASS(150,"大区经理审批通过"),
	DIRECTOR_UNPASS(160,"大区经理审批不通过"),
	CHANNEL_PASS(170,"渠道主管审批通过"),
	CHANNEL_UNPASS(175,"渠道主管审批不通过"),
	DIRECTOR_END_PASS(180,"大区经理结案审批通过"),
	DIRECTOR_END_UNPASS(185,"大区经理结案审批不通过"),
	VP_PASS(200,"结案审批通过"),
	REJECT(300,"渠道主管结案审批不通过");
	
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
	
	private PromotionalApproveStatus(Integer code,String name){
		this.code=code;
		this.name=name;
	}
}
