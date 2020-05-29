package com.els.runhe.statisticAnalysis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderProduct;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderProductExample;

public interface AnalysisOrderProductMapper {
    int countByExample(AnalysisOrderProductExample example);

    int deleteByExample(AnalysisOrderProductExample example);

    int deleteByPrimaryKey(String id);

    int insert(AnalysisOrderProduct record);

    int insertSelective(AnalysisOrderProduct record);

    List<AnalysisOrderProduct> selectByExample(AnalysisOrderProductExample example);

    AnalysisOrderProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AnalysisOrderProduct record, @Param("example") AnalysisOrderProductExample example);

    int updateByExample(@Param("record") AnalysisOrderProduct record, @Param("example") AnalysisOrderProductExample example);

    int updateByPrimaryKeySelective(AnalysisOrderProduct record);

    int updateByPrimaryKey(AnalysisOrderProduct record);

    List<AnalysisOrderProduct> selectByExampleByPage(AnalysisOrderProductExample example);
    
    int saveAnalysisOrderProduct(List<AnalysisOrderProduct> list);
    
    List<AnalysisOrderProduct> selectLastMonthDetail();
    
    void deleteByCreateTime();
}