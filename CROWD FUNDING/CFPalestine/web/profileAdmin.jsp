<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : profileAdmin
    Created on : Jan 10, 2024, 3:45:48 PM
    Author     : Haikal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="bean.AdminBean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Profile</title>
        <link rel="stylesheet" href="css/styleFund.css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    </head>
    <body>
        <div class="container">
            <nav>
          <ul>
              <li>
                  <a href="HomeAdminServlet" class="logo">
                      <img src="images/logo.png" style="height: 40%;">
                      <span class="nav-item">Donators</span>
                  </a>
              </li>
              <li>
                  <a href="HomeAdminServlet">
                      <i class="fas fa-home"></i>
                      <span class="nav-item" >Home</span>
                  </a>
              </li>
                    <li>
                        <a href="DashboardAdminServlet">
                            <i class="fas fa-list"></i>
                            <span class="nav-item">Funder History</span>
                        </a>
                    </li>
              <li>
                  <a href="ListFundAdminServlet">
                      <i class="fas fa-database"></i>
                      <span class="nav-item">Edit Project</span>
                  </a>
              </li>
              <li>
                  <a href="AdminServlet">
                      <i class="fas fa-user"></i>
                      <span class="nav-item">Profile</span>
                  </a>
              </li>
              <li>
                  <a href="LogoutServlet" class="logout">
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
                                    <th><center>Name</center></th>
                                    <th><center>Founder ID</center></th>            
                                    <th><center>INCHARGE IN(PROJECT ID)</center></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
<!--                                    <td>Test Phone Number</td>-->
                                    <%
                                        AdminBean admin = (AdminBean) request.getAttribute("admin");
                                    %>
                                    <td class="col-2"><center><%= admin.getUsername() %></center></td>
                                    <td class="col-2"><center><%= admin.getId() %></center></td>
                                    <td class="col-2"><center><%= admin.getProjId() %></center></td>
                                    
                                    
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </section>

                <!-- Site footer -->
                <section class="footer">
                    <footer>
                        <p class="text-center">Copyright &copy; Crowd Funding</p>
                    </footer>
                </section>
            </section>
        </div>
    </body>
</html>
