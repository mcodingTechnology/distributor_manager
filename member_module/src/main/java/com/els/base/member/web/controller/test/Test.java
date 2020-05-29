package com.els.base.member.web.controller.test;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.els.base.core.entity.ResponseResult;
import com.els.base.member.entity.member.Member;
import com.els.base.member.service.member.MemberService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Api("测试用接口")
@Controller
@RequestMapping("test")
public class Test {
	
	@Resource
	protected MemberService memberService;
	
//	@Resource
//	protected StoreService storeService;

//	@MemberPointable(using=CommonMemberPointRuleHandler.class,targetMemberIndex=0,pointSourceIndex=1)
	@ApiOperation(value="设置用户账号", httpMethod="GET")
	@RequestMapping("setMemberInSession")
	@ResponseBody
	public ResponseResult<String> setMemberInSession(String memberId, HttpSession session){
		Member me = this.memberService.queryObjById(memberId);// 测试数据id
		
//		System.out.println("----------------"+me.getCreateTime()+"---------------------------------");
		session.setAttribute("member", me);
		session.setAttribute("memberId", me.getId());
		if(me.getWxMember() != null){
			session.setAttribute("openid", me.getWxMember().getWxOpenid());
		}else{
			session.setAttribute("openid", "test_open_id");
		}
		session.setAttribute("wxMpUser", new WxMpUser());
		
		session.setAttribute("isGetWxUserInfo", "true");
		
		return ResponseResult.success();
	}
	
	/*@ApiOperation(value="设置storeId", httpMethod="GET")
	@RequestMapping("setStoreInSession")
	@ResponseBody
	public ResponseResult<String> setStoreInSession(int storeId, HttpSession session){
		Store store = this.storeService.queryObjById(storeId);
		session.setAttribute("store", store);
		session.setAttribute("storeId", storeId);
		
		
		ResponseResult<String> result = new ResponseResult<>();
		result.setSize(0);
		result.setMsg("ok");
		result.setStatus("00");
		return result;
	}*/
}
