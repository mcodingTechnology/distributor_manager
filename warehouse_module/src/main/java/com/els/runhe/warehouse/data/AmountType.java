package com.els.runhe.warehouse.data;

public enum AmountType {

	Plus("plus", "增加"), Minus("minus", "减少"), Keep("keep", "保持");

	private String id;
	private String name;

	private AmountType(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
