package com.els.runhe.order.utils;

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
import com.els.runhe.order.entity.Order;

/**
 * 订单触发微信消息工具
 * @author hzy
 *
 */
public abstract class OrderSendWxMsgUtils {
	
	private static Logger logger = LoggerFactory.getLogger(OrderSendWxMsgUtils.class);
	
	public static final String ORDER_STATUS_UN_PAID = "ORDER_STATUS_UN_PAID";
	public static final String ORDER_STATUS_UN_SENT = "ORDER_STATUS_UN_SENT";
	public static final String ORDER_STATUS_UN_RECEIVED = "ORDER_STATUS_UN_RECEIVED";
	public static final String ORDER_STATUS_FININSH = "ORDER_STATUS_FININSH";
	public static final String ORDER_STATUS_CANCEL = "ORDER_STATUS_CANCEL";
	
	/*public static void sendMsg(String orderStatus, Set<String> receiverIdList, Object data){
		switch (orderStatus) {
		case UN_PAID:
			sendMsg(receiverIdList, "ORDER_STATUS_UN_PAID", data);
			break;
		case UN_SENT:
			sendMsg(receiverIdList, "ORDER_STATUS_UN_SENT", data);
			break;
		case UN_RECEIVED:
			sendMsg(receiverIdList, "ORDER_STATUS_UN_RECEIVED", data);
			break;
		case FININSH:
			sendMsg(receiverIdList, "ORDER_STATUS_FININSH", data);
			break;
		}
	}*/
	
	public static void sendMsg(String orderStatus, Order order){
		Set<String> userIdList = new HashSet<>();
		userIdList.add(order.getUserId());
		
		String orderUserId = getUserByPhone(order.getOrderUserPhone());
		if (StringUtils.isNotBlank(orderUserId)) {
			userIdList.add(orderUserId);
		}
		
		String addressUserId = getUserByPhone(order.getAddressPhone());
		if (StringUtils.isNotBlank(addressUserId)) {
			userIdList.add(addressUserId);
		}
		
		OrderSendWxMsgUtils.sendMsg(userIdList ,orderStatus,  order);
	}
	
	public static void sendMsg(String orderStatus, List<Order> orderList){
		for(int i=0; CollectionUtils.isNotEmpty(orderList) && i<orderList.size(); i++){
			OrderSendWxMsgUtils.sendMsg(orderStatus, orderList.get(i));
		}
	}
	
	public static void sendMsg(Set<String> receiverIdList, String businessType, Object data){
		if (CollectionUtils.isEmpty(receiverIdList)) {
			return;
		}
		
		Iterator<String> iterator = receiverIdList.iterator();
		while (iterator.hasNext()) {
			OrderSendWxMsgUtils.sendMsg(iterator.next(), businessType, data);
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
