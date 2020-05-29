 package com.els.runhe.product.service.productPrice.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.base.company.entity.Company;
import com.els.base.company.entity.CompanyExample;
import com.els.base.company.service.CompanyService;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Assert;
import com.els.runhe.product.dao.productPrice.ProductPriceMapper;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.product.entity.product.ProductExample;
import com.els.runhe.product.entity.productPrice.ProductPrice;
import com.els.runhe.product.entity.productPrice.ProductPriceExample;
import com.els.runhe.product.service.product.ProductService;
import com.els.runhe.product.service.productPrice.ProductPriceService;

@Service("defaultProductPriceService")
public class ProductPriceServiceImpl implements ProductPriceService {
    @Resource
    protected ProductPriceMapper productPriceMapper;
    
    @Resource
    protected ProductService productService;

    @Resource
    protected CompanyService companyService;
    
    
    @CacheEvict(value={"productPrice"}, allEntries=true)
    @Override
    public void addObj(ProductPrice t) {
        this.productPriceMapper.insertSelective(t);
    }

    @CacheEvict(value={"productPrice"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.productPriceMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"productPrice"}, allEntries=true)
    @Override
    public void modifyObj(ProductPrice t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.productPriceMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="productPrice", keyGenerator="redisKeyGenerator")
    @Override
    public ProductPrice queryObjById(Integer id) {
        return this.productPriceMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="productPrice", keyGenerator="redisKeyGenerator")
    @Override
    public List<ProductPrice> queryAllObjByExample(ProductPriceExample example) {
        return this.productPriceMapper.selectByExample(example);
    }

    @Cacheable(value="productPrice", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<ProductPrice> queryObjByPage(ProductPriceExample example) {
        PageView<ProductPrice> pageView = example.getPageView();
        pageView.setQueryResult(this.productPriceMapper.selectByExampleByPage(example));
        return pageView;
    }

    @Cacheable(value="productPrice", keyGenerator="redisKeyGenerator")
	@Override
	public ProductPrice queryByProductIdAndNum(int productId, int num, String companyId) {
    	if (productId <=0 || num <0 || StringUtils.isBlank(companyId)) {
			throw new IllegalArgumentException("参数异常无法查询供货价");
		}
    	
    	ProductPriceExample priceExample = new ProductPriceExample();
    	priceExample.createCriteria()
    	            .andCompanyIdEqualTo(companyId)
    	            .andProductIdEqualTo(productId)
    	            .andNumFromLessThanOrEqualTo(num)
    	            .andNumToGreaterThanOrEqualTo(num);
    	
    	priceExample.setOrderByClause("priority DESC");
    	List<ProductPrice> list = this.productPriceMapper.selectByExample(priceExample);
    	
    	if (CollectionUtils.isNotEmpty(list)) {
			return list.get(0);
		}
    	
    	priceExample.clear();
    	priceExample.createCriteria()
    	            .andCompanyIdEqualTo(companyId)
                    .andProductIdEqualTo(productId);
    	
    	priceExample.setOrderByClause("priority DESC, num_from ASC");
        list = this.productPriceMapper.selectByExample(priceExample);
    	
    	if (CollectionUtils.isEmpty(list)) {
    		return null;
		}
    	
    	
    	
    	Date now = new Date();
    	List<ProductPrice> removeList = new ArrayList<>();
     	for (ProductPrice price: list) {
     		
     		if (price.getNumFrom()!= null && price.getNumFrom() > num) {
     			//小于最低价
     			removeList.add(price);
				continue;
			}
     		
     		if (price.getNumTo() != null && price.getNumTo() < num) {
     			//大于最高价
     			removeList.add(price);
				continue;
			}
     		
			if (price.getValidDate() != null && price.getValidDate().getTime() > now.getTime()) {
				//没到有效期
				removeList.add(price);
				continue;
			}
			
			if (price.getExpiredDate() != null && price.getExpiredDate().getTime() < now.getTime()) {
				//超过过期时间
				removeList.add(price);
				continue;
			}
		} 
     	
     	list.removeAll(removeList);
     	if (CollectionUtils.isEmpty(list)) {
    		return null;
		}
     	
    	return list.get(0);
    	
	}

    @CacheEvict(value={"productPrice"}, allEntries=true)
    @Transactional
	@Override
	public void importData(List<ProductPrice> list) {
    	if (CollectionUtils.isEmpty(list)) {
			return;
		}
    	
    	for(ProductPrice price: list){
    		Assert.isNotBlank(price.getProductBarCode(), "产品条形码");
    		Assert.isNotBlank(price.getNumberCode(), "产品编码");
    		Assert.isNotBlank(price.getProductName(), "产品名称");
    		Assert.isNotBlank(price.getCompanyCode(), "经销商编码");
    		Assert.isNotNull(price.getPrice(), "产品定价");
    		Assert.isNotNull(price.getValidDate(), "开始日期");
    		
    		Company company = this.getCompanyByCode(price.getCompanyCode());
    		price.setCompanyId(company.getId());
    		price.setCompanyName(company.getCompanyFullName());
    		
    		Product product = this.getProductByCode(price.getProductBarCode());
    		price.setProductId(product.getId());
    		price.setProductName(product.getProductName());
    		
    		ProductPriceExample priceExample = new ProductPriceExample();
    		ProductPriceExample.Criteria cri = priceExample.createCriteria();
    		cri.andCompanyIdEqualTo(price.getCompanyId()).andProductIdEqualTo(price.getProductId());
    		
    		if (this.productPriceMapper.countByExample(priceExample) >0) {
				this.productPriceMapper.deleteByExample(priceExample);
			}
    	}
    	
    	for(ProductPrice price: list){
    		this.productPriceMapper.insertSelective(price);
    	}
	}
    
    private Product getProductByCode(String code){
    	ProductExample example = new ProductExample();
    	example.createCriteria().andBarCodeEqualTo(code);
    	List<Product> list = this.productService.queryAllObjByExample(example);
    	if (CollectionUtils.isEmpty(list)) {
    		throw new CommonException("系统不存在条形码为["+code+"]的产品");
		}
    	
    	return list.get(0);
    }
    
    private Company getCompanyByCode(String companyCode){
    	CompanyExample example = new CompanyExample();
    	example.createCriteria().andCompanyCodeEqualTo(companyCode);
    	List<Company> list = this.companyService.queryAllObjByExample(example);
    	
    	if (CollectionUtils.isEmpty(list)) {
    		throw new CommonException("系统不存在编码为["+companyCode+"]的经销商");
		}
    	
    	return list.get(0);
    }

    @CacheEvict(value={"productPrice"}, allEntries=true)
	@Override
	public void deleteByExample(ProductPriceExample priceExample) {
		this.productPriceMapper.deleteByExample(priceExample);
	}

    @Cacheable(value="productPrice", keyGenerator="redisKeyGenerator")
	@Override
	public ProductPrice queryLowestPrice(int productId, String companyId) {
		if (productId <=0 || StringUtils.isBlank(companyId)) {
			throw new IllegalArgumentException("参数异常无法查询供货价");
		}
    	
    	ProductPriceExample priceExample = new ProductPriceExample();
    	priceExample.createCriteria()
    	            .andCompanyIdEqualTo(companyId)
    	            .andProductIdEqualTo(productId);
    	
    	priceExample.setOrderByClause("NUM_FROM ASC");
    	
//    	priceExample.setPageView(new PageView<ProductPrice>(1, 1));
    	List<ProductPrice> list = this.productPriceMapper.selectByExample(priceExample);
    	if(CollectionUtils.isEmpty(list)){
    		return null;
    	}
		return list.get(0);
	}
}