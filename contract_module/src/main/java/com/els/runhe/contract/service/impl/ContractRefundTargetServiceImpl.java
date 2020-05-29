package com.els.runhe.contract.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.runhe.contract.dao.ContractRefundTargetMapper;
import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractRefundTarget;
import com.els.runhe.contract.entity.ContractRefundTargetExample;
import com.els.runhe.contract.service.ContractRefundTargetService;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

@Service("defaultContractRefundTargetService")
@Transactional
public class ContractRefundTargetServiceImpl implements ContractRefundTargetService {

	@Resource
	protected ContractRefundTargetMapper contractRefundTargetMapper;

	@CacheEvict(value = { "contractRefundTarget" }, allEntries = true)
	@Override
	public void addObj(ContractRefundTarget t) {
		this.contractRefundTargetMapper.insertSelective(t);
	}

	@CacheEvict(value = { "contractRefundTarget" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.contractRefundTargetMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "contractRefundTarget" }, allEntries = true)
	@Override
	public void modifyObj(ContractRefundTarget t) {
		if (StringUtils.isBlank(t.getId())) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.contractRefundTargetMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "contractRefundTarget", keyGenerator = "redisKeyGenerator")
	@Override
	public ContractRefundTarget queryObjById(String id) {
		return this.contractRefundTargetMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "contractRefundTarget", keyGenerator = "redisKeyGenerator")
	@Override
	public List<ContractRefundTarget> queryAllObjByExample(ContractRefundTargetExample example) {
		return this.contractRefundTargetMapper.selectByExample(example);
	}

	@Cacheable(value = "contractRefundTarget", keyGenerator = "redisKeyGenerator")
	@Override
	public PageView<ContractRefundTarget> queryObjByPage(ContractRefundTargetExample example) {
		PageView<ContractRefundTarget> pageView = example.getPageView();
		pageView.setQueryResult(this.contractRefundTargetMapper.selectByExampleByPage(example));
		return pageView;
	}

	@Override
	public Double add(Contract contract, List<ContractRefundTarget> list) {
		if (null == contract || StringUtils.isBlank(contract.getId())) {
			throw new NullPointerException("合同信息为空");
		}
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		String contractId = contract.getId();
		Date date = contract.getCreateTime();
		double yearTarget = 0; // 年度回款目标
		for (ContractRefundTarget entity : list) {
			Integer month = entity.getMonth();
			if (!checkMonth(month)) {
				// 检查月份格式
				throw new CommonException("月份格式不正确");
			}

			yearTarget += entity.getMonthRefundTarget();

			entity.setContractId(contractId);
			entity.setCreateTime(date);
			entity.setUpdateTime(date);

			contractRefundTargetMapper.insertSelective(entity);
		}
		return yearTarget;
	}

	@Override
	public List<ContractRefundTarget> getRefundTargetListByContractId(String contractId) {
		if (StringUtils.isBlank(contractId)) {
			throw new CommonException("合同ID为空");
		}
		ContractRefundTargetExample example = new ContractRefundTargetExample();
		ContractRefundTargetExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT).andContractIdEqualTo(contractId);
		List<ContractRefundTarget> list = contractRefundTargetMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<String> getRefundTargetIdListByContractId(String contractId) {
		List<ContractRefundTarget> recordList = getRefundTargetListByContractId(contractId);
		List<String> idList = Lists.transform(recordList, new Function<ContractRefundTarget, String>() {
			@Override
			public String apply(ContractRefundTarget record) {
				return record.getId();
			}
		});
		return idList;
	}

	@Override
	public void update(String contractId, List<ContractRefundTarget> list) {
		if (StringUtils.isBlank(contractId)) {
			throw new CommonException("合同ID为空");
		}
		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		List<String> dbIdList = getRefundTargetIdListByContractId(contractId);
		List<String> updateIdList = new ArrayList<>();
		// 更新
		Date now = new Date();
		for (ContractRefundTarget record : list) {
			String id = record.getId();
			record.setContractId(contractId);
			record.setUpdateTime(now);
			if (StringUtils.isBlank(id)) {
				// 新增
				record.setCreateTime(now);
				record.setIsEnable(Constant.YES_INT);
				contractRefundTargetMapper.insertSelective(record);
			} else {
				updateIdList.add(id);
				// 修改
				contractRefundTargetMapper.updateByPrimaryKeySelective(record);
			}
		}
		// 删除
		dbIdList.removeAll(updateIdList);
		deleteByIdList(dbIdList);
	}

	@Override
	public int deleteByContractId(String contractId) {
		if (StringUtils.isBlank(contractId)) {
			return 0;
		}
		ContractRefundTargetExample example = new ContractRefundTargetExample();
		ContractRefundTargetExample.Criteria criteria = example.createCriteria();
		criteria.andContractIdEqualTo(contractId);
		int result = contractRefundTargetMapper.deleteByExample(example);
		return result;
	}

	@Override
	public int deleteByIdList(List<String> idList) {
		if (CollectionUtils.isEmpty(idList)) {
			return 0;
		}
		ContractRefundTargetExample example = new ContractRefundTargetExample();
		ContractRefundTargetExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andIdIn(idList);
		int result = contractRefundTargetMapper.deleteByExample(example);
		return result;
	}

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
	@Override
	public Boolean isReachByMonth(String contractId, Integer month, Double actualAmount) {
		if (!checkMonth(month)) {
			// 检查月份格式
			throw new CommonException("月份格式不正确");
		}
		ContractRefundTargetExample example = new ContractRefundTargetExample();
		ContractRefundTargetExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andContractIdEqualTo(contractId).andMonthEqualTo(month);
		List<ContractRefundTarget> list = this.contractRefundTargetMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			throw new CommonException(String.format("没有设置合同ID=%s的%s月回款目标记录", contractId, month));
		}
		ContractRefundTarget record = list.get(0);
		Double monthRefundTarget = record.getMonthRefundTarget();
		if (actualAmount >= monthRefundTarget) {
			// 达标
			return true;
		}
		return false;
	}

	/*
	 * 检查月份格式
	 */
	private Boolean checkMonth(Integer month) {
		if (null == month) {
			throw new CommonException("月份为空");
		}
		if (month <= 0 || month > 12) {
			throw new CommonException("月份格式不正确，须为1-12");
		}
		return true;
	}

}