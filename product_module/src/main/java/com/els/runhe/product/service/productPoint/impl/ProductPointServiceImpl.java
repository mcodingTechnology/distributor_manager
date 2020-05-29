package com.els.runhe.product.service.productPoint.impl;

import com.els.runhe.product.dao.productPoint.ProductPointMapper;
import com.els.runhe.product.entity.productPoint.ProductPoint;
import com.els.runhe.product.entity.productPoint.ProductPointExample;
import com.els.runhe.product.service.productPoint.ProductPointService;
import com.els.base.core.entity.PageView;

import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("productPointService")
public class ProductPointServiceImpl implements ProductPointService {
    @Resource
    protected ProductPointMapper productPointMapper;

    @CacheEvict(value={"productPoint"}, allEntries=true)
    @Override
    public void addObj(ProductPoint t) {
        this.productPointMapper.insertSelective(t);
    }

    @CacheEvict(value={"productPoint"}, allEntries=true)
    @Override
    public void deleteObjById(Integer id) {
        this.productPointMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value={"productPoint"}, allEntries=true)
    @Override
    public void modifyObj(ProductPoint t) {
        if (t.getId() == null || t.getId() ==0) {
            throw new NullPointerException("id 为空，无法更新");
        }
        this.productPointMapper.updateByPrimaryKeySelective(t);
    }

    @Cacheable(value="productPoint", keyGenerator="redisKeyGenerator")
    @Override
    public ProductPoint queryObjById(Integer id) {
        return this.productPointMapper.selectByPrimaryKey(id);
    }

    @Cacheable(value="productPoint", keyGenerator="redisKeyGenerator")
    @Override
    public List<ProductPoint> queryAllObjByExample(ProductPointExample example) {
        return this.productPointMapper.selectByExample(example);
    }

    @Cacheable(value="productPoint", keyGenerator="redisKeyGenerator")
    @Override
    public PageView<ProductPoint> queryObjByPage(ProductPointExample example) {
        PageView<ProductPoint> pageView = example.getPageView();
        if (pageView == null) {
            pageView = new PageView<>(1, 10);
            example.setPageView(pageView);
        }
        pageView.setQueryResult(this.productPointMapper.selectByExampleByPage(example));
        return pageView;
    }

    @Cacheable(value="productPoint", keyGenerator="redisKeyGenerator")
	@Override
	public ProductPoint queryByProductId(int productId) {
		ProductPointExample example = new ProductPointExample();
		example.createCriteria().andProductIdEqualTo(productId);
		
		List<ProductPoint> list = this.queryAllObjByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

    @CacheEvict(value={"productPoint"}, allEntries=true)
	@Override
	public void deleteByExample(ProductPointExample pointExample) {
		this.productPointMapper.deleteByExample(pointExample);
	}
}