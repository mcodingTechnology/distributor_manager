package com.els.runhe.order.ruleengine.command;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.els.base.core.exception.CommonException;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderExample;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.entity.OrderProductExample;
import com.els.runhe.order.ruleengine.OrderCommand;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.state.ApprovalStatus;
import com.els.runhe.order.ruleengine.state.DeliveryStatus;
import com.els.runhe.order.service.OrderProductService;
import com.els.runhe.order.service.OrderService;
import com.els.runhe.order.utils.OrderSendWxMsgUtils;

/**
 * 订单发货指令
 * @author hzy
 *
 */
public class DeliverOrderCommand implements OrderCommand {
	
	/**
	 * 订货单号
	 */
	private List<String> orderIdList;
	/**
	 * 物流编码
	 */
	private String deliveryCode;
	
	protected static OrderService orderService = SpringContextHolder.getOneBean(OrderService.class);
	protected static OrderProductService orderProductService = SpringContextHolder.getOneBean(OrderProductService.class);

	@Override
	public void execute(OrderRuleEngine context) {
		if (CollectionUtils.isEmpty(orderIdList)) {
			throw new CommonException("订单id为空，无法发货");
		}
		
		OrderExample example = new OrderExample();
		example.createCriteria()
		    .andIdIn(orderIdList)
		    .andApprovalStatusNotEqualTo(ApprovalStatus.FINANCIAL_PASS.getCode());
		
		List<Order> orderList = orderService.queryAllObjByExample(example);
		if (CollectionUtils.isNotEmpty(orderList)) {
			throw new CommonException("还有未审核审核完毕的订单,无法发货");
		}
		
		OrderProductExample orderProductExample = new OrderProductExample();
		orderProductExample.createCriteria()
		    .andOrderIdIn(this.orderIdList)
		    .andOrderProductSerialNoIsNull();
		
		List<OrderProduct> orderProductList = orderProductService.queryAllObjByExample(orderProductExample);
		if (CollectionUtils.isNotEmpty(orderProductList)) {
			OrderProduct orderProduct = orderProductList.get(0);
			String orderNo = orderService.queryObjById(orderProduct.getOrderId()).getOrderNo();
			String message = MessageFormat.format("订单{0},产品{1}还没有录入流水号，无法发货",orderNo, orderProduct.getProductName());
			throw new CommonException(message);
		}
		
		example.clear();
		example.createCriteria().andIdIn(orderIdList);
		
		Order tmp = new Order();
		tmp.setDeliveryCode(deliveryCode);
		tmp.setDeliveryStatus(DeliveryStatus.UN_RECEIVED.getCode());
		tmp.setDeliveryTime(new Date());
		orderService.modifyObjByExample(tmp, example);
		
		orderList = orderService.queryAllObjByExample(example);
		OrderSendWxMsgUtils.sendMsg(OrderSendWxMsgUtils.ORDER_STATUS_UN_RECEIVED, orderList);
	}

	public DeliverOrderCommand(List<String> orderIdList, String deliveryCode) {
		super();
		this.orderIdList = orderIdList;
		this.deliveryCode = deliveryCode;
	}
	
	@SuppressWarnings("unused")
	private DeliverOrderCommand(){
		super();
	}

	public List<String> getOrderIdList() {
		return orderIdList;
	}
	
	

}
