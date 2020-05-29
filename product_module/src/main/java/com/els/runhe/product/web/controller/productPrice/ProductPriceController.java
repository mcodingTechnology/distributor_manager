package com.els.runhe.product.web.controller.productPrice;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.els.base.auth.entity.Role;
import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.company.entity.Company;
import com.els.base.company.entity.CompanyExample;
import com.els.base.company.entity.UserArea;
import com.els.base.company.service.CompanyService;
import com.els.base.company.utils.CompanyUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.entity.user.User;
import com.els.base.core.exception.CommonException;
import com.els.base.core.service.user.UserService;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.project.ProjectUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.base.utils.excel.BigDecimalConverter;
import com.els.base.utils.excel.DateConverter;
import com.els.base.utils.excel.ExcelUtils;
import com.els.base.utils.excel.TitleAndModelKey;
import com.els.base.utils.json.JsonUtils;
import com.els.runhe.product.entity.product.Product;
import com.els.runhe.product.entity.product.ProductExample;
import com.els.runhe.product.entity.productPrice.ProductPrice;
import com.els.runhe.product.entity.productPrice.ProductPriceExample;
import com.els.runhe.product.service.product.ProductService;
import com.els.runhe.product.service.productPrice.ProductPriceService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jxl.write.WritableWorkbook;
@Api(value = "产品价格")
@Controller
@RequestMapping("productPrice")
public class ProductPriceController {
	@Resource
	protected ProductPriceService productPriceService;
	@Resource
	protected ProductService productService;
	@Resource
    protected CompanyService companyService;
	@Resource
    protected UserService userService;

	@ApiOperation(httpMethod = "POST", value = "创建产品价格")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody ProductPrice productPrice) {
		this.productPriceService.addObj(productPrice);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑产品价格")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody ProductPrice productPrice) {
		if (productPrice.getId() == null || productPrice.getId() <= 0) {
			throw new CommonException("id 为空，保存失败");
		}
		this.productPriceService.modifyObj(productPrice);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除产品价格")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(int id) {
		this.productPriceService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "GET", value = "查询产品价格")
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<ProductPrice>> findByPage(
			@ApiParam(name = "分页索引", defaultValue = "0") @RequestParam(defaultValue = "1") int pageNo,
			@ApiParam(name = "每页的数量", defaultValue = "10") @RequestParam(defaultValue = "10") int pageSize,
			@ApiParam(value = "查询条件") @RequestBody(required=false) QueryParamWapper wapper) {
		
		PageView<ProductPrice> pageView = new PageView<>(pageNo, pageSize);
		ProductPriceExample example = new ProductPriceExample();
		example.setPageView(pageView);
		
		ProductPriceExample.Criteria criteria = example.createCriteria();
		if (wapper != null ) {
			CriteriaUtils.addCriterion(criteria, wapper);
		}
		
		boolean isSupplier = false;
		List<Role> roleList = SpringSecurityUtils.getLoginUserRoleList();
    	for(int i=0; CollectionUtils.isNotEmpty(roleList) && i < roleList.size(); i++){
    		if (CompanyUtils.currentCompanyId().equals(ProjectUtils.getProject().getCompanyId())) {
    			//如果是润禾
    			isSupplier = true;
    			break;
			}
    	}
    	
    	if (!isSupplier) {
			criteria.andCompanyIdEqualTo(CompanyUtils.currentCompanyId());
		}else{
			// 区域权限
			// 查询当前用户所分配的区域
	    	String userId = SpringSecurityUtils.getLoginUserId();
	    	if(StringUtils.isNotEmpty(userId)){
	    		User user = this.userService.queryObjById(userId);
	    		if(StringUtils.isNotEmpty(user.getUserArea())){
	    			List<UserArea> userAreas = new ArrayList<UserArea>();
	    			try {
						userAreas = JsonUtils.convertCollection(user.getUserArea(), List.class, null, UserArea.class);
					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JsonMappingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	    			List<String> strings = new ArrayList<>();
	    			for(UserArea values : userAreas){
	    				strings.add(values.getId());
	    			}
	    			if(strings.size() > 0 ){
	    				String areaIds = strings.toString();
	    				areaIds = areaIds.substring(1, areaIds.length()-1);
	    				CompanyExample paramExample = new CompanyExample();
	        			CompanyExample.Criteria companyCriteria = paramExample.createCriteria(); 
	        			companyCriteria.andAreaOrId("AREA IN ("+areaIds+") OR CITY IN ("+areaIds+") OR PROVINCE IN ("+areaIds+") OR DISTRICT IN("+areaIds+")");
	        			List<Company> companyList = companyService.queryAllObjByExample(paramExample);
	        			List<String> companyStrings = new ArrayList<String>();
	        			for(Company company:companyList){
	        				companyStrings.add(company.getId());
	        			}
	        			if(companyStrings.size() > 0){
	        				criteria.andCompanyIdIn(companyStrings);
	        			}else {
	        				criteria.andNotCompanyId();
	        			}
	    			}else {
	    				criteria.andNotCompanyId();
	    			}
	    		}else{
	    			criteria.andNotCompanyId();
	    		}
	    	}else {
	    		criteria.andNotCompanyId();
	    	}
		}
		
		return ResponseResult.success(this.productPriceService.queryObjByPage(example));
	}

	@ApiOperation(httpMethod = "GET", value = "查询产品价格详细")
	@RequestMapping("service/findByProductId")
	@ResponseBody
	public ResponseResult<List<ProductPrice>> findByProductId(@ApiParam("产品id") int productId) {
		ProductPriceExample example = new ProductPriceExample();
		ProductPriceExample.Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		List<ProductPrice> list = this.productPriceService.queryAllObjByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			throw new CommonException("01");
		}
		return ResponseResult.success(list);
	}

	@ApiOperation(value = "导出Excel", httpMethod = "POST")
	@RequestMapping(value = "service/exportDateToExcel")
	@ResponseBody
	public ResponseResult<String> exportDateToExcel(@RequestParam(required = false) String queryParams,
			HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {

		ProductExample example = new ProductExample();
		List<Product> productList = this.productService.queryAllObjByExample(example);
		
		Date now = new Date();
		List<ProductPrice> list = new ArrayList<>(productList.size());
		for(Product product : productList){
			ProductPrice price = new ProductPrice();
			price.setProductName(product.getProductName());
			price.setProductBarCode(product.getBarCode());
			price.setProductUnit(product.getUnit());
			price.setProductSpec(product.getSpec());
			price.setNumFrom(1);
			price.setNumTo(99999);
			price.setPrice(BigDecimal.ZERO);
			price.setPriceForNextDealer(BigDecimal.ZERO);
			price.setValidDate(now);
			
			price.setNumberCode(product.getNumberCode());
			price.setProductSpec(product.getSpec());
			list.add(price);
		}

		try {
			List<TitleAndModelKey> titleAndModelKeys = this.createExcelHeader();

			String dateStr = DateFormatUtils.format(new Date(), "yyyyMMdd");
			setDownLoadHeader(response, MessageFormat.format("产品调整-{0}.xls", dateStr));
			OutputStream outputStream = response.getOutputStream();

			WritableWorkbook writableWorkbook = ExcelUtils.exportDataToExcel(outputStream, titleAndModelKeys, list, "价格表", "", 0);
			writableWorkbook.write();
			outputStream.flush();
			writableWorkbook.close();
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
//			response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
			throw new CommonException(e.getMessage());
		}

		return null;
	}
	
	@ApiOperation(value = "导入Excel", httpMethod = "POST")
	@RequestMapping(value = "service/importDateFromExcel")
	@ResponseBody
	public ResponseResult<String> importDateFromExcel(String companyCode,String companyName, MultipartHttpServletRequest request)  {

		Map<String, MultipartFile> fileMap = request.getFileMap();
		MultipartFile file = this.vaildFile(fileMap);

		List<TitleAndModelKey> titleAndModelKeys = this.createExcelHeader();

		List<ProductPrice> list;
		try {
			list = ExcelUtils.importExcelDataToMap(file.getInputStream(), 0, 1, 0, titleAndModelKeys, ProductPrice.class);
			for(int i=0; CollectionUtils.isNotEmpty(list) && i<list.size(); i++){
				list.get(i).setCompanyCode(companyCode);
				list.get(i).setCompanyName(companyName);
			}
			this.productPriceService.importData(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CommonException("导入异常：" + e.getMessage());
		}

		return ResponseResult.success();
	}
	
	private List<TitleAndModelKey> createExcelHeader() {

		List<TitleAndModelKey> titleAndModelKeys = new ArrayList<TitleAndModelKey>();
//		TitleAndModelKey companyCodeTAMK = ExcelUtils.createTitleAndModelKey("经销商编码*", "companyCode", true);
//		companyCodeTAMK.setDefaultValue(companyCode);
//		titleAndModelKeys.add(companyCodeTAMK);
//		
//		TitleAndModelKey companyNameTAMK = ExcelUtils.createTitleAndModelKey("经销商名称*", "companyName", true);
//		companyNameTAMK.setDefaultValue(companyName);
//		titleAndModelKeys.add(companyNameTAMK);
		
//		titleAndModelKeys.add(companyNameTAMK);
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("产品名称*", "productName",true));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("产品条形码*", "productBarCode", true));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("产品编码*", "numberCode",true));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("产品单位", "productUnit"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("产品规格", "productSpec"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("数量从*", "numFrom", true));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("数量至*", "numTo", true));
		
		BigDecimalConverter bigDecimalConverter = new BigDecimalConverter();
		TitleAndModelKey price = ExcelUtils.createTitleAndModelKey("订货价*", "price", true);
		price.setToObjConverter(bigDecimalConverter);
		price.setToStrConverter(bigDecimalConverter);
		titleAndModelKeys.add(price);
		
		TitleAndModelKey priceForNextDealer = ExcelUtils.createTitleAndModelKey("零售价*", "priceForNextDealer", true);
		priceForNextDealer.setToObjConverter(bigDecimalConverter);
		priceForNextDealer.setToStrConverter(bigDecimalConverter);
		titleAndModelKeys.add(priceForNextDealer);
		
		TitleAndModelKey priceExtra = ExcelUtils.createTitleAndModelKey("固定加价", "priceExtra");
		priceExtra.setToObjConverter(bigDecimalConverter);
		priceExtra.setToStrConverter(bigDecimalConverter);
		titleAndModelKeys.add(priceExtra);
		
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("限购", "limitQuantity"));
		titleAndModelKeys.add(ExcelUtils.createTitleAndModelKey("备注", "remark"));
		
		DateConverter dateConverter = new DateConverter("yyyy.MM.dd");
		
		TitleAndModelKey validDate = ExcelUtils.createTitleAndModelKey("开始日期*", "validDate", true);
		validDate.setToStrConverter(dateConverter );
		validDate.setToObjConverter(dateConverter);
		titleAndModelKeys.add(validDate);
		
		TitleAndModelKey expiredDate = ExcelUtils.createTitleAndModelKey("结束日期", "expiredDate");
		expiredDate.setToObjConverter(dateConverter);
		expiredDate.setToStrConverter(dateConverter);
		titleAndModelKeys.add(expiredDate);
		
		return titleAndModelKeys;
	}
	
	private MultipartFile vaildFile(Map<String, MultipartFile> fileMap) {
		if (MapUtils.isEmpty(fileMap)) {
			throw new CommonException("上传文件为空", "file_isNull");
		}
		if (fileMap.size() > 1) {
			throw new CommonException("只接受单个文件导入");
		}

		Set<String> fileKeySet = fileMap.keySet();// 获取所有的key集合

		Iterator<String> keyIterator = fileKeySet.iterator();
		MultipartFile file = null;
		while (keyIterator.hasNext()) {
			file = fileMap.get(keyIterator.next());
		}
		return file;
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