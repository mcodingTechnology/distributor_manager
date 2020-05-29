package com.els.runhe.contract.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.els.runhe.contract.dao.ContractSaleSupportMapper;
import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractSaleSupport;
import com.els.runhe.contract.entity.ContractSaleSupportExample;
import com.els.runhe.contract.service.ContractSaleSupportService;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service("defaultContractSaleSupportService")
@Transactional
public class ContractSaleSupportServiceImpl implements ContractSaleSupportService {

	@Resource
	protected ContractSaleSupportMapper contractSaleSupportMapper;

	@CacheEvict(value = { "contractSaleSupport" }, allEntries = true)
	@Override
	public void addObj(ContractSaleSupport t) {
		this.contractSaleSupportMapper.insertSelective(t);
	}

	@CacheEvict(value = { "contractSaleSupport" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.contractSaleSupportMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "contractSaleSupport" }, allEntries = true)
	@Override
	public void modifyObj(ContractSaleSupport t) {
		if (StringUtils.isBlank(t.getId())) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.contractSaleSupportMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "contractSaleSupport", keyGenerator = "redisKeyGenerator")
	@Override
	public ContractSaleSupport queryObjById(String id) {
		return this.contractSaleSupportMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "contractSaleSupport", keyGenerator = "redisKeyGenerator")
	@Override
	public List<ContractSaleSupport> queryAllObjByExample(ContractSaleSupportExample example) {
		return this.contractSaleSupportMapper.selectByExample(example);
	}

	@Cacheable(value = "contractSaleSupport", keyGenerator = "redisKeyGenerator")
	@Override
	public PageView<ContractSaleSupport> queryObjByPage(ContractSaleSupportExample example) {
		PageView<ContractSaleSupport> pageView = example.getPageView();
		pageView.setQueryResult(this.contractSaleSupportMapper.selectByExampleByPage(example));
		return pageView;
	}

	@Override
	public void add(Contract contract, List<ContractSaleSupport> list) {
		if (null == contract || StringUtils.isBlank(contract.getId())) {
			throw new NullPointerException("合同信息为空");
		}
		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		if (!checkSaleSupportSection(list)) {
			throw new CommonException(
					"销售支持区间填写格式不正确，序号需按顺序从小到大，每级区间最小值不允许大于最大值，上一级区间最大值不能大于下一级区间最小值，不填写则认为是无穷大，最多只允许有一个，而且只允许出现在最后一级的最大值");
		}

		String contractId = contract.getId();
		Date date = contract.getCreateTime();

		for (ContractSaleSupport entity : list) {

			entity.setContractId(contractId);
			entity.setCreateTime(date);
			entity.setUpdateTime(date);

			contractSaleSupportMapper.insertSelective(entity);
		}
	}

	@Override
	public List<ContractSaleSupport> getSaleSupportListByContractId(String contractId) {
		if (StringUtils.isBlank(contractId)) {
			throw new CommonException("合同ID为空");
		}
		ContractSaleSupportExample example = new ContractSaleSupportExample();
		ContractSaleSupportExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT).andContractIdEqualTo(contractId);
		List<ContractSaleSupport> list = contractSaleSupportMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<String> getSaleSupportIdListByContractId(String contractId) {
		List<ContractSaleSupport> recordList = getSaleSupportListByContractId(contractId);
		List<String> idList = Lists.transform(recordList, new Function<ContractSaleSupport, String>() {
			@Override
			public String apply(ContractSaleSupport record) {
				return record.getId();
			}
		});
		return idList;
	}

	@Override
	public void update(String contractId, List<ContractSaleSupport> list) {
		if (StringUtils.isBlank(contractId)) {
			throw new CommonException("合同ID为空");
		}
		if (CollectionUtils.isEmpty(list)) {
			return;
		}
		if (!checkSaleSupportSection(list)) {
			throw new CommonException(
					"销售支持区间填写格式不正确，序号需按顺序从小到大，每级区间最小值不允许大于最大值，上一级区间最大值不能大于下一级区间最小值，不填写则认为是无穷大，最多只允许有一个，而且只允许出现在最后一级的最大值");
		}
		List<String> dbIdList = getSaleSupportIdListByContractId(contractId);
		List<String> updateIdList = new ArrayList<>();
		// 再更新
		Date now = new Date();
		for (ContractSaleSupport record : list) {
			String id = record.getId();
			record.setContractId(contractId);
			record.setUpdateTime(now);
			if (StringUtils.isBlank(id)) {
				// 新增
				record.setCreateTime(now);
				record.setIsEnable(Constant.YES_INT);
				contractSaleSupportMapper.insertSelective(record);
			} else {
				updateIdList.add(id);
				// 修改
				contractSaleSupportMapper.updateByPrimaryKeySelective(record);
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
		ContractSaleSupportExample example = new ContractSaleSupportExample();
		ContractSaleSupportExample.Criteria criteria = example.createCriteria();
		criteria.andContractIdEqualTo(contractId);
		int result = contractSaleSupportMapper.deleteByExample(example);
		return result;
	}

	@Override
	public int deleteByIdList(List<String> idList) {
		if (CollectionUtils.isEmpty(idList)) {
			return 0;
		}
		ContractSaleSupportExample example = new ContractSaleSupportExample();
		ContractSaleSupportExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andIdIn(idList);
		int result = contractSaleSupportMapper.deleteByExample(example);
		return result;
	}

	/**
	 * 根据合同ID和实际销售额查询相应的销售支付比率
	 * 
	 * @param contractId
	 *            合同ID
	 * @param actualAmount
	 *            实际销售额
	 * @return
	 */
	@Override
	public ContractSaleSupport getSaleSupportByActualSales(String contractId, Double actualAmount) {
		ContractSaleSupportExample example = new ContractSaleSupportExample();
		ContractSaleSupportExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andContractIdEqualTo(contractId);
		criteria.andRefundMinLessThan(actualAmount);
		example.setOrderByClause("SERIAL_NUM DESC"); // 倒序
		List<ContractSaleSupport> list = contractSaleSupportMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		ContractSaleSupport record = list.get(0);
		Double max = record.getRefundMax();
		if (null != max && actualAmount > max) {
			return null;
		}
		return record;
	}

	/*
	 * 区间最大最小值校验、序号列表校验
	 */
	private Boolean checkSaleSupportSection(List<ContractSaleSupport> list) {
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		int nullCount = 0; // 最大值为空计数
		List<Integer> numList = new ArrayList<>(); // 序号列表
		for (ContractSaleSupport record : list) {
			numList.add(record.getSerialNum());
			Double min = record.getRefundMin();
			Double max = record.getRefundMax();
			if (min == null) {
				// 最小值不允许为空，可以为0
				throw new CommonException("销售支持区间填写格式不正确：最小值不允许为空");
			}
			if (null == max) {
				// 最大值允许为空，表示无穷大
				nullCount++;
			}
			if (nullCount > 1) {
				// 最大值只允许为空1次，国为无穷大最多只能有1个
				throw new CommonException("销售支持区间填写格式不正确：不填则认为是无穷大，无穷大只允许出现1次");
			}
			if (null != max) {
				if (min > max) {
					// 最小值不能大于最大值
					throw new CommonException("销售支持区间填写格式不正确：最小值不能大于最大值");
				}
			}
		}
		int size = list.size();
		if (size == 1) {
			return true;
		}
		// 校验序列
		int numIndex = 1; // 序号索引
		Collections.sort(numList); // 将序号列表从小到大排序
		for (Integer num : numList) {
			if (num != numIndex) {
				// 序号列表只能是：1、2、3、4...
				throw new CommonException("销售支持区间格式不正确：序号列表只允许是：1、2、3、4...");
			}
			numIndex++;
		}
		// 将列表转换为Map，Key为序号，Value为合同销售支持对象
		Map<Integer, ContractSaleSupport> map = Maps.uniqueIndex(list, new Function<ContractSaleSupport, Integer>() {
			public Integer apply(ContractSaleSupport obj) {
				return obj.getSerialNum();
			}
		});
		// 相邻元素比较，上一个跟下一个比较，按顺序比较
		for (Integer i = 1; i < size; i++) {
			Integer nextNum = (i + 1);
			ContractSaleSupport current = map.get(i);
			ContractSaleSupport next = map.get(nextNum);
			Double currentMax = current.getRefundMax();
			Double nextMin = next.getRefundMin();
			if (null == currentMax) {
				// 非最后一级区间最大值不能为无穷大
				throw new CommonException("销售支持区间填写格式不正确：不填写则认为是无穷大，非最后一级区间最大值不能为无穷大");
			}
			if (currentMax > nextMin) {
				// 上一级区间最大值不能大于下一级区间最小值
				throw new CommonException("销售支持区间填写格式不正确：上一级区间最大值不能大于下一级区间最小值");
			}
		}
		return true;
	}

}