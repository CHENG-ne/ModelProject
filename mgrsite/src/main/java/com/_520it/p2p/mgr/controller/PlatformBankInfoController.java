package com._520it.p2p.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com._520it.p2p.business.domain.PlatformBankInfo;
import com._520it.p2p.business.query.PlatformBankInfoQueryObject;
import com._520it.p2p.business.service.IPlatformBankInfoService;

/**
 * 后台账户相关控制器
 * 
 * @author Administrator
 * 
 */
@Controller
public class PlatformBankInfoController {

	@Autowired
	private IPlatformBankInfoService platformBankInfoService;

	/**
	 * 后台账户相关列表
	 * 
	 * @param model
	 * @param qo
	 * @return
	 */
	@RequestMapping("companyBank_list")
	public String companyBankList(Model model,@ModelAttribute("qo") PlatformBankInfoQueryObject qo) {
		model.addAttribute("pageResult", platformBankInfoService.query(qo));
		return "platformbankinfo/list";
	}

	/**
	 * 更新或保存账户信息
	 */
	@RequestMapping("companyBank_update")
	public String saveOrUpdate(PlatformBankInfo bankInfo) {
		platformBankInfoService.saveOrUpdate(bankInfo);
		return "redirect:/companyBank_list.do";
	}
}
