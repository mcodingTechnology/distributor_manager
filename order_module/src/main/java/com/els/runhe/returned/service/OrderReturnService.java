package com.els.runhe.returned.service;

import com.els.base.core.service.BaseService;
import com.els.runhe.returned.entity.OrderReturn;
import com.els.runhe.returned.entity.OrderReturnExample;

public interface OrderReturnService extends BaseService<OrderReturn, OrderReturnExample, Integer> {
	
	/**
     * 根据退货单编号删除
     * @param orderReturnNo
     */
    public void deleteObjByOrderReturnNo(String orderReturnNo);

    /**
     * 批量修改退货单
     * @param record
     * @param OrderReturnExample
     */
    public void modifyObjByExample(OrderReturn record, OrderReturnExample OrderReturnExample);
    
    /**
     * 根据退货单编号查询
     * @param orderReturnNo
     * @return
     */
    public OrderReturn queryByOrderReturnNo(String orderReturnNo);
}