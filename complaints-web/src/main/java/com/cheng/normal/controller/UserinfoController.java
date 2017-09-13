package com.cheng.normal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cheng.normal.base.domain.Userinfo;
import com.cheng.normal.base.service.IUserinfoService;


/**
 * @author cheng
 * @date 2017年8月17日  下午2:12:15
 */
@RestController//(该类下的方法默认返回json格式数据)
@RequestMapping(value="/user")
public class UserinfoController extends BaseController {
	@Autowired
	private IUserinfoService userinfoService;
	
	/**
	 * 根据条件过滤查询用户列表
	 */
	@RequestMapping(value="/query",method=RequestMethod.POST)
	public List<Userinfo> selectUserinfoByCondition(Userinfo entity) {
		return userinfoService.selectAll();
	}
}
