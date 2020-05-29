package com.els.runhe.warehouse.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.codegenerator.service.GenerateCodeService;
import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.base.utils.SpringContextHolder;
import com.els.runhe.product.dao.product.ProductMapper;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.warehouse.dao.StockSafetyLogMapper;
import com.els.runhe.warehouse.dao.StockSafetyMapper;
import com.els.runhe.warehouse.entity.StockSafety;
import com.els.runhe.warehouse.entity.StockSafetyExample;
import com.els.runhe.warehouse.entity.StockSafetyLog;
import com.els.runhe.warehouse.service.StockSafetyService;
import com.els.runhe.warehouse.util.IdUtil;

@Service("defaultStockSafetyService")
public class StockSafetyServiceImpl implements StockSafetyService {

	@Resource
	protected StockSafetyMapper stockSafetyMapper;

	@Resource
	protected ProductMapper productMapper;
	
	@Resource
    protected StockSafetyLogMapper stockSafetyLogMapper;
	
	private static final String RETURN_CODE_GENERATE = "STOCK_SAFETY_CODE";
	private static final String RETURN_CODE = "STOCK_SAFETY_LOG_CODE";
    protected static GenerateCodeService generateCodeService  = SpringContextHolder.getOneBean(GenerateCodeService.class);

	@CacheEvict(value = { "stockSafety" }, allEntries = true)
	@Override
	public void addObj(StockSafety t) {
		if (null == t) {
			throw new CommonException("安全库存信息为空");
		}
		Integer min = t.getMin();
		if (null == min || min < 0) {
			throw new CommonException("最小库存量为空或小于0");
		}
		Integer max = t.getMax();
		if ((null != max && max < 0) || (null != max && max < min)) {
			throw new CommonException("最大库存量小于0或小于最小库存量");
		}
		// 设置产品信息
		String productId = t.getProductId();
		if (StringUtils.isBlank(productId)) {
			throw new CommonException("产品ID为空");
		}
		Product product = productMapper.selectByPrimaryKey(IdUtil.change(productId));
		if (null == product) {
			throw new CommonException("找不到相应的产品记录");
		}
		if (isExistByProduct(productId, null)) {
			throw new CommonException("已存在该产品的安全库存记录");
		}
		t.setProductName(product.getProductName());
		// t.setProductCode(product.getNumberCode());
		t.setProductCode(product.getBarCode());
		t.setProductModel(product.getSpec());
		t.setProductUnit(product.getUnit());
		// 其他信息
		Date now = new Date();
		t.setCreateTime(now);
		t.setUpdateTime(now);
		t.setIsEnable(Constant.YES_INT);

		String code =generateCodeService.getNextCode(RETURN_CODE_GENERATE);
		t.setId(code);
		this.stockSafetyMapper.insertSelective(t);
		// 插入安全库存流水
		StockSafetyLog log = new StockSafetyLog();
		BeanUtils.copyProperties(t, log);
		log.setStockSafetyId(code);
		log.setId(generateCodeService.getNextCode(RETURN_CODE));
		this.stockSafetyLogMapper.insertSelective(log);
	}
	
	@CacheEvict(value = { "stockSafety" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.stockSafetyMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "stockSafety" }, allEntries = true)
	@Override
	public void modifyObj(StockSafety t) {
		String id = t.getId();
		if (StringUtils.isBlank(id)) {
			throw new NullPointerException("id 为空，无法更新");
		}
		StockSafety record = this.stockSafetyMapper.selectByPrimaryKey(id);
		if (null == record) {
			throw new CommonException("安全库存记录不存在");
		}
		Integer min = t.getMin();
		min = (null == min) ? record.getMin() : t.getMin();
		if (null != min && min < 0) {
			throw new CommonException("最小库存量小于0");
		}
		Integer max = t.getMax();
		max = (null == max) ? record.getMax() : t.getMax();
		if ((null != max && max < 0) || (null != max && max < min)) {
			throw new CommonException("最大库存量小于0或小于最小库存量");
		}
		String productId = t.getProductId();
		if (StringUtils.isNotBlank(productId)) {
			if (isExistByProduct(productId, id)) {
				throw new CommonException("已存在该产品的安全库存记录");
			}
		}
		Date now = new Date();
		t.setUpdateTime(now);
		this.stockSafetyMapper.updateByPrimaryKeySelective(t);
		// 插入安全库存流水
		StockSafetyLog log = new StockSafetyLog();
		BeanUtils.copyProperties(t, log);
		log.setStockSafetyId(t.getId());
		log.setId(generateCodeService.getNextCode(RETURN_CODE));
		log.setCreateTime(now);
		this.stockSafetyLogMapper.insertSelective(log);
	}

	@Cacheable(value = "stockSafety", keyGenerator = "redisKeyGenerator")
	@Override
	public StockSafety queryObjById(String id) {
		return this.stockSafetyMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "stockSafety", keyGenerator = "redisKeyGenerator")
	@Override
	public List<StockSafety> queryAllObjByExample(StockSafetyExample example) {
		return this.stockSafetyMapper.selectByExample(example);
	}

	@Cacheable(value = "stockSafety", keyGenerator = "redisKeyGenerator")
	@Override
	public PageView<StockSafety> queryObjByPage(StockSafetyExample example) {
		PageView<StockSafety> pageView = example.getPageView();
		pageView.setQueryResult(this.stockSafetyMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 根据产品ID获取库存安全信息(安全库存预警)
	 * 
	 * @param productId
	 *            产品ID
	 * @return
	 */
	@Override
	public StockSafety getStockSafetyInfoByProduct(String productId) {
		StockSafetyExample example = new StockSafetyExample();
		StockSafetyExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andProductIdEqualTo(productId);
		List<StockSafety> list = this.stockSafetyMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 根据产品ID查询记录是否存在，作排重之用
	 * 
	 * @param productId
	 *            产品ID
	 * @param id
	 *            此ID为记录ID，当更新修改时用于排除自身记录
	 * @return
	 */
	private Boolean isExistByProduct(String productId, String id) {
		StockSafetyExample example = new StockSafetyExample();
		StockSafetyExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andProductIdEqualTo(productId);
		if (StringUtils.isNotBlank(id)) {
			criteria.andIdNotEqualTo(id); // 排除自身记录，用于修改时
		}
		List<StockSafety> list = this.stockSafetyMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return false;
		}
		return true;
	}

}