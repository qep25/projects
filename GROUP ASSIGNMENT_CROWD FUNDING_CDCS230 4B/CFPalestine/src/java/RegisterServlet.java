import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.RegisterBean;
import dao.RegisterDao;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Haikal
 */
public class RegisterServlet extends HttpServlet {

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
        List errorMsgs = new LinkedList();
        
        String fundername = request.getParameter("fundername");
        String funderemail = request.getParameter("funderemail");
        String funderphone = request.getParameter("funderphone");
        String funderusername = request.getParameter("funderusername");
        String funderpass = request.getParameter("funderpass");
        
        
        RegisterBean rb = new RegisterBean();
        rb.setFundername(fundername);
        rb.setFunderemail(funderemail);
        rb.setFunderphone(funderphone);
        rb.setFunderusername(funderusername);
        rb.setFunderpass(funderpass);


        if ((fundername == null) || fundername.length() == 0) {
            errorMsgs.add("Please enter your name");
        }
        if ((funderemail == null) || funderemail.length() == 0) {
            errorMsgs.add("Please enter your email");
        }
        if ((funderphone == null) || funderphone.length() == 0) {
            errorMsgs.add("Please enter your phone");
        }
        if ((funderusername == null) || funderusername.length() == 0) {
            errorMsgs.add("Please enter your username");
        }
        if ((funderpass == null) || funderpass.length() == 0) {
            errorMsgs.add("Please enter your password");
        }

        if (errorMsgs.isEmpty()) {
            RegisterDao rd = new RegisterDao();
            String statusRegister = rd.registerUser(rb);

            if (statusRegister.equals("SUCCESS")) {
                request.setAttribute("funderusername", funderusername);
                request.setAttribute("errMessage", "You have sign up successfully.");
                request.getRequestDispatcher("/loginUser.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMsgs", statusRegister);
                request.getRequestDispatcher("/loginUser.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMsgs", errorMsgs);
            request.getRequestDispatcher("/loginUser.jsp").forward(request, response);
        }
   }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
