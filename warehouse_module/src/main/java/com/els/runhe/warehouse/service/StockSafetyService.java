package com.els.runhe.warehouse.service;

import com.els.base.core.service.BaseService;
import com.els.runhe.warehouse.entity.StockSafety;
import com.els.runhe.warehouse.entity.StockSafetyExample;

public interface StockSafetyService extends BaseService<StockSafety, StockSafetyExample, String> {

	/**
	 * 根据产品ID获取库存安全信息(安全库存预警)
	 * 
	 * @param productId
	 *            产品ID
	 * @return
	 */
	StockSafety getStockSafetyInfoByProduct(String productId);

}