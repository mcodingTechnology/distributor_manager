package com.els.runhe.contract.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="合同销售支持")
public class ContractSaleSupport implements Serializable {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("合同ID")
    private String contractId;

    @ApiModelProperty("序号")
    private Integer serialNum;

    @ApiModelProperty("回款任务(万元)最小值(大于)")
    private Double refundMin;

    @ApiModelProperty("回款任务(万元)最大值(小于等于)")
    private Double refundMax;

    @ApiModelProperty("销售支持比率")
    private Double supportRate;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("是否启用：1启用，0禁用")
    private Integer isEnable;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Double getRefundMin() {
        return refundMin;
    }

    public void setRefundMin(Double refundMin) {
        this.refundMin = refundMin;
    }

    public Double getRefundMax() {
        return refundMax;
    }

    public void setRefundMax(Double refundMax) {
        this.refundMax = refundMax;
    }

    public Double getSupportRate() {
        return supportRate;
    }

    public void setSupportRate(Double supportRate) {
        this.supportRate = supportRate;
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

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }
}