package com.els.runhe.contract.service;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractRefundTarget;
import com.els.runhe.contract.entity.ContractRefundTargetExample;

public interface ContractRefundTargetService
		extends BaseService<ContractRefundTarget, ContractRefundTargetExample, String> {

	Double add(Contract contract, List<ContractRefundTarget> list);

	List<ContractRefundTarget> getRefundTargetListByContractId(String contractId);

	List<String> getRefundTargetIdListByContractId(String contractId);

	void update(String contractId, List<ContractRefundTarget> list);

	int deleteByContractId(String contractId);

	int deleteByIdList(List<String> idList);

	/**
	 * 检查某个月的实际回款目标是否已达标
	 * 
	 * @param contractId
	 *            合同ID
	 * @param actualAmount
	 *            某月实际回款额
	 * @param month
	 *            月份(1-12)
	 * @return 返回true为达标，false为不达标
	 */
	Boolean isReachByMonth(String contractId, Integer month, Double actualAmount);

}