package com.els.base.member.service.member.impl;

import java.util.Map;

import com.els.base.member.service.member.MemberService;
import com.els.base.utils.SpringContextHolder;
import com.els.base.wechat.member.entity.WxMember;
import com.els.base.wechat.member.service.WxMemberService;
import com.els.base.wechat.msg.entity.WxMsgRule;
import com.els.base.wechat.msg.handler.BaseMsgHandler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

public class SubscribeHandler extends BaseMsgHandler {

	public SubscribeHandler(WxMsgRule wxMsgRule) {
		super(wxMsgRule);
	}

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
			WxSessionManager sessionManager) throws WxErrorException {
		WxMpUser wxMpUser = wxMpService.getUserService().userInfo(wxMessage.getFromUser(), null);
		WxMember wxMember = SpringContextHolder.getOneBean(WxMemberService.class).createOrEditWxMember(wxMpUser, wxMessage.getEventKey(), wxMessage.getToUser());
		SpringContextHolder.getOneBean(MemberService.class).createOrEditByWxMember(wxMember);
		
		return null;
	}

}
