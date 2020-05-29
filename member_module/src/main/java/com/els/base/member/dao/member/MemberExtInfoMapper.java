package com.els.base.member.dao.member;

import com.els.base.core.dao.IMapper;
import com.els.base.member.entity.member.MemberExtInfo;
import com.els.base.member.entity.member.MemberExtInfoExample;

public interface MemberExtInfoMapper extends IMapper<MemberExtInfo, MemberExtInfoExample>{
	
	public MemberExtInfo selectByMemberId(int memberId);
}