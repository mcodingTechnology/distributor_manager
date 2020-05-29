package com.els.runhe.statisticAnalysis.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.els.base.core.entity.PageView;
import com.els.runhe.statisticAnalysis.entity.AnalysisArea;
import com.els.runhe.statisticAnalysis.entity.AreaSummaryTable;
import com.els.runhe.statisticAnalysis.entity.AreaYieldRateReport;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysis;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysisCharts;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysisExample;
import com.els.runhe.statisticAnalysis.entity.ProductAnalysisChartData;

public interface OrderStatisticAnalysisService{

	public PageView<OrderStatisticAnalysis> queryObjByPage(OrderStatisticAnalysisExample example);

	public OrderStatisticAnalysisCharts queryChartData(HttpServletRequest request, List<String> companyIds);

	public PageView<OrderStatisticAnalysis> findDealerRankingByPage(OrderStatisticAnalysisExample example);

	public PageView<OrderStatisticAnalysis> findProductRankingByPage(OrderStatisticAnalysisExample example);
	
	public PageView<OrderStatisticAnalysis> findProductDeliveryByPage(OrderStatisticAnalysisExample example);

	public OrderStatisticAnalysisCharts queryMonthChartData(HttpServletRequest request, List<String> companyIds);

	public OrderStatisticAnalysis queryPayAmountData(HttpServletRequest request, List<String> companyIds);

	public ProductAnalysisChartData queryProductChartData(List<String> companyIds,String startDate,String endDate);
	
	public List<String> queryCompanyList(String userId);
	
	public List<AreaYieldRateReport> queryAreaYieldRate(HttpServletRequest request,List<String> companyIds);
	
	public List<AreaYieldRateReport> queryProvinceYieldRate(HttpServletRequest request, List<String> companyIds);
	
	public List<AreaSummaryTable> queryAreaSummary(HttpServletRequest request, List<String> companyIds);
	
	public List<AreaSummaryTable> querySalesDetailReport(HttpServletRequest request, List<String> companyIds);
	
	public PageView<OrderStatisticAnalysis> findAccountingByPage(OrderStatisticAnalysisExample example);
	
	public List<AnalysisArea> queryAreaStatistics(HttpServletRequest request, List<String> companyIds);

	public List<AnalysisArea> queryProductStatistics(HttpServletRequest request);
	
}