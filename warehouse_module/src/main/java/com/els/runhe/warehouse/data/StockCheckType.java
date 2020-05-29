package com.els.runhe.warehouse.data;

public enum StockCheckType {

	Check("1", "盘点"), Storage("2", "发货");

	private String id;
	private String name;

	private StockCheckType(String id, String name) {
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
