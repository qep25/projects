<%-- Document : calculatorApp Created on : Jan 22, 2024, 12:12:50 AM Author :
hasif --%> <%@page import="java.util.ArrayList"%> <%@page
contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://rsms.me/inter/inter.css" />
    <title>Home</title>
  </head>
  <body align="center">
    <div>
      Calculator KSSM
      <form
        class="p-20"
        action="calculatorServlet"
        enctype="multipart/form-data"
        method="GET"
      >
        <div class="flex flex-col">
          <label for="studentYear">Select a year </label>
          <select name="studentYear">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select>
        </div>
        <input type="submit" value="Go" />
      </form>
      <%
          String errorMsg = (String)request.getAttribute("errorMsg");
          if (errorMsg != null) { %>
      <p><%= errorMsg %></p>
      <% } %>
    </div>
  </body>
</html>
