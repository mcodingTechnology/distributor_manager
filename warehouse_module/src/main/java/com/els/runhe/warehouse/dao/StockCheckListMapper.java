package com.els.runhe.warehouse.dao;

import com.els.runhe.warehouse.entity.StockCheckList;
import com.els.runhe.warehouse.entity.StockCheckListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockCheckListMapper {
    int countByExample(StockCheckListExample example);

    int deleteByExample(StockCheckListExample example);

    int deleteByPrimaryKey(String id);

    int insert(StockCheckList record);

    int insertSelective(StockCheckList record);

    List<StockCheckList> selectByExample(StockCheckListExample example);

    StockCheckList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StockCheckList record, @Param("example") StockCheckListExample example);

    int updateByExample(@Param("record") StockCheckList record, @Param("example") StockCheckListExample example);

    int updateByPrimaryKeySelective(StockCheckList record);

    int updateByPrimaryKey(StockCheckList record);

    void insertBatch(List<StockCheckList> list);

    List<StockCheckList> selectByExampleByPage(StockCheckListExample example);

	List<StockCheckList> queryObjByStockCheckId(@Param("stockCheckId")String id);
}