package com.els.runhe.order.ruleengine.rule;

import java.math.BigDecimal;

import com.els.runhe.order.entity.Order;
import com.els.runhe.order.ruleengine.OrderCommand;
import com.els.runhe.order.ruleengine.OrderRule;
import com.els.runhe.order.ruleengine.command.CreateOrderCommand;
import com.els.runhe.order.ruleengine.command.ModifyOrderCommand;
import com.els.runhe.order.ruleengine.state.OrderStateCheckable;

public class OrderAmountPayRule implements OrderRule {

	@Override
	public boolean isMatch(OrderCommand orderCommand) {
		return  orderCommand instanceof CreateOrderCommand 
				|| orderCommand instanceof ModifyOrderCommand;
	}

	@Override
	public boolean preHandler(OrderCommand orderCommand) {
		
		OrderStateCheckable checkable = (OrderStateCheckable) orderCommand;
		Order order = checkable.getOrder();
		
		if (order.getAmountReduce() == null) {
			order.setAmountReduce(BigDecimal.ZERO);
		}
		
		if (order.getAmountPreferential() == null) {
			order.setAmountPreferential(BigDecimal.ZERO);
		}
		
		if (order.getApplySaleSupport() == null) {
			order.setApplySaleSupport(BigDecimal.ZERO);
		}
		
		if (order.getApplyMarketSupport() == null) {
			order.setApplyMarketSupport(BigDecimal.ZERO);
		}
		
		BigDecimal amountPay = order.getAmountTotal()
		     .subtract(order.getAmountReduce())
		     .subtract(order.getAmountPreferential())
		     .subtract(order.getApplySaleSupport())
		     .subtract(order.getApplyMarketSupport());
		     
		
		if (order.getTax() == null) {
			order.setTax(BigDecimal.ZERO);
		}
		
		BigDecimal amountTax = amountPay.multiply(order.getTax()).divide(new BigDecimal(100));
		amountPay = amountPay.add(amountTax);
		
		order.setAmountPay(amountPay);
		return true;
	}

	@Override
	public void afterCompletion(OrderCommand orderCommand) {
		// TODO Auto-generated method stub

	}

}
