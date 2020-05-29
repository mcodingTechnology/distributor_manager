package com.els.runhe.product.entity.productPrice;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="产品价格")
public class ProductPrice implements Serializable {
	
//	#########勿覆盖#############
	private String productSpec;
	
    public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}
	
//	######################

	@ApiModelProperty("价格id")
    private Integer id;

    @ApiModelProperty("商品id")
    private Integer productId;

    @ApiModelProperty("产品名称")
    private String productName;

    @ApiModelProperty("产品条形码")
    private String productBarCode;
    
    @ApiModelProperty("产品编码")
    private String numberCode;

    @ApiModelProperty("产品单位")
    private String productUnit;

    @ApiModelProperty("价格")
    private BigDecimal price;

    @ApiModelProperty("药店供货价")
    private BigDecimal priceForNextDealer;

    @ApiModelProperty("客户id")
    private String companyId;

    @ApiModelProperty("客户名称")
    private String companyName;

    @ApiModelProperty("经销商编码")
    private String companyCode;

    @ApiModelProperty("数量从")
    private Integer numFrom;

    @ApiModelProperty("数量至")
    private Integer numTo;

    @ApiModelProperty("扣率")
    private BigDecimal discount;

    @ApiModelProperty("固定加价")
    private BigDecimal priceExtra;

    @ApiModelProperty("优先级，数字越大优先级越高")
    private Integer priority;

    @ApiModelProperty("限购数量")
    private Integer limitQuantity;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("生效时间")
    private Date validDate;

    @ApiModelProperty("过期时间")
    private Date expiredDate;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;
    
    @ApiModelProperty("状态  0或空为正常， 1为作废")
    private String status;

    private static final long serialVersionUID = 1L;

    
    
    
    public String getNumberCode() {
		return numberCode;
	}

	public void setNumberCode(String numberCode) {
		this.numberCode = numberCode;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode == null ? null : productBarCode.trim();
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPriceForNextDealer() {
        return priceForNextDealer;
    }

    public void setPriceForNextDealer(BigDecimal priceForNextDealer) {
        this.priceForNextDealer = priceForNextDealer;
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public Integer getNumFrom() {
        return numFrom;
    }

    public void setNumFrom(Integer numFrom) {
        this.numFrom = numFrom;
    }

    public Integer getNumTo() {
        return numTo;
    }

    public void setNumTo(Integer numTo) {
        this.numTo = numTo;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPriceExtra() {
        return priceExtra;
    }

    public void setPriceExtra(BigDecimal priceExtra) {
        this.priceExtra = priceExtra;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getLimitQuantity() {
        return limitQuantity;
    }

    public void setLimitQuantity(Integer limitQuantity) {
        this.limitQuantity = limitQuantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}