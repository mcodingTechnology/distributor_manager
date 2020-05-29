package com.els.runhe.product.service.product;

import com.els.base.core.service.BaseService;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.product.entity.product.ProductExample;
import com.els.base.core.entity.PageView;

public interface ProductService extends BaseService<Product, ProductExample, Integer> {
	
	/**
	 * 根据查询条件，产品分类，分页查询产品
	 * @param example
	 * @param categoryId
	 * @return
	 */
    public PageView<Product> findConditionByPage(ProductExample example, Integer categoryId);
    
    /**
	 * 根据查询条件，产品分类，场景code，分页查询产品，产品中带有产品价格，产品图片
	 * @param example
	 * @param categoryId
	 * @return
	 */
//    public PageView<Product> findConditionByPage(ProductExample example, Integer categoryId, String scene);
    
    /**
     * 查询产品的所有详情，包括产品的 价格，图片
     * @param scene
     * @param id
     * @return
     */
    public Product queryProductDetailById(String scene, int id);

	/***
	 * 查询简单产品信息，不包括图片
	 * @param scene
	 * @param id
	 * @return
	 * */
	public Product findSingleById(String scene, int id);
    
}