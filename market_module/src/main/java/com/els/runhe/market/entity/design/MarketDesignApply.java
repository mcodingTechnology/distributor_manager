package com.els.runhe.market.entity.design;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="市场平面设计申请")
public class MarketDesignApply implements Serializable {
	
//	############后期添加的，请不要覆盖############
	@ApiModelProperty("设计资料信息")
	private List<MarketDesigned> designedList;
	
	public List<MarketDesigned> getDesignedList() {
		return designedList;
	}

	public void setDesignedList(List<MarketDesigned> designedList) {
		this.designedList = designedList;
	}
//	########################################
    @ApiModelProperty("主键id")
    private Integer id;
    
    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户名称")
    private String userName;
    
    @ApiModelProperty("申请单状态:0、待提交，1、待审批，2、待设计，3、已设计，4、已完成，5、作废")
    private Integer status;
    
    @ApiModelProperty("审批状态：100审批申请中，200审批通过,300审批不通过")
    private Integer approvalStatus;
    
    @ApiModelProperty("设计申请信息id")
    private String designApplyId;

    @ApiModelProperty("主题ID")
    private String themeId;

    @ApiModelProperty("主题")
    private String theme;

    @ApiModelProperty("委托单位")
    private String entrustCompany;

    @ApiModelProperty("委托人ID")
    private String entrustId;

    @ApiModelProperty("委托人")
    private String entrustName;

    @ApiModelProperty("联系电话")
    private String contactPhone;

    @ApiModelProperty("QQ")
    private String qq;

    @ApiModelProperty("下单时间")
    private String addTime;

    @ApiModelProperty("预计完成时间")
    private Date expectCompleteTime;

    @ApiModelProperty("设计内容描述")
    private String designDescription;

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

	public String getDesignApplyId() {
        return designApplyId;
    }

    public void setDesignApplyId(String designApplyId) {
        this.designApplyId = designApplyId == null ? null : designApplyId.trim();
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

    public String getEntrustCompany() {
        return entrustCompany;
    }

    public void setEntrustCompany(String entrustCompany) {
        this.entrustCompany = entrustCompany == null ? null : entrustCompany.trim();
    }

    public String getEntrustId() {
        return entrustId;
    }

    public void setEntrustId(String entrustId) {
        this.entrustId = entrustId == null ? null : entrustId.trim();
    }

    public String getEntrustName() {
        return entrustName;
    }

    public void setEntrustName(String entrustName) {
        this.entrustName = entrustName == null ? null : entrustName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime == null ? null : addTime.trim();
    }

    public Date getExpectCompleteTime() {
        return expectCompleteTime;
    }

    public void setExpectCompleteTime(Date expectCompleteTime) {
        this.expectCompleteTime = expectCompleteTime;
    }

    public String getDesignDescription() {
        return designDescription;
    }

    public void setDesignDescription(String designDescription) {
        this.designDescription = designDescription == null ? null : designDescription.trim();
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