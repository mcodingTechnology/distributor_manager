package com.els.runhe.order.ruleengine.state;

import com.els.base.core.exception.CommonException;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.ruleengine.command.DeliverOrderCommand;
import com.els.runhe.order.ruleengine.command.ModifyOrderCommand;
import com.els.runhe.order.ruleengine.command.StartApprovalCommand;
import com.els.runhe.order.ruleengine.command.SubmitOrderComand;

/**
 * 订单提交状态
 * @author hzy
 *
 */
public class SubmitStatus extends AbstractOrderState {
	
	/**待提交**/
	public static final SubmitStatus UN_SUBMIT = new SubmitStatus(100, "待提交");
	/**已提交**/
	public static final SubmitStatus SUBMITED = new SubmitStatus(200, "已提交");
	/**已取消**/
	public static final SubmitStatus CANCEL = new SubmitStatus(600, "已取消");
	/**已支付**/
	public static final SubmitStatus PAID = new SubmitStatus(700, "已支付");
	
	private Integer code;
	private String name;

	public SubmitStatus(Order order) {
		super(order);
		this.code = order.getStatus();
	}
	
	private SubmitStatus(Integer code, String name) {
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
		if (UN_SUBMIT.getCode().equals( this.getCode())
				&& (command instanceof DeliverOrderCommand 
						|| command instanceof StartApprovalCommand )) {
			throw new CommonException("该订单还没有提交，无法操作");
		}
		
		if (SUBMITED.getCode().equals(this.getCode()) 
				&& (command instanceof ModifyOrderCommand
						|| command instanceof SubmitOrderComand) ) {
			throw new CommonException("该订单已经提交，无法操作");
		}

	}

}
