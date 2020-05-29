package com.els.runhe.warehouse.service;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.warehouse.entity.StockSerial;
import com.els.runhe.warehouse.entity.StockSerialExample;
import com.els.runhe.warehouse.entity.StockSerialToExcel;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.model.StockOpt;

public interface StockSerialService extends BaseService<StockSerial, StockSerialExample, String> {

	int createSerial(Warehouse warehouse, Product product, Integer originAmount, StockOpt stockOpt);

	List<StockSerialToExcel> queryToExcel(StockSerialToExcel example);

}