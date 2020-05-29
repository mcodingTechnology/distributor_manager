package com.els.runhe.warehouse.service;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.warehouse.entity.StockCheck;
import com.els.runhe.warehouse.entity.StockCheckList;
import com.els.runhe.warehouse.entity.StockCheckListExample;
import com.els.runhe.warehouse.entity.Warehouse;

public interface StockCheckListService extends BaseService<StockCheckList, StockCheckListExample, String> {

	void addList(List<StockCheckList> stockCheckList, StockCheck stockCheck, Warehouse warehouse);

	List<StockCheckList> queryObjByStockCheckId(String id);

}