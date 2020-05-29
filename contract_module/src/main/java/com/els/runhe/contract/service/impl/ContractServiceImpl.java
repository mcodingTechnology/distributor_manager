package com.els.runhe.contract.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.base.company.entity.Company;
import com.els.base.company.service.CompanyService;
import com.els.base.company.utils.CompanyUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.runhe.contract.dao.ContractMapper;
import com.els.runhe.contract.data.ContractStatus;
import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractExample;
import com.els.runhe.contract.entity.ContractRefundTarget;
import com.els.runhe.contract.entity.ContractSaleSupport;
import com.els.runhe.contract.model.ContractInfo;
import com.els.runhe.contract.service.ContractRefundTargetService;
import com.els.runhe.contract.service.ContractSaleSupportService;
import com.els.runhe.contract.service.ContractService;

@Service("defaultContractService")
@Transactional
public class ContractServiceImpl implements ContractService {

	@Resource
	protected ContractMapper contractMapper;

	@Resource
	protected ContractRefundTargetService contractRefundTargetService;

	@Resource
	protected ContractSaleSupportService contractSaleSupportService;

	@Resource
	protected CompanyService companyService;

	@CacheEvict(value = { "contract" }, allEntries = true)
	@Override
	public void addObj(Contract t) {
		this.contractMapper.insertSelective(t);
	}

	@CacheEvict(value = { "contract" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("合同ID为空");
		}
		Contract t = new Contract();
		t.setId(id);
		t.setStatus("invalid");
		int result = this.contractMapper.updateByPrimaryKeySelective(t);
		// 删除关联数据
		/*if (result > 0) {
			contractRefundTargetService.deleteByContractId(id);
			contractSaleSupportService.deleteByContractId(id);
		}*/
	}

	@CacheEvict(value = { "contract" }, allEntries = true)
	@Override
	public void modifyObj(Contract t) {
		if (StringUtils.isBlank(t.getId())) 
		{
			throw new NullPointerException("id 为空，无法更新");
		}
		this.contractMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "contract", keyGenerator = "redisKeyGenerator")
	@Override
	public Contract queryObjById(String id) {
		return this.contractMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "contract", keyGenerator = "redisKeyGenerator")
	@Override
	public List<Contract> queryAllObjByExample(ContractExample example) {
		return this.contractMapper.selectByExample(example);
	}

	@Cacheable(value = "contract", keyGenerator = "redisKeyGenerator")
	@Override
	public PageView<Contract> queryObjByPage(ContractExample example) {
		PageView<Contract> pageView = example.getPageView();
		pageView.setQueryResult(this.contractMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 新增合同
	 */
	@Override
	public void add(ContractInfo data) {
		if (null == data || null == data.getContract()) {
			throw new CommonException("请求数据为空");
		}
		Date now = new Date();
		// 处理合同基础信息
		Contract contract = data.getContract();

		validateContract(contract); // 校验

		// 甲方
		Company partACompany = CompanyUtils.currentCompany();
		contract.setPartyAId(partACompany.getId());
		contract.setPartyA(partACompany.getCompanyFullName());

		// 乙方
		Company partBCompany = companyService.queryObjById(contract.getPartyBId());
		contract.setPartyB(partBCompany.getCompanyFullName());

		contract.setStatus(ContractStatus.Submit.getId());
		contract.setCreateTime(now);
		contract.setUpdateTime(now);
		// 保存合同基础信息
		int result = contractMapper.insertSelective(contract);
		if (result > 0) {
			// 处理回款目标
			contractRefundTargetService.add(contract, data.getRefundTargetList());
			// 处理销售支持
			contractSaleSupportService.add(contract, data.getSaleSupportList());
		}
	}

	/**
	 * 判断合同名称是否存在
	 */
	@Override
	public boolean isExistContractName(String contractName, String contractId) {
		ContractExample example = new ContractExample();
		ContractExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(contractId)) {
			criteria.andIdNotEqualTo(contractId); // 排除自身(针对修改的时候)
		}
		criteria.andContractNameEqualTo(contractName);
		List<Contract> list = contractMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断合同编号是否存在
	 */
	@Override
	public boolean isExistContractNum(String contractNum, String contractId) {
		ContractExample example = new ContractExample();
		ContractExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(contractId)) {
			criteria.andIdNotEqualTo(contractId); // 排除自身(针对修改的时候)
		}
		criteria.andContractNumEqualTo(contractNum);
		List<Contract> list = contractMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return true;
		}
		return false;
	}

	/*
	 * 校验合同信息
	 */
	private void validateContract(Contract contract) {
		if (StringUtils.isBlank(contract.getContractName())) {
			throw new CommonException("合同名称为空");
		}
		if (StringUtils.isBlank(contract.getContractNum())) {
			throw new CommonException("合同编号为空");
		}
		if (isExistContractName(contract.getContractName(), null)) {
			throw new CommonException("合同名称已存在");
		}
		if (isExistContractNum(contract.getContractNum(), null)) {
			throw new CommonException("合同编号已存在");
		}
		if (StringUtils.isBlank(contract.getSignAddr())) {
			throw new CommonException("合同签署地为空");
		}
		if (StringUtils.isBlank(contract.getPartyBId())) {
			throw new CommonException("乙方公司ID为空");
		}
		if (null == contract.getSignDate()) {
			throw new CommonException("合同签署日期为空");
		}
		// 有效期
		Date startDate = contract.getStartDate();
		Date endDate = contract.getEndDate();
		if (null == startDate) {
			throw new CommonException("合同生效开始日期为空");
		}
		if (null == endDate) {
			throw new CommonException("合同生效结束日期为空");
		}
		if (!checkValidDate(startDate, endDate)) {
			throw new CommonException("结束日期必须大于开始日期");
		}
		// 是否存在尚未结束的合同
		// String partyBId = contract.getPartyBId();
		// List<Contract> list = getUnfinishedContractsByPartyB(partyBId);
		// if (CollectionUtils.isNotEmpty(list)) {
		// throw new CommonException("存在与该乙方尚未结束的合同，暂时无法新增");
		// }
	}

	@Override
	public ContractInfo detail(String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("合同ID为空");
		}
		Contract contract = this.contractMapper.selectByPrimaryKey(id);
		if (null == contract) {
			throw new CommonException("找不到该合同记录");
		}
		List<ContractRefundTarget> refundTargetList = contractRefundTargetService.getRefundTargetListByContractId(id);
		List<ContractSaleSupport> saleSupportList = contractSaleSupportService.getSaleSupportListByContractId(id);
		ContractInfo info = new ContractInfo();
		info.setContract(contract);
		info.setRefundTargetList(refundTargetList);
		info.setSaleSupportList(saleSupportList);
		return info;
	}

	@Override
	public void update(ContractInfo data) {
		if (null == data) {
			throw new CommonException("请求数据为空");
		}
		Contract contract = data.getContract();
		if (null == contract || StringUtils.isBlank(contract.getId())) {
			throw new CommonException("请求数据为空");
		}
		String contractId = contract.getId();
		String contractName = contract.getContractName();
		if (StringUtils.isNotBlank(contractName) && isExistContractName(contractName, contractId)) {
			throw new CommonException("合同名称已存在");
		}
		String contractNum = contract.getContractNum();
		if (StringUtils.isNotBlank(contractNum) && isExistContractNum(contractNum, contractId)) {
			throw new CommonException("合同编号已存在");
		}
		// 有效期
		Date startDate = contract.getStartDate();
		Date endDate = contract.getEndDate();
		if (null != startDate && null != endDate) {
			if (!checkValidDate(startDate, endDate)) {
				throw new CommonException("结束日期必须大于开始日期");
			}
		}
		Date now = new Date();
		contract.setUpdateTime(now);
		// 更新信息
		int result = contractMapper.updateByPrimaryKeySelective(contract);
		if (result > 0) {
			// 更新关联数据
			contractRefundTargetService.update(contractId, data.getRefundTargetList());
			contractSaleSupportService.update(contractId, data.getSaleSupportList());
		}
	}

	/**
	 * 根据乙方ID(经销商公司ID)查询当前有效合同记录
	 * 
	 * @param partyBId
	 *            乙方ID(经销商公司ID)
	 * @return
	 */
	@Override
	public Contract getValidContractByPartyB(String partyBId) {
		if (StringUtils.isBlank(partyBId)) {
			throw new CommonException("乙方ID为空");
		}
		Date now = new Date(); // 当前时间
		ContractExample example = new ContractExample();
		ContractExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andPartyBIdEqualTo(partyBId);
		// criteria.andStatusEqualTo(ContractStatus.Valid.getId()); // 有效状态
		criteria.andStartDateLessThanOrEqualTo(now).andEndDateGreaterThanOrEqualTo(now); // 当前时间在有效区间内
		List<Contract> list = this.contractMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		if (list.size() > 1) {
			throw new CommonException(String.format("跟乙方ID=%s的有效合同记录有多条", partyBId));
		}

		return list.get(0);
	}

	/**
	 * 根据乙方ID(经销商公司ID)查询尚未结束的合同列表记录
	 * 
	 * @param partyBId
	 *            乙方ID(经销商公司ID)
	 * @return
	 */
	@Override
	public List<Contract> getUnfinishedContractsByPartyB(String partyBId) {
		if (StringUtils.isBlank(partyBId)) {
			throw new CommonException("乙方ID为空");
		}
		Date now = new Date(); // 当前时间
		ContractExample example = new ContractExample();
		ContractExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andPartyBIdEqualTo(partyBId);
		criteria.andEndDateGreaterThan(now); // 未结束
		List<Contract> list = this.contractMapper.selectByExample(example);
		return list;
	}

	/*
	 * 检查合同有效期
	 */
	private Boolean checkValidDate(Date startDate, Date endDate) {
		if (null == startDate || null == endDate) {
			throw new CommonException("合同开始日期或结束日期为空");
		}
		if (startDate.after(endDate)) {
			return false;
		}

		return true;
	}

}