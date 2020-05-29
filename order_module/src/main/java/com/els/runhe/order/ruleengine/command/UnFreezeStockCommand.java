package com.els.runhe.order.ruleengine.command;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.els.base.utils.SpringContextHolder;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.ruleengine.OrderCommand;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.service.OrderProductService;
import com.els.runhe.warehouse.data.AmountType;
import com.els.runhe.warehouse.data.StockOptType;
import com.els.runhe.warehouse.model.StockOpt;
import com.els.runhe.warehouse.service.StockService;

public class UnFreezeStockCommand implements OrderCommand {

	private String orderId;

	public UnFreezeStockCommand(String orderId) {
		this.orderId = orderId;
	}

	@Override
	public void execute(OrderRuleEngine context) {
		
		List<OrderProduct> orderProducts = SpringContextHolder.getOneBean(OrderProductService.class).queryByOrderId(this.orderId);
		if (CollectionUtils.isEmpty(orderProducts)) {
			return;
		}
		
		StockService stockService = SpringContextHolder.getOneBean(StockService.class);
		for(OrderProduct orderProduct : orderProducts){
			StockOpt stockOpt = new StockOpt();
			stockOpt.setAmount(orderProduct.getNums());
			stockOpt.setProductId(String.valueOf(orderProduct.getProductId()));
			stockOpt.setAmountType(AmountType.Plus.getId());
			stockOpt.setOptType(StockOptType.Shipment.getId());
			
			stockService.optStock(stockOpt);
		}

	}

}
