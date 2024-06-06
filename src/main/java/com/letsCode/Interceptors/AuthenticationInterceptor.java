//$Id$
package com.letsCode.Interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.letsCode.dao.AccountsDao;
import com.letsCode.service.EncryptionService;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor{
	//private Map<String, Object> session;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        String NetBankingUserId="";
        try {
        	HttpSession session = ServletActionContext.getRequest().getSession(false);
//        	System.out.println(session);
        	if(session != null) {
        		NetBankingUserId=session.getAttribute("NetBankingUserId").toString();
        	}
//        	System.out.println("post"+ NetBankingUserId);
        	NetBankingUserId=EncryptionService.decrypt(NetBankingUserId);
//        	System.out.println("post++    " + NetBankingUserId);
        //    NetBankingUserId=(EncryptionService.decrypt((String)session.get("NetBankingUserId")));

		} catch (Exception e) {
			e.printStackTrace();
		}
//        System.out.println("bool"+ AccountsDao.checkIfAccountExists(NetBankingUserId));
        if(AccountsDao.checkIfAccountExists(NetBankingUserId)) {
//        	System.out.println("invoked");
            invocation.invoke();  
        }
        else {
        	response.sendRedirect(request.getContextPath()+ "/logoutPage");
        }
		return null;
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
