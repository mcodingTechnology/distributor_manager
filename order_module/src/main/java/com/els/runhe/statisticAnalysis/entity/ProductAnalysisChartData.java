package com.els.runhe.statisticAnalysis.entity;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="统计分析订单")
public class ProductAnalysisChartData implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("谷幽兰折线图legend")
    private List<String> lineGYLLegendList;

	@ApiModelProperty("谷幽兰折线图series")
	private List<OrderStatisticAnalysis> lineGYLSeriesList;
	
	@ApiModelProperty("肤专家兰折线图legend")
    private List<String> lineFZJLegendList;

	@ApiModelProperty("肤专家兰折线图series")
	private List<OrderStatisticAnalysis> lineFZJSeriesList;
	
	@ApiModelProperty("物料兰折线图legend")
    private List<String> lineWLLegendList;

	@ApiModelProperty("物料折线图series")
	private List<OrderStatisticAnalysis> lineWLSeriesList;
	
	@ApiModelProperty("折线图xAxis")
	private List<String> lineXAxisList;
	
	@ApiModelProperty("谷幽兰饼图legend")
    private List<String> pieGYLLegendList;
	
	@ApiModelProperty("谷幽兰饼图series")
	private List<OrderStatisticAnalysis> pieGYLSeriesList;
	
	@ApiModelProperty("肤专家兰饼图legend")
    private List<String> pieFZJLegendList;
	
	@ApiModelProperty("肤专家饼图series")
	private List<OrderStatisticAnalysis> pieFZJSeriesList;
	
	@ApiModelProperty("物料饼图legend")
    private List<String> pieWLLegendList;
	
	@ApiModelProperty("物料饼图series")
	private List<OrderStatisticAnalysis> pieWLSeriesList;

	public List<String> getLineGYLLegendList() {
		return lineGYLLegendList;
	}

	public void setLineGYLLegendList(List<String> lineGYLLegendList) {
		this.lineGYLLegendList = lineGYLLegendList;
	}

	public List<OrderStatisticAnalysis> getLineGYLSeriesList() {
		return lineGYLSeriesList;
	}

	public void setLineGYLSeriesList(List<OrderStatisticAnalysis> lineGYLSeriesList) {
		this.lineGYLSeriesList = lineGYLSeriesList;
	}

	public List<String> getLineFZJLegendList() {
		return lineFZJLegendList;
	}

	public void setLineFZJLegendList(List<String> lineFZJLegendList) {
		this.lineFZJLegendList = lineFZJLegendList;
	}

	public List<OrderStatisticAnalysis> getLineFZJSeriesList() {
		return lineFZJSeriesList;
	}

	public void setLineFZJSeriesList(List<OrderStatisticAnalysis> lineFZJSeriesList) {
		this.lineFZJSeriesList = lineFZJSeriesList;
	}

	public List<String> getLineWLLegendList() {
		return lineWLLegendList;
	}

	public void setLineWLLegendList(List<String> lineWLLegendList) {
		this.lineWLLegendList = lineWLLegendList;
	}

	public List<OrderStatisticAnalysis> getLineWLSeriesList() {
		return lineWLSeriesList;
	}

	public void setLineWLSeriesList(List<OrderStatisticAnalysis> lineWLSeriesList) {
		this.lineWLSeriesList = lineWLSeriesList;
	}

	public List<String> getLineXAxisList() {
		return lineXAxisList;
	}

	public void setLineXAxisList(List<String> lineXAxisList) {
		this.lineXAxisList = lineXAxisList;
	}

	public List<String> getPieGYLLegendList() {
		return pieGYLLegendList;
	}

	public void setPieGYLLegendList(List<String> pieGYLLegendList) {
		this.pieGYLLegendList = pieGYLLegendList;
	}

	public List<OrderStatisticAnalysis> getPieGYLSeriesList() {
		return pieGYLSeriesList;
	}

	public void setPieGYLSeriesList(List<OrderStatisticAnalysis> pieGYLSeriesList) {
		this.pieGYLSeriesList = pieGYLSeriesList;
	}

	public List<String> getPieFZJLegendList() {
		return pieFZJLegendList;
	}

	public void setPieFZJLegendList(List<String> pieFZJLegendList) {
		this.pieFZJLegendList = pieFZJLegendList;
	}

	public List<OrderStatisticAnalysis> getPieFZJSeriesList() {
		return pieFZJSeriesList;
	}

	public void setPieFZJSeriesList(List<OrderStatisticAnalysis> pieFZJSeriesList) {
		this.pieFZJSeriesList = pieFZJSeriesList;
	}

	public List<String> getPieWLLegendList() {
		return pieWLLegendList;
	}

	public void setPieWLLegendList(List<String> pieWLLegendList) {
		this.pieWLLegendList = pieWLLegendList;
	}

	public List<OrderStatisticAnalysis> getPieWLSeriesList() {
		return pieWLSeriesList;
	}

	public void setPieWLSeriesList(List<OrderStatisticAnalysis> pieWLSeriesList) {
		this.pieWLSeriesList = pieWLSeriesList;
	}
	
	
	
}