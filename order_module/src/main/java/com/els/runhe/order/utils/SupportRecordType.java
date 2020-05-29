package com.els.runhe.order.utils;

public enum SupportRecordType {
	
	SALE_SUPPORT_INCREASE("sale_support_increase"),
	SALE_SUPPORT_DECREASE("sale_support_decrease"),
	MARKET_SUPPORT_INCREASE("market_support_increase"),
	MARKET_SUPPORT_DECREASE("market_support_decrease");
	
	private String code;

	private SupportRecordType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
