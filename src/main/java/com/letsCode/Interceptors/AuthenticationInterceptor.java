//$Id$
package com.letsCode.Interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.letsCode.dao.AccountsDao;
import com.letsCode.service.EncryptionService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor,SessionAware{
	private Map<String, Object> session;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String NetBankingUserId="";
        try {
            NetBankingUserId=(EncryptionService.decrypt((String)session.get("NetBankingUserId")));

		} catch (Exception e) {
			// TODO: handle exception
		}
        if(AccountsDao.checkIfAccountExists(NetBankingUserId)) {
        	
            invocation.invoke();  
        }
        else {
        	response.sendRedirect(request.getContextPath()+ "/logoutPage");

        }
		return null;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
