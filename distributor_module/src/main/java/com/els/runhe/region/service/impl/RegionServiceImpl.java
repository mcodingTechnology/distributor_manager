package com.els.runhe.region.service.impl;

import com.els.base.core.entity.PageView;
import com.els.runhe.region.dao.RegionMapper;
import com.els.runhe.region.entity.Region;
import com.els.runhe.region.entity.RegionExample;
import com.els.runhe.region.service.RegionService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("defaultRegionService")
public class RegionServiceImpl implements RegionService {
    @Resource
    protected RegionMapper regionMapper;

    @CacheEvict(value={"region"}, allEntries=true)
    @Override
    public void addObj(Region t) {
        this.regionMapper.insertSelective(t);
    }

    @CacheEvict(value={"region"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.regionMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"region"}, allEntries=true)
    @Override
    public void modifyObj(Region t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.regionMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="region", keyGenerator="redisKeyGenerator")
    @Override
    public Region queryObjById(Integer id) {
        return this.regionMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="region", keyGenerator="redisKeyGenerator")
    @Override
    public List<Region> queryAllObjByExample(RegionExample example) {
        return this.regionMapper.selectByExample(example);
    }

    @Cacheable(value="region", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<Region> queryObjByPage(RegionExample example) {
        PageView<Region> pageView = example.getPageView();
        pageView.setQueryResult(this.regionMapper.selectByExampleByPage(example));
        return pageView;
    }
}