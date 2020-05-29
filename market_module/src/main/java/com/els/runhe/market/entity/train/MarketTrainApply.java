package com.els.runhe.market.entity.train;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="培训申请信息表")
public class MarketTrainApply implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;
    
    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户名称")
    private String userName;
    
    @ApiModelProperty("培训申请单ID")
    private String trainApplyId;

    @ApiModelProperty("主题ID")
    private String themeId;

    @ApiModelProperty("主题")
    private String theme;

    @ApiModelProperty("申请人ID")
    private String applicantId;

    @ApiModelProperty("申请人")
    private String applicant;
    
    @ApiModelProperty("申请单状态:0、待提交，1、待审批，2、待培训，3、已培训，4、已完成，5、作废")
    private Integer status;
    
    @ApiModelProperty("审批状态：100审批申请中，200审批通过,300审批不通过")
    private Integer approvalStatus;

    @ApiModelProperty("类别ID")
    private String categoryId;

    @ApiModelProperty("类别：1、产品，2、技巧，3基本礼仪")
    private String category;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("培训人数")
    private Integer trainingNumber;

    @ApiModelProperty("连锁名称")
    private String chainName;

    @ApiModelProperty("代理商渠道")
    private String agentChannels;

    @ApiModelProperty("代理商ID")
    private String agentId;

    @ApiModelProperty("代理商")
    private String agents;

    @ApiModelProperty("培训联系人")
    private String trainContactName;

    @ApiModelProperty("联系电话")
    private String trainContactPhone;

    @ApiModelProperty("期望培训内容")
    private String expectTrainingContent;

    @ApiModelProperty("申请培训时间")
    private Date applyTrainTime;

    @ApiModelProperty("本年度已培训次数")
    private String trainingTimes;

    @ApiModelProperty("是否提供培训场地")
    private String whetherTrainingGround;

    @ApiModelProperty("具体地址")
    private String trainAddress;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("附件ID")
    private String attaId;

    @ApiModelProperty("附件名称")
    private String attaName;

    @ApiModelProperty("附件URL")
    private String attaUrl;

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
	
    public String getTrainApplyId() {
		return trainApplyId;
	}

	public void setTrainApplyId(String trainApplyId) {
		this.trainApplyId = trainApplyId == null ? null : trainApplyId.trim();
	}

	public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId == null ? null : themeId.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId == null ? null : applicantId.trim();
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant == null ? null : applicant.trim();
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

	public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Integer getTrainingNumber() {
        return trainingNumber;
    }

    public void setTrainingNumber(Integer trainingNumber) {
        this.trainingNumber = trainingNumber;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName == null ? null : chainName.trim();
    }

    public String getAgentChannels() {
        return agentChannels;
    }

    public void setAgentChannels(String agentChannels) {
        this.agentChannels = agentChannels == null ? null : agentChannels.trim();
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents == null ? null : agents.trim();
    }

    public String getTrainContactName() {
        return trainContactName;
    }

    public void setTrainContactName(String trainContactName) {
        this.trainContactName = trainContactName == null ? null : trainContactName.trim();
    }

    public String getTrainContactPhone() {
        return trainContactPhone;
    }

    public void setTrainContactPhone(String trainContactPhone) {
        this.trainContactPhone = trainContactPhone == null ? null : trainContactPhone.trim();
    }

    public String getExpectTrainingContent() {
        return expectTrainingContent;
    }

    public void setExpectTrainingContent(String expectTrainingContent) {
        this.expectTrainingContent = expectTrainingContent == null ? null : expectTrainingContent.trim();
    }

    public Date getApplyTrainTime() {
        return applyTrainTime;
    }

    public void setApplyTrainTime(Date applyTrainTime) {
        this.applyTrainTime = applyTrainTime;
    }

    public String getTrainingTimes() {
        return trainingTimes;
    }

    public void setTrainingTimes(String trainingTimes) {
        this.trainingTimes = trainingTimes == null ? null : trainingTimes.trim();
    }

    public String getWhetherTrainingGround() {
        return whetherTrainingGround;
    }

    public void setWhetherTrainingGround(String whetherTrainingGround) {
        this.whetherTrainingGround = whetherTrainingGround == null ? null : whetherTrainingGround.trim();
    }

    public String getTrainAddress() {
        return trainAddress;
    }

    public void setTrainAddress(String trainAddress) {
        this.trainAddress = trainAddress == null ? null : trainAddress.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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