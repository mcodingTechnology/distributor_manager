package com.els.runhe.warehouse.dao;

import com.els.runhe.warehouse.entity.StockAdjustList;
import com.els.runhe.warehouse.entity.StockAdjustListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockAdjustListMapper {
    int countByExample(StockAdjustListExample example);

    int deleteByExample(StockAdjustListExample example);

    int deleteByPrimaryKey(String id);

    int insert(StockAdjustList record);

    int insertSelective(StockAdjustList record);

    List<StockAdjustList> selectByExample(StockAdjustListExample example);

    StockAdjustList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StockAdjustList record, @Param("example") StockAdjustListExample example);

    int updateByExample(@Param("record") StockAdjustList record, @Param("example") StockAdjustListExample example);

    int updateByPrimaryKeySelective(StockAdjustList record);

    int updateByPrimaryKey(StockAdjustList record);

    List<StockAdjustList> selectByExampleByPage(StockAdjustListExample example);
}