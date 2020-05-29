package com.els.base.member.service.wechat;

import java.util.Map;

import com.els.base.core.service.BaseService;
import com.els.base.member.entity.wechat.StoreWxRef;
import com.els.base.member.entity.wechat.StoreWxRefExample;
import com.els.base.wechat.account.entity.AccountConfig;

import me.chanjar.weixin.mp.api.WxMpService;

public interface StoreWxRefService extends BaseService<StoreWxRef, StoreWxRefExample, Integer> {

	 public AccountConfig queryWxAccountByStoreId(String storeId);

	// public String queryWechatOauthUrlByRequest(HttpServletRequest request)
	// throws Exception;
	
	public String queryWxAppidByStoreId(String storeId);
	
	public String queryWxAppSecretByStoreId(String storeId);

	public boolean sendWxMpTemplateMessage(String storeId, String templateType, String receiverOpenid, String url,
			String keyword1, String keyword2, String keyword3, String keyword4, String keyword5) throws Exception;

	public boolean sendWxMpTemplateMessage(String storeId, String templateType, String receiverOpenid, String first,
			String remark, String url, String color, String keyword1, String keyword2, String keyword3, String keyword4,
			String keyword5) throws Exception;

	public String queryWechatOauthUrlForOpenId(String scheme, String serverName, int serverPort, String requestUri,
			Map<String, String> params, String ref) throws Exception;

	public String queryWechatOauthUrlForWxUserInfo(String scheme, String serverName, int serverPort, String requestUri,
			Map<String, String> params, String ref) throws Exception;

	public String queryWechatOauthUrlForOpenId(String scheme, String serverName, int serverPort, String requestUri,
			Map<String, String> params, String ref, boolean isShortUrl) throws Exception;

	public String queryWechatOauthUrlForWxUserInfo(String scheme, String serverName, int serverPort, String requestUri,
			Map<String, String> params, String ref, boolean isShortUrl) throws Exception;

//	public WxJsapiSignature getJsapiSignature(String scheme, String serverName, int serverPort, String requestUri) throws WxErrorException;
	
	public WxMpService queryWxMpServiceByStoreId(String storeId);

}