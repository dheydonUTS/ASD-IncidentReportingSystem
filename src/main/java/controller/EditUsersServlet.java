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
import model.dao.DBConnector;
import model.dao.DBManager;

/**
 *
 * @author adam
 */
public class EditUsersServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  // Loads the list of incidents from the database
            throws ServletException, IOException {
        
//        HttpSession session;
//        session = request.getSession();
//        DBManager manager = (DBManager)session.getAttribute("manager");
//        
//        int editID =Integer.parseInt(request.getParameter("editID"));
//        System.out.println(request.getParameter("editID"));
//        User editUser = null;
//        
//        try{
//            editUser = manager.getUser(editID);
//            if (editUser!= null){
//                session.setAttribute("editUser", editUser);
//                System.out.println(editUser.getId());
//                request.getRequestDispatcher("editUser.jsp").forward(request, response); // Dispatch request and response to webpage
//            }
//        } catch(SQLException e){
//            Logger.getLogger(updateIncidentServlet.class.getName()).log(Level.SEVERE, null, e);
//        } 
        
    }
}

