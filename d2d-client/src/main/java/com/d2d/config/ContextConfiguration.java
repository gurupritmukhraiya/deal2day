package com.d2d.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextConfiguration implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("Sevlet Configuration...............!!!!!!!!!!!!");
		ServletContext context = servletContextEvent.getServletContext();
		if(context != null && context.getInitParameter("currentEnv") != null){
			String currentEnv = context.getInitParameter("currentEnv");
			System.setProperty("currentEnv", currentEnv);
		}		
	}
}
