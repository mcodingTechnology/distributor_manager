package com.els.runhe.contract.dao;

import com.els.runhe.contract.entity.ContractRefundTarget;
import com.els.runhe.contract.entity.ContractRefundTargetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractRefundTargetMapper {
    int countByExample(ContractRefundTargetExample example);

    int deleteByExample(ContractRefundTargetExample example);

    int deleteByPrimaryKey(String id);

    int insert(ContractRefundTarget record);

    int insertSelective(ContractRefundTarget record);

    List<ContractRefundTarget> selectByExample(ContractRefundTargetExample example);

    ContractRefundTarget selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ContractRefundTarget record, @Param("example") ContractRefundTargetExample example);

    int updateByExample(@Param("record") ContractRefundTarget record, @Param("example") ContractRefundTargetExample example);

    int updateByPrimaryKeySelective(ContractRefundTarget record);

    int updateByPrimaryKey(ContractRefundTarget record);

    List<ContractRefundTarget> selectByExampleByPage(ContractRefundTargetExample example);
}