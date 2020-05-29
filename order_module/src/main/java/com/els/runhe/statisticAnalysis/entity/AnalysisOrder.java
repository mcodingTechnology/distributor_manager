package com.els.runhe.statisticAnalysis.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="对账单")
public class AnalysisOrder implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("要货经销商id")
    private String companyId;

    @ApiModelProperty("要货经销商名称")
    private String companyName;

    @ApiModelProperty("总金额")
    private BigDecimal amountTotal;
    
    @ApiModelProperty("待提交总金额")
    private BigDecimal noSubmitTotal;
    
    @ApiModelProperty("取消总金额")
    private BigDecimal cancelSubmitTotal;
    
    @ApiModelProperty("待支付总金额")
    private BigDecimal noPayTotal;
    
    @ApiModelProperty("拒绝总金额")
    private BigDecimal refusedTotal;
    
    @ApiModelProperty("代审批总金额")
    private BigDecimal noApprovalTotal;
    
    @ApiModelProperty("已付")
    private BigDecimal paid;

    @ApiModelProperty("未付")
    private BigDecimal unpaid;

    @ApiModelProperty("审核状态， 100待审核、200通过、300拒绝")
    private Integer auditStates;

    @ApiModelProperty("对账状态 ， 400待对账、500已对账")
    private Integer accountBillStates;
    
    @ApiModelProperty("账单年月")
    private String orderTime;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getNoSubmitTotal() {
		return noSubmitTotal;
	}

	public void setNoSubmitTotal(BigDecimal noSubmitTotal) {
		this.noSubmitTotal = noSubmitTotal;
	}

	public BigDecimal getCancelSubmitTotal() {
		return cancelSubmitTotal;
	}

	public void setCancelSubmitTotal(BigDecimal cancelSubmitTotal) {
		this.cancelSubmitTotal = cancelSubmitTotal;
	}

	public BigDecimal getNoPayTotal() {
		return noPayTotal;
	}

	public void setNoPayTotal(BigDecimal noPayTotal) {
		this.noPayTotal = noPayTotal;
	}

	public BigDecimal getRefusedTotal() {
		return refusedTotal;
	}

	public void setRefusedTotal(BigDecimal refusedTotal) {
		this.refusedTotal = refusedTotal;
	}

	public BigDecimal getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(BigDecimal amountTotal) {
        this.amountTotal = amountTotal;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public BigDecimal getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(BigDecimal unpaid) {
        this.unpaid = unpaid;
    }

    public Integer getAuditStates() {
        return auditStates;
    }

    public void setAuditStates(Integer auditStates) {
        this.auditStates = auditStates;
    }

    public Integer getAccountBillStates() {
        return accountBillStates;
    }

    public void setAccountBillStates(Integer accountBillStates) {
        this.accountBillStates = accountBillStates;
    }

    public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
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

	public BigDecimal getNoApprovalTotal() {
		return noApprovalTotal;
	}

	public void setNoApprovalTotal(BigDecimal noApprovalTotal) {
		this.noApprovalTotal = noApprovalTotal;
	}
    
}