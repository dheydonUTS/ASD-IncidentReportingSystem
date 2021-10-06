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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.dao.*;

/**
 *
 * @author christianlopez
 */
public class addVenueServlet {
    
    private DBManager manager;
    private DBConnector Connector;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
    
        //catch exceptions for the DBConnector
        try
        {
            Connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(addVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //catch exceptions for the DBManager
        try
        {       
            manager = new DBManager(Connector.connection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(addVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }

 

        //session
        HttpSession session = request.getSession();
        Validator validator = new Validator();    
        
        // Collect parameters from addVenue.jsp
        String venueName = request.getParameter("venueName");
        String venueAddress = request.getParameter("venueAddress");
        //double lat = Double.parseDouble(request.getParameter("venueLat"));
        //double lon = Double.parseDouble(request.getParameter("venueLon"));
        String latString = request.getParameter("venueLat");
        String lonString = request.getParameter("venueLon");

        
         if (!validator.validateLonLat(latString)) {                                      // Check Latitude
            session.setAttribute("latError", "Latitude invalid.");
            request.getRequestDispatcher("addVenue.jsp").include(request, response);
        } else if (!validator.validateLonLat(lonString)) {
            session.setAttribute("lonError", "Longitude invalid.");                         // Check Longitude
            request.getRequestDispatcher("addVenue.jsp").include(request, response);
        } else if (validator.validateLonLat(latString) && validator.validateLonLat(lonString))
        {
        try {
            if (venueName != null) {
                manager.addVenue(venueName, venueAddress, Double.valueOf(latString), Double.valueOf(lonString));
                session.setAttribute("added", "Venue has been added");
                
                request.getRequestDispatcher("addVenue.jsp").include(request, response);
                response.sendRedirect("addVenue.jsp");
            } else {
                session.setAttribute("added", "Item has not been added to inventory");
                request.getRequestDispatcher("addVenue.jsp").include(request, response);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(addVenueServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
}
