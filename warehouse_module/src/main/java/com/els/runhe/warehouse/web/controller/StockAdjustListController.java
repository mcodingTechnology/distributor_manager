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
import com.els.runhe.warehouse.entity.StockAdjustList;
import com.els.runhe.warehouse.entity.StockAdjustListExample;
import com.els.runhe.warehouse.service.StockAdjustListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="库存模块-调整明细清单管理")
@Controller
@RequestMapping("stockAdjustList")
public class StockAdjustListController {
    @Resource
    protected StockAdjustListService stockAdjustListService;

    @ApiOperation(httpMethod="POST", value="创建调整明细清单")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody StockAdjustList stockAdjustList) {
        this.stockAdjustListService.addObj(stockAdjustList);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑调整明细清单")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody StockAdjustList stockAdjustList) {
        if (StringUtils.isBlank(stockAdjustList.getId())) {
            throw new CommonException("id 为空，保存失败");
        }
        this.stockAdjustListService.modifyObj(stockAdjustList);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除调整明细清单")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.stockAdjustListService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询调整明细清单")
    @ApiImplicitParams({ 
		@ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
		@ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
		@ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 StockAdjustList", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<StockAdjustList>> findByPage( 
		@RequestParam(defaultValue="0") int pageNo,  
		@RequestParam(defaultValue="10") int pageSize, 
		@RequestBody(required=false) QueryParamWapper wapper) {
        StockAdjustListExample example = new StockAdjustListExample();
        example.setPageView(new PageView<StockAdjustList>(pageNo, pageSize));
        
        StockAdjustListExample.Criteria criteria = example.createCriteria();
        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<StockAdjustList> pageData = this.stockAdjustListService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}