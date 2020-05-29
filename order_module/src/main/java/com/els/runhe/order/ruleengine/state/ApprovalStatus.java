package com.els.runhe.order.ruleengine.state;

import com.els.base.core.exception.CommonException;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.ruleengine.command.DeliverOrderCommand;

public class ApprovalStatus extends AbstractOrderState{
	
	/**待审批**/
	public static final ApprovalStatus UN_APPROVAL = new ApprovalStatus(100, "待审批");
	/**运维审批通过**/
	public static final ApprovalStatus OPERATOR_PASS = new ApprovalStatus(150, "运维审批通过");
	/**运维审批通过**/
	public static final ApprovalStatus OPERATOR_UNPASS = new ApprovalStatus(160, "运维审批不通过");
	/**审批通过**/
	public static final ApprovalStatus FINANCIAL_PASS = new ApprovalStatus(200, "审批通过");
	/**审批不通过**/
	public static final ApprovalStatus UN_PASS = new ApprovalStatus(300, "财务审批不通过");

	private Integer code;
	private String name;

	public ApprovalStatus(Order order) {
		super(order);
		this.code = order.getDeliveryStatus();
	}
	
	private ApprovalStatus(Integer code, String name) {
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
		if (UN_APPROVAL.equals(this.code)
				&& (command instanceof DeliverOrderCommand)) {
			throw new CommonException("该订单还没有运营审批，无法操作");
		}
	}

}
