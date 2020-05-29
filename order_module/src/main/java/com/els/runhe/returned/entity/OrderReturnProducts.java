package com.els.runhe.returned.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="退货单关联表")
public class OrderReturnProducts implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("（退货）订单编号")
    private String orderReturnNo;

    @ApiModelProperty("产品分类id")
    private Integer categoryId;

    @ApiModelProperty("产品分类名")
    private String categoryName;

    @ApiModelProperty("商品ID")
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

    @ApiModelProperty("区域")
    private String area;

    @ApiModelProperty("订货时间")
    private Date orderTime;

    @ApiModelProperty("有效期")
    private Date validityPeriod;

    @ApiModelProperty("生产日期")
    private Date productionDate;

    @ApiModelProperty("商品数量")
    private Integer nums;

    @ApiModelProperty("合计数量")
    private Integer totalNums;

    @ApiModelProperty("退货单价")
    private BigDecimal returnPrice;

    @ApiModelProperty("退货金额")
    private BigDecimal returnAmount;

    @ApiModelProperty("退货合计金额")
    private BigDecimal returnTotalAmount;

    @ApiModelProperty("订货单价")
    private BigDecimal orderPrice;

    @ApiModelProperty("订货金额")
    private BigDecimal orderAmount;

    @ApiModelProperty("合计订货金额")
    private BigDecimal orderTotalAmount;

    @ApiModelProperty("退货原因")
    private String returnReason;

    @ApiModelProperty("备用字段1")
    private String ext1;

    @ApiModelProperty("备用字段2")
    private String ext2;

    @ApiModelProperty("备用字段3")
    private String ext3;

    @ApiModelProperty("备用字段4")
    private String ext4;

    @ApiModelProperty("备用字段5")
    private String ext5;

    @ApiModelProperty("备用字段6")
    private String ext6;

    @ApiModelProperty("备用字段7")
    private String ext7;

    @ApiModelProperty("备用字段8")
    private String ext8;

    @ApiModelProperty("备用字段9")
    private String ext9;

    @ApiModelProperty("备用字段10")
    private String ext10;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("创建人")
    private String creater;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    @ApiModelProperty("修改人")
    private String updater;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderReturnNo() {
        return orderReturnNo;
    }

    public void setOrderReturnNo(String orderReturnNo) {
        this.orderReturnNo = orderReturnNo == null ? null : orderReturnNo.trim();
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getValidityPeriod() {
        return validityPeriod;
    }

    public void setValidityPeriod(Date validityPeriod) {
        this.validityPeriod = validityPeriod;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getTotalNums() {
        return totalNums;
    }

    public void setTotalNums(Integer totalNums) {
        this.totalNums = totalNums;
    }

    public BigDecimal getReturnPrice() {
        return returnPrice;
    }

    public void setReturnPrice(BigDecimal returnPrice) {
        this.returnPrice = returnPrice;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public BigDecimal getReturnTotalAmount() {
        return returnTotalAmount;
    }

    public void setReturnTotalAmount(BigDecimal returnTotalAmount) {
        this.returnTotalAmount = returnTotalAmount;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason == null ? null : returnReason.trim();
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4 == null ? null : ext4.trim();
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5 == null ? null : ext5.trim();
    }

    public String getExt6() {
        return ext6;
    }

    public void setExt6(String ext6) {
        this.ext6 = ext6 == null ? null : ext6.trim();
    }

    public String getExt7() {
        return ext7;
    }

    public void setExt7(String ext7) {
        this.ext7 = ext7 == null ? null : ext7.trim();
    }

    public String getExt8() {
        return ext8;
    }

    public void setExt8(String ext8) {
        this.ext8 = ext8 == null ? null : ext8.trim();
    }

    public String getExt9() {
        return ext9;
    }

    public void setExt9(String ext9) {
        this.ext9 = ext9 == null ? null : ext9.trim();
    }

    public String getExt10() {
        return ext10;
    }

    public void setExt10(String ext10) {
        this.ext10 = ext10 == null ? null : ext10.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }
}