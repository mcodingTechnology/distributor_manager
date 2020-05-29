package com.els.runhe.order.entity;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.els.base.utils.SpringContextHolder;
import com.els.runhe.order.ruleengine.state.AbstractOrderState;
import com.els.runhe.order.ruleengine.state.StateFactory;
import com.els.runhe.order.service.OrderProductService;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="订单")
public class Order implements Serializable {
	
//	############################
	
	@ApiModelProperty("订单-销售支持额度信息")
	private SaleAndMarketSupport saleAndMarketSupport;
	
	@JsonIgnore
	@ApiModelProperty("订单行项目是否有初始化，设置值")
	private boolean isItemsInited = false;
	
	@ApiModelProperty("订单行项目")
	private List<OrderProduct> orderItems;
	
	public SaleAndMarketSupport getSaleAndMarketSupport() {
		return saleAndMarketSupport;
	}

	public void setSaleAndMarketSupport(SaleAndMarketSupport saleAndMarketSupport) {
		this.saleAndMarketSupport = saleAndMarketSupport;
	}

	public List<OrderProduct> getOrderItems() {
    	if (!isItemsInited
    			&& StringUtils.isNotBlank(this.getId())) {
	    	this.orderItems = SpringContextHolder.getOneBean(OrderProductService.class).queryByOrderId(this.getId());
		}
    	
		return orderItems;
	}

	public void setOrderItems(List<OrderProduct> orderItems) {
		isItemsInited = true;
		this.orderItems = orderItems;
	}
	
	@JsonIgnore
	public List<AbstractOrderState> getStateList() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, IOException{
		return StateFactory.buildStates(this);
	}
	
//	############################

	@ApiModelProperty("订单id")
    private String id;

    @ApiModelProperty("要货的经销商id")
    private String purCompanyId;

    @ApiModelProperty("要货的经销商名")
    private String purCompanyName;

    @ApiModelProperty("客户采购订单号")
    private String purchaseOrderNo;

    @ApiModelProperty("下单用户id")
    private String userId;

    @ApiModelProperty("下单用户名称")
    private String userName;

    @ApiModelProperty("下单时间")
    private Date addTime;

    @ApiModelProperty("供货方id")
    private String supCompanyId;

    @ApiModelProperty("供货方名称")
    private String supCompanyName;

    @ApiModelProperty("订单联系人id")
    private String orderUserId;

    @ApiModelProperty("订单联系人")
    private String orderUserName;

    @ApiModelProperty("订单电话")
    private String orderUserPhone;

    @ApiModelProperty("订单编号")
    private String orderNo;

    @ApiModelProperty("第三方交易流水号 如：微信支付流水号")
    private String tradeNo;

    @ApiModelProperty("订单类型 0.微商城默认订单 1.积分商城兑换订单 2.积分翻牌中奖订单")
    private Integer type;

    @ApiModelProperty("场景值，metrxmall 微商城，metrxgiftmall 积分商城")
    private String sceneCode;

    @ApiModelProperty("订单状态, 100待提交，200待支付,600已取消,700已支付")
    private Integer status;

    @ApiModelProperty("发货状态， 300待发货, 400待收货，500已完成收货")
    private Integer deliveryStatus;

    @ApiModelProperty("审批状态：100审批申请中，150 运维人员审核通过, 200审批通过，300审批不通过")
    private Integer approvalStatus;

    @ApiModelProperty("审批结束时间")
    private Date approvalTime;

    @ApiModelProperty("商品总数量")
    private Integer nums;

    @ApiModelProperty("结算方式：电汇TELE TRANSFER,转账ACOUNT_TRANSFER")
    private String payType;

    @ApiModelProperty("税率")
    private BigDecimal tax;

    @ApiModelProperty("订单总金额")
    private BigDecimal amountTotal;

    @ApiModelProperty("支付金额")
    private BigDecimal amountPay;

    @ApiModelProperty("减免金额")
    private BigDecimal amountReduce;

    @ApiModelProperty("优惠规则匹配减免金额")
    private BigDecimal amountPreferential;

    @ApiModelProperty("支付时间")
    private Date payTime;

    @ApiModelProperty("交货方式:1货运，2快递")
    private Integer deliveryType;

    @ApiModelProperty("快递名称")
    private String deliveryName;

    @ApiModelProperty("快递单号")
    private String deliveryCode;

    @ApiModelProperty("发货优先级:1低，2中，3高")
    private Integer deliveryPriority;

    @ApiModelProperty("快递费")
    private Integer freight;

    @ApiModelProperty("收货地址ID")
    private Integer addressId;

    @ApiModelProperty("收货手机号码")
    private String addressPhone;

    @ApiModelProperty("收货人姓名")
    private String addressReveiver;

    @ApiModelProperty("收货地址所在省市县地区信息")
    private String addressRegson;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("预计收货时间")
    private Date presetReceiverTime;

    @ApiModelProperty("发货时间")
    private Date deliveryTime;

    @ApiModelProperty("确认收货时间")
    private Date receiveTime;

    @ApiModelProperty("退换货和退款状态，0表示无申请，1退款，2退换货")
    private Integer returnStatus;

    @ApiModelProperty("退款时间")
    private Date returnTime;

    @ApiModelProperty("订单备注")
    private String remark;

    @ApiModelProperty("区域")
    private String area;

    @ApiModelProperty("合同编码")
    private String contractNo;

    @ApiModelProperty("使用销售支持额度")
    private BigDecimal applySaleSupport;

    @ApiModelProperty("使用市场支持额度")
    private BigDecimal applyMarketSupport;

    @ApiModelProperty("税费")
    private Integer amountTax;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getPurchaseOrderNo() {
        return purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo == null ? null : purchaseOrderNo.trim();
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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

    public String getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(String orderUserId) {
        this.orderUserId = orderUserId == null ? null : orderUserId.trim();
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName == null ? null : orderUserName.trim();
    }

    public String getOrderUserPhone() {
        return orderUserPhone;
    }

    public void setOrderUserPhone(String orderUserPhone) {
        this.orderUserPhone = orderUserPhone == null ? null : orderUserPhone.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSceneCode() {
        return sceneCode;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode == null ? null : sceneCode.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Date getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Date approvalTime) {
        this.approvalTime = approvalTime;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getAmountTotal() {
        return amountTotal;
    }

    public void setAmountTotal(BigDecimal amountTotal) {
        this.amountTotal = amountTotal;
    }

    public BigDecimal getAmountPay() {
        return amountPay;
    }

    public void setAmountPay(BigDecimal amountPay) {
        this.amountPay = amountPay;
    }

    public BigDecimal getAmountReduce() {
        return amountReduce;
    }

    public void setAmountReduce(BigDecimal amountReduce) {
        this.amountReduce = amountReduce;
    }

    public BigDecimal getAmountPreferential() {
        return amountPreferential;
    }

    public void setAmountPreferential(BigDecimal amountPreferential) {
        this.amountPreferential = amountPreferential;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName == null ? null : deliveryName.trim();
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode == null ? null : deliveryCode.trim();
    }

    public Integer getDeliveryPriority() {
        return deliveryPriority;
    }

    public void setDeliveryPriority(Integer deliveryPriority) {
        this.deliveryPriority = deliveryPriority;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone == null ? null : addressPhone.trim();
    }

    public String getAddressReveiver() {
        return addressReveiver;
    }

    public void setAddressReveiver(String addressReveiver) {
        this.addressReveiver = addressReveiver == null ? null : addressReveiver.trim();
    }

    public String getAddressRegson() {
        return addressRegson;
    }

    public void setAddressRegson(String addressRegson) {
        this.addressRegson = addressRegson == null ? null : addressRegson.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getPresetReceiverTime() {
        return presetReceiverTime;
    }

    public void setPresetReceiverTime(Date presetReceiverTime) {
        this.presetReceiverTime = presetReceiverTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Integer getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    public BigDecimal getApplySaleSupport() {
        return applySaleSupport;
    }

    public void setApplySaleSupport(BigDecimal applySaleSupport) {
        this.applySaleSupport = applySaleSupport;
    }

    public BigDecimal getApplyMarketSupport() {
        return applyMarketSupport;
    }

    public void setApplyMarketSupport(BigDecimal applyMarketSupport) {
        this.applyMarketSupport = applyMarketSupport;
    }

    public Integer getAmountTax() {
        return amountTax;
    }

    public void setAmountTax(Integer amountTax) {
        this.amountTax = amountTax;
    }
}