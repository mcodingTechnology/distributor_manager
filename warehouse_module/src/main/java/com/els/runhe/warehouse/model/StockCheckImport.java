package com.els.runhe.warehouse.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "盘点单导入对象")
public class StockCheckImport implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品编码")
	private String productCode;
	@ApiModelProperty("实盘数量")
	private Integer amount;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
