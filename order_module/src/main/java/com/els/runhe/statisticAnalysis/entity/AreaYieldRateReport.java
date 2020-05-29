package com.els.runhe.statisticAnalysis.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="统计分析订单")
public class AreaYieldRateReport implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("大区")
    private String area;
	
	@ApiModelProperty("省：id")
    private String province;
	
	@ApiModelProperty("省:中文名称")
    private String provinceName;

    @ApiModelProperty("负责人")
    private String head;

    @ApiModelProperty("当月达成率")
    private BigDecimal monthYieldRate = new BigDecimal(0);
    
    @ApiModelProperty("当月达成率排名")
    private int monthYieldRateRanking;
    
    @ApiModelProperty("第一季度达成率")
    private BigDecimal oneQuarterYieldRate = new BigDecimal(0);

    @ApiModelProperty("第一季度同期增长率")
    private BigDecimal oneQuarterGrowth = new BigDecimal(0);
    
    @ApiModelProperty("第二季度达成率")
    private BigDecimal twoQuarterYieldRate = new BigDecimal(0);

    @ApiModelProperty("第二季度同期增长率")
    private BigDecimal twoQuarterGrowth = new BigDecimal(0);
    
    @ApiModelProperty("第三季度达成率")
    private BigDecimal threeQuarterYieldRate = new BigDecimal(0);

    @ApiModelProperty("第三季度同期增长率")
    private BigDecimal threeQuarterGrowth = new BigDecimal(0);
    
    @ApiModelProperty("第四季度达成率")
    private BigDecimal fourQuarterYieldRate = new BigDecimal(0);

    @ApiModelProperty("第四季度同期增长率")
    private BigDecimal fourQuarterGrowth = new BigDecimal(0);
   
    @ApiModelProperty("年达成率")
    private BigDecimal yearYieldRate = new BigDecimal(0);

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

	public BigDecimal getMonthYieldRate() {
		return monthYieldRate;
	}

	public void setMonthYieldRate(BigDecimal monthYieldRate) {
		this.monthYieldRate = monthYieldRate;
	}

	public int getMonthYieldRateRanking() {
		return monthYieldRateRanking;
	}

	public void setMonthYieldRateRanking(int monthYieldRateRanking) {
		this.monthYieldRateRanking = monthYieldRateRanking;
	}

	public BigDecimal getOneQuarterYieldRate() {
		return oneQuarterYieldRate;
	}

	public void setOneQuarterYieldRate(BigDecimal oneQuarterYieldRate) {
		this.oneQuarterYieldRate = oneQuarterYieldRate;
	}

	public BigDecimal getOneQuarterGrowth() {
		return oneQuarterGrowth;
	}

	public void setOneQuarterGrowth(BigDecimal oneQuarterGrowth) {
		this.oneQuarterGrowth = oneQuarterGrowth;
	}

	public BigDecimal getTwoQuarterYieldRate() {
		return twoQuarterYieldRate;
	}

	public void setTwoQuarterYieldRate(BigDecimal twoQuarterYieldRate) {
		this.twoQuarterYieldRate = twoQuarterYieldRate;
	}

	public BigDecimal getTwoQuarterGrowth() {
		return twoQuarterGrowth;
	}

	public void setTwoQuarterGrowth(BigDecimal twoQuarterGrowth) {
		this.twoQuarterGrowth = twoQuarterGrowth;
	}

	public BigDecimal getThreeQuarterYieldRate() {
		return threeQuarterYieldRate;
	}

	public void setThreeQuarterYieldRate(BigDecimal threeQuarterYieldRate) {
		this.threeQuarterYieldRate = threeQuarterYieldRate;
	}

	public BigDecimal getThreeQuarterGrowth() {
		return threeQuarterGrowth;
	}

	public void setThreeQuarterGrowth(BigDecimal threeQuarterGrowth) {
		this.threeQuarterGrowth = threeQuarterGrowth;
	}

	public BigDecimal getFourQuarterYieldRate() {
		return fourQuarterYieldRate;
	}

	public void setFourQuarterYieldRate(BigDecimal fourQuarterYieldRate) {
		this.fourQuarterYieldRate = fourQuarterYieldRate;
	}

	public BigDecimal getFourQuarterGrowth() {
		return fourQuarterGrowth;
	}

	public void setFourQuarterGrowth(BigDecimal fourQuarterGrowth) {
		this.fourQuarterGrowth = fourQuarterGrowth;
	}

	public BigDecimal getYearYieldRate() {
		return yearYieldRate;
	}

	public void setYearYieldRate(BigDecimal yearYieldRate) {
		this.yearYieldRate = yearYieldRate;
	}
    
}