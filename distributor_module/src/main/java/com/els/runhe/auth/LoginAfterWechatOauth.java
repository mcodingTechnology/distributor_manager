package com.els.runhe.auth;

import java.text.MessageFormat;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.stereotype.Component;

import com.els.base.core.entity.user.User;
import com.els.base.core.exception.CommonException;
import com.els.base.core.service.user.UserService;
import com.els.base.core.utils.Assert;
import com.els.base.core.utils.Constant;
import com.els.base.utils.encryption.DESUtils;
import com.els.base.wechat.account.entity.AccountConfig;
import com.els.base.wechat.account.service.AccountConfigService;
import com.els.base.wechat.common.WxConstant;
import com.els.base.wechat.member.entity.WxMember;
import com.els.base.wechat.member.service.WxMemberService;
import com.els.base.wechat.oauth.service.WechatOauthService;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Component
public class LoginAfterWechatOauth implements WechatOauthService {

	private static final Logger logger = LoggerFactory.getLogger(LoginAfterWechatOauth.class);
	private static String loginFailePage = "/error.html";

	@Resource
	protected AuthenticationManager authenticationManager;

	@Resource
	protected WxMemberService wxMemberService;

	@Resource
	protected UserService userService;
	
	@Resource
	protected AccountConfigService accountConfigService;
	
	@Autowired
    private SessionAuthenticationStrategy sessionStrategy;

	@Override
	public void handleForOpenId(String openId, Map<String, String> paramsMap, HttpServletRequest request, HttpServletResponse response) {
		try {
			this.loginByOpenid(openId, request, response);
			
		} catch (Exception e) {
			logger.error("微信登录失败", e);
			String orginId = paramsMap.get(WxConstant.PARAMS_MAP_KEY_TARGET_APPID);
			
			AccountConfig accountConfig = accountConfigService.queryByOriginId(orginId);
			String errorPage = accountConfig.getDomain().concat(loginFailePage);
			logger.warn("跳转到页面[{}]", errorPage);
			request.setAttribute("redirectTargetUrl", errorPage);
		}
	}

	@Override
	public void handleForWxUser(WxMpUser wxMpUser, Map<String, String> paramsMap, HttpServletRequest request, HttpServletResponse response) {
		this.loginByOpenid(wxMpUser.getOpenId(), request, response);
	}
	
	private void loginByOpenid(String openId, HttpServletRequest request, HttpServletResponse response){
		WxMember wxMember = this.wxMemberService.queryByOpenId(openId);
		if (wxMember ==null) {
			String message = MessageFormat.format("微信登录失败，原因是 openid[{0}], wxmember找不到", openId);
			throw new CommonException(message);
		}
		
		if (StringUtils.isBlank(wxMember.getMemberId())) {
			throw new CommonException("微信登录失败，原因是 wxMember.getMemberId() 为空");
			
		}

		User user = this.userService.queryObjById(wxMember.getMemberId());
		if (user == null) {
			String message = MessageFormat.format("微信登录失败，原因是 user id[{0}] 用户找不到", wxMember.getMemberId());
			throw new CommonException(message);
		}

		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getLoginName(), this.getPassword(user));
		Authentication authResult = authenticationManager.authenticate(authentication);
		logger.debug("登录结果：" + authResult.getAuthorities());
		
		// 在 session 中保存 authResult
        sessionStrategy.onAuthentication(authResult, request, response);

        // 在当前访问线程中设置 authResult
        SecurityContextHolder.getContext().setAuthentication(authResult);
        request.getSession().setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
        logger.debug("登录结果存在session");


	}

	private String getPassword(User user) {
		Assert.isNotBlank(user.getPassword(), "帐号异常");
		
		String password = null;
		try {
			password = DESUtils.decrypt(user.getPassword(), Constant.SECRET_KEY);
			if (StringUtils.isNotBlank(user.getPasswordKey())) {
				password = password.replace(user.getPasswordKey(), "");
				password = DESUtils.decrypt(password, Constant.SECRET_KEY);
			}
		} catch (Exception e) {
			throw new CommonException("帐号异常", e);
		}
		
		return password;

	}

}
