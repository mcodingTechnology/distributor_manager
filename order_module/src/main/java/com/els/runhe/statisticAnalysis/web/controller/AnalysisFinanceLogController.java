package com.els.runhe.statisticAnalysis.web.controller;

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
import com.els.runhe.statisticAnalysis.entity.AnalysisFinanceLog;
import com.els.runhe.statisticAnalysis.entity.AnalysisFinanceLogExample;
import com.els.runhe.statisticAnalysis.service.AnalysisFinanceLogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value="财务流水")
@Controller
@RequestMapping("analysisFinanceLog")
public class AnalysisFinanceLogController {
    @Resource
    protected AnalysisFinanceLogService analysisFinanceLogService;

    @ApiOperation(httpMethod="POST", value="创建财务流水")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody AnalysisFinanceLog analysisFinanceLog) {
        this.analysisFinanceLogService.addObj(analysisFinanceLog);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑财务流水")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody AnalysisFinanceLog analysisFinanceLog) {
        if (analysisFinanceLog.getId() == null || analysisFinanceLog.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.analysisFinanceLogService.modifyObj(analysisFinanceLog);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除财务流水")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.analysisFinanceLogService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询财务流水")
    @ApiImplicitParams({ 
		@ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
		@ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
		@ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 AnalysisFinanceLog", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<AnalysisFinanceLog>> findByPage( 
		@RequestParam(defaultValue="0") int pageNo,  
		@RequestParam(defaultValue="10") int pageSize, 
		@RequestBody(required=false) QueryParamWapper wapper) {
        AnalysisFinanceLogExample example = new AnalysisFinanceLogExample();
        example.setPageView(new PageView<AnalysisFinanceLog>(pageNo, pageSize));
        
        AnalysisFinanceLogExample.Criteria criteria = example.createCriteria();
        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<AnalysisFinanceLog> pageData = this.analysisFinanceLogService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}