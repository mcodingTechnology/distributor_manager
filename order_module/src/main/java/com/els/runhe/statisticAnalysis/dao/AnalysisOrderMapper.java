package com.els.runhe.statisticAnalysis.dao;

import com.els.runhe.statisticAnalysis.entity.AnalysisOrder;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderExample;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysis;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnalysisOrderMapper {
    int countByExample(AnalysisOrderExample example);

    int deleteByExample(AnalysisOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AnalysisOrder record);

    int insertSelective(AnalysisOrder record);

    List<AnalysisOrder> selectByExample(AnalysisOrderExample example);

    AnalysisOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AnalysisOrder record, @Param("example") AnalysisOrderExample example);

    int updateByExample(@Param("record") AnalysisOrder record, @Param("example") AnalysisOrderExample example);

    int updateByPrimaryKeySelective(AnalysisOrder record);

    int updateByPrimaryKey(AnalysisOrder record);

    List<AnalysisOrder> selectByExampleByPage(AnalysisOrderExample example);
    
    int saveAnalysisOrder(List<AnalysisOrder> list);
    
    public List<AnalysisOrder> selectMonthReport();
    
    /**
     * 硬删除当前月所有对账单
     */
    void deleteByOrderTime();
}