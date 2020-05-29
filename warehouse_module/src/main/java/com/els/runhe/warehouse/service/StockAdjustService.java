package com.els.runhe.warehouse.service;

import com.els.base.core.service.BaseService;
import com.els.runhe.warehouse.entity.StockAdjust;
import com.els.runhe.warehouse.entity.StockAdjustExample;
import com.els.runhe.warehouse.model.StockAdjustInfo;

public interface StockAdjustService extends BaseService<StockAdjust, StockAdjustExample, String> {

	/**
	 * 新增库存调整单
	 * 
	 * @param data
	 */
	void add(StockAdjustInfo data);

	/**
	 * 是否存在库存调整单号
	 * 
	 * @param adjustOrderNum
	 *            库存调整单号
	 * @param id
	 *            ID用于修改时，主要为了排除自身记录
	 * @return
	 */
	boolean isExistAdjustOrderNum(String adjustOrderNum, String id);

	/**
	 * 查询库存调整单详情
	 * 
	 * @param id
	 *            库存调整单ID
	 * @return
	 */
	StockAdjustInfo detail(String id);

}