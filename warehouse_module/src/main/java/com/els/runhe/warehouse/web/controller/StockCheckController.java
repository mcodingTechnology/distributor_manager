package com.els.runhe.warehouse.web.controller;

import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amazonaws.util.IOUtils;
import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.company.entity.Company;
import com.els.base.company.utils.CompanyUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.entity.user.User;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.warehouse.entity.StockCheck;
import com.els.runhe.warehouse.entity.StockCheckExample;
import com.els.runhe.warehouse.model.StockCheckInfo;
import com.els.runhe.warehouse.service.StockCheckService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "库存模块-盘点单管理")
@Controller
@RequestMapping("stockCheck")
public class StockCheckController {

	// private Logger logger = LogManager.getLogger(this.getClass());
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	protected StockCheckService stockCheckService;

	@ApiOperation(httpMethod = "POST", value = "创建盘点单")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody StockCheck stockCheck) {
		this.stockCheckService.addObj(stockCheck);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑盘点单")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody StockCheck stockCheck) {
		if (StringUtils.isBlank(stockCheck.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.stockCheckService.modifyObj(stockCheck);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除盘点单")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.stockCheckService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询盘点单")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 StockCheck", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<StockCheck>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		StockCheckExample example = new StockCheckExample();
		example.setPageView(new PageView<StockCheck>(pageNo, pageSize));
		example.setOrderByClause("CREATE_TIME DESC");

		StockCheckExample.Criteria criteria = example.createCriteria();
		criteria.andCompanyIdEqualTo(CompanyUtils.currentCompanyId());
		if (wapper != null) {
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<StockCheck> pageData = this.stockCheckService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}

	@ApiOperation(httpMethod = "POST", value = "新增盘点单")
	@RequestMapping("service/add")
	@ResponseBody
	public ResponseResult<?> add(@RequestBody StockCheckInfo req) {
		stockCheckService.add(req);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "GET", value = "下载库存盘点模板")
	@RequestMapping(value = "service/downloadTemplate")
	public ResponseEntity<byte[]> downloadTemplate(HttpServletResponse response) {
		ResponseEntity<byte[]> res = null;
		try {
			long start = System.currentTimeMillis();

			// 文件处理
			String fileName = URLEncoder.encode("stock_check_template.xlsx", "UTF-8");
			String filePath = "/files/" + fileName;
			InputStream in = this.getClass().getResourceAsStream(filePath);
			byte[] bytes = IOUtils.toByteArray(in);
			// byte[] bytes = FileUtils.readFileToByteArray(new File(filePath));

			// 响应头信息处理
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("file", fileName);

			// 返回处理
			res = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.CREATED);

			long end = System.currentTimeMillis();
			long spend = end - start;
			logger.info(String.format("下载库存盘点模板消耗时间=%s毫秒", spend));
		} catch (Throwable t) {
			logger.error("下载库存盘点模板出错", t);
			response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
		}
		return res;
	}

	@ApiOperation(value = "批量导入盘点单", httpMethod = "POST")
	@ResponseBody
	@RequestMapping(value = { "service/import" })
	public ResponseResult<?> importData(MultipartHttpServletRequest request, StockCheck req) throws Exception {
		Map<String, MultipartFile> fileMap = request.getFileMap();
		if (MapUtils.isEmpty(fileMap)) {
			throw new CommonException("导入文件为空", "file_isNull");
		}
		if (null == req) {
			throw new CommonException("请求信息为空");
		}

		Set<String> fileKeySet = fileMap.keySet();
		if (fileKeySet.size() > 1) {
			throw new CommonException("不接受多个文件", "file_upload_not_accepted");
		}

		long start = System.currentTimeMillis();

		MultipartFile file = null;

		Iterator<String> keyIterator = fileKeySet.iterator();
		while (keyIterator.hasNext()) {
			file = fileMap.get(keyIterator.next());
		}

		if (null == file) {
			throw new CommonException("找不到文件", "file_isNull");
		}

		// 设置用户信息
		Company company = CompanyUtils.currentCompany();
		User user = SpringSecurityUtils.getLoginUser();
		req.setCompanyId(company.getId());
		req.setCompanyName(company.getCompanyFullName());
		req.setUserId(user.getId());

		stockCheckService.importData(file, req);

		long end = System.currentTimeMillis();
		long spend = end - start;
		logger.info(String.format("批量导入盘点单消耗时间=%s毫秒", spend));

		return ResponseResult.success();
	}

}