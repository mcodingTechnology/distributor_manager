package com.els.runhe.product.service.product;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.product.entity.product.ProductImg;
import com.els.runhe.product.entity.product.ProductImgExample;

public interface ProductImgService extends BaseService<ProductImg, ProductImgExample, Integer> {

	/**
	 * 根据产品id查询出产品的图片
	 * @param id
	 * @return
	 */
	public List<ProductImg> queryByProductId(int id);

	public void deleteObjByExample(ProductImgExample example);

	public void deleteByExample(ProductImgExample imgExample);
}