package com.els.runhe.cms.service.banner.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.els.runhe.cms.dao.banner.BannerMapper;
import com.els.runhe.cms.entity.banner.Banner;
import com.els.runhe.cms.entity.banner.BannerExample;
import com.els.runhe.cms.service.banner.BannerService;
import com.els.base.core.entity.PageView;

@Service
public class BannerServiceImpl implements BannerService {

	@Resource
	protected BannerMapper bannerMapper;
	
	@Override
	public void addObj(Banner t) {
		this.bannerMapper.insertSelective(t);
	}

	@Override
	public void deleteObjById(Integer id) {
		this.bannerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void modifyObj(Banner t) {
		this.bannerMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public Banner queryObjById(Integer id) {
		return this.bannerMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Banner> queryAllObjByExample(BannerExample example) {
		return this.bannerMapper.selectByExample(example);
	}

	@Override
	public PageView<Banner> queryObjByPage(BannerExample example) {
		PageView<Banner> pageView = example.getPageView();
		if (pageView == null) {
			pageView = new PageView<Banner>();
			pageView.setPageNo(1);
			pageView.setPageSize(10);
			example.setPageView(pageView);
		}
		List<Banner> list = this.bannerMapper.selectByExampleByPage(example);
		pageView.setQueryResult(list);
		return pageView;
	}

}
