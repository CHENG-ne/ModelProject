package com._520it.p2p.mgr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.p2p.base.domain.Logininfo;
import com._520it.p2p.base.service.ILogininfoService;
import com._520it.p2p.base.util.JSONResult;

//后台登录
@Controller
public class LogininfoController {

	@Autowired
	private ILogininfoService logininfoService;
	
	@RequestMapping("login")
	@ResponseBody
	public JSONResult login(String username,String password,HttpServletRequest request){
		JSONResult jsonResult=new JSONResult();
		Logininfo current = logininfoService.login(username,password,request.getRemoteAddr(),Logininfo.USER_MANAGER);
		if(current==null){
			jsonResult.mark("帐号或密码不正确!");
		}
		return jsonResult;
	}
	
	//后台首页
	@RequestMapping("index")
	public String index(){
		return "main";
	}
}
