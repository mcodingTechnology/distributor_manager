package com.els.runhe.warehouse.data;

public enum Status {

	To_Audit("to_audit", "待审批"), Pass("pass", "审批通过"), No_Pass("no_pass", "审批不通过");

	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private Status(String id, String name) {
		this.id = id;
		this.name = name;
	}

}
