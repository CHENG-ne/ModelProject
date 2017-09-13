package com._520it.p2p.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.p2p.base.util.JSONResult;
import com._520it.p2p.business.query.RechargeOfflineQueryObject;
import com._520it.p2p.business.service.IPlatformBankInfoService;
import com._520it.p2p.business.service.IRechargeOfflineService;

/**
 * 后台线下充值相关控制器
 * @author Administrator
 *
 */
@Controller
public class RechargeOfflineController {

	@Autowired
	private IPlatformBankInfoService platformBankInfoService;
	@Autowired
	private IRechargeOfflineService rechargeOfflineService;
	
	/**
	 * 跳转后台线下充值审核页面
	 * @param model
	 * @param qo
	 * @return
	 */
	@RequestMapping("rechargeOffline")
	public String rechargeIndex(Model model,@ModelAttribute("qo")RechargeOfflineQueryObject qo){
		model.addAttribute("pageResult", rechargeOfflineService.query(qo));
		model.addAttribute("banks", platformBankInfoService.listAll());
		return "rechargeoffline/list";
	}
	
	/**
	 * 线下充值审核
	 */
	@RequestMapping("rechargeOffline_audit")
	@ResponseBody
	public JSONResult audit(Long id,int state,String remark){
		JSONResult jsonResult=new JSONResult();
		try {
			rechargeOfflineService.audit(id,state,remark);
		} catch (Exception e) {
			jsonResult.mark(e.getMessage());
		}
		return jsonResult;
	}
}
