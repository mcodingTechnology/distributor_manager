package com.els.runhe.market.service.design.impl;

import com.els.base.core.entity.PageView;
import com.els.runhe.market.dao.design.MarketDesignedMapper;
import com.els.runhe.market.entity.design.MarketDesigned;
import com.els.runhe.market.entity.design.MarketDesignedExample;
import com.els.runhe.market.service.design.MarketDesignedService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultMarketDesignedService")
public class MarketDesignedServiceImpl implements MarketDesignedService {
    @Resource
    protected MarketDesignedMapper marketDesignedMapper;

    @CacheEvict(value={"marketDesigned"}, allEntries=true)
    @Override
    public void addObj(MarketDesigned t) {
        this.marketDesignedMapper.insertSelective(t);
    }

    @CacheEvict(value={"marketDesigned"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.marketDesignedMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"marketDesigned"}, allEntries=true)
    @Override
    public void modifyObj(MarketDesigned t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.marketDesignedMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="marketDesigned", keyGenerator="redisKeyGenerator")
    @Override
    public MarketDesigned queryObjById(Integer id) {
        return this.marketDesignedMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="marketDesigned", keyGenerator="redisKeyGenerator")
    @Override
    public List<MarketDesigned> queryAllObjByExample(MarketDesignedExample example) {
        return this.marketDesignedMapper.selectByExample(example);
    }

    @Cacheable(value="marketDesigned", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<MarketDesigned> queryObjByPage(MarketDesignedExample example) {
        PageView<MarketDesigned> pageView = example.getPageView();
        pageView.setQueryResult(this.marketDesignedMapper.selectByExampleByPage(example));
        return pageView;
    }
}