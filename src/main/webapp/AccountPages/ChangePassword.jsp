<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>
	<div
		class="container d-flex  align-items-center h-100">
		<div class="card w-50 ">
			<div class="card-header text-center">Change Password</div>
			<div class="card-body">
				<s:form action="ChangeNetBankingPassword">
						<s:textfield key="OldPassword" cssClass="form-control" label="Enter old password " />
						<s:textfield key="NewPassword" cssClass="form-control" label="Enter new password " />
						<s:textfield key="ConfirmNewPassword" cssClass="form-control" label="Confirm new password " />
						<s:submit cssClass="btn btn-secondary btn-sm" value="Change Pin" />
				</s:form>
			</div>
		</div>
	
		</div>
</body>
</html>