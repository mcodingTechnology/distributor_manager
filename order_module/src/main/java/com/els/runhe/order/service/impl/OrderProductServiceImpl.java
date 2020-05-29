package com.els.runhe.order.service.impl;

import com.els.base.core.entity.PageView;
import com.els.base.core.utils.Assert;
import com.els.runhe.order.dao.OrderProductMapper;
import com.els.runhe.order.entity.OrderProduct;
import com.els.runhe.order.entity.OrderProductExample;
import com.els.runhe.order.service.OrderProductService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultOrderProductService")
public class OrderProductServiceImpl implements OrderProductService {
    @Resource
    protected OrderProductMapper orderProductMapper;

    @CacheEvict(value={"orderProduct"}, allEntries=true)
    @Override
    public void addObj(OrderProduct t) {
        this.orderProductMapper.insertSelective(t);
    }

    @CacheEvict(value={"orderProduct"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.orderProductMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"orderProduct"}, allEntries=true)
    @Override
    public void modifyObj(OrderProduct t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.orderProductMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="orderProduct", keyGenerator="redisKeyGenerator")
    @Override
    public OrderProduct queryObjById(String id) {
        return this.orderProductMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="orderProduct", keyGenerator="redisKeyGenerator")
    @Override
    public List<OrderProduct> queryAllObjByExample(OrderProductExample example) {
        return this.orderProductMapper.selectByExample(example);
    }

    @Cacheable(value="orderProduct", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<OrderProduct> queryObjByPage(OrderProductExample example) {
        PageView<OrderProduct> pageView = example.getPageView();
        pageView.setQueryResult(this.orderProductMapper.selectByExampleByPage(example));
        return pageView;
    }

    @CacheEvict(value={"orderProduct"}, allEntries=true)
    @Override
	public void deleteObjByExample(OrderProductExample orderProductExample) {
		this.orderProductMapper.deleteByExample(orderProductExample);
	}

    @Cacheable(value="orderProduct", keyGenerator="redisKeyGenerator")
	@Override
	public List<OrderProduct> queryByOrderId(String orderId) {
		Assert.isNotBlank(orderId, "orderId不能为空");
		
		OrderProductExample orderProductExample = new OrderProductExample();
		orderProductExample.createCriteria().andOrderIdEqualTo(orderId);
		orderProductExample.setOrderByClause("PRODUCT_CODE ASC");
		
		return this.queryAllObjByExample(orderProductExample);
	}
}