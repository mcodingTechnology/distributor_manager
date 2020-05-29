package com.els.runhe.market.dao.promotional;

import com.els.runhe.market.entity.promotional.PromotionalCostProject;
import com.els.runhe.market.entity.promotional.PromotionalCostProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionalCostProjectMapper {
    int countByExample(PromotionalCostProjectExample example);

    int deleteByExample(PromotionalCostProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionalCostProject record);

    int insertSelective(PromotionalCostProject record);

    List<PromotionalCostProject> selectByExample(PromotionalCostProjectExample example);

    PromotionalCostProject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PromotionalCostProject record, @Param("example") PromotionalCostProjectExample example);

    int updateByExample(@Param("record") PromotionalCostProject record, @Param("example") PromotionalCostProjectExample example);

    int updateByPrimaryKeySelective(PromotionalCostProject record);

    int updateByPrimaryKey(PromotionalCostProject record);

    List<PromotionalCostProject> selectByExampleByPage(PromotionalCostProjectExample example);
}