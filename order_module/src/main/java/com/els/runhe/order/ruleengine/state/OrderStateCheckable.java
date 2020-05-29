package com.els.runhe.order.ruleengine.state;

import com.els.runhe.order.entity.Order;
import com.els.runhe.order.ruleengine.OrderCommand;

public interface OrderStateCheckable extends OrderCommand {

	Order getOrder();
}
