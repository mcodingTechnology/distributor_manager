package com.els.runhe.statisticAnalysis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.els.runhe.statisticAnalysis.entity.AnalysisArea;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysis;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysisExample;

public interface OrderStatisticAnalysisMapper {

	public List<OrderStatisticAnalysis> selectByExampleByPage(OrderStatisticAnalysisExample example);

	public List<OrderStatisticAnalysis> queryCategoryList(OrderStatisticAnalysis analysis);

	public List<OrderStatisticAnalysis> queryProvinceList(OrderStatisticAnalysis analysis);

	public List<OrderStatisticAnalysis> queryChartDataList(OrderStatisticAnalysis analysis);

	public List<OrderStatisticAnalysis> findDealerRankingByPage(OrderStatisticAnalysisExample example);

	public List<OrderStatisticAnalysis> findProductRankingByPage(OrderStatisticAnalysisExample example);
	
	public List<OrderStatisticAnalysis> findProductDeliveryByPage(OrderStatisticAnalysisExample example);

	public OrderStatisticAnalysis queryMonthChartData(OrderStatisticAnalysis analysis);

	public OrderStatisticAnalysis queryPayAmountData(OrderStatisticAnalysis analysis);

	public List<OrderStatisticAnalysis> queryProductLineChartData(OrderStatisticAnalysis analysis);

	public List<OrderStatisticAnalysis> querylineGYLLegendList(OrderStatisticAnalysis orderStatisticAnalysis);

	public List<OrderStatisticAnalysis> queryProductPieChartData(OrderStatisticAnalysis analysis);
	
	public List<OrderStatisticAnalysis> selectAccountingByPage(OrderStatisticAnalysisExample example);

	public List<AnalysisArea> queryProvinceDataList(AnalysisArea analysisArea);

	public List<String> querDealerAreaList(AnalysisArea analysisArea);

	public List<AnalysisArea> queryProvinceProductDataList(AnalysisArea analysisArea);
}