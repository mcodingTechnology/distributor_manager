package com.els.runhe.warehouse.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.base.utils.SpringContextHolder;
import com.els.base.workflow.common.service.WorkFlowService;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.product.dao.product.ProductMapper;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.warehouse.dao.StockAdjustListMapper;
import com.els.runhe.warehouse.data.AmountType;
import com.els.runhe.warehouse.data.StockConstant;
import com.els.runhe.warehouse.entity.Stock;
import com.els.runhe.warehouse.entity.StockAdjust;
import com.els.runhe.warehouse.entity.StockAdjustList;
import com.els.runhe.warehouse.entity.StockAdjustListExample;
import com.els.runhe.warehouse.service.StockAdjustListService;
import com.els.runhe.warehouse.service.StockService;
import com.els.runhe.warehouse.util.IdUtil;

@Service("defaultStockAdjustListService")
@Transactional
public class StockAdjustListServiceImpl implements StockAdjustListService {

	@Resource
	protected StockAdjustListMapper stockAdjustListMapper;

	@Resource
	protected ProductMapper productMapper;

	@Resource
	protected StockService stockService;
	
	protected static WorkFlowService workFlowService = SpringContextHolder.getOneBean(WorkFlowService.class);


	@CacheEvict(value = { "stockAdjustList" }, allEntries = true)
	@Override
	public void addObj(StockAdjustList t) {
		this.stockAdjustListMapper.insertSelective(t);
	}

	@CacheEvict(value = { "stockAdjustList" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.stockAdjustListMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "stockAdjustList" }, allEntries = true)
	@Override
	public void modifyObj(StockAdjustList t) {
		if (StringUtils.isBlank(t.getId())) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.stockAdjustListMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "stockAdjustList", keyGenerator = "redisKeyGenerator")
	@Override
	public StockAdjustList queryObjById(String id) {
		return this.stockAdjustListMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "stockAdjustList", keyGenerator = "redisKeyGenerator")
	@Override
	public List<StockAdjustList> queryAllObjByExample(StockAdjustListExample example) {
		return this.stockAdjustListMapper.selectByExample(example);
	}

	@Cacheable(value = "stockAdjustList", keyGenerator = "redisKeyGenerator")
	@Override
	public PageView<StockAdjustList> queryObjByPage(StockAdjustListExample example) {
		PageView<StockAdjustList> pageView = example.getPageView();
		pageView.setQueryResult(this.stockAdjustListMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 新增库存调整清单列表
	 */
	@Override
	public void addList(StockAdjust data, List<StockAdjustList> list) {
		if (null == data || CollectionUtils.isEmpty(list)) {
			return;
		}
		String stockAdjustId = data.getId();
		if (StringUtils.isBlank(stockAdjustId)) {
			throw new CommonException("调整单ID为空");
		}

		for (StockAdjustList detail : list) {
			if (null == detail) {
				continue;
			}
			add(data, detail);
		}
		
		Map<String, Object> processMap = new HashMap<>();
		processMap.put(ProcessVariableNameEnum.START_USER.getVarName(), SpringSecurityUtils.getLoginUserName());
		processMap.put(ProcessVariableNameEnum.BUSINESS_ID.getVarName(), data.getId());
		processMap.put(ProcessVariableNameEnum.COMPANY_NAME.getVarName(), data.getCompanyName());
		processMap.put(ProcessVariableNameEnum.TITLE.getVarName(), "调整单审批流程");
		workFlowService.startProcess(StockConstant.STOCK_ADJUST_APPROVE_PROCESS_ID, data.getId(), processMap);
	}

	/**
	 * 新增库存调整清单
	 * 
	 * @param data
	 * @param detail
	 */
	@Override
	public void add(StockAdjust data, StockAdjustList detail) {
		if (!validateStockAdjustList(detail)) {
			throw new CommonException("调整清单数据非法");
		}
		String stockAdjustId = data.getId();
		String productId = detail.getProductId();
		String adjustType = detail.getAdjustType();
		Integer amount = detail.getAmount();
		Product product = productMapper.selectByPrimaryKey(IdUtil.change(productId));
		if (null == product) {
			throw new CommonException("调整清单产品不存在");
		}
		Stock stock = stockService.getStockInfoByProduct(data.getWarehouseId(), productId);
		if (null == stock) {
			throw new CommonException("调整清单产品库存记录不存在");
		}
		if (AmountType.Minus.getId().equals(adjustType)) {
			// 减少库存后库存不得小于0
			Integer originAmount = stock.getAmount();
			if (originAmount - amount < 0) {
				throw new CommonException("调整清单产品库存调整后小于0");
			}
		}

		Date now = new Date();

		// 设置关联信息
		detail.setStockAdjustId(stockAdjustId);

		// 设置产品信息
		detail.setProductCode(product.getBarCode());
		detail.setProductModel(product.getSpec());
		detail.setProductUnit(product.getUnit());

		// 设置其他信息
		detail.setCreateTime(now);
		detail.setUpdateTime(now);
		detail.setIsEnable(Constant.YES_INT);

		// 保存
		int result = this.stockAdjustListMapper.insertSelective(detail);

		// 修改库存和创建库存流水
		/*if (result > 0) {
			StockOpt stockOpt = new StockOpt();
			stockOpt.setProductId(productId);
			stockOpt.setWarehouseId(data.getWarehouseId());
			stockOpt.setAmount(amount);
			stockOpt.setAmountType(detail.getAdjustType());
			stockOpt.setOptType(StockOptType.Adjust.getId());
			stockService.optStock(stockOpt);
		}*/
	}

	/**
	 * 根据库存调整单ID查询库存调整清单列表
	 * 
	 * @param stockAdjustId
	 * @return
	 */
	@Override
	public List<StockAdjustList> queryListByStockAdjustId(String stockAdjustId) {
		if (StringUtils.isBlank(stockAdjustId)) {
			return null;
		}
		StockAdjustListExample example = new StockAdjustListExample();
		StockAdjustListExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andStockAdjustIdEqualTo(stockAdjustId);
		List<StockAdjustList> list = this.stockAdjustListMapper.selectByExample(example);
		return list;
	}

	/*
	 * 验证库存调整清单信息
	 */
	private boolean validateStockAdjustList(StockAdjustList data) {
		Integer amount = data.getAmount();
		if (null == amount || 0 == amount) {
			throw new CommonException("调整清单数量为空或为0");
		}
		String adjustType = data.getAdjustType();
		if (StringUtils.isBlank(adjustType)) {
			throw new CommonException("调整清单操作类型为空");
		}
		String productId = data.getProductId();
		if (StringUtils.isBlank(productId)) {
			throw new CommonException("调整清单产品ID为空");
		}

		return true;
	}

}