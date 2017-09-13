package com._520it.p2p.mgr.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com._520it.p2p.business.service.ISystemAccountService;

//当Spring容器创建的时候,初始化系统账户
@Component
public class InitSystemAccountListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ISystemAccountService systemAccountService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		systemAccountService.initSystemAccount();
	}

}
