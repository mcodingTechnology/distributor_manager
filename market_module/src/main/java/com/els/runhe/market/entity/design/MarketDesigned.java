package com.els.runhe.market.entity.design;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="设计资料")
public class MarketDesigned implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("设计申请信息id")
    private String designApplyId;

    @ApiModelProperty("图片名称")
    private String designImgName;

    @ApiModelProperty("图片地址")
    private String designImgUrl;

    @ApiModelProperty("图片类型")
    private String designImgType;

    @ApiModelProperty("数量")
    private Integer designNumber;

    @ApiModelProperty("备注")
    private String remark;

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

    public String getDesignApplyId() {
        return designApplyId;
    }

    public void setDesignApplyId(String designApplyId) {
        this.designApplyId = designApplyId == null ? null : designApplyId.trim();
    }

    public String getDesignImgName() {
        return designImgName;
    }

    public void setDesignImgName(String designImgName) {
        this.designImgName = designImgName == null ? null : designImgName.trim();
    }

    public String getDesignImgUrl() {
        return designImgUrl;
    }

    public void setDesignImgUrl(String designImgUrl) {
        this.designImgUrl = designImgUrl == null ? null : designImgUrl.trim();
    }

    public String getDesignImgType() {
        return designImgType;
    }

    public void setDesignImgType(String designImgType) {
        this.designImgType = designImgType == null ? null : designImgType.trim();
    }

    public Integer getDesignNumber() {
        return designNumber;
    }

    public void setDesignNumber(Integer designNumber) {
        this.designNumber = designNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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