package com.els.runhe.market.dao.design;

import com.els.runhe.market.entity.design.MarketDesigned;
import com.els.runhe.market.entity.design.MarketDesignedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketDesignedMapper {
    int countByExample(MarketDesignedExample example);

    int deleteByExample(MarketDesignedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MarketDesigned record);

    int insertSelective(MarketDesigned record);

    List<MarketDesigned> selectByExample(MarketDesignedExample example);

    MarketDesigned selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MarketDesigned record, @Param("example") MarketDesignedExample example);

    int updateByExample(@Param("record") MarketDesigned record, @Param("example") MarketDesignedExample example);

    int updateByPrimaryKeySelective(MarketDesigned record);

    int updateByPrimaryKey(MarketDesigned record);

    List<MarketDesigned> selectByExampleByPage(MarketDesignedExample example);
}