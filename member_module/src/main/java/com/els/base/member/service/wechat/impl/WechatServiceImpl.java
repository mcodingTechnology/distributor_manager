package com.els.base.member.service.wechat.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.els.base.member.entity.member.Member;
import com.els.base.member.service.member.MemberService;
import com.els.base.member.service.wechat.StoreWxRefService;
import com.els.base.member.service.wechat.WechatLoginInterceptor;
import com.els.base.utils.SpringContextHolder;
import com.els.base.wechat.account.entity.AccountConfig;
import com.els.base.wechat.account.utils.WxAccountConfigUtils;
import com.els.base.wechat.member.entity.WxMember;
import com.els.base.wechat.member.utils.WxMemberUtils;
import com.els.base.wechat.oauth.service.WechatOauthService;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Service("wechatService")
public class WechatServiceImpl implements WechatOauthService {
	
	private Logger logger = LoggerFactory.getLogger(WechatServiceImpl.class); 
	
	private List<WechatLoginInterceptor> interceptorList = new ArrayList<>();
	
	@Resource
	protected MemberService memberService;
	
	@Autowired
	protected StoreWxRefService storeWxRefService;
	
//	@MemberPointable(using=LoginPointRuleHandler.class, targetMemberIndex=0)
	@Override
	public void handleForOpenId(String openId, Map<String, String> paramsMap, HttpServletRequest request, HttpServletResponse response) {
		
		if (!beforLogin(openId)) {
			return;
		}
		
		Member member = this.memberService.createOrEditByOpenId(openId);
		if (member == null || member.getId() == null) {
			logger.error("Failed creating Member.............");
			throw new NullPointerException("Failed creating Member............. ");
		}
		request.getSession().setAttribute("openid", member.getWxMember().getWxOpenid());
		request.getSession().setAttribute("member", member);
		request.getSession().setAttribute("memberId", member.getId());
		logger.info("success creating Member: memberId:["+member.getId()+"], openId:["+openId+"]............. ");
		
		this.afterLogin(member);
	}

	@Override
	public void handleForWxUser(WxMpUser wxMpUser, Map<String, String> paramsMap, HttpServletRequest request, HttpServletResponse response) {
		
		if (!beforLogin(wxMpUser.getOpenId())) {
			return;
		}
		
		WxMember wxMember =  WxMemberUtils.getWxMemberFormMpUser(wxMpUser);
		
		AccountConfig accountConfig = WxAccountConfigUtils.getDefaultAccountFromConfig();
		wxMember.setWxAccountOriginId(accountConfig.getOriginId());

		Member member = this.memberService.createOrEditByWxMember(wxMember);
		if (member == null || member.getId() == null) {
			throw new NullPointerException("Failed creating Member............. ");
		}
		
		request.getSession().setAttribute("openid", wxMpUser.getOpenId());
		request.getSession().setAttribute("member", member);
		request.getSession().setAttribute("memberId", member.getId());
		logger.info("success creating Member: memberId:["+member.getId()+"], openId:["+wxMember.getWxOpenid()+"]............. ");
		
		this.afterLogin(member);
	}
	
	/**
	 * 微信登录前的操作
	 * @param openId
	 * @return true 正常获取会员资料，false不获取会员资料
	 */
	protected boolean beforLogin(String openId) {
		if (CollectionUtils.isEmpty(this.interceptorList)) {
			return true;
		}
		
		for (WechatLoginInterceptor interceptor : interceptorList) {
			
			boolean isOk = interceptor.preHandle(openId);
			if(!isOk){
				return isOk;
			}
		}
		
		return true;
	}
	
	/**
	 * 微信登录后的操作
	 * @param member 登录后获取到的会员资料
	 */
	protected void afterLogin(Member member){
		if (CollectionUtils.isEmpty(this.interceptorList)) {
			return;
		}
		
		for (WechatLoginInterceptor interceptor : interceptorList) {
			interceptor.afterCompletion(member);
		}
		
	}
	
	@PostConstruct
	protected void init(){
		Map<String, WechatLoginInterceptor> map = SpringContextHolder.getBeans(WechatLoginInterceptor.class);
		if (MapUtils.isEmpty(map)) {
			return;
		}
		Collection<WechatLoginInterceptor> tmpList = map.values();
		CollectionUtils.addAll(this.interceptorList, tmpList.iterator());
	}
	
}
