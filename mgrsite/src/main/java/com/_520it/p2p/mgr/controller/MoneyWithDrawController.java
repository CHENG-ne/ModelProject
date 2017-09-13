package com._520it.p2p.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.p2p.base.util.JSONResult;
import com._520it.p2p.business.query.MoneyWithDrawQueryObject;
import com._520it.p2p.business.service.IMoneyWithDrawService;

/**
 * 后台提现控制器
 * @author Administrator
 *
 */
@Controller
public class MoneyWithDrawController {

	@Autowired
	private IMoneyWithDrawService moneyWithDrawService;
	
	/**
	 * 跳转提现审核页面
	 * @param model
	 * @return
	 */
	@RequestMapping("moneyWithdraw")
	public String moneyWithDraw(Model model,@ModelAttribute("qo")MoneyWithDrawQueryObject qo){
		model.addAttribute("pageResult", moneyWithDrawService.query(qo));
		return "moneywithdraw/list";
	}
	/**
	 * 审核提现
	 */
	@RequestMapping("moneyWithdraw_audit")
	@ResponseBody
	public JSONResult audit(Long id,String remark,int state){
		JSONResult jsonResult=new JSONResult();
		try {
			moneyWithDrawService.aduit(id,remark,state);
		} catch (Exception e) {
			jsonResult.mark(e.getMessage());
		}
		return jsonResult;
	}
}
