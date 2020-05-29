package com.els.runhe.warehouse.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.company.entity.Company;
import com.els.base.company.utils.CompanyUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.user.User;
import com.els.base.core.exception.CommonException;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.warehouse.component.ProductComponent;
import com.els.runhe.warehouse.dao.StockCheckMapper;
import com.els.runhe.warehouse.data.Status;
import com.els.runhe.warehouse.data.StockCheckSrc;
import com.els.runhe.warehouse.entity.StockCheck;
import com.els.runhe.warehouse.entity.StockCheckExample;
import com.els.runhe.warehouse.entity.StockCheckList;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.model.StockCheckImport;
import com.els.runhe.warehouse.model.StockCheckInfo;
import com.els.runhe.warehouse.service.StockCheckListService;
import com.els.runhe.warehouse.service.StockCheckService;
import com.els.runhe.warehouse.service.WarehouseService;
import com.els.runhe.warehouse.util.StockCheckImportUtil;
import com.els.runhe.warehouse.util.IdUtil;
import com.google.common.base.Function;
import com.google.common.collect.Maps;

@Service("defaultStockCheckService")
public class StockCheckServiceImpl implements StockCheckService {

	// private Logger logger = LogManager.getLogger(this.getClass());
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	protected StockCheckMapper stockCheckMapper;

	@Resource
	protected WarehouseService warehouseService;

	@Resource
	protected StockCheckListService stockCheckListService;

	@Resource
	protected ProductComponent productComponent;

	@CacheEvict(value = { "stockCheck" }, allEntries = true)
	@Override
	public void addObj(StockCheck t) {
		this.stockCheckMapper.insertSelective(t);
	}

	@CacheEvict(value = { "stockCheck" }, allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.stockCheckMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = { "stockCheck" }, allEntries = true)
	@Override
	public void modifyObj(StockCheck t) {
		if (StringUtils.isBlank(t.getId())) {
			throw new NullPointerException("id 为空，无法更新");
		}
		this.stockCheckMapper.updateByPrimaryKeySelective(t);
	}

	@Cacheable(value = "stockCheck", keyGenerator = "redisKeyGenerator")
	@Override
	public StockCheck queryObjById(String id) {
		return this.stockCheckMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "stockCheck", key = "'StockCheckService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public List<StockCheck> queryAllObjByExample(StockCheckExample example) {
		return this.stockCheckMapper.selectByExample(example);
	}

	@Cacheable(value = "stockCheck", key = "'StockCheckService_' + #root.methodName + '_'+ T(com.els.base.utils.encryption.Md5Utils).md5Object(#example)")
	@Override
	public PageView<StockCheck> queryObjByPage(StockCheckExample example) {
		PageView<StockCheck> pageView = example.getPageView();
		pageView.setQueryResult(this.stockCheckMapper.selectByExampleByPage(example));
		return pageView;
	}

	/**
	 * 新增盘点单
	 */
	@Override
	public void add(StockCheckInfo data) {
		if (null == data || null == data.getStockCheck() || null == data.getStockCheckList()) {
			throw new CommonException("新增盘点单数据为空");
		}
		StockCheck stockCheck = data.getStockCheck();
		String checkOrderNum = stockCheck.getCheckOrderNum();
		if (StringUtils.isBlank(checkOrderNum)) {
			throw new CommonException("盘点单号不允许为空");
		}
		// 盘点单编码排重
		if (isExist(checkOrderNum, null)) {
			throw new CommonException("盘点单号已存在");
		}
		Warehouse warehouse = warehouseService.queryObjById(stockCheck.getWarehouseId());
		if (null == warehouse) {
			throw new CommonException("找不到相应的仓库记录");
		}

		Date now = new Date();
		Date checkTime = stockCheck.getCheckTime();
		checkTime = (null == checkTime) ? now : checkTime;

		// 设置用户信息
		Company company = CompanyUtils.currentCompany();
		User user = SpringSecurityUtils.getLoginUser();
		stockCheck.setCompanyId(company.getId());
		stockCheck.setCompanyName(company.getCompanyFullName());
		stockCheck.setUserId(user.getId());

		// 将盘点单信息写入数据库
		String src = stockCheck.getSrc();
		src = (StringUtils.isBlank(src)) ? StockCheckSrc.Entering.getId() : src;
		stockCheck.setSrc(src);
		stockCheck.setWarehouseName(warehouse.getWarehouseName());
		stockCheck.setCheckTime(checkTime);
		stockCheck.setCreateTime(now);
		stockCheck.setUpdateTime(now);
		stockCheck.setApprovalStatus(Status.To_Audit.getId());
		int result = stockCheckMapper.insertSelective(stockCheck);
		List<StockCheckList> stockCheckList = data.getStockCheckList();
		if (result > 0 && CollectionUtils.isNotEmpty(stockCheckList)) {
			stockCheckListService.addList(stockCheckList, stockCheck, warehouse);
		}
	}

	/*
	 * 判断盘点单号是否存在
	 */
	public boolean isExist(String checkOrderNum, String stockCheckId) {
		StockCheckExample example = new StockCheckExample();
		StockCheckExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(stockCheckId)) {
			criteria.andIdNotEqualTo(stockCheckId); // 排除自身(针对修改的时候)
		}
		criteria.andCheckOrderNumEqualTo(checkOrderNum);
		List<StockCheck> list = stockCheckMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return true;
		}
		return false;
	}

	/**
	 * 导入盘点单
	 * 
	 * @param file
	 */
	@Override
	public void importData(MultipartFile file, StockCheck data) throws Exception {
		if (null == file || null == data) {
			throw new CommonException("请求信息为空");
		}
		if (StringUtils.isBlank(data.getCheckOrderNum())) {
			throw new CommonException("请填写盘点单号");
		}
		if (StringUtils.isBlank(data.getWarehouseId())) {
			throw new CommonException("请选择仓库");
		}
		InputStream in = null;
		try {
			in = file.getInputStream();
		} catch (Exception e) {
			logger.error("导入盘点单数据出错", e);
			throw new CommonException("获取导入文件流出错");
		}
		if (null == in) {
			logger.warn("导入盘点单数据文件流为空");
			return;
		}
		List<StockCheckImport> list = null;
		list = StockCheckImportUtil.readImportData(in);
		if (CollectionUtils.isEmpty(list)) {
			throw new CommonException("批量盘点数据为空");
		}
		if (null == list) {
			logger.warn("盘点单Excel数据为空");
			return;
		}
		batchStockCheck(list, data);
	}

	/**
	 * 批量盘点
	 */
	@Override
	public void batchStockCheck(List<StockCheckImport> list, StockCheck data) {
		Set<String> productCodeSet = new HashSet<>(); // 产品编码集合
		// 校验行
		for (StockCheckImport row : list) {
			String productCode = row.getProductCode();
			if (StringUtils.isBlank(productCode)) {
				throw new CommonException("存在产品编码为空的行");
			}
			Integer amount = row.getAmount();
			if (null == amount || amount < 0) {
				throw new CommonException("存在实盘数量不正确的行");
			}
			productCodeSet.add(productCode);
		}
		// 查产品信息
		Map<String, Product> productCodeMap = productComponent.transferCodesToMap(new ArrayList<>(productCodeSet));
		if (null == productCodeMap) {
			throw new CommonException("不存在这些产品编码的产品");
		}
		String notExistProductCodes = getNotExistProducts(productCodeSet, productCodeMap);
		if (StringUtils.isNotBlank(notExistProductCodes)) {
			throw new CommonException("以下产品编码的产品不存在：" + notExistProductCodes);
		}
		// 盘点单信息
		Date now = new Date();
		Date checkTime = data.getCheckTime();
		checkTime = (null == checkTime) ? now : checkTime;
		data.setCheckTime(checkTime);
		data.setCreateTime(now);
		data.setUpdateTime(now);
		data.setSrc(StockCheckSrc.Import.getId());
		// 组合盘点单
		StockCheckInfo info = new StockCheckInfo();
		info.setStockCheck(data);
		List<StockCheckList> detailList = new ArrayList<>();
		// 遍历行
		for (StockCheckImport row : list) {
			// 产品信息
			String productCode = row.getProductCode();
			Product product = productCodeMap.get(productCode);
			if (product != null) {
				String productId = IdUtil.change(product.getId());
				// 清单明细
				StockCheckList detail = new StockCheckList();
				detail.setProductId(productId);
				detail.setAmount(row.getAmount());

				detailList.add(detail);
			}
		}
		info.setStockCheckList(detailList);
		// 新增盘点单
		add(info);
	}

	@Override
	public List<StockCheck> queryByCodes(List<String> codes) {
		StockCheckExample example = new StockCheckExample();
		StockCheckExample.Criteria criteria = example.createCriteria();
		criteria.andCheckOrderNumIn(codes);
		List<StockCheck> list = stockCheckMapper.selectByExample(example);
		if (CollectionUtils.isNotEmpty(list)) {
			return null;
		}
		return list;
	}

	@Override
	public Map<String, StockCheck> transferCodesToMap(List<String> codes) {
		List<StockCheck> list = queryByCodes(codes);
		if (CollectionUtils.isNotEmpty(list)) {
			return null;
		}
		Map<String, StockCheck> map = Maps.uniqueIndex(list, new Function<StockCheck, String>() {
			public String apply(StockCheck obj) {
				return obj.getCheckOrderNum();
			}
		});
		return map;
	}

	protected String getKey(String stockCheckNum, String wharehouseCode) {
		return stockCheckNum + "_" + wharehouseCode;
	}

	protected String[] splitByKey(String key) {
		return key.split("_");
	}

	protected String getNotExistProducts(Set<String> allProductCodeSet, Map<String, Product> existProductCodeMap) {
		if (null == existProductCodeMap || existProductCodeMap.isEmpty()
				|| CollectionUtils.isEmpty(allProductCodeSet)) {
			throw new CommonException("产品编码为空或不存在这些产品编码的产品");
		}
		Set<String> newProductCodeSet = allProductCodeSet;
		Set<String> existProductCodeSet = existProductCodeMap.keySet();
		newProductCodeSet.removeAll(existProductCodeSet);
		if (null == newProductCodeSet || newProductCodeSet.isEmpty()) {
			return null;
		}
		return StringUtils.join(newProductCodeSet, ",");
	}

}