package com.els.runhe.product.service.productSet.impl;

import com.els.runhe.product.dao.productSet.ProductSetMapper;
import com.els.runhe.product.entity.productSet.ProductSet;
import com.els.runhe.product.entity.productSet.ProductSetExample;
import com.els.runhe.product.service.productSet.ProductSetService;
import com.els.base.core.entity.PageView;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("productSetService")
public class ProductSetServiceImpl implements ProductSetService {
    @Resource
    protected ProductSetMapper productSetMapper;

    @CacheEvict(value={"productSet"}, allEntries=true)
    @Override
    public void addObj(ProductSet t) {
        this.productSetMapper.insertSelective(t);
    }

    @CacheEvict(value={"productSet"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.productSetMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"productSet"}, allEntries=true)
    @Override
    public void modifyObj(ProductSet t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.productSetMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="productSet", keyGenerator="redisKeyGenerator")
    @Override
    public ProductSet queryObjById(Integer id) {
        return this.productSetMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="productSet", keyGenerator="redisKeyGenerator")
    @Override
    public List<ProductSet> queryAllObjByExample(ProductSetExample example) {
        return this.productSetMapper.selectByExample(example);
    }

    @Cacheable(value="productSet", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<ProductSet> queryObjByPage(ProductSetExample example) {
        PageView<ProductSet> pageView = example.getPageView();
        if (pageView == null) {
            pageView = new PageView<>(1, 10);
            example.setPageView(pageView);
        }
        pageView.setQueryResult(this.productSetMapper.selectByExampleByPage(example));
        return pageView;
    }

    @Cacheable(value="productSet", keyGenerator="redisKeyGenerator")
	@Override
	public List<ProductSet> queryByProductId(int setId) {
    	ProductSetExample example = new ProductSetExample();
    	example.createCriteria().andSetIdEqualTo(setId);
    	
		return this.productSetMapper.selectByExample(example);
	}
}