package com.els.runhe.product.service.category.impl;

import com.els.runhe.product.dao.category.ProductCategoryMapper;
import com.els.runhe.product.entity.category.ProductCategory;
import com.els.runhe.product.entity.category.ProductCategoryExample;
import com.els.runhe.product.service.category.ProductCategoryService;
import com.els.base.core.entity.PageView;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    protected ProductCategoryMapper productCategoryMapper;

    @CacheEvict(value={"productCategory"}, allEntries=true)
    @Override
    public void addObj(ProductCategory t) {
        this.productCategoryMapper.insertSelective(t);
    }

    @CacheEvict(value={"productCategory"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.productCategoryMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"productCategory"}, allEntries=true)
    @Override
    public void modifyObj(ProductCategory t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.productCategoryMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="productCategory", keyGenerator="redisKeyGenerator")
    @Override
    public ProductCategory queryObjById(Integer id) {
        return this.productCategoryMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="productCategory", keyGenerator="redisKeyGenerator")
    @Override
    public List<ProductCategory> queryAllObjByExample(ProductCategoryExample example) {
        return this.productCategoryMapper.selectByExample(example);
    }

    @Cacheable(value="productCategory", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<ProductCategory> queryObjByPage(ProductCategoryExample example) {
        PageView<ProductCategory> pageView = example.getPageView();
        if (pageView == null) {
            pageView = new PageView<>(1, 10);
            example.setPageView(pageView);
        }
        pageView.setQueryResult(this.productCategoryMapper.selectByExampleByPage(example));
        return pageView;
    }
    
    @Cacheable(value="productCategory", keyGenerator="redisKeyGenerator")
	@Override
	public List<ProductCategory> queryChildern(int parentId) {
		ProductCategoryExample example = new ProductCategoryExample();
		example.createCriteria().andCategoryParentIdEqualTo(parentId);
		
		return this.queryAllObjByExample(example);
	}
}