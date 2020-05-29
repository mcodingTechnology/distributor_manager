package com.els.runhe.warehouse.dao;

import com.els.runhe.warehouse.entity.StockAdjust;
import com.els.runhe.warehouse.entity.StockAdjustExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockAdjustMapper {
    int countByExample(StockAdjustExample example);

    int deleteByExample(StockAdjustExample example);

    int deleteByPrimaryKey(String id);

    int insert(StockAdjust record);

    int insertSelective(StockAdjust record);

    List<StockAdjust> selectByExample(StockAdjustExample example);

    StockAdjust selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StockAdjust record, @Param("example") StockAdjustExample example);

    int updateByExample(@Param("record") StockAdjust record, @Param("example") StockAdjustExample example);

    int updateByPrimaryKeySelective(StockAdjust record);

    int updateByPrimaryKey(StockAdjust record);

    List<StockAdjust> selectByExampleByPage(StockAdjustExample example);
}