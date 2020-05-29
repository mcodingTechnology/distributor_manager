package com.els.runhe.warehouse.data;

public enum StockOptType {

	Check("check", "盘点"), Shipment("shipment", "发货"), Adjust("adjust", "调整"), Init("init", "初始化");

	private String id;
	private String name;

	private StockOptType(String id, String name) {
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
