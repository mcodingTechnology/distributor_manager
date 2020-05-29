package com.els.runhe.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="订单-销售支持额度信息")
public class SaleAndMarketSupport implements Serializable {
	
	private static final long serialVersionUID = 8580649384585220034L;

	@ApiModelProperty("销售支持总额度")
	private BigDecimal saleSupportTotalQuota;
	
	@ApiModelProperty("销售支持已用额度")
	private BigDecimal saleSupportUsedQuota;
	
	@ApiModelProperty("销售支持可用限额")
	private BigDecimal saleSupportQuota;
	
	@ApiModelProperty("市场支持总额度")
	private BigDecimal marketSupportTotalQuota;
	
	@ApiModelProperty("市场支持已用额度")
	private BigDecimal marketSupportUsedQuota;
	
	@ApiModelProperty("市场支持可用限额")
	private BigDecimal marketSupportQuota;
	
	public BigDecimal getSaleSupportTotalQuota() {
		return saleSupportTotalQuota;
	}

	public void setSaleSupportTotalQuota(BigDecimal saleSupportTotalQuota) {
		this.saleSupportTotalQuota = saleSupportTotalQuota;
	}

	public BigDecimal getSaleSupportUsedQuota() {
		return saleSupportUsedQuota;
	}

	public void setSaleSupportUsedQuota(BigDecimal saleSupportUsedQuota) {
		this.saleSupportUsedQuota = saleSupportUsedQuota;
	}

	public BigDecimal getSaleSupportQuota() {
		return saleSupportQuota;
	}

	public void setSaleSupportQuota(BigDecimal marketSupportQuota) {
		this.saleSupportQuota = marketSupportQuota;
	}

	public BigDecimal getMarketSupportTotalQuota() {
		return marketSupportTotalQuota;
	}

	public void setMarketSupportTotalQuota(BigDecimal marketSupportTotalQuota) {
		this.marketSupportTotalQuota = marketSupportTotalQuota;
	}

	public BigDecimal getMarketSupportUsedQuota() {
		return marketSupportUsedQuota;
	}

	public void setMarketSupportUsedQuota(BigDecimal marketSupportUsedQuota) {
		this.marketSupportUsedQuota = marketSupportUsedQuota;
	}

	public BigDecimal getMarketSupportQuota() {
		return marketSupportQuota;
	}

	public void setMarketSupportQuota(BigDecimal marketSupportQuota) {
		this.marketSupportQuota = marketSupportQuota;
	}

}
