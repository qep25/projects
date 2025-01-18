/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bean.homeBean;
import dao.homeUserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
public class homeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet homeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet homeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        try (PrintWriter out = response.getWriter()) {
            String projectname = request.getParameter("projectname");
            String projectdescription = request.getParameter("projectdescription");
            String deadline = request.getParameter("deadline");
 
        homeBean data = new homeBean(projectname, projectdescription, deadline);
        homeUserDao hud = new homeUserDao();
        
        String homeDashboard = hud.homeUser(data);
        
        if (homeDashboard.equals("SUCCESS")) {
                // If authentication is successful, forward to the Home.jsp page
//                int userID = hud.getUserId();
                HttpSession session = request.getSession();
//                session.setAttribute("userID", userID);
                request.setAttribute("projectname", projectname);
                request.getRequestDispatcher("/homeUser.jsp").forward(request, response);
            } else {
                // If authentication fails, display an error message and forward to the Login.jsp page
                request.setAttribute("errMessage", homeDashboard);
                request.getRequestDispatcher("/loginUser.jsp").forward(request, response);
            }
        }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Dashboard";
    }// </editor-fold>

}
