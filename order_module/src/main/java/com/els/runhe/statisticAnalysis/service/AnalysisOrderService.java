package com.els.runhe.statisticAnalysis.service;

import javax.servlet.http.HttpServletRequest;

import com.els.base.core.service.BaseService;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrder;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderExample;

public interface AnalysisOrderService extends BaseService<AnalysisOrder, AnalysisOrderExample, Integer> {
	
	public void saveAnalysisOrder();
}