package com.els.runhe.order.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.utils.Assert;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.order.entity.OrderSaleSupportRecord;
import com.els.runhe.order.entity.OrderSaleSupportRecordExample;
import com.els.runhe.order.entity.SaleAndMarketSupport;
import com.els.runhe.order.service.OrderSaleSupportRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="订单-销售支持记录")
@Controller
@RequestMapping("orderSaleSupportRecord")
public class OrderSaleSupportRecordController {
    @Resource
    protected OrderSaleSupportRecordService orderSaleSupportRecordService;

    @ApiOperation(httpMethod="POST", value="创建销售支持汇款记录")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody OrderSaleSupportRecord orderSaleSupportRecord) {
        this.orderSaleSupportRecordService.addObj(orderSaleSupportRecord);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑销售支持汇款记录")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody OrderSaleSupportRecord orderSaleSupportRecord) {
        Assert.isNotBlank(orderSaleSupportRecord.getId(), "id 为空，保存失败");
        this.orderSaleSupportRecordService.modifyObj(orderSaleSupportRecord);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除销售支持汇款记录")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        Assert.isNotBlank(id, "删除失败,id不能为空");
        this.orderSaleSupportRecordService.deleteObjById(id);
        return ResponseResult.success();
    }
    
    @ApiOperation(httpMethod="POST", value="查询经销商市场额度")
    @RequestMapping("service/queryByCompanyId")
    @ResponseBody
    public ResponseResult<SaleAndMarketSupport> queryByCompanyId(@RequestParam(required=true) String id) {
    	Assert.isNotBlank(id, "删除失败,id不能为空");
    	
    	return ResponseResult.success(this.orderSaleSupportRecordService.calculateByOrderId(id));
    }

    @ApiOperation(httpMethod="POST", value="查询销售支持汇款记录")
    @ApiImplicitParams({ 
		@ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
		@ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
		@ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderSaleSupportRecord", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<OrderSaleSupportRecord>> findByPage( 
		@RequestParam(defaultValue="0") int pageNo,  
		@RequestParam(defaultValue="10") int pageSize, 
		@RequestBody(required=false) QueryParamWapper wapper) {
        OrderSaleSupportRecordExample example = new OrderSaleSupportRecordExample();
        example.setPageView(new PageView<OrderSaleSupportRecord>(pageNo, pageSize));
        
        OrderSaleSupportRecordExample.Criteria criteria = example.createCriteria();
        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<OrderSaleSupportRecord> pageData = this.orderSaleSupportRecordService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}