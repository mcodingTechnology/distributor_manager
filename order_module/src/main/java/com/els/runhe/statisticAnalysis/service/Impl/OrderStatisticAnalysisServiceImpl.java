package com.els.runhe.statisticAnalysis.service.Impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.els.base.company.entity.Company;
import com.els.base.company.entity.CompanyExample;
import com.els.base.company.entity.UserArea;
import com.els.base.company.service.CompanyService;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.user.User;
import com.els.base.core.service.user.UserService;
import com.els.runhe.statisticAnalysis.dao.AreaYieldRateReportMapper;
import com.els.runhe.statisticAnalysis.dao.OrderStatisticAnalysisMapper;
import com.els.runhe.statisticAnalysis.entity.AnalysisArea;
import com.els.runhe.statisticAnalysis.entity.AreaSummaryTable;
import com.els.runhe.statisticAnalysis.entity.AreaYieldRateReport;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysis;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysisCharts;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysisExample;
import com.els.runhe.statisticAnalysis.entity.ProductAnalysisChartData;
import com.els.runhe.statisticAnalysis.service.OrderStatisticAnalysisService;
import com.els.runhe.statisticAnalysis.utils.StatisticAnalysisConstant;
import com.els.runhe.statisticAnalysis.utils.StatisticAnalysisDateUtil;

import net.sf.json.JSONArray;

@Service("orderStatisticAnalysisService")
public class OrderStatisticAnalysisServiceImpl implements OrderStatisticAnalysisService {
	@Resource
	private OrderStatisticAnalysisMapper orderStatisticAnalysisMapper;
	@Resource
	private AreaYieldRateReportMapper areaYieldRateReportMapper;
	
	@Resource
    protected CompanyService companyService;
    
    @Resource
    protected UserService userService;
	
	@Override
	public PageView<OrderStatisticAnalysis> queryObjByPage(OrderStatisticAnalysisExample example) {
		PageView<OrderStatisticAnalysis> pageView = example.getPageView();
        List<OrderStatisticAnalysis> list = this.orderStatisticAnalysisMapper.selectByExampleByPage(example);
        pageView.setQueryResult(list);
        return pageView;
	}

	@Override
	public OrderStatisticAnalysisCharts queryChartData(HttpServletRequest request, List<String> companyIds) {
		OrderStatisticAnalysisCharts analysisCharts = new OrderStatisticAnalysisCharts();
		if (CollectionUtils.isEmpty(companyIds)) {
			return new OrderStatisticAnalysisCharts();
		}
		// 查询出所有系列
		OrderStatisticAnalysis analysis = new OrderStatisticAnalysis();
		if(StringUtils.isNotEmpty(request.getParameter("queryDate"))){
			analysis.setQueryData(request.getParameter("queryDate"));
		}
		analysis.setCompanyIds(companyIds);
		List<OrderStatisticAnalysis> categoryList = this.orderStatisticAnalysisMapper.queryCategoryList(analysis);
		//查询出所有省
		List<OrderStatisticAnalysis> provinceList = this.orderStatisticAnalysisMapper.queryProvinceList(analysis);
		// 查询出所有经营数据
		List<OrderStatisticAnalysis> chartDataList = this.orderStatisticAnalysisMapper.queryChartDataList(analysis);
		
		// 组装数据
		List<String> categoryLists  = new  ArrayList<String>(); // 系列数据
		List<String> provinceLists  = new  ArrayList<String>(); // 省数据
		List<OrderStatisticAnalysis> statisticAnalysisList = new ArrayList<OrderStatisticAnalysis>(); // 产品系列销售数据
		for(OrderStatisticAnalysis category:categoryList){
			List<String> provinceDataList  = new  ArrayList<String>(); // 系列对应的省销售数据
			for(OrderStatisticAnalysis province:provinceList){
				boolean flag = false;
				for(OrderStatisticAnalysis chart:chartDataList){
					if(category.getCategoryId().equals(chart.getCategoryId())){
						if(province.getProvinceId().equals(chart.getProvinceId())){
							provinceDataList.add(String.valueOf(chart.getNums()));
							flag = true;
							break;
						}
					}	
				}
				if(!flag){
					provinceDataList.add("0");
				}
				if(provinceList.size() > provinceLists.size()){
					provinceLists.add(province.getProvince());
				}
			}
			categoryLists.add(category.getCategoryName());
			// 
			OrderStatisticAnalysis chartCategory = new OrderStatisticAnalysis();
			chartCategory.setProvinceDataList(provinceDataList);
			chartCategory.setCategoryId(category.getCategoryId());
			chartCategory.setCategoryName(category.getCategoryName());
			chartCategory.setStack(category.getStack());
			statisticAnalysisList.add(chartCategory);
		}
		analysisCharts.setCategoryList(categoryLists);
		analysisCharts.setProvinceList(provinceLists);
		analysisCharts.setStatisticAnalysisList(statisticAnalysisList);
		return analysisCharts;
	}

	@Override
	public PageView<OrderStatisticAnalysis> findDealerRankingByPage(OrderStatisticAnalysisExample example) {
		PageView<OrderStatisticAnalysis> pageView = example.getPageView();
        List<OrderStatisticAnalysis> list = this.orderStatisticAnalysisMapper.findDealerRankingByPage(example);
        pageView.setQueryResult(list);
        return pageView;
	}

	@Override
	public PageView<OrderStatisticAnalysis> findProductRankingByPage(OrderStatisticAnalysisExample example) {
		PageView<OrderStatisticAnalysis> pageView = example.getPageView();
        List<OrderStatisticAnalysis> list = this.orderStatisticAnalysisMapper.findProductRankingByPage(example);
        pageView.setQueryResult(list);
        return pageView;
	}
	
	@Override
	public PageView<OrderStatisticAnalysis> findProductDeliveryByPage(OrderStatisticAnalysisExample example) {
		PageView<OrderStatisticAnalysis> pageView = example.getPageView();
        List<OrderStatisticAnalysis> list = this.orderStatisticAnalysisMapper.findProductDeliveryByPage(example);
        pageView.setQueryResult(list);
        return pageView;
	}

	@Override
	public OrderStatisticAnalysisCharts queryMonthChartData(HttpServletRequest request, List<String> companyIds) {
		OrderStatisticAnalysisCharts analysisCharts = new OrderStatisticAnalysisCharts();
		// 获取当前月的日期
		List<String> dateList = StatisticAnalysisDateUtil.getDayListOfMonth();
		OrderStatisticAnalysis analysis = new OrderStatisticAnalysis();
		List<String> monthXAxisList = new ArrayList<String>();
		List<String> monthYAxisList = new ArrayList<String>();
 		for(String date:dateList){
			analysis.setQueryData(date);
			analysis.setCompanyIds(companyIds);
			OrderStatisticAnalysis orderStatisticAnalysis = null;
			// 经销商id为空即不执行查询
			if (CollectionUtils.isNotEmpty(companyIds)) {
				orderStatisticAnalysis = this.orderStatisticAnalysisMapper.queryMonthChartData(analysis);
			}
			if(orderStatisticAnalysis != null && StringUtils.isNotEmpty(orderStatisticAnalysis.getTotalMonthAmount())){
				monthYAxisList.add(orderStatisticAnalysis.getTotalMonthAmount());
			}else {
				monthYAxisList.add("0");
			}
			monthXAxisList.add(date);
		}
 		analysisCharts.setMonthXAxisList(monthXAxisList);
 		analysisCharts.setMonthYAxisList(monthYAxisList);
		return analysisCharts;
	}

	@Override
	public OrderStatisticAnalysis queryPayAmountData(HttpServletRequest request, List<String> companyIds) {
		if (CollectionUtils.isEmpty(companyIds)) {
			return new OrderStatisticAnalysis();
		}
		OrderStatisticAnalysis analysis = new OrderStatisticAnalysis();
		analysis.setCompanyIds(companyIds);
		return this.orderStatisticAnalysisMapper.queryPayAmountData(analysis);
	}

	@Override
	public ProductAnalysisChartData queryProductChartData(List<String> companyIds, String startDate, String endDate) {
		
		ProductAnalysisChartData chartData = new ProductAnalysisChartData();
		// 如果经销商id为空，即不执行后续代码。
		if (CollectionUtils.isEmpty(companyIds)) {
			return chartData;
		}
		List<String> dateList = new ArrayList<String>();
		if (StringUtils.isNotEmpty(startDate)) {
			dateList = StatisticAnalysisDateUtil.getDates(startDate, endDate, "yyyy-MM-dd");
		} else {
			dateList = StatisticAnalysisDateUtil.getDayListOfMonth();
		}
		// 获取当前月的日期
		
		List<String> lineGYLLegendList = new ArrayList<String>(); // 谷幽兰Legend
		List<OrderStatisticAnalysis> lineGYLSeriesList = new ArrayList<OrderStatisticAnalysis>(); // 谷幽兰Series
		
		List<String> lineFZJLegendList = new ArrayList<String>(); // 肤专家Legend
		List<OrderStatisticAnalysis> lineFZJSeriesList = new ArrayList<OrderStatisticAnalysis>(); // 肤专家Series
		
		List<String> lineWLLegendList = new ArrayList<String>(); // 物料Legend
		List<OrderStatisticAnalysis> lineWLSeriesList = new ArrayList<OrderStatisticAnalysis>(); // 物料Series
		// 查询折线图数据
		for(String data:dateList){
			OrderStatisticAnalysis analysis = new OrderStatisticAnalysis();
			analysis.setQueryData(data);
			// 谷幽兰
			analysis.setCategoryId(StatisticAnalysisConstant.CATEGORY_GYL_ID);
			analysis.setCompanyIds(companyIds);
			List<OrderStatisticAnalysis> listGYL = this.orderStatisticAnalysisMapper.queryProductLineChartData(analysis);
			for(OrderStatisticAnalysis analysisGYL:listGYL){
				if(StringUtils.isNotEmpty(analysisGYL.getCategoryName()) && lineGYLLegendList.size() < listGYL.size()){
					lineGYLLegendList.add(analysisGYL.getCategoryName());
					OrderStatisticAnalysis statisticAnalysis = new OrderStatisticAnalysis();
					statisticAnalysis.setCategoryId(analysisGYL.getCategoryId());
					statisticAnalysis.setCategoryName(analysisGYL.getCategoryName());
					List<String> seriesDataList = new ArrayList<String>();
					seriesDataList.add(String.valueOf(analysisGYL.getNums()));
					statisticAnalysis.setSeriesDataList(seriesDataList);
					lineGYLSeriesList.add(statisticAnalysis);
				}else if(lineGYLSeriesList.size() == listGYL.size()) {
					for(OrderStatisticAnalysis statisticAnalysis:lineGYLSeriesList){
						if(statisticAnalysis.getCategoryId().equals(analysisGYL.getCategoryId())){
							statisticAnalysis.getSeriesDataList().add(String.valueOf(analysisGYL.getNums()));
						}
					}
				}
			}
			/*// 肤专家
			analysis.setCategoryId(StatisticAnalysisConstant.CATEGORY_FZJ_ID);
			List<OrderStatisticAnalysis> listFZJ = this.orderStatisticAnalysisMapper.queryProductLineChartData(analysis);
			for(OrderStatisticAnalysis analysisGYL:listFZJ){
				if(StringUtils.isNotEmpty(analysisGYL.getCategoryName()) && lineFZJLegendList.size() < listFZJ.size()){
					lineFZJLegendList.add(analysisGYL.getCategoryName());
					OrderStatisticAnalysis statisticAnalysis = new OrderStatisticAnalysis();
					statisticAnalysis.setCategoryId(analysisGYL.getCategoryId());
					statisticAnalysis.setCategoryName(analysisGYL.getCategoryName());
					List<String> seriesDataList = new ArrayList<String>();
					seriesDataList.add(String.valueOf(analysisGYL.getNums()));
					statisticAnalysis.setSeriesDataList(seriesDataList);
					lineFZJSeriesList.add(statisticAnalysis);
				}else if(lineFZJSeriesList.size() == listFZJ.size()) {
					for(OrderStatisticAnalysis statisticAnalysis:lineFZJSeriesList){
						if(statisticAnalysis.getCategoryId().equals(analysisGYL.getCategoryId())){
							statisticAnalysis.getSeriesDataList().add(String.valueOf(analysisGYL.getNums()));
						}
					}
				}
			}
			//物料
			analysis.setCategoryId(StatisticAnalysisConstant.CATEGORY_WL_ID);
			List<OrderStatisticAnalysis> listWL = this.orderStatisticAnalysisMapper.queryProductLineChartData(analysis);
			for(OrderStatisticAnalysis analysisGYL:listWL){
				if(StringUtils.isNotEmpty(analysisGYL.getCategoryName()) && lineWLLegendList.size() < listWL.size()){
					lineWLLegendList.add(analysisGYL.getCategoryName());
					OrderStatisticAnalysis statisticAnalysis = new OrderStatisticAnalysis();
					statisticAnalysis.setCategoryId(analysisGYL.getCategoryId());
					statisticAnalysis.setCategoryName(analysisGYL.getCategoryName());
					List<String> seriesDataList = new ArrayList<String>();
					seriesDataList.add(String.valueOf(analysisGYL.getNums()));
					statisticAnalysis.setSeriesDataList(seriesDataList);
					lineWLSeriesList.add(statisticAnalysis);
				}else if(lineWLSeriesList.size() == listWL.size()) {
					for(OrderStatisticAnalysis statisticAnalysis:lineWLSeriesList){
						if(statisticAnalysis.getCategoryId().equals(analysisGYL.getCategoryId())){
							statisticAnalysis.getSeriesDataList().add(String.valueOf(analysisGYL.getNums()));
						}
					}
				}
			}*/
		}
		
		// 查询饼图数据
		OrderStatisticAnalysis analysis = new OrderStatisticAnalysis();
		// 谷幽兰
		List<String> pieGYLLegendList = new ArrayList<String>();
		analysis.setCategoryId(StatisticAnalysisConstant.CATEGORY_GYL_ID);
		analysis.setCompanyIds(companyIds);
		if (StringUtils.isNotEmpty(startDate)) {
			analysis.setStartDate(startDate);
			analysis.setEndDate(endDate);
		}
		List<OrderStatisticAnalysis> pieGYLList = this.orderStatisticAnalysisMapper.queryProductPieChartData(analysis);
		for(OrderStatisticAnalysis pieGyl:pieGYLList){
			pieGYLLegendList.add(pieGyl.getCategoryName());
		}
		
		// 肤专家
		List<String> pieFZJLegendList = new ArrayList<String>();
		analysis.setCategoryId(StatisticAnalysisConstant.CATEGORY_FZJ_ID);
		analysis.setCompanyIds(companyIds);
		List<OrderStatisticAnalysis> pieFZJList = this.orderStatisticAnalysisMapper.queryProductPieChartData(analysis);
		for(OrderStatisticAnalysis pieGyl:pieFZJList){
			pieFZJLegendList.add(pieGyl.getCategoryName());
		}
				
				
		// 物料
		List<String> pieWLLegendList = new ArrayList<String>();
		analysis.setCategoryId(StatisticAnalysisConstant.CATEGORY_WL_ID);
		analysis.setCompanyIds(companyIds);
		List<OrderStatisticAnalysis> pieWLList = this.orderStatisticAnalysisMapper.queryProductPieChartData(analysis);
		for(OrderStatisticAnalysis pieGyl:pieWLList){
			pieWLLegendList.add(pieGyl.getCategoryName());
		}
		//饼图
		chartData.setPieGYLLegendList(pieGYLLegendList);
		chartData.setPieGYLSeriesList(pieGYLList);
		chartData.setPieFZJLegendList(pieFZJLegendList);
		chartData.setPieFZJSeriesList(pieFZJList);
		chartData.setPieWLLegendList(pieWLLegendList);
		chartData.setPieWLSeriesList(pieWLList);
		// 折线图
		chartData.setLineGYLLegendList(lineGYLLegendList);
		chartData.setLineGYLSeriesList(lineGYLSeriesList);
		chartData.setLineFZJLegendList(lineFZJLegendList);
		chartData.setLineFZJSeriesList(lineFZJSeriesList);
		chartData.setLineWLLegendList(lineWLLegendList);
		chartData.setLineWLSeriesList(lineWLSeriesList);
		chartData.setLineXAxisList(dateList);
		return chartData;
	}

	@Override
	public PageView<OrderStatisticAnalysis> findAccountingByPage(OrderStatisticAnalysisExample example) {
		PageView<OrderStatisticAnalysis> pageView = example.getPageView();
        List<OrderStatisticAnalysis> list = this.orderStatisticAnalysisMapper.selectAccountingByPage(example);
        pageView.setQueryResult(list);
        return pageView;
	}
	private List<String> getMoth(int i){
		List<String> str = new ArrayList<String>();
		str.add(String.valueOf(i));
		str.add(String.valueOf(++i));
		str.add(String.valueOf(++i));
		return str;
	}
	
	private List<String> getYearMoth(int i,boolean flag){
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
		int year = aCalendar.get(Calendar.YEAR);//年份
		if (flag) {
			year = year - 1;
		}
		List<String> str = new ArrayList<String>();
	    for (int k = i;k < i+3; k++) {
	    	if (k>9) {
	    		str.add(String.valueOf(year)+"-"+k);
	    	}else{
	    		str.add(String.valueOf(year)+"-0"+k);
	    	}
	    }
		return str;
	}
	@Override
	public List<AreaYieldRateReport> queryAreaYieldRate(HttpServletRequest request,List<String> companyIds) {
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
	    int year = aCalendar.get(Calendar.YEAR);//年份
	    int month = aCalendar.get(Calendar.MONTH)+1;//月份
		List<String> monthList = new ArrayList<String>();
		List<String> yearMonthList = new ArrayList<String>();
		String startTime = StatisticAnalysisDateUtil.getMonth();
		String endTime = StatisticAnalysisDateUtil.getMonth();
		monthList.add(String.valueOf(month));
		yearMonthList.add(startTime);
		// 当月的业绩达成率及排名
		List<AreaYieldRateReport> list = this.areaYieldRateReportMapper.queryAreaYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		// 本年第一季度达成率
		List<AreaYieldRateReport> oneQuarterList = new ArrayList<AreaYieldRateReport>();
		// 本年第二季度达成率
		List<AreaYieldRateReport> twoQuarterList = new ArrayList<AreaYieldRateReport>();
		// 本年第三季度达成率
		List<AreaYieldRateReport> threeQuarterList = new ArrayList<AreaYieldRateReport>();
		// 本年第四季度达成率
		List<AreaYieldRateReport> fourQuarterList = new ArrayList<AreaYieldRateReport>();
		
		// 去年第一季度达成率
		List<AreaYieldRateReport> oneQuarterLists = new ArrayList<AreaYieldRateReport>();
		// 去年第二季度达成率
		List<AreaYieldRateReport> twoQuarterLists = new ArrayList<AreaYieldRateReport>();
		// 去年第三季度达成率
		List<AreaYieldRateReport> threeQuarterLists = new ArrayList<AreaYieldRateReport>();
		// 去年第四季度达成率
		List<AreaYieldRateReport> fourQuarterLists = new ArrayList<AreaYieldRateReport>();
		
		if (month > 0) {
			startTime = String.valueOf(year-1)+"-01";
			endTime = String.valueOf(year-1)+"-03";
			monthList = this.getMoth(1);
			yearMonthList = this.getYearMoth(1,true);
			oneQuarterList = this.areaYieldRateReportMapper.queryAreaYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
			
			startTime = String.valueOf(year)+"-01";
			endTime = String.valueOf(year)+"-03";
			monthList = this.getMoth(1);
			yearMonthList = this.getYearMoth(1,false);
			oneQuarterList = this.areaYieldRateReportMapper.queryAreaYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		}
		if (month > 3) {
			startTime = String.valueOf(year)+"-04";
			endTime = String.valueOf(year)+"-06";
			monthList = this.getMoth(4);
			yearMonthList = this.getYearMoth(4,true);
			twoQuarterLists = this.areaYieldRateReportMapper.queryAreaYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
			
			startTime = String.valueOf(year)+"-04";
			endTime = String.valueOf(year)+"-06";
			monthList = this.getMoth(4);
			yearMonthList = this.getYearMoth(4,false);
			twoQuarterList = this.areaYieldRateReportMapper.queryAreaYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		}
		if (month > 6) {
			startTime = String.valueOf(year)+"-07";
			endTime = String.valueOf(year)+"-09";
			monthList = this.getMoth(7);
			yearMonthList = this.getYearMoth(7,true);
			threeQuarterLists = this.areaYieldRateReportMapper.queryAreaYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
			
			startTime = String.valueOf(year)+"-07";
			endTime = String.valueOf(year)+"-09";
			monthList = this.getMoth(7);
			yearMonthList = this.getYearMoth(7,false);
			threeQuarterList = this.areaYieldRateReportMapper.queryAreaYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		}
		if (month > 9) {
			startTime = String.valueOf(year)+"-10";
			endTime = String.valueOf(year)+"-12";
			monthList = this.getMoth(10);
			yearMonthList = this.getYearMoth(10,true);
			fourQuarterLists = this.areaYieldRateReportMapper.queryAreaYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
			
			startTime = String.valueOf(year)+"-10";
			endTime = String.valueOf(year)+"-12";
			monthList = this.getMoth(10);
			yearMonthList = this.getYearMoth(10,false);
			fourQuarterList = this.areaYieldRateReportMapper.queryAreaYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		}
		AreaYieldRateReport rateReport = new AreaYieldRateReport();// 总计
		int i = 1;
		if (CollectionUtils.isNotEmpty(list)) {
			for (AreaYieldRateReport item : list) {
				// 当前月排名
				item.setMonthYieldRateRanking(i++);
				// 一月达成率、增长率
				if (CollectionUtils.isNotEmpty(oneQuarterList)) {
					for (AreaYieldRateReport lists : oneQuarterList) {
						if (item.getArea().equals(lists.getArea())) {
							item.setOneQuarterYieldRate(lists.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
							if (CollectionUtils.isNotEmpty(oneQuarterLists)) {
								for (AreaYieldRateReport listss : oneQuarterLists) {
									if (listss.getArea().equals(lists.getArea())) {
										if (listss.getMonthYieldRate().compareTo(new BigDecimal(0)) != 0) {
											BigDecimal growth = (lists.getMonthYieldRate().subtract(listss.getMonthYieldRate()))
													.divide(listss.getMonthYieldRate()).multiply(new BigDecimal(100));
											item.setOneQuarterGrowth(growth.setScale(2,BigDecimal.ROUND_HALF_UP));
										}
									}
								}
							}
						}
					}
				}
				// 二月达成率、增长率
				if (CollectionUtils.isNotEmpty(twoQuarterList)) {
					for (AreaYieldRateReport lists : twoQuarterList) {
						if (item.getArea().equals(lists.getArea())) {
							item.setTwoQuarterYieldRate(lists.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
							if (CollectionUtils.isNotEmpty(twoQuarterLists)) {
								for (AreaYieldRateReport listss : twoQuarterLists) {
									if (listss.getArea().equals(lists.getArea())) {
										if (listss.getMonthYieldRate().compareTo(new BigDecimal(0)) != 0) {
											BigDecimal growth = (lists.getMonthYieldRate().subtract(listss.getMonthYieldRate()))
													.divide(listss.getMonthYieldRate()).multiply(new BigDecimal(100));
											item.setTwoQuarterGrowth(growth.setScale(2,BigDecimal.ROUND_HALF_UP));
										}
									}
								}
							}
						}
					}
				}
				// 三月达成率、增长率
				if (CollectionUtils.isNotEmpty(threeQuarterList)) {
					for (AreaYieldRateReport lists : threeQuarterList) {
						if (item.getArea().equals(lists.getArea())) {
							item.setThreeQuarterYieldRate(lists.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
							if (CollectionUtils.isNotEmpty(threeQuarterLists)) {
								for (AreaYieldRateReport listss : threeQuarterLists) {
									if (listss.getArea().equals(lists.getArea())) {
										if (listss.getMonthYieldRate().compareTo(new BigDecimal(0)) != 0) {
											BigDecimal growth = (lists.getMonthYieldRate().subtract(listss.getMonthYieldRate()))
													.divide(listss.getMonthYieldRate()).multiply(new BigDecimal(100));
											item.setThreeQuarterGrowth(growth.setScale(2,BigDecimal.ROUND_HALF_UP));
										}
									}
								}
							}
						}
					}
				}
				// 四月达成率、增长率
				if (CollectionUtils.isNotEmpty(fourQuarterList)) {
					for (AreaYieldRateReport lists : fourQuarterList) {
						if (item.getArea().equals(lists.getArea())) {
							item.setFourQuarterYieldRate(lists.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
							if (CollectionUtils.isNotEmpty(fourQuarterLists)) {
								for (AreaYieldRateReport listss : fourQuarterLists) {
									if (listss.getArea().equals(lists.getArea())) {
										if (listss.getMonthYieldRate().compareTo(new BigDecimal(0)) != 0) {
											BigDecimal growth = (lists.getMonthYieldRate().subtract(listss.getMonthYieldRate()))
													.divide(listss.getMonthYieldRate()).multiply(new BigDecimal(100));
											item.setFourQuarterGrowth(growth.setScale(2,BigDecimal.ROUND_HALF_UP));
										}
									}
								}
							}
						}
					}
				}
				item.setMonthYieldRate(item.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
				// 年度达成率
				BigDecimal yearYieldRate = item.getOneQuarterYieldRate().add(item.getTwoQuarterYieldRate())
						.add(item.getThreeQuarterYieldRate()).add(item.getFourQuarterYieldRate());
				item.setYearYieldRate(yearYieldRate.setScale(2,BigDecimal.ROUND_HALF_UP));
				
				// 合计
				rateReport.setMonthYieldRate(item.getMonthYieldRate().add(rateReport.getMonthYieldRate()));
				rateReport.setOneQuarterYieldRate(item.getOneQuarterYieldRate().add(rateReport.getOneQuarterYieldRate()));
				rateReport.setTwoQuarterYieldRate(item.getTwoQuarterYieldRate().add(rateReport.getTwoQuarterYieldRate()));
				rateReport.setThreeQuarterYieldRate(item.getThreeQuarterYieldRate().add(rateReport.getThreeQuarterYieldRate()));
				rateReport.setFourQuarterYieldRate(item.getFourQuarterYieldRate().add(rateReport.getFourQuarterYieldRate()));
				rateReport.setYearYieldRate(item.getYearYieldRate().add(rateReport.getYearYieldRate()));
			}
			rateReport.setMonthYieldRate(rateReport.getMonthYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setOneQuarterYieldRate(rateReport.getOneQuarterYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setTwoQuarterYieldRate(rateReport.getTwoQuarterYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setThreeQuarterYieldRate(rateReport.getThreeQuarterYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setFourQuarterYieldRate(rateReport.getFourQuarterYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setYearYieldRate(rateReport.getYearYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setArea("9");
			list.add(rateReport);
		}
		return list;
	}
	@Override
	public List<AreaYieldRateReport> queryProvinceYieldRate(HttpServletRequest request, List<String> companyIds) {
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
	    int year = aCalendar.get(Calendar.YEAR);//年份
	    int month = aCalendar.get(Calendar.MONTH)+1;//月份
		List<String> monthList = new ArrayList<String>();
		List<String> yearMonthList = new ArrayList<String>();
		String startTime = StatisticAnalysisDateUtil.getMonth();
		String endTime = StatisticAnalysisDateUtil.getMonth();
		monthList.add(String.valueOf(month));
		yearMonthList.add(startTime);
		// 当月的业绩达成率及排名
		List<AreaYieldRateReport> list = this.areaYieldRateReportMapper.queryProvinceYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		// 本年第一季度达成率
		List<AreaYieldRateReport> oneQuarterList = new ArrayList<AreaYieldRateReport>();
		// 本年第二季度达成率
		List<AreaYieldRateReport> twoQuarterList = new ArrayList<AreaYieldRateReport>();
		// 本年第三季度达成率
		List<AreaYieldRateReport> threeQuarterList = new ArrayList<AreaYieldRateReport>();
		// 本年第四季度达成率
		List<AreaYieldRateReport> fourQuarterList = new ArrayList<AreaYieldRateReport>();
		
		// 去年第一季度达成率
		List<AreaYieldRateReport> oneQuarterLists = new ArrayList<AreaYieldRateReport>();
		// 去年第二季度达成率
		List<AreaYieldRateReport> twoQuarterLists = new ArrayList<AreaYieldRateReport>();
		// 去年第三季度达成率
		List<AreaYieldRateReport> threeQuarterLists = new ArrayList<AreaYieldRateReport>();
		// 去年第四季度达成率
		List<AreaYieldRateReport> fourQuarterLists = new ArrayList<AreaYieldRateReport>();
		
		if (month > 0) {
			startTime = String.valueOf(year-1)+"-01";
			endTime = String.valueOf(year-1)+"-03";
			monthList = this.getMoth(1);
			yearMonthList = this.getYearMoth(1,true);
			oneQuarterList = this.areaYieldRateReportMapper.queryProvinceYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
			
			startTime = String.valueOf(year)+"-01";
			endTime = String.valueOf(year)+"-03";
			monthList = this.getMoth(1);
			yearMonthList = this.getYearMoth(1,false);
			oneQuarterList = this.areaYieldRateReportMapper.queryProvinceYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		}
		if (month > 3) {
			startTime = String.valueOf(year)+"-04";
			endTime = String.valueOf(year)+"-06";
			monthList = this.getMoth(4);
			yearMonthList = this.getYearMoth(4,true);
			twoQuarterLists = this.areaYieldRateReportMapper.queryProvinceYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
			
			startTime = String.valueOf(year)+"-04";
			endTime = String.valueOf(year)+"-06";
			monthList = this.getMoth(4);
			yearMonthList = this.getYearMoth(4,false);
			twoQuarterList = this.areaYieldRateReportMapper.queryProvinceYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		}
		if (month > 6) {
			startTime = String.valueOf(year)+"-07";
			endTime = String.valueOf(year)+"-09";
			monthList = this.getMoth(7);
			yearMonthList = this.getYearMoth(7,true);
			threeQuarterLists = this.areaYieldRateReportMapper.queryProvinceYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
			
			startTime = String.valueOf(year)+"-07";
			endTime = String.valueOf(year)+"-09";
			monthList = this.getMoth(7);
			yearMonthList = this.getYearMoth(7,false);
			threeQuarterList = this.areaYieldRateReportMapper.queryProvinceYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		}
		if (month > 9) {
			startTime = String.valueOf(year)+"-10";
			endTime = String.valueOf(year)+"-12";
			monthList = this.getMoth(10);
			yearMonthList = this.getYearMoth(10,true);
			fourQuarterLists = this.areaYieldRateReportMapper.queryProvinceYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
			
			startTime = String.valueOf(year)+"-10";
			endTime = String.valueOf(year)+"-12";
			monthList = this.getMoth(10);
			yearMonthList = this.getYearMoth(10,false);
			fourQuarterList = this.areaYieldRateReportMapper.queryProvinceYieldRate(startTime, endTime, monthList, yearMonthList,companyIds);
		}
		AreaYieldRateReport rateReport = new AreaYieldRateReport();// 总计
		int i = 1;
		if (CollectionUtils.isNotEmpty(list)) {
			for (AreaYieldRateReport item : list) {
				// 当前月排名
				item.setMonthYieldRateRanking(i++);
				// 一月达成率、增长率
				if (CollectionUtils.isNotEmpty(oneQuarterList)) {
					for (AreaYieldRateReport lists : oneQuarterList) {
						if (item.getProvince().equals(lists.getProvince())) {
							item.setOneQuarterYieldRate(lists.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
							if (CollectionUtils.isNotEmpty(oneQuarterLists)) {
								for (AreaYieldRateReport listss : oneQuarterLists) {
									if (listss.getProvince().equals(lists.getProvince())) {
										if (listss.getMonthYieldRate().compareTo(new BigDecimal(0)) != 0) {
											BigDecimal growth = (lists.getMonthYieldRate().subtract(listss.getMonthYieldRate()))
													.divide(listss.getMonthYieldRate(),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
											item.setOneQuarterGrowth(growth);
										}
									}
								}
							}
						}
					}
				}
				// 二月达成率、增长率
				if (CollectionUtils.isNotEmpty(twoQuarterList)) {
					for (AreaYieldRateReport lists : twoQuarterList) {
						if (item.getProvince().equals(lists.getProvince())) {
							item.setTwoQuarterYieldRate(lists.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
							if (CollectionUtils.isNotEmpty(twoQuarterLists)) {
								for (AreaYieldRateReport listss : twoQuarterLists) {
									if (listss.getProvince().equals(lists.getProvince())) {
										if (listss.getMonthYieldRate().compareTo(new BigDecimal(0)) != 0) {
											BigDecimal growth = (lists.getMonthYieldRate().subtract(listss.getMonthYieldRate()))
													.divide(listss.getMonthYieldRate(),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
											item.setTwoQuarterGrowth(growth);
										}
									}
								}
							}
						}
					}
				}
				// 三月达成率、增长率
				if (CollectionUtils.isNotEmpty(threeQuarterList)) {
					for (AreaYieldRateReport lists : threeQuarterList) {
						if (item.getProvince().equals(lists.getProvince())) {
							item.setThreeQuarterYieldRate(lists.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
							if (CollectionUtils.isNotEmpty(threeQuarterLists)) {
								for (AreaYieldRateReport listss : threeQuarterLists) {
									if (listss.getProvince().equals(lists.getProvince())) {
										if (listss.getMonthYieldRate().compareTo(new BigDecimal(0)) != 0) {
											BigDecimal growth = (lists.getMonthYieldRate().subtract(listss.getMonthYieldRate()))
													.divide(listss.getMonthYieldRate(),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
											item.setThreeQuarterGrowth(growth);
										}
									}
								}
							}
						}
					}
				}
				// 四月达成率、增长率
				if (CollectionUtils.isNotEmpty(fourQuarterList)) {
					for (AreaYieldRateReport lists : fourQuarterList) {
						if (item.getProvince().equals(lists.getProvince())) {
							item.setFourQuarterYieldRate(lists.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
							if (CollectionUtils.isNotEmpty(fourQuarterLists)) {
								for (AreaYieldRateReport listss : fourQuarterLists) {
									if (listss.getProvince().equals(lists.getProvince())) {
										if (listss.getMonthYieldRate().compareTo(new BigDecimal(0)) != 0) {
											BigDecimal growth = (lists.getMonthYieldRate().subtract(listss.getMonthYieldRate()))
													.divide(listss.getMonthYieldRate(),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
											item.setFourQuarterGrowth(growth);
										}
									}
								}
							}
						}
					}
				}
				item.setMonthYieldRate(item.getMonthYieldRate().setScale(2,BigDecimal.ROUND_HALF_UP));
				// 年度达成率
				BigDecimal yearYieldRate = item.getOneQuarterYieldRate().add(item.getTwoQuarterYieldRate())
						.add(item.getThreeQuarterYieldRate()).add(item.getFourQuarterYieldRate());
				item.setYearYieldRate(yearYieldRate.setScale(2,BigDecimal.ROUND_HALF_UP));
				// 合计
				rateReport.setMonthYieldRate(item.getMonthYieldRate().add(rateReport.getMonthYieldRate()));
				rateReport.setOneQuarterYieldRate(item.getOneQuarterYieldRate().add(rateReport.getOneQuarterYieldRate()));
				rateReport.setTwoQuarterYieldRate(item.getTwoQuarterYieldRate().add(rateReport.getTwoQuarterYieldRate()));
				rateReport.setThreeQuarterYieldRate(item.getThreeQuarterYieldRate().add(rateReport.getThreeQuarterYieldRate()));
				rateReport.setFourQuarterYieldRate(item.getFourQuarterYieldRate().add(rateReport.getFourQuarterYieldRate()));
				rateReport.setYearYieldRate(item.getYearYieldRate().add(rateReport.getYearYieldRate()));
			}
			rateReport.setMonthYieldRate(rateReport.getMonthYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setOneQuarterYieldRate(rateReport.getOneQuarterYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setTwoQuarterYieldRate(rateReport.getTwoQuarterYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setThreeQuarterYieldRate(rateReport.getThreeQuarterYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setFourQuarterYieldRate(rateReport.getFourQuarterYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setYearYieldRate(rateReport.getYearYieldRate().divide(new BigDecimal(list.size()), 2, RoundingMode.HALF_UP));
			rateReport.setArea("9");
			list.add(rateReport);
		}
		return list;
	}
	
	@Override
	public List<AreaSummaryTable> queryAreaSummary(HttpServletRequest request, List<String> companyIds) {
		List<AreaSummaryTable> tableList = this.areaYieldRateReportMapper.queryProvince(companyIds);
		
		List<AreaSummaryTable> list = this.areaYieldRateReportMapper.queryAreaSummary(companyIds);
		
		if (CollectionUtils.isNotEmpty(tableList)) {
			for (AreaSummaryTable item : tableList) {
				if (CollectionUtils.isNotEmpty(list)) {
					for (AreaSummaryTable item2 : list) {
						if (item.getProvince().equals(item2.getProvince())) {
							// 把每个月的目标金额和每个月的回款金额塞好
							assemblyMonthTotal(item,item2);
						}
					}
				}
			}
			// 通过每个月的金额进行计算出其它字段的金额及百分比
			assemblyData(tableList, list);
			// 拼上区域总和
			tableList = addAreatotal(tableList);
		}
		
		return tableList;
	}
	
	@Override
	public List<AreaSummaryTable> querySalesDetailReport(HttpServletRequest request,List<String> companyIds) {
		List<AreaSummaryTable> tableList = this.areaYieldRateReportMapper.querySalesDetailReport(companyIds);
		
		List<AreaSummaryTable> list = this.areaYieldRateReportMapper.salesDetailReport(companyIds);
		
		if (CollectionUtils.isNotEmpty(tableList)) {
			for (AreaSummaryTable item : tableList) {
				if (CollectionUtils.isNotEmpty(list)) {
					for (AreaSummaryTable item2 : list) {
						if (item.getCompanyId().equals(item2.getCompanyId())) {
							// 把每个月的目标金额和每个月的回款金额塞好
							assemblyMonthTotal(item,item2);
						}
					}
				}
			}
			// 通过每个月的金额进行计算出其它字段的金额及百分比
			assemblyData(tableList, list);
			// 拼上省份总和及区域总和
			tableList = addAreaTotalAndProvinceTotal(tableList);
		}
		
		return tableList;
	}
	
	public void assemblyMonthTotal(AreaSummaryTable item, AreaSummaryTable item2){
		Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
	    int year = aCalendar.get(Calendar.YEAR);//年份
	    
	    // 合同开始时间
	    item.setStateDate(item2.getStateDate());
		// 塞入12个月的目标金额
	    if (StringUtils.isNotEmpty(item2.getMonth()) && item2.getMonthTargetTotal().compareTo(new BigDecimal(0)) != 0) {
	    	switch(item2.getMonth()) 
	    	{ 
	    	case "1": 
	    		item.setOneMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "2": 
	    		item.setTwoMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "3": 
	    		item.setThreeMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "4": 
	    		item.setFourMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "5": 
	    		item.setFiveMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "6": 
	    		item.setSixMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "7": 
	    		item.setSevenMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "8": 
	    		item.setEightMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "9": 
	    		item.setNineMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "10": 
	    		item.setTenMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "11": 
	    		item.setElevenMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	case "12": 
	    		item.setTwelveMonthTargetTotal(item2.getMonthTargetTotal());
	    		break; 
	    	} 
	    }
		// 判断年月、塞入每个月的支付金额
		if (StringUtils.isNotEmpty(item2.getPayTime())) {
			if (item2.getPayTime().equals(String.valueOf(year)+"-01")) {
				item.setYearOneMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-01")) {
				item.setLastYearOneMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-02")) {
				item.setYearTwoMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-02")) {
				item.setLastYearTwoMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-03")) {
				item.setYearThreeMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-03")) {
				item.setLastYearThreeMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-04")) {
				item.setYearFourMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-04")) {
				item.setLastYearFourMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-05")) {
				item.setYearFiveMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-05")) {
				item.setLastYearFiveMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-06")) {
				item.setYearSixMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-06")) {
				item.setLastYearSixMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-07")) {
				item.setYearSevenMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-07")) {
				item.setLastYearSevenMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-08")) {
				item.setYearEightMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-08")) {
				item.setLastYearEightMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-09")) {
				item.setYearNineMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-09")) {
				item.setLastYearNineMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-10")) {
				item.setYearTenMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-10")) {
				item.setLastYearTenMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-11")) {
				item.setYearElevenMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-11")) {
				item.setLastYearElevenMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year)+"-12")) {
				item.setYearTwelveMonthPay(item2.getPayAmount());
			}else if (item2.getPayTime().equals(String.valueOf(year-1)+"-12")) {
				item.setLastYearTwelveMonthPay(item2.getPayAmount());
			}
		}
	
	}
	
	public void assemblyData(List<AreaSummaryTable> tableList, List<AreaSummaryTable> list) {
		
		if (CollectionUtils.isNotEmpty(tableList)) {
			BigDecimal bai = new BigDecimal(100);
			BigDecimal b = new BigDecimal(0);
			for (AreaSummaryTable item : tableList) {
				// 第一季度回款目标额
				item.setOneQuarterTargetTotal(item.getOneMonthTargetTotal().add(item.getTwoMonthTargetTotal())
						.add(item.getThreeMonthTargetTotal()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 本年度一季度合计(实销回款)
				item.setYearOneQuarterPay(item.getYearOneMonthPay().add(item.getYearTwoMonthPay())
						.add(item.getYearThreeMonthPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 上年度一季度合计(实销回款)
				item.setLastYearOneQuarterPay(item.getLastYearOneMonthPay().add(item.getLastYearTwoMonthPay())
						.add(item.getLastYearThreeMonthPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				
				if (item.getYearOneQuarterPay().compareTo(b) != 0 && item.getOneQuarterTargetTotal().compareTo(b) != 0) {
					// 第一季度(回款达成率)
					item.setOneQuarterYieldRate(item.getYearOneQuarterPay().divide(item.getOneQuarterTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearOneMonthPay().compareTo(b) != 0 && item.getOneMonthTargetTotal().compareTo(b) != 0) {
					// 一月(回款达成率)
					item.setOneMonthYieldRate(item.getYearOneMonthPay().divide(item.getOneMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearTwoMonthPay().compareTo(b) != 0 && item.getTwoMonthTargetTotal().compareTo(b) != 0) {
					// 二月(回款达成率)
					item.setTwoMonthYieldRate(item.getYearTwoMonthPay().divide(item.getTwoMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearThreeMonthPay().compareTo(b) != 0 && item.getThreeMonthTargetTotal().compareTo(b) != 0) {
					// 三月(回款达成率)
					item.setThreeMonthYieldRate(item.getYearThreeMonthPay().divide(item.getThreeMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearOneQuarterPay().compareTo(b) != 0 && item.getLastYearOneQuarterPay().compareTo(b) != 0) {
					// 第一季度实销回款同期比
					item.setOneQuarterGrowth(item.getYearOneQuarterPay().subtract(item.getLastYearOneQuarterPay())
							.divide(item.getLastYearOneQuarterPay(),4,BigDecimal.ROUND_HALF_EVEN).multiply(bai));
				}
				if (item.getYearOneMonthPay().compareTo(b) != 0 && item.getLastYearOneMonthPay().compareTo(b) != 0) {
					// 1月实销回款同期比
					item.setOneMonthPayGrowth(item.getYearOneMonthPay().subtract(item.getLastYearOneMonthPay())
							.divide(item.getLastYearOneMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearTwoMonthPay().compareTo(b) != 0 && item.getLastYearTwoMonthPay().compareTo(b) != 0) {
					// 2月实销回款同期比
					item.setTwoMonthPayGrowth(item.getYearTwoMonthPay().subtract(item.getLastYearTwoMonthPay())
							.divide(item.getLastYearTwoMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearThreeMonthPay().compareTo(b) != 0 && item.getLastYearThreeMonthPay().compareTo(b) != 0) {
					// 3月实销回款同期比
					item.setThreeMonthPayGrowth(item.getYearThreeMonthPay().subtract(item.getLastYearThreeMonthPay())
							.divide(item.getLastYearThreeMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				// 第二季度回款目标额
				item.setTwoQuarterTargetTotal(item.getFourMonthTargetTotal().add(item.getFiveMonthTargetTotal())
						.add(item.getSixMonthTargetTotal()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 本年度二季度合计(实销回款)
				item.setYearTwoQuarterPay(item.getYearFourMonthPay().add(item.getYearFiveMonthPay())
						.add(item.getYearSixMonthPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 上年度二季度合计(实销回款)
				item.setLastYearTwoQuarterPay(item.getLastYearFourMonthPay().add(item.getLastYearFiveMonthPay())
						.add(item.getLastYearSixMonthPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				if (item.getYearTwoQuarterPay().compareTo(b) != 0 && item.getTwoQuarterTargetTotal().compareTo(b) != 0) {
					// 第二季度(回款达成率)
					item.setTwoQuarterYieldRate(item.getYearTwoQuarterPay().divide(item.getTwoQuarterTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearFourMonthPay().compareTo(b) != 0 && item.getFourMonthTargetTotal().compareTo(b) != 0) {
					// 四月(回款达成率)
					item.setFourMonthYieldRate(item.getYearFourMonthPay().divide(item.getFourMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearFiveMonthPay().compareTo(b) != 0 && item.getFiveMonthTargetTotal().compareTo(b) != 0) {
					// 五月(回款达成率)
					item.setFiveMonthYieldRate(item.getYearFiveMonthPay().divide(item.getFiveMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearSixMonthPay().compareTo(b) != 0 && item.getSixMonthTargetTotal().compareTo(b) != 0) {
					// 六月(回款达成率)
					item.setSixMonthYieldRate(item.getYearSixMonthPay().divide(item.getSixMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearTwoQuarterPay().compareTo(b) != 0 && item.getLastYearTwoQuarterPay().compareTo(b) != 0) {
					// 第二季度实销回款同期比
					item.setTwoQuarterGrowth(item.getYearTwoQuarterPay().subtract(item.getLastYearTwoQuarterPay())
							.divide(item.getLastYearTwoQuarterPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearFourMonthPay().compareTo(b) != 0 && item.getLastYearFourMonthPay().compareTo(b) != 0) {
					// 4月实销回款同期比
					item.setFourMonthPayGrowth(item.getYearFourMonthPay().subtract(item.getLastYearFourMonthPay())
							.divide(item.getLastYearFourMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearFiveMonthPay().compareTo(b) != 0 && item.getLastYearFiveMonthPay().compareTo(b) != 0) {
					// 5月实销回款同期比
					
					item.setFiveMonthPayGrowth(item.getYearFiveMonthPay().subtract(item.getLastYearFiveMonthPay())
							.divide(item.getLastYearFiveMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearSixMonthPay().compareTo(b) != 0 && item.getLastYearSixMonthPay().compareTo(b) != 0) {
					// 6月实销回款同期比
					item.setSixMonthPayGrowth(item.getYearSixMonthPay().subtract(item.getLastYearSixMonthPay())
							.divide(item.getLastYearSixMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				// 第三季度回款目标额
				item.setThreeQuarterTargetTotal(item.getSevenMonthTargetTotal().add(item.getEightMonthTargetTotal())
						.add(item.getNineMonthTargetTotal()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 本年度三季度合计(实销回款)
				item.setYearThreeQuarterPay(item.getYearSevenMonthPay().add(item.getYearEightMonthPay())
						.add(item.getYearNineMonthPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 上年度三季度合计(实销回款)
				item.setLastYearThreeQuarterPay(item.getLastYearSevenMonthPay().add(item.getLastYearEightMonthPay())
						.add(item.getLastYearNineMonthPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				if (item.getYearThreeQuarterPay().compareTo(b) != 0 && item.getThreeQuarterTargetTotal().compareTo(b) != 0) {
					// 第三季度(回款达成率)
					item.setThreeQuarterYieldRate(item.getYearThreeQuarterPay().divide(item.getThreeQuarterTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearSevenMonthPay().compareTo(b) != 0 && item.getSevenMonthTargetTotal().compareTo(b) != 0) {
					// 七月(回款达成率)
					item.setSevenMonthYieldRate(item.getYearSevenMonthPay().divide(item.getSevenMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearEightMonthPay().compareTo(b) != 0 && item.getEightMonthTargetTotal().compareTo(b) != 0) {
					// 八月(回款达成率)
					item.setEightMonthYieldRate(item.getYearEightMonthPay().divide(item.getEightMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearNineMonthPay().compareTo(b) != 0 && item.getNineMonthTargetTotal().compareTo(b) != 0) {
					// 九月(回款达成率)
					item.setNineMonthYieldRate(item.getYearNineMonthPay().divide(item.getNineMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearThreeQuarterPay().compareTo(b) != 0 && item.getLastYearThreeQuarterPay().compareTo(b) != 0) {
					// 第三季度实销回款同期比
					item.setThreeQuarterGrowth(item.getYearThreeQuarterPay().subtract(item.getLastYearThreeQuarterPay())
							.divide(item.getLastYearThreeQuarterPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearSevenMonthPay().compareTo(b) != 0 && item.getLastYearSevenMonthPay().compareTo(b) != 0) {
					// 7月实销回款同期比
					item.setSevenMonthPayGrowth(item.getYearSevenMonthPay().subtract(item.getLastYearSevenMonthPay())
							.divide(item.getLastYearSevenMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearEightMonthPay().compareTo(b) != 0 && item.getLastYearEightMonthPay().compareTo(b) != 0) {
					// 8月实销回款同期比
					item.setEightMonthPayGrowth(item.getYearEightMonthPay().subtract(item.getLastYearEightMonthPay())
							.divide(item.getLastYearEightMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearNineMonthPay().compareTo(b) != 0 && item.getLastYearNineMonthPay().compareTo(b) != 0) {
					// 9月实销回款同期比
					item.setNineMonthPayGrowth(item.getYearNineMonthPay().subtract(item.getLastYearNineMonthPay())
							.divide(item.getLastYearNineMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				// 第四季度回款目标额
				item.setFourQuarterTargetTotal(item.getTenMonthTargetTotal().add(item.getElevenMonthTargetTotal())
						.add(item.getTwelveMonthTargetTotal()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 本年度四季度合计(实销回款)
				item.setYearFourQuarterPay(item.getYearTenMonthPay().add(item.getYearElevenMonthPay())
						.add(item.getYearTwelveMonthPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 上年度四季度合计(实销回款)
				item.setLastYearFourQuarterPay(item.getLastYearTenMonthPay().add(item.getLastYearElevenMonthPay())
						.add(item.getLastYearTwelveMonthPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				if (item.getYearFourQuarterPay().compareTo(b) != 0 && item.getFourQuarterTargetTotal().compareTo(b) != 0) {
					// 第四季度(回款达成率)
					item.setFourQuarterYieldRate(item.getYearFourQuarterPay().divide(item.getFourQuarterTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearTenMonthPay().compareTo(b) != 0 && item.getTenMonthTargetTotal().compareTo(b) != 0) {
					// 十月(回款达成率)
					item.setTenMonthYieldRate(item.getYearTenMonthPay().divide(item.getTenMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearElevenMonthPay().compareTo(b) != 0 && item.getElevenMonthTargetTotal().compareTo(b) != 0) {
					// 十一月(回款达成率)
					item.setElevenMonthYieldRate(item.getYearElevenMonthPay().divide(item.getElevenMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearTwelveMonthPay().compareTo(b) != 0 && item.getTwelveMonthTargetTotal().compareTo(b) != 0) {
					// 十二月(回款达成率)
					item.setTwelveMonthYieldRate(item.getYearTwelveMonthPay().divide(item.getTwelveMonthTargetTotal(),4,BigDecimal.ROUND_HALF_UP)
							.multiply(bai));
				}
				if (item.getYearFourQuarterPay().compareTo(b) != 0 && item.getLastYearFourQuarterPay().compareTo(b) != 0) {
					// 第四季度实销回款同期比
					item.setFourQuarterGrowth(item.getYearFourQuarterPay().subtract(item.getLastYearFourQuarterPay())
							.divide(item.getLastYearFourQuarterPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearTenMonthPay().compareTo(b) != 0 && item.getLastYearTenMonthPay().compareTo(b) != 0) {
					// 10月实销回款同期比
					item.setTenMonthPayGrowth(item.getYearTenMonthPay().subtract(item.getLastYearTenMonthPay())
							.divide(item.getLastYearTenMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearElevenMonthPay().compareTo(b) != 0 && item.getLastYearElevenMonthPay().compareTo(b) != 0) {
					// 11月实销回款同期比
					item.setElevenMonthPayGrowth(item.getYearElevenMonthPay().subtract(item.getLastYearElevenMonthPay())
							.divide(item.getLastYearElevenMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				if (item.getYearTwelveMonthPay().compareTo(b) != 0 && item.getLastYearTwelveMonthPay().compareTo(b) != 0) {
					// 12月实销回款同期比
					item.setTwelveMonthPayGrowth(item.getYearTwelveMonthPay().subtract(item.getLastYearTwelveMonthPay())
							.divide(item.getLastYearTwelveMonthPay(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				
				// 全年回款目标金额
				item.setYearTargetTotal(item.getOneQuarterTargetTotal().add(item.getTwoQuarterTargetTotal())
						.add(item.getThreeQuarterTargetTotal()).add(item.getFourQuarterTargetTotal()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 本年实销回款
				item.setYearPayTotal(item.getYearOneQuarterPay().add(item.getYearTwoQuarterPay())
						.add(item.getYearThreeQuarterPay()).add(item.getYearFourQuarterPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				if (item.getYearPayTotal().compareTo(b) != 0 && item.getYearTargetTotal().compareTo(b) != 0) {
					// 年度达成率
					item.setYearYieldRate(item.getYearPayTotal().divide(item.getYearTargetTotal(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
				// 上年度回款合计
				item.setLastYearPayTotal(item.getLastYearOneQuarterPay().add(item.getLastYearTwoQuarterPay())
						.add(item.getLastYearThreeQuarterPay()).add(item.getLastYearFourQuarterPay()).setScale(2,BigDecimal.ROUND_HALF_UP));
				// 本年度VS上年度差额
				item.setYearVSLastYearTotal(item.getYearPayTotal().subtract(item.getLastYearPayTotal()));
				
				if (item.getYearPayTotal().compareTo(b) != 0 && item.getLastYearPayTotal().compareTo(b) != 0) {
					// 全年实销回款同期比
					item.setYearPayGrowth(item.getYearPayTotal().subtract(item.getLastYearPayTotal())
							.divide(item.getLastYearPayTotal(),4,BigDecimal.ROUND_HALF_UP).multiply(bai));
				}
			}
			
		}
	}
	
	public List<AreaSummaryTable> addAreatotal (List<AreaSummaryTable> tableList) {
		List<AreaSummaryTable> returnList = new ArrayList<AreaSummaryTable>();
		Map<String, String> areaMap = new HashMap<String, String>();
		areaMap.put("1", "华东地区");
		areaMap.put("2", "华南地区");
		areaMap.put("3", "华中地区");
		areaMap.put("4", "华北地区");
		areaMap.put("5", "西北地区");
		areaMap.put("6", "西南地区");
		areaMap.put("7", "东北地区");
		areaMap.put("8", "台港澳地区");
		
		if (CollectionUtils.isNotEmpty(tableList)) {
			// 公司总计
			AreaSummaryTable companyRow = new AreaSummaryTable();
			// 大区总计
			AreaSummaryTable row = new AreaSummaryTable();
			
			BigDecimal areaSize = new BigDecimal(0);
			BigDecimal companySize = new BigDecimal(0);
			
			for (AreaSummaryTable item : tableList) {
				
				if (compareAreaRepeat(item,returnList)) {
					total(row, areaSize);
					returnList.add(row);
					row = new AreaSummaryTable();
					areaSize = new BigDecimal(0);
				}
				
				if (StringUtils.isNotEmpty(item.getArea())) {
					row.setAreaName(areaMap.get(item.getArea())+"合计");
					item.setAreaName(areaMap.get(item.getArea()));
				}
				returnList.add(item);
				
				areaSize = areaSize.add(new BigDecimal(1));
				companySize = companySize.add(new BigDecimal(1));
				
				rowTotal(row,item);
				
				rowTotal(companyRow,item);
			}
			total(row, areaSize);
			returnList.add(row);
			total(companyRow, companySize);
			companyRow.setAreaName("公司总计");
			returnList.add(companyRow);
		}
		return returnList;
	}
	
	public List<AreaSummaryTable> addAreaTotalAndProvinceTotal (List<AreaSummaryTable> tableList) {
		List<AreaSummaryTable> returnList = new ArrayList<AreaSummaryTable>();
		Map<String, String> areaMap = new HashMap<String, String>();
		areaMap.put("1", "华东地区");
		areaMap.put("2", "华南地区");
		areaMap.put("3", "华中地区");
		areaMap.put("4", "华北地区");
		areaMap.put("5", "西北地区");
		areaMap.put("6", "西南地区");
		areaMap.put("7", "东北地区");
		areaMap.put("8", "台港澳地区");
		
		if (CollectionUtils.isNotEmpty(tableList)) {
			// 公司总计
			AreaSummaryTable companyRow = new AreaSummaryTable();
			// 大区合计
			AreaSummaryTable row = new AreaSummaryTable();
			// 省合计
			AreaSummaryTable row2 = new AreaSummaryTable();
			
			BigDecimal areaSize = new BigDecimal(0);
			BigDecimal provinceSize = new BigDecimal(0);
			BigDecimal companySize = new BigDecimal(0);
			
			for (AreaSummaryTable item : tableList) {
				
				if (compareProvinceRepeat(item,returnList)) {
					total(row2, provinceSize);
					returnList.add(row2);
					row2 = new AreaSummaryTable();
					provinceSize = new BigDecimal(0);
				}
				
				if (compareAreaRepeat(item,returnList)) {
					total(row, areaSize);
					returnList.add(row);
					row = new AreaSummaryTable();
					areaSize = new BigDecimal(0);
				}
				
				if (StringUtils.isNotEmpty(item.getArea())) {
					row.setAreaName(areaMap.get(item.getArea())+"合计");
					item.setAreaName(areaMap.get(item.getArea()));
				}
				returnList.add(item);
				
				areaSize = areaSize.add(new BigDecimal(1));
				provinceSize = provinceSize.add(new BigDecimal(1));
				companySize = companySize.add(new BigDecimal(1));
				
				rowTotal(companyRow,item);
				
				rowTotal(row,item);
				
				rowTotal(row2,item);
				row2.setProvinceName(item.getProvinceName()+"合计");
			}
			total(row2, provinceSize);
			returnList.add(row2);
			total(row, areaSize);
			returnList.add(row);
			total(companyRow, companySize);
			companyRow.setAreaName("公司总计");
			returnList.add(companyRow);
		}
		return returnList;
	}
	
	public void total (AreaSummaryTable row, BigDecimal size) {
		row.setYearYieldRate(row.getYearYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setYearPayGrowth(row.getYearPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setOneQuarterYieldRate(row.getOneQuarterYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setOneMonthYieldRate(row.getOneMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setTwoMonthYieldRate(row.getTwoMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setThreeMonthYieldRate(row.getThreeMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setOneQuarterGrowth(row.getOneQuarterGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setOneMonthPayGrowth(row.getOneMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setTwoMonthPayGrowth(row.getTwoMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setThreeMonthPayGrowth(row.getThreeMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setTwoQuarterYieldRate(row.getTwoQuarterYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setFourMonthYieldRate(row.getFourMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setFiveMonthYieldRate(row.getFiveMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setSixMonthYieldRate(row.getSixMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setTwoQuarterGrowth(row.getTwoQuarterGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setFourMonthPayGrowth(row.getFourMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setFiveMonthPayGrowth(row.getFiveMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setSixMonthPayGrowth(row.getSixMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setThreeQuarterYieldRate(row.getThreeQuarterYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setSevenMonthYieldRate(row.getSevenMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setEightMonthYieldRate(row.getEightMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setNineMonthYieldRate(row.getNineMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setThreeQuarterGrowth(row.getThreeQuarterGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setSevenMonthPayGrowth(row.getSevenMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setEightMonthPayGrowth(row.getEightMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setNineMonthPayGrowth(row.getNineMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setFourQuarterYieldRate(row.getFourQuarterYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setTenMonthYieldRate(row.getTenMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setElevenMonthYieldRate(row.getElevenMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setTwelveMonthYieldRate(row.getTwelveMonthYieldRate().divide(size, 2, RoundingMode.HALF_UP));
		row.setFourQuarterGrowth(row.getFourQuarterGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setTenMonthPayGrowth(row.getTenMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setElevenMonthPayGrowth(row.getElevenMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
		row.setTwelveMonthPayGrowth(row.getTwelveMonthPayGrowth().divide(size, 2, RoundingMode.HALF_UP));
	}
	
	public void rowTotal (AreaSummaryTable row, AreaSummaryTable item){
		row.setYearTargetTotal(row.getYearTargetTotal().add(item.getYearTargetTotal()));
		row.setYearPayTotal(row.getYearPayTotal().add(item.getYearPayTotal()));
		row.setYearYieldRate(row.getYearYieldRate().add(item.getYearYieldRate()));
		row.setLastYearPayTotal(row.getLastYearPayTotal().add(item.getLastYearPayTotal()));
		row.setYearVSLastYearTotal(row.getYearVSLastYearTotal().add(item.getYearVSLastYearTotal()));
		row.setYearPayGrowth(row.getYearPayGrowth().add(item.getYearPayGrowth()));
		row.setOneQuarterTargetTotal(row.getOneQuarterTargetTotal().add(item.getOneQuarterTargetTotal()));
		row.setOneMonthTargetTotal(row.getOneMonthTargetTotal().add(item.getOneMonthTargetTotal()));
		row.setTwoMonthTargetTotal(row.getTwoMonthTargetTotal().add(item.getTwoMonthTargetTotal()));
		row.setThreeMonthTargetTotal(row.getThreeMonthTargetTotal().add(item.getThreeMonthTargetTotal()));
		row.setOneQuarterYieldRate(row.getOneQuarterYieldRate().add(item.getOneQuarterYieldRate()));
		row.setOneMonthYieldRate(row.getOneMonthYieldRate().add(item.getOneMonthYieldRate()));
		row.setTwoMonthYieldRate(row.getTwoMonthYieldRate().add(item.getTwoMonthYieldRate()));
		row.setThreeMonthYieldRate(row.getThreeMonthYieldRate().add(item.getThreeMonthYieldRate()));
		row.setYearOneQuarterPay(row.getYearOneQuarterPay().add(item.getYearOneQuarterPay()));
		row.setLastYearOneQuarterPay(row.getLastYearOneQuarterPay().add(item.getLastYearOneQuarterPay()));
		row.setOneQuarterGrowth(row.getOneQuarterGrowth().add(item.getOneQuarterGrowth()));
		row.setYearOneMonthPay(row.getYearOneMonthPay().add(item.getYearOneMonthPay()));
		row.setLastYearOneMonthPay(row.getLastYearOneMonthPay().add(item.getLastYearOneMonthPay()));
		row.setOneMonthPayGrowth(row.getOneMonthPayGrowth().add(item.getOneMonthPayGrowth()));
		row.setYearTwoMonthPay(row.getYearTwoMonthPay().add(item.getYearTwoMonthPay()));
		row.setLastYearTwoMonthPay(row.getLastYearTwoMonthPay().add(item.getLastYearTwoMonthPay()));
		row.setTwoMonthPayGrowth(row.getTwoMonthPayGrowth().add(item.getTwoMonthPayGrowth()));
		row.setYearThreeMonthPay(row.getYearThreeMonthPay().add(item.getYearThreeMonthPay()));
		row.setLastYearThreeMonthPay(row.getLastYearThreeMonthPay().add(item.getLastYearThreeMonthPay()));
		row.setThreeMonthPayGrowth(row.getThreeMonthPayGrowth().add(item.getThreeMonthPayGrowth()));
		row.setTwoQuarterTargetTotal(row.getTwoQuarterTargetTotal().add(item.getTwoQuarterTargetTotal()));
		row.setFourMonthTargetTotal(row.getFourMonthTargetTotal().add(item.getFourMonthTargetTotal()));
		row.setFiveMonthTargetTotal(row.getFiveMonthTargetTotal().add(item.getFiveMonthTargetTotal()));
		row.setSixMonthTargetTotal(row.getSixMonthTargetTotal().add(item.getSixMonthTargetTotal()));
		row.setTwoQuarterYieldRate(row.getTwoQuarterYieldRate().add(item.getTwoQuarterYieldRate()));
		row.setFourMonthYieldRate(row.getFourMonthYieldRate().add(item.getFourMonthYieldRate()));
		row.setFiveMonthYieldRate(row.getFiveMonthYieldRate().add(item.getFiveMonthYieldRate()));
		row.setSixMonthYieldRate(row.getSixMonthYieldRate().add(item.getSixMonthYieldRate()));
		row.setYearTwoQuarterPay(row.getYearTwoQuarterPay().add(item.getYearTwoQuarterPay()));
		row.setLastYearTwoQuarterPay(row.getLastYearTwoQuarterPay().add(item.getLastYearTwoQuarterPay()));
		row.setTwoQuarterGrowth(row.getTwoQuarterGrowth().add(item.getTwoQuarterGrowth()));
		row.setYearFourMonthPay(row.getYearFourMonthPay().add(item.getYearFourMonthPay()));
		row.setLastYearFourMonthPay(row.getLastYearFourMonthPay().add(item.getLastYearFourMonthPay()));
		row.setFourMonthPayGrowth(row.getFourMonthPayGrowth().add(item.getFourMonthPayGrowth()));
		row.setYearFiveMonthPay(row.getYearFiveMonthPay().add(item.getYearFiveMonthPay()));
		row.setLastYearFiveMonthPay(row.getLastYearFiveMonthPay().add(item.getLastYearFiveMonthPay()));
		row.setFiveMonthPayGrowth(row.getFiveMonthPayGrowth().add(item.getFiveMonthPayGrowth()));
		row.setYearSixMonthPay(row.getYearSixMonthPay().add(item.getYearSixMonthPay()));
		row.setLastYearSixMonthPay(row.getLastYearSixMonthPay().add(item.getLastYearSixMonthPay()));
		row.setSixMonthPayGrowth(row.getSixMonthPayGrowth().add(item.getSixMonthPayGrowth()));
		row.setThreeQuarterTargetTotal(row.getThreeQuarterTargetTotal().add(item.getThreeQuarterTargetTotal()));
		row.setSevenMonthTargetTotal(row.getSevenMonthTargetTotal().add(item.getSevenMonthTargetTotal()));
		row.setEightMonthTargetTotal(row.getEightMonthTargetTotal().add(item.getEightMonthTargetTotal()));
		row.setNineMonthTargetTotal(row.getNineMonthTargetTotal().add(item.getNineMonthTargetTotal()));
		row.setThreeQuarterYieldRate(row.getThreeQuarterYieldRate().add(item.getThreeQuarterYieldRate()));
		row.setSevenMonthYieldRate(row.getSevenMonthYieldRate().add(item.getSevenMonthYieldRate()));
		row.setEightMonthYieldRate(row.getEightMonthYieldRate().add(item.getEightMonthYieldRate()));
		row.setNineMonthYieldRate(row.getNineMonthYieldRate().add(item.getNineMonthYieldRate()));
		row.setYearThreeQuarterPay(row.getYearThreeQuarterPay().add(item.getYearThreeQuarterPay()));
		row.setLastYearThreeQuarterPay(row.getLastYearThreeQuarterPay().add(item.getLastYearThreeQuarterPay()));
		row.setThreeQuarterGrowth(row.getThreeQuarterGrowth().add(item.getThreeQuarterGrowth()));
		row.setYearSevenMonthPay(row.getYearSevenMonthPay().add(item.getYearSevenMonthPay()));
		row.setLastYearSevenMonthPay(row.getLastYearSevenMonthPay().add(item.getLastYearSevenMonthPay()));
		row.setSevenMonthPayGrowth(row.getSevenMonthPayGrowth().add(item.getSevenMonthPayGrowth()));
		row.setYearEightMonthPay(row.getYearEightMonthPay().add(item.getYearEightMonthPay()));
		row.setLastYearEightMonthPay(row.getLastYearEightMonthPay().add(item.getLastYearEightMonthPay()));
		row.setEightMonthPayGrowth(row.getEightMonthPayGrowth().add(item.getEightMonthPayGrowth()));
		row.setYearNineMonthPay(row.getYearNineMonthPay().add(item.getYearNineMonthPay()));
		row.setLastYearNineMonthPay(row.getLastYearNineMonthPay().add(item.getLastYearNineMonthPay()));
		row.setNineMonthPayGrowth(row.getNineMonthPayGrowth().add(item.getNineMonthPayGrowth()));
		row.setFourQuarterTargetTotal(row.getFourQuarterTargetTotal().add(item.getFourQuarterTargetTotal()));
		row.setTenMonthTargetTotal(row.getTenMonthTargetTotal().add(item.getTenMonthTargetTotal()));
		row.setElevenMonthTargetTotal(row.getElevenMonthTargetTotal().add(item.getElevenMonthTargetTotal()));
		row.setTwelveMonthTargetTotal(row.getTwelveMonthTargetTotal().add(item.getTwelveMonthTargetTotal()));
		row.setFourQuarterYieldRate(row.getFourQuarterYieldRate().add(item.getFourQuarterYieldRate()));
		row.setTenMonthYieldRate(row.getTenMonthYieldRate().add(item.getTenMonthYieldRate()));
		row.setElevenMonthYieldRate(row.getElevenMonthYieldRate().add(item.getElevenMonthYieldRate()));
		row.setTwelveMonthYieldRate(row.getTwelveMonthYieldRate().add(item.getTwelveMonthYieldRate()));
		row.setYearFourQuarterPay(row.getYearFourQuarterPay().add(item.getYearFourQuarterPay()));
		row.setLastYearFourQuarterPay(row.getLastYearFourQuarterPay().add(item.getLastYearFourQuarterPay()));
		row.setFourQuarterGrowth(row.getFourQuarterGrowth().add(item.getFourQuarterGrowth()));
		row.setYearTenMonthPay(row.getYearTenMonthPay().add(item.getYearTenMonthPay()));
		row.setLastYearTenMonthPay(row.getLastYearTenMonthPay().add(item.getLastYearTenMonthPay()));
		row.setTenMonthPayGrowth(row.getTenMonthPayGrowth().add(item.getTenMonthPayGrowth()));
		row.setYearElevenMonthPay(row.getYearElevenMonthPay().add(item.getYearElevenMonthPay()));
		row.setLastYearElevenMonthPay(row.getLastYearElevenMonthPay().add(item.getLastYearElevenMonthPay()));
		row.setElevenMonthPayGrowth(row.getElevenMonthPayGrowth().add(item.getElevenMonthPayGrowth()));
		row.setYearTwelveMonthPay(row.getYearTwelveMonthPay().add(item.getYearTwelveMonthPay()));
		row.setLastYearTwelveMonthPay(row.getLastYearTwelveMonthPay().add(item.getLastYearTwelveMonthPay()));
		row.setTwelveMonthPayGrowth(row.getTwelveMonthPayGrowth().add(item.getTwelveMonthPayGrowth()));
	}
	
	
	
	public Boolean compareAreaRepeat(AreaSummaryTable item,List<AreaSummaryTable> returnList){
		Boolean b = true;
		if (CollectionUtils.isNotEmpty(returnList)) {
			for (AreaSummaryTable item2 : returnList) {
				if (item.getArea().equals(item2.getArea())) {
					b = false;
					break;
				}
			}
		}else{
			b = false;
		}
		return b;
	}
	
	public Boolean compareProvinceRepeat(AreaSummaryTable item,List<AreaSummaryTable> returnList){
		Boolean b = true;
		if (CollectionUtils.isNotEmpty(returnList)) {
			for (AreaSummaryTable item2 : returnList) {
				if (item.getProvince().equals(item2.getProvince())) {
					b = false;
					break;
				}
			}
		}else{
			b = false;
		}
		return b;
	}
	
	@Override
	public List<AnalysisArea> queryAreaStatistics(HttpServletRequest request, List<String> companyIds) {
		List<AnalysisArea> areas = new ArrayList<AnalysisArea>();
		//查询出经销商下所有的大区
		AnalysisArea analysisArea = new AnalysisArea();
		
		AnalysisArea sumArea = new AnalysisArea();
		analysisArea.setCompanyIds(companyIds);
		List<String> dealerList = this.orderStatisticAnalysisMapper.querDealerAreaList(analysisArea);
		for(String string : dealerList){
			// 统计本大区
			analysisArea.setArea(string);
			// 查询大区下的省
			List<AnalysisArea> provinceDataList = this.orderStatisticAnalysisMapper.queryProvinceDataList(analysisArea);
			
			//拼接大区数据
			String yaer = StatisticAnalysisDateUtil.getCurrentYear();
			AnalysisArea area = new AnalysisArea();
			for(AnalysisArea areaData:provinceDataList){
				setAreaData(yaer, area, areaData);
				if(StringUtils.isNotEmpty(areaData.getAreaName())){
					area.setAreaName(string);
					area.setAreaType("DQ");
				}
			}
			setSumData(sumArea, area);
			areas.add(area);
			//拼接大区下的省数据
			List<AnalysisArea> analysisAreaold = new ArrayList<>();
			for(int i = 0 ; i < provinceDataList.size(); i++){
				List<AnalysisArea> analysisAreapro = new ArrayList<>();
				AnalysisArea province = new AnalysisArea();
				for(int j = i + 1 ; j < provinceDataList.size() ; j++ ){
					if(provinceDataList.get(i).getAreaName().equals(provinceDataList.get(j).getAreaName())){
						analysisAreapro.add(provinceDataList.get(j));
					}
				}
				if(analysisAreapro.size() > 0){
					for(AnalysisArea provinces : analysisAreapro){
						setAreaData(yaer, province, provinces);
					}
				}
				if(i == 0){
					setAreaData(yaer, province, provinceDataList.get(i));
					province.setAreaName(provinceDataList.get(i).getAreaName());
					areas.add(province);
					analysisAreaold.add(province);
				}else {
					boolean falg = false;
					for(AnalysisArea  provinces:analysisAreaold ){
						if(provinceDataList.get(i).getAreaName().equals(provinces.getAreaName())){
							falg = true;
							break;
						}
					}
					if(!falg){
						setAreaData(yaer, province, provinceDataList.get(i));
						province.setAreaName(provinceDataList.get(i).getAreaName());
						areas.add(province);
						analysisAreaold.add(province);
					}
				}
				
			}
		}
		sumArea.setAreaName("总计");
		areas.add(sumArea);
		return areas;
	}

	private void setSumData(AnalysisArea sumArea, AnalysisArea area) {
		sumArea.setOneMonth(String.valueOf(Float.parseFloat(area.getOneMonth())+Float.parseFloat(sumArea.getOneMonth())));
		sumArea.setTwoMonth(String.valueOf(Float.parseFloat(area.getTwoMonth())+Float.parseFloat(sumArea.getTwoMonth())));
		sumArea.setThreeMonth(String.valueOf(Float.parseFloat(area.getThreeMonth())+Float.parseFloat(sumArea.getThreeMonth())));
		sumArea.setFourMonth(String.valueOf(Float.parseFloat(area.getFourMonth())+Float.parseFloat(sumArea.getFourMonth())));
		sumArea.setFiveMonth(String.valueOf(Float.parseFloat(area.getFiveMonth())+Float.parseFloat(sumArea.getFiveMonth())));
		sumArea.setSixMonth(String.valueOf(Float.parseFloat(area.getSixMonth())+Float.parseFloat(sumArea.getSixMonth())));
		sumArea.setSevenMonth(String.valueOf(Float.parseFloat(area.getSevenMonth())+Float.parseFloat(sumArea.getSevenMonth())));
		sumArea.setEightMonth(String.valueOf(Float.parseFloat(area.getEightMonth())+Float.parseFloat(sumArea.getEightMonth())));
		sumArea.setNineMonth(String.valueOf(Float.parseFloat(area.getNineMonth())+Float.parseFloat(sumArea.getNineMonth())));
		sumArea.setTenMonth(String.valueOf(Float.parseFloat(area.getTenMonth())+Float.parseFloat(sumArea.getTenMonth())));
		sumArea.setElevenMonth(String.valueOf(Float.parseFloat(area.getElevenMonth())+Float.parseFloat(sumArea.getElevenMonth())));
		sumArea.setTwelveMonth(String.valueOf(Float.parseFloat(area.getTwelveMonth())+Float.parseFloat(sumArea.getTwelveMonth())));
		sumArea.setSum(String.valueOf(Float.parseFloat(area.getSum())+Float.parseFloat(sumArea.getSum())));
	}

	private void setAreaData(String yaer, AnalysisArea area, AnalysisArea areaData) {
		if(StringUtils.isNotEmpty(areaData.getAmountTotal())){
			if(StringUtils.isNotEmpty(area.getSum())){
				area.setSum(String.valueOf(Float.parseFloat(area.getSum()) + Float.parseFloat(areaData.getAmountTotal())));
			}else{
				area.setSum(String.valueOf(Float.parseFloat(areaData.getAmountTotal())));
			}
		}
		
		if((yaer+"-01").equals(areaData.getOrderTime())){
			area.setOneMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getOneMonth())));
		}
		if((yaer+"-02").equals(areaData.getOrderTime())){
			area.setTwoMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getTwoMonth())));
		}
		if((yaer+"-03").equals(areaData.getOrderTime())){
			area.setThreeMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getThreeMonth())));
		}
		if((yaer+"-04").equals(areaData.getOrderTime())){
			area.setFourMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getFourMonth())));
		}
		if((yaer+"-05").equals(areaData.getOrderTime())){
			area.setFiveMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getFiveMonth())));
		}
		if((yaer+"-06").equals(areaData.getOrderTime())){
			area.setSixMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getSixMonth())));
		}
		if((yaer+"-07").equals(areaData.getOrderTime())){
			area.setSevenMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getSevenMonth())));
		}
		if((yaer+"-08").equals(areaData.getOrderTime())){
			area.setEightMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getEightMonth())));
		}
		if((yaer+"-09").equals(areaData.getOrderTime())){
			area.setNineMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getNineMonth())));
		}
		if((yaer+"-10").equals(areaData.getOrderTime())){
			area.setTenMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getTenMonth())));
		}
		if((yaer+"-11").equals(areaData.getOrderTime())){
			area.setElevenMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getElevenMonth())));
		}
		if((yaer+"-12").equals(areaData.getOrderTime())){
			area.setTwelveMonth(String.valueOf(Float.parseFloat(areaData.getAmountTotal())+Float.parseFloat(area.getTwelveMonth())));
		}
	}

	@Override
	public List<AnalysisArea> queryProductStatistics(HttpServletRequest request) {
		List<AnalysisArea> products = new ArrayList<AnalysisArea>();
		//查询出经销商下所有的大区
		AnalysisArea analysisArea = new AnalysisArea();
		
		AnalysisArea sumArea = new AnalysisArea(); // 总计
		List<String> dealerList = this.orderStatisticAnalysisMapper.querDealerAreaList(analysisArea);
		for(String string : dealerList){
			// 统计本大区
			analysisArea.setArea(string);
			// 查询大区下的省
			List<AnalysisArea> provinceDataList = this.orderStatisticAnalysisMapper.queryProvinceProductDataList(analysisArea);
			// 拼接大区数据
			AnalysisArea area = new AnalysisArea();
			for(AnalysisArea areaProvince:provinceDataList){
				setProductData(area, areaProvince);
				if(StringUtils.isNotEmpty(areaProvince.getAreaName())){
					area.setAreaName(string);
					area.setAreaType("DQ");
				}
			}
			products.add(area);
			sumArea.setPresent(String.valueOf(Float.parseFloat(area.getPresent())+Float.parseFloat(sumArea.getPresent())));
			sumArea.setProduct(String.valueOf(Float.parseFloat(area.getProduct())+Float.parseFloat(sumArea.getProduct())));
			sumArea.setMateriel(String.valueOf(Float.parseFloat(area.getMateriel())+Float.parseFloat(sumArea.getMateriel())));
			sumArea.setSum(String.valueOf(Float.parseFloat(sumArea.getSum())+Float.parseFloat(sumArea.getPresent())+Float.parseFloat(sumArea.getProduct())+Float.parseFloat(sumArea.getMateriel())));
			// 拼装大区下的省数据
			List<AnalysisArea> analysisAreaold = new ArrayList<>();
			for(int i = 0 ; i < provinceDataList.size(); i++){
				List<AnalysisArea> analysisAreapro = new ArrayList<>();
				AnalysisArea province = new AnalysisArea();
				for(int j = i + 1 ; j < provinceDataList.size() ; j++ ){
					if(provinceDataList.get(i).getAreaName().equals(provinceDataList.get(j).getAreaName())){
						analysisAreapro.add(provinceDataList.get(j));
					}
				}
				if(analysisAreapro.size() > 0){
					for(AnalysisArea provinces : analysisAreapro){
						setProductData(province, provinces);
					}
				}
				if(i == 0){
					province.setAreaName(provinceDataList.get(i).getAreaName());
					products.add(province);
					analysisAreaold.add(province);
				}else {
					boolean falg = false;
					for(AnalysisArea  provinces:analysisAreaold ){
						if(provinceDataList.get(i).getAreaName().equals(provinces.getAreaName())){
							falg = true;
							break;
						}
					}
					if(!falg){
						province.setAreaName(provinceDataList.get(i).getAreaName());
						products.add(province);
						analysisAreaold.add(province);
					}
				}
				
			}
		}
		sumArea.setAreaName("总计");
		products.add(sumArea);
		return products;
	}

	private void setProductData(AnalysisArea province, AnalysisArea provinces) {
		if("1".equals(provinces.getCategoryId()) || "2".equals(provinces.getCategoryId()) || "3".equals(provinces.getCategoryId()) || "4".equals(provinces.getCategoryId())){
			province.setProduct(String.valueOf(Float.parseFloat(province.getProduct())+Float.parseFloat(provinces.getAmountTotal())));
		}else if ("5".equals(provinces.getCategoryId())){
			province.setMateriel(String.valueOf(Float.parseFloat(province.getMateriel())+Float.parseFloat(provinces.getAmountTotal())));
		}
		province.setPresent(String.valueOf(Float.parseFloat(province.getPresent())+Float.parseFloat(provinces.getPresent())));
		province.setSum(String.valueOf(Float.parseFloat(province.getSum())+Float.parseFloat(province.getProduct())+Float.parseFloat(province.getPresent())+Float.parseFloat(province.getMateriel())));
		
	}
	
	@Override
	public List<String> queryCompanyList(String userId){
		List<String> companyIds = new ArrayList<String>();
		if(StringUtils.isNotEmpty(userId)){
    		User user = this.userService.queryObjById(userId);
    		if(StringUtils.isNotEmpty(user.getUserArea())){
    			List<UserArea> userAreas = new ArrayList<UserArea>();
    			JSONArray jsonArray = JSONArray.fromObject(user.getUserArea());
    			userAreas = (List<UserArea>) jsonArray.toCollection(jsonArray, UserArea.class);
    			List<String> strings = new ArrayList<>();
    			if (CollectionUtils.isNotEmpty(userAreas)) {
    				for(UserArea values : userAreas){
    					strings.add(values.getId());
    				}
    			}
    			if(strings.size() > 0 ){
    				String areaIds = strings.toString();
    				areaIds = areaIds.substring(1, areaIds.length()-1);
    				
    				CompanyExample paramExample = new CompanyExample();
        			CompanyExample.Criteria companyCriteria = paramExample.createCriteria(); 
        			companyCriteria.andAreaOrId("AREA IN ("+areaIds+") OR CITY IN ("+areaIds+") OR PROVINCE IN ("+areaIds+") OR DISTRICT IN("+areaIds+")");
        			List<Company> companyList = companyService.queryAllObjByExample(paramExample);
        			
        			if (CollectionUtils.isNotEmpty(companyList)) {
        				for(Company company:companyList){
        					companyIds.add(company.getId());
        				}
        				
        			}
    			}
    		}
    	}
		return companyIds;
	}
}