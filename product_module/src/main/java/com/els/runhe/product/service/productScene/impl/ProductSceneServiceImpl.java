package com.els.runhe.product.service.productScene.impl;

import com.els.runhe.product.dao.productScene.ProductSceneMapper;
import com.els.runhe.product.entity.productScene.ProductScene;
import com.els.runhe.product.entity.productScene.ProductSceneExample;
import com.els.runhe.product.service.productScene.ProductSceneService;
import com.els.base.core.entity.PageView;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("productSceneService")
public class ProductSceneServiceImpl implements ProductSceneService {
    @Resource
    protected ProductSceneMapper productSceneMapper;

    @CacheEvict(value={"productScene"}, allEntries=true)
    @Override
    public void addObj(ProductScene t) {
        this.productSceneMapper.insertSelective(t);
    }

    @CacheEvict(value={"productScene"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.productSceneMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"productScene"}, allEntries=true)
    @Override
    public void modifyObj(ProductScene t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.productSceneMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="productScene", keyGenerator="redisKeyGenerator")
    @Override
    public ProductScene queryObjById(Integer id) {
        return this.productSceneMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="productScene", keyGenerator="redisKeyGenerator")
    @Override
    public List<ProductScene> queryAllObjByExample(ProductSceneExample example) {
        return this.productSceneMapper.selectByExample(example);
    }

    @Cacheable(value="productScene", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<ProductScene> queryObjByPage(ProductSceneExample example) {
        PageView<ProductScene> pageView = example.getPageView();
        if (pageView == null) {
            pageView = new PageView<>(1, 10);
            example.setPageView(pageView);
        }
        pageView.setQueryResult(this.productSceneMapper.selectByExampleByPage(example));
        return pageView;
    }
}