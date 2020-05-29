package com.els.runhe.warehouse.web.controller;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.ResponseCode;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.warehouse.entity.StockSafetyLog;
import com.els.runhe.warehouse.entity.StockSafetyLogExample;
import com.els.runhe.warehouse.service.StockSafetyLogService;
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

@Api(value="安全库存流水")
@Controller
@RequestMapping("stockSafetyLog")
public class StockSafetyLogController {
    @Resource
    protected StockSafetyLogService stockSafetyLogService;

    @ApiOperation(httpMethod="POST", value="创建安全库存流水")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody StockSafetyLog stockSafetyLog) {
        this.stockSafetyLogService.addObj(stockSafetyLog);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑安全库存流水")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody StockSafetyLog stockSafetyLog) {
        if (StringUtils.isBlank(stockSafetyLog.getId())) {
            throw new CommonException("id 为空，保存失败");
        }
        this.stockSafetyLogService.modifyObj(stockSafetyLog);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除安全库存流水")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) String id) {
        if (StringUtils.isBlank(id)) {
            throw new CommonException("删除失败,id不能为空");
        }
        this.stockSafetyLogService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询安全库存流水")
    @ApiImplicitParams({ 
		@ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
		@ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
		@ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 StockSafetyLog", paramType = "body", dataType = "QueryParamWapper" )  
	}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<StockSafetyLog>> findByPage( 
		@RequestParam(defaultValue="0") int pageNo,  
		@RequestParam(defaultValue="10") int pageSize, 
		@RequestBody(required=false) QueryParamWapper wapper) {
        StockSafetyLogExample example = new StockSafetyLogExample();
        example.setPageView(new PageView<StockSafetyLog>(pageNo, pageSize));
        
        StockSafetyLogExample.Criteria criteria = example.createCriteria();
        if (wapper != null) {
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        example.setOrderByClause("CREATE_TIME DESC");
        PageView<StockSafetyLog> pageData = this.stockSafetyLogService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}