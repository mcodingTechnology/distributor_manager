package com.els.runhe.order.service;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.entity.OrderProductExample;

public interface OrderProductService extends BaseService<OrderProduct, OrderProductExample, String> {

	void deleteObjByExample(OrderProductExample orderProductExample);
	
	List<OrderProduct> queryByOrderId(String orderId);
}