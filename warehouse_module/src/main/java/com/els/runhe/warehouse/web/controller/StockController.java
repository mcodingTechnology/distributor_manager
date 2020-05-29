package com.els.runhe.warehouse.web.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.warehouse.entity.Stock;
import com.els.runhe.warehouse.entity.StockExample;
import com.els.runhe.warehouse.model.ProductStock;
import com.els.runhe.warehouse.model.ProductsStock;
import com.els.runhe.warehouse.model.StockOpt;
import com.els.runhe.warehouse.service.StockService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "库存模块-库存管理")
@Controller
@RequestMapping("stock")
public class StockController {
	@Resource
	protected StockService stockService;

	@ApiOperation(httpMethod = "POST", value = "创建库存")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody Stock stock) {
		this.stockService.addObj(stock);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑库存")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Stock stock) {
		if (StringUtils.isBlank(stock.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.stockService.modifyObj(stock);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除库存")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.stockService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询库存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 Stock", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<Stock>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		StockExample example = new StockExample();
		example.setPageView(new PageView<Stock>(pageNo, pageSize));
		example.setOrderByClause("CREATE_TIME DESC");

		if (wapper != null) {
			StockExample.Criteria criteria = example.createCriteria();
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<Stock> pageData = this.stockService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}

	/**
	 * 操作库存
	 * 
	 * @param req
	 * @return
	 */
	@ApiOperation(httpMethod = "POST", value = "操作库存")
	@RequestMapping("service/optStock")
	@ResponseBody
	public ResponseResult<Stock> optStock(@RequestBody StockOpt req) {
		if (null == req || StringUtils.isBlank(req.getProductId())) {
			throw new CommonException("产品 id 为空");
		}
		Stock result = stockService.optStock(req);
		return ResponseResult.success(result);
	}

	@ApiOperation(httpMethod = "POST", value = "根据产品聚合查询所有仓库库存总和")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 Stock", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/queryForProductByPage")
	@ResponseBody
	public ResponseResult<PageView<Stock>> queryForProductByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		StockExample example = new StockExample();
		example.setPageView(new PageView<Stock>(pageNo, pageSize));
		example.setOrderByClause("CREATE_TIME DESC");

		if (wapper != null) {
			StockExample.Criteria criteria = example.createCriteria();
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<Stock> pageData = this.stockService.queryForProductByPage(example);
		return ResponseResult.success(pageData);
	}

	@ApiOperation(httpMethod = "POST", value = "根据产品ID获取库存信息")
	@RequestMapping("service/findStockInfoByProduct")
	@ResponseBody
	public ResponseResult<Stock> findStockInfoByProduct(@RequestBody ProductStock req) {
		Stock result = stockService.getStockInfoByProduct(req.getWarehouseId(), req.getProductId());
		return ResponseResult.success(result);
	}

	@ApiOperation(httpMethod = "POST", value = "根据产品ID列表获取相应的库存量")
	@RequestMapping("service/findStocksByProducts")
	@ResponseBody
	public ResponseResult<Map<String, Stock>> findStocksByProducts(@RequestBody ProductsStock req) {
		Map<String, Stock> result = stockService.getStocksByProducts(req.getWarehouseId(), req.getProductIdList());
		return ResponseResult.success(result);
	}

}