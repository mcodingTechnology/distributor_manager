package com.els.runhe.cms.web.controller.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.utils.CriteriaUtils;
import com.els.base.core.utils.query.QueryParamWapper;
import com.els.runhe.cms.entity.module.Module;
import com.els.runhe.cms.entity.module.ModuleExample;
import com.els.runhe.cms.service.module.ModuleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * ModuleController
 * 
 * @author acer
 * 
 */
@Api("模板管理")
@Controller
@RequestMapping("module")
public class ModuleController {
	@Autowired
	private ModuleService moduleService;

	@ApiOperation(value = "模块页面跳转", httpMethod = "GET")
	@RequestMapping("service/init")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("cms/module/main");
		return mv;
	}

	/**
	 * 页面跳转
	 * 
	 * @param moduleId
	 * @param actionType
	 *            (A:add,U:update,D:detail)
	 * @return
	 */
	@RequestMapping(value = "service/action", params = "actionType")
	public ModelAndView action(Integer moduleId, String actionType,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("cms/module/add");
		mv.addObject("actionType", actionType);
		if (StringUtils.isNotBlank(actionType)) {
			if ("U".equalsIgnoreCase(actionType)
					|| "D".equalsIgnoreCase(actionType)) {
				Module module = this.moduleService.queryObjById(moduleId);
				mv.addObject("module", module);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("moduleId", moduleId);
		
		List<Module> modules = moduleService.selectModules(map);
		mv.addObject("modules", modules);
		return mv;
	}

	@ApiOperation(value = "新增模块", httpMethod = "POST")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody Module module) {
		this.moduleService.addObj(module);
		return ResponseResult.success();
	}

	@ApiOperation(value = "修改模块", httpMethod = "POST")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Module module) {
		this.moduleService.modifyObj(module);
		return ResponseResult.success();
	}

	@ApiOperation(value = "删除模块", httpMethod = "POST")
	@RequestMapping("service/delete")
	@ResponseBody
	public ResponseResult<String> delete(int moduleId) {
		this.moduleService.deleteObjById(moduleId);
		return ResponseResult.success();
	}

	@ApiOperation(value = "根据模板ID查询模块", httpMethod = "GET")
	@RequestMapping(value = { "front/findByTemplateId",
			"service/findByTemplateId" })
	@ResponseBody
	public ResponseResult<Module> findByTemplateId(int moduleId) {
		Module module = this.moduleService.queryObjById(moduleId);
		return ResponseResult.success(module);
	}

	@ApiOperation(value = "分页查询模块", httpMethod = "POST")
    @ApiImplicitParams({ 
	 @ApiImplicitParam( name = "pageNo",required = false,value = "所在页", paramType = "query", dataType = "String", defaultValue = "0" ),  
	 @ApiImplicitParam( name = "pageSize", required = false, value = "每页数量", paramType = "query", dataType = "String", defaultValue = "10" ),  
	 @ApiImplicitParam( name = "wapper", required = false, value = "查询条件,属性名请参考 Module", paramType = "body", dataType = "QueryParamWapper" )  
})
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<Module>> findByPage(
			@RequestParam(defaultValue="0") int pageNo,  
			 @RequestParam(defaultValue="10") int pageSize, 
			 @RequestBody(required=false) QueryParamWapper wapper) {
		ModuleExample example = new ModuleExample();
		example.setPageView(new PageView<Module>(pageNo, pageSize));
		
		if (wapper != null) {
			ModuleExample.Criteria criteria = example.createCriteria();
            CriteriaUtils.addCriterion(criteria, wapper);
        }
		example.setOrderByClause("id DESC");
		PageView<Module> pageData = this.moduleService.queryObjByPage(example);
		return ResponseResult.success(pageData);
	}

	/**
	 * 根据父级ID查询模块
	 * 
	 * @param parentId
	 * @return
	 */
	@ApiOperation(value = "根据父级ID查询模块", httpMethod = "GET")
	@RequestMapping("front/findModuleByParentId")
	@ResponseBody
	public ResponseResult<List<Module>> findModuleByParentId(Integer parentId,
			HttpServletRequest request) {
		ModuleExample example = new ModuleExample();
		example.createCriteria()
				.andParentIdEqualTo(parentId);
//		example.createCriteria()
//		.andStoreIdEqualTo(StoreUtils.getStoreIdFromThreadLocal())
//		.andParentIdEqualTo(parentId);
		List<Module> list = moduleService.queryAllObjByExample(example);
		return ResponseResult.success(list);

	}
	
	/**
	 * 加载模块信息
	 * @param iDisplayStart
	 * @param iDisplayLength
	 * @param pramType
	 * @param pramValue
	 * @return
	 */
	@ApiOperation(value = "加载模块信息", httpMethod = "GET", notes = "paramType参数类型(articleId--文章,labels--多个标签名称使用逗号分隔,moduleId--文章模块,typeId--文章类型),paramValue参数值")
	@RequestMapping("front/queryModulePage")
	@ResponseBody
	public PageView<Module> queryModulePage(HttpServletRequest request) {
		return moduleService.selectByPage(0);
//		return moduleService.selectByPage(StoreUtils.getStoreIdFromThreadLocal());
	}

}