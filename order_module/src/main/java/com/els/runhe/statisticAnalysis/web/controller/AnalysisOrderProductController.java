package com.els.runhe.statisticAnalysis.web.controller;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderProduct;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderProductExample;
import com.els.runhe.statisticAnalysis.service.AnalysisOrderProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value="对账订单行项目")
@Controller
@RequestMapping("analysisOrderProduct")
public class AnalysisOrderProductController {
    @Resource
    protected AnalysisOrderProductService analysisOrderProductService;

    @ApiOperation(httpMethod="POST", value="创建对账订单行项目")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody AnalysisOrderProduct analysisOrderProduct) {
        this.analysisOrderProductService.addObj(analysisOrderProduct);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑对账订单行项目")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody AnalysisOrderProduct analysisOrderProduct) {
        if (StringUtils.isBlank(analysisOrderProduct.getId())) {
            throw new CommonException("id 为空，保存失败");
        }
        this.analysisOrderProductService.modifyObj(analysisOrderProduct);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除对账订单行项目")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.analysisOrderProductService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询对账订单行项目")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 AnalysisOrderProduct", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<AnalysisOrderProduct>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        AnalysisOrderProductExample example = new AnalysisOrderProductExample();
        example.setPageView(new PageView<AnalysisOrderProduct>(pageNo, pageSize));
        
        if (wapper != null) {
            AnalysisOrderProductExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<AnalysisOrderProduct> pageData = this.analysisOrderProductService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}