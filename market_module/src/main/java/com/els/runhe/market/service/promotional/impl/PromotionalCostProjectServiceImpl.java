package com.els.runhe.market.service.promotional.impl;

import com.els.base.core.entity.PageView;
import com.els.runhe.market.dao.promotional.PromotionalCostProjectMapper;
import com.els.runhe.market.entity.promotional.PromotionalCostProject;
import com.els.runhe.market.entity.promotional.PromotionalCostProjectExample;
import com.els.runhe.market.service.promotional.PromotionalCostProjectService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultPromotionalCostProjectService")
public class PromotionalCostProjectServiceImpl implements PromotionalCostProjectService {
    @Resource
    protected PromotionalCostProjectMapper promotionalCostProjectMapper;

    @CacheEvict(value={"promotionalCostProject"}, allEntries=true)
    @Override
    public void addObj(PromotionalCostProject t) {
        this.promotionalCostProjectMapper.insertSelective(t);
    }

    @CacheEvict(value={"promotionalCostProject"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.promotionalCostProjectMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"promotionalCostProject"}, allEntries=true)
    @Override
    public void modifyObj(PromotionalCostProject t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.promotionalCostProjectMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="promotionalCostProject", keyGenerator="redisKeyGenerator")
    @Override
    public PromotionalCostProject queryObjById(Integer id) {
        return this.promotionalCostProjectMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="promotionalCostProject", keyGenerator="redisKeyGenerator")
    @Override
    public List<PromotionalCostProject> queryAllObjByExample(PromotionalCostProjectExample example) {
        return this.promotionalCostProjectMapper.selectByExample(example);
    }

    @Cacheable(value="promotionalCostProject", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<PromotionalCostProject> queryObjByPage(PromotionalCostProjectExample example) {
        PageView<PromotionalCostProject> pageView = example.getPageView();
        pageView.setQueryResult(this.promotionalCostProjectMapper.selectByExampleByPage(example));
        return pageView;
    }
}