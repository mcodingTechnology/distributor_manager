package com.els.runhe.statisticAnalysis.entity;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="统计分析订单图表")
public class OrderStatisticAnalysisCharts implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("产品系列")
    private List<String> categoryList;

    @ApiModelProperty("产品销售省")
    private List<String> provinceList;
    
    @ApiModelProperty("产品销售数据")
    private List<OrderStatisticAnalysis> statisticAnalysisList;
    
    @ApiModelProperty("月度销售xAxis")
    private List<String> monthXAxisList;
    
    @ApiModelProperty("月度销售yAxis")
    private List<String> monthYAxisList;

    
	public List<String> getMonthXAxisList() {
		return monthXAxisList;
	}

	public void setMonthXAxisList(List<String> monthXAxisList) {
		this.monthXAxisList = monthXAxisList;
	}

	public List<String> getMonthYAxisList() {
		return monthYAxisList;
	}

	public void setMonthYAxisList(List<String> monthYAxisList) {
		this.monthYAxisList = monthYAxisList;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public List<String> getProvinceList() {
		return provinceList;
	}

	public void setProvinceList(List<String> provinceList) {
		this.provinceList = provinceList;
	}

	public List<OrderStatisticAnalysis> getStatisticAnalysisList() {
		return statisticAnalysisList;
	}

	public void setStatisticAnalysisList(List<OrderStatisticAnalysis> statisticAnalysisList) {
		this.statisticAnalysisList = statisticAnalysisList;
	}
    
    
    
}