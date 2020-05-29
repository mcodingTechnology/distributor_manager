package com.els.runhe.order.ruleengine.command;

import org.apache.commons.lang.StringUtils;

import com.els.base.utils.SpringContextHolder;
import com.els.base.workflow.common.service.WorkFlowService;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.event.OrderSubmitEvent;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.state.OrderStateCheckable;
import com.els.runhe.order.ruleengine.state.SubmitStatus;
import com.els.runhe.order.service.OrderService;

/**
 * 提交订单指令
 * @author hzy
 *
 */
public class SubmitOrderComand implements OrderStateCheckable  {
	
	protected static OrderService orderService = SpringContextHolder.getOneBean(OrderService.class);
	protected static WorkFlowService workFlowService = SpringContextHolder.getOneBean(WorkFlowService.class);
	
	private Order order;
	
	public SubmitOrderComand(Order order) {
		this.order = order;
	}

	@Override
	public void execute(OrderRuleEngine context) {
		
		//1、保存订单
		if (StringUtils.isBlank(order.getId())) {
			//如果没有保存，就先保存
			CreateOrderCommand createOrderCommand = new CreateOrderCommand(order);
			context.invoke(createOrderCommand);
		}else {
			
			//如果已经保存，就修改
			ModifyOrderCommand modifyOrderCommand = new ModifyOrderCommand(order);
			context.invoke(modifyOrderCommand);
		}
		
		//2、修改状态为 已提交
		order.setStatus(SubmitStatus.SUBMITED.getCode());
		orderService.modifyObj(order);
		
		//冻结库存
		context.invoke(new FreezeStockCommand(order.getId()));
		
		//3、触发审核流程
		context.invoke(new StartApprovalCommand(order));
		
		//添加销售和市场支持额度
		context.invoke(new AddSupportRecordCommand(order));
		
		//4、发布订单提交事件
		SpringContextHolder.getApplicationContext().publishEvent(new OrderSubmitEvent(order));
	}

	@Override
	public Order getOrder() {
		return this.order;
	}

}
