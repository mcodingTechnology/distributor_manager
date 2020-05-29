package com.els.runhe.returned.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.els.runhe.order.entity.SaleAndMarketSupport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="退货单")
public class OrderReturn implements Serializable {
	
//	############################
	@ApiModelProperty("订单-销售支持额度信息")
	private SaleAndMarketSupport saleAndMarketSupport;
	
	public SaleAndMarketSupport getSaleAndMarketSupport() {
		return saleAndMarketSupport;
	}

	public void setSaleAndMarketSupport(SaleAndMarketSupport saleAndMarketSupport) {
		this.saleAndMarketSupport = saleAndMarketSupport;
	}

	@ApiModelProperty("结算方式1")
    private String payType;

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	@ApiModelProperty("订单-销售支持额度信息")
	private BigDecimal applyMarketSupport;
	
	public BigDecimal getApplyMarketSupport() {
		return applyMarketSupport;
	}

	public void setApplyMarketSupport(BigDecimal applyMarketSupport) {
		this.applyMarketSupport = applyMarketSupport;
	}

	@ApiModelProperty("退货单行项目")
	private List<OrderReturnProducts> orderReturnItems;
	
	public List<OrderReturnProducts> getOrderReturnItems() {
		return orderReturnItems;
	}

	public void setOrderReturnItems(List<OrderReturnProducts> orderReturnItems) {
		this.orderReturnItems = orderReturnItems;
	}
    
//	############################
	
    @ApiModelProperty("主键id")
    private Integer id;

    @ApiModelProperty("下单用户id")
    private String userId;

    @ApiModelProperty("下单用户名称")
    private String userName;

    @ApiModelProperty("（退货）订单编号")
    private String orderReturnNo;

    @ApiModelProperty("订单时间")
    private Date orderTime;

    @ApiModelProperty("退货单状态:0、待提交，1、待确认，2、待发货，3、待收货，4、已完成，5、已取消")
    private Integer orderReturnStatus;
    
    @ApiModelProperty("审批状态：100审批申请中，200审批通过,300审批不通过")
    private Integer approvalStatus;

    @ApiModelProperty("要货的经销商id")
    private String purCompanyId;

    @ApiModelProperty("要货的经销商名")
    private String purCompanyName;

    @ApiModelProperty("供货方id")
    private String supCompanyId;

    @ApiModelProperty("供货方名称")
    private String supCompanyName;

    @ApiModelProperty("单据日期")
    private Date addTime;

    @ApiModelProperty("收货人姓名")
    private String addressReveiver;

    @ApiModelProperty("收货联系电话")
    private String addressPhone;

    @ApiModelProperty("收货地址")
    private String address;
    
    @ApiModelProperty("物流单号")
    private String logisticsNo;

    @ApiModelProperty("订单联系人")
    private String orderReturnUserName;

    @ApiModelProperty("订单电话")
    private String orderReturnPhone;

    @ApiModelProperty("客户采购单号")
    private String purchaseOrderNo;

    @ApiModelProperty("选择合同")
    private String optionContract;

    @ApiModelProperty("合同编码")
    private String contractNo;

    @ApiModelProperty("订单备注")
    private String orderRemark;

    @ApiModelProperty("发货优先级:1低，2中，3高")
    private Integer deliveryPriority;

    @ApiModelProperty("退货订单类型")
    private String returnOrderType;

    @ApiModelProperty("税率%")
    private BigDecimal tax;

    @ApiModelProperty("区域")
    private String area;

    @ApiModelProperty("结算方式")
    private String paytype;

    @ApiModelProperty("交货方式:1货运，2快递")
    private Integer deliveryType;

    @ApiModelProperty("生产流水号")
    private String productionNo;

    @ApiModelProperty("总数量（汇总数量）")
    private Integer nums;

    @ApiModelProperty("总金额（汇总金额）")
    private BigDecimal amountTotal;

    @ApiModelProperty("折让部分退款金额")
    private BigDecimal amountReduce;

    @ApiModelProperty("应退金额")
    private BigDecimal amountPay;

    @ApiModelProperty("支付时间")
    private Date payTime;

    @ApiModelProperty("预计退货时间")
    private Date presetReturnTime;

    @ApiModelProperty("退货原因")
    private String returnReason;
    
    @ApiModelProperty("审核通过时间")
    private Date auditTime;

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

    @ApiModelProperty("备用字段11")
    private String ext11;

    @ApiModelProperty("备用字段12")
    private String ext12;

    @ApiModelProperty("备用字段13")
    private String ext13;

    @ApiModelProperty("备用字段14")
    private String ext14;

    @ApiModelProperty("备用字段15")
    private String ext15;

    @ApiModelProperty("备用字段16")
    private String ext16;

    @ApiModelProperty("备用字段17")
    private String ext17;

    @ApiModelProperty("备用字段18")
    private String ext18;

    @ApiModelProperty("备用字段19")
    private String ext19;

    @ApiModelProperty("备用字段20")
    private String ext20;

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

    public String getOrderReturnNo() {
        return orderReturnNo;
    }

    public void setOrderReturnNo(String orderReturnNo) {
        this.orderReturnNo = orderReturnNo == null ? null : orderReturnNo.trim();
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getOrderReturnStatus() {
        return orderReturnStatus;
    }

    public void setOrderReturnStatus(Integer orderReturnStatus) {
        this.orderReturnStatus = orderReturnStatus;
    }
    
    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getPurCompanyId() {
        return purCompanyId;
    }

    public void setPurCompanyId(String purCompanyId) {
        this.purCompanyId = purCompanyId == null ? null : purCompanyId.trim();
    }

    public String getPurCompanyName() {
        return purCompanyName;
    }

    public void setPurCompanyName(String purCompanyName) {
        this.purCompanyName = purCompanyName == null ? null : purCompanyName.trim();
    }

    public String getSupCompanyId() {
        return supCompanyId;
    }

    public void setSupCompanyId(String supCompanyId) {
        this.supCompanyId = supCompanyId == null ? null : supCompanyId.trim();
    }

    public String getSupCompanyName() {
        return supCompanyName;
    }

    public void setSupCompanyName(String supCompanyName) {
        this.supCompanyName = supCompanyName == null ? null : supCompanyName.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddressReveiver() {
        return addressReveiver;
    }

    public void setAddressReveiver(String addressReveiver) {
        this.addressReveiver = addressReveiver == null ? null : addressReveiver.trim();
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone == null ? null : addressPhone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    
    public String getLogisticsNo() {
		return logisticsNo;
	}

	public void setLogisticsNo(String logisticsNo) {
		this.logisticsNo = logisticsNo == null ? null : logisticsNo.trim();
	}

	public String getOrderReturnUserName() {
        return orderReturnUserName;
    }

    public void setOrderReturnUserName(String orderReturnUserName) {
        this.orderReturnUserName = orderReturnUserName == null ? null : orderReturnUserName.trim();
    }

    public String getOrderReturnPhone() {
        return orderReturnPhone;
    }

    public void setOrderReturnPhone(String orderReturnPhone) {
        this.orderReturnPhone = orderReturnPhone == null ? null : orderReturnPhone.trim();
    }

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo == null ? null : purchaseOrderNo.trim();
    }

    public String getOptionContract() {
        return optionContract;
    }

    public void setOptionContract(String optionContract) {
        this.optionContract = optionContract == null ? null : optionContract.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public Integer getDeliveryPriority() {
        return deliveryPriority;
    }

    public void setDeliveryPriority(Integer deliveryPriority) {
        this.deliveryPriority = deliveryPriority;
    }

    public String getReturnOrderType() {
        return returnOrderType;
    }

    public void setReturnOrderType(String returnOrderType) {
        this.returnOrderType = returnOrderType == null ? null : returnOrderType.trim();
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getProductionNo() {
        return productionNo;
    }

    public void setProductionNo(String productionNo) {
        this.productionNo = productionNo == null ? null : productionNo.trim();
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public BigDecimal getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(BigDecimal amountTotal) {
        this.amountTotal = amountTotal;
    }

    public BigDecimal getAmountReduce() {
        return amountReduce;
    }

    public void setAmountReduce(BigDecimal amountReduce) {
        this.amountReduce = amountReduce;
    }

    public BigDecimal getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(BigDecimal amountPay) {
        this.amountPay = amountPay;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getPresetReturnTime() {
        return presetReturnTime;
    }

    public void setPresetReturnTime(Date presetReturnTime) {
        this.presetReturnTime = presetReturnTime;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason == null ? null : returnReason.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
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

    public String getExt11() {
        return ext11;
    }

    public void setExt11(String ext11) {
        this.ext11 = ext11 == null ? null : ext11.trim();
    }

    public String getExt12() {
        return ext12;
    }

    public void setExt12(String ext12) {
        this.ext12 = ext12 == null ? null : ext12.trim();
    }

    public String getExt13() {
        return ext13;
    }

    public void setExt13(String ext13) {
        this.ext13 = ext13 == null ? null : ext13.trim();
    }

    public String getExt14() {
        return ext14;
    }

    public void setExt14(String ext14) {
        this.ext14 = ext14 == null ? null : ext14.trim();
    }

    public String getExt15() {
        return ext15;
    }

    public void setExt15(String ext15) {
        this.ext15 = ext15 == null ? null : ext15.trim();
    }

    public String getExt16() {
        return ext16;
    }

    public void setExt16(String ext16) {
        this.ext16 = ext16 == null ? null : ext16.trim();
    }

    public String getExt17() {
        return ext17;
    }

    public void setExt17(String ext17) {
        this.ext17 = ext17 == null ? null : ext17.trim();
    }

    public String getExt18() {
        return ext18;
    }

    public void setExt18(String ext18) {
        this.ext18 = ext18 == null ? null : ext18.trim();
    }

    public String getExt19() {
        return ext19;
    }

    public void setExt19(String ext19) {
        this.ext19 = ext19 == null ? null : ext19.trim();
    }

    public String getExt20() {
        return ext20;
    }

    public void setExt20(String ext20) {
        this.ext20 = ext20 == null ? null : ext20.trim();
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