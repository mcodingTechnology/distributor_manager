package com.els.runhe.order.ruleengine;

/**
 * 订单规则
 * @author hzy
 *
 */
public interface OrderRule {
	
	/**
	 * 判断当前指令或订单，是否与规则的要求匹配
	 * @param order
	 * @param orderCommand
	 * @return
	 */
	boolean isMatch(OrderCommand orderCommand);
	
	/**
	 * 订单的指令的预处理，如果返回true，订单指令按计划执行，如果返回false，停止执行订单指令。例如做用户的订单控制等。
	 * @param order
	 * @param orderCommand
	 * @return
	 */
	boolean preHandler(OrderCommand orderCommand);
	
	/**
	 * 订单指令执行完毕后，补充执行。例如发送优惠券等。
	 * @param order
	 * @param orderCommand
	 */
	public void afterCompletion(OrderCommand orderCommand);

}
