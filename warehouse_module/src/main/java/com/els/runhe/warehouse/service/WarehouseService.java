package com.els.runhe.warehouse.service;

import java.util.List;
import java.util.Map;

import com.els.base.core.service.BaseService;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.entity.WarehouseExample;

public interface WarehouseService extends BaseService<Warehouse, WarehouseExample, String> {

	/**
	 * 将仓库编码列表转换为Map(Key为仓库编码，value为盘点单对象)
	 * 
	 * @param codes
	 *            仓库编码列表
	 * @return
	 */
	Map<String, Warehouse> transferCodesToMap(List<String> codes);

}