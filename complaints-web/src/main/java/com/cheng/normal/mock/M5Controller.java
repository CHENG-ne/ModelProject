package com.cheng.normal.mock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class M5Controller {

	@RequestMapping("sendMsg")
	@ResponseBody
	public String send(String username, String password, String aipKey,
			String mobile, String content) {
		System.out.println("给"+mobile+"发送验证码为:"+content);
		return "success";
	}
}
