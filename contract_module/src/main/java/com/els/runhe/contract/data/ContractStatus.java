package com.els.runhe.contract.data;

/**
 * 合同状态
 *
 */
public enum ContractStatus {

	Submit("submit", "已提交"), Valid("valid", "生效"), Invalid("invalid", "作废");

	private String id;
	private String name;

	private ContractStatus(String id, String name) {
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
