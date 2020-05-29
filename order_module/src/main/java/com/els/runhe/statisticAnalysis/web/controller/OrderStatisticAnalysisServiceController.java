package com.els.runhe.statisticAnalysis.web.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.company.utils.CompanyUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.project.ProjectUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.base.utils.excel.BigDecimalConverter;
import com.els.base.utils.excel.DateConverter;
import com.els.base.utils.excel.ExcelUtils;
import com.els.base.utils.excel.TitleAndModelKey;
import com.els.runhe.statisticAnalysis.entity.AnalysisArea;
import com.els.runhe.statisticAnalysis.entity.AreaSummaryTable;
import com.els.runhe.statisticAnalysis.entity.AreaYieldRateReport;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysis;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysisCharts;
import com.els.runhe.statisticAnalysis.entity.OrderStatisticAnalysisExample;
import com.els.runhe.statisticAnalysis.entity.ProductAnalysisChartData;
import com.els.runhe.statisticAnalysis.service.OrderStatisticAnalysisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jxl.write.WritableWorkbook;

@Api(value="统计分析")
@Controller
@RequestMapping("orderStatisticAnalysis")
public class OrderStatisticAnalysisServiceController {
	
	@Autowired
	private OrderStatisticAnalysisService orderStatisticAnalysisService;

    @ApiOperation(httpMethod="POST", value="查询经营业绩")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderStatisticAnalysis", paramType = "body", dataType = "QueryParamWapper" )  
    }) 
    @RequestMapping("service/findByPage")    
    @ResponseBody
    public ResponseResult<PageView<OrderStatisticAnalysis>> findByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OrderStatisticAnalysisExample example = new OrderStatisticAnalysisExample();
        example.setPageView(new PageView<OrderStatisticAnalysis>(pageNo, pageSize));
        List<String> companyIds = new ArrayList<String>();
        String currentCompanyId = "";
        
        if (wapper != null) {
        	OrderStatisticAnalysisExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
            if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
    			//如果润禾
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
    			criteria.andIdIn(companyIds);
    		}else{
    			return ResponseResult.success(new PageView<OrderStatisticAnalysis>());
    		}
        }
        example.setOrderByClause("tos.add_time DESC");
        PageView<OrderStatisticAnalysis> pageData = this.orderStatisticAnalysisService.queryObjByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(value = "导出Excel", httpMethod = "POST")
    @RequestMapping(value = "service/exportDate")    
    @ResponseBody
    public ResponseResult<String> exportDate( 
     @RequestParam String queryDate,
     @RequestParam String categoryId,
     @RequestParam String province,
     @RequestParam String city,
     @RequestParam String district,
	 HttpServletResponse response) {
        OrderStatisticAnalysisExample example = new OrderStatisticAnalysisExample();
        example.setPageView(new PageView<OrderStatisticAnalysis>(0, 100000));
        List<String> companyIds = new ArrayList<String>();
        String currentCompanyId = "";
        
    	OrderStatisticAnalysisExample.Criteria criteria = example.createCriteria();
    	
    	if(StringUtils.isNotEmpty(queryDate)){
    		criteria.andQueryDateEqualTo(queryDate);
		}
    	if(StringUtils.isNotEmpty(categoryId)){
    		criteria.andCategoryIdEqualTo(categoryId);
		}
    	if(StringUtils.isNotEmpty(province)){
    		criteria.andProvinceEqualTo(province);
		}
    	if(StringUtils.isNotEmpty(city)){
    		criteria.andCityEqualTo(city);
		}
    	if(StringUtils.isNotEmpty(district)){
    		criteria.andDistrictEqualTo(district);
		}
    	
        if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
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
			criteria.andIdIn(companyIds);
		}else{
			return null;
		}
		
        example.setOrderByClause("tos.add_time DESC");
        PageView<OrderStatisticAnalysis> pageData = this.orderStatisticAnalysisService.queryObjByPage(example);
        List<OrderStatisticAnalysis> list = pageData.getQueryResult();
        
        try {
			List<TitleAndModelKey> titleAndModelKeys = this.createExcelHeader();

			String dateStr = DateFormatUtils.format(new Date(), "yyyyMMdd");
			setDownLoadHeader(response, MessageFormat.format("经营报表-{0}.xls", dateStr));
			OutputStream outputStream = response.getOutputStream();

			WritableWorkbook writableWorkbook = ExcelUtils.exportDataToExcel(outputStream, titleAndModelKeys, list, "经营报表", "", 0);
			writableWorkbook.write();
			outputStream.flush();
			writableWorkbook.close();
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException(e.getMessage());
		}
        
        return null;
    }
    
    private List<TitleAndModelKey> createExcelHeader() {

		List<TitleAndModelKey> titleAndModelKeys = new ArrayList<TitleAndModelKey>();
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("单据编号", "orderNo"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("下单时间", "addTime"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("状态", "statusName"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("客户编码", "companyId"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("经销商名称", "companyName"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("类别", "categoryName"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("大区", "areaName"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("所属省", "province"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("所属市", "city"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("货品名称", "productName"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("货品编码", "productId"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("数量", "nums"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("单位", "productUnit"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("供货价", "productSupplyPrice"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("订货金额", "amountTotal"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("规格", "productSpec"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("备注", "remark"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("制单人", "userName"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("营运审批意见", "taskText"));
		return titleAndModelKeys;
	}
    
    private void setDownLoadHeader(HttpServletResponse response, String fileName) throws UnsupportedEncodingException {
		response.reset();
		StringBuffer header = new StringBuffer("attachment;");
		header.append("filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
		response.setHeader("Content-Disposition", header.toString());
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/x-msdownload;");
	}
    
    @ApiOperation(httpMethod="POST", value="经营业绩图表")
    @RequestMapping("service/queryChartData")
    @ResponseBody
    public ResponseResult<OrderStatisticAnalysisCharts> queryChartData(HttpServletRequest request){
    	List<String> companyIds = new ArrayList<String>();
    	String currentCompanyId = "";
		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
			currentCompanyId = CompanyUtils.currentCompanyId();
		}
		if (StringUtils.isEmpty(currentCompanyId)) {
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
		}else {
			companyIds.add(currentCompanyId);
		}
    	OrderStatisticAnalysisCharts charts = this.orderStatisticAnalysisService.queryChartData(request, companyIds);
    	return ResponseResult.success(charts);
    }
    
    
    @ApiOperation(httpMethod="POST", value="查询经销商排名")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderStatisticAnalysis", paramType = "body", dataType = "QueryParamWapper" )  
    }) 
    @RequestMapping("service/findDealerRankingByPage")
    @ResponseBody
    public ResponseResult<PageView<OrderStatisticAnalysis>> findDealerRankingByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OrderStatisticAnalysisExample example = new OrderStatisticAnalysisExample();
        example.setPageView(new PageView<OrderStatisticAnalysis>(pageNo, pageSize));
        if (wapper != null) {
        	OrderStatisticAnalysisExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
            
            List<String> companyIds = new ArrayList<String>();
            String currentCompanyId = "";
            if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
            	//如果润禾
            	currentCompanyId = CompanyUtils.currentCompanyId();
            }
            if (StringUtils.isEmpty(currentCompanyId)) {
            	// 查询当前用户所分配的区域
            	String userId = SpringSecurityUtils.getLoginUserId();
            	companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
            }else {
            	companyIds.add(currentCompanyId);
            }
            if(companyIds.size() > 0 ){
            	StringBuilder ids = new StringBuilder("");
                for(String id : companyIds){
                	ids.append("'"+id+"',");
                }
                if(ids.length()>1){
                    example.setCompanyIds("where tbc.id in ("+ids.substring(0, ids.length()-1)+")");
                }
            	criteria.andIdIn(companyIds);
            } else {
            	example.setCompanyIds("where 1 > 1");
            }
        }
        example.setOrderByClause("SUM(top.amount_total) DESC");
        PageView<OrderStatisticAnalysis> pageData = this.orderStatisticAnalysisService.findDealerRankingByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(httpMethod="POST", value="查询产品排名")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "categoryId", required = false, value = "产品类目", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderStatisticAnalysis", paramType = "body", dataType = "QueryParamWapper" )  
    }) 
    @RequestMapping("service/findProductRankingByPage")
    @ResponseBody
    public ResponseResult<PageView<OrderStatisticAnalysis>> findProductRankingByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestParam String byCategoryId,
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OrderStatisticAnalysisExample example = new OrderStatisticAnalysisExample();
        example.setPageView(new PageView<OrderStatisticAnalysis>(pageNo, pageSize));
        if (wapper != null) {
        	OrderStatisticAnalysisExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
            List<String> companyIds = new ArrayList<String>();
        	String currentCompanyId = "";
    		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
    			//如果润禾
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
    			criteria.andPurCompanyIdIn(companyIds);
    		}else{
    			return ResponseResult.success(new PageView<OrderStatisticAnalysis>());
    		}
        }
        example.setOrderByClause("sum(top.amount_total) DESC");
        if(StringUtils.isNotEmpty(byCategoryId)){
        	example.setCategoryId(byCategoryId);
        }
        PageView<OrderStatisticAnalysis> pageData = this.orderStatisticAnalysisService.findProductRankingByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(httpMethod="POST", value="产品发货量")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),
	 @ApiImplicitParam( name = "productId", required = false, value = "产品id", paramType = "query", dataType = "String", defaultValue = "" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderStatisticAnalysis", paramType = "body", dataType = "QueryParamWapper" )  
    }) 
    @RequestMapping("service/findProductDeliveryByPage")
    @ResponseBody
    public ResponseResult<PageView<OrderStatisticAnalysis>> findProductDeliveryByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestParam String productId,
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OrderStatisticAnalysisExample example = new OrderStatisticAnalysisExample();
        example.setPageView(new PageView<OrderStatisticAnalysis>(pageNo, pageSize));
        if (wapper != null) {
        	OrderStatisticAnalysisExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
            List<String> companyIds = new ArrayList<String>();
        	String currentCompanyId = "";
    		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
    			//如果润禾
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
    			criteria.andPurCompanyIdIn(companyIds);
    		}else{
    			return ResponseResult.success(new PageView<OrderStatisticAnalysis>());
    		}
        }
        if(StringUtils.isNotEmpty(productId)){
        	example.setId(productId);
        }
        example.setOrderByClause("top.delivery_time DESC");
        PageView<OrderStatisticAnalysis> pageData = this.orderStatisticAnalysisService.findProductDeliveryByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(httpMethod="POST", value="月度销售业绩图表")
    @RequestMapping("service/queryMonthChartData")
    @ResponseBody
    public ResponseResult<OrderStatisticAnalysisCharts> queryMonthChartData(HttpServletRequest request){
    	List<String> companyIds = new ArrayList<String>();
    	String currentCompanyId = "";
		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
			currentCompanyId = CompanyUtils.currentCompanyId();
		}
		if (StringUtils.isEmpty(currentCompanyId)) {
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
		}else {
			companyIds.add(currentCompanyId);
		}
    	OrderStatisticAnalysisCharts charts = this.orderStatisticAnalysisService.queryMonthChartData(request, companyIds);
    	return ResponseResult.success(charts);
    }
    
    @ApiOperation(httpMethod="POST", value="查询销售支付金额")
    @RequestMapping("service/queryPayAmountData")
    @ResponseBody
    public ResponseResult<OrderStatisticAnalysis> queryPayAmountData(HttpServletRequest request){
    	List<String> companyIds = new ArrayList<String>();
    	String currentCompanyId = "";
		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
			currentCompanyId = CompanyUtils.currentCompanyId();
		}
		if (StringUtils.isEmpty(currentCompanyId)) {
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
		}else {
			companyIds.add(currentCompanyId);
		}
    	OrderStatisticAnalysis charts = this.orderStatisticAnalysisService.queryPayAmountData(request, companyIds);
    	return ResponseResult.success(charts);
    }
    
    @ApiOperation(httpMethod="POST", value="查询产品分析数据")
    @ApiImplicitParams({ 
   	 @ApiImplicitParam( name = "startDate",required = false,value = "开始时间", paramType = "query", dataType = "String", defaultValue = "" ),  
   	 @ApiImplicitParam( name = "endDate", required = false, value = "结束时间", paramType = "query", dataType = "String", defaultValue = "" ),  
    }) 
    @RequestMapping("service/queryProductChartData")
    @ResponseBody
    public ResponseResult<ProductAnalysisChartData> queryProductChartData(
    		@RequestParam(defaultValue="") String startDate,  
    		 @RequestParam(defaultValue="") String endDate){
    	List<String> companyIds = new ArrayList<String>();
    	String currentCompanyId = "";
		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
			currentCompanyId = CompanyUtils.currentCompanyId();
		}
		if (StringUtils.isEmpty(currentCompanyId)) {
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
		}else {
			companyIds.add(currentCompanyId);
		}
    	ProductAnalysisChartData charts = this.orderStatisticAnalysisService.queryProductChartData(companyIds, startDate, endDate);
    	
    	return ResponseResult.success(charts);
    }
    
    @ApiOperation(httpMethod="POST", value="查询经营业绩")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 OrderStatisticAnalysis", paramType = "body", dataType = "QueryParamWapper" )  
    }) 
    @RequestMapping("service/findAccountingByPage")    
    @ResponseBody
    public ResponseResult<PageView<OrderStatisticAnalysis>> findAccountingByPage( 
	 @RequestParam(defaultValue="0") int pageNo,  
	 @RequestParam(defaultValue="10") int pageSize, 
	 @RequestBody(required=false) QueryParamWapper wapper) {
        OrderStatisticAnalysisExample example = new OrderStatisticAnalysisExample();
        example.setPageView(new PageView<OrderStatisticAnalysis>(pageNo, pageSize));
        
        if (wapper != null) {
        	OrderStatisticAnalysisExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
        example.setOrderByClause("tos.add_time DESC");
        PageView<OrderStatisticAnalysis> pageData = this.orderStatisticAnalysisService.findAccountingByPage(example);
        return ResponseResult.success(pageData);
    }
    
    @ApiOperation(httpMethod="POST", value="查询各大区回款达成率")
    @RequestMapping("service/queryAreaYieldRate")
    @ResponseBody
    public ResponseResult<List<AreaYieldRateReport>> queryAreaYieldRate(HttpServletRequest request){
    	List<String> companyIds = new ArrayList<String>();
    	String currentCompanyId = "";
		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
			currentCompanyId = CompanyUtils.currentCompanyId();
		}
		if (StringUtils.isEmpty(currentCompanyId)) {
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
		}else {
			companyIds.add(currentCompanyId);
		}
		List<AreaYieldRateReport> charts = new ArrayList<AreaYieldRateReport>();
		if (CollectionUtils.isNotEmpty(companyIds)) {
			charts = this.orderStatisticAnalysisService.queryAreaYieldRate(request,companyIds);
		}
    	return ResponseResult.success(charts);
    }
    
    @ApiOperation(httpMethod="POST", value="查询各省份回款达成率")
    @RequestMapping("service/queryProvinceYieldRate")
    @ResponseBody
    public ResponseResult<List<AreaYieldRateReport>> queryProvinceYieldRate(HttpServletRequest request){
    	List<String> companyIds = new ArrayList<String>();
    	String currentCompanyId = "";
		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
			currentCompanyId = CompanyUtils.currentCompanyId();
		}
		if (StringUtils.isEmpty(currentCompanyId)) {
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
		}else {
			companyIds.add(currentCompanyId);
		}
		List<AreaYieldRateReport> charts = new ArrayList<AreaYieldRateReport>();
		if (CollectionUtils.isNotEmpty(companyIds)) {
			charts = this.orderStatisticAnalysisService.queryProvinceYieldRate(request,companyIds);
		}
    	return ResponseResult.success(charts);
    }
    
    @ApiOperation(httpMethod="POST", value="查询区域合计汇总表")
    @RequestMapping("service/queryAreaSummary")
    @ResponseBody
    public ResponseResult<List<AreaSummaryTable>> queryAreaSummary(HttpServletRequest request){
    	List<String> companyIds = new ArrayList<String>();
    	String currentCompanyId = "";
		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
			currentCompanyId = CompanyUtils.currentCompanyId();
		}
		if (StringUtils.isEmpty(currentCompanyId)) {
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
		}else {
			companyIds.add(currentCompanyId);
		}
		List<AreaSummaryTable> charts = new ArrayList<AreaSummaryTable>();
		if (CollectionUtils.isNotEmpty(companyIds)) {
			charts = this.orderStatisticAnalysisService.queryAreaSummary(request, companyIds);
		}
    	return ResponseResult.success(charts);
    }
    
    @ApiOperation(httpMethod="POST", value="查询营销明细报表")
    @RequestMapping("service/querySalesDetailReport") 
    @ResponseBody
    public ResponseResult<List<AreaSummaryTable>> querySalesDetailReport(HttpServletRequest request){
    	List<String> companyIds = new ArrayList<String>();
    	String currentCompanyId = "";
		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
			currentCompanyId = CompanyUtils.currentCompanyId();
		}
		if (StringUtils.isEmpty(currentCompanyId)) {
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
		}else {
			companyIds.add(currentCompanyId);
		}
		List<AreaSummaryTable> charts = new ArrayList<AreaSummaryTable>();
		if (CollectionUtils.isNotEmpty(companyIds)) {
			charts = this.orderStatisticAnalysisService.querySalesDetailReport(request,companyIds);
		}
    	return ResponseResult.success(charts);
    }
    
    @ApiOperation(httpMethod="POST", value="区域统计")
    @RequestMapping("service/queryAreaStatistics")
    @ResponseBody
    public ResponseResult<List<AnalysisArea>> queryAreaStatistics(HttpServletRequest request){
    	List<String> companyIds = new ArrayList<String>();
    	String currentCompanyId = "";
		if (!CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
			//如果润禾
			currentCompanyId = CompanyUtils.currentCompanyId();
		}
		if (StringUtils.isEmpty(currentCompanyId)) {
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
			companyIds = orderStatisticAnalysisService.queryCompanyList(userId);
		}else {
			companyIds.add(currentCompanyId);
		}
		List<AnalysisArea> analysisAreas = new ArrayList<AnalysisArea>();
		if (CollectionUtils.isNotEmpty(companyIds)) {
			analysisAreas = this.orderStatisticAnalysisService.queryAreaStatistics(request, companyIds);
		}
    	return ResponseResult.success(analysisAreas);
    }
    
    @ApiOperation(httpMethod="POST", value="产品统计")
    @RequestMapping("service/queryProductStatistics")
    @ResponseBody
    public ResponseResult<List<AnalysisArea>> queryProductStatistics(HttpServletRequest request){
    	List<AnalysisArea> analysisAreas = this.orderStatisticAnalysisService.queryProductStatistics(request);
    	return ResponseResult.success(analysisAreas);
    }
}