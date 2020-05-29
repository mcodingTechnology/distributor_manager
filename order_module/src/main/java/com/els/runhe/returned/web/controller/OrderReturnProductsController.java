package com.els.runhe.returned.web.controller;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.ResponseCode;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.returned.entity.OrderReturnProducts;
import com.els.runhe.returned.entity.OrderReturnProductsExample;
import com.els.runhe.returned.service.OrderReturnProductsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="退货单关联表")
@Controller
@RequestMapping("orderReturnProducts")
public class OrderReturnProductsController {
    @Resource
    protected OrderReturnProductsService orderReturnProductsService;

   /* @ApiOperation(httpMethod="POST", value="创建退货单关联表")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody OrderReturnProducts orderReturnProducts) {
        this.orderReturnProductsService.addObj(orderReturnProducts);
        return ResponseResult.success();
    }*/

    /*@ApiOperation(httpMethod="POST", value="编辑退货单关联表")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody OrderReturnProducts orderReturnProducts) {
        if (orderReturnProducts.getId() == null || orderReturnProducts.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.orderReturnProductsService.modifyObj(orderReturnProducts);
        return ResponseResult.success();
    }*/

    /*@ApiOperation(httpMethod="POST", value="删除退货单关联表")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.orderReturnProductsService.deleteObjById(id);
        return ResponseResult.success();
    }*/

    @ApiOperation(httpMethod="POST", value="查询退货单关联表")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderReturnProducts", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<OrderReturnProducts>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OrderReturnProductsExample example = new OrderReturnProductsExample();
        example.setPageView(new PageView<OrderReturnProducts>(pageNo, pageSize));
        
        if (wapper != null) {
            OrderReturnProductsExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<OrderReturnProducts> pageData = this.orderReturnProductsService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}