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
            <form action="LoginFunderServlet" method="POST">
            <label>
                <span>Username</span>
                <input type="text" name="funderusername" value="">
            </label>
            <label>
                <span>Password</span>
                <input type="password" name="funderpass" value="">
            </label>
<!--            <p class="forgot-pass">Forgot password?</p>-->
                <input type="submit" value="Sign In" class="submit"/>
                <br>
                <button class="create-fund">
                    <a href="loginAdmin.jsp">Admin Sign In</a>
                </button>
                


            </form>
        </div>
        <div class="sub-cont">
            <div class="img">
                <div class="img__text m--up">
                    <h3>Don't have an account? Please Sign up!<h3>
                </div>
                <div class="img__text m--in">
                    <h3>If you already has an account, just sign in.<h3>
                </div>
                <div class="img__btn">
                    <span class="m--up">Sign Up</span>
                    <span class="m--in">Sign In</span>
                </div>
            </div>
            <div class="form sign-up">
                <h2 align="center">Create your Account</h2>
                <form action="RegisterServlet" method="POST">
                <label>
                    <span>Name</span>
                    <input type="text" name="fundername" value="" />
                </label>
                <label>
                    <span>Email</span>
                    <input type="text" name="funderemail" value="" />
                </label>
                <label>
                    <span>Phone</span>
                    <input type="text" name="funderphone" value="" />
                </label>
                <label>
                    <span>Username</span>
                    <input type="text" name="funderusername" value="" />
                </label>
                <label>
                    <span>Password</span>
                    <input type="password" name="funderpass" value="" />
                </label>
                <input type="submit" value="Sign Up" class="submit"/>
                
                </form>
            </div>
        </div>
      </div>   
    <script>
        document.querySelector('.img__btn').addEventListener('click', function() {
            document.querySelector('.cont').classList.toggle('s--signup');
        });
    </script>
    
    <script type="text/javascript">
    document.getElementById("adminLogin").onclick = function () {
        location.href = "loginAdmin.jsp";
    };
    </script>
        
    </body>
</html>
