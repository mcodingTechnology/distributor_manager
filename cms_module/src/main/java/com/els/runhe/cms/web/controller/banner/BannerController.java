package com.els.runhe.cms.web.controller.banner;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.runhe.cms.entity.banner.Banner;
import com.els.runhe.cms.entity.banner.BannerExample;
import com.els.runhe.cms.service.banner.BannerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@Api("首页轮播图片管理")
@Controller
@RequestMapping("banner")
public class BannerController {

	@Resource
	protected BannerService bannerService;

	@ApiOperation(value = "图片管理页面跳转", httpMethod = "GET")
	@RequestMapping("service/toListPageView")
	public ModelAndView toListPageView() {
		ModelAndView mv = new ModelAndView("cms/banner/listPageView");
		return mv;
	}
	
	@RequestMapping("service/toAddView")
	public ModelAndView toAddView() {
		ModelAndView view = new ModelAndView();
		view.setViewName("cms/banner/toAddView");
		return view;
	}
	
	@ApiIgnore
	@RequestMapping("service/toUpdateViewById")
	public ModelAndView toUpdateViewById(int id) {
		ModelAndView view = new ModelAndView();
		Banner banner = this.bannerService.queryObjById(id);
		view.addObject("banner", banner);
		view.setViewName("cms/banner/toAddView");
		return view;
	}

	@ApiOperation(value = "分页查询轮播图片", httpMethod = "GET")
	@RequestMapping("service/findByPage")
	@ResponseBody
	public PageView<Banner> findByPage(Integer pageNo, Integer pageSize) {
		if (pageNo == null) {
			pageNo = 0;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		PageView<Banner> pageView = new PageView<Banner>();
		pageView.setPageNo(pageNo);
		pageView.setPageSize(pageSize);

		BannerExample example = new BannerExample();
		example.setPageView(pageView);
		this.bannerService.queryObjByPage(example);
		return pageView;
	}

	@ApiOperation(value = "添加首页轮播图片", httpMethod = "POST")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@RequestBody Banner banner) {
		banner.setIsEnable(Constant.YES_INT);
		this.bannerService.addObj(banner);
		return ResponseResult.success();
	}

	@ApiOperation(value = "修改轮播图片", httpMethod = "POST")
	@RequestMapping("service/edit")
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Banner banner) {
		this.bannerService.modifyObj(banner);
		return ResponseResult.success();
	}
	
	@ApiOperation(value = "修改轮播图片显隐状态", httpMethod = "POST")
	@RequestMapping("service/enableBanner")
	@ResponseBody
	public ResponseResult<String> enableBanner(int bannerId) {
		Banner banner = this.bannerService.queryObjById(bannerId);
		if(banner==null){
			throw new CommonException("找不到轮播图片信息");
		}
		Banner b = new Banner();
		b.setId(bannerId);
		if(Constant.YES_INT == banner.getIsEnable()){
			b.setIsEnable(Constant.NO_INT);
		}else{
			b.setIsEnable(Constant.YES_INT);
		}
		this.bannerService.modifyObj(b);
		return ResponseResult.success();
	}
	
	@ApiOperation(value = "首页加载轮播图片", httpMethod = "POST")
	@RequestMapping("front/bannerList")
	@ResponseBody
	public PageView<Banner> bannerList(@RequestParam(defaultValue="0") Integer pageNo, @RequestParam(defaultValue="5")Integer pageSize) {
		PageView<Banner> pageView = new PageView<Banner>(pageNo, pageSize);
		
		BannerExample example = new BannerExample();
		example.createCriteria().andIsEnableEqualTo(Constant.YES_INT);
		example.setOrderByClause("sort DESC");
		example.setPageView(pageView);
		
		this.bannerService.queryObjByPage(example);
		return pageView;
	}

}
