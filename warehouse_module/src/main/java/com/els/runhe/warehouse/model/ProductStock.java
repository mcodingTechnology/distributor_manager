package com.els.runhe.warehouse.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "产品库存")
public class ProductStock implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("仓库ID")
	private String warehouseId;
	@ApiModelProperty("产品ID")
	private String productId;

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}
