package com.els.runhe.region.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="地区")
public class Region implements Serializable {
    private Integer id;

    private Integer parentId;

    private String regionName;

    private Boolean regionType;

    private Short agencyId;

    private String regionSn;

    @ApiModelProperty("是否系统内建")
    private Boolean buildin;

    private Date lastchanged;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Boolean getRegionType() {
        return regionType;
    }

    public void setRegionType(Boolean regionType) {
        this.regionType = regionType;
    }

    public Short getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
    }

    public String getRegionSn() {
        return regionSn;
    }

    public void setRegionSn(String regionSn) {
        this.regionSn = regionSn == null ? null : regionSn.trim();
    }

    public Boolean getBuildin() {
        return buildin;
    }

    public void setBuildin(Boolean buildin) {
        this.buildin = buildin;
    }

    public Date getLastchanged() {
        return lastchanged;
    }

    public void setLastchanged(Date lastchanged) {
        this.lastchanged = lastchanged;
    }
}