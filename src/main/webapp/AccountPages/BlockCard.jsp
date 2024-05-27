<%@page import="com.letsCode.service.EncryptionService"%>
<%@page import="com.letsCode.dao.CardsDao"%>
<%@page import="java.util.*"%>
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


 <div style="margin-top:20px;position:relative;left:60px;top:30px; display: flex; align-items: center; gap: 20px;">
            <a href="./Home.jsp"><i class="fa-solid fa-house"></i></a>
        </div>
<div class="card w-50 " style="margin: 30px">
			<div class="card-header text-center">Block Card</div>
			<div class="card-body">

<s:form action="BlockCard" method="post">
        <s:select 
            id="CardSelect" 
            cssClass="form-control" 
            label="Select Your Card"
            list="cards" 
            listKey="CardNumber" 
            listValue="CardNumber" 
            name="CardNumber"/>
                    <s:submit cssClass="btn btn-primary" value="Submit" />
        
       
</s:form>

</div>
</div>

      <script src="https://kit.fontawesome.com/4176c29b3b.js" crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
      
</body>
</html>