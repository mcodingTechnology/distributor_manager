package com.els.runhe.product.service.productPrice;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.product.entity.productPrice.ProductPrice;
import com.els.runhe.product.entity.productPrice.ProductPriceExample;

public interface ProductPriceService extends BaseService<ProductPrice, ProductPriceExample, Integer> {

	/**
	 * 根据供货价规则查询产品的供货价
	 * @param productId
	 * @param num
	 * @param companyId
	 * @return
	 */
	ProductPrice queryByProductIdAndNum(int productId, int num, String companyId);

	void importData(List<ProductPrice> list);

	/**
	 * 根据条件批量删除
	 * @param priceExample
	 */
	void deleteByExample(ProductPriceExample priceExample);
	
	/**
	 * 根据供货价规则查询产品的最低供货价
	 * @param productId
	 * @param companyId
	 * @return
	 */
	ProductPrice queryLowestPrice(int productId, String companyId);
}