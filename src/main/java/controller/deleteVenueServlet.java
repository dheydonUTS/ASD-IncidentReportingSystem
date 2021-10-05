/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Venue;
import model.dao.*;

/**
 *
 * @author christianlopez
 */
public class deleteVenueServlet extends HttpServlet {
    
      private DBManager manager;
    private DBConnector Connector;
    
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {
            Connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(deleteVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try
        {       
            manager = new DBManager(Connector.connection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(deleteVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        // Session 
        HttpSession session = request.getSession();
            int venueID = Integer.parseInt(request.getParameter("venueID"));
        
        
        Venue venue = null;
        
        try {
            venue = manager.findVenue(venueID);
            
            if (venue != null) {
                manager.deleteVenue(venueID);
                session.setAttribute("deleteMessage", "Venue is deleted successfully");
            } else {
                session.setAttribute("existErr", "Venue does not exist in the Database!");
                request.getRequestDispatcher("editVenue.jsp").include(request, response);
            }
        } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(editVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
             request.getRequestDispatcher("manageVenue.jsp").include(request, response);
        }
}
}