/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
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
import model.Venue;
import model.dao.*;

/**
 *
 * @author adam
 */
public class updateUserServlet extends HttpServlet {
    
 private DBManager manager;
    private DBConnector Connector;
    
    @Override //Create and instance of DBConnector for the deployment session
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        try
//        {
//            Connector = new DBConnector();
//        }catch (ClassNotFoundException | SQLException ex){
//            java.util.logging.Logger.getLogger(updateUserServlet.class.getName()).log(Level.SEVERE,null,ex);
//        }
//        
//        try
//        {       
//            manager = new DBManager(Connector.connection());  
//        }catch (SQLException ex){
//            java.util.logging.Logger.getLogger(updateUserServlet.class.getName()).log(Level.SEVERE,null,ex);
//        }
//        
//        HttpSession session = request.getSession();
//        
//        int id = Integer.parseInt(request.getParameter("userID"));
//        String firstName = request.getParameter("userFirstName");
//        String lastName = request.getParameter("userLastName");
//        String email = request.getParameter("userEmail");
//        String password = request.getParameter("password");
//        System.out.println(request.getParameter("userIsStaff"));
//        //boolean admin = request.getParameter("password");
//
//        
//        try {
//                manager.setStatusIncident(id, status, priority, assID);
//                LinkedList<Incident> incidentList = null;
//                    try{
//                        incidentList = manager.getIncidentList(); // Loads the list of incidents
//                    }catch(SQLException e){
//                        Logger.getLogger(updateUserServlet.class.getName()).log(Level.SEVERE, null, e);
//                    }
//                session.setAttribute("incidents", incidentList); // Set list of incidents into session
//                request.getRequestDispatcher("ViewIncidentsAndTickets.jsp").forward(request, response); // Dispatch request and response to webpage
//            
//        } catch (SQLException ex) {
//         Logger.getLogger(updateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
//     } 
   }
    
}
