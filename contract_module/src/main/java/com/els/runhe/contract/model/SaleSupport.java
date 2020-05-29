package com.els.runhe.contract.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "实际销售")
public class SaleSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("合同ID")
	private String contractId;
	@ApiModelProperty("实际销售额")
	private Double actualAmount;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public Double getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(Double actualAmount) {
		this.actualAmount = actualAmount;
	}

}
