package com.els.runhe.statisticAnalysis.dao;

import com.els.runhe.statisticAnalysis.entity.AnalysisFinanceLog;
import com.els.runhe.statisticAnalysis.entity.AnalysisFinanceLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnalysisFinanceLogMapper {
    int countByExample(AnalysisFinanceLogExample example);

    int deleteByExample(AnalysisFinanceLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AnalysisFinanceLog record);

    int insertSelective(AnalysisFinanceLog record);

    List<AnalysisFinanceLog> selectByExample(AnalysisFinanceLogExample example);

    AnalysisFinanceLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AnalysisFinanceLog record, @Param("example") AnalysisFinanceLogExample example);

    int updateByExample(@Param("record") AnalysisFinanceLog record, @Param("example") AnalysisFinanceLogExample example);

    int updateByPrimaryKeySelective(AnalysisFinanceLog record);

    int updateByPrimaryKey(AnalysisFinanceLog record);

    List<AnalysisFinanceLog> selectByExampleByPage(AnalysisFinanceLogExample example);

	String queryAmountByCompanyId(@Param("purCompanyId") String purCompanyId);
}