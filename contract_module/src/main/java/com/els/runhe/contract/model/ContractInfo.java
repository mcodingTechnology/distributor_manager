package com.els.runhe.contract.model;

import java.io.Serializable;
import java.util.List;

import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractRefundTarget;
import com.els.runhe.contract.entity.ContractSaleSupport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "合同信息")
public class ContractInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("合同基础信息")
	private Contract contract;

	@ApiModelProperty("回款目标列表")
	private List<ContractRefundTarget> refundTargetList;

	@ApiModelProperty("销售支持列表")
	private List<ContractSaleSupport> saleSupportList;

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public List<ContractRefundTarget> getRefundTargetList() {
		return refundTargetList;
	}

	public void setRefundTargetList(List<ContractRefundTarget> refundTargetList) {
		this.refundTargetList = refundTargetList;
	}

	public List<ContractSaleSupport> getSaleSupportList() {
		return saleSupportList;
	}

	public void setSaleSupportList(List<ContractSaleSupport> saleSupportList) {
		this.saleSupportList = saleSupportList;
	}

}
