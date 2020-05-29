package com.els.runhe.order.service;

import com.els.base.core.service.BaseService;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderExample;

public interface OrderService extends BaseService<Order, OrderExample, String> {
	
	/**
	 * 批量修改订单
	 * @param orderExample
	 */
	void modifyObjByExample(Order record, OrderExample orderExample);
}