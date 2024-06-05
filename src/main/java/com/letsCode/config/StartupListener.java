//$Id$
package com.letsCode.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.letsCode.dao.DatabaseInitializationDao;
import com.letsCode.dao.DbInitialization;

public class StartupListener implements ServletContextListener{
	@Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
		//	DatabaseInitializationDao.initializeDatabase();
        	DbInitialization.initializeTables();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //if any
    }
}
