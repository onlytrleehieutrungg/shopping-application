/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trungtran.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import trungtran.registration.RegistrationDAO;
import trungtran.registration.RegistrationDTO;
import trungtran.registration.RegistrationInsertError;

/**
 *
 * @author trung
 */
@WebServlet(name = "CreateNewAccountServlet", urlPatterns = {"/CreateNewAccountServlet"})
public class CreateNewAccountServlet extends HttpServlet {
    private final String LOGIN_PAGE = "login.html";
    private final String ERROR_PAGE = "createNewAccount.jsp";

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
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm =  request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        RegistrationInsertError errors = new RegistrationInsertError();
        boolean foundErr = false;
        String url = ERROR_PAGE;
        try{
            //1. check all user error
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                 foundErr = true;
                 errors.setUsernameLengthErr("Username is required 6 to 20 chars");           
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                 foundErr = true;
                 errors.setPasswordLenthErr("Password is required 6 to 30 chars");           
            }else if (!confirm.trim().equals(password.trim())) {
                 foundErr = true;
                 errors.setConfirmNotMatch("Confirm must match password"); 
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                 foundErr = true;
                 errors.setFullNameLengthErr("Full name is required 2 to 50 chars");           
            }
            if (foundErr) {
                request.setAttribute("INSERT_ERRORS", errors);
            }else{
                // insert to DB
                RegistrationDTO dto = 
                        new RegistrationDTO(username, password, fullname, false);
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.createNewAccount(dto);
                if (result) {
                // transfer to login page
                    url = LOGIN_PAGE;
                // end account is created
                }
            }
        }catch(SQLException ex){
            String msg = ex.getMessage();              
            log("CreateNewAccountServlet _ SQL " + msg);
            if (msg.contains("duplicate")) {
                errors.setUsernameIsExisted(username + " existed!!!!");
                request.setAttribute("INSERT_ERRORS", errors);
            }
        }catch(NamingException ex){
            log("CreateNewAccountServlet _ Naming " + ex.getMessage());
        }
        finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
        processRequest(request, response);
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
