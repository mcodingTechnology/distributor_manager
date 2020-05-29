package com.els.runhe.warehouse.dao;

import com.els.runhe.warehouse.entity.StockSerial;
import com.els.runhe.warehouse.entity.StockSerialExample;
import com.els.runhe.warehouse.entity.StockSerialToExcel;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockSerialMapper {
    int countByExample(StockSerialExample example);

    int deleteByExample(StockSerialExample example);

    int deleteByPrimaryKey(String id);

    int insert(StockSerial record);

    int insertSelective(StockSerial record);

    List<StockSerial> selectByExample(StockSerialExample example);

    StockSerial selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StockSerial record, @Param("example") StockSerialExample example);

    int updateByExample(@Param("record") StockSerial record, @Param("example") StockSerialExample example);

    int updateByPrimaryKeySelective(StockSerial record);

    int updateByPrimaryKey(StockSerial record);

    void insertBatch(List<StockSerial> list);

    List<StockSerial> selectByExampleByPage(StockSerialExample example);

	List<StockSerialToExcel> queryToExcel(StockSerialToExcel stockSerialToExcel);
}