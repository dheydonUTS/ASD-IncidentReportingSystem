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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("Servlet Reached");
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;
        try {
            user = manager.findUser(email, password);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (user != null) {
            session.setAttribute("user", user);
            request.getRequestDispatcher("index.jsp").include(request, response);
        } else {
            session.getAttribute("existErr");
            request.getRequestDispatcher("Login.jsp").include(request, response);
        }

    }
}
