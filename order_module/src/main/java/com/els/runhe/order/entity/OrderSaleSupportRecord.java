package com.els.runhe.order.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="销售支持汇款记录")
public class OrderSaleSupportRecord implements Serializable {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("经销商")
    private String purCompanyId;

    @ApiModelProperty("订单id")
    private String orderId;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("合同id")
    private String contractId;

    @ApiModelProperty("回款任务最小值")
    private BigDecimal refundMin;

    @ApiModelProperty("回款任务最大值")
    private BigDecimal refundMax;

    @ApiModelProperty("销售支持比率")
    private BigDecimal supportRate;

    @ApiModelProperty("订单支付金额")
    private BigDecimal orderAmountPay;

    @ApiModelProperty("销售支持")
    private BigDecimal refund;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("销售支持记录类型，增加额度(increase),减少额度(decrease)")
    private String type;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPurCompanyId() {
        return purCompanyId;
    }

    public void setPurCompanyId(String purCompanyId) {
        this.purCompanyId = purCompanyId == null ? null : purCompanyId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public BigDecimal getRefundMin() {
        return refundMin;
    }

    public void setRefundMin(BigDecimal refundMin) {
        this.refundMin = refundMin;
    }

    public BigDecimal getRefundMax() {
        return refundMax;
    }

    public void setRefundMax(BigDecimal refundMax) {
        this.refundMax = refundMax;
    }

    public BigDecimal getSupportRate() {
        return supportRate;
    }

    public void setSupportRate(BigDecimal supportRate) {
        this.supportRate = supportRate;
    }

    public BigDecimal getOrderAmountPay() {
        return orderAmountPay;
    }

    public void setOrderAmountPay(BigDecimal orderAmountPay) {
        this.orderAmountPay = orderAmountPay;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}