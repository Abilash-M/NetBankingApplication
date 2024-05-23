<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="card w-50 ">
			<div class="card-header text-center">Transfer To Mobile Number</div>
			<div class="card-body">
				<s:form action="MobileNumberFundTransfer">
						<s:textfield key="ToPhoneNumber" cssClass="form-control" label="Enter Receiver's Mobile Number " />
						<s:textfield key="Amount" cssClass="form-control" label="Enter Amount in Rs " />
						<s:submit cssClass="btn btn-secondary btn-sm" value="Transfer Funds" />
				</s:form>
			</div>
		</div>
</body>
</html>