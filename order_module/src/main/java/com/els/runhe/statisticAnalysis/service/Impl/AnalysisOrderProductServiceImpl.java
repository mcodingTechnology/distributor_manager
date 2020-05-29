package com.els.runhe.statisticAnalysis.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.runhe.statisticAnalysis.dao.AnalysisOrderProductMapper;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderProduct;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderProductExample;
import com.els.runhe.statisticAnalysis.service.AnalysisOrderProductService;

@Service("defaultAnalysisOrderProductService")
public class AnalysisOrderProductServiceImpl implements AnalysisOrderProductService {
    @Resource
    protected AnalysisOrderProductMapper analysisOrderProductMapper;

    @CacheEvict(value={"analysisOrderProduct"}, allEntries=true)
    @Override
    public void addObj(AnalysisOrderProduct t) {
        this.analysisOrderProductMapper.insertSelective(t);
    }

    @CacheEvict(value={"analysisOrderProduct"}, allEntries=true)
    @Override
    public void deleteObjById(String id) {
        this.analysisOrderProductMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"analysisOrderProduct"}, allEntries=true)
    @Override
    public void modifyObj(AnalysisOrderProduct t) {
        if (StringUtils.isBlank(t.getId())) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.analysisOrderProductMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="analysisOrderProduct", keyGenerator="redisKeyGenerator")
    @Override
    public AnalysisOrderProduct queryObjById(String id) {
        return this.analysisOrderProductMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="analysisOrderProduct", keyGenerator="redisKeyGenerator")
    @Override
    public List<AnalysisOrderProduct> queryAllObjByExample(AnalysisOrderProductExample example) {
        return this.analysisOrderProductMapper.selectByExample(example);
    }

    @Cacheable(value="analysisOrderProduct", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<AnalysisOrderProduct> queryObjByPage(AnalysisOrderProductExample example) {
        PageView<AnalysisOrderProduct> pageView = example.getPageView();
        pageView.setQueryResult(this.analysisOrderProductMapper.selectByExampleByPage(example));
        return pageView;
    }
}