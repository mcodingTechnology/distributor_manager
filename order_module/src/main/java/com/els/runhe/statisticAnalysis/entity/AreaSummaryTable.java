package com.els.runhe.statisticAnalysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="统计分析订单")
public class AreaSummaryTable implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("大区")
    private String area;
	
	@ApiModelProperty("大区")
    private String areaName;
	
	@ApiModelProperty("省：id")
    private String province;
	
	@ApiModelProperty("省:中文名称")
    private String provinceName;

	@ApiModelProperty("城市：id")
    private String cityId;
	
	@ApiModelProperty("城市：名称")
    private String cityName;
	
	@ApiModelProperty("经销商id")
    private String companyId;
	
	@ApiModelProperty("经销商名称")
    private String companyName;
	
	@ApiModelProperty("合同开始时间")
    private String stateDate;
	
    @ApiModelProperty("负责人")
    private String head;

    @ApiModelProperty("本年目标金额")
    private BigDecimal yearTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("本年实销回款金额")
    private BigDecimal yearPayTotal = new BigDecimal(0);
    
    @ApiModelProperty("本年达成率")
    private BigDecimal yearYieldRate = new BigDecimal(0);

    @ApiModelProperty("上年实销回款金额")
    private BigDecimal lastYearPayTotal = new BigDecimal(0);
    
    @ApiModelProperty("本年度VS上年度差额")
    private BigDecimal yearVSLastYearTotal = new BigDecimal(0);
    
    @ApiModelProperty("全年实销回款同期比")
    private BigDecimal yearPayGrowth = new BigDecimal(0);
    
    
    
    // 回款目标额
    @ApiModelProperty("第一季度回款目标额")
    private BigDecimal oneQuarterTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("1月回款目标额")
    private BigDecimal oneMonthTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("2月回款目标额")
    private BigDecimal twoMonthTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("3月回款目标额")
    private BigDecimal threeMonthTargetTotal = new BigDecimal(0);
        
    // 回款达成率		
    @ApiModelProperty("第一季度回款达成率")
    private BigDecimal oneQuarterYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("1月回款达成率")
    private BigDecimal oneMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("2月回款达成率")
    private BigDecimal twoMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("3月回款达成率")
    private BigDecimal threeMonthYieldRate = new BigDecimal(0);
    
    // 实销回款	
    @ApiModelProperty("本年度一季度合计")
    private BigDecimal yearOneQuarterPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度一季度合计")
    private BigDecimal lastYearOneQuarterPay = new BigDecimal(0);
    
    // "第一季度实销回款同期比
    @ApiModelProperty("第一季度实销回款同期比")
    private BigDecimal oneQuarterGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度1月合计:实销回款")
    private BigDecimal yearOneMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度1月合计:实销回款")
    private BigDecimal lastYearOneMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("1月实销回款同期比")
    private BigDecimal oneMonthPayGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度2月合计:实销回款")
    private BigDecimal yearTwoMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度2月合计:实销回款")
    private BigDecimal lastYearTwoMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("2月实销回款同期比")
    private BigDecimal twoMonthPayGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度3月合计:实销回款")
    private BigDecimal yearThreeMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度3月合计:实销回款")
    private BigDecimal lastYearThreeMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("3月实销回款同期比")
    private BigDecimal threeMonthPayGrowth = new BigDecimal(0);
    
    
    // 当前年第二季度、4-6月
    @ApiModelProperty("第二季度回款目标额")
    private BigDecimal twoQuarterTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("4月回款目标额")
    private BigDecimal fourMonthTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("5月回款目标额")
    private BigDecimal fiveMonthTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("6月回款目标额")
    private BigDecimal sixMonthTargetTotal = new BigDecimal(0);
        
    // 第二季度回款达成率
    @ApiModelProperty("第二季度回款达成率")
    private BigDecimal twoQuarterYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("4月回款达成率")
    private BigDecimal fourMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("5月回款达成率")
    private BigDecimal fiveMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("6月回款达成率")
    private BigDecimal sixMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("本年度第二季度合计")
    private BigDecimal yearTwoQuarterPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度第二季度合计")
    private BigDecimal lastYearTwoQuarterPay = new BigDecimal(0);
    
    @ApiModelProperty("第二季度实销回款同期比")
    private BigDecimal twoQuarterGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度4月合计:实销回款")
    private BigDecimal yearFourMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度4月合计:实销回款")
    private BigDecimal lastYearFourMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("4月实销回款同期比")
    private BigDecimal fourMonthPayGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度5月合计:实销回款")
    private BigDecimal yearFiveMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度5月合计:实销回款")
    private BigDecimal lastYearFiveMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("5月实销回款同期比")
    private BigDecimal fiveMonthPayGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度6月合计:实销回款")
    private BigDecimal yearSixMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度6月合计:实销回款")
    private BigDecimal lastYearSixMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("6月实销回款同期比")
    private BigDecimal sixMonthPayGrowth = new BigDecimal(0);
    
    
    // 当前年第三季度、7-9月
    @ApiModelProperty("第三季度回款目标额")
    private BigDecimal threeQuarterTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("7月回款目标额")
    private BigDecimal sevenMonthTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("8月回款目标额")
    private BigDecimal eightMonthTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("9月回款目标额")
    private BigDecimal nineMonthTargetTotal = new BigDecimal(0);
        
    // 第三季度回款达成率
    @ApiModelProperty("第三季度回款达成率")
    private BigDecimal threeQuarterYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("7月回款达成率")
    private BigDecimal sevenMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("8月回款达成率")
    private BigDecimal eightMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("9月回款达成率")
    private BigDecimal nineMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("本年度第三季度合计")
    private BigDecimal yearThreeQuarterPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度第三季度合计")
    private BigDecimal lastYearThreeQuarterPay = new BigDecimal(0);
    
    @ApiModelProperty("第三季度实销回款同期比")
    private BigDecimal threeQuarterGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度7月合计:实销回款")
    private BigDecimal yearSevenMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度7月合计:实销回款")
    private BigDecimal lastYearSevenMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("7月实销回款同期比")
    private BigDecimal sevenMonthPayGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度8月合计:实销回款")
    private BigDecimal yearEightMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度8月合计:实销回款")
    private BigDecimal lastYearEightMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("8月实销回款同期比")
    private BigDecimal eightMonthPayGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度9月合计:实销回款")
    private BigDecimal yearNineMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度9月合计:实销回款")
    private BigDecimal lastYearNineMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("9月实销回款同期比")
    private BigDecimal nineMonthPayGrowth = new BigDecimal(0);
    
    
    // 当前年第四季度、10-12月
    @ApiModelProperty("第四季度回款目标额")
    private BigDecimal fourQuarterTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("10月回款目标额")
    private BigDecimal tenMonthTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("11月回款目标额")
    private BigDecimal elevenMonthTargetTotal = new BigDecimal(0);
    
    @ApiModelProperty("12月回款目标额")
    private BigDecimal twelveMonthTargetTotal = new BigDecimal(0);
        
    // 第二季度回款达成率
    @ApiModelProperty("第四季度回款达成率")
    private BigDecimal fourQuarterYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("10月回款达成率")
    private BigDecimal tenMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("11月回款达成率")
    private BigDecimal elevenMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("12月回款达成率")
    private BigDecimal twelveMonthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("本年度第四季度合计")
    private BigDecimal yearFourQuarterPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度第四季度合计")
    private BigDecimal lastYearFourQuarterPay = new BigDecimal(0);
    
    @ApiModelProperty("第四季度实销回款同期比")
    private BigDecimal fourQuarterGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度10月合计:实销回款")
    private BigDecimal yearTenMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度10月合计:实销回款")
    private BigDecimal lastYearTenMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("10月实销回款同期比")
    private BigDecimal tenMonthPayGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度11月合计:实销回款")
    private BigDecimal yearElevenMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度11月合计:实销回款")
    private BigDecimal lastYearElevenMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("11月实销回款同期比")
    private BigDecimal elevenMonthPayGrowth = new BigDecimal(0);
    
    @ApiModelProperty("本年度12月合计:实销回款")
    private BigDecimal yearTwelveMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("上年度12月合计:实销回款")
    private BigDecimal lastYearTwelveMonthPay = new BigDecimal(0);
    
    @ApiModelProperty("12月实销回款同期比")
    private BigDecimal twelveMonthPayGrowth = new BigDecimal(0);
    
    // 返回值
    @ApiModelProperty("支付月份")
    private String payTime;
    
    @ApiModelProperty("支付金额")
    private BigDecimal payAmount = new BigDecimal(0);
    
    @ApiModelProperty("目标月份")
    private String month;
    
    @ApiModelProperty("目标月份总金额")
    private BigDecimal monthTargetTotal;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public BigDecimal getYearTargetTotal() {
		return yearTargetTotal;
	}

	public void setYearTargetTotal(BigDecimal yearTargetTotal) {
		this.yearTargetTotal = yearTargetTotal;
	}

	public BigDecimal getYearPayTotal() {
		return yearPayTotal;
	}

	public void setYearPayTotal(BigDecimal yearPayTotal) {
		this.yearPayTotal = yearPayTotal;
	}

	public BigDecimal getYearYieldRate() {
		return yearYieldRate;
	}

	public void setYearYieldRate(BigDecimal yearYieldRate) {
		this.yearYieldRate = yearYieldRate;
	}

	public BigDecimal getLastYearPayTotal() {
		return lastYearPayTotal;
	}

	public void setLastYearPayTotal(BigDecimal lastYearPayTotal) {
		this.lastYearPayTotal = lastYearPayTotal;
	}

	public BigDecimal getYearVSLastYearTotal() {
		return yearVSLastYearTotal;
	}

	public void setYearVSLastYearTotal(BigDecimal yearVSLastYearTotal) {
		this.yearVSLastYearTotal = yearVSLastYearTotal;
	}

	public BigDecimal getYearPayGrowth() {
		return yearPayGrowth;
	}

	public void setYearPayGrowth(BigDecimal yearPayGrowth) {
		this.yearPayGrowth = yearPayGrowth;
	}

	public BigDecimal getOneQuarterTargetTotal() {
		return oneQuarterTargetTotal;
	}

	public void setOneQuarterTargetTotal(BigDecimal oneQuarterTargetTotal) {
		this.oneQuarterTargetTotal = oneQuarterTargetTotal;
	}

	public BigDecimal getOneMonthTargetTotal() {
		return oneMonthTargetTotal;
	}

	public void setOneMonthTargetTotal(BigDecimal oneMonthTargetTotal) {
		this.oneMonthTargetTotal = oneMonthTargetTotal;
	}

	public BigDecimal getTwoMonthTargetTotal() {
		return twoMonthTargetTotal;
	}

	public void setTwoMonthTargetTotal(BigDecimal twoMonthTargetTotal) {
		this.twoMonthTargetTotal = twoMonthTargetTotal;
	}

	public BigDecimal getThreeMonthTargetTotal() {
		return threeMonthTargetTotal;
	}

	public void setThreeMonthTargetTotal(BigDecimal threeMonthTargetTotal) {
		this.threeMonthTargetTotal = threeMonthTargetTotal;
	}

	public BigDecimal getOneQuarterYieldRate() {
		return oneQuarterYieldRate;
	}

	public void setOneQuarterYieldRate(BigDecimal oneQuarterYieldRate) {
		this.oneQuarterYieldRate = oneQuarterYieldRate;
	}

	public BigDecimal getOneMonthYieldRate() {
		return oneMonthYieldRate;
	}

	public void setOneMonthYieldRate(BigDecimal oneMonthYieldRate) {
		this.oneMonthYieldRate = oneMonthYieldRate;
	}

	public BigDecimal getTwoMonthYieldRate() {
		return twoMonthYieldRate;
	}

	public void setTwoMonthYieldRate(BigDecimal twoMonthYieldRate) {
		this.twoMonthYieldRate = twoMonthYieldRate;
	}

	public BigDecimal getThreeMonthYieldRate() {
		return threeMonthYieldRate;
	}

	public void setThreeMonthYieldRate(BigDecimal threeMonthYieldRate) {
		this.threeMonthYieldRate = threeMonthYieldRate;
	}

	public BigDecimal getYearOneQuarterPay() {
		return yearOneQuarterPay;
	}

	public void setYearOneQuarterPay(BigDecimal yearOneQuarterPay) {
		this.yearOneQuarterPay = yearOneQuarterPay;
	}

	public BigDecimal getLastYearOneQuarterPay() {
		return lastYearOneQuarterPay;
	}

	public void setLastYearOneQuarterPay(BigDecimal lastYearOneQuarterPay) {
		this.lastYearOneQuarterPay = lastYearOneQuarterPay;
	}

	public BigDecimal getOneQuarterGrowth() {
		return oneQuarterGrowth;
	}

	public void setOneQuarterGrowth(BigDecimal oneQuarterGrowth) {
		this.oneQuarterGrowth = oneQuarterGrowth;
	}

	public BigDecimal getYearOneMonthPay() {
		return yearOneMonthPay;
	}

	public void setYearOneMonthPay(BigDecimal yearOneMonthPay) {
		this.yearOneMonthPay = yearOneMonthPay;
	}

	public BigDecimal getLastYearOneMonthPay() {
		return lastYearOneMonthPay;
	}

	public void setLastYearOneMonthPay(BigDecimal lastYearOneMonthPay) {
		this.lastYearOneMonthPay = lastYearOneMonthPay;
	}

	public BigDecimal getOneMonthPayGrowth() {
		return oneMonthPayGrowth;
	}

	public void setOneMonthPayGrowth(BigDecimal oneMonthPayGrowth) {
		this.oneMonthPayGrowth = oneMonthPayGrowth;
	}

	public BigDecimal getYearTwoMonthPay() {
		return yearTwoMonthPay;
	}

	public void setYearTwoMonthPay(BigDecimal yearTwoMonthPay) {
		this.yearTwoMonthPay = yearTwoMonthPay;
	}

	public BigDecimal getLastYearTwoMonthPay() {
		return lastYearTwoMonthPay;
	}

	public void setLastYearTwoMonthPay(BigDecimal lastYearTwoMonthPay) {
		this.lastYearTwoMonthPay = lastYearTwoMonthPay;
	}

	public BigDecimal getTwoMonthPayGrowth() {
		return twoMonthPayGrowth;
	}

	public void setTwoMonthPayGrowth(BigDecimal twoMonthPayGrowth) {
		this.twoMonthPayGrowth = twoMonthPayGrowth;
	}

	public BigDecimal getYearThreeMonthPay() {
		return yearThreeMonthPay;
	}

	public void setYearThreeMonthPay(BigDecimal yearThreeMonthPay) {
		this.yearThreeMonthPay = yearThreeMonthPay;
	}

	public BigDecimal getLastYearThreeMonthPay() {
		return lastYearThreeMonthPay;
	}

	public void setLastYearThreeMonthPay(BigDecimal lastYearThreeMonthPay) {
		this.lastYearThreeMonthPay = lastYearThreeMonthPay;
	}

	public BigDecimal getThreeMonthPayGrowth() {
		return threeMonthPayGrowth;
	}

	public void setThreeMonthPayGrowth(BigDecimal threeMonthPayGrowth) {
		this.threeMonthPayGrowth = threeMonthPayGrowth;
	}

	public BigDecimal getTwoQuarterTargetTotal() {
		return twoQuarterTargetTotal;
	}

	public void setTwoQuarterTargetTotal(BigDecimal twoQuarterTargetTotal) {
		this.twoQuarterTargetTotal = twoQuarterTargetTotal;
	}

	public BigDecimal getFourMonthTargetTotal() {
		return fourMonthTargetTotal;
	}

	public void setFourMonthTargetTotal(BigDecimal fourMonthTargetTotal) {
		this.fourMonthTargetTotal = fourMonthTargetTotal;
	}

	public BigDecimal getFiveMonthTargetTotal() {
		return fiveMonthTargetTotal;
	}

	public void setFiveMonthTargetTotal(BigDecimal fiveMonthTargetTotal) {
		this.fiveMonthTargetTotal = fiveMonthTargetTotal;
	}

	public BigDecimal getSixMonthTargetTotal() {
		return sixMonthTargetTotal;
	}

	public void setSixMonthTargetTotal(BigDecimal sixMonthTargetTotal) {
		this.sixMonthTargetTotal = sixMonthTargetTotal;
	}

	public BigDecimal getTwoQuarterYieldRate() {
		return twoQuarterYieldRate;
	}

	public void setTwoQuarterYieldRate(BigDecimal twoQuarterYieldRate) {
		this.twoQuarterYieldRate = twoQuarterYieldRate;
	}

	public BigDecimal getFourMonthYieldRate() {
		return fourMonthYieldRate;
	}

	public void setFourMonthYieldRate(BigDecimal fourMonthYieldRate) {
		this.fourMonthYieldRate = fourMonthYieldRate;
	}

	public BigDecimal getFiveMonthYieldRate() {
		return fiveMonthYieldRate;
	}

	public void setFiveMonthYieldRate(BigDecimal fiveMonthYieldRate) {
		this.fiveMonthYieldRate = fiveMonthYieldRate;
	}

	public BigDecimal getSixMonthYieldRate() {
		return sixMonthYieldRate;
	}

	public void setSixMonthYieldRate(BigDecimal sixMonthYieldRate) {
		this.sixMonthYieldRate = sixMonthYieldRate;
	}

	public BigDecimal getYearTwoQuarterPay() {
		return yearTwoQuarterPay;
	}

	public void setYearTwoQuarterPay(BigDecimal yearTwoQuarterPay) {
		this.yearTwoQuarterPay = yearTwoQuarterPay;
	}

	public BigDecimal getLastYearTwoQuarterPay() {
		return lastYearTwoQuarterPay;
	}

	public void setLastYearTwoQuarterPay(BigDecimal lastYearTwoQuarterPay) {
		this.lastYearTwoQuarterPay = lastYearTwoQuarterPay;
	}

	public BigDecimal getTwoQuarterGrowth() {
		return twoQuarterGrowth;
	}

	public void setTwoQuarterGrowth(BigDecimal twoQuarterGrowth) {
		this.twoQuarterGrowth = twoQuarterGrowth;
	}

	public BigDecimal getYearFourMonthPay() {
		return yearFourMonthPay;
	}

	public void setYearFourMonthPay(BigDecimal yearFourMonthPay) {
		this.yearFourMonthPay = yearFourMonthPay;
	}

	public BigDecimal getLastYearFourMonthPay() {
		return lastYearFourMonthPay;
	}

	public void setLastYearFourMonthPay(BigDecimal lastYearFourMonthPay) {
		this.lastYearFourMonthPay = lastYearFourMonthPay;
	}

	public BigDecimal getFourMonthPayGrowth() {
		return fourMonthPayGrowth;
	}

	public void setFourMonthPayGrowth(BigDecimal fourMonthPayGrowth) {
		this.fourMonthPayGrowth = fourMonthPayGrowth;
	}

	public BigDecimal getYearFiveMonthPay() {
		return yearFiveMonthPay;
	}

	public void setYearFiveMonthPay(BigDecimal yearFiveMonthPay) {
		this.yearFiveMonthPay = yearFiveMonthPay;
	}

	public BigDecimal getLastYearFiveMonthPay() {
		return lastYearFiveMonthPay;
	}

	public void setLastYearFiveMonthPay(BigDecimal lastYearFiveMonthPay) {
		this.lastYearFiveMonthPay = lastYearFiveMonthPay;
	}

	public BigDecimal getFiveMonthPayGrowth() {
		return fiveMonthPayGrowth;
	}

	public void setFiveMonthPayGrowth(BigDecimal fiveMonthPayGrowth) {
		this.fiveMonthPayGrowth = fiveMonthPayGrowth;
	}

	public BigDecimal getYearSixMonthPay() {
		return yearSixMonthPay;
	}

	public void setYearSixMonthPay(BigDecimal yearSixMonthPay) {
		this.yearSixMonthPay = yearSixMonthPay;
	}

	public BigDecimal getLastYearSixMonthPay() {
		return lastYearSixMonthPay;
	}

	public void setLastYearSixMonthPay(BigDecimal lastYearSixMonthPay) {
		this.lastYearSixMonthPay = lastYearSixMonthPay;
	}

	public BigDecimal getSixMonthPayGrowth() {
		return sixMonthPayGrowth;
	}

	public void setSixMonthPayGrowth(BigDecimal sixMonthPayGrowth) {
		this.sixMonthPayGrowth = sixMonthPayGrowth;
	}

	public BigDecimal getThreeQuarterTargetTotal() {
		return threeQuarterTargetTotal;
	}

	public void setThreeQuarterTargetTotal(BigDecimal threeQuarterTargetTotal) {
		this.threeQuarterTargetTotal = threeQuarterTargetTotal;
	}

	public BigDecimal getSevenMonthTargetTotal() {
		return sevenMonthTargetTotal;
	}

	public void setSevenMonthTargetTotal(BigDecimal sevenMonthTargetTotal) {
		this.sevenMonthTargetTotal = sevenMonthTargetTotal;
	}

	public BigDecimal getEightMonthTargetTotal() {
		return eightMonthTargetTotal;
	}

	public void setEightMonthTargetTotal(BigDecimal eightMonthTargetTotal) {
		this.eightMonthTargetTotal = eightMonthTargetTotal;
	}

	public BigDecimal getNineMonthTargetTotal() {
		return nineMonthTargetTotal;
	}

	public void setNineMonthTargetTotal(BigDecimal nineMonthTargetTotal) {
		this.nineMonthTargetTotal = nineMonthTargetTotal;
	}

	public BigDecimal getThreeQuarterYieldRate() {
		return threeQuarterYieldRate;
	}

	public void setThreeQuarterYieldRate(BigDecimal threeQuarterYieldRate) {
		this.threeQuarterYieldRate = threeQuarterYieldRate;
	}

	public BigDecimal getSevenMonthYieldRate() {
		return sevenMonthYieldRate;
	}

	public void setSevenMonthYieldRate(BigDecimal sevenMonthYieldRate) {
		this.sevenMonthYieldRate = sevenMonthYieldRate;
	}

	public BigDecimal getEightMonthYieldRate() {
		return eightMonthYieldRate;
	}

	public void setEightMonthYieldRate(BigDecimal eightMonthYieldRate) {
		this.eightMonthYieldRate = eightMonthYieldRate;
	}

	public BigDecimal getNineMonthYieldRate() {
		return nineMonthYieldRate;
	}

	public void setNineMonthYieldRate(BigDecimal nineMonthYieldRate) {
		this.nineMonthYieldRate = nineMonthYieldRate;
	}

	public BigDecimal getYearThreeQuarterPay() {
		return yearThreeQuarterPay;
	}

	public void setYearThreeQuarterPay(BigDecimal yearThreeQuarterPay) {
		this.yearThreeQuarterPay = yearThreeQuarterPay;
	}

	public BigDecimal getLastYearThreeQuarterPay() {
		return lastYearThreeQuarterPay;
	}

	public void setLastYearThreeQuarterPay(BigDecimal lastYearThreeQuarterPay) {
		this.lastYearThreeQuarterPay = lastYearThreeQuarterPay;
	}

	public BigDecimal getThreeQuarterGrowth() {
		return threeQuarterGrowth;
	}

	public void setThreeQuarterGrowth(BigDecimal threeQuarterGrowth) {
		this.threeQuarterGrowth = threeQuarterGrowth;
	}

	public BigDecimal getYearSevenMonthPay() {
		return yearSevenMonthPay;
	}

	public void setYearSevenMonthPay(BigDecimal yearSevenMonthPay) {
		this.yearSevenMonthPay = yearSevenMonthPay;
	}

	public BigDecimal getLastYearSevenMonthPay() {
		return lastYearSevenMonthPay;
	}

	public void setLastYearSevenMonthPay(BigDecimal lastYearSevenMonthPay) {
		this.lastYearSevenMonthPay = lastYearSevenMonthPay;
	}

	public BigDecimal getSevenMonthPayGrowth() {
		return sevenMonthPayGrowth;
	}

	public void setSevenMonthPayGrowth(BigDecimal sevenMonthPayGrowth) {
		this.sevenMonthPayGrowth = sevenMonthPayGrowth;
	}

	public BigDecimal getYearEightMonthPay() {
		return yearEightMonthPay;
	}

	public void setYearEightMonthPay(BigDecimal yearEightMonthPay) {
		this.yearEightMonthPay = yearEightMonthPay;
	}

	public BigDecimal getLastYearEightMonthPay() {
		return lastYearEightMonthPay;
	}

	public void setLastYearEightMonthPay(BigDecimal lastYearEightMonthPay) {
		this.lastYearEightMonthPay = lastYearEightMonthPay;
	}

	public BigDecimal getEightMonthPayGrowth() {
		return eightMonthPayGrowth;
	}

	public void setEightMonthPayGrowth(BigDecimal eightMonthPayGrowth) {
		this.eightMonthPayGrowth = eightMonthPayGrowth;
	}

	public BigDecimal getYearNineMonthPay() {
		return yearNineMonthPay;
	}

	public void setYearNineMonthPay(BigDecimal yearNineMonthPay) {
		this.yearNineMonthPay = yearNineMonthPay;
	}

	public BigDecimal getLastYearNineMonthPay() {
		return lastYearNineMonthPay;
	}

	public void setLastYearNineMonthPay(BigDecimal lastYearNineMonthPay) {
		this.lastYearNineMonthPay = lastYearNineMonthPay;
	}

	public BigDecimal getNineMonthPayGrowth() {
		return nineMonthPayGrowth;
	}

	public void setNineMonthPayGrowth(BigDecimal nineMonthPayGrowth) {
		this.nineMonthPayGrowth = nineMonthPayGrowth;
	}

	public BigDecimal getFourQuarterTargetTotal() {
		return fourQuarterTargetTotal;
	}

	public void setFourQuarterTargetTotal(BigDecimal fourQuarterTargetTotal) {
		this.fourQuarterTargetTotal = fourQuarterTargetTotal;
	}

	public BigDecimal getTenMonthTargetTotal() {
		return tenMonthTargetTotal;
	}

	public void setTenMonthTargetTotal(BigDecimal tenMonthTargetTotal) {
		this.tenMonthTargetTotal = tenMonthTargetTotal;
	}

	public BigDecimal getElevenMonthTargetTotal() {
		return elevenMonthTargetTotal;
	}

	public void setElevenMonthTargetTotal(BigDecimal elevenMonthTargetTotal) {
		this.elevenMonthTargetTotal = elevenMonthTargetTotal;
	}

	public BigDecimal getTwelveMonthTargetTotal() {
		return twelveMonthTargetTotal;
	}

	public void setTwelveMonthTargetTotal(BigDecimal twelveMonthTargetTotal) {
		this.twelveMonthTargetTotal = twelveMonthTargetTotal;
	}

	public BigDecimal getFourQuarterYieldRate() {
		return fourQuarterYieldRate;
	}

	public void setFourQuarterYieldRate(BigDecimal fourQuarterYieldRate) {
		this.fourQuarterYieldRate = fourQuarterYieldRate;
	}

	public BigDecimal getTenMonthYieldRate() {
		return tenMonthYieldRate;
	}

	public void setTenMonthYieldRate(BigDecimal tenMonthYieldRate) {
		this.tenMonthYieldRate = tenMonthYieldRate;
	}

	public BigDecimal getElevenMonthYieldRate() {
		return elevenMonthYieldRate;
	}

	public void setElevenMonthYieldRate(BigDecimal elevenMonthYieldRate) {
		this.elevenMonthYieldRate = elevenMonthYieldRate;
	}

	public BigDecimal getTwelveMonthYieldRate() {
		return twelveMonthYieldRate;
	}

	public void setTwelveMonthYieldRate(BigDecimal twelveMonthYieldRate) {
		this.twelveMonthYieldRate = twelveMonthYieldRate;
	}

	public BigDecimal getYearFourQuarterPay() {
		return yearFourQuarterPay;
	}

	public void setYearFourQuarterPay(BigDecimal yearFourQuarterPay) {
		this.yearFourQuarterPay = yearFourQuarterPay;
	}

	public BigDecimal getLastYearFourQuarterPay() {
		return lastYearFourQuarterPay;
	}

	public void setLastYearFourQuarterPay(BigDecimal lastYearFourQuarterPay) {
		this.lastYearFourQuarterPay = lastYearFourQuarterPay;
	}

	public BigDecimal getFourQuarterGrowth() {
		return fourQuarterGrowth;
	}

	public void setFourQuarterGrowth(BigDecimal fourQuarterGrowth) {
		this.fourQuarterGrowth = fourQuarterGrowth;
	}

	public BigDecimal getYearTenMonthPay() {
		return yearTenMonthPay;
	}

	public void setYearTenMonthPay(BigDecimal yearTenMonthPay) {
		this.yearTenMonthPay = yearTenMonthPay;
	}

	public BigDecimal getLastYearTenMonthPay() {
		return lastYearTenMonthPay;
	}

	public void setLastYearTenMonthPay(BigDecimal lastYearTenMonthPay) {
		this.lastYearTenMonthPay = lastYearTenMonthPay;
	}

	public BigDecimal getTenMonthPayGrowth() {
		return tenMonthPayGrowth;
	}

	public void setTenMonthPayGrowth(BigDecimal tenMonthPayGrowth) {
		this.tenMonthPayGrowth = tenMonthPayGrowth;
	}

	public BigDecimal getYearElevenMonthPay() {
		return yearElevenMonthPay;
	}

	public void setYearElevenMonthPay(BigDecimal yearElevenMonthPay) {
		this.yearElevenMonthPay = yearElevenMonthPay;
	}

	public BigDecimal getLastYearElevenMonthPay() {
		return lastYearElevenMonthPay;
	}

	public void setLastYearElevenMonthPay(BigDecimal lastYearElevenMonthPay) {
		this.lastYearElevenMonthPay = lastYearElevenMonthPay;
	}

	public BigDecimal getElevenMonthPayGrowth() {
		return elevenMonthPayGrowth;
	}

	public void setElevenMonthPayGrowth(BigDecimal elevenMonthPayGrowth) {
		this.elevenMonthPayGrowth = elevenMonthPayGrowth;
	}

	public BigDecimal getYearTwelveMonthPay() {
		return yearTwelveMonthPay;
	}

	public void setYearTwelveMonthPay(BigDecimal yearTwelveMonthPay) {
		this.yearTwelveMonthPay = yearTwelveMonthPay;
	}

	public BigDecimal getLastYearTwelveMonthPay() {
		return lastYearTwelveMonthPay;
	}

	public void setLastYearTwelveMonthPay(BigDecimal lastYearTwelveMonthPay) {
		this.lastYearTwelveMonthPay = lastYearTwelveMonthPay;
	}

	public BigDecimal getTwelveMonthPayGrowth() {
		return twelveMonthPayGrowth;
	}

	public void setTwelveMonthPayGrowth(BigDecimal twelveMonthPayGrowth) {
		this.twelveMonthPayGrowth = twelveMonthPayGrowth;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public BigDecimal getMonthTargetTotal() {
		return monthTargetTotal;
	}

	public void setMonthTargetTotal(BigDecimal monthTargetTotal) {
		this.monthTargetTotal = monthTargetTotal;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStateDate() {
		return stateDate;
	}

	public void setStateDate(String stateDate) {
		this.stateDate = stateDate;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}