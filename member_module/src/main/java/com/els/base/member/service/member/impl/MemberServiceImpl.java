package com.els.base.member.service.member.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.base.core.entity.PageView;
import com.els.base.core.exception.CommonException;
import com.els.base.member.dao.member.MemberExtInfoMapper;
import com.els.base.member.dao.member.MemberMapper;
import com.els.base.member.entity.member.Member;
import com.els.base.member.entity.member.MemberExample;
import com.els.base.member.service.member.MemberService;
import com.els.base.member.service.member.event.FinishAddMemberEvent;
import com.els.base.member.service.wechat.StoreWxRefService;
import com.els.base.member.utils.member.MemberUtils;
import com.els.base.utils.SpringContextHolder;
import com.els.base.wechat.account.entity.AccountConfig;
import com.els.base.wechat.account.utils.WxAccountConfigUtils;
import com.els.base.wechat.common.WxMpServiceUtils;
import com.els.base.wechat.member.entity.WxMember;
import com.els.base.wechat.member.service.WxMemberService;
import com.els.base.wechat.member.utils.WxMemberUtils;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	private Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Resource
	protected MemberMapper memberMapper;

	@Resource
	protected MemberExtInfoMapper memberExtInfoMapper;

	@Autowired
	protected WxMemberService wxMemberService;
	
	@Autowired
	protected StoreWxRefService storeWxRefService;
	
	@CacheEvict(value = "memberCache", allEntries = true)
	@Transactional
	@Override
	public void addObj(Member member) {
		this.memberMapper.insertSelective(member);
		
		FinishAddMemberEvent event = new FinishAddMemberEvent(member);
		SpringContextHolder.getApplicationContext().publishEvent(event);

	}

	@CacheEvict(value = "memberCache", allEntries = true)
	@Override
	public void deleteObjById(String id) {
		this.memberMapper.deleteByPrimaryKey(id);
	}

	@CacheEvict(value = "memberCache", allEntries = true)
	@Transactional
	@Override
	public void modifyObj(Member member) {
		if (StringUtils.isBlank(member.getId())) {
			throw new CommonException("会员更新失败，因为提交的会员id为空");
		}
		this.memberMapper.updateByPrimaryKeySelective(member);

	}
	
	@Override
	public Member queryObjById(String id) {
		MemberService memberService = SpringContextHolder.getBean("memberService");
		Member member = memberService.queryMemberFromSingleTable(id);
		if (member == null) {
			return null;
		}
		return member;
	}
	
	@Cacheable(value = "memberCache", key = "'MemberService_' + #root.methodName + '_'+ #id")
	public Member queryMemberFromSingleTable(String id){
		return this.memberMapper.selectByPrimaryKey(id);
	}

	@Cacheable(value = "memberCache", key = "'MemberService_' + #root.methodName + '_'+ #example.toJson()")
	@Override
	public List<Member> queryAllObjByExample(MemberExample example) {
		return this.memberMapper.selectByExample(example);
	}

	@Cacheable(value = "memberCache", key = "'MemberService_' + #root.methodName + '_'+ #example.toJson()")
	@Override
	public PageView<Member> queryObjByPage(MemberExample example) {
		PageView<Member> pageView = example.getPageView();
		if (pageView == null) {
			pageView = new PageView<>(1, 10);
			example.setPageView(pageView);
		}
		pageView.setQueryResult(this.memberMapper.selectByExampleByPage(example));
		return pageView;
	}

	@CacheEvict(value = "memberCache", allEntries = true)
	@Override
	public Member createOrEditByOpenId(String openId) {
		if (StringUtils.isBlank(openId)) {
			throw new NullPointerException("获取openid 失败");
		}

		WxMember wxMember = this.wxMemberService.queryByOpenId(openId);

		if (wxMember == null) {
			// 没有微信用户信息，则添加
			// 新增用户
			wxMember = this.getWxUserInfoFromWxService(openId);
			if (wxMember != null && wxMember.getWxNickname() != null) {
				return this.createOrEditByWxMember(wxMember);
				
			} else {
				wxMember = new WxMember();
				wxMember.setWxOpenid(openId);
			}
			
			Member member = new Member();
			member.setSource(Member.SOURCE_WEIXIN);
			MemberUtils.setWxMemberInfoToMember(wxMember, member);
			this.addObj(member);
			
			wxMember.setMemberId(String.valueOf(member.getId()));
			this.wxMemberService.addObj(wxMember);
			
			member.setWxMember(wxMember);
			return member;

		} else {
			// 存在微信用户信息，则修改
			
			Member member = null;
			if(wxMember.getMemberId() != null){
				member = this.queryObjById(wxMember.getMemberId());
			}
			
			if(member == null){
				member = new Member();
				member.setSource(Member.SOURCE_WEIXIN);
				MemberUtils.setWxMemberInfoToMember(wxMember, member);
				if (StringUtils.isNotBlank(wxMember.getMemberId())) {
					member.setId(wxMember.getMemberId());
				}
				
				this.addObj(member);
				
			}else{
				
				member.setName(wxMember.getWxNickname());
				member.setHeadImgUrl(wxMember.getWxHeadimgurl());
				this.modifyObj(member);
			}
			
			wxMember.setMemberId(String.valueOf(member.getId()));
			this.wxMemberService.modifyObj(wxMember);
			
			member.setWxMember(wxMember);
			return member;
		}
	}

	private WxMember getWxUserInfoFromWxService(String openId) {
		WxMember wxMember = null;
		try {
			// 到公众号里面，查询微信会员的个人资料
//			WxMpService wxMpService = WxMpServiceUtils.getWxMpServiceFromThreadLocal();
			AccountConfig accountConfig = WxAccountConfigUtils.getDefaultAccountFromConfig();;
			WxMpService wxMpService = WxMpServiceUtils.getWxMpServiceByAccount(accountConfig);
			WxMpUser wxMpUser = wxMpService.getUserService().userInfo(openId, "zh_CN");
			wxMember = WxMemberUtils.getWxMemberFormMpUser(wxMpUser);

		} catch (Exception e) {
			logger.warn("获取微信用户资料失败，可能用户没有关注公众号");
			logger.warn(e.getMessage());
		}

		return wxMember;
	}

	@CacheEvict(value = "memberCache", allEntries = true)
	@Override
	public Member createOrEditByWxMember(WxMember wxMember) {
		
		WxMember tmpWxMember = this.wxMemberService.queryByOpenId(wxMember.getWxOpenid());
		logger.debug("query wxMember By openid: wxmebemr["+tmpWxMember+"]");
		
		if (tmpWxMember == null) {
			// 新用户，新增
			Member member = new Member();
			member.setSource(Member.SOURCE_WEIXIN);
			MemberUtils.setWxMemberInfoToMember(wxMember, member);
			this.addObj(member);
			
			wxMember.setMemberId(String.valueOf(member.getId()));
			this.wxMemberService.addObj(wxMember);
			
			member.setWxMember(wxMember);
			return member;

		} else {
			// 老用户，更新
			Member member = null;
			logger.debug("wxmember.memberId["+tmpWxMember.getMemberId()+"]");
			
			if(tmpWxMember.getMemberId() != null){
			    member = this.queryObjById(tmpWxMember.getMemberId());
			}
			logger.debug("member query By memberId["+ member +"]");
			if (member != null) {
				MemberUtils.setWxMemberInfoToMember(wxMember, member);
				this.modifyObj(member);

			} else {
				member = new Member();
				MemberUtils.setWxMemberInfoToMember(wxMember, member);
				member.setSource(Member.SOURCE_WEIXIN);
				this.addObj(member);

			}
			
			wxMember.setMemberId(String.valueOf(member.getId()));
			wxMember.setId(tmpWxMember.getId());
			this.wxMemberService.modifyObj(wxMember);
			
			member.setWxMember(wxMember);
			return member;
		}
	}

	@Cacheable(value = "memberCache", key = "'MemberService_' + #root.methodName + '_'+ #openId")
	@Override
	public Member queryByOpenId(String openId) {
		WxMember wxMember = this.wxMemberService.queryByOpenId(openId);
		if (wxMember == null) {
			return null;
		}
		
		if (StringUtils.isBlank(wxMember.getMemberId())) {
			return null;
		}
		
		return this.queryObjById(wxMember.getMemberId());
	}

}
