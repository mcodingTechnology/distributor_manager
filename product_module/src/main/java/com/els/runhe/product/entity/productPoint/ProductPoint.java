package com.els.runhe.product.entity.productPoint;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="产品积分")
public class ProductPoint implements Serializable {

    //############以下是后期添加的，请不要覆盖########
    @ApiModelProperty("加钱购价格")
    private Integer plusPrice;

    @ApiModelProperty("加钱购价格ID")
    private Integer priceId;

    public Integer getPriceId() {
        return priceId;
    }

    public void setPriceId(Integer priceId) {
        this.priceId = priceId;
    }

    public Integer getPlusPrice() {
        return plusPrice;
    }

    public void setPlusPrice(Integer plusPrice) {
        this.plusPrice = plusPrice;
    }
    //####################

    private Integer id;

    @ApiModelProperty("产品ID")
    private Integer productId;

    @ApiModelProperty("产品获得的积分")
    private Integer productEarnPoint;

    @ApiModelProperty("全额兑换积分")
    private Integer exchangePoint;

    @ApiModelProperty("加钱购积分")
    private Integer plusPricePoint;

    @ApiModelProperty("创建时间")
    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

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

    public Integer getProductEarnPoint() {
        return productEarnPoint;
    }

    public void setProductEarnPoint(Integer productEarnPoint) {
        this.productEarnPoint = productEarnPoint;
    }

    public Integer getExchangePoint() {
        return exchangePoint;
    }

    public void setExchangePoint(Integer exchangePoint) {
        this.exchangePoint = exchangePoint;
    }

    public Integer getPlusPricePoint() {
        return plusPricePoint;
    }

    public void setPlusPricePoint(Integer plusPricePoint) {
        this.plusPricePoint = plusPricePoint;
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
}