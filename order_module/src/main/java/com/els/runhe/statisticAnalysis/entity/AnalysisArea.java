package com.els.runhe.statisticAnalysis.entity;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="对账单")
public class AnalysisArea implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("区域")
    private String area;
	
    @ApiModelProperty("区域名")
    private String areaName;
    
    @ApiModelProperty("区域类型，DQ：大区，SQ：省区")
    private String areaType;
    
    @ApiModelProperty("1月")
    private String oneMonth = "0";
    
    @ApiModelProperty("2月")
    private String twoMonth = "0";
    
    @ApiModelProperty("3月")
    private String threeMonth = "0";
    
    @ApiModelProperty("4月")
    private String fourMonth = "0";
    
    @ApiModelProperty("5月")
    private String fiveMonth = "0";
    
    @ApiModelProperty("6月")
    private String sixMonth = "0";
    
    @ApiModelProperty("7月")
    private String sevenMonth = "0";
    
    @ApiModelProperty("8月")
    private String eightMonth = "0";
    
    
    @ApiModelProperty("9月")
    private String nineMonth = "0";
    
    @ApiModelProperty("10月")
    private String tenMonth = "0";
    
    @ApiModelProperty("11月")
    private String elevenMonth = "0";
    
    @ApiModelProperty("12月")
    private String twelveMonth = "0";
    
    @ApiModelProperty("合计")
    private String sum  = "0";
    
    
    @ApiModelProperty("金额")
    private String amountTotal = "0";
    
    @ApiModelProperty("订单时间")
    private String orderTime = "0";
    
    
    
    @ApiModelProperty("产品分类id")
    private String  categoryId;
    
    @ApiModelProperty("产品")
    private String  product = "0";
    
    @ApiModelProperty("物料")
    private String materiel = "0";
    
    @ApiModelProperty("赠品其他")
    private String present  = "0";
    
    private List<String> companyIds;
    
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	public String getMateriel() {
		return materiel;
	}

	public void setMateriel(String materiel) {
		this.materiel = materiel;
	}

	public String getPresent() {
		return present;
	}

	public void setPresent(String present) {
		this.present = present;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaType() {
		return areaType;
	}

	public void setAreaType(String areaType) {
		this.areaType = areaType;
	}

	public String getOneMonth() {
		return oneMonth;
	}

	public void setOneMonth(String oneMonth) {
		this.oneMonth = oneMonth;
	}

	public String getTwoMonth() {
		return twoMonth;
	}

	public void setTwoMonth(String twoMonth) {
		this.twoMonth = twoMonth;
	}

	public String getThreeMonth() {
		return threeMonth;
	}

	public void setThreeMonth(String threeMonth) {
		this.threeMonth = threeMonth;
	}

	public String getFourMonth() {
		return fourMonth;
	}

	public void setFourMonth(String fourMonth) {
		this.fourMonth = fourMonth;
	}

	public String getFiveMonth() {
		return fiveMonth;
	}

	public void setFiveMonth(String fiveMonth) {
		this.fiveMonth = fiveMonth;
	}

	public String getSixMonth() {
		return sixMonth;
	}

	public void setSixMonth(String sixMonth) {
		this.sixMonth = sixMonth;
	}

	public String getSevenMonth() {
		return sevenMonth;
	}

	public void setSevenMonth(String sevenMonth) {
		this.sevenMonth = sevenMonth;
	}

	public String getEightMonth() {
		return eightMonth;
	}

	public void setEightMonth(String eightMonth) {
		this.eightMonth = eightMonth;
	}

	public String getNineMonth() {
		return nineMonth;
	}

	public void setNineMonth(String nineMonth) {
		this.nineMonth = nineMonth;
	}

	public String getTenMonth() {
		return tenMonth;
	}

	public void setTenMonth(String tenMonth) {
		this.tenMonth = tenMonth;
	}

	public String getElevenMonth() {
		return elevenMonth;
	}

	public void setElevenMonth(String elevenMonth) {
		this.elevenMonth = elevenMonth;
	}

	public String getTwelveMonth() {
		return twelveMonth;
	}

	public void setTwelveMonth(String twelveMonth) {
		this.twelveMonth = twelveMonth;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(String amountTotal) {
		this.amountTotal = amountTotal;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<String> getCompanyIds() {
		return companyIds;
	}
	public void setCompanyIds(List<String> companyIds) {
		this.companyIds = companyIds;
	}
	
	
}