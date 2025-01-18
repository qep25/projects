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
<span style="font-family: verdana, geneva, sans-serif;"><!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <title>EDIT PROJECT</title>
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
                <section class="fundL">
                    <div class="fund-list">
                        <center><h1>PROJECT</h1></center>
                       
                        <table class="table">
                            <thead>
                                <tr>
                                    <th><center>PROJECT ID</center></th>
                                    <th><center>PROJECT NAME</center></th>
                                    <th><center>PROJECT DESC</center></th>
                                    <th><center>DATELINE</center></th>
                                    <th><center>CUSTOMIZE</center></th>
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
                                <form action="EditProjectServlet" method="POST">
                                <tr>

                                    <td class="col-2"><center><input type="hidden" name="projId" value="<%= category.getProjId() %>"><%= category.getProjId() %></center></td>
                                    <td class="col-2"><center><input type="text" name="projName" value="<%=category.getProjName()%>"/></center></td>
                                    <td class="col-2"><center><input type="text" name="projDesc" value="<%=category.getProjDesc()%>"/></center></td>
                                    <td class="col-2"><center><input type="text" name="dateline" value="<%=category.getDateline()%>"/></center></td>
                                    <td class="col-2"><center><input type="submit" value="Edit Project" /></form>
                                                <form action="DeleteProjectServlet" method="post">
                                            <input type="hidden" name="projId" value="<%= category.getProjId() %>">
                                            <input type="submit" value="Delete Project"><br><br>
                                        </form>
                                    </center></td>
                                </tr>
                            </tbody>
                        <%
                                }
                            }
                        %>
                        </table>
                        <center><form action="addProject.jsp" method="POST">
                        <input type="submit" value="ADD PROJECT" />
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
