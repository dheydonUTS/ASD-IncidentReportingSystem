/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.DBConnector;
import model.dao.DBManager;

/**
 *
 * @author User
 */
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Validator validator = new Validator();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            // Obtain entered user details
            String email = request.getParameter("email");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            DBManager manager = (DBManager) session.getAttribute("manager");
            Boolean errorFound = false;
            if (!validator.validateEmail(email)) { // Validate Email
                session.setAttribute("emailError", "The Email entered is not valid");
                errorFound = true;
            }
            if (!validator.validatePassword(password)) { // Validate Password
                session.setAttribute("passwordError", "The Password entered is not valid");
                errorFound = true;
            }
            if (!validator.validateName(fname)) { // Validate First Name
                session.setAttribute("fnameError", "The Name entered is not valid");
                errorFound = true;
            }
            if (!validator.validateName(lname)) { // Validate Last Name
                session.setAttribute("lnameError", "The Name entered is not valid");
                errorFound = true;
            }
            if (!passwordMatch(password, repassword)) { // Check passwords match
                session.setAttribute("passwordMatchError", "Passwords did not Match");
                errorFound = true;
            }
            if (password.equals(repassword) && errorFound == false) { // Create user if no errors found
                manager.createUser(email, password, fname, lname);
                response.sendRedirect("Login.jsp");
                session.removeAttribute("fnameError");
                session.removeAttribute("lnameError");
                session.removeAttribute("passwordError");
                session.removeAttribute("passwordMatchError");
                session.removeAttribute("emailError");
            } else if (errorFound == true) { // Return to page if error(s) found
                request.getRequestDispatcher("Register.jsp").include(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Boolean passwordMatch(String p1, String p2) {
        if (p1.equals(p2)) {
            return true;
        } else {return false;}
    }
}
