package com.els.base.member.service.wechat;

import com.els.base.member.entity.member.Member;

public interface WechatLoginInterceptor {

	public boolean preHandle(String openId);

	public void afterCompletion(Member member);

}
