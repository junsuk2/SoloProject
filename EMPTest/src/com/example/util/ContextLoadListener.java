package com.example.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class ContextLoadListener
 *
 */
@WebListener
public class ContextLoadListener implements ServletContextListener {
	static Logger logger = LoggerFactory.getLogger(ContextLoadListener.class);
    /**
     * Default constructor. 
     */
    public ContextLoadListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    		myBatisUtil util = myBatisUtil.getInstance();
    		SqlSession session = util.getSession();
    		logger.trace("session : {}",util.getSession());
    }
	
}
