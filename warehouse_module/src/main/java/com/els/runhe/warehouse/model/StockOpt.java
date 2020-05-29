package com.els.runhe.warehouse.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "库存操作")
public class StockOpt implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品ID")
	private String productId;
	@ApiModelProperty("仓库ID")
	private String warehouseId;
	@ApiModelProperty("数量")
	private Integer amount;
	@ApiModelProperty("操作数量类型：plus增加，minus减少，keep保持")
	private String amountType;
	@ApiModelProperty("操作类型：check盘点，shipment发货，adjust调整")
	private String optType;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getAmountType() {
		return amountType;
	}

	public void setAmountType(String amountType) {
		this.amountType = amountType;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

}
