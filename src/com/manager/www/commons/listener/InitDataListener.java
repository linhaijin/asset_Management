package com.manager.www.commons.listener;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;


/**
 * @author djx
 * @date 2015-8-17
 * @description
 */
public class InitDataListener implements InitializingBean, ServletContextAware{
    @Override
    public void setServletContext(ServletContext context) {

    	System.out.println("项目初始化。。。");
    }
    
    
    @Override
    public void afterPropertiesSet() throws Exception {
        
    }
}