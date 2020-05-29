package com.els.runhe.warehouse.dao;

import com.els.runhe.warehouse.entity.StockSafetyLog;
import com.els.runhe.warehouse.entity.StockSafetyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockSafetyLogMapper {
    int countByExample(StockSafetyLogExample example);

    int deleteByExample(StockSafetyLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(StockSafetyLog record);

    int insertSelective(StockSafetyLog record);

    List<StockSafetyLog> selectByExample(StockSafetyLogExample example);

    StockSafetyLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StockSafetyLog record, @Param("example") StockSafetyLogExample example);

    int updateByExample(@Param("record") StockSafetyLog record, @Param("example") StockSafetyLogExample example);

    int updateByPrimaryKeySelective(StockSafetyLog record);

    int updateByPrimaryKey(StockSafetyLog record);

    List<StockSafetyLog> selectByExampleByPage(StockSafetyLogExample example);
}