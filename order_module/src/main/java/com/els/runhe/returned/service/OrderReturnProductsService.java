package com.els.runhe.returned.service;

import com.els.base.core.service.BaseService;
import com.els.runhe.returned.entity.OrderReturnProducts;
import com.els.runhe.returned.entity.OrderReturnProductsExample;

public interface OrderReturnProductsService extends BaseService<OrderReturnProducts, OrderReturnProductsExample, Integer> {

	/**
     * 根据退货单编号删除退货单关联表
     * @param orderReturnNo
     */
    public void deleteObjByOrderReturnNo(String orderReturnNo);
}