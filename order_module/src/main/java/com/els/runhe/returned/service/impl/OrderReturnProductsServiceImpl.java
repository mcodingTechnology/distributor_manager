package com.els.runhe.returned.service.impl;

import com.els.base.core.entity.PageView;
import com.els.runhe.returned.dao.OrderReturnProductsMapper;
import com.els.runhe.returned.entity.OrderReturnProducts;
import com.els.runhe.returned.entity.OrderReturnProductsExample;
import com.els.runhe.returned.service.OrderReturnProductsService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultOrderReturnProductsService")
public class OrderReturnProductsServiceImpl implements OrderReturnProductsService {
    @Resource
    protected OrderReturnProductsMapper orderReturnProductsMapper;

    @CacheEvict(value={"orderReturnProducts"}, allEntries=true)
    @Override
    public void addObj(OrderReturnProducts t) {
        this.orderReturnProductsMapper.insertSelective(t);
    }

    @CacheEvict(value={"orderReturnProducts"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.orderReturnProductsMapper.deleteByPrimaryKey(id);
    }
    
    @CacheEvict(value={"orderReturnProducts"}, allEntries=true)
    @Override
    public void deleteObjByOrderReturnNo(String orderReturnNo) {
        this.orderReturnProductsMapper.deleteObjByOrderReturnNo(orderReturnNo);
    }
    
    @CacheEvict(value={"orderReturnProducts"}, allEntries=true)
    @Override
    public void modifyObj(OrderReturnProducts t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.orderReturnProductsMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="orderReturnProducts", keyGenerator="redisKeyGenerator")
    @Override
    public OrderReturnProducts queryObjById(Integer id) {
        return this.orderReturnProductsMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="orderReturnProducts", keyGenerator="redisKeyGenerator")
    @Override
    public List<OrderReturnProducts> queryAllObjByExample(OrderReturnProductsExample example) {
        return this.orderReturnProductsMapper.selectByExample(example);
    }

    @Cacheable(value="orderReturnProducts", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<OrderReturnProducts> queryObjByPage(OrderReturnProductsExample example) {
        PageView<OrderReturnProducts> pageView = example.getPageView();
        pageView.setQueryResult(this.orderReturnProductsMapper.selectByExampleByPage(example));
        return pageView;
    }
}