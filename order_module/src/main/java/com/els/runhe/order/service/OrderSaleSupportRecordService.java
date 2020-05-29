package com.els.runhe.order.service;

import com.els.base.core.service.BaseService;
import com.els.runhe.order.entity.SaleAndMarketSupport;
import com.els.runhe.order.entity.OrderSaleSupportRecord;
import com.els.runhe.order.entity.OrderSaleSupportRecordExample;

public interface OrderSaleSupportRecordService extends BaseService<OrderSaleSupportRecord, OrderSaleSupportRecordExample, String> {
	
	/**
	 * 计算企业当前的销售支持额度
	 * @param companyId
	 * @return
	 */
	SaleAndMarketSupport calculateByOrderId(String companyId);

	SaleAndMarketSupport saleSupportRecordByCompanyId(String purCompanyId);
}