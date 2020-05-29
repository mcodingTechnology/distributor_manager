package com.els.runhe.product.service.productCategoryRef;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRef;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRefExample;

public interface ProductCategoryRefService extends BaseService<ProductCategoryRef, ProductCategoryRefExample, Integer> {

	void deleteByExample(ProductCategoryRefExample categoryRefExample);
	
	List<ProductCategoryRef> queryProductCategory(Integer id);
}