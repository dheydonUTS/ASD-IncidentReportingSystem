/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Incident;
import model.Venue;

/**
 *
 * @author dom_h
 */
public class IncidentServlet extends HttpServlet {
@Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {       
       HttpSession session = request.getSession();  
       Venue currentVenue = new Venue(1,"Rhodes",12,12); // Fix to add current venue (get from session)
       String type = request.getParameter("type");
       LocalDate date = LocalDate.parse(request.getParameter("date"));
       LocalTime time = LocalTime.parse(request.getParameter("time"));
       String desc = request.getParameter("desc");
       String reporter = request.getParameter("reporter");
       String offender = request.getParameter("offender");
       Venue venue = currentVenue;
       // Add some validation
       
       Incident incident = new Incident(venue,type,date,time,desc,reporter,offender);
       session.setAttribute("incident", incident);
       session.setAttribute("venue", venue);
       request.getRequestDispatcher("ViewIncident.jsp").include(request,response);
   }

}
