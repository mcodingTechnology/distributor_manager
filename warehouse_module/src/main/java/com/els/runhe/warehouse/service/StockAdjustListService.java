package com.els.runhe.warehouse.service;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.warehouse.entity.StockAdjust;
import com.els.runhe.warehouse.entity.StockAdjustList;
import com.els.runhe.warehouse.entity.StockAdjustListExample;

public interface StockAdjustListService extends BaseService<StockAdjustList, StockAdjustListExample, String> {

	/**
	 * 新增库存调整清单列表
	 * 
	 * @param data
	 * @param list
	 */
	void addList(StockAdjust data, List<StockAdjustList> list);

	/**
	 * 新增库存调整清单
	 * 
	 * @param data
	 * @param detail
	 */
	void add(StockAdjust data, StockAdjustList detail);

	/**
	 * 根据库存调整单ID查询库存调整清单列表
	 * 
	 * @param stockAdjustId
	 * @return
	 */
	List<StockAdjustList> queryListByStockAdjustId(String stockAdjustId);

}