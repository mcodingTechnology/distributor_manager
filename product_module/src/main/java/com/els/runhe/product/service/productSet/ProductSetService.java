package com.els.runhe.product.service.productSet;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.product.entity.productSet.ProductSet;
import com.els.runhe.product.entity.productSet.ProductSetExample;

public interface ProductSetService extends BaseService<ProductSet, ProductSetExample, Integer> {
	
	/**
	 * 查询套餐底下的产品
	 * @param setId
	 * @return
	 */
	public List<ProductSet> queryByProductId(int setId);
}