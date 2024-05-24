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
        <label for="CardSelect">Select Card Type </label>
			<s:select 
			class="form-control"
            id="CardTypeSelect" 
            cssClass="form-control" 
            list="#{'debit':'DebitCard','credit':'CreditCard'}" 
            name="CardType" 
            onchange="updateHiddenInput(this.value)" />
                    <s:submit cssClass="btn btn-primary" value="Submit" />
        
       
</s:form>

</div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>