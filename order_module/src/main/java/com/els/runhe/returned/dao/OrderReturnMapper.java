package com.els.runhe.returned.dao;

import com.els.runhe.returned.entity.OrderReturn;
import com.els.runhe.returned.entity.OrderReturnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderReturnMapper {
    int countByExample(OrderReturnExample example);

    int deleteByExample(OrderReturnExample example);

    int deleteByPrimaryKey(Integer id);
    
    int deleteObjByOrderReturnNo(String orderReturnNo);

    int insert(OrderReturn record);

    int insertSelective(OrderReturn record);

    List<OrderReturn> selectByExample(OrderReturnExample example);

    OrderReturn selectByPrimaryKey(Integer id);
    
    OrderReturn selectByOrderReturnNo(String orderReturnNo);

    int updateByExampleSelective(@Param("record") OrderReturn record, @Param("example") OrderReturnExample example);

    int updateByExample(@Param("record") OrderReturn record, @Param("example") OrderReturnExample example);

    int updateByPrimaryKeySelective(OrderReturn record);

    int updateByPrimaryKey(OrderReturn record);

    List<OrderReturn> selectByExampleByPage(OrderReturnExample example);
}