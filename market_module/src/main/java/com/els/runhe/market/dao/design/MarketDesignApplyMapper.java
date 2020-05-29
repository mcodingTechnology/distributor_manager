package com.els.runhe.market.dao.design;

import com.els.runhe.market.entity.design.MarketDesignApply;
import com.els.runhe.market.entity.design.MarketDesignApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketDesignApplyMapper {
    int countByExample(MarketDesignApplyExample example);

    int deleteByExample(MarketDesignApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MarketDesignApply record);

    int insertSelective(MarketDesignApply record);

    List<MarketDesignApply> selectByExample(MarketDesignApplyExample example);

    MarketDesignApply selectByPrimaryKey(Integer id);
    
    MarketDesignApply selectByDesignApplyId(String designApplyId);

    int updateByExampleSelective(@Param("record") MarketDesignApply record, @Param("example") MarketDesignApplyExample example);

    int updateByExample(@Param("record") MarketDesignApply record, @Param("example") MarketDesignApplyExample example);

    int updateByPrimaryKeySelective(MarketDesignApply record);

    int updateByPrimaryKey(MarketDesignApply record);

    List<MarketDesignApply> selectByExampleByPage(MarketDesignApplyExample example);
}