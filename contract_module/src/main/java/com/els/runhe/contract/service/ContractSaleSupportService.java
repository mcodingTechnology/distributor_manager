package com.els.runhe.contract.service;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractSaleSupport;
import com.els.runhe.contract.entity.ContractSaleSupportExample;

public interface ContractSaleSupportService
		extends BaseService<ContractSaleSupport, ContractSaleSupportExample, String> {

	void add(Contract contract, List<ContractSaleSupport> list);

	List<ContractSaleSupport> getSaleSupportListByContractId(String contractId);

	List<String> getSaleSupportIdListByContractId(String contractId);

	void update(String contractId, List<ContractSaleSupport> list);

	int deleteByContractId(String contractId);

	int deleteByIdList(List<String> idList);

	/**
	 * 根据合同ID和实际销售额查询相应的销售支付比率
	 * 
	 * @param contractId
	 *            合同ID
	 * @param actualAmount
	 *            实际销售额
	 * @return
	 */
	ContractSaleSupport getSaleSupportByActualSales(String contractId, Double actualAmount);

}