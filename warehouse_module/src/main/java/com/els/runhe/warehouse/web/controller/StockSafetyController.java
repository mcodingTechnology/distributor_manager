package com.els.runhe.warehouse.web.controller;

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
import com.els.runhe.warehouse.entity.StockSafety;
import com.els.runhe.warehouse.entity.StockSafetyExample;
import com.els.runhe.warehouse.service.StockSafetyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "库存模块-安全库存管理")
@Controller
@RequestMapping("stockSafety")
public class StockSafetyController {

	@Resource
	protected StockSafetyService stockSafetyService;

	@ApiOperation(httpMethod = "POST", value = "创建安全库存")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody StockSafety stockSafety) {
		this.stockSafetyService.addObj(stockSafety);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑安全库存")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody StockSafety stockSafety) {
		if (StringUtils.isBlank(stockSafety.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.stockSafetyService.modifyObj(stockSafety);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除安全库存")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.stockSafetyService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询安全库存")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 StockSafety", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<StockSafety>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		StockSafetyExample example = new StockSafetyExample();
		example.setPageView(new PageView<StockSafety>(pageNo, pageSize));
		example.setOrderByClause("CREATE_TIME DESC");

		if (wapper != null) {
			StockSafetyExample.Criteria criteria = example.createCriteria();
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<StockSafety> pageData = this.stockSafetyService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}

	@ApiOperation(httpMethod = "GET", value = "根据产品ID获取库存安全信息(安全库存预警)")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "productId", required = true, value = "产品ID", paramType = "query", dataType = "String") })
	@RequestMapping("service/findStockSafetyInfoByProduct")
	@ResponseBody
	public ResponseResult<StockSafety> findStockSafetyInfoByProduct(String productId) {
		if (StringUtils.isBlank(productId)) {
			throw new CommonException("产品ID为空");
		}
		StockSafety data = this.stockSafetyService.getStockSafetyInfoByProduct(productId);
		return ResponseResult.success(data);
	}

}