package com.els.runhe.market.dao.promotional;

import com.els.runhe.market.entity.promotional.PromotionalCostApply;
import com.els.runhe.market.entity.promotional.PromotionalCostApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PromotionalCostApplyMapper {
    int countByExample(PromotionalCostApplyExample example);

    int deleteByExample(PromotionalCostApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PromotionalCostApply record);

    int insertSelective(PromotionalCostApply record);

    List<PromotionalCostApply> selectByExample(PromotionalCostApplyExample example);

    PromotionalCostApply selectByPrimaryKey(Integer id);
    
    PromotionalCostApply selectByPromotionalCostNo(String promotionalCostNo);

    int updateByExampleSelective(@Param("record") PromotionalCostApply record, @Param("example") PromotionalCostApplyExample example);

    int updateByExample(@Param("record") PromotionalCostApply record, @Param("example") PromotionalCostApplyExample example);

    int updateByPrimaryKeySelective(PromotionalCostApply record);

    int updateByPrimaryKey(PromotionalCostApply record);

    List<PromotionalCostApply> selectByExampleByPage(PromotionalCostApplyExample example);
}