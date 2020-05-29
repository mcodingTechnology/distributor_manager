package com.els.runhe.region.web.controller;

import java.util.List;

import javax.annotation.Resource;

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
import com.els.runhe.region.entity.Region;
import com.els.runhe.region.entity.RegionExample;
import com.els.runhe.region.service.RegionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "地区")
@Controller
@RequestMapping("region")
public class RegionController {
	@Resource
	protected RegionService regionService;

	@ApiOperation(httpMethod = "POST", value = "创建地区")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody Region region) {
		this.regionService.addObj(region);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑地区")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Region region) {
		if (region.getId() == null || region.getId() <= 0) {
			throw new CommonException("id 为空，保存失败");
		}
		this.regionService.modifyObj(region);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除地区")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) int id) {
		this.regionService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询地区")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 Region", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<Region>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		RegionExample example = new RegionExample();
		example.setPageView(new PageView<Region>(pageNo, pageSize));

		if (wapper != null) {
			RegionExample.Criteria criteria = example.createCriteria();
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<Region> pageData = this.regionService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}
	
	@ApiOperation(httpMethod="GET", value="根据parentId查询地区列表")
    @RequestMapping("service/findByParentId")
    @ResponseBody
    public ResponseResult<List<Region>> findByParentId( @ApiParam(value="parentId", required = true) int parentRegionId) {
        RegionExample example = new RegionExample();
        RegionExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentRegionId);
        
        return ResponseResult.success(this.regionService.queryAllObjByExample(example));
    }
}