package com.els.runhe.product.service.product.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Assert;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.product.dao.product.ProductMapper;
import com.els.runhe.product.entity.category.ProductCategory;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.product.entity.product.ProductExample;
import com.els.runhe.product.entity.product.ProductImgExample;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRef;
import com.els.runhe.product.entity.productCategoryRef.ProductCategoryRefExample;
import com.els.runhe.product.entity.productPoint.ProductPointExample;
import com.els.runhe.product.entity.productPrice.ProductPriceExample;
import com.els.runhe.product.service.category.ProductCategoryService;
import com.els.runhe.product.service.product.ProductImgService;
import com.els.runhe.product.service.product.ProductService;
import com.els.runhe.product.service.productCategoryRef.ProductCategoryRefService;
import com.els.runhe.product.service.productPoint.ProductPointService;
import com.els.runhe.product.service.productPrice.ProductPriceService;
import com.els.runhe.product.service.productSet.ProductSetService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    protected ProductMapper productMapper;
    @Autowired
    protected ProductPriceService productPriceService;
    
    @Autowired
    protected ProductImgService productImgService;
    
    @Autowired
    protected ProductSetService productSetService;

    @Autowired
    protected ProductPointService productPointService;
    
    @Resource
    protected ProductCategoryRefService productCategoryRefService;
    
    @Resource
    protected ProductCategoryService productCategoryService;

    @CacheEvict(value={"product"}, allEntries=true)
    @Override
    public void addObj(Product t) {
    	Assert.isNotBlank(t.getProductName(), "产品名称");
    	Assert.isNotBlank(t.getBarCode(), "产品条形码");
    	Assert.isNotNull(t.getOriginPrice(), "产品零售价");
    	
    	t.setNumberCode(t.getBarCode());
    	
    	ProductExample example = new ProductExample();
    	example.createCriteria().andBarCodeEqualTo(t.getBarCode());
    	
    	if (this.productMapper.countByExample(example) > 0) {
			throw new CommonException("条形码已存在，不能重复");
		}
    	
        this.productMapper.insertSelective(t);
        
        if (t.getCategoryId() != null) {
        	ProductCategory category = this.productCategoryService.queryObjById(t.getCategoryId());
    		ProductCategoryRef ref = new ProductCategoryRef();
    		ref.setProductId(t.getId());
    		ref.setCategoryId(t.getCategoryId());
    		ref.setCategoryName(category.getCategoryName());
    		productCategoryRefService.addObj(ref);
		}
        
        for(int i=0; CollectionUtils.isNotEmpty(t.getImgList()) && i<t.getImgList().size(); i++){
        	t.getImgList().get(i).setProductId(t.getId());
        	t.getImgList().get(i).setCreateTime(new Date());
        	this.productImgService.addObj(t.getImgList().get(i));
        	
        }
    }

    @CacheEvict(value={"product"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {

        this.productMapper.deleteByPrimaryKey(id);
        
//        ProductPriceExample priceExample = new ProductPriceExample();
//        ProductPriceExample.Criteria criteria = priceExample.createCriteria();
//        criteria.andProductIdEqualTo(id);
//        this.productPriceService.deleteByExample(priceExample);
//
//        ProductImgExample imgExample = new ProductImgExample();
//        ProductImgExample.Criteria criteria1 = imgExample.createCriteria();
//        criteria1.andProductIdEqualTo(id);
//        this.productImgService.deleteByExample(imgExample);
//
//        ProductPointExample pointExample = new ProductPointExample();
//        ProductPointExample.Criteria criteria3 = pointExample.createCriteria();
//        criteria3.andProductIdEqualTo(id);
//        this.productPointService.deleteByExample(pointExample);
//        
//        ProductCategoryRefExample categoryRefExample = new ProductCategoryRefExample();
//        categoryRefExample.createCriteria().andProductIdEqualTo(id);
//        this.productCategoryRefService.deleteByExample(categoryRefExample);
    }

    @CacheEvict(value={"product"}, allEntries=true)
    @Override
    public void modifyObj(Product t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        
        ProductExample example = new ProductExample();
    	example.createCriteria()
    	       .andBarCodeEqualTo(t.getBarCode())
    	       .andIdNotEqualTo(t.getId());
    	
    	if (this.productMapper.countByExample(example) > 0) {
			throw new CommonException("条形码已存在，不能重复");
		}
        
    	t.setUpdateTime(new Date());
        this.productMapper.updateByPrimaryKeySelective(t);
        
        if (t.getCategoryId() != null) {
        	ProductCategoryRefExample categoryRefExample = new ProductCategoryRefExample();
            categoryRefExample.createCriteria().andProductIdEqualTo(t.getId());
            this.productCategoryRefService.deleteByExample(categoryRefExample);
        	
        	ProductCategory category = this.productCategoryService.queryObjById(t.getCategoryId());
    		ProductCategoryRef ref = new ProductCategoryRef();
    		ref.setProductId(t.getId());
    		ref.setCategoryId(t.getCategoryId());
    		ref.setCategoryName(category.getCategoryName());
    		productCategoryRefService.addObj(ref);
		}
        
        for(int i=0; CollectionUtils.isNotEmpty(t.getImgList()) && i<t.getImgList().size(); i++){
        	ProductImgExample imgExample = new ProductImgExample();
            ProductImgExample.Criteria criteria1 = imgExample.createCriteria();
            criteria1.andProductIdEqualTo(t.getId());
            this.productImgService.deleteByExample(imgExample);
        	
        	t.getImgList().get(i).setProductId(t.getId());
        	t.getImgList().get(i).setCreateTime(new Date());
        	this.productImgService.addObj(t.getImgList().get(i));
        	
        }
    }

    @Cacheable(value="product", keyGenerator="redisKeyGenerator")
    @Override
    public Product queryObjById(Integer id) {
        Product product = this.productMapper.selectByPrimaryKey(id);
        this.setCategoryForProduct(product);
        return product;
    }

    @Cacheable(value="product", keyGenerator="redisKeyGenerator")
    @Override
    public List<Product> queryAllObjByExample(ProductExample example) {
        List<Product> list = this.productMapper.selectByExampleWithBLOBs(example);
        for(int i=0; CollectionUtils.isNotEmpty(list) && i<list.size(); i++){
        	this.setCategoryForProduct(list.get(i));
        }
        
        return list;
    }

    @Cacheable(value="product", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<Product> queryObjByPage(ProductExample example) {
        PageView<Product> pageView = example.getPageView();
        if (pageView == null) {
            pageView = new PageView<>(1, 10);
            example.setPageView(pageView);
        }
        
        List<Product> list = this.productMapper.selectByExampleByPage(example);
        for(int i=0; CollectionUtils.isNotEmpty(list) && i<list.size(); i++){
        	this.setCategoryForProduct(list.get(i));
        }
        pageView.setQueryResult(list);
        return pageView;
    }

    @Cacheable(value="product", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<Product> findConditionByPage(ProductExample example,Integer categoryId) {
    	if (categoryId==null || categoryId <= 0) {
			return this.queryObjByPage(example);
		}
    	
    	PageView<Product> pageView = example.getPageView();
        if (pageView == null) {
            pageView = new PageView<>(1, 10);
            example.setPageView(pageView);
        }
        
        List<Product> list = this.productMapper.findConditionByPage(example, categoryId);
        for(int i=0; CollectionUtils.isNotEmpty(list) && i<list.size(); i++){
        	this.setCategoryForProduct(list.get(i));
        }
        pageView.setQueryResult(list);
        
    	return pageView;
    }
    
    @Override
    public Product queryProductDetailById(String sceneCode, int id) {
    	Product product = SpringContextHolder.getOneBean(ProductService.class).queryObjById(id);
        product.setImgList(this.productImgService.queryByProductId(product.getId()));
//    	this.setDataInProduct(product, sceneCode);
    	return product;
    }

    @Override
    public Product findSingleById(String sceneCode, int id) {
        Product product = SpringContextHolder.getOneBean(ProductService.class).queryObjById(id);
        return product;
    }
    
    private void setCategoryForProduct(Product product){
    	if (product == null || product.getId() == null) {
			return;
		}
    	
    	ProductCategoryRefExample example = new ProductCategoryRefExample();
    	example.createCriteria().andProductIdEqualTo(product.getId());
    	List<ProductCategoryRef> list = this.productCategoryRefService.queryAllObjByExample(example);
    	
    	if (CollectionUtils.isNotEmpty(list)) {
    		product.setCategoryId(list.get(0).getCategoryId());
    		product.setCategoryName(list.get(0).getCategoryName());
		}
    	
    	ProductImgExample imgExample = new ProductImgExample();
    	imgExample.createCriteria().andProductIdEqualTo(product.getId());
    	product.setImgList(this.productImgService.queryAllObjByExample(imgExample));
    	
    }

}