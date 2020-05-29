package com.els.runhe.order.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.runhe.order.dao.OrderMapper;
import com.els.runhe.order.entity.Order;
import com.els.runhe.order.entity.OrderExample;
import com.els.runhe.order.entity.OrderProductExample;
import com.els.runhe.order.service.OrderProductService;
import com.els.runhe.order.service.OrderService;

@Service("defaultOrderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    protected OrderMapper orderMapper;
    
    @Resource
    protected OrderProductService orderProductServiceImpl;

    @Transactional
    @CacheEvict(value={"order"}, allEntries=true)
    @Override
    public void addObj(Order t) {
    	if (CollectionUtils.isEmpty(t.getOrderItems())) {
			throw new CommonException("订单行不能为空");
		}
    	
    	this.orderMapper.insertSelective(t);
    }

    @Transactional
    @CacheEvict(value={"order"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.orderMapper.deleteByPrimaryKey(id);
        OrderProductExample orderProductExample = new OrderProductExample();
        orderProductExample.createCriteria().andOrderIdEqualTo(id);
        
        this.orderProductServiceImpl.deleteObjByExample(orderProductExample);
    }

    @Transactional
    @CacheEvict(value={"order"}, allEntries=true)
    @Override
    public void modifyObj(Order t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.orderMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="order", keyGenerator="redisKeyGenerator")
    @Override
    public Order queryObjById(String id) {
        Order order = this.orderMapper.selectByPrimaryKey(id);
        return order;
    }

    @Cacheable(value="order", keyGenerator="redisKeyGenerator")
    @Override
    public List<Order> queryAllObjByExample(OrderExample example) {
        List<Order> list = this.orderMapper.selectByExample(example);
        return list;
    }

    @Cacheable(value="order", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<Order> queryObjByPage(OrderExample example) {
        PageView<Order> pageView = example.getPageView();
        List<Order> list = this.orderMapper.selectByExampleByPage(example);
        pageView.setQueryResult(list);
        return pageView;
    }

    @CacheEvict(value={"order"}, allEntries=true)
	@Override
	public void modifyObjByExample(Order record, OrderExample orderExample) {
		this.orderMapper.updateByExampleSelective(record, orderExample);
	}
}