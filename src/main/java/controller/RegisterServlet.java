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
        validator validator = new validator();
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            // Obtain entered user details
            String email = request.getParameter("email");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");
            String repassword = request.getParameter("repassword");
            DBManager manager = (DBManager) session.getAttribute("manager");
            /*if (!validator.validateEmail(email)) {
                session.setAttribute("emailError", "The Email entered is not valid");
                request.getRequestDispatcher("Register.jsp").include(request, response);
            } else if (!validator.validatePassword(password) || !validator.validatePassword(repassword)) {
                session.setAttribute("passwordError", "The Password entered is not valid");
                request.getRequestDispatcher("Register.jsp").include(request, response);
            } else if (!validator.validateName(fname) || (!validator.validateName(lname))) {
                session.setAttribute("nameError", "The Name entered is not valid");
                request.getRequestDispatcher("Register.jsp").include(request, response);
            } else if (password.equals(repassword)) {
                manager.createUser(email, password, fname, lname);
                response.sendRedirect("Login.jsp");
            } else {
                session.setAttribute("passwordMatchError", "Passwords did not Match");
                response.sendRedirect("Register.jsp");
            }
            
            }      catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
       }*/
            Boolean errorFound = false;
            if (!validator.validateEmail(email)) {
                session.setAttribute("emailError", "The Email entered is not valid");
                errorFound = true;
            } if (!validator.validatePassword(password) || !validator.validatePassword(repassword)) {
                session.setAttribute("passwordError", "The Password entered is not valid");
                errorFound = true;
            } if (!validator.validateName(fname) || (!validator.validateName(lname))) {
                session.setAttribute("nameError", "The Name entered is not valid");
                errorFound = true;
            } if (!password.equals(repassword)) {
                session.setAttribute("passwordMatchError", "Passwords did not Match");
                errorFound = true;
            } if (password.equals(repassword) && errorFound == false) {
                manager.createUser(email, password, fname, lname);
                response.sendRedirect("Login.jsp");
            } else if (errorFound == true) {
                request.getRequestDispatcher("Register.jsp").include(request, response);
            }
            
            }      catch (SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
