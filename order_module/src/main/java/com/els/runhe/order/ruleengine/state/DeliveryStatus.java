package com.els.runhe.order.ruleengine.state;

import com.els.runhe.order.entity.Order;

public class DeliveryStatus extends AbstractOrderState {
	
	/**待发货**/
	public static final DeliveryStatus UN_SENT = new DeliveryStatus(300, "待发货");
	/**待收货**/
	public static final DeliveryStatus UN_RECEIVED = new DeliveryStatus(400, "待收货");
	/**已收货**/
	public static final DeliveryStatus FININSH = new DeliveryStatus(500, "已收货");

	private Integer code;
	private String name;

	public DeliveryStatus(Order order) {
		super(order);
		this.code = order.getDeliveryStatus();
	}
	
	private DeliveryStatus(Integer code, String name) {
		super(null);
		this.code = code;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	@Override
	public void checkCanDo(OrderStateCheckable command) {
		// TODO Auto-generated method stub

	}

}
