package com.els.runhe.warehouse.component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.els.runhe.product.dao.product.ProductMapper;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.product.entity.product.ProductExample;
import com.els.runhe.warehouse.dao.StockMapper;
import com.els.runhe.warehouse.data.IsEnable;
import com.els.runhe.warehouse.data.StockConstant;
import com.els.runhe.warehouse.entity.Stock;
import com.els.runhe.warehouse.entity.StockExample;
import com.els.runhe.warehouse.model.StockKey;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Component
public class ProductComponent {

	@Resource
	private ProductMapper productMapper;

	@Resource
	private StockMapper stockMapper;

	/**
	 * 将产品ID列表转换为Map(Key为产品ID，Value为产品对象)
	 * 
	 * @param productIdList
	 *            产品ID列表
	 * @return
	 */
	public Map<String, Product> transferIdsToMap(List<Integer> ids) {
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		criteria.andIdIn(ids);
		List<Product> list = productMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		Map<String, Product> map = Maps.uniqueIndex(list, new Function<Product, String>() {
			public String apply(Product obj) {
				return obj.getId().toString();
			}
		});
		return map;
	}

	/**
	 * 将产品编码列表转换为Map(Key为产品编码，Value为产品对象)
	 * 
	 * @param codes
	 *            产品编码列表
	 * @return
	 */
	public Map<String, Product> transferCodesToMap(List<String> codes) {
		ProductExample example = new ProductExample();
		ProductExample.Criteria criteria = example.createCriteria();
		criteria.andNumberCodeIn(codes);
		//criteria.andBarCodeIn(codes);
		List<Product> list = productMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		Map<String, Product> map = Maps.uniqueIndex(list, new Function<Product, String>() {
			public String apply(Product obj) {
				return obj.getNumberCode();
				// return obj.getBarCode();
			}
		});
		return map;
	}

	/**
	 * 根据产品ID列表查询并组装 Key=产品ID_仓库ID 的库存Map(Key=产品ID_仓库ID，Value=库存对象)
	 * 
	 * @param productIdList
	 * @return
	 */
	public Map<String, Stock> transferStockToMapByProductIds(List<String> productIdList) {
		if (CollectionUtils.isEmpty(productIdList)) {
			return null;
		}
		// 查询库存记录
		StockExample example = new StockExample();
		StockExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(IsEnable.Yes.getId());
		criteria.andProductIdIn(productIdList);
		List<Stock> list = stockMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		// 组装 Key=产品ID_仓库ID 的库存Map
		Map<String, Stock> map = Maps.uniqueIndex(list, new Function<Stock, String>() {
			public String apply(Stock obj) {
				return getStockKey(obj.getProductId(), obj.getWarehouseId());
			}
		});
		return map;
	}

	/**
	 * 根据库存联合主键列表查询并组装 Key=产品ID_仓库ID 的库存Map(Key=产品ID_仓库ID，Value=库存对象)
	 * 
	 * @param stockKeyList
	 * @return
	 */
	public Map<String, Stock> transferStockToMapByKeys(List<StockKey> stockKeyList) {
		if (CollectionUtils.isEmpty(stockKeyList)) {
			return null;
		}
		List<String> productIdList = Lists.transform(stockKeyList, new Function<StockKey, String>() {
			@Override
			public String apply(StockKey obj) {
				return obj.getProductId();
			}
		});
		if (CollectionUtils.isEmpty(productIdList)) {
			return null;
		}
		Map<String, Boolean> stockKeyMap = new HashMap<>();
		for (StockKey keyObj : stockKeyList) {
			String key = getStockKey(keyObj.getProductId(), keyObj.getWarehouseId());
			stockKeyMap.put(key, true);
		}
		StockExample example = new StockExample();
		// 查询库存记录
		StockExample.Criteria criteria = example.createCriteria();
		criteria.andIsEnableEqualTo(IsEnable.Yes.getId());
		criteria.andProductIdIn(productIdList);
		List<Stock> list = stockMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return new HashMap<String, Stock>(); // 2017-11-28 为空是不返回null 避免空指针
		}
		// 过滤掉一些重复或没用到的库存记录
		Set<Stock> stockSet = new HashSet<>();
		for (Stock stock : list) {
			String key = getStockKey(stock.getProductId(), stock.getWarehouseId());
			if (stockKeyMap.containsKey(key) && stockKeyMap.get(key)) {
				stockSet.add(stock);
			}
		}
		if (CollectionUtils.isEmpty(stockSet)) {
			return null;
		}
		// 组装 Key=产品ID_仓库ID 的库存Map
		Map<String, Stock> map = Maps.uniqueIndex(stockSet, new Function<Stock, String>() {
			public String apply(Stock obj) {
				return getStockKey(obj.getProductId(), obj.getWarehouseId());
			}
		});
		return map;
	}

	/**
	 * 拼装库存联合主键
	 * 
	 * @param productId
	 * @param warehouseId
	 * @return
	 */
	public String getStockKey(String productId, String warehouseId) {
		String key = productId + StockConstant.SPLIT + warehouseId;
		return key;
	}

}
