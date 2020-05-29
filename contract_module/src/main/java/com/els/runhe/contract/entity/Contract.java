package com.els.runhe.contract.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value="合同")
public class Contract implements Serializable {
    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("合同名称")
    private String contractName;

    @ApiModelProperty("合同编号")
    private String contractNum;

    @ApiModelProperty("签署日期")
    private Date signDate;

    @ApiModelProperty("开始日期")
    private Date startDate;

    @ApiModelProperty("结束日期")
    private Date endDate;

    @ApiModelProperty("状态：submit已提交、valid生效、invalid作废")
    private String status;

    @ApiModelProperty("签署地")
    private String signAddr;

    @ApiModelProperty("甲方ID")
    private String partyAId;

    @ApiModelProperty("甲方")
    private String partyA;

    @ApiModelProperty("乙方ID")
    private String partyBId;

    @ApiModelProperty("乙方")
    private String partyB;

    @ApiModelProperty("销售区域省")
    private String saleProvince;

    @ApiModelProperty("销售区域市")
    private String saleCity;

    @ApiModelProperty("销售区域县(区)")
    private String saleDistrict;

    @ApiModelProperty("销售区域省编码")
    private String saleProvinceCode;

    @ApiModelProperty("销售区域市编码")
    private String saleCityCode;

    @ApiModelProperty("销售区域县(区)编码")
    private String saleDistrictCode;

    @ApiModelProperty("销售渠道：ds药店、cs化妆品店、mbs母婴用品店")
    private String saleChannel;

    @ApiModelProperty("年度回款目标(万元)")
    private Double yearRefundTarget;

    @ApiModelProperty("首笔货款金额(万元)")
    private Double firstPayAmount;

    @ApiModelProperty("首笔收款日期")
    private Date firstReceiptDate;

    @ApiModelProperty("每批次订货金额(万元)")
    private Double perOrderAmount;

    @ApiModelProperty("货款：pbd款到发货、cod货到付款")
    private String goodsPayment;

    @ApiModelProperty("货款支付方式：TA转账、TT电汇")
    private String payType;

    @ApiModelProperty("收款单位ID")
    private String payeeId;

    @ApiModelProperty("收款单位名称")
    private String payeeName;

    @ApiModelProperty("银行类型")
    private String bankType;

    @ApiModelProperty("银行名称")
    private String bankName;

    @ApiModelProperty("银行账号")
    private String bankAccount;

    @ApiModelProperty("合同发货地址")
    private String deliveryAddress;

    @ApiModelProperty("合同收货地址")
    private String receiveAddress;

    @ApiModelProperty("收货人姓名")
    private String receiveName;

    @ApiModelProperty("收货人电话")
    private String receivePhone;

    @ApiModelProperty("违约金第一次（元）")
    private Integer firstPenalty;

    @ApiModelProperty("违约金第二次或以上（元）")
    private Integer secondPenalty;

    @ApiModelProperty("市场推广费用比率")
    private Double marketExpenseRate;

    @ApiModelProperty("退、换货地址")
    private String refundExchangeAddress;

    @ApiModelProperty("退、换货收货人姓名")
    private String refundExchangeName;

    @ApiModelProperty("退、换货收货人电话")
    private String refundExchangePhone;

    @ApiModelProperty("退、换货额度为本年总回款额的占比，在这个比率内可免费")
    private Double refundExchangeLimitRate;

    @ApiModelProperty("退、换货额度超出本年发货总额的占比")
    private Double refundExchangeExceedRate;

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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getContractNum() {
        return contractNum;
    }

    public void setContractNum(String contractNum) {
        this.contractNum = contractNum == null ? null : contractNum.trim();
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSignAddr() {
        return signAddr;
    }

    public void setSignAddr(String signAddr) {
        this.signAddr = signAddr == null ? null : signAddr.trim();
    }

    public String getPartyAId() {
        return partyAId;
    }

    public void setPartyAId(String partyAId) {
        this.partyAId = partyAId == null ? null : partyAId.trim();
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA == null ? null : partyA.trim();
    }

    public String getPartyBId() {
        return partyBId;
    }

    public void setPartyBId(String partyBId) {
        this.partyBId = partyBId == null ? null : partyBId.trim();
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB == null ? null : partyB.trim();
    }

    public String getSaleProvince() {
        return saleProvince;
    }

    public void setSaleProvince(String saleProvince) {
        this.saleProvince = saleProvince == null ? null : saleProvince.trim();
    }

    public String getSaleCity() {
        return saleCity;
    }

    public void setSaleCity(String saleCity) {
        this.saleCity = saleCity == null ? null : saleCity.trim();
    }

    public String getSaleDistrict() {
        return saleDistrict;
    }

    public void setSaleDistrict(String saleDistrict) {
        this.saleDistrict = saleDistrict == null ? null : saleDistrict.trim();
    }

    public String getSaleProvinceCode() {
        return saleProvinceCode;
    }

    public void setSaleProvinceCode(String saleProvinceCode) {
        this.saleProvinceCode = saleProvinceCode == null ? null : saleProvinceCode.trim();
    }

    public String getSaleCityCode() {
        return saleCityCode;
    }

    public void setSaleCityCode(String saleCityCode) {
        this.saleCityCode = saleCityCode == null ? null : saleCityCode.trim();
    }

    public String getSaleDistrictCode() {
        return saleDistrictCode;
    }

    public void setSaleDistrictCode(String saleDistrictCode) {
        this.saleDistrictCode = saleDistrictCode == null ? null : saleDistrictCode.trim();
    }

    public String getSaleChannel() {
        return saleChannel;
    }

    public void setSaleChannel(String saleChannel) {
        this.saleChannel = saleChannel == null ? null : saleChannel.trim();
    }

    public Double getYearRefundTarget() {
        return yearRefundTarget;
    }

    public void setYearRefundTarget(Double yearRefundTarget) {
        this.yearRefundTarget = yearRefundTarget;
    }

    public Double getFirstPayAmount() {
        return firstPayAmount;
    }

    public void setFirstPayAmount(Double firstPayAmount) {
        this.firstPayAmount = firstPayAmount;
    }

    public Date getFirstReceiptDate() {
        return firstReceiptDate;
    }

    public void setFirstReceiptDate(Date firstReceiptDate) {
        this.firstReceiptDate = firstReceiptDate;
    }

    public Double getPerOrderAmount() {
        return perOrderAmount;
    }

    public void setPerOrderAmount(Double perOrderAmount) {
        this.perOrderAmount = perOrderAmount;
    }

    public String getGoodsPayment() {
        return goodsPayment;
    }

    public void setGoodsPayment(String goodsPayment) {
        this.goodsPayment = goodsPayment == null ? null : goodsPayment.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId == null ? null : payeeId.trim();
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName == null ? null : payeeName.trim();
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType == null ? null : bankType.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress == null ? null : deliveryAddress.trim();
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress == null ? null : receiveAddress.trim();
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName == null ? null : receiveName.trim();
    }

    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone == null ? null : receivePhone.trim();
    }

    public Integer getFirstPenalty() {
        return firstPenalty;
    }

    public void setFirstPenalty(Integer firstPenalty) {
        this.firstPenalty = firstPenalty;
    }

    public Integer getSecondPenalty() {
        return secondPenalty;
    }

    public void setSecondPenalty(Integer secondPenalty) {
        this.secondPenalty = secondPenalty;
    }

    public Double getMarketExpenseRate() {
        return marketExpenseRate;
    }

    public void setMarketExpenseRate(Double marketExpenseRate) {
        this.marketExpenseRate = marketExpenseRate;
    }

    public String getRefundExchangeAddress() {
        return refundExchangeAddress;
    }

    public void setRefundExchangeAddress(String refundExchangeAddress) {
        this.refundExchangeAddress = refundExchangeAddress == null ? null : refundExchangeAddress.trim();
    }

    public String getRefundExchangeName() {
        return refundExchangeName;
    }

    public void setRefundExchangeName(String refundExchangeName) {
        this.refundExchangeName = refundExchangeName == null ? null : refundExchangeName.trim();
    }

    public String getRefundExchangePhone() {
        return refundExchangePhone;
    }

    public void setRefundExchangePhone(String refundExchangePhone) {
        this.refundExchangePhone = refundExchangePhone == null ? null : refundExchangePhone.trim();
    }

    public Double getRefundExchangeLimitRate() {
        return refundExchangeLimitRate;
    }

    public void setRefundExchangeLimitRate(Double refundExchangeLimitRate) {
        this.refundExchangeLimitRate = refundExchangeLimitRate;
    }

    public Double getRefundExchangeExceedRate() {
        return refundExchangeExceedRate;
    }

    public void setRefundExchangeExceedRate(Double refundExchangeExceedRate) {
        this.refundExchangeExceedRate = refundExchangeExceedRate;
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