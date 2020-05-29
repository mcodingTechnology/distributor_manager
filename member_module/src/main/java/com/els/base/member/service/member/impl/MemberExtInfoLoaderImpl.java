package com.els.base.member.service.member.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.els.base.member.entity.member.IMemberExtInfo;
import com.els.base.member.entity.member.MemberExtInfo;
import com.els.base.member.entity.member.MemberExtInfoExample;
import com.els.base.member.service.member.IMemberExtInfoLoader;
import com.els.base.member.service.member.MemberExtInfoService;
import com.els.base.utils.SpringContextHolder;

//@Component
public class MemberExtInfoLoaderImpl implements IMemberExtInfoLoader {
	
	private static MemberExtInfoService memberExtInfoService = SpringContextHolder.getOneBean(MemberExtInfoService.class);

	@Override
	public String getMemberExtInfoType() {
		return "base";
	}

	@Override
	public IMemberExtInfo getMemberExtInfo(String memberId) {
		MemberExtInfoExample example = new MemberExtInfoExample();
		example.createCriteria().andMemberIdEqualTo(Integer.valueOf(memberId));
		
		
		List<MemberExtInfo> list = memberExtInfoService.queryAllObjByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}

}
