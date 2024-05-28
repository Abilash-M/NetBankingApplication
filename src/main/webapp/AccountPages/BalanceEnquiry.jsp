<%-- <%@page import="com.opensymphony.xwork2.ActionContext"%>		--%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance Enquiry</title>
</head>
<body>
				<s:if test="#session.balance != null">
        <p>Account balance: ${session.balance}</p>
    </s:if>
</body>
</html>