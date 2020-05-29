package com.els.runhe.order.ruleengine.command;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.els.base.company.entity.Company;
import com.els.base.company.entity.CompanyExample;
import com.els.base.company.service.CompanyService;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Assert;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.entity.OrderProductExample;
import com.els.runhe.order.ruleengine.OrderRuleEngine;
import com.els.runhe.order.ruleengine.state.OrderStateCheckable;
import com.els.runhe.order.service.OrderProductService;
import com.els.runhe.order.service.OrderService;

/**
 * 修改订单的指令
 * @author hzy
 *
 */
public class ModifyOrderCommand implements OrderStateCheckable {
	
	protected static OrderService orderService = SpringContextHolder.getOneBean(OrderService.class);
	protected static CompanyService companyService = SpringContextHolder.getOneBean(CompanyService.class);
	protected static OrderProductService orderProductService = SpringContextHolder.getOneBean(OrderProductService.class);
	private Order order;

	public ModifyOrderCommand(Order order) {
		this.order = order;
	}

	@Override
	public void execute(OrderRuleEngine context) {
		validOrderBeforeCreate(order);
		
        Integer nums = 0;
        BigDecimal amountTotal = BigDecimal.ZERO;
        
        if (CollectionUtils.isNotEmpty(order.getOrderItems())) {
        	//删除旧有的订单行数据
            OrderProductExample orderProductExample = new OrderProductExample();
            orderProductExample.createCriteria().andOrderIdEqualTo(order.getId());
            orderProductService.deleteObjByExample(orderProductExample);
            
            //重新插入订单行数据
            for(OrderProduct orderProduct: order.getOrderItems()){
        		orderProduct.setOrderId(order.getId());
        		orderProductService.addObj(orderProduct);
        		
        		nums = nums + orderProduct.getNums();
        		amountTotal = amountTotal.add(orderProduct.getAmountTotal());
        	}
		}
        
        if (order.getTax() != null && !order.getTax().equals(BigDecimal.ZERO)) {
			amountTotal = amountTotal.add(amountTotal.multiply(order.getTax()));
		}
        
		order.setNums(nums);
		order.setAmountTotal(amountTotal);
        orderService.modifyObj(order);
	}
	
	private void validOrderBeforeCreate(Order order){
    	Assert.isNotEmpty(order.getOrderItems(), "订单行不能为空");
		Assert.isNotBlank(order.getPayType(), "支付方式不能为空");
		Assert.isNotBlank(order.getId(), "id 为空，无法更新");
    	
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
    		
    		if (StringUtils.isBlank(orderProduct.getCompanyId())) {
    			orderProduct.setCompanyId(order.getPurCompanyId());
    		}
    		
    		orderProduct.setOrderProductSerialNo(null);
    	}
//    	order.settime(new Date());
//    	order.setUserId(SpringSecurityUtils.getLoginUserId());
//    	order.setUserName(SpringSecurityUtils.getLoginUserName());
    }

	@Override
	public Order getOrder() {
		return this.order;
	}

}
