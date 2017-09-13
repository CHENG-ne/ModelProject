package com._520it.p2p.mgr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com._520it.p2p.base.util.UserContext;

//登录拦截器继承拦截适配器
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//判断session中是否存在logininfo对象
		if(UserContext.getCurrentUser()==null){
			response.sendRedirect("/login.html");
			return false;
		}
		return true;
	}
}
