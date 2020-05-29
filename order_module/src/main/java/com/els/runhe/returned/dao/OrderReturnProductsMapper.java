package com.els.runhe.returned.dao;

import com.els.runhe.returned.entity.OrderReturnProducts;
import com.els.runhe.returned.entity.OrderReturnProductsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderReturnProductsMapper {
    int countByExample(OrderReturnProductsExample example);

    int deleteByExample(OrderReturnProductsExample example);

    int deleteByPrimaryKey(Integer id);
    
    int deleteObjByOrderReturnNo(String orderReturnNo);

    int insert(OrderReturnProducts record);

    int insertSelective(OrderReturnProducts record);

    List<OrderReturnProducts> selectByExample(OrderReturnProductsExample example);

    OrderReturnProducts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderReturnProducts record, @Param("example") OrderReturnProductsExample example);

    int updateByExample(@Param("record") OrderReturnProducts record, @Param("example") OrderReturnProductsExample example);

    int updateByPrimaryKeySelective(OrderReturnProducts record);

    int updateByPrimaryKey(OrderReturnProducts record);

    List<OrderReturnProducts> selectByExampleByPage(OrderReturnProductsExample example);
}