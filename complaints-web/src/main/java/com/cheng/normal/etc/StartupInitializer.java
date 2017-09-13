package com.cheng.normal.etc;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author cheng
 * @date 2017年8月23日  下午3:29:01
 */
public class StartupInitializer implements ServletContextListener {
	
	/* (non-Javadoc) 销毁
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc) 初始化
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.err.println("================服务器初始化=================");
		sce.getServletContext().setAttribute("ctx", sce.getServletContext().getContextPath());
		System.out.println(sce.getServletContext().getServletContextName());
	}

}
