package com.els.runhe.statisticAnalysis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.els.runhe.statisticAnalysis.entity.AreaSummaryTable;
import com.els.runhe.statisticAnalysis.entity.AreaYieldRateReport;

public interface AreaYieldRateReportMapper {
	List<AreaYieldRateReport> queryAreaYieldRate(@Param("startTime") String startTime, @Param("endTime") String endTime, 
			@Param("monthList") List<String> monthList, @Param("yearMonthList") List<String> yearMonthList, 
			@Param("companyIds")  List<String> companyIds);
	
	List<AreaYieldRateReport> queryProvinceYieldRate(@Param("startTime") String startTime, @Param("endTime") String endTime, 
			@Param("monthList") List<String> monthList, @Param("yearMonthList") List<String> yearMonthList, 
			@Param("companyIds")  List<String> companyIds);
	
	List<AreaSummaryTable> queryProvince(@Param("companyIds")  List<String> companyIds);
	
	List<AreaSummaryTable> queryAreaSummary(@Param("companyIds")  List<String> companyIds);
	
	List<AreaSummaryTable> querySalesDetailReport(@Param("companyIds")  List<String> companyIds);
	
	List<AreaSummaryTable> salesDetailReport(@Param("companyIds")  List<String> companyIds);
}