package com.els.runhe.cms.web.controller.template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.els.base.auth.utils.SpringSecurityUtils;
import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.runhe.cms.entity.template.Template;
import com.els.runhe.cms.entity.template.TemplateExample;
import com.els.runhe.cms.service.template.TemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * TemplateController
 * 
 * @author acer
 * 
 */
@Api("模板管理")
@Controller
@RequestMapping("template")
public class TemplateController {
	@Autowired
	private TemplateService templateService;

	@ApiOperation(value = "模板页面跳转", httpMethod = "GET")
	@RequestMapping("service/init")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("cms/template/main");
		return mv;
	}

	/**
	 * 页面跳转
	 * 
	 * @param templateId
	 * @param actionType
	 *            (A:add,U:update,D:detail)
	 * @return
	 */
	@RequestMapping(value = "service/action", params = "actionType")
	public ModelAndView action(Integer templateId, String actionType,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("cms/template/add");
		mv.addObject("actionType", actionType);
		if (StringUtils.isNotBlank(actionType)) {
			if ("U".equalsIgnoreCase(actionType)
					|| "D".equalsIgnoreCase(actionType)) {
				Template template = this.templateService
						.queryObjById(templateId);
				mv.addObject("template", template);
			}
		}
		return mv;
	}

	@ApiOperation(value = "新增模板", httpMethod = "POST")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody Template template) {
		this.templateService.addObj(template);
//		template.setOperater(SpringSecurityUtils.getLoginUserId());
		return ResponseResult.success();
	}

	@ApiOperation(value = "修改模板", httpMethod = "POST")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Template template) {
		this.templateService.modifyObj(template);
		return ResponseResult.success();
	}

	@ApiOperation(value = "删除模板", httpMethod = "POST")
	@RequestMapping("service/delete")
	@ResponseBody
	public ResponseResult<String> delete(int templateId) {
		this.templateService.deleteObjById(templateId);
		return ResponseResult.success();
	}

	@ApiOperation(value = "根据模板ID查询模板", httpMethod = "GET")
	@RequestMapping(value = { "front/findByTemplateId",
			"service/findByTemplateId" })
	@ResponseBody
	public ResponseResult<Template> findByTemplateId(int templateId) {
		Template template = this.templateService.queryObjById(templateId);
		return ResponseResult.success(template);
	}

	@ApiOperation(value = "分页查询模板", httpMethod = "GET")
	@RequestMapping("service/findByPage")
	@ResponseBody
	public PageView<Template> findByPage(HttpServletRequest request,
			HttpServletResponse response) {
		int pageNo = 1;// 起始索引
		int pageSize = 10;// 每页显示的行数
		if (StringUtils.isNotBlank(request.getParameter("iDisplayStart"))) {
			pageNo = Integer.valueOf(request.getParameter("iDisplayStart"));
		}

		if (StringUtils.isNotBlank(request.getParameter("iDisplayLength"))) {
			pageSize = Integer.valueOf(request.getParameter("iDisplayLength"));
		}

		String search = request.getParameter("sSearch");

		PageView<Template> pageView = new PageView<Template>(pageNo,
				pageSize);
		TemplateExample example = new TemplateExample();
		example.setPageView(pageView);
		if (StringUtils.isNotBlank(search)) {
			example.createCriteria().andTemplateNameLike("%" + search + "%");
		}
		return this.templateService.queryObjByPage(example);
	}
}