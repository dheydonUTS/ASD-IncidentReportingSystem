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
import model.Incident;
import model.dao.DBManager;

/**
 *
 * @author vince
 */
public class IncidentDetailServlet extends HttpServlet {

    @Override    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) // Load corresponding incident from incident list page and load the incident details
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        int incidentId = 0;
        Incident incident = null;
        // Safely retrieve incident id from button and GET request
        try{
            incidentId = Integer.parseInt(request.getParameter("incidentId"));
            System.out.println(incidentId);
        }catch(Exception e){
            System.out.println("Invalid incidentId!");
            Logger.getLogger(IncidentDetailServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        // Safely load Incident object from database
        try{
            incident = manager.getIncident(incidentId);
        }catch(Exception e){
            System.out.println("Incident retrival error!");
            Logger.getLogger(IncidentDetailServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        session.setAttribute("incident", incident); // Set incident bean into session
        request.getRequestDispatcher("IncidentDetails.jsp").forward(request, response); // Dispatch request and response to webpage
    }
}