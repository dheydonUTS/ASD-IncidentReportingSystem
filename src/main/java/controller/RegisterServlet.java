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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DBConnector;
import model.dao.DBManager;


/**
 *
 * @author User
 */
public class RegisterServlet extends HttpServlet {
    private DBConnector connector;
    private Connection conn;
    private DBManager manager;
    
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String email = request.getParameter("emailForm");
            String password = request.getParameter("passForm");
            connector = new DBConnector();
            conn = connector.connection();
            manager = new DBManager(conn);
            response.sendRedirect("Login.jsp");
            manager.createUser(email, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
