package com.els.runhe.market.dao.train;

import com.els.runhe.market.entity.train.MarketTrainApply;
import com.els.runhe.market.entity.train.MarketTrainApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarketTrainApplyMapper {
    int countByExample(MarketTrainApplyExample example);

    int deleteByExample(MarketTrainApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MarketTrainApply record);

    int insertSelective(MarketTrainApply record);

    List<MarketTrainApply> selectByExample(MarketTrainApplyExample example);

    MarketTrainApply selectByPrimaryKey(Integer id);
    
    MarketTrainApply selectByTrainApplyId(String trainApplyId);

    int updateByExampleSelective(@Param("record") MarketTrainApply record, @Param("example") MarketTrainApplyExample example);

    int updateByExample(@Param("record") MarketTrainApply record, @Param("example") MarketTrainApplyExample example);

    int updateByPrimaryKeySelective(MarketTrainApply record);

    int updateByPrimaryKey(MarketTrainApply record);

    List<MarketTrainApply> selectByExampleByPage(MarketTrainApplyExample example);
}