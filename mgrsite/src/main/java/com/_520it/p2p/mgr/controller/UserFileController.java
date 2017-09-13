package com._520it.p2p.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.p2p.base.query.UserFileQueryObject;
import com._520it.p2p.base.service.IUserFileService;
import com._520it.p2p.base.util.JSONResult;
/**
 * 后台风控材料控制器
 * @author Administrator
 *
 */
@Controller
public class UserFileController {

	@Autowired
	private IUserFileService userFileService;
	
	/**
	 * 后台风控材料列表
	 * @return
	 */
	@RequestMapping("userFileAuth")
	public String userFileAuth(Model model,@ModelAttribute("qo")UserFileQueryObject qo){
		model.addAttribute("pageResult", userFileService.query(qo));
		return "userFileAuth/list";
	}
	
	/**
	 * 后台审核风控材料对象
	 * @param id 风控对象ID
	 * @param state 风控材料状态
	 * @param score 分数
	 * @param remark 备注
	 */
	@RequestMapping("userFile_audit")
	@ResponseBody
	public JSONResult audit(Long id,int state,int score,String remark){
		JSONResult jsonResult=new JSONResult();
		try {
			userFileService.audit(id,state,score,remark);
		} catch (Exception e) {
			jsonResult.mark(e.getMessage());
		}
		return jsonResult;
	}
}
