package com.els.runhe.cms.web.controller.test;

import org.springframework.stereotype.Controller;

@Controller
public class LoginPlugController {
	
	/*@Autowired
	protected UserService userService;
	
	@Autowired
	private UserRoleService rightService;
	
	@RequestMapping("front/loginByHk")
	public ModelAndView loginByHk(HttpSession session, String elsAccount, String elsSubAccount) {
		if(StringUtils.isBlank(elsAccount)){
			elsAccount = (String) session.getAttribute("elsAccount");// 账号
		}
		if (StringUtils.isBlank(elsSubAccount)) {
			elsSubAccount = (String) session.getAttribute("elsSubAccount");// 账号
		}
		
		if (StringUtils.isBlank(elsAccount) || StringUtils.isBlank(elsSubAccount)) {
			throw new HTTPException(403);
		}
		
		String loginName = elsAccount + "_" + elsSubAccount;
		
		UserExample userExample = new UserExample();
		userExample.createCriteria().andLoginNameEqualTo(loginName);
		
		User user = this.userService.findusername(loginName);
		if (user == null) {
			user = new User();
			user.setLoginName(loginName);
			user.setPassword("123456");
			this.userService.addObj(user);
			
			UserRole userRole = new UserRole();
			userRole.setRoleId(2);
			userRole.setUserId(user.getUserId());
			rightService.addObj(userRole);
		}
		
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginName, "123456");
		token.setDetails(user);
		AuthenticationManager authenticationManager = SpringContextHolder.getBean("authenticationManager");
		Authentication authenticatedUser = authenticationManager.authenticate(token);
		
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        
        return new ModelAndView("redirect:/index.html");
	}*/
	
	
}
