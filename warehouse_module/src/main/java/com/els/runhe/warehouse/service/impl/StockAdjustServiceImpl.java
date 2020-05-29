package com.els.runhe.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.company.entity.Company;
import com.els.base.company.utils.CompanyUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.user.User;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.runhe.warehouse.dao.StockAdjustMapper;
import com.els.runhe.warehouse.data.Status;
import com.els.runhe.warehouse.entity.StockAdjust;
import com.els.runhe.warehouse.entity.StockAdjustExample;
import com.els.runhe.warehouse.entity.StockAdjustList;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.model.StockAdjustInfo;
import com.els.runhe.warehouse.service.StockAdjustListService;
import com.els.runhe.warehouse.service.StockAdjustService;
import com.els.runhe.warehouse.service.WarehouseService;

@Service("defaultStockAdjustService")
@Transactional
public class StockAdjustServiceImpl implements StockAdjustService {

	@Resource
	protected StockAdjustMapper stockAdjustMapper;

	@Resource
	protected StockAdjustListService stockAdjustListService;

	@Resource
	protected WarehouseService warehouseService;

	@CacheEvict(value = { "stockAdjust" }, allEntries = true)
	@Override
	public void addObj(StockAdjust t) {
		this.stockAdjustMapper.insertSelective(t);
	}

	@CacheEvict(value = { "stockAdjust" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.stockAdjustMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "stockAdjust" }, allEntries = true)
	@Override
	public void modifyObj(StockAdjust t) {
		if (StringUtils.isBlank(t.getId())) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.stockAdjustMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "stockAdjust", keyGenerator = "redisKeyGenerator")
	@Override
	public StockAdjust queryObjById(String id) {
		return this.stockAdjustMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "stockAdjust", keyGenerator = "redisKeyGenerator")
	@Override
	public List<StockAdjust> queryAllObjByExample(StockAdjustExample example) {
		return this.stockAdjustMapper.selectByExample(example);
	}

	@Cacheable(value = "stockAdjust", keyGenerator = "redisKeyGenerator")
	@Override
	public PageView<StockAdjust> queryObjByPage(StockAdjustExample example) {
		PageView<StockAdjust> pageView = example.getPageView();
		pageView.setQueryResult(this.stockAdjustMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 新增库存调整单
	 */
	@Override
	public void add(StockAdjustInfo data) {
		if (null == data) {
			throw new CommonException("调整单信息不允许为空");
		}
		StockAdjust stockAdjust = data.getStockAdjust();
		List<StockAdjustList> list = data.getStockAdjustList();
		
		//调整单号生成规则(年月日时分秒) 例如：A20171113114311
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	String ids = "A"+sdf.format(date);
    	stockAdjust.setAdjustOrderNum(ids);
		
		int result = 0;
		Date now = new Date();
		if (validateStockAdjustInfo(stockAdjust)) {
			// 仓库信息
			String warehouseId = stockAdjust.getWarehouseId();
			if (StringUtils.isNotBlank(warehouseId)) {
				Warehouse warehouse = warehouseService.queryObjById(warehouseId);
				if (null != warehouse) {
					stockAdjust.setWarehouseName(warehouse.getWarehouseName());
				}
			}
			// 公司信息
			Company company = CompanyUtils.currentCompany();
			if (null != company) {
				stockAdjust.setCompanyId(company.getId());
				stockAdjust.setCompanyName(company.getCompanyFullName());
			}
			// 用户信息
			User user = SpringSecurityUtils.getLoginUser();
			if (null != user) {
				stockAdjust.setUserId(user.getId());
			}
			// 其他信息
			stockAdjust.setStatus(Status.To_Audit.getId());
			stockAdjust.setCreateTime(now);
			stockAdjust.setUpdateTime(now);
			stockAdjust.setIsEnable(Constant.YES_INT);
			// 保存
			result = this.stockAdjustMapper.insertSelective(stockAdjust);
		}
		if (result > 0) {
			stockAdjustListService.addList(stockAdjust, list);
		}
	}

	/**
	 * 是否存在库存调整单号
	 * 
	 * @param adjustOrderNum
	 *            库存调整单号
	 * @param id
	 *            ID用于修改时，主要为了排除自身记录
	 * @return
	 */
	@Override
	public boolean isExistAdjustOrderNum(String adjustOrderNum, String id) {
		StockAdjustExample example = new StockAdjustExample();
		StockAdjustExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andAdjustOrderNumEqualTo(adjustOrderNum);
		if (StringUtils.isNotBlank(id)) {
			criteria.andIdNotEqualTo(id); // 排除自身记录，用于修改的排重
		}
		List<StockAdjust> list = this.stockAdjustMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return false;
		}
		return true;
	}

	/**
	 * 查询库存调整单详情
	 * 
	 * @param id
	 *            库存调整单ID
	 * @return
	 */
	@Override
	public StockAdjustInfo detail(String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}
		// 查询调整单记录
		StockAdjust record = this.stockAdjustMapper.selectByPrimaryKey(id);
		if (null == record) {
			return null;
		}
		// 查询调整单清单列表
		List<StockAdjustList> list = this.stockAdjustListService.queryListByStockAdjustId(id);
		// 返回信息
		StockAdjustInfo info = new StockAdjustInfo();
		info.setStockAdjust(record);
		info.setStockAdjustList(list);

		return info;
	}

	/*
	 * 校验库存调整单信息
	 */
	private boolean validateStockAdjustInfo(StockAdjust data) {
		if (null == data) {
			throw new CommonException("调整信息不允许为空");
		}
		String id = data.getId();
		String adjustOrderNum = data.getAdjustOrderNum();
		if (StringUtils.isBlank(adjustOrderNum)) {
			throw new CommonException("调整单号不允许为空");
		}
		if (isExistAdjustOrderNum(adjustOrderNum, id)) {
			throw new CommonException("调整单号已存在");
		}
		return true;
	}

}