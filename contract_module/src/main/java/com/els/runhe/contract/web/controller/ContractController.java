package com.els.runhe.contract.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
import com.els.base.utils.json.JsonUtils;
import com.els.runhe.contract.entity.Contract;
import com.els.runhe.contract.entity.ContractExample;
import com.els.runhe.contract.model.ContractInfo;
import com.els.runhe.contract.service.ContractService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "合同模块-合同管理")
@Controller
@RequestMapping("contract")
public class ContractController {

	@Resource
	protected ContractService contractService;
	@Resource
    protected CompanyService companyService;
	@Resource
    protected UserService userService;

	@ApiOperation(httpMethod = "POST", value = "创建合同")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody Contract contract) {
		this.contractService.addObj(contract);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "编辑合同")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Contract contract) {
		if (StringUtils.isBlank(contract.getId())) {
			throw new CommonException("id 为空，保存失败");
		}
		this.contractService.modifyObj(contract);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "删除合同")
	@RequestMapping("service/deleteById")
	@ResponseBody
	public ResponseResult<String> deleteById(@RequestParam(required = true) String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("删除失败,id不能为空");
		}
		this.contractService.deleteObjById(id);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "POST", value = "查询合同")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNo", required = false, value = "所在页", paramType = "query", dataType = "String", defaultValue = "0"),
			@ApiImplicitParam(name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10"),
			@ApiImplicitParam(name = "wapper", required = false, value = "查询条件,属性名请参考 Contract", paramType = "body", dataType = "QueryParamWapper") })
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<Contract>> findByPage(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "10") int pageSize, @RequestBody(required = false) QueryParamWapper wapper) {
		ContractExample example = new ContractExample();
		example.setPageView(new PageView<Contract>(pageNo, pageSize));

		ContractExample.Criteria criteria = example.createCriteria();
		criteria.andPartyAIdEqualTo(CompanyUtils.currentCompanyId());
		if (wapper != null) {
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
    		criteria.andPartyBIdEqualTo(CompanyUtils.currentCompanyId());
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
	        				criteria.andPartyBIdIn(companyStrings);
	        			}else {
	        				criteria.andNotPartyBIdIn();
	        			}
	    			}else {
	    				criteria.andNotPartyBIdIn();
	    			}
	    		}else{
	    			criteria.andNotPartyBIdIn();
	    		}
	    	}else {
	    		criteria.andNotPartyBIdIn();
	    	}
		}
		PageView<Contract> pageData = this.contractService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}

	@ApiOperation(httpMethod = "POST", value = "新增合同")
	@RequestMapping("service/add")
	@ResponseBody
	public ResponseResult<?> add(@RequestBody ContractInfo req) {
		contractService.add(req);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "GET", value = "查看合同详情")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", required = true, value = "合同ID", paramType = "query", dataType = "String") })
	@RequestMapping("service/detail")
	@ResponseBody
	public ResponseResult<ContractInfo> detail(String id) {
		if (StringUtils.isBlank(id)) {
			throw new CommonException("合同ID为空");
		}
		ContractInfo data = contractService.detail(id);
		return ResponseResult.success(data);
	}

	@ApiOperation(httpMethod = "POST", value = "更新合同信息")
	@RequestMapping("service/update")
	@ResponseBody
	public ResponseResult<?> update(@RequestBody ContractInfo req) {
		contractService.update(req);
		return ResponseResult.success();
	}

	@ApiOperation(httpMethod = "GET", value = "根据乙方ID查询当前有效合同记录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "partyBId", required = true, value = "乙方ID", paramType = "query", dataType = "String") })
	@RequestMapping("service/findValidContractByPartyB")
	@ResponseBody
	public ResponseResult<Contract> findValidContractByPartyB(String partyBId) {
		if (StringUtils.isBlank(partyBId)) {
			throw new CommonException("乙方ID为空");
		}
		Contract data = contractService.getValidContractByPartyB(partyBId);
		return ResponseResult.success(data);
	}

}