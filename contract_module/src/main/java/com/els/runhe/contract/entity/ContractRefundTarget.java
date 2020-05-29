package com.els.runhe.contract.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="合同回款目标")
public class ContractRefundTarget implements Serializable {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("合同ID")
    private String contractId;

    @ApiModelProperty("年份")
    private Integer year;

    @ApiModelProperty("月份")
    private Integer month;

    @ApiModelProperty("年度回款目标(万元)")
    private Double yearRefundTarget;

    @ApiModelProperty("月度回款目标(万元)")
    private Double monthRefundTarget;

    @ApiModelProperty("月度回款比例(%)")
    private Double monthRefundProportion;
    
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getYearRefundTarget() {
        return yearRefundTarget;
    }

    public void setYearRefundTarget(Double yearRefundTarget) {
        this.yearRefundTarget = yearRefundTarget;
    }

    public Double getMonthRefundTarget() {
        return monthRefundTarget;
    }

    public void setMonthRefundTarget(Double monthRefundTarget) {
        this.monthRefundTarget = monthRefundTarget;
    }
    
    public Double getMonthRefundProportion() {
		return monthRefundProportion;
	}

	public void setMonthRefundProportion(Double monthRefundProportion) {
		this.monthRefundProportion = monthRefundProportion;
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