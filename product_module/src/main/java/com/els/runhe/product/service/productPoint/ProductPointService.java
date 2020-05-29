package com.els.runhe.product.service.productPoint;

import com.els.base.core.service.BaseService;
import com.els.runhe.product.entity.productPoint.ProductPoint;
import com.els.runhe.product.entity.productPoint.ProductPointExample;

public interface ProductPointService extends BaseService<ProductPoint, ProductPointExample, Integer> {
	
	public ProductPoint queryByProductId(int productId);

	public void deleteByExample(ProductPointExample pointExample);
}