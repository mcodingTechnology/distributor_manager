package com.els.runhe.contract.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "回款是否达标")
public class ReachRefund implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("合同ID")
	private String contractId;
	@ApiModelProperty("月份")
	private Integer month;
	@ApiModelProperty("实际回款额")
	private Double actualAmount;

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Double getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(Double actualAmount) {
		this.actualAmount = actualAmount;
	}

}
