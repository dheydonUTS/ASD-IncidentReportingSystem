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
public class createVenueServlet extends HttpServlet {
    
     private DBManager manager;
    private DBConnector Connector;
    
    @Override //Create and instance of DBConnector for the deployment session
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        //catch exceptions for the DBConnector
        try
        {
            Connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(createVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //catch exceptions for the DBManager
        try
        {       
            manager = new DBManager(Connector.connection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(createVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }

 
        Venue venue = null;
        //session
        HttpSession session = request.getSession();
        
        String venueName = request.getParameter("venueName");
        String venueAddress = request.getParameter("venueAddress");
        Double venueLat = Double.parseDouble(request.getParameter("venueLat"));
        Double venueLon = Double.parseDouble(request.getParameter("venueLon"));
        
        try {
        if (venueName != null) {
            manager.addVenue(venueName, venueAddress, venueLat, venueLon); //call addNewItem and use the inputted values from admin user method in manager
            session.setAttribute("added", "Venue has been added"); //set the attribute as successful (no error message)

 

            request.getRequestDispatcher("addVenue.jsp").include(request, response); //request comes from the addNewItem.jsp
            response.sendRedirect("addVenue.jsp"); //the user is redirected back to this page with the success message
        } else {
            session.setAttribute("added", "Item has NOT been added to Inventory");//if form is completed incorrectly, display error message
            request.getRequestDispatcher("manageVenues.jsp").include(request, response); //the user is redirected back to this page to display error message
        }
    
    } catch (SQLException ex){
        Logger.getLogger(createVenueServlet.class.getName()).log(Level.SEVERE, null, ex); //if there is an SQL error, it is logged under this Servlet
    }
        
    }             
}
