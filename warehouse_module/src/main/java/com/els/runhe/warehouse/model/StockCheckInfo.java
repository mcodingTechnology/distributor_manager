package com.els.runhe.warehouse.model;

import java.io.Serializable;
import java.util.List;

import com.els.runhe.warehouse.entity.StockCheck;
import com.els.runhe.warehouse.entity.StockCheckList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "盘点单信息")
public class StockCheckInfo implements Serializable {

	private static final long serialVersionUID = -3436924186715708537L;

	@ApiModelProperty("盘点信息")
	private StockCheck stockCheck;
	@ApiModelProperty("盘点清单")
	private List<StockCheckList> stockCheckList;

	public StockCheck getStockCheck() {
		return stockCheck;
	}

	public void setStockCheck(StockCheck stockCheck) {
		this.stockCheck = stockCheck;
	}

	public List<StockCheckList> getStockCheckList() {
		return stockCheckList;
	}

	public void setStockCheckList(List<StockCheckList> stockCheckList) {
		this.stockCheckList = stockCheckList;
	}

}
