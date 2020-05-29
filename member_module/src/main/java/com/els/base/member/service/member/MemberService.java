package com.els.base.member.service.member;

import com.els.base.core.service.BaseService;
import com.els.base.member.entity.member.Member;
import com.els.base.member.entity.member.MemberExample;
import com.els.base.wechat.member.entity.WxMember;

public interface MemberService extends BaseService<Member, MemberExample, String> {
	
	/**
	 * 根据微信用户openId，增加或修改用户信息
	 * @param wxMpUser
	 * @return
	 */
	public Member createOrEditByOpenId(String openId);
	
	/**
	 * 根据微信用户资料，增加或修改用户信息
	 * @param wxMpUser
	 * @return
	 */
	public Member createOrEditByWxMember(WxMember wxMpUser);
	
	/**
	 * 只查询会员的信息，包括会员的拓展信息和微信会员信息
	 * @param id
	 * @return
	 */
	public Member queryMemberFromSingleTable(String id);
	
	/**
	 * 根据微信的会员openid，查询出会员信息
	 * @param openId
	 * @return
	 */
	public Member queryByOpenId(String openId);

}
