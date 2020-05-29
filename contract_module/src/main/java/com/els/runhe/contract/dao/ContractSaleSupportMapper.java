package com.els.runhe.contract.dao;

import com.els.runhe.contract.entity.ContractSaleSupport;
import com.els.runhe.contract.entity.ContractSaleSupportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractSaleSupportMapper {
    int countByExample(ContractSaleSupportExample example);

    int deleteByExample(ContractSaleSupportExample example);

    int deleteByPrimaryKey(String id);

    int insert(ContractSaleSupport record);

    int insertSelective(ContractSaleSupport record);

    List<ContractSaleSupport> selectByExample(ContractSaleSupportExample example);

    ContractSaleSupport selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ContractSaleSupport record, @Param("example") ContractSaleSupportExample example);

    int updateByExample(@Param("record") ContractSaleSupport record, @Param("example") ContractSaleSupportExample example);

    int updateByPrimaryKeySelective(ContractSaleSupport record);

    int updateByPrimaryKey(ContractSaleSupport record);

    List<ContractSaleSupport> selectByExampleByPage(ContractSaleSupportExample example);
}