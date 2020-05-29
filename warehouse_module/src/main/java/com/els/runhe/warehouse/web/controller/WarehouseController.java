package com.els.runhe.warehouse.web.controller;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.company.utils.CompanyUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.warehouse.entity.Warehouse;
import com.els.runhe.warehouse.entity.WarehouseExample;
import com.els.runhe.warehouse.service.WarehouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "库存模块-仓库管理")
@Controller
@RequestMapping("warehouse")
public class WarehouseController {
	@Resource
	protected WarehouseService warehouseService;

	@ApiOperation(httpMethod = "POST", value = "创建仓库")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody Warehouse warehouse) {
		if (null == warehouse) {
			throw new CommonException("仓库信息为空");
		}
		String companyId = CompanyUtils.currentCompanyId();
		String userId = SpringSecurityUtils.getLoginUserId();
		warehouse.setCompanyId(companyId);
		warehouse.setUserId(userId);
		this.warehouseService.addObj(warehouse);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑仓库")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Warehouse warehouse) {
		if (StringUtils.isBlank(warehouse.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.warehouseService.modifyObj(warehouse);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除仓库")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.warehouseService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询仓库")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 Warehouse", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<Warehouse>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		WarehouseExample example = new WarehouseExample();
		example.setPageView(new PageView<Warehouse>(pageNo, pageSize));
		example.setOrderByClause("CREATE_TIME DESC");

		WarehouseExample.Criteria criteria = example.createCriteria();
		criteria.andCompanyIdEqualTo(CompanyUtils.currentCompanyId());
		if (wapper != null) {
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<Warehouse> pageData = this.warehouseService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}
}