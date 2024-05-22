//$Id$
package com.letsCode.controllers;

import com.letsCode.dao.DatabaseInitializationDao;
import com.opensymphony.xwork2.ActionSupport;

public class DatabaseInitializationAction extends ActionSupport {
	@Override
    public String execute() throws Exception {
        DatabaseInitializationDao.initializeDatabase();
        return SUCCESS;
    }
}
