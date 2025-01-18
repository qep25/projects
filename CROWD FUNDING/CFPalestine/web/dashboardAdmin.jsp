<%-- 
    Document   : dashboardAdmin
    Created on : Jan 17, 2024, 6:37:52 PM
    Author     : Lenovo
--%>

<%@page import="bean.DashboardUserBean"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
      <title>History</title>
      <link rel="stylesheet" href="css/home.css" />
      <link rel="stylesheet" href="css/styleFund.css" />
      <!-- Font Awesome Cdn Link -->
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
            <section class="main">
        
            <section class="attendance">
              <div class="attendance-list">
                  <h1><center>HISTORY</center></h1>
                <table class="table">
                  <thead>
                    <tr>
                        <th><center>PROJECT ID</center></th>
                        <th><center>FUNDER ID</center></th>
                        <th><center>FUNDER NAME</center></th>
                        <th><center>DATE</center></th>              
                        <th><center>AMOUNT(RM)</center></th>
                    </tr>
                  </thead>
                  <%
                            List categoryList = (List) request.getAttribute("projectList");
                            if (categoryList != null) {
                                Iterator categorys = categoryList.iterator();
                                while (categorys.hasNext()) {
                                    DashboardUserBean category = (DashboardUserBean) categorys.next();       
                        %>   
                            <tbody>
                                <tr>
                                    <td><center><%=category.getProjectid()%></center></td>
                                    <td><center><%=category.getFunderid()%></center></td>
                                    <td><center><%=category.getFunderName()%></center></td>
                                    <td><center><%=category.getFundingdate()%></center></td>
                                    <td><center><%=category.getFundingamount()%></center></td>
                                </tr>
                            </tbody>
                        <%
                    }
                }
            %>
                </table>
              </div>
            </section>
            </section>
                          <footer>
              <p class="text-center">Copyright &copy; FundingHelp.com</p>
          </footer>
            </section>


    </div>
    </body>
</html>
