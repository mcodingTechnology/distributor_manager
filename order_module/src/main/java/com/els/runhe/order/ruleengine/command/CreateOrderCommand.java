package com.els.runhe.order.ruleengine.command;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.codegenerator.service.GenerateCodeService;
import com.els.base.company.entity.Company;
import com.els.base.company.entity.CompanyExample;
import com.els.base.company.service.CompanyService;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Assert;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.event.OrderCreatedEvent;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.state.ApprovalStatus;
import com.els.runhe.order.ruleengine.state.DeliveryStatus;
import com.els.runhe.order.ruleengine.state.OrderStateCheckable;
import com.els.runhe.order.ruleengine.state.SubmitStatus;
import com.els.runhe.order.service.OrderProductService;
import com.els.runhe.order.service.OrderService;

/**
 * 创建订单指令
 * @author hzy
 *
 */
public class CreateOrderCommand implements OrderStateCheckable {
	private static final String ORDER_CODE_GENERATE = "SALE_ORDER_CODE";
	
	protected static OrderService orderService = SpringContextHolder.getOneBean(OrderService.class);
	protected static CompanyService companyService = SpringContextHolder.getOneBean(CompanyService.class);
	protected static OrderProductService orderProductService = SpringContextHolder.getOneBean(OrderProductService.class);
	protected static GenerateCodeService generateCodeService  = SpringContextHolder.getOneBean(GenerateCodeService.class);

	private Order order;
	
	public CreateOrderCommand(Order order) {
		this.order = order;
	}

	@Override
	public void execute(OrderRuleEngine context) {
		//1、校验数据
		valid(order);
		
		//2、初始化保存数据
		init(order);
		
		//3、保存数据
		orderService.addObj(order);
		
    	for(OrderProduct orderProduct: order.getOrderItems()){
    		orderProduct.setOrderId(order.getId());
    		orderProductService.addObj(orderProduct);
    	}
    	
    	//发布订单保存事件
    	SpringContextHolder.getApplicationContext().publishEvent(new OrderCreatedEvent(order));
	}
	
	/**
	 * 初始化订单的数据
	 * @param order
	 */
	private void init(Order order) {
		order.setAddTime(new Date());
    	order.setUserId(SpringSecurityUtils.getLoginUserId());
    	order.setUserName(SpringSecurityUtils.getLoginUserName());
    	
    	order.setOrderNo(generateCodeService.getNextCode(ORDER_CODE_GENERATE));
		order.setStatus(SubmitStatus.UN_SUBMIT.getCode());
		order.setDeliveryStatus(DeliveryStatus.UN_SENT.getCode());
		order.setApprovalStatus(ApprovalStatus.UN_APPROVAL.getCode());
    	
    	for(OrderProduct orderProduct : order.getOrderItems()){
    		
    		if (StringUtils.isBlank(orderProduct.getCompanyId())) {
    			orderProduct.setCompanyId(order.getPurCompanyId());
    		}
    		
    		//不能输入流水号
    		orderProduct.setOrderProductSerialNo(null);
    	}
	}
	
	/**
	 * 校验订单数据是否正常
	 * @param order
	 */
	private void valid(Order order){
    	Assert.isNotEmpty(order.getOrderItems(), "订单行不能为空");
		Assert.isNotBlank(order.getPayType(), "支付方式不能为空");
    	
    	if (StringUtils.isBlank(order.getPurCompanyId())) {
    		if (StringUtils.isBlank(order.getPurCompanyName())) {
    			throw new CommonException("经销商id不能为空");
    		}

			CompanyExample companyExample = new CompanyExample();
			companyExample.createCriteria().andCompanyFullNameEqualTo(order.getPurCompanyName());
			List<Company> companyList = companyService.queryAllObjByExample(companyExample);
			if (CollectionUtils.isEmpty(companyList)) {
				throw new CommonException("系统不存在该经销商");
			}
			
			order.setPurCompanyId(companyList.get(0).getId());
		}
    	
    	for(OrderProduct orderProduct: order.getOrderItems()){
    		if (orderProduct.getProductId() == null || orderProduct.getProductId() <= 0) {
    			throw new CommonException("产品id不能为空");
			}
    		
    		if (orderProduct.getNums() == null || orderProduct.getNums() <= 0) {
    			throw new CommonException("产品数量异常");
    		}
    	}
    	
    }

	@Override
	public Order getOrder() {
		return this.order;
	}

}
