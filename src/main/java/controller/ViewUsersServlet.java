/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Incident;
import model.User;
import model.dao.DBManager;

/**
 *
 * @author vince
 */
public class ViewUsersServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  // Loads the list of incidents from the database
            throws ServletException, IOException {
        HttpSession session;
        session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        
        LinkedList<User> users = null;
        try{
            users = manager.getAllStaff();
        }catch(SQLException e){
            
        }
        session.setAttribute("users", users);
        request.getRequestDispatcher("viewUsers.jsp").forward(request, response); // Dispatch request and response to webpage
    }
}

