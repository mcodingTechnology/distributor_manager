package com.els.runhe.order.ruleengine.state;

import com.els.runhe.order.entity.Order;

/**
 * 订单状态的抽象类
 * 
 * @author hzy
 *
 */
public abstract class AbstractOrderState {

	private Order order;

	public AbstractOrderState(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	/**
	 * 检查订单能否执行该命令
	 * 
	 * @param command
	 */
	public abstract void checkCanDo(OrderStateCheckable command);

	/**
	 * 这个订单有没有这个状态
	 * 
	 * @param order
	 * @return
	 */
	public boolean isMatch(Order order) {
		return true;
	}

}
