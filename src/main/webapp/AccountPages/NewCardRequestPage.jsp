 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body> 
	<div class="card w-50 " style="margin: 30px">
			<div class="card-header text-center">New Card Request</div>
			<div class="card-body">

<s:form action="AllotCard" method="post">
			<s:select 
			class="form-control"
            id="CardTypeSelect" 
            cssClass="form-control" 
            label="Select Card Type"
            list="#{'debit':'DebitCard','credit':'CreditCard'}" 
            name="CardType" 
            onchange="updateHiddenInput(this.value)" />
            <s:select 
			class="form-control"
            id="CreditLimitSelect" 
            cssClass="form-control" 
            label="Select Credit Limit"
            list="#{0:'N/A',100000:100000,50000:50000}" 
            name="CreditLimit" 
            onchange="updateHiddenInput(this.value)" />
                    <s:submit cssClass="btn btn-primary" value="Submit" />
        
       
</s:form>

</div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>