/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.dao.DBManager;

/**
 *
 * @author User
 */
public class editAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        validator validator = new validator();
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = (User) session.getAttribute("user");
        DBManager manager = (DBManager) session.getAttribute("manager");
        // If matching user is found then update the user details in the database
        try {
            if (!validator.validateEmail(email)) {
                session.setAttribute("emailError", "New Email is Invalid");
            }
            if (!validator.validatePassword(password)) {
               session.setAttribute("passwordError", "New Password is Invalid");
            }
            manager.updateUser(email, password, user.getEmail());
            user.setEmail(email);
            user.setPassword(password);
        } catch (SQLException ex) {
            Logger.getLogger(editAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("userChanged", "Details have been Successfully Changed");
        request.getRequestDispatcher("Account.jsp").include(request, response);
    }
}
