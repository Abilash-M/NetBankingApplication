
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <%@ taglib prefix="s" uri="/struts-tags"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="styles.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    
</head>
<body>
<%
    if (session.getAttribute("accountNumber") == null) {
        response.sendRedirect("loginPage"); 
    }
%>

    <header>
        <nav>
			  <ul class="nav nav-underline nav-fill">
					  <li class="nav-item">
					    <a class="nav-link" aria-current="page" href="#" onclick="loadSideBar('HomePages/Accounts')">Accounts</a>
					  </li>
					  <li class="nav-item">
					    <a class="nav-link" href="#" onclick="loadSideBar('HomePages/TransferFunds')">Transfer Funds</a>
					  </li>
	<%--	 		  <li class="nav-item">
					    <a class="nav-link" href="#" onclick="loadSideBar('HomePages/Deposits')">Deposits</a>
					  </li>    --%>	
					  <li class="nav-item">
							<form action="logoutPage" method="post">
					            <input type="submit" value="Logout"/>
						  </form>
		  			  </li>
			  
			</ul>
        </nav>
    </header>
	
    <div class="container" style="margin-left: 0">
        <div class="sidebar" id="sideBar">
            
        </div>

        <div class="main-content" id="mainContent">
        </div>
    </div>

    <footer>
        <p>&copy; ASS Bank. Net Banking. All rights reserved.</p>
    </footer>

    <script>
        function loadPage(page) {
             fetch(page + '.jsp')
                 .then(response => response.text())
                 .then(html => document.getElementById('mainContent').innerHTML = html)
                 .catch(error => console.error('Error loading page:', error));
        }
        function loadSideBar(page) {
        	document.getElementById('mainContent').innerHTML = "";
            fetch(page + '.jsp')
                .then(response => response.text())
                .then(html => document.getElementById('sideBar').innerHTML = html)
                .catch(error => console.error('Error loading page:', error));
       }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    

</body>
</html>
