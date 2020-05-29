package com.els.base.member.web.controller.member;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.els.base.core.entity.PageView;
import com.els.base.core.entity.ResponseResult;
import com.els.base.core.exception.CommonException;
import com.els.base.core.utils.Constant;
import com.els.base.member.entity.member.Member;
import com.els.base.member.entity.member.MemberExample;
import com.els.base.member.entity.member.MemberExample.Criteria;
import com.els.base.member.service.member.MemberExtInfoService;
import com.els.base.member.service.member.MemberService;
import com.els.base.member.utils.MemberConstant;
import com.els.base.sms.SmsManager;
import com.els.base.sms.SmsResponse;
import com.els.base.sms.utils.SmsConstanst;
import com.els.base.sms.utils.Supplier;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api("会员管理")
@Controller
@RequestMapping("member")
public class MemberController {

	@Resource
	protected MemberService memberService;
	
	@Resource
	protected MemberExtInfoService memberExtInfoService;
	
	/**
	 * 修改当前用户的资料
	 * @param member
	 * @return
	 * @throws Exception 
	 */
	@ApiOperation(value="请求获取手机验证码", httpMethod="GET")
	@RequestMapping("front/sendVerifyCode")
	@ResponseBody
	public ResponseResult<String> sendVerifyCode(String phoneNum, HttpSession session) throws Exception{
		if (StringUtils.isBlank(phoneNum) || !phoneNum.matches(MemberConstant.PHONE_NUM_REGEX)) {
			throw new CommonException("手机的格式不正确，请重新输入.");
		}
		
		Date verifyTime = (Date) session.getAttribute("verifyTimeForMember");
		Date now = new Date();
		
		if(verifyTime != null && (now.getTime() - verifyTime.getTime()) < 5000){
			throw new CommonException("验证码请求太频繁了，请稍候再请求");
		}
		session.setAttribute("verifyTimeForMember", now);
		
		String verifyCode = String.valueOf(RandomUtils.nextInt(8999) + 1000) ;
		String content = "正在修改个人资料，验证码["+verifyCode+"]";
		
		SmsResponse smsResponse = SmsManager.getInstance(Supplier.BAY_YUE).sendSingleMsgWithoutReport(phoneNum, content);
//		SmsResponse smsResponse = SmsManager.getInstance(Supplier.BAI_XI).sendSingleMsgWithoutReport(phoneNum, content);
//		SmsResponse smsResponse = SmsManager.getInstance(Supplier.MAI_CHE).sendSingleMsgWithoutReport(phoneNum, content);
		if (!SmsConstanst.SUCCESS_RESPONSE_CODE.equals(smsResponse.getRespstatus())) {
			throw new CommonException("获取验证码失败，因为:" +smsResponse.getRespMsg());
		}
		session.setAttribute("verifyCodeForMember", verifyCode);
		session.setAttribute("newPhoneNum", phoneNum);
		
		return ResponseResult.success();
	}
	
	/**
	 * 修改当前用户的资料
	 * @param member
	 * @return
	 */
	@ApiOperation(value="完善当前的会员信息", httpMethod="GET")
	@RequestMapping("front/editCurrentMember")
	@ResponseBody
	public ResponseResult<String> editCurrentMember(@RequestBody Member member, String verifyCode, HttpSession session){
		Member memberInSession = (Member) session.getAttribute("member");
		if (memberInSession == null || (StringUtils.isBlank(memberInSession.getId()))) {
			throw new CommonException("获取用户信息失败，请重新进入公众号登陆。");
		}
		
//		Member origin = (Member) session.getAttribute("member");
		
		if(StringUtils.isBlank(memberInSession.getMobilephone())
				|| (StringUtils.isNotBlank(member.getMobilephone()) && !memberInSession.getMobilephone().equals(member.getMobilephone()))){
			String newPhone = (String) session.getAttribute("newPhoneNum");
			if (!newPhone.equals(member.getMobilephone()) ) {
				throw new CommonException("提交的电话号码，与验证的号码不一致，请重新输入");
			}
			this.checkVerifyCode(session, verifyCode);
		}
		
		
		member.setId(memberInSession.getId());
		
		this.memberService.modifyObj(member);
		member = this.memberService.queryObjById(memberInSession.getId());
		session.setAttribute("member", member);
		return ResponseResult.success();
	}
	
	private void checkVerifyCode(HttpSession session, String verifyCode){
		String verifyCodeForMember = (String) session.getAttribute("verifyCodeForMember");
		Date verifyTime = (Date) session.getAttribute("verifyTimeForMember");
		
		if (StringUtils.isBlank(verifyCodeForMember) || StringUtils.isBlank(verifyCode) || !verifyCodeForMember.equals(verifyCode)) {
			throw new CommonException("验证码不正确，请重试");
		}
		
		if(verifyTime != null ){
			Date now = new Date();
			long expiredTime = verifyTime.getTime() + 120 * 1000;
			if(now.getTime() > expiredTime){
				throw new CommonException("时间已超过2分钟，验证码已过期,请重新请求验证码");
			}
		}
	}
	
	/**
	 * 获取当前会员信息
	 */
	@ApiOperation(value="获取当前的会员信息", httpMethod="GET")
	@RequestMapping("front/findCurrentMember")
	@ResponseBody
	public ResponseResult<Member> findCurrentMember(HttpServletRequest request) {
		// 获取session里面保存的对象
		Member memberInSession = (Member) request.getSession().getAttribute("member");
		if (memberInSession == null || (StringUtils.isBlank(memberInSession.getId()))) {
			throw new CommonException("获取用户信息失败，请重新进入公众号登陆。");
		}

		Member member = this.memberService.queryObjById(memberInSession.getId());

		return ResponseResult.success(member);
	}
	
	@ApiOperation(httpMethod="GET", value="根据openid登录")
	@RequestMapping("front/loginByOpenid")
	@ResponseBody
	public ResponseResult<Member> loginByOpenId(String openid, HttpSession session){
		Member member = this.memberService.queryByOpenId(openid);
		if (member == null) {
			throw new CommonException("获取用户信息失败，请跳转授权url。");
		}
		
		session.setAttribute("member", member);
		

		return ResponseResult.success(member);
	}

	/**
	 * 查询会员列表信息
	 * @param typeMember 会员分类
	 * @param industry 行业
	 * @param interest 兴趣
	 * @param province 
	 * @param city
	 * @param district
	 * @param pageNo
	 * @param pageSize
	 * @param sSearch
	 * @return
	 */
	@ApiOperation(value="分页查看会员列表", httpMethod="GET")
	@RequestMapping("service/findByPage")
	@ResponseBody
	public ResponseResult<PageView<Member>> findByPage(
			@RequestParam(value = "type", required=false) List<Integer> typeMember,
			@RequestParam(value = "industry", required=false) List<Integer> industry, 
			@RequestParam(value = "interest", required=false) List<Integer> interest,
			@RequestParam(defaultValue="0") int pageNo, 
			@RequestParam(defaultValue="10") int pageSize,
			String province, String city, String district, String sSearch) {
		MemberExample exampleOne = new MemberExample();
		PageView<Member> pageView = new PageView<>(pageNo, pageSize);
		exampleOne.setPageView(pageView);
		
		if (StringUtils.isNotBlank(sSearch)) {
			Criteria cri1 = exampleOne.createCriteria();
			cri1.andNameLike(sSearch + "%");
			Criteria cri2 = exampleOne.or();
			cri2.andTrueNameLike(sSearch +"%");
			if (StringUtils.isNumeric(sSearch)) {
				exampleOne.or().andMobilephoneLike(sSearch + "%");
			}
		}
		
		exampleOne.setOrderByClause("create_time DESC");
		return ResponseResult.success(this.memberService.queryObjByPage(exampleOne));
		
	}

	/**
	 * 添加会员
	 * 
	 * @param member
	 * @return
	 */
	@ApiOperation(value="添加会员", httpMethod="POST")
	@RequestMapping("service/create")
	@ResponseBody
	public ResponseResult<String> create(@ApiParam(value="会员信息") @RequestBody Member member) {
		member.setIsEnable(1);
		this.memberService.addObj(member);
		return ResponseResult.success();
	}

	/**
	 * 修改会员
	 * 
	 * @param member
	 * @return
	 */
	@ApiOperation(value="修改会员", httpMethod="POST", notes="注意必须带有会员的ID")
	@RequestMapping(value={"service/edit"})
	@ResponseBody
	public ResponseResult<String> edit(@RequestBody Member member) {
		this.memberService.modifyObj(member);
		return ResponseResult.success();
	}

	/**
	 * 查看会员详情
	 * 
	 * @param memberId
	 * @return
	 */
	@ApiOperation(value="查看会员详情", httpMethod="GET")
	@RequestMapping("service/findByMemberId")
	@ResponseBody
	public ResponseResult<Member> findByMemberId(String memberId) {
		Member member = this.memberService.queryObjById(memberId);
		return ResponseResult.success(member);
	}
	
	@ApiOperation(value="禁用会员", httpMethod="GET")
	@RequestMapping("service/setIsEnableById")
	@ResponseBody
	public ResponseResult<String> disableMember(String id, int isEnable) {
		Member member = this.memberService.queryObjById(id);
		if (member == null) {
			throw new CommonException("找不到该会员信息，请刷新重试");
		}
		Member m = new Member();
		if (Constant.YES_INT.equals(isEnable)) {
			m.setIsEnable(Constant.YES_INT);
		}else{
			m.setIsEnable(Constant.NO_INT);
		}
		m.setId(member.getId());
		this.memberService.modifyObj(m);
		return ResponseResult.success();
	}

	
	// 设置访问页面
	@ApiIgnore
	@RequestMapping("/service/toMainView")
	@ResponseBody
	public ModelAndView toNewMemberListForView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/member/toMainView");
		return mav;
	}

	// 查看会员详情页面
	@ApiIgnore
	@RequestMapping("/service/toUpdateViewById")
	@ResponseBody
	public ModelAndView toUpdateViewById(String memberId) {
		ModelAndView mav = new ModelAndView();
		Member member = this.memberService.queryObjById(memberId);
		mav.addObject("member", member);
		mav.setViewName("member/member/toAddView");
		return mav;
	}

	// 添加会员页面
	@ApiOperation(value="添加会员页面", httpMethod="GET")
	@RequestMapping("/service/toAddView")
	@ResponseBody
	public ModelAndView toAddView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/member/toAddView");
		return mav;
	}

}
