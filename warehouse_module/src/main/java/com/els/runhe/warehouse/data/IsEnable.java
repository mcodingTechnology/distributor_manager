package com.els.runhe.warehouse.data;

/**
 * 是否可用(软删除)
 *
 */
public enum IsEnable {

	Yes(1, "可用"), No(0, "禁用");

	private int id;
	private String name;

	private IsEnable(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
