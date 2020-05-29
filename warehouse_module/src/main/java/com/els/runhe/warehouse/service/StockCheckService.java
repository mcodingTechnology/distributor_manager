package com.els.runhe.warehouse.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.els.base.core.service.BaseService;
import com.els.runhe.warehouse.entity.StockCheck;
import com.els.runhe.warehouse.entity.StockCheckExample;
import com.els.runhe.warehouse.model.StockCheckImport;
import com.els.runhe.warehouse.model.StockCheckInfo;

public interface StockCheckService extends BaseService<StockCheck, StockCheckExample, String> {

	/**
	 * 新增盘点单
	 * 
	 * @param data
	 */
	void add(StockCheckInfo data);

	/**
	 * 判断盘点单号是否存在
	 * 
	 * @param checkOrderNum
	 * @param stockCheckId
	 *            盘点单ID，用于修改时排除自身记录
	 * @return
	 */
	boolean isExist(String checkOrderNum, String stockCheckId);

	/**
	 * 导入盘点单
	 * 
	 * @param file
	 *            导入文件
	 * @param data
	 *            盘点单信息
	 */
	void importData(MultipartFile file, StockCheck data) throws Exception;

	/**
	 * 批量盘点
	 * 
	 * @param list
	 */
	void batchStockCheck(List<StockCheckImport> list, StockCheck data);

	/**
	 * 根据盘点单号查询盘点列表
	 * 
	 * @param codes
	 * @return
	 */
	List<StockCheck> queryByCodes(List<String> codes);

	/**
	 * 将盘点单号列表转换为Map(Key为盘点单号，value为盘点单对象)
	 * 
	 * @param codes
	 *            盘点单号列表
	 * @return
	 */
	Map<String, StockCheck> transferCodesToMap(List<String> codes);

}