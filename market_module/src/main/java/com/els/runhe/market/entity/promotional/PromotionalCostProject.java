package com.els.runhe.market.entity.promotional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value="促销活动费用申请项目表")
public class PromotionalCostProject implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("促销活动费用申请单号")
    private String promotionalCostNo;

    @ApiModelProperty("类型(计划/实际)")
    private String type;

    @ApiModelProperty("项目行号")
    private String line;

    @ApiModelProperty("总计")
    private BigDecimal amountTotal;
    
    @ApiModelProperty("（代理商承担）费用（元）")
    private BigDecimal saleCost;

    @ApiModelProperty("（代理商承担）占比")
    private BigDecimal saleProport;

    @ApiModelProperty("代理商承担项目")
    private String saleProject;

    @ApiModelProperty("（代理商承担）金额")
    private BigDecimal saleAmount;

    @ApiModelProperty("（我司承担）费用")
    private BigDecimal ourCost;

    @ApiModelProperty("（我司承担）占比")
    private BigDecimal ourProport;

    @ApiModelProperty("我司承担项目")
    private String ourProject;

    @ApiModelProperty("（我司承担）金额")
    private BigDecimal ourAmount;

    @ApiModelProperty("附件ID")
    private String attaId;

    @ApiModelProperty("附件名称")
    private String attaName;

    @ApiModelProperty("附件URL")
    private String attaUrl;

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

    public String getPromotionalCostNo() {
        return promotionalCostNo;
    }

    public void setPromotionalCostNo(String promotionalCostNo) {
        this.promotionalCostNo = promotionalCostNo == null ? null : promotionalCostNo.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line == null ? null : line.trim();
    }

    public BigDecimal getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(BigDecimal amountTotal) {
		this.amountTotal = amountTotal;
	}

	public BigDecimal getSaleCost() {
        return saleCost;
    }

    public void setSaleCost(BigDecimal saleCost) {
        this.saleCost = saleCost;
    }

    public BigDecimal getSaleProport() {
        return saleProport;
    }

    public void setSaleProport(BigDecimal saleProport) {
        this.saleProport = saleProport;
    }

    public String getSaleProject() {
        return saleProject;
    }

    public void setSaleProject(String saleProject) {
        this.saleProject = saleProject == null ? null : saleProject.trim();
    }

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public BigDecimal getOurCost() {
        return ourCost;
    }

    public void setOurCost(BigDecimal ourCost) {
        this.ourCost = ourCost;
    }

    public BigDecimal getOurProport() {
        return ourProport;
    }

    public void setOurProport(BigDecimal ourProport) {
        this.ourProport = ourProport;
    }

    public String getOurProject() {
        return ourProject;
    }

    public void setOurProject(String ourProject) {
        this.ourProject = ourProject == null ? null : ourProject.trim();
    }

    public BigDecimal getOurAmount() {
        return ourAmount;
    }

    public void setOurAmount(BigDecimal ourAmount) {
        this.ourAmount = ourAmount;
    }

    public String getAttaId() {
        return attaId;
    }

    public void setAttaId(String attaId) {
        this.attaId = attaId == null ? null : attaId.trim();
    }

    public String getAttaName() {
        return attaName;
    }

    public void setAttaName(String attaName) {
        this.attaName = attaName == null ? null : attaName.trim();
    }

    public String getAttaUrl() {
        return attaUrl;
    }

    public void setAttaUrl(String attaUrl) {
        this.attaUrl = attaUrl == null ? null : attaUrl.trim();
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