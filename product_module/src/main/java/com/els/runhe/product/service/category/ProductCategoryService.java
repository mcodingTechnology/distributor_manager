package com.els.runhe.product.service.category;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.product.entity.category.ProductCategory;
import com.els.runhe.product.entity.category.ProductCategoryExample;

public interface ProductCategoryService extends BaseService<ProductCategory, ProductCategoryExample, Integer> {
	
	public List<ProductCategory> queryChildern(int parentId);
}