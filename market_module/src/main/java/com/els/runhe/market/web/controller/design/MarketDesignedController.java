package com.els.runhe.market.web.controller.design;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.ResponseCode;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.market.entity.design.MarketDesigned;
import com.els.runhe.market.entity.design.MarketDesignedExample;
import com.els.runhe.market.service.design.MarketDesignedService;
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

@Api(value="设计资料")
@Controller
@RequestMapping("marketDesigned")
public class MarketDesignedController {
    @Resource
    protected MarketDesignedService marketDesignedService;

    /*@ApiOperation(httpMethod="POST", value="创建设计资料信息表")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(@RequestBody MarketDesigned marketDesigned) {
        this.marketDesignedService.addObj(marketDesigned);
        return ResponseResult.success();
    }*/

    /*@ApiOperation(httpMethod="POST", value="编辑设计资料信息表")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody MarketDesigned marketDesigned) {
        if (marketDesigned.getId() == null || marketDesigned.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.marketDesignedService.modifyObj(marketDesigned);
        return ResponseResult.success();
    }*/

    @ApiOperation(httpMethod="POST", value="删除设计资料信息")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.marketDesignedService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询设计资料信息")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 MarketDesigned", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<MarketDesigned>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        MarketDesignedExample example = new MarketDesignedExample();
        example.setPageView(new PageView<MarketDesigned>(pageNo, pageSize));
        
        if (wapper != null) {
            MarketDesignedExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        
        PageView<MarketDesigned> pageData = this.marketDesignedService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}