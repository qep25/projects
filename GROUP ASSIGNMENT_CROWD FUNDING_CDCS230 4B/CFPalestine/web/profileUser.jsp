<%-- 
    Document   : profileUser
    Created on : Jan 8, 2024, 4:27:00 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.UserBean"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User - Profile</title>
        <link rel="stylesheet" href="css/styleFund.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    </head>
    <body>
        <div class="container">
            <nav>
                <ul>
                    <a href="ListFundServlet" class="logo">
                      <img src="images/logo.png" style="height: 40%;">
                      <span class="nav-item">CF</span>
                  </a>
                    <li>
                        <a href="ListFundServlet">
                            <i class="fas fa-home"></i>
                            <span class="nav-item" >Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="DashboardUserServlet">
                            <i class="fas fa-database"></i>
                            <span class="nav-item">Dashboard</span>
                        </a>
                    </li>
                    <li>
                        <a href="UserServlet">
                            <i class="fas fa-user"></i>
                            <span class="nav-item">Profile</span>
                        </a>
                    </li>
                    <li>
                        <a href="loginUser.jsp" class="logout">
                            <i class="fas fa-sign-out-alt"></i>
                            <span class="nav-item">Log out</span>
                        </a>
                    </li>
                </ul>
            </nav>

            <section class="main">
                <section class="fundL">
                    <div class="fund-list">
                        <center><h1>USER PROFILE</h1></center>
                        
                        <table class="table">
                            <thead>
                                <tr>
                                    <th><center>Username</center></th>
                                    <th><center>User ID</center></th>            
                                    <th><center>Email Address</center></th>
                                    <th><center>Phone Number</center></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
<!--                                    <td>Test Phone Number</td>-->
                                    <%
                                        UserBean user = (UserBean) request.getAttribute("user");
                                    %>
                                    <td class="col-2"><center><%= user.getName() %></center></td>
                                    <td class="col-2"><center><%= user.getId() %></center></td>
                                    <td class="col-2"><center><%= user.getEmail() %></center></td>
                                    <td class="col-2"><center><%= user.getNumPhone()%></center></td>
                                    
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </section>

                <!-- Site footer -->
                <section class="footer">
                    <footer>
                        <p class="text-center">Copyright &copy; FundingHelp.com</p>
                    </footer>
                </section>
            </section>
        </div>
    </body>
</html>
