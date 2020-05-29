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
import com.els.runhe.warehouse.entity.StockCheckList;
import com.els.runhe.warehouse.entity.StockCheckListExample;
import com.els.runhe.warehouse.service.StockCheckListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "库存模块-盘点明细清单管理")
@Controller
@RequestMapping("stockCheckList")
public class StockCheckListController {
	@Resource
	protected StockCheckListService stockCheckListService;

	@ApiOperation(httpMethod = "POST", value = "创建盘点明细清单")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody StockCheckList stockCheckList) {
		this.stockCheckListService.addObj(stockCheckList);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑盘点明细清单")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody StockCheckList stockCheckList) {
		if (StringUtils.isBlank(stockCheckList.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.stockCheckListService.modifyObj(stockCheckList);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除盘点明细清单")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.stockCheckListService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询盘点明细清单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 StockCheckList", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<StockCheckList>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		StockCheckListExample example = new StockCheckListExample();
		example.setPageView(new PageView<StockCheckList>(pageNo, pageSize));
		example.setOrderByClause("CREATE_TIME DESC");
		
		if (wapper != null) {
			StockCheckListExample.Criteria criteria = example.createCriteria();
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<StockCheckList> pageData = this.stockCheckListService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}
}