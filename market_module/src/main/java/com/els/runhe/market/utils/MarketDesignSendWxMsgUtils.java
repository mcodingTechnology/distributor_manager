package com.els.runhe.market.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.els.base.core.entity.user.User;
import com.els.base.core.entity.user.UserExample;
import com.els.base.core.exception.CommonException;
import com.els.base.core.service.user.UserService;
import com.els.base.utils.SpringContextHolder;
import com.els.base.wechat.member.entity.WxMember;
import com.els.base.wechat.member.entity.WxMemberExample;
import com.els.base.wechat.member.service.WxMemberService;
import com.els.base.wechat.msg.utils.WxMpTemplateMsgUtils;
import com.els.runhe.market.entity.design.MarketDesignApply;
import com.els.runhe.market.event.design.MarketDesignStatusEnum;

/**
 * 市场平面设计申请触发微信消息工具
 * @author wbin
 *
 */
public class MarketDesignSendWxMsgUtils {

	private static Logger logger = LoggerFactory.getLogger(MarketDesignSendWxMsgUtils.class);
	
	public static void sendMsg(MarketDesignStatusEnum marketDesignStatus, MarketDesignApply marketDesignApply){
		Set<String> userIdList = new HashSet<>();
		userIdList.add(marketDesignApply.getUserId());
		
		String contactUserId = MarketDesignSendWxMsgUtils.getUserByPhone(marketDesignApply.getContactPhone());
		if(StringUtils.isNotBlank(contactUserId)){
			userIdList.add(contactUserId);
		}
		
		MarketDesignSendWxMsgUtils.sendMsg(marketDesignStatus, userIdList, marketDesignApply);
	}
	
	public static void sendMsg(MarketDesignStatusEnum marketDesignStatus, List<MarketDesignApply> marketDesignList){
		if(CollectionUtils.isNotEmpty(marketDesignList)){
			for(int i=0;i<marketDesignList.size();i++){
				MarketDesignSendWxMsgUtils.sendMsg(marketDesignStatus, marketDesignList.get(i));
			}
		}
	}
	
	public static void sendMsg(MarketDesignStatusEnum marketDesignStatus, Set<String> receiverIdList, Object data){
		switch(marketDesignStatus) {
		case UN_CONFIRM:
			MarketDesignSendWxMsgUtils.sendMsg(receiverIdList, "TASK_STATUS_OPERATE", data);
			break;
		default:
			break;
		}
	}
	
	public static void sendMsg(Set<String> receiverIdList, String businessType, Object data){
		if (CollectionUtils.isEmpty(receiverIdList)) {
			return;
		}
		
		Iterator<String> iterator = receiverIdList.iterator();
		while (iterator.hasNext()) {
			MarketDesignSendWxMsgUtils.sendMsg(iterator.next(), businessType, data);
		}
	}

	public static void sendMsg(String receiverId, String businessType, Object data) {
		try {
			if (StringUtils.isBlank(receiverId)) {
				throw new CommonException("用户id为空");
			}
			
			WxMemberExample wxMemberExample = new WxMemberExample();
			wxMemberExample.createCriteria().andMemberIdEqualTo(receiverId);
			
			WxMemberService wxMemberService = SpringContextHolder.getOneBean(WxMemberService.class);
			List<WxMember> list = wxMemberService.queryAllObjByExample(wxMemberExample);
			if (CollectionUtils.isEmpty(list)) {
				logger.warn("微信模板消息发送失败，因为该用户["+ receiverId+"]还没有关联微信公众号");
				return;
			}
			
			for(WxMember wxMember : list){
				WxMpTemplateMsgUtils.sendWxMpTemplateMessage( businessType, data, wxMember);
				
			}
		} catch (Exception e) {
			logger.error("发送给微信模板消息失败" ,e);
		}
	}
	
	/**
	 * 获取相应电话号码的用户ID
	 * @param phone
	 * @return ID
	 */
	public static String getUserByPhone(String phone){
		if (StringUtils.isBlank(phone)) {
			return null;
		}
		
		UserExample userExample = new UserExample();
		userExample.createCriteria().andMobilePhoneEqualTo(phone);
		
		UserService userService = SpringContextHolder.getOneBean(UserService.class);
		List<User> list = userService.queryAllObjByExample(userExample);
		if (CollectionUtils.isEmpty(list)) {
			return null;
		}
		
		return list.get(0).getId();
	}
}
