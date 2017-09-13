package com.cheng.normal.base.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cheng.normal.base.vo.VerifyCodeVO;


/**
 * 用户的上下文
 */
public class UserContext {
	public static final String USER_IN_SESSION="logininfo";
	public static final String VERIFYCODE_IN_SESSION="verifycode_in_session";

	private static HttpSession getSession() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest().getSession();
	}
	/*public static void setCurrentUser(Logininfo current){
		getSession().setAttribute(USER_IN_SESSION, current);
	}
	
	public static Logininfo getCurrentUser(){
		return (Logininfo) getSession().getAttribute(USER_IN_SESSION);
	}*/
	
	//把手机验证码信息存放在session中
	public static void setVerifyCodeVO(VerifyCodeVO vo){
		getSession().setAttribute(VERIFYCODE_IN_SESSION, vo);
	}
	//在session中取出手机验证码信息
	public static VerifyCodeVO getVerifyCodeVO(){
		return (VerifyCodeVO) getSession().getAttribute(VERIFYCODE_IN_SESSION);
	}
}
