<%-- 
    Document   : listFundAdmin
    Created on : Jan 13, 2024, 1:52:26 AM
    Author     : Haikal
--%>

<%@page import="bean.AdminBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="bean.ListFundAdmin"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<span style="font-family: verdana, geneva, sans-serif;">
    <!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <title>HOME</title>
      <link rel="stylesheet" href="css/home.css" />
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
            <div class="home">
              <section class="parallax-section1" style="background-position: 50% 120px;">
                <div class="projects-img">
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
                        <center><h1>PROJECT LIST</h1></center>
                       
                        
                        <table class="table">
                            <thead>
                                <tr>
                                    <th><center>PROJECT ID</center></th>
                                    <th><center>PROJECT NAME</center></th>
                                    <th><center>PROJECT DESC</center></th>
                                    <th><center>DATELINE</center></th>
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

                                    <td class="col-2"><center><%= category.getProjId() %></center></td>
                                    <td class="col-2"><center><%=category.getProjName()%></center></td>
                                    <td class="col-2"><center><%=category.getProjDesc()%></center></td>
                                    <td class="col-2"><center><%=category.getDateline()%></center></td>
                                </tr>
                            </tbody>
                            <%
                                }
                            }
                        %>
                        </table>
                        <center><form action="ListFundAdminServlet" method="POST">
                        <input type="submit" value="EDIT PROJECT" />
                        </form>
                    </center>  
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
