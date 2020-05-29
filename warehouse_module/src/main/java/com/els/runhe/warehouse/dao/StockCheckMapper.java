package com.els.runhe.warehouse.dao;

import com.els.runhe.warehouse.entity.StockCheck;
import com.els.runhe.warehouse.entity.StockCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockCheckMapper {
    int countByExample(StockCheckExample example);

    int deleteByExample(StockCheckExample example);

    int deleteByPrimaryKey(String id);

    int insert(StockCheck record);

    int insertSelective(StockCheck record);

    List<StockCheck> selectByExample(StockCheckExample example);

    StockCheck selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StockCheck record, @Param("example") StockCheckExample example);

    int updateByExample(@Param("record") StockCheck record, @Param("example") StockCheckExample example);

    int updateByPrimaryKeySelective(StockCheck record);

    int updateByPrimaryKey(StockCheck record);

    void insertBatch(List<StockCheck> list);

    List<StockCheck> selectByExampleByPage(StockCheckExample example);
}