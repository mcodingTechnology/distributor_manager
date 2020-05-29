package com.els.runhe.warehouse.model;

import java.io.Serializable;
import java.util.List;

import com.els.runhe.warehouse.entity.StockAdjust;
import com.els.runhe.warehouse.entity.StockAdjustList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "调整单信息")
public class StockAdjustInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("调整信息")
	private StockAdjust stockAdjust;
	@ApiModelProperty("调整清单")
	private List<StockAdjustList> stockAdjustList;

	public StockAdjust getStockAdjust() {
		return stockAdjust;
	}

	public void setStockAdjust(StockAdjust stockAdjust) {
		this.stockAdjust = stockAdjust;
	}

	public List<StockAdjustList> getStockAdjustList() {
		return stockAdjustList;
	}

	public void setStockAdjustList(List<StockAdjustList> stockAdjustList) {
		this.stockAdjustList = stockAdjustList;
	}

}
