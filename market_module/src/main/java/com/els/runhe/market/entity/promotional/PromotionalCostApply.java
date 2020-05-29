package com.els.runhe.market.entity.promotional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(value="促销活动费用申请表")
public class PromotionalCostApply implements Serializable {
	
//	############后期添加的，请不要覆盖############
	@ApiModelProperty("促销活动费用申请项目信息")
	private List<PromotionalCostProject> costProjectList;
	
	public List<PromotionalCostProject> getCostProjectList() {
		return costProjectList;
	}

	public void setCostProjectList(List<PromotionalCostProject> costProjectList) {
		this.costProjectList = costProjectList;
	}
	//	########################################
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("促销活动费用申请单号")
    private String promotionalCostNo;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("申请单状态:0、新建，1、待运营人员审批，2、待财务人员审批，3、待培训，4、已培训")
    private Integer status;

    @ApiModelProperty("审批状态：100审批申请中，200审批通过，300审批不通过")
    private Integer approvalStatus;

    @ApiModelProperty("大区")
    private String district;

    @ApiModelProperty("省份")
    private String province;

    @ApiModelProperty("地级城市")
    private String city;

    @ApiModelProperty("区域")
    private String area;

    @ApiModelProperty("区域负责人")
    private String areaManager;

    @ApiModelProperty("代理商")
    private String agents;

    @ApiModelProperty("联系方式")
    private String contact;
    
    @ApiModelProperty("费用类型")
    private String costType;

    @ApiModelProperty("连锁名称")
    private String chainName;

    @ApiModelProperty("门店总数")
    private Integer storeNums;

    @ApiModelProperty("参与活动门店数")
    private Integer joinStoreNums;

    @ApiModelProperty("门店参与率")
    private Integer joinRate;

    @ApiModelProperty("第一竞品")
    private String firstCompeteGoods;

    @ApiModelProperty("我司产品品类排名")
    private String categoryRank;

    @ApiModelProperty("前三月月均销售额（元）")
    private BigDecimal sales;

    @ApiModelProperty("计划活动开始时间")
    private Date planStartTime;

    @ApiModelProperty("计划活动结束时间")
    private Date planEndTime;

    @ApiModelProperty("计划活动开展天数")
    private Integer planDays;

    @ApiModelProperty("实际活动开始时间")
    private Date actualStartTime;

    @ApiModelProperty("实际活动结束时间")
    private Date actualEndTime;

    @ApiModelProperty("实际活动开展天数")
    private Integer actualDays;

    @ApiModelProperty("计划销售目标（元）")
    private BigDecimal planSaleTarget;

    @ApiModelProperty("计划活动费用（元）")
    private BigDecimal planActivityCost;

    @ApiModelProperty("计划活动费比")
    private String planActivityProport;

    @ApiModelProperty("实际销售达成（元）")
    private BigDecimal actualSaleTarget;

    @ApiModelProperty("实际活动费用（元）")
    private BigDecimal actualActivityCost;

    @ApiModelProperty("实际活动费比")
    private String actualActivityProport;
    
    @ApiModelProperty("销售目标完成率(%)")
    private BigDecimal targetCompleteRate;

    @ApiModelProperty("活动费用使用率(%)")
    private BigDecimal costUsage;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAreaManager() {
        return areaManager;
    }

    public void setAreaManager(String areaManager) {
        this.areaManager = areaManager == null ? null : areaManager.trim();
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents == null ? null : agents.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }
    
    public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType == null ? null : costType.trim();
	}

	public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName == null ? null : chainName.trim();
    }

    public Integer getStoreNums() {
        return storeNums;
    }

    public void setStoreNums(Integer storeNums) {
        this.storeNums = storeNums;
    }

    public Integer getJoinStoreNums() {
        return joinStoreNums;
    }

    public void setJoinStoreNums(Integer joinStoreNums) {
        this.joinStoreNums = joinStoreNums;
    }

    public Integer getJoinRate() {
        return joinRate;
    }

    public void setJoinRate(Integer joinRate) {
        this.joinRate = joinRate;
    }

    public String getFirstCompeteGoods() {
        return firstCompeteGoods;
    }

    public void setFirstCompeteGoods(String firstCompeteGoods) {
        this.firstCompeteGoods = firstCompeteGoods == null ? null : firstCompeteGoods.trim();
    }

    public String getCategoryRank() {
        return categoryRank;
    }

    public void setCategoryRank(String categoryRank) {
        this.categoryRank = categoryRank == null ? null : categoryRank.trim();
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    public Integer getPlanDays() {
        return planDays;
    }

    public void setPlanDays(Integer planDays) {
        this.planDays = planDays;
    }

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public Integer getActualDays() {
        return actualDays;
    }

    public void setActualDays(Integer actualDays) {
        this.actualDays = actualDays;
    }

    public BigDecimal getPlanSaleTarget() {
        return planSaleTarget;
    }

    public void setPlanSaleTarget(BigDecimal planSaleTarget) {
        this.planSaleTarget = planSaleTarget;
    }

    public BigDecimal getPlanActivityCost() {
        return planActivityCost;
    }

    public void setPlanActivityCost(BigDecimal planActivityCost) {
        this.planActivityCost = planActivityCost;
    }

    public String getPlanActivityProport() {
        return planActivityProport;
    }

    public void setPlanActivityProport(String planActivityProport) {
        this.planActivityProport = planActivityProport == null ? null : planActivityProport.trim();
    }

    public BigDecimal getActualSaleTarget() {
        return actualSaleTarget;
    }

    public void setActualSaleTarget(BigDecimal actualSaleTarget) {
        this.actualSaleTarget = actualSaleTarget;
    }

    public BigDecimal getActualActivityCost() {
        return actualActivityCost;
    }

    public void setActualActivityCost(BigDecimal actualActivityCost) {
        this.actualActivityCost = actualActivityCost;
    }

    public String getActualActivityProport() {
        return actualActivityProport;
    }

    public void setActualActivityProport(String actualActivityProport) {
        this.actualActivityProport = actualActivityProport == null ? null : actualActivityProport.trim();
    }
    
    public BigDecimal getTargetCompleteRate() {
		return targetCompleteRate;
	}

	public void setTargetCompleteRate(BigDecimal targetCompleteRate) {
		this.targetCompleteRate = targetCompleteRate;
	}

	public BigDecimal getCostUsage() {
		return costUsage;
	}

	public void setCostUsage(BigDecimal costUsage) {
		this.costUsage = costUsage;
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