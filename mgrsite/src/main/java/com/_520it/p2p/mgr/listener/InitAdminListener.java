package com._520it.p2p.mgr.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com._520it.p2p.base.service.ILogininfoService;

//当Spring容器创建成功时,创建第一个管理员
@Component
public class InitAdminListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private ILogininfoService logininfoService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("******************初始化管理员帐号*******************");
		logininfoService.initAdmin();
	}

}
