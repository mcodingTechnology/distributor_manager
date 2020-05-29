package com.els.runhe.product.utils;

public enum ProductSceneEnum {
	
	GIFT_MALL("积分商城", "metrxgiftmall");
	
	
	private String name;
	private String code;
	private ProductSceneEnum(String name, String code) {
		this.name = name;
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	
}
