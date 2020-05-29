package com.els.runhe.warehouse.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.runhe.product.dao.product.ProductMapper;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.warehouse.component.ProductComponent;
import com.els.runhe.warehouse.dao.StockMapper;
import com.els.runhe.warehouse.dao.WarehouseMapper;
import com.els.runhe.warehouse.data.AmountType;
import com.els.runhe.warehouse.data.StockOptType;
import com.els.runhe.warehouse.entity.Stock;
import com.els.runhe.warehouse.entity.StockExample;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.model.StockOpt;
import com.els.runhe.warehouse.service.StockSerialService;
import com.els.runhe.warehouse.service.StockService;
import com.els.runhe.warehouse.util.IdUtil;
import com.google.common.base.Function;
import com.google.common.collect.Maps;

@Service("defaultStockService")
@Transactional
public class StockServiceImpl implements StockService {

	@Resource
	protected StockMapper stockMapper;

	@Resource
	protected WarehouseMapper warehouseMapper;

	@Resource
	protected ProductMapper productMapper;

	@Resource
	protected ProductComponent productComponent;

	@Resource
	private StockSerialService stockSerialService;

	@CacheEvict(value = { "stock" }, allEntries = true)
	@Override
	public void addObj(Stock t) {
		this.stockMapper.insertSelective(t);
	}

	@CacheEvict(value = { "stock" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.stockMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "stock" }, allEntries = true)
	@Override
	public void modifyObj(Stock t) {
		if (StringUtils.isBlank(t.getId())) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.stockMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "stock", keyGenerator = "redisKeyGenerator")
	@Override
	public Stock queryObjById(String id) {
		return this.stockMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "stock", keyGenerator = "redisKeyGenerator")
	@Override
	public List<Stock> queryAllObjByExample(StockExample example) {
		return this.stockMapper.selectByExample(example);
	}

	@Cacheable(value = "stock", keyGenerator = "redisKeyGenerator")
	@Override
	public PageView<Stock> queryObjByPage(StockExample example) {
		PageView<Stock> pageView = example.getPageView();
		pageView.setQueryResult(this.stockMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 操作库存，适合单个操作
	 */
	@Override
	public Stock optStock(StockOpt data) {
		if (null == data || StringUtils.isBlank(data.getProductId())) {
			throw new NullPointerException("产品 id 为空，无法操作库存");
		}
		if (data.getAmount() <= 0) {
			throw new CommonException("操作的库存数量必须大于0");
		}
		String productId = data.getProductId();
		Product product = productMapper.selectByPrimaryKey(IdUtil.change(productId));
		if (null == product) {
			throw new CommonException("产品不存在");
		}
		String warehouseId = data.getWarehouseId();
		if (StringUtils.isBlank(warehouseId)) {
			warehouseId = "";
		}
		Integer amount = data.getAmount();
		// 处理库存数量类型
		String amountType = data.getAmountType();
		if (StringUtils.isBlank(amountType)) {
			amountType = AmountType.Plus.getId();
			data.setAmountType(amountType);
		}

		int result = 0;
		Date now = new Date();
		Stock entity = null;
		Warehouse warehouse = null;
		String warehouseName = null;

		// 查询库存记录
		StockExample example = new StockExample();
		StockExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		if (StringUtils.isNotBlank(warehouseId)) {
			criteria.andWarehouseIdEqualTo(warehouseId);
			warehouse = warehouseMapper.selectByPrimaryKey(warehouseId);
			if (null != warehouse) {
				warehouseName = warehouse.getWarehouseName();
			}
		}
		List<Stock> list = stockMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			if (AmountType.Minus.getId().equals(amountType)) {
				throw new CommonException("当没有产品的库存记录时，不能做减少库存操作");
			}
			// 添加库存记录
			entity = new Stock();
			entity.setWarehouseId(warehouseId);
			entity.setWarehouseName(warehouseName);
			entity.setProductId(productId);
			entity.setProductName(product.getProductName());
			// entity.setProductCode(product.getNumberCode());
			entity.setProductCode(product.getBarCode());
			entity.setProductModel(product.getSpec());
			entity.setProductUnit(product.getUnit());
			entity.setAmount(amount);
			entity.setCreateTime(now);
			entity.setUpdateTime(now);
			result = stockMapper.insertSelective(entity);
			if (result > 0) {
				stockSerialService.createSerial(warehouse, product, 0, data);
			}
		} else {
			// 更新库存记录
			Stock record = list.get(0);
			Integer originAmount = record.getAmount();
			String optType = data.getOptType();
			entity = new Stock();
			int newAmount = 0;

			if (null != optType && StockOptType.Check.getId().equals(optType)) {
				// 盘点类型：数量处理
				int offsetAmount = 0; // 库存流水偏移量
				if (originAmount < amount) {
					data.setAmountType(AmountType.Plus.getId());
					offsetAmount = amount - originAmount;
				} else if (originAmount > amount) {
					data.setAmountType(AmountType.Minus.getId());
					offsetAmount = originAmount - amount;
				} else {
					data.setAmountType(AmountType.Keep.getId());
					offsetAmount = 0;
				}
				newAmount = amount;
				// 设置库存流水偏移量
				data.setAmount(offsetAmount);
			} else {
				if (AmountType.Minus.getId().equals(amountType) && originAmount < amount) {
					throw new CommonException("库存不足");
				}
				// 发货或出货类型：数量处理
				if (AmountType.Plus.getId().equals(amountType)) {
					// 增加库存
					newAmount = originAmount + amount;
				} else {
					// 减少库存
					newAmount = originAmount - amount;
				}
			}

			entity.setId(record.getId());
			entity.setAmount(newAmount);
			entity.setUpdateTime(now);
			result = stockMapper.updateByPrimaryKeySelective(entity);
			if (result > 0) {
				stockSerialService.createSerial(warehouse, product, originAmount, data);
			}
		}
		// 返回处理
		if (result > 0) {
			return stockMapper.selectByPrimaryKey(entity.getId());
		} else {
			throw new CommonException("库存操作失败");
		}
	}

	@Override
	public int optStockByBatch(StockOpt data, Warehouse warehouse, Product product, Map<String, Stock> stockMap) {
		if (null == data) {
			throw new CommonException("数据为空");

		}
		if (data.getAmount() < 0) {
			throw new CommonException("操作的库存数量必须大于等于0");
		}

		String productId = data.getProductId();
		if (StringUtils.isBlank(productId)) {
			productId = product.getId().toString();
		}
		if (StringUtils.isBlank(productId)) {
			throw new CommonException("产品 id 为空，无法操作库存");
		}
		if (null == product) {
			product = productMapper.selectByPrimaryKey(IdUtil.change(productId));
		}
		if (null == product) {
			throw new CommonException("产品不存在");
		}

		String warehouseId = data.getWarehouseId();
		if (StringUtils.isBlank(warehouseId)) {
			warehouseId = warehouse.getId();
		}
		if (null == warehouse && StringUtils.isNotBlank(warehouseId)) {
			warehouse = warehouseMapper.selectByPrimaryKey(warehouseId);
		}
		String warehouseName = null;
		if (null != warehouse) {
			warehouseName = warehouse.getWarehouseName();
		}
		if (StringUtils.isBlank(warehouseId)) {
			warehouseId = "";
		}

		Integer amount = data.getAmount();
		// 处理库存数量类型
		String amountType = data.getAmountType();
		if (StringUtils.isBlank(amountType)) {
			amountType = AmountType.Plus.getId();
			data.setAmountType(amountType);
		}

		int result = 0;
		Date now = new Date();
		Stock entity = null;

		// 查询库存记录
		warehouseId = (StringUtils.isBlank(warehouseId)) ? "" : warehouseId;
		String sotckKey = productComponent.getStockKey(productId, warehouseId);
		if (null == stockMap || !stockMap.containsKey(sotckKey)) {
			if (AmountType.Minus.getId().equals(amountType)) {
				throw new CommonException("当没有产品的库存记录时，不能做减少库存操作");
			}
			// 添加库存记录
			entity = new Stock();
			entity.setWarehouseId(warehouseId);
			entity.setWarehouseName(warehouseName);
			entity.setProductId(productId);
			entity.setProductName(product.getProductName());
			entity.setProductCode(product.getNumberCode());
			// entity.setProductCode(product.getBarCode());
			entity.setProductModel(product.getSpec());
			entity.setProductUnit(product.getUnit());
			entity.setAmount(amount);
			entity.setCreateTime(now);
			entity.setUpdateTime(now);
			result = stockMapper.insertSelective(entity);
			if (result > 0) {
				stockSerialService.createSerial(warehouse, product, 0, data);
			}
		} else {
			// 更新库存记录
			Stock record = stockMap.get(sotckKey);
			Integer originAmount = record.getAmount();
			String optType = data.getOptType();
			entity = new Stock();
			int newAmount = 0;

			if (null != optType && StockOptType.Check.getId().equals(optType)) {
				// 盘点类型：数量处理
				int offsetAmount = 0; // 库存流水偏移量
				if (originAmount < amount) {
					data.setAmountType(AmountType.Plus.getId());
					offsetAmount = amount - originAmount;
				} else if (originAmount > amount) {
					data.setAmountType(AmountType.Minus.getId());
					offsetAmount = originAmount - amount;
				} else {
					data.setAmountType(AmountType.Keep.getId());
					offsetAmount = 0;
				}
				newAmount = amount;
				// 设置库存流水偏移量
				data.setAmount(offsetAmount);
			} else {
				if (AmountType.Minus.getId().equals(amountType) && originAmount < amount) {
					throw new CommonException("库存不足");
				}
				// 发货或出货类型：数量处理
				if (AmountType.Plus.getId().equals(amountType)) {
					// 增加库存
					newAmount = originAmount + amount;
				} else {
					// 减少库存
					newAmount = originAmount - amount;
				}
			}

			entity.setId(record.getId());
			entity.setAmount(newAmount);
			entity.setUpdateTime(now);
			result = stockMapper.updateByPrimaryKeySelective(entity);
			if (result > 0) {
				stockSerialService.createSerial(warehouse, product, originAmount, data);
			}
		}
		// 返回处理
		return result;
	}

	@Override
	public PageView<Stock> queryForProductByPage(StockExample example) {
		PageView<Stock> pageView = example.getPageView();
		List<Stock> list = this.stockMapper.selectForProductByExampleByPage(example);
		pageView.setQueryResult(list);
		return pageView;
	}

	/**
	 * 根据产品ID获取库存信息
	 * 
	 * @param warehouseId
	 *            仓库ID，可选
	 * @param productId
	 *            产品ID
	 * @return
	 */
	@Override
	public Stock getStockInfoByProduct(String warehouseId, String productId) {
		StockExample example = new StockExample();
		StockExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andProductIdEqualTo(productId);
		if (StringUtils.isNotBlank(warehouseId)) {
			criteria.andWarehouseIdEqualTo(warehouseId);
		}
		List<Stock> list = this.stockMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 根据产品ID列表获取相应的库存量
	 * 
	 * @param warehouseId
	 *            仓库ID，可选
	 * @param productIdList
	 *            品ID列表
	 * @return 返回Map：Key是产品ID，Value是库存量
	 */
	@Override
	public Map<String, Stock> getStocksByProducts(String warehouseId, List<String> productIdList) {
		StockExample example = new StockExample();
		StockExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(Constant.YES_INT);
		criteria.andProductIdIn(productIdList);
		if (StringUtils.isNotBlank(warehouseId)) {
			criteria.andWarehouseIdEqualTo(warehouseId);
		}
		List<Stock> list = this.stockMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		Map<String, Stock> map = Maps.uniqueIndex(list, new Function<Stock, String>() {
			public String apply(Stock obj) {
				return obj.getProductId();
			}
		});
		return map;
	}

}