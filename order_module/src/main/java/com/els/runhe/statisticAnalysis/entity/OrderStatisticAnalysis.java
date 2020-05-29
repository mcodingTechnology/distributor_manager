package com.els.runhe.statisticAnalysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="统计分析订单")
public class OrderStatisticAnalysis implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("订单id")
    private String id;

    @ApiModelProperty("单据类型")
    private String type;

    @ApiModelProperty("单据编号")
    private String orderNo;
    
    @ApiModelProperty("状态")
    private Integer status;
    
    @ApiModelProperty("类别")
    private String categoryName;
    
    @ApiModelProperty("类别id")
    private String categoryId;

    @ApiModelProperty("下单日期")
    private Date addTime;

    @ApiModelProperty("货品名称")
    private String productName;
    
    @ApiModelProperty("货品Id")
    private String productId;
    
    @ApiModelProperty("规格")
    private String productSpec;

    @ApiModelProperty("供货价")
    private BigDecimal productSupplyPrice;

    @ApiModelProperty("数量")
    private Integer nums;

    @ApiModelProperty("单位")
    private String productUnit;
    
    @ApiModelProperty("订单金额")
    private String amountTotal;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("物流编号")
    private String deliveryCode;

    @ApiModelProperty("经销商名称")
    private String companyName;
    
    @ApiModelProperty("经销商id")
    private String companyId;

    @ApiModelProperty("所属市")
    private String city;

    @ApiModelProperty("所属省")
    private String province;
    
    @ApiModelProperty("区")
    private String district;
    
    @ApiModelProperty("大区")
    private String area;
    
    @ApiModelProperty("发货时间")
    private String deliveryTime;
    
    @ApiModelProperty("营运审批意见")
    private String taskText;

    
    /**
     * 以下是统计图使用
     */
    @ApiModelProperty("所属省id")
    private String provinceId;
    
    @ApiModelProperty("省销售系列数据")
    private List<String> provinceDataList;
    
    @ApiModelProperty("查询条件in")
    private String categoryIdIn;
    
    @ApiModelProperty("查询条件notin")
    private String categoryIdNotIn;
    
    @ApiModelProperty("echart stack参数")
    private String stack;
    
    @ApiModelProperty("时间查询条件")
    private String queryData;
    
    @ApiModelProperty("经销商id列表")
    private List<String> companyIds;
    
    @ApiModelProperty("开始时间")
    private String startDate;
    
    @ApiModelProperty("结束时间")
    private String endDate;
    
    /**
     * 供应商排名   
     */
    @ApiModelProperty("订货数量")
    private Integer totalNums;
    
    @ApiModelProperty("销售金额")
    private BigDecimal totalAmount;
    
    @ApiModelProperty("月销售金额")
    private String totalMonthAmount;
    
    @ApiModelProperty("已收金额")
    private String payAmount;
    
    @ApiModelProperty("未收金额")
    private String notPayAmount;
    
    @ApiModelProperty("应收金额")
    private String totalPayAmount;
    
    @ApiModelProperty("大区名称")
    private String areaName;
    
    @ApiModelProperty("状态名称")
    private String statusName;
    
    @ApiModelProperty("制单人姓名")
    private String userName;
    
    @ApiModelProperty("line series数据")
    private List<String> seriesDataList;
    
    
	public List<String> getSeriesDataList() {
		return seriesDataList;
	}

	public void setSeriesDataList(List<String> seriesDataList) {
		this.seriesDataList = seriesDataList;
	}

	public String getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}

	public String getNotPayAmount() {
		return notPayAmount;
	}

	public void setNotPayAmount(String notPayAmount) {
		this.notPayAmount = notPayAmount;
	}

	public String getTotalPayAmount() {
		return totalPayAmount;
	}

	public void setTotalPayAmount(String totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTotalMonthAmount() {
		return totalMonthAmount;
	}

	public void setTotalMonthAmount(String totalMonthAmount) {
		this.totalMonthAmount = totalMonthAmount;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Integer getTotalNums() {
		return totalNums;
	}

	public void setTotalNums(Integer totalNums) {
		this.totalNums = totalNums;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getQueryData() {
		return queryData;
	}

	public void setQueryData(String queryData) {
		this.queryData = queryData;
	}

	public String getStack() {
		return stack;
	}

	public void setStack(String stack) {
		this.stack = stack;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public List<String> getProvinceDataList() {
		return provinceDataList;
	}

	public void setProvinceDataList(List<String> provinceDataList) {
		this.provinceDataList = provinceDataList;
	}

	public String getCategoryIdIn() {
		return categoryIdIn;
	}

	public void setCategoryIdIn(String categoryIdIn) {
		this.categoryIdIn = categoryIdIn;
	}

	public String getCategoryIdNotIn() {
		return categoryIdNotIn;
	}

	public void setCategoryIdNotIn(String categoryIdNotIn) {
		this.categoryIdNotIn = categoryIdNotIn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}

	public BigDecimal getProductSupplyPrice() {
		return productSupplyPrice;
	}

	public void setProductSupplyPrice(BigDecimal productSupplyPrice) {
		this.productSupplyPrice = productSupplyPrice;
	}

	public Integer getNums() {
		return nums;
	}

	public void setNums(Integer nums) {
		this.nums = nums;
	}

	public String getAmountTotal() {
		return amountTotal;
	}

	public void setAmountTotal(String amountTotal) {
		this.amountTotal = amountTotal;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeliveryCode() {
		return deliveryCode;
	}

	public void setDeliveryCode(String deliveryCode) {
		this.deliveryCode = deliveryCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(List<String> companyIds) {
		this.companyIds = companyIds;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(String productUnit) {
		this.productUnit = productUnit;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreaName() {
		return areaName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTaskText() {
		return taskText;
	}

	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}
	
}