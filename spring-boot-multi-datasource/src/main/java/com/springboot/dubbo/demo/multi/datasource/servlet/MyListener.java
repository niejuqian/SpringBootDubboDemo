package com.springboot.dubbo.demo.multi.datasource.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by laonie on 2018/9/20.
 */
@WebListener
public class MyListener implements ServletContextListener {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("===================contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("===================contextDestroyed");
    }
}
