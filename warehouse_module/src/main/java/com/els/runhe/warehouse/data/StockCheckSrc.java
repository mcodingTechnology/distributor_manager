package com.els.runhe.warehouse.data;

public enum StockCheckSrc {

	Entering("entering", "手工录入"), Import("import", "导入");

	private String id;
	private String name;

	private StockCheckSrc(String id, String name) {
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
