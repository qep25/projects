<%-- 
    Document   : Login
    Created on : Jan 4, 2024, 2:31:23 PM
    Author     : Smiling
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${not empty requestScope.errMessage}">
    <div class="errorMessage">${requestScope.errMessage}</div>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link href="css/register.css" rel="stylesheet" type="text/css"/>
        <style>
        .errorMessage {
            color: red;
            text-align: center;
            font-size: 20px;
        }
        </style>
    </head>
    <body>
        <div class="cont">
        <div class="form sign-in">
            <h2>Welcome</h2>
            <form action="LoginServlet" method="POST">
            <label>
                <span>Username</span>
                <input type="text" name="username" value="">
            </label>
            <label>
                <span>Password</span>
                <input type="password" name="password" value="">
            </label>
                <input type="submit" value="Sign In" class="submit"/>
            </form>
            <button class="create-fund">
                    <a href="loginUser.jsp">User Sign In</a>
                </button>
        </div>
            <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                    <h3>WELCOME ADMIN!!!!<h3>
                </div>
            </div>        
      </div>
    </body>
</html>
