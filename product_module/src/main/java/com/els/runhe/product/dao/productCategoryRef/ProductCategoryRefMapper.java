package com.els.runhe.product.dao.productCategoryRef;

import java.util.List;

import com.els.base.core.dao.IMapper;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRef;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRefExample;

public interface ProductCategoryRefMapper extends IMapper<ProductCategoryRef, ProductCategoryRefExample> {
	
	List<ProductCategoryRef> queryProductCategory(Integer id);
}