package com.els.runhe.cms.web.controller.label;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.runhe.cms.entity.label.Label;
import com.els.runhe.cms.entity.label.LabelExample;
import com.els.runhe.cms.service.label.LabelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * LabelController
 * 
 * @author acer
 * 
 */
@Api("标签管理")
@Controller
@RequestMapping("label")
public class LabelController {

	@Autowired
	private LabelService labelService;

	@ApiOperation(value = "标签页面跳转", httpMethod = "GET")
	@RequestMapping("service/init")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("cms/label/main");
		return mv;
	}

	/**
	 * 页面跳转
	 * 
	 * @param labelId
	 * @param actionType
	 *            (A:add,U:update,D:detail)
	 * @return
	 */
	@RequestMapping(value = "service/action", params = "actionType")
	public ModelAndView action(Integer labelId, String actionType,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("cms/label/add");
		mv.addObject("actionType", actionType);
		if (StringUtils.isNotBlank(actionType)) {
			if ("U".equalsIgnoreCase(actionType)
					|| "D".equalsIgnoreCase(actionType)) {
				Label label = this.labelService.queryObjById(labelId);
				mv.addObject("label", label);
			}
		}
		return mv;
	}

	@ApiOperation(value = "添加标签", httpMethod = "POST")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody Label label) {
		this.labelService.addObj(label);
		return ResponseResult.success();
	}

	@ApiOperation(value = "修改标签", httpMethod = "POST")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Label label) {
		this.labelService.modifyObj(label);
		return ResponseResult.success();
	}

	@ApiOperation(value = "删除标签", httpMethod = "POST")
	@RequestMapping("service/delete")
	@ResponseBody
	public ResponseResult<String> delete(int labelId) {
		this.labelService.deleteObjById(labelId);
		return ResponseResult.success();
	}

	@ApiOperation(value = "根据标签ID查询标签", httpMethod = "GET")
	@RequestMapping(value = { "front/findByLabelId", "service/findByLabelId" })
	@ResponseBody
	public ResponseResult<Label> findByLabelId(int labelId) {
		Label label = this.labelService.queryObjById(labelId);
		return ResponseResult.success(label);
	}

	@ApiOperation(value = "分页查询标签", httpMethod = "GET")
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<Label>> findByPage(HttpServletRequest request) {
		int pageNo = 1;// 起始索引
		int pageSize = 10;// 每页显示的行数

		if (StringUtils.isNotBlank(request.getParameter("iDisplayStart"))) {
			pageNo = Integer.valueOf(request.getParameter("iDisplayStart"));
		}

		if (StringUtils.isNotBlank(request.getParameter("iDisplayLength"))) {
			pageSize = Integer.valueOf(request.getParameter("iDisplayLength"));
		}

		String search = request.getParameter("sSearch");

		PageView<Label> pageView = new PageView<Label>(pageNo,
				pageSize);

		LabelExample example = new LabelExample();
		example.setPageView(pageView);
		if (StringUtils.isNotBlank(search)) {
			example.createCriteria().andMarkLike(search + "%");
		}
		example.setOrderByClause("hit DESC, seq_num DESC");

		return ResponseResult.success(this.labelService.queryObjByPage(example));
	}

	/**
	 * 更新标签热度
	 * 
	 * @param label
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "更新标签热度", httpMethod = "GET")
	@RequestMapping("front/updateHit")
	@ResponseBody
	public ResponseResult<String> updateHit(String label, HttpServletRequest request) {
//		labelService.addLabelHit(StoreUtils.getStoreIdFromThreadLocal(), label);
		labelService.addLabelHit(0, label);
		return ResponseResult.success();
	}

	/**
	 * 查询标签热度接口
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 */
	@ApiOperation(value = "查询标签热度接口", httpMethod = "GET")
	@RequestMapping("front/findLabelByPage")
	@ResponseBody
	public PageView<Label> findLabelByPage(int pageNo,
			int pageSize, HttpServletRequest request) {
		PageView<Label> pageView = new PageView<Label>(pageNo,
				pageSize);
		LabelExample example = new LabelExample();
//		example.createCriteria().andStoreIdEqualTo(StoreUtils.getStoreIdFromThreadLocal());
		example.setOrderByClause(" hit desc ");
		example.setPageView(pageView);
		return labelService.queryObjByPage(example);
	}
}