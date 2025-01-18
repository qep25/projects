<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Iterator"%>
<%@page import="bean.ListFundAdmin"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="bean.UserBean"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Crowd Funding Dashboard</title>
    <link rel="stylesheet" href="css/payment.css" />
    <!--<link rel="stylesheet" href="css/styleFund.css" />-->
    <!-- Font Awesome Cdn Link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<body>
    <div class="container">
   <nav>
          <ul>
              <li>
                  <a class="logo">
                      <img src="images/logo.png">
                      <span class="nav-item">CF</span>
                  </a>
              </li>
              <li>
                  <a href="ListFundServlet">
                      <i class="fas fa-home"></i>
                      <span class="nav-item">Home</span>
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
        <section class="main-top">
            <div class="home">
                <div style="width: 1500px; border: 5px solid #000; padding: 64px; margin-top: 100px; margin-left: 100px; background: #a2b1a2">
                    <h3>Payment Confirmation</h3>
                    <section class="main">
                        <form action="CreateFundServlet" method="POST">
                            <%
                                        UserBean user = (UserBean) request.getAttribute("user");
                                        
                               %>
                            <label>
                                
                                <span>Your Name :</span>
                                <input type="hidden" name="funderid" value="<%= user.getId()%>"><br>
                                <input type="text" class="input" name="fundername" value="<%= user.getName() %>"><br>
                            </label>
                            <label>
                                <span>Email Address :</span>
                                <input type="text" class="input" name="funderemail" value="<%= user.getEmail() %>"><br>
                            </label>
                            <label>
                                <span>Enter Amount (RM):</span>
                                <input type="text" name="amount" value=""  class=" input" required><br>
                            </label>
                            <label>
                                <span>Date :</span>
                                <input type="text" name="date" value="" class=" input" required><br>
                            </label>
                            <label for="payment_method">
                                 <span>Project Name :</span>
                                 <select name="projid" class="input" >
                                     
                                    <%
                List categoryList = (List) request.getAttribute("projectList");
                if (categoryList != null) {
                    Iterator categorys = categoryList.iterator();
                    while (categorys.hasNext()) {
                        ListFundAdmin category = (ListFundAdmin) categorys.next();       
            %> 
            
            <option value="<%=category.getProjId()%>"><%=category.getProjName()%></option>
                                    <%
                                }
                            }
                        %>
                                </select>
                                 </label><br>
                            <input type="submit" value="Pay" class="submit">
                        </form>
                    </section>
                </div>
            </div>
                <footer style="padding-top: 27%">
                    <p class="text-center">Copyright &copy; FundingHelp.com</p>
                </footer>
        </section>
                                
    </div>
</body>
</html>


