package com.els.runhe.warehouse.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="库存流水导出")
public class StockSerialToExcel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品ID")
    private String productId;

    @ApiModelProperty("品名")
    private String productName;

    @ApiModelProperty("期初数量")
    private Integer beginningAmount;
    
    @ApiModelProperty("当期入库数量")
    private Integer originAmount;

    @ApiModelProperty("当期出库数量")
    private Integer offsetAmount;

    @ApiModelProperty("系统已发仓库未发")
    private Integer sysShippedAmount;
    
    @ApiModelProperty("系统未发仓库已发")
    private Integer sysNotShippedAmount;
    
    @ApiModelProperty("系统已入仓库未入")
    private Integer sysInStorageAmount;
    
    @ApiModelProperty("系统未入仓库已入")
    private Integer sysNotInStorageAmount;
    
    @ApiModelProperty("应结存数量")
    private Integer balanceAmount;
    
    @ApiModelProperty("实际数量")
    private Integer realityAmount;
    
    
    @ApiModelProperty("实际数量")
    private String whetherConform;
    
    
    @ApiModelProperty("查询周期")
    private String queryPeriod;
    
    
    

	public String getQueryPeriod() {
		return queryPeriod;
	}


	public void setQueryPeriod(String queryPeriod) {
		this.queryPeriod = queryPeriod;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Integer getBeginningAmount() {
		return beginningAmount;
	}


	public void setBeginningAmount(Integer beginningAmount) {
		this.beginningAmount = beginningAmount;
	}


	public Integer getOriginAmount() {
		return originAmount;
	}


	public void setOriginAmount(Integer originAmount) {
		this.originAmount = originAmount;
	}


	public Integer getOffsetAmount() {
		return offsetAmount;
	}


	public void setOffsetAmount(Integer offsetAmount) {
		this.offsetAmount = offsetAmount;
	}


	public Integer getSysShippedAmount() {
		return sysShippedAmount;
	}


	public void setSysShippedAmount(Integer sysShippedAmount) {
		this.sysShippedAmount = sysShippedAmount;
	}


	public Integer getSysNotShippedAmount() {
		return sysNotShippedAmount;
	}


	public void setSysNotShippedAmount(Integer sysNotShippedAmount) {
		this.sysNotShippedAmount = sysNotShippedAmount;
	}


	public Integer getSysInStorageAmount() {
		return sysInStorageAmount;
	}


	public void setSysInStorageAmount(Integer sysInStorageAmount) {
		this.sysInStorageAmount = sysInStorageAmount;
	}


	public Integer getSysNotInStorageAmount() {
		return sysNotInStorageAmount;
	}


	public void setSysNotInStorageAmount(Integer sysNotInStorageAmount) {
		this.sysNotInStorageAmount = sysNotInStorageAmount;
	}


	public Integer getBalanceAmount() {
		return balanceAmount;
	}


	public void setBalanceAmount(Integer balanceAmount) {
		this.balanceAmount = balanceAmount;
	}


	public Integer getRealityAmount() {
		return realityAmount;
	}


	public void setRealityAmount(Integer realityAmount) {
		this.realityAmount = realityAmount;
	}


	public String getWhetherConform() {
		return whetherConform;
	}


	public void setWhetherConform(String whetherConform) {
		this.whetherConform = whetherConform;
	}
    
    
   
}