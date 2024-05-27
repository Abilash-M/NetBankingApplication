<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Atm Pin </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
 <div style="margin-top:20px;position:relative;left:60px;top:30px; display: flex; align-items: center; gap: 20px;">
            <a href="./Home.jsp"><i class="fa-solid fa-house"></i></a>
        </div>
	<div
		class="container d-flex  align-items-center h-100">
		<div class="card w-50 ">
			<div class="card-header text-center">Change ATM pin</div>
			<div class="card-body">
				<s:form action="ChangeAtmPin">
				        <s:select 
				            id="CardSelect" 
				            cssClass="form-control" 
				            label="Select Your Card"
				            list="cards" 
				            listKey="CardNumber" 
				            listValue="CardNumber" 
				            name="CardNumber"/>			 
				<%--		<s:textfield key="CardNumber" cssClass="form-control" label="Enter your card number " />		  --%>
						<s:textfield key="OldPin" cssClass="form-control" label="Enter old pin " />
						<s:textfield key="NewPin" cssClass="form-control" label="Enter new pin " />
						<s:submit cssClass="btn btn-secondary btn-sm" value="Change Pin" />
				</s:form>
			</div>
		</div>
		</div>
		      <script src="https://kit.fontawesome.com/4176c29b3b.js" crossorigin="anonymous"></script>
		          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
		
</body>
</html>