<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open New Account</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
		<div
		class="container d-flex justify-content-center align-items-center h-100">
		<div class="card w-50">
			<div class="card-header text-center">Create Account</div>
			<div class="card-body">
				<s:form action="openAccount">
						<s:textfield key="AccountNumber" cssClass="form-control" label="Enter your customised account number " />
						<s:textfield key="AccountHolderName" cssClass="form-control" label="Enter your Name(As in aadhar card) " />
						<s:textfield key="PhoneNumber" cssClass="form-control" label="Enter your Phone Number " />
						<s:textfield key="EmailId" cssClass="form-control" label="Enter your email " />
						<s:textfield key="ResidentialAddress" cssClass="form-control" label="Enter your Residential Address(As in aadhar card) " />
						<s:textfield key="ResidentialCity" cssClass="form-control" label="Enter your Residential City " />
						<s:textfield key="NetBankingUserId" cssClass="form-control" label="Enter your NetBanking UserId " />
						<s:password key="NetBankingPassword" cssClass="form-control" label="Enter Netbanking Password " />
 				 	    <s:textfield key="DateOfBirth" cssClass="form-control" label="Enter your DOB(as in aadhar card)" type="date" />
 						<s:textfield key="AccountBalance" cssClass="form-control" label="Opening Balance"  />
						<s:submit cssClass="btn btn-primary" value="Create Account" />
				</s:form>
			</div>
		</div>
	</div>
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>