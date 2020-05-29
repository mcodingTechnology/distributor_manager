package com.els.runhe.order.ruleengine.rule;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.els.base.core.exception.CommonException;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.ruleengine.OrderCommand;
import com.els.runhe.order.ruleengine.OrderRule;
import com.els.runhe.order.ruleengine.state.AbstractOrderState;
import com.els.runhe.order.ruleengine.state.OrderStateCheckable;

/**
 * 根据订单的状态判断该命令能否执行
 * @author hzy
 *
 */
public class IsExecutableCheckRule implements OrderRule {
	
	private static Logger logger = LoggerFactory.getLogger(IsExecutableCheckRule.class);

	@Override
	public boolean isMatch(OrderCommand orderCommand) {
		return orderCommand instanceof OrderStateCheckable;
	}

	@Override
	public boolean preHandler(OrderCommand orderCommand) {
		
		OrderStateCheckable checkable = (OrderStateCheckable) orderCommand;
		Order order = checkable.getOrder();
		
		if (order == null) {
			return true;
		}
		
		List<AbstractOrderState> stateList = null;
		try {
			stateList = order.getStateList();
			
		} catch (Exception e) {
			logger.error("订单状态判断失败", e);
			throw new CommonException("订单状态判断失败");
		}
		
		if (CollectionUtils.isEmpty(stateList)) {
			return true;
		}
		
		for(AbstractOrderState state : stateList){
			state.checkCanDo(checkable);
		}
		return true;
	}

	@Override
	public void afterCompletion(OrderCommand orderCommand) {
		// TODO Auto-generated method stub
		
	}

}
