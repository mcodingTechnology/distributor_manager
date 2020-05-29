package com.els.runhe.warehouse.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
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
import com.els.base.utils.excel.ExcelUtils;
import com.els.base.utils.excel.TitleAndModelKey;
import com.els.runhe.warehouse.entity.StockSerial;
import com.els.runhe.warehouse.entity.StockSerialExample;
import com.els.runhe.warehouse.entity.StockSerialToExcel;
import com.els.runhe.warehouse.service.StockSerialService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jxl.write.WritableWorkbook;

@Api(value = "库存模块-库存流水管理")
@Controller
@RequestMapping("stockSerial")
public class StockSerialController {
	@Resource
	protected StockSerialService stockSerialService;

	@ApiOperation(httpMethod = "POST", value = "创建库存流水")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody StockSerial stockSerial) {
		this.stockSerialService.addObj(stockSerial);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑库存流水")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody StockSerial stockSerial) {
		if (StringUtils.isBlank(stockSerial.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.stockSerialService.modifyObj(stockSerial);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除库存流水")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.stockSerialService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询库存流水")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 StockSerial", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<StockSerial>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		StockSerialExample example = new StockSerialExample();
		example.setPageView(new PageView<StockSerial>(pageNo, pageSize));
		example.setOrderByClause("CREATE_TIME DESC");

		if (wapper != null) {
			StockSerialExample.Criteria criteria = example.createCriteria();
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<StockSerial> pageData = this.stockSerialService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}
	
	
	@ApiOperation(value = "导出Excel", httpMethod = "POST")
	@RequestMapping(value = "service/exportDateToExcel")
	@ResponseBody
	public ResponseResult<String> exportDateToExcel(@RequestParam(required = false) String queryParams,
			HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {

		StockSerialToExcel stockSerialToExcel = new StockSerialToExcel();
		if(StringUtils.isNotEmpty(queryParams)){
			stockSerialToExcel.setQueryPeriod(queryParams);
		}
		List<StockSerialToExcel> list = this.stockSerialService.queryToExcel(stockSerialToExcel);
		try {
			List<TitleAndModelKey> titleAndModelKeys = this.createExcelHeader();

			String dateStr = DateFormatUtils.format(new Date(), "yyyyMMdd");
			setDownLoadHeader(response, MessageFormat.format("盘点单-{0}.xls", dateStr));
			OutputStream outputStream = response.getOutputStream();
			WritableWorkbook writableWorkbook = ExcelUtils.exportDataToExcel(outputStream, titleAndModelKeys, list, "盘点单", "", 0);
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
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("品名", "productName",true));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("期初数量", "beginningAmount"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("当前入库数量", "originAmount",true));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("当期出库数量", "offsetAmount",true));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("系统已发仓库未发", "sysShippedAmount"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("系统未发仓库已发", "sysNotShippedAmount"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("系统已入仓库未入", "sysInStorageAmount"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("系统未入仓库已入", "sysNotInStorageAmount"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("应结存数量", "balanceAmount"));
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
}