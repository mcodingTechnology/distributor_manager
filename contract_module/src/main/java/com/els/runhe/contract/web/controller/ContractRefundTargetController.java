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
import com.els.runhe.contract.entity.ContractRefundTarget;
import com.els.runhe.contract.entity.ContractRefundTargetExample;
import com.els.runhe.contract.model.ReachRefund;
import com.els.runhe.contract.service.ContractRefundTargetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "合同模块-回款目标")
@Controller
@RequestMapping("contractRefundTarget")
public class ContractRefundTargetController {

	@Resource
	protected ContractRefundTargetService contractRefundTargetService;

	@ApiOperation(httpMethod = "POST", value = "创建合同回款目标")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody ContractRefundTarget contractRefundTarget) {
		this.contractRefundTargetService.addObj(contractRefundTarget);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑合同回款目标")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody ContractRefundTarget contractRefundTarget) {
		if (StringUtils.isBlank(contractRefundTarget.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.contractRefundTargetService.modifyObj(contractRefundTarget);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除合同回款目标")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.contractRefundTargetService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询合同回款目标")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 ContractRefundTarget", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<ContractRefundTarget>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		ContractRefundTargetExample example = new ContractRefundTargetExample();
		example.setPageView(new PageView<ContractRefundTarget>(pageNo, pageSize));

		if (wapper != null) {
			ContractRefundTargetExample.Criteria criteria = example.createCriteria();
			CriteriaUtils.addCriterion(criteria, wapper);
		}

		PageView<ContractRefundTarget> pageData = this.contractRefundTargetService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}

	@ApiOperation(httpMethod = "POST", value = "检查某个月的实际回款目标是否已达标")
	@RequestMapping("service/isReachByMonth")
	@ResponseBody
	public ResponseResult<Boolean> isReachByMonth(@RequestBody ReachRefund req) {
		Boolean result = this.contractRefundTargetService.isReachByMonth(req.getContractId(), req.getMonth(),
				req.getActualAmount());
		return ResponseResult.success(result);
	}

}