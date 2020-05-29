package com.els.runhe.warehouse.service;

import java.util.List;
import java.util.Map;

import com.els.base.core.entity.PageView;
import com.els.base.core.service.BaseService;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.warehouse.entity.Stock;
import com.els.runhe.warehouse.entity.StockExample;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.model.StockOpt;

public interface StockService extends BaseService<Stock, StockExample, String> {

	/**
	 * 操作库存，同时会产生库存流水(适合单个操作，不适合批量调用，批量操作请调用optStockByBatch方法)
	 * 
	 * @param data
	 * @return
	 */
	Stock optStock(StockOpt data);

	/**
	 * 操作库存，同时会产生库存流水(适合批量调用)
	 * 
	 * @param data
	 * @param warehouse
	 * @param product
	 * @return
	 */
	int optStockByBatch(StockOpt data, Warehouse warehouse, Product product, Map<String, Stock> stockMap);

	/**
	 * 根据产品聚合查询库存记录
	 * 
	 * @param example
	 * @return
	 */
	PageView<Stock> queryForProductByPage(StockExample example);

	/**
	 * 根据产品ID获取库存信息
	 * 
	 * @param warehouseId
	 *            仓库ID，可选
	 * @param productId
	 *            产品ID
	 * @return
	 */
	Stock getStockInfoByProduct(String warehouseId, String productId);

	/**
	 * 根据产品ID列表获取相应的库存量
	 * 
	 * @param warehouseId
	 *            仓库ID，可选
	 * @param productIdList
	 *            品ID列表
	 * @return 返回Map：Key是产品ID，Value是库存信息
	 */
	Map<String, Stock> getStocksByProducts(String warehouseId, List<String> productIdList);

}