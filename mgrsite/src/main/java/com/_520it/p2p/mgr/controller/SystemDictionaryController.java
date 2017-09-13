package com._520it.p2p.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.p2p.base.domain.SystemDictionary;
import com._520it.p2p.base.domain.SystemDictionaryItem;
import com._520it.p2p.base.query.SystemDictionaryQueryObject;
import com._520it.p2p.base.service.ISystemDictionaryService;
import com._520it.p2p.base.util.JSONResult;

@Controller
public class SystemDictionaryController {

	@Autowired
	private ISystemDictionaryService systemDictionaryService;

	// 数据字典分类列表
	@RequestMapping("systemDictionary_list")
	public String systemDictionary(Model model,
			@ModelAttribute("qo") SystemDictionaryQueryObject qo) {
		model.addAttribute("pageResult", systemDictionaryService.queryDics(qo));
		return "systemdic/systemDictionary_list";
	}

	// 保存或新增数据字典分类
	@RequestMapping("systemDictionary_update")
	@ResponseBody
	public JSONResult addOrUpdateDic(SystemDictionary sd) {
		JSONResult jsonResult = new JSONResult();
		try {
			// service层判断是新增还是更改
			systemDictionaryService.saveOrUpdateDic(sd);
		} catch (Exception e) {
			jsonResult.mark(e.getMessage());
		}
		return jsonResult;
	}
	
	//--------------------------------------------------------
	
	// 数据字典明细列表
	@RequestMapping("systemDictionaryItem_list")
	public String systemDictionaryItem(Model model,
			@ModelAttribute("qo") SystemDictionaryQueryObject qo) {
		model.addAttribute("pageResult", systemDictionaryService.queryItems(qo));
		model.addAttribute("systemDictionaryGroups", systemDictionaryService.listAllDic());
		return "systemdic/systemDictionaryItem_list";
	}

	// 保存或新增数据字典明细
	@RequestMapping("systemDictionaryItem_update")
	@ResponseBody
	public JSONResult addOrUpdateItem(SystemDictionaryItem item) {
		JSONResult jsonResult = new JSONResult();
		try {
			// service层判断是新增还是更改
			systemDictionaryService.saveOrUpdateItems(item);
		} catch (Exception e) {
			jsonResult.mark(e.getMessage());
		}
		return jsonResult;
	}
}
