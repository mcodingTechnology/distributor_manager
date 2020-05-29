package com.els.runhe.warehouse.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.product.entity.product.ProductExample;
import com.els.runhe.warehouse.dao.StockSerialMapper;
import com.els.runhe.warehouse.data.AmountType;
import com.els.runhe.warehouse.data.StockOptType;
import com.els.runhe.warehouse.entity.StockSerial;
import com.els.runhe.warehouse.entity.StockSerialExample;
import com.els.runhe.warehouse.entity.StockSerialToExcel;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.model.StockOpt;
import com.els.runhe.warehouse.service.StockSerialService;
import com.els.runhe.warehouse.util.IdUtil;

@Service("defaultStockSerialService")
public class StockSerialServiceImpl implements StockSerialService {
	@Resource
	protected StockSerialMapper stockSerialMapper;

	@CacheEvict(value = { "stockSerial" }, allEntries = true)
	@Override
	public void addObj(StockSerial t) {
		this.stockSerialMapper.insertSelective(t);
	}

	@CacheEvict(value = { "stockSerial" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.stockSerialMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "stockSerial" }, allEntries = true)
	@Override
	public void modifyObj(StockSerial t) {
		if (StringUtils.isBlank(t.getId())) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.stockSerialMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "stockSerial", keyGenerator = "redisKeyGenerator")
	@Override
	public StockSerial queryObjById(String id) {
		return this.stockSerialMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "stockSerial", key = "'StockSerialService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public List<StockSerial> queryAllObjByExample(StockSerialExample example) {
		return this.stockSerialMapper.selectByExample(example);
	}

	@Cacheable(value = "stockSerial", key = "'StockSerialService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public PageView<StockSerial> queryObjByPage(StockSerialExample example) {
		PageView<StockSerial> pageView = example.getPageView();
		pageView.setQueryResult(this.stockSerialMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 生成库存流水
	 */
	@Override
	public int createSerial(Warehouse warehouse, Product product, Integer originAmount, StockOpt stockOpt) {
		if (null == product || null == stockOpt || originAmount < 0) {
			throw new CommonException("参数有误");
		}
		StockSerial entity = new StockSerial();
		if (null != warehouse) {
			entity.setWarehouseId(warehouse.getId());
			entity.setWarehouseName(warehouse.getWarehouseName());
		}
		entity.setProductId(IdUtil.change(product.getId()));
		entity.setProductName(product.getProductName());
		// entity.setProductCode(product.getNumberCode());
		entity.setProductCode(product.getBarCode());
		entity.setProductModel(product.getSpec());
		entity.setProductUnit(product.getUnit());
		String optType = stockOpt.getOptType();
		if (StringUtils.isBlank(optType)) {
			optType = StockOptType.Shipment.getId();
		}
		entity.setOptType(optType);
		Integer amount = stockOpt.getAmount();
		// 处理库存数量类型
		String amountType = stockOpt.getAmountType();
		if (StringUtils.isBlank(amountType)) {
			amountType = AmountType.Plus.getId();
		}
		if (AmountType.Minus.getId().equals(amountType) && originAmount < amount) {
			throw new CommonException("库存不足");
		}
		Date now = new Date();
		int newAmount = 0;
		if (AmountType.Plus.getId().equals(amountType)) {
			// 增加库存
			newAmount = originAmount + amount;
		} else {
			// 减少库存
			newAmount = originAmount - amount;
		}
		entity.setAmountType(amountType);
		entity.setOriginAmount(originAmount);
		entity.setOffsetAmount(amount);
		entity.setSurplusAmount(newAmount);
		entity.setOptTime(now);
		entity.setCreateTime(now);
		entity.setUpdateTime(now);
		int result = stockSerialMapper.insertSelective(entity);
		return result;
	}

	@Override
	public List<StockSerialToExcel> queryToExcel(StockSerialToExcel stockSerialToExcel) {
		return stockSerialMapper.queryToExcel(stockSerialToExcel);
	}

}