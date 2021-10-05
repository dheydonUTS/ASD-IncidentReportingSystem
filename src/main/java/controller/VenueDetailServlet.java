/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Venue;
import model.dao.DBManager;

/**
 *
 * @author vince
 */
public class VenueDetailServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        int venueId = 0;
        Venue venue = null;
        // Safely retrieve venue id from button and GET request
        try{
            venueId = Integer.parseInt(request.getParameter("venueId"));
            System.out.println("Venue Id: "+venueId);
        }catch(Exception e){
            System.out.println("Invalid venueId!");
            Logger.getLogger(IncidentDetailServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        // Safely load venue object from database
        try{
            venue = manager.getVenue(venueId);
        }catch(Exception e){
            System.out.println("Venue retrival error!");
            Logger.getLogger(IncidentDetailServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        session.setAttribute("venue", venue); // Set incident bean into session
        request.getRequestDispatcher("VenueDetails.jsp").forward(request, response); // Dispatch request and response to webpage
    }
}
