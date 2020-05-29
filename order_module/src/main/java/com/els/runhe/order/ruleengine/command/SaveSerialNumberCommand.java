package com.els.runhe.order.ruleengine.command;

import java.text.MessageFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Assert;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.entity.OrderProductExample;
import com.els.runhe.order.ruleengine.OrderCommand;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.state.ApprovalStatus;
import com.els.runhe.order.ruleengine.state.DeliveryStatus;
import com.els.runhe.order.service.OrderProductService;
import com.els.runhe.order.service.OrderService;

/**
 * 保存流水号的命令
 * @author hzy
 *
 */
public class SaveSerialNumberCommand implements OrderCommand {

	protected static OrderService orderService = SpringContextHolder.getOneBean(OrderService.class);
	protected static OrderProductService orderProductService = SpringContextHolder.getOneBean(OrderProductService.class);
	private Order order;

	public SaveSerialNumberCommand(Order order) {
		this.order = order;
		
	}

	@Override
	public void execute(OrderRuleEngine context) {
		Assert.isNotNull(this.order, "订单信息不能为空");
		Assert.isNotNull(this.order.getId(), "订单Id不能为空");
		Assert.isNotEmpty(order.getOrderItems(), "订单行信息不能为空");
		
		for(OrderProduct orderProduct : order.getOrderItems()){
			Assert.isNotBlank(orderProduct.getId(), "订单行id不能为空");
			Assert.isNotBlank(orderProduct.getOrderProductSerialNo(), "输入的流水号不能为空");
		}
		
		Order oldOrder = orderService.queryObjById(order.getId());
		if (ApprovalStatus.UN_APPROVAL.getCode().equals(oldOrder.getApprovalStatus())
				|| ApprovalStatus.UN_PASS.getCode().equals(oldOrder.getApprovalStatus())) {
			throw new CommonException("订单审批通过后才能输入流水号");
		}
		
		if (!DeliveryStatus.UN_SENT.getCode().equals(oldOrder.getDeliveryStatus())) {
			throw new CommonException("订单待发货的情况下才能可以输入流水号");
		}
		
		for(OrderProduct orderProduct : order.getOrderItems()){
			
			OrderProductExample example = new OrderProductExample();
			example.createCriteria()
			    .andOrderProductSerialNoEqualTo(orderProduct.getOrderProductSerialNo())
			    .andIdNotEqualTo(orderProduct.getId());
		
			List<OrderProduct> list = orderProductService.queryAllObjByExample(example);
			if (CollectionUtils.isNotEmpty(list)) {
				String message = MessageFormat.format("流水号[{0}]已存在，无法保存", orderProduct.getOrderProductSerialNo());
				throw new CommonException(message );
			}
			
			OrderProduct tmp = new OrderProduct();
			tmp.setId(orderProduct.getId());
			tmp.setOrderProductSerialNo(orderProduct.getOrderProductSerialNo());
			orderProductService.modifyObj(orderProduct);
		}
	}

	

}
