package com.els.runhe.warehouse.dao;

import com.els.runhe.warehouse.entity.StockSafety;
import com.els.runhe.warehouse.entity.StockSafetyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockSafetyMapper {
    int countByExample(StockSafetyExample example);

    int deleteByExample(StockSafetyExample example);

    int deleteByPrimaryKey(String id);

    int insert(StockSafety record);

    int insertSelective(StockSafety record);

    List<StockSafety> selectByExample(StockSafetyExample example);

    StockSafety selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StockSafety record, @Param("example") StockSafetyExample example);

    int updateByExample(@Param("record") StockSafety record, @Param("example") StockSafetyExample example);

    int updateByPrimaryKeySelective(StockSafety record);

    int updateByPrimaryKey(StockSafety record);

    List<StockSafety> selectByExampleByPage(StockSafetyExample example);
}