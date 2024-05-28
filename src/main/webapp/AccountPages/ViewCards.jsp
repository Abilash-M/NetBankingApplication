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
	<table class="table" id= "CardDetails">
                    <thead>
                        <tr>
                            <th>Account Number</th>
                            <th>Card Number</th>
                            <th>Expiry Date</th>
                            <th>CVV</th>
                            <th>Name On Card</th>
                            <th>Card Type</th>
                            <th>Card Status</th>
                            <th>Credit Limit</th>

                        </tr>
                    </thead>
                    <tbody>

					<s:iterator value="cards">
					    <tr>
					        <td><s:property value="AccountNumber" /></td>
					        <td><s:property value="CardNumber" /></td>
					        <td><s:property value="ExpiryDate" /></td>
					        <td><s:property value="Cvv" /></td>
					        <td><s:property value="NameOnCard" /></td>	
					        <td><s:property value="CardType" /></td>					        
					        <td><s:property value="CardStatus" /></td>					        
					        <td><s:property value="CreditLimit" /></td>					        
					    </tr>
					</s:iterator>
                    </tbody>
                </table>
               <div style="position: relative; left: 760px; display: flex; align-items: center; gap: 20px; ">
                		<a href="./Home.jsp" ><i class="fa-solid fa-house"></i></a>
                </div>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.min.js"></script>
                <script src="https://kit.fontawesome.com/4176c29b3b.js" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
           
</body>
</html>