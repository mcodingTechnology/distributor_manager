package com.els.runhe.contract.service;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractExample;
import com.els.runhe.contract.model.ContractInfo;

public interface ContractService extends BaseService<Contract, ContractExample, String> {

	/**
	 * 新增合同
	 * 
	 * @param data
	 */
	void add(ContractInfo data);

	/**
	 * 判断合同名称是否存在
	 * 
	 * @param contractName
	 *            合同名称
	 * @param contractId
	 *            合同ID，用于修改时排除自身
	 * @return
	 */
	boolean isExistContractName(String contractName, String contractId);

	/**
	 * 判断合同编号是否存在
	 * 
	 * @param contractNum
	 *            合同编号
	 * @param contractId
	 *            合同ID，用于修改时排除自身
	 * @return
	 */
	boolean isExistContractNum(String contractNum, String contractId);

	/**
	 * 查看合同详情
	 * 
	 * @param id
	 * @return
	 */
	ContractInfo detail(String id);

	/**
	 * 更新合同
	 * 
	 * @param data
	 */
	void update(ContractInfo data);

	/**
	 * 根据乙方ID(经销商公司ID)查询当前有效合同记录
	 * 
	 * @param partyBId
	 *            乙方ID(经销商公司ID)
	 * @return
	 */
	Contract getValidContractByPartyB(String partyBId);

	/**
	 * 根据乙方ID(经销商公司ID)查询尚未结束的合同列表记录
	 * 
	 * @param partyBId
	 *            乙方ID(经销商公司ID)
	 * @return
	 */
	List<Contract> getUnfinishedContractsByPartyB(String partyBId);

}