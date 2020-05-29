package com.els.runhe.product.service.productCategoryRef.impl;

import com.els.runhe.product.dao.productCategoryRef.ProductCategoryRefMapper;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRef;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRefExample;
import com.els.runhe.product.service.productCategoryRef.ProductCategoryRefService;
import com.els.base.core.entity.PageView;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("productCategoryRefService")
public class ProductCategoryRefServiceImpl implements ProductCategoryRefService {
    @Resource
    protected ProductCategoryRefMapper productCategoryRefMapper;

    @CacheEvict(value={"productCategoryRef"}, allEntries=true)
    @Override
    public void addObj(ProductCategoryRef t) {
        this.productCategoryRefMapper.insertSelective(t);
    }

    @CacheEvict(value={"productCategoryRef"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.productCategoryRefMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"productCategoryRef"}, allEntries=true)
    @Override
    public void modifyObj(ProductCategoryRef t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.productCategoryRefMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="productCategoryRef", keyGenerator="redisKeyGenerator")
    @Override
    public ProductCategoryRef queryObjById(Integer id) {
        return this.productCategoryRefMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="productCategoryRef", keyGenerator="redisKeyGenerator")
    @Override
    public List<ProductCategoryRef> queryAllObjByExample(ProductCategoryRefExample example) {
        return this.productCategoryRefMapper.selectByExample(example);
    }

    @Cacheable(value="productCategoryRef", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<ProductCategoryRef> queryObjByPage(ProductCategoryRefExample example) {
        PageView<ProductCategoryRef> pageView = example.getPageView();
        if (pageView == null) {
            pageView = new PageView<>(1, 10);
            example.setPageView(pageView);
        }
        pageView.setQueryResult(this.productCategoryRefMapper.selectByExampleByPage(example));
        return pageView;
    }

    @CacheEvict(value={"productCategoryRef"}, allEntries=true)
	@Override
	public void deleteByExample(ProductCategoryRefExample categoryRefExample) {
		this.productCategoryRefMapper.deleteByExample(categoryRefExample);
	}
    
    @Cacheable(value="productCategoryRef", keyGenerator="redisKeyGenerator")
    @Override
    public List<ProductCategoryRef> queryProductCategory(Integer id) {
    	if (id == null || id ==0) {
            throw new NullPointerException("类别id 不能为空");
        }
        return productCategoryRefMapper.queryProductCategory(id);
    }
}