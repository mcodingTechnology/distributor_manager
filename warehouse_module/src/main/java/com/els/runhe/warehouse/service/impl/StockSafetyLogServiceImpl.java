package com.els.runhe.warehouse.service.impl;

import com.els.base.core.entity.PageView;
import com.els.runhe.warehouse.dao.StockSafetyLogMapper;
import com.els.runhe.warehouse.entity.StockSafetyLog;
import com.els.runhe.warehouse.entity.StockSafetyLogExample;
import com.els.runhe.warehouse.service.StockSafetyLogService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultStockSafetyLogService")
public class StockSafetyLogServiceImpl implements StockSafetyLogService {
    @Resource
    protected StockSafetyLogMapper stockSafetyLogMapper;

    @CacheEvict(value={"stockSafetyLog"}, allEntries=true)
    @Override
    public void addObj(StockSafetyLog t) {
        this.stockSafetyLogMapper.insertSelective(t);
    }

    @CacheEvict(value={"stockSafetyLog"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.stockSafetyLogMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"stockSafetyLog"}, allEntries=true)
    @Override
    public void modifyObj(StockSafetyLog t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.stockSafetyLogMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="stockSafetyLog", keyGenerator="redisKeyGenerator")
    @Override
    public StockSafetyLog queryObjById(String id) {
        return this.stockSafetyLogMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="stockSafetyLog", keyGenerator="redisKeyGenerator")
    @Override
    public List<StockSafetyLog> queryAllObjByExample(StockSafetyLogExample example) {
        return this.stockSafetyLogMapper.selectByExample(example);
    }

    @Cacheable(value="stockSafetyLog", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<StockSafetyLog> queryObjByPage(StockSafetyLogExample example) {
        PageView<StockSafetyLog> pageView = example.getPageView();
        pageView.setQueryResult(this.stockSafetyLogMapper.selectByExampleByPage(example));
        return pageView;
    }
}