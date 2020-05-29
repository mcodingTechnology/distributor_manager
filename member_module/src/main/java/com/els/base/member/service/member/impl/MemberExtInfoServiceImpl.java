package com.els.base.member.service.member.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.els.base.core.entity.PageView;
import com.els.base.member.dao.member.MemberExtInfoMapper;
import com.els.base.member.entity.member.MemberExtInfo;
import com.els.base.member.entity.member.MemberExtInfoExample;
import com.els.base.member.service.member.MemberExtInfoService;

@Service("memberExtInfoService")
public class MemberExtInfoServiceImpl implements MemberExtInfoService {

	@Resource
	protected MemberExtInfoMapper memberExtInfoMapper;

	@Override
	public void addObj(MemberExtInfo t) {
		this.memberExtInfoMapper.insert(t);
	}

	@Override
	public void deleteObjById(Integer id) {
		this.memberExtInfoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void modifyObj(MemberExtInfo t) {
		this.memberExtInfoMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public MemberExtInfo queryObjById(Integer id) {
		return this.memberExtInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<MemberExtInfo> queryAllObjByExample(MemberExtInfoExample example) {
		return this.memberExtInfoMapper.selectByExample(example);
	}

	@Override
	public PageView<MemberExtInfo> queryObjByPage(MemberExtInfoExample example) {
		PageView<MemberExtInfo> pageView = example.getPageView();
		if (pageView == null) {
			pageView = new PageView<>(1, 10);
			example.setPageView(pageView);
		}
		pageView.setQueryResult(this.memberExtInfoMapper.selectByExampleByPage(example));
		return pageView;
	}

}
