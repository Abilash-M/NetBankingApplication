<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<ul>
                <li><a href="#" onclick="loadPage('AccountPages/BalanceEnquiry')">Balance Enquiry</a></li>
                <li><a href="#" onclick="loadPage('AccountPages/AccountStatement')">AccountStatement</a></li>
           <%--      <li><a href="#" onclick="loadPage('AccountPages/DownloadStatement')">Download Statement</a></li>			--%>
                <li><a href="#" onclick="loadPage('AccountPages/ChangePassword')">Change Password</a></li>
           <%--     <li><a href="#" onclick="loadPage('AccountPages/ChangeAtmPin')">Change ATM PIN</a></li>		--%>
                
     </ul>
</body>
</html>