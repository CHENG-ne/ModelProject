package com._520it.p2p.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.p2p.base.query.RealAuthQueryObject;
import com._520it.p2p.base.service.IRealAuthService;
import com._520it.p2p.base.util.JSONResult;

/**
 * 后台实名认证审核相关
 * @author Administrator
 *
 */
@Controller
public class RealAuthController {
	
	@Autowired
	private IRealAuthService realAuthService;
	
	@RequestMapping("realAuth")
	public String realAuth(@ModelAttribute("qo")RealAuthQueryObject qo,Model model){
		model.addAttribute("pageResult", realAuthService.queryRealAuth(qo));
		return "realAuth/list";
	}
	
	@RequestMapping("realAuth_audit")
	@ResponseBody
	public JSONResult audit(Long id, String remark, int state){
		JSONResult jsonResult=new JSONResult();
		try {
			realAuthService.audit(id,remark,state);
		} catch (Exception e) {
			jsonResult.mark("审核失败,请联系管理员!异常信息:"+e.getMessage());
			e.printStackTrace();
		}
		
		return jsonResult;
	}
}
