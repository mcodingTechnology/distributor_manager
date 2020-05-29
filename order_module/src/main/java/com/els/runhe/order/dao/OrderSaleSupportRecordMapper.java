package com.els.runhe.order.dao;

import com.els.runhe.order.entity.OrderSaleSupportRecord;
import com.els.runhe.order.entity.OrderSaleSupportRecordExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderSaleSupportRecordMapper {
    int countByExample(OrderSaleSupportRecordExample example);

    int deleteByExample(OrderSaleSupportRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrderSaleSupportRecord record);

    int insertSelective(OrderSaleSupportRecord record);

    List<OrderSaleSupportRecord> selectByExample(OrderSaleSupportRecordExample example);

    OrderSaleSupportRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrderSaleSupportRecord record, @Param("example") OrderSaleSupportRecordExample example);

    int updateByExample(@Param("record") OrderSaleSupportRecord record, @Param("example") OrderSaleSupportRecordExample example);

    int updateByPrimaryKeySelective(OrderSaleSupportRecord record);

    int updateByPrimaryKey(OrderSaleSupportRecord record);

    List<OrderSaleSupportRecord> selectByExampleByPage(OrderSaleSupportRecordExample example);
    
    BigDecimal sumRefundByExample(OrderSaleSupportRecordExample example);
}