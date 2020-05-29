package com.els.runhe.statisticAnalysis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="对账订单行项目")
public class AnalysisOrderProduct implements Serializable {
    @ApiModelProperty("订单商品关联ID")
    private String id;

    @ApiModelProperty("要货经销商id")
    private String companyId;

    @ApiModelProperty("要货经销商名称")
    private String companyName;

    @ApiModelProperty("订单id")
    private String orderId;

    @ApiModelProperty("产品分类id")
    private Integer categoryId;

    @ApiModelProperty("产品分类名")
    private String categoryName;

    @ApiModelProperty("商品id")
    private Integer productId;

    private String productCode;

    @ApiModelProperty("商品名称")
    private String productName;

    @ApiModelProperty("产品图片")
    private String productImg;

    @ApiModelProperty("产品单位")
    private String productUnit;

    @ApiModelProperty("产品规格")
    private String productSpec;

    @ApiModelProperty("商品零售价")
    private BigDecimal productPrice;

    @ApiModelProperty("药房供货价")
    private BigDecimal productPriceForNextDealer;

    @ApiModelProperty("供货价")
    private BigDecimal productSupplyPrice;

    @ApiModelProperty("产品兑换积分")
    private Integer productPoint;

    @ApiModelProperty("类型 0 微商城，1 全额积分兑换 2 加钱购兑换")
    private Integer type;

    @ApiModelProperty("单个商品数量")
    private Integer nums;

    @ApiModelProperty("小计总数")
    private BigDecimal amountTotal;

    @ApiModelProperty("产品库存")
    private Integer productStock;
    
    @ApiModelProperty("创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec == null ? null : productSpec.trim();
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductPriceForNextDealer() {
        return productPriceForNextDealer;
    }

    public void setProductPriceForNextDealer(BigDecimal productPriceForNextDealer) {
        this.productPriceForNextDealer = productPriceForNextDealer;
    }

    public BigDecimal getProductSupplyPrice() {
        return productSupplyPrice;
    }

    public void setProductSupplyPrice(BigDecimal productSupplyPrice) {
        this.productSupplyPrice = productSupplyPrice;
    }

    public Integer getProductPoint() {
        return productPoint;
    }

    public void setProductPoint(Integer productPoint) {
        this.productPoint = productPoint;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public BigDecimal getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(BigDecimal amountTotal) {
        this.amountTotal = amountTotal;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
    
}