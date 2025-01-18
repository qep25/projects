<%-- 
    Document   : listFundAdmin
    Created on : Jan 13, 2024, 1:52:26 AM
    Author     : Haikal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<span style="font-family: verdana, geneva, sans-serif;"><!DOCTYPE html>
    <html lang="en">
    <head>
      <meta charset="UTF-8" />
      <title>PROJECT</title>
      <link rel="stylesheet" href="css/styleFund.css" />
      <!-- Font Awesome Cdn Link -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    </head>
    <body>
      <div class="container">
             <section class="main">
                <section class="fundL">
                    <div class="fund-list">
                        <center><h1>ADD PROJECT</h1></center>
                        
                        <table class="table">
                            <thead>
                                <tr>
                                    <th><center>PROJECT NAME</center></th>
                                    <th><center>PROJECT DESC</center></th>
                                    <th><center>DATELINE</center></th>
                                    <th><center>CUSTOMIZE</center></th>
                                </tr>
                            </thead>
                            <tbody>
                                <form action="AddProjectServlet" method="POST">
                                <tr>
                                    <td class="col-2"><center><input type="text" name="projName" value=""/></center></td>
                                    <td class="col-2"><center><input type="text" name="projDesc" value=""/></center></td>
                                    <td class="col-2"><center><input type="text" name="dateline" value=""/></center></td>
                                    <td class="col-2"><center><input type="submit" value="Add Project" /></form></center></td>
                                </tr>
                            </tbody>
                        </table>
                        <center><form action="ListFundAdminServlet" method="POST">
                        <input type="submit" value="BACK" />
                        </form>
                    </div>
                </section>
                    
                    </center>                 

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
