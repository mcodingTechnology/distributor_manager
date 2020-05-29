package com.els.runhe.contract.web.controller;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
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
import com.els.runhe.contract.entity.ContractSaleSupport;
import com.els.runhe.contract.entity.ContractSaleSupportExample;
import com.els.runhe.contract.model.SaleSupport;
import com.els.runhe.contract.service.ContractSaleSupportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "合同模块-销售支持")
@Controller
@RequestMapping("contractSaleSupport")
public class ContractSaleSupportController {

	@Resource
	protected ContractSaleSupportService contractSaleSupportService;

	@ApiOperation(httpMethod = "POST", value = "创建合同销售支持")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody ContractSaleSupport contractSaleSupport) {
		this.contractSaleSupportService.addObj(contractSaleSupport);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑合同销售支持")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody ContractSaleSupport contractSaleSupport) {
		if (StringUtils.isBlank(contractSaleSupport.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.contractSaleSupportService.modifyObj(contractSaleSupport);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除合同销售支持")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.contractSaleSupportService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询合同销售支持")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 ContractSaleSupport", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<ContractSaleSupport>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		ContractSaleSupportExample example = new ContractSaleSupportExample();
		example.setPageView(new PageView<ContractSaleSupport>(pageNo, pageSize));

		if (wapper != null) {
			ContractSaleSupportExample.Criteria criteria = example.createCriteria();
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<ContractSaleSupport> pageData = this.contractSaleSupportService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}

	@ApiOperation(httpMethod = "POST", value = "根据合同ID和实际销售额查询相应的销售支付比率")
	@RequestMapping("service/findSaleSupportByActualSales")
	@ResponseBody
	public ResponseResult<ContractSaleSupport> findSaleSupportByActualSales(@RequestBody SaleSupport req) {
		ContractSaleSupport record = this.contractSaleSupportService.getSaleSupportByActualSales(req.getContractId(),
				req.getActualAmount());
		return ResponseResult.success(record);
	}

}