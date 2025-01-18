<%-- 
    Document   : Register User
    Created on : Jan 11, 2024, 2:19:21 PM
    Author     : Smiling
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty requestScope.errorMsgs}">
    <div class="errorMessage">
        <ul>
            <c:forEach items="${requestScope.errorMsgs}" var="errorMsg">
                <li>${errorMsg}</li>
            </c:forEach>
        </ul>
    </div>
</c:if>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
        <link rel="stylesheet" href="css/register.css">
        <style>
        .errorMessage {
            color: red;
            text-align: center;
            font-size: 20px;
        }
        </style>
        
    </head>
    <body>
        <div class="form sign-in">
        <h1>User Registration</h1>
        <form action="RegisterServlet" method="POST">
        <table border="0" cellspacing="4" cellpadding="4">
            <tbody>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="fundername" value="" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="funderemail" value="" /></td>
                </tr>
                <tr>
                    <td>Phone</td>
                    <td><input type="text" name="funderphone" value="" /></td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="funderusername" value="" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="funderpass" value="" /></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td><input type="password" name="confirmpassword" value="" /></td>
                </tr>
                <tr>
                     <td><input type="submit" value="Sign In" class="submit"/></td>
                </tr>
            </tbody>
        </table>
        </form>
        </div>
    </body>
</html>
