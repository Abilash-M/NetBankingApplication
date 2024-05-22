<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Download Statement</title>
</head>
<body>
	<div
		class="container d-flex  align-items-center h-100">
		<div class="card w-50 ">
			<div class="card-header text-center">Download Statement</div>
			<div class="card-body">
				<s:form action="openAccount">
 					    <s:textfield key="FromDate" cssClass="form-control" label="From Date" type="date" />
 						<s:textfield key="ToDate" cssClass="form-control" label="To Date" type="date" />
						<s:submit cssClass="btn btn-secondary btn-sm" value="Download Statement" />
						</s:form>
			</div>
		</div>
		</div>
</body>
</html>