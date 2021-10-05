/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

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
 * @author dheydon
 */

public class LoginServlet extends HttpServlet {
    
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();  
    Validator validator = new Validator();     
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    DBManager manager = (DBManager)session.getAttribute("manager");
    User user = null;
    if (!validator.validateEmail(email)) {                                      //Check email
        session.setAttribute("emailError","email invalid.");
        request.getRequestDispatcher("Login.jsp").include(request,response); 
    } 
    else if (!validator.validatePassword(password)) {                           // Check PW
        session.setAttribute("passwordError","The pasword entered is invalid.");
        request.getRequestDispatcher("Login.jsp").include(request,response);
    } 
    else if (validator.validateEmail(email) && validator.validatePassword(password)) {
         try {                                                                  // Try login user
             user = manager.findUser(email,password);                           // If the use does not exist NPE is thrown
                session.setAttribute("user", user);
                session.removeAttribute("noSuchUserError");
                session.removeAttribute("passwordError");
                session.removeAttribute("emailError");
                request.getRequestDispatcher("index.jsp").include(request,response);
            }
         catch (Exception ex ){                                                 // No such user case            
             session.setAttribute("noSuchUserError",                            // NPE thrown if account doesn't exist this catches.
                        "No such user exists for the details you have entered. Please try again"); 
            request.getRequestDispatcher("Login.jsp").include(request,response);
             }
         }
    }  
}
