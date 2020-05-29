package com.els.runhe.statisticAnalysis.service.Impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.runhe.statisticAnalysis.dao.AnalysisFinanceLogMapper;
import com.els.runhe.statisticAnalysis.entity.AnalysisFinanceLog;
import com.els.runhe.statisticAnalysis.entity.AnalysisFinanceLogExample;
import com.els.runhe.statisticAnalysis.service.AnalysisFinanceLogService;

@Service("defaultAnalysisFinanceLogService")
public class AnalysisFinanceLogServiceImpl implements AnalysisFinanceLogService {
    @Resource
    protected AnalysisFinanceLogMapper analysisFinanceLogMapper;

    @CacheEvict(value={"analysisFinanceLog"}, allEntries=true)   
    @Override
    public void addObj(AnalysisFinanceLog t) {
    	t.setLastUpdateTime(new Date());
    	t.setCreateTime(new Date());
        this.analysisFinanceLogMapper.insertSelective(t);
    }

    @CacheEvict(value={"analysisFinanceLog"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.analysisFinanceLogMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"analysisFinanceLog"}, allEntries=true)
    @Override
    public void modifyObj(AnalysisFinanceLog t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.analysisFinanceLogMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="analysisFinanceLog", keyGenerator="redisKeyGenerator")
    @Override
    public AnalysisFinanceLog queryObjById(Integer id) {
        return this.analysisFinanceLogMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="analysisFinanceLog", keyGenerator="redisKeyGenerator")
    @Override
    public List<AnalysisFinanceLog> queryAllObjByExample(AnalysisFinanceLogExample example) {
        return this.analysisFinanceLogMapper.selectByExample(example);
    }

    @Cacheable(value="analysisFinanceLog", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<AnalysisFinanceLog> queryObjByPage(AnalysisFinanceLogExample example) {
        PageView<AnalysisFinanceLog> pageView = example.getPageView();
        pageView.setQueryResult(this.analysisFinanceLogMapper.selectByExampleByPage(example));
        return pageView;
    }
}