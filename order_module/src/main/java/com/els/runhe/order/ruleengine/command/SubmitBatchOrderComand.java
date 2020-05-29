package com.els.runhe.order.ruleengine.command;

import java.util.List;

import com.els.base.core.utils.Assert;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderExample;
import com.els.runhe.order.event.OrderSubmitEvent;
import com.els.runhe.order.ruleengine.OrderCommand;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.state.SubmitStatus;
import com.els.runhe.order.service.OrderService;

public class SubmitBatchOrderComand implements OrderCommand {
	protected static OrderService orderService = SpringContextHolder.getOneBean(OrderService.class);

	private List<String> orderIds;

	public SubmitBatchOrderComand(List<String> orderIds) {
		this.orderIds = orderIds;
	}

	@Override
	public void execute(OrderRuleEngine context) {
		Assert.isNotEmpty(this.orderIds, "订单id不能为空");

		// 1、检查参数订单状态
		OrderExample orderExample = new OrderExample();
		orderExample.createCriteria()
		    .andIdIn(this.orderIds)
		    .andStatusEqualTo(SubmitStatus.UN_SUBMIT.getCode());
		
		List<Order> orderList = orderService.queryAllObjByExample(orderExample);
		Assert.isNotEmpty(orderList, "列表中不存在未提交的订单");
		
		for (Order order : orderList) {
			
			// 2、修改状态为 已提交
			order.setStatus(SubmitStatus.SUBMITED.getCode());
			orderService.modifyObj(order);
			
			//冻结库存
			context.invoke(new FreezeStockCommand(order.getId()));
			
			// 3、发起审批流程
			context.invoke(new StartApprovalCommand(order));
			
			//添加市场或者销售额度
			context.invoke(new AddSupportRecordCommand(order));

			// 4、发布订单提交事件,触发其他事情，例如发消息之类的
			SpringContextHolder.getApplicationContext().publishEvent(new OrderSubmitEvent(order));
			
		}
		
	}

}
