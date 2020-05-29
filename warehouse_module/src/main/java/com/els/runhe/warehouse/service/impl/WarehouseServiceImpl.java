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

import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.runhe.warehouse.dao.WarehouseMapper;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.entity.WarehouseExample;
import com.els.runhe.warehouse.service.WarehouseService;
import com.google.common.base.Function;
import com.google.common.collect.Maps;

@Service("defaultWarehouseService")
public class WarehouseServiceImpl implements WarehouseService {

	@Resource
	protected WarehouseMapper warehouseMapper;

	@CacheEvict(value = { "warehouse" }, allEntries = true)
	@Override
	public void addObj(Warehouse t) {
		String code = t.getWarehouseCode();
		if (StringUtils.isBlank(code)) {
			throw new CommonException("仓库编码不允许为空");
		}
		// 仓库编码须唯一
		WarehouseExample example = new WarehouseExample();
		WarehouseExample.Criteria criteria = example.createCriteria();
		criteria.andWarehouseCodeEqualTo(code);
		List<Warehouse> list = warehouseMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			throw new CommonException("仓库编码已存在");
		}
		Date now = new Date();
		t.setCreateTime(now);
		t.setUpdateTime(now);
		t.setIsEnable(Constant.YES_INT);
		this.warehouseMapper.insertSelective(t);
	}

	@CacheEvict(value = { "warehouse" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.warehouseMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "warehouse" }, allEntries = true)
	@Override
	public void modifyObj(Warehouse t) {
		if (StringUtils.isBlank(t.getId())) {
			throw new NullPointerException("id 为空，无法更新");
		}
		String id = t.getId();
		String code = t.getWarehouseCode();
		if (StringUtils.isNotBlank(code)) {
			// 仓库编码不能与其他仓库编码重复
			WarehouseExample example = new WarehouseExample();
			WarehouseExample.Criteria criteria = example.createCriteria();
			criteria.andIdNotEqualTo(id); // 排除自身
			criteria.andWarehouseCodeEqualTo(code);
			List<Warehouse> list = warehouseMapper.selectByExample(example);
			if (CollectionUtils.isNotEmpty(list)) {
				throw new CommonException("仓库编码重复");
			}
		}
		Date now = new Date();
		t.setUpdateTime(now);
		this.warehouseMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "warehouse", keyGenerator = "redisKeyGenerator")
	@Override
	public Warehouse queryObjById(String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("仓库ID不允许为空");
		}
		return this.warehouseMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "warehouse", keyGenerator = "redisKeyGenerator")
	@Override
	public List<Warehouse> queryAllObjByExample(WarehouseExample example) {
		return this.warehouseMapper.selectByExample(example);
	}

	@Cacheable(value = "warehouse", keyGenerator = "redisKeyGenerator")
	@Override
	public PageView<Warehouse> queryObjByPage(WarehouseExample example) {
		PageView<Warehouse> pageView = example.getPageView();
		pageView.setQueryResult(this.warehouseMapper.selectByExampleByPage(example));
		return pageView;
	}

	@Override
	public Map<String, Warehouse> transferCodesToMap(List<String> codes) {
		WarehouseExample example = new WarehouseExample();
		WarehouseExample.Criteria criteria = example.createCriteria();
		criteria.andWarehouseCodeIn(codes);
		List<Warehouse> list = warehouseMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		Map<String, Warehouse> map = Maps.uniqueIndex(list, new Function<Warehouse, String>() {
			public String apply(Warehouse obj) {
				return obj.getWarehouseCode();
			}
		});
		return map;
	}

}