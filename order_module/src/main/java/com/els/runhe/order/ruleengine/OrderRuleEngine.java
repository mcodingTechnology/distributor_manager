package com.els.runhe.order.ruleengine;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.els.runhe.order.ruleengine.rule.CheckProductPriceRule;
import com.els.runhe.order.ruleengine.rule.IsExecutableCheckRule;
import com.els.runhe.order.ruleengine.rule.OrderAmountPayRule;

/**
 * 订单规则引擎
 * @author hzy
 *
 */
@Component
public class OrderRuleEngine {
	
	private static Logger logger = LoggerFactory.getLogger(OrderRuleEngine.class);
	
	/**
	 * 执行订单指令
	 * @param orderCommand
	 * @param order
	 */
	@Transactional
	public void invoke(OrderCommand orderCommand){
		logger.debug("当前执行的命令是[{}]", orderCommand.getClass().getName());
		
		//1、获取订单处理规则
		Queue<OrderRule> ruleList = this.getDefalutOrderRuleList();
		
		//2、按照规则执行订单指令
		invokeWithRule(ruleList, orderCommand);
	}
	
	private void invokeWithRule(Queue<OrderRule> ruleList, OrderCommand orderCommand) {
		OrderRule orderRule = ruleList.poll();
		
		if (orderRule == null) {
			//没有订单规则了,直接执行命令
			orderCommand.execute(this);
			return;
		}
		
		//如果有订单规则，按照规则执行
		if (orderRule.isMatch(orderCommand) ) {
			logger.debug("该命令匹配了规则,并开始执行。[{}]", orderRule);
			
			//如果匹配，使用规则，做前置的判断执行
			if (!orderRule.preHandler(orderCommand)) {
				return;
			}
			
			this.invokeWithRule(ruleList, orderCommand);
			
			//如果匹配，使用规则，做后置处理
			orderRule.afterCompletion(orderCommand);
			
		}else {
			
			//如果不匹配继续下一个规则
			this.invokeWithRule(ruleList, orderCommand);
		}
		
		
	}

	protected Queue<OrderRule> getDefalutOrderRuleList(){
		Queue<OrderRule> defaultRuleList = new LinkedList<>();
		defaultRuleList.offer(new IsExecutableCheckRule());
		defaultRuleList.offer(new CheckProductPriceRule());
		defaultRuleList.offer(new OrderAmountPayRule());
		return defaultRuleList;
	}

}
