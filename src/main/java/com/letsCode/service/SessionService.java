//$Id$
package com.letsCode.service;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class SessionService {
	public static Object getSessionAttribute(String attributeName) {
    	HttpSession session = ServletActionContext.getRequest().getSession(false);
    	if(session != null) {
    		return session.getAttribute(attributeName);
    	}
    	return null;
	}
	
	
	public static Object setSessionAttribute(String attributeName, Object value) {
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute(attributeName, value);
    	return null;
	}
}
