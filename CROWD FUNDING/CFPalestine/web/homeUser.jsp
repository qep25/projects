<%--  
    Document   : Home 
    Created on : Jan 4, 2024, 2:42:18 PM 
    Author     : Smiling 
--%> 
 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Iterator"%>
<%@page import="bean.ListFundAdmin"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<!DOCTYPE html> 
    <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <title>User - Home</title>
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
                        <a class="logo">
                          <img src="images/logo.png" style="height: 40%;">
                          <span class="nav-item">CF</span>
                        </a>
                    </li>
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
<!--          <div class="main-top">
            <i class="fas fa-user-cog"></i>
          </div>-->
            <div class="home">
                <%-- 
//                    String funderusername = request.getParameter("funderusername");
                    out.println("<h1 align=center>"+"WELCOME TO CROWD FUNDING"+ "</h1>");
                --%>
        
              <!--<h1 class="box_verticalPaddedHalf">WELCOME TO CROWDFUNDER</h1>-->
              
              <section class="parallax-section1" style="background-position: 50% 120px;">
                <div class="projects-img">
                    <% 
//                    String funderusername = request.getParameter("funderusername");
                    out.println("<h1 align=center>"+"WELCOME TO CROWD FUNDING"+ "</h1>");
                    %>
                  <!-- <div class="card">
                    <img src="images/1.png">
                  </div> -->
                  <div class="row">
                    <div class="column">
                      <img src="images/1.png" style="width:100%">
                    </div>
                    <div class="column">
                      <img src="images/4.jpg" style="width:100%">
                    </div>
                    <div class="column">
                      <img src="images/3.jpg" style="width:100%">
                    </div>
                  </div>
                </div>
              </section>
              
            </div>

                <section class="main">
                <section class="fundL">
                    <div class="fund-list">
                        <center><h1>LIST FUND</h1></center>
                        <table border="1" class="table">
                            <thead>
                                <tr>
                                    <th>PROJECT ID</th>
                                    <th>DATELINE</th>
                                    <th>PROJECT NAME AND DESCRIPTION</th>
                                </tr>
                            </thead>
                        <%
                            List categoryList = (List) request.getAttribute("projectList");
                            if (categoryList != null) {
                                Iterator categorys = categoryList.iterator();
                                while (categorys.hasNext()) {
                                    ListFundAdmin category = (ListFundAdmin) categorys.next();       
                        %>   
                            <tbody>
                                <tr>
                                    <td><%=category.getProjId()%></td>
                                    <td><%=category.getDateline()%></td>
                                    <td><%=category.getProjName()%> - <%=category.getProjDesc()%></td>
                                </tr>
                            </tbody>
                        <%
                    }
                }
            %>
                        </table>
                        <center><button class="create-fund">
                            <h1><a href="paymentServlet">DONATE NOW !!!</a></h1>
                            </button></center>
                    </div>
                </section>
                        
      <!-- Site footer -->
      <section class="footer">
        <footer>
          <p class="text-center">Copyright &copy; FundingHelp.com</p>
        </footer>
    </section>

      </div>
    </body>
    </html>
    </span>
