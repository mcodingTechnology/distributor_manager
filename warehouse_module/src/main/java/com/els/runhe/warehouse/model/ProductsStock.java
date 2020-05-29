package com.els.runhe.warehouse.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "产品库存")
public class ProductsStock implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("仓库ID")
	private String warehouseId;
	@ApiModelProperty("产品ID列表")
	private List<String> productIdList;

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public List<String> getProductIdList() {
		return productIdList;
	}

	public void setProductIdList(List<String> productIdList) {
		this.productIdList = productIdList;
	}

}
