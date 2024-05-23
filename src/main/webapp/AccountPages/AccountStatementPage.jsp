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

	<table class="table" id= "statementTable">
                    <thead>
                        <tr>
                            <th>Transaction ID</th>
                            <th>To</th>
                            <th>Amount</th>
                            <th>Date</th>
                            <th>Type</th>
                            
                        </tr>
                    </thead>
                    <tbody>

					<s:iterator value="transactions">
					    <tr>
					        <td><s:property value="TransactionId" /></td>
					        <td><s:property value="ToAccountNumber" /></td>
					        <td><s:property value="TransactionValue" /></td>
					        <td><s:property value="TransactionDate" /></td>
					        <td><s:property value="TransactionType" /></td>					        
					    </tr>
					</s:iterator>
					                       
                    </tbody>
                </table>
                <div style="position: relative; left: 760px; display: flex; align-items: center; gap: 20px; ">
                		<a href="../Home.jsp" ><i class="fa-solid fa-house"></i></a>
   	                <button id="downloadTable" ><i class="fa-solid fa-download"></i></button>
                </div>

    <script>
    document.getElementById('downloadTable').addEventListener('click', function() {
        var element = document.getElementById('statementTable');        
        var opt = {
          margin:       0.5,
          filename:     'StatementTable.pdf',
          image:        { type: 'jpeg', quality: 0.98 },
          html2canvas:  { scale: 2 },
          jsPDF:        { unit: 'in', format: 'letter', orientation: 'portrait' }
        };
        html2pdf().set(opt).from(element).save();
    });
    </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.2/html2pdf.bundle.min.js"></script>
                <script src="https://kit.fontawesome.com/4176c29b3b.js" crossorigin="anonymous"></script>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
                
</body>
</html>