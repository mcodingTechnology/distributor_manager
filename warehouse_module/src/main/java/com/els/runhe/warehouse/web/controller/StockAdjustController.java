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
import com.els.runhe.warehouse.entity.StockAdjust;
import com.els.runhe.warehouse.entity.StockAdjustExample;
import com.els.runhe.warehouse.model.StockAdjustInfo;
import com.els.runhe.warehouse.service.StockAdjustService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "库存模块-调整单管理")
@Controller
@RequestMapping("stockAdjust")
public class StockAdjustController {

	@Resource
	protected StockAdjustService stockAdjustService;

	@ApiOperation(httpMethod = "POST", value = "创建调整单")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody StockAdjust stockAdjust) {
		this.stockAdjustService.addObj(stockAdjust);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑调整单")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody StockAdjust stockAdjust) {
		if (StringUtils.isBlank(stockAdjust.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.stockAdjustService.modifyObj(stockAdjust);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除调整单")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.stockAdjustService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询调整单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 StockAdjust", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<StockAdjust>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		StockAdjustExample example = new StockAdjustExample();
		example.setPageView(new PageView<StockAdjust>(pageNo, pageSize));

		StockAdjustExample.Criteria criteria = example.createCriteria();
		if (wapper != null) {
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		example.setOrderByClause("CREATE_TIME DESC");
		PageView<StockAdjust> pageData = this.stockAdjustService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}

	@ApiOperation(httpMethod = "POST", value = "新增库存调整单")
	@RequestMapping("service/add")
	@ResponseBody
	public ResponseResult<?> add(@RequestBody StockAdjustInfo req) {
		this.stockAdjustService.add(req);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "GET", value = "查看库存调整单详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", required = true, value = "库存调整单ID", paramType = "query", dataType = "String") })
	@RequestMapping("service/detail")
	@ResponseBody
	public ResponseResult<StockAdjustInfo> detail(String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("库存调整清单ID为空");
		}
		StockAdjustInfo result = this.stockAdjustService.detail(id);
		return ResponseResult.success(result);
	}

}