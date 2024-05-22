<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Atm Pin </title>
</head>
<body>
	<div
		class="container d-flex  align-items-center h-100">
		<div class="card w-50 ">
			<div class="card-header text-center">Change ATM pin</div>
			<div class="card-body">
				<s:form action="ChangeAtmPin">
						<s:textfield key="CardNumber" cssClass="form-control" label="Enter your card number " />
						<s:textfield key="OldPin" cssClass="form-control" label="Enter old pin " />
						<s:textfield key="NewPin" cssClass="form-control" label="Enter new pin " />
						<s:submit cssClass="btn btn-secondary btn-sm" value="Change Pin" />
				</s:form>
			</div>
		</div>
		</div>
</body>
</html>