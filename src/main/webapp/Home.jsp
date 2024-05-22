
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
    if (session.getAttribute("loggedIn") == null) {
        response.sendRedirect("loginPage"); 
    }
%>

    <header>
        <nav>
            <ul>
                <li><a href="">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Contact</a></li>
				<form action="logoutPage" method="post">
            <input type="submit" value="Logout"/>
        </form>
            </ul>
        </nav>
    </header>

    <div class="container">
        <div class="sidebar">
            <ul>
                <li><a href="#" onclick="loadPage('AccountPages/BalanceEnquiry')">Balance Enquiry</a></li>
                <li><a href="#" onclick="loadPage('AccountPages/AccountStatement')">AccountStatement</a></li>
                <li><a href="#" onclick="loadPage('AccountPages/DownloadStatement')">Download Statement</a></li>
                <li><a href="#" onclick="loadPage('AccountPages/ChangePassword')">Change Password</a></li>
                <li><a href="#" onclick="loadPage('AccountPages/ChangeAtmPin')">Change ATM PIN</a></li>
                
            </ul>
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
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    

</body>
</html>
