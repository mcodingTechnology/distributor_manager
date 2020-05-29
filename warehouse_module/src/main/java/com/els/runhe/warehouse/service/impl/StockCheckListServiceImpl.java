package com.els.runhe.warehouse.service.impl;

import java.util.ArrayList;
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

import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.core.entity.PageView;
import com.els.base.utils.SpringContextHolder;
import com.els.base.workflow.common.service.WorkFlowService;
import com.els.base.workflow.common.utils.ProcessVariableNameEnum;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.warehouse.component.ProductComponent;
import com.els.runhe.warehouse.dao.StockCheckListMapper;
import com.els.runhe.warehouse.data.StockCheckType;
import com.els.runhe.warehouse.data.StockConstant;
import com.els.runhe.warehouse.entity.Stock;
import com.els.runhe.warehouse.entity.StockCheck;
import com.els.runhe.warehouse.entity.StockCheckList;
import com.els.runhe.warehouse.entity.StockCheckListExample;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.model.StockKey;
import com.els.runhe.warehouse.service.StockCheckListService;
import com.els.runhe.warehouse.service.StockService;
import com.els.runhe.warehouse.util.IdUtil;

@Service("defaultStockCheckListService")
public class StockCheckListServiceImpl implements StockCheckListService {

	@Resource
	protected StockCheckListMapper stockCheckListMapper;

	@Resource
	protected ProductComponent productComponent;

	@Resource
	protected StockService stockService;
	
	protected static WorkFlowService workFlowService = SpringContextHolder.getOneBean(WorkFlowService.class);

	
	@CacheEvict(value = { "stockCheckList" }, allEntries = true)
	@Override
	public void addObj(StockCheckList t) {
		this.stockCheckListMapper.insertSelective(t);
	}

	@CacheEvict(value = { "stockCheckList" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.stockCheckListMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "stockCheckList" }, allEntries = true)
	@Override
	public void modifyObj(StockCheckList t) {
		if (StringUtils.isBlank(t.getId())) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.stockCheckListMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "stockCheckList", keyGenerator = "redisKeyGenerator")
	@Override
	public StockCheckList queryObjById(String id) {
		return this.stockCheckListMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "stockCheckList", key = "'StockCheckListService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public List<StockCheckList> queryAllObjByExample(StockCheckListExample example) {
		return this.stockCheckListMapper.selectByExample(example);
	}

	@Cacheable(value = "stockCheckList", key = "'StockCheckListService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public PageView<StockCheckList> queryObjByPage(StockCheckListExample example) {
		PageView<StockCheckList> pageView = example.getPageView();
		pageView.setQueryResult(this.stockCheckListMapper.selectByExampleByPage(example));
		return pageView;
	}

	@Override
	public void addList(List<StockCheckList> stockCheckList, StockCheck stockCheck, Warehouse warehouse) {
		String stockCheckId = stockCheck.getId();
		String src = stockCheck.getSrc();
		Date date = stockCheck.getCreateTime();
		// 盘点明细清单数据处理
		List<Integer> productIdList = new ArrayList<>();
		String warehouseId = warehouse.getId();
		warehouseId = (StringUtils.isBlank(warehouseId)) ? "" : warehouseId;
		List<StockKey> stockKeyList = new ArrayList<>();
		for (StockCheckList detail : stockCheckList) {
			String productId = detail.getProductId();
			if (StringUtils.isBlank(productId) || detail.getAmount() < 0) {
				continue;
			}
			StockKey stockKey = new StockKey();
			stockKey.setProductId(productId);
			stockKey.setWarehouseId(warehouseId);
			stockKeyList.add(stockKey);

			productIdList.add(IdUtil.change(productId));

			detail.setStockCheckId(stockCheckId);
			detail.setSrc(src);

			detail.setCreateTime(date);
			detail.setUpdateTime(date);
		}
		if (CollectionUtils.isEmpty(productIdList)) {
			return;
		}
		Map<String, Stock> stockMap = productComponent.transferStockToMapByKeys(stockKeyList);
		// 产品信息处理
		Map<String, Product> productMap = productComponent.transferIdsToMap(productIdList);
		if (null == productMap || productMap.isEmpty()) {
			return;
		}
		// 插入明细清单
		for (StockCheckList detail : stockCheckList) {
			String productId = detail.getProductId();
			Product product = productMap.get(productId);
			if (null == product) {
				continue;
			}
			detail.setProductName(product.getProductName());
			// detail.setProductCode(product.getNumberCode());
			detail.setProductCode(product.getBarCode());
			detail.setProductModel(product.getSpec());
			detail.setProductUnit(product.getUnit());
			int result = stockCheckListMapper.insertSelective(detail);
			// 更新库存(同时会产生库存流水单)    -2018-01-21  改为提交审批
		}
		Map<String, Object> processMap = new HashMap<>();
		processMap.put(ProcessVariableNameEnum.START_USER.getVarName(), SpringSecurityUtils.getLoginUserName());
		processMap.put(ProcessVariableNameEnum.BUSINESS_ID.getVarName(), stockCheck.getId());
		processMap.put(ProcessVariableNameEnum.COMPANY_NAME.getVarName(), stockCheck.getCompanyName());
		if(StockCheckType.Check.getId().equals(stockCheck.getType())){
			processMap.put(ProcessVariableNameEnum.TITLE.getVarName(), "盘点单审批流程");
			workFlowService.startProcess(StockConstant.STOCK_CHECK_APPROVE_PROCESS_ID, stockCheck.getId(), processMap);
		}else {
			processMap.put(ProcessVariableNameEnum.TITLE.getVarName(), "入库单审批流程");
			workFlowService.startProcess(StockConstant.STORAGE_APPROVE_PROCESS_ID, stockCheck.getId(), processMap);

		}
	}

	@Override
	public List<StockCheckList> queryObjByStockCheckId(String id) {
		return this.stockCheckListMapper.queryObjByStockCheckId(id);
	}

}