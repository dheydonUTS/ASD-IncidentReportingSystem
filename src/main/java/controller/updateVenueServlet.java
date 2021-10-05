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
import model.Venue;
import model.dao.*;

/**
 *
 * @author christianlopez
 */
public class updateVenueServlet extends HttpServlet {
    
 private DBManager manager;
    private DBConnector Connector;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {
            Connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(updateVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try
        {       
            manager = new DBManager(Connector.connection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(updateVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        HttpSession session = request.getSession();
        
        int venueID = Integer.parseInt(request.getParameter("venueID"));
        String venueName = request.getParameter("venueName");
        String venueAddress = request.getParameter("venueAddress");
        double venueLat = Double.parseDouble(request.getParameter("venueLat"));
        double venueLon = Double.parseDouble(request.getParameter("venueLon"));
        
        Venue venue = new Venue(venueID, venueName, venueAddress, venueLat, venueLon);
        
        try {
            if (venue != null) {
                if (manager.checkVenue(venueID)) {
                session.setAttribute("venue", venue);
                manager.updateVenue(venueID, venueName, venueAddress, venueLat, venueLon);
                session.setAttribute("updated", "Update was successful");
                request.getRequestDispatcher("editVenue.jsp").include(request, response);
            } else {
                session.setAttribute("updated", "Update was not successful");
                request.getRequestDispatcher("editVenue.jsp").include(request, response);
            }
            } else
            {
                session.setAttribute("updated", "Update was not successful");
            }
        } catch (SQLException ex) {
         Logger.getLogger(updateVenueServlet.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
}
