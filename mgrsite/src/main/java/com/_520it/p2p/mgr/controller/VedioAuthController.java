package com._520it.p2p.mgr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.p2p.base.query.VedioQueryObject;
import com._520it.p2p.base.service.IVedioAuthService;
import com._520it.p2p.base.util.JSONResult;

/**
 * 后台视频审核控制器
 * @author Administrator
 * 
 */
@Controller
public class VedioAuthController {

	@Autowired
	private IVedioAuthService vedioAuthService;

	/**
	 * 后台视频审核列表
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("vedioAuth")
	public String vedioAuth(@ModelAttribute("qo") VedioQueryObject qo,
			Model model) {
		model.addAttribute("pageResult", vedioAuthService.queryRealAuth(qo));
		return "vedioAuth/list";
	}

	/**
	 * 后台审核视频认证
	 * @param applierId
	 * @param remark
	 * @param state
	 * @return
	 */
	@RequestMapping("vedioAuth_audit")
	@ResponseBody
	public JSONResult audit(Long applierId,String remark,int state){
		JSONResult jsonResult=new JSONResult();
		try {
			vedioAuthService.audit(applierId,remark,state);
		} catch (Exception e) {
			jsonResult.mark(e.getMessage());
		}
		return jsonResult;
	}
	
	/**
	 * 视频审核的自动补全
	 * @param query 用户名输入框的内容
	 * @return
	 */
	@RequestMapping("autocomplete")
	@ResponseBody
	public List<Map<String, Object>> autocomplete(String query){
		return vedioAuthService.autocomplete(query);
	}
}
