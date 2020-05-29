package com.els.runhe.statisticAnalysis.web.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.company.utils.CompanyUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.project.ProjectUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrder;
import com.els.runhe.statisticAnalysis.entity.AnalysisOrderExample;
import com.els.runhe.statisticAnalysis.service.AnalysisOrderService;
import com.els.runhe.statisticAnalysis.service.OrderStatisticAnalysisService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value="对账单")
@Controller
@RequestMapping("analysisOrder")
public class AnalysisOrderController {
    @Resource
    protected AnalysisOrderService analysisOrderService;
    @Resource
	private OrderStatisticAnalysisService orderStatisticAnalysisService;

    @ApiOperation(httpMethod="POST", value="创建对账单")
    @RequestMapping("service/create")
    @ResponseBody
    public ResponseResult<String> create(HttpServletRequest request) {
        this.analysisOrderService.saveAnalysisOrder();
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="编辑对账单")
    @RequestMapping("service/edit")
    @ResponseBody
    public ResponseResult<String> edit(@RequestBody AnalysisOrder analysisOrder) {
        if (analysisOrder.getId() == null || analysisOrder.getId() <=0) {
            throw new CommonException("id 为空，保存失败");
        }
        this.analysisOrderService.modifyObj(analysisOrder);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="删除对账单")
    @RequestMapping("service/deleteById")
    @ResponseBody
    public ResponseResult<String> deleteById(@RequestParam(required=true) int id) {
        this.analysisOrderService.deleteObjById(id);
        return ResponseResult.success();
    }

    @ApiOperation(httpMethod="POST", value="查询对账单")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 AnalysisOrder", paramType = "body", dataType = "QueryParamWapper" )  
}) 
    @RequestMapping("service/findByPage")
    @ResponseBody
    public ResponseResult<PageView<AnalysisOrder>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        AnalysisOrderExample example = new AnalysisOrderExample();
        example.setPageView(new PageView<AnalysisOrder>(pageNo, pageSize));
        
        if (wapper != null) {
            AnalysisOrderExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
            
            List<String> companyIds = new ArrayList<String>();
            String currentCompanyId = "";
            if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
    			currentCompanyId = CompanyUtils.currentCompanyId();
    		}
    		if (StringUtils.isEmpty(currentCompanyId)) {
    			// 查询当前用户所分配的区域
    	    	String userId = SpringSecurityUtils.getLoginUserId();
    			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
    		}else {
    			companyIds.add(currentCompanyId);
    		}
    		
    		if (CollectionUtils.isNotEmpty(companyIds)) {
    			criteria.andCompanyIdIn(companyIds);
    		}else{
    			return ResponseResult.success(new PageView<AnalysisOrder>());
    		}
        }
        example.setOrderByClause("create_time DESC");
        PageView<AnalysisOrder> pageData = this.analysisOrderService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
}