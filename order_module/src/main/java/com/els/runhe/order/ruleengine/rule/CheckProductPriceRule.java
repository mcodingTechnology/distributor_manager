package com.els.runhe.order.ruleengine.rule;

import java.math.BigDecimal;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.els.base.core.exception.CommonException;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.ruleengine.OrderCommand;
import com.els.runhe.order.ruleengine.OrderRule;
import com.els.runhe.order.ruleengine.command.CreateOrderCommand;
import com.els.runhe.order.ruleengine.command.ModifyOrderCommand;
import com.els.runhe.order.ruleengine.state.OrderStateCheckable;
import com.els.runhe.product.entity.productPrice.ProductPrice;
import com.els.runhe.product.service.productPrice.ProductPriceService;

/**
 * 检查订单供货价的订单规则
 * @author hzy
 *
 */
public class CheckProductPriceRule implements OrderRule {
	
	@Override
	public boolean preHandler(OrderCommand orderCommand) {

		OrderStateCheckable checkable = (OrderStateCheckable) orderCommand;
		Order order = checkable.getOrder();
		
		if (CollectionUtils.isEmpty(order.getOrderItems())) {
			throw new CommonException("订单行不能为空");
		}
		
		BigDecimal orderAmountTotal = BigDecimal.ZERO;
		Integer totalNums = 0;
		for(OrderProduct orderProduct: order.getOrderItems()){
    		if (orderProduct.getProductId() == null || orderProduct.getProductId() <= 0) {
    			throw new CommonException("产品id不能为空");
    		}
    		
    		if (orderProduct.getNums() == null || orderProduct.getNums() <= 0) {
    			throw new CommonException("产品数量异常");
    		}
    		if (StringUtils.isBlank(orderProduct.getCompanyId())) {
    			throw new CommonException("要货方的id不能为空");
    		}
    		
    		ProductPriceService productPriceService = SpringContextHolder.getOneBean(ProductPriceService.class);
    		ProductPrice productPrice = productPriceService.queryByProductIdAndNum(orderProduct.getProductId(), orderProduct.getNums(), orderProduct.getCompanyId());
    		if (productPrice == null) {
    	    	throw new CommonException("产品id["+orderProduct.getProductId()+"],还没有设置供货价");
			}
    		
    		//orderProduct.setProductPrice(productPrice.getPrice());
    		orderProduct.setAmountTotal(productPrice.getPrice().multiply(new BigDecimal(orderProduct.getNums())));
    		orderProduct.setCompanyId(productPrice.getCompanyId());
    		orderProduct.setCompanyName(productPrice.getCompanyName());
    		
    		orderAmountTotal = orderAmountTotal.add(orderProduct.getAmountTotal());
    		totalNums = totalNums + orderProduct.getNums();
    	}
		
		order.setAmountTotal(orderAmountTotal);
		order.setNums(totalNums);
		
		return true;
	}

	@Override
	public void afterCompletion(OrderCommand orderCommand) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isMatch(OrderCommand orderCommand) {
		return  orderCommand instanceof CreateOrderCommand 
				|| orderCommand instanceof ModifyOrderCommand;
	}

}
