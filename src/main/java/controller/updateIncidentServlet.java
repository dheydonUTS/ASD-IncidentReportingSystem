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
import model.Venue;
import model.dao.*;

/**
 *
 * @author adam
 */
public class updateIncidentServlet extends HttpServlet {
    
 private DBManager manager;
    private DBConnector Connector;
    
    @Override //Create and instance of DBConnector for the deployment session
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {
            Connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(updateIncidentServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try
        {       
            manager = new DBManager(Connector.connection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(updateIncidentServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        HttpSession session = request.getSession();
        
        String status = request.getParameter("IncidentStatus");
        int id = Integer.parseInt(request.getParameter("incidentID"));
        Incident incident = new Incident(id, status);
        //Venue venue = new Venue(venueID, venueName, venueAddress, venueLat, venueLon); // new instance of venue
        
        try {
            if (incident != null) {
                //if (manager.checkVenue(venueID)) {           // check venue exists
                //session.setAttribute("venue", venue);
                //manager.updateVenue(venueID, venueName, venueAddress, venueLat, venueLon);      //update the venue
                //session.setAttribute("updated", "Update was successful");
                //request.getRequestDispatcher("editVenue.jsp").include(request, response);
                manager.setStatusIncident(id, status);
                LinkedList<Incident> incidentList = null;
                    try{
                        incidentList = manager.getIncidentList(); // Loads the list of incidents
                    }catch(SQLException e){
                        //    Logger.getLogger(MyIncidentsServlet.class.getName()).log(Level.SEVERE, null, e);
                    }
                session.setAttribute("incidents", incidentList); // Set list of incidents into session
                request.getRequestDispatcher("ViewIncidentsAndTickets.jsp").forward(request, response); // Dispatch request and response to webpage
            //} else {
                //session.setAttribute("updated", "Update was not successful");
                //request.getRequestDispatcher("editVenue.jsp").include(request, response);
            //}
            } else
            {
                session.setAttribute("updated", "Update was not successful");
            }
        } catch (SQLException ex) {
         Logger.getLogger(updateIncidentServlet.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
}
