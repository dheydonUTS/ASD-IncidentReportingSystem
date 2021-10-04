/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;


import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Incident;
import model.*;
import model.dao.DBManager;
/**
 *
 * @author dom_h
 */
public class IncidentServlet extends HttpServlet {
@Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
            throws ServletException, IOException {       
       HttpSession session = request.getSession();
       DBManager manager = (DBManager)session.getAttribute("manager");
       Venue currentVenue = new Venue(1,request.getParameter("venueName"),12,12); // Fix to add current venue (get from session)
       String type = request.getParameter("type");
       LocalDate date = LocalDate.parse(request.getParameter("date"));
       LocalTime time = LocalTime.parse(request.getParameter("time"));
       String desc = request.getParameter("desc");
       User reporter = (User)session.getAttribute("user");
       
       /* --- Validation & Initialisation --- */
       Validator valid = new Validator();
       String oFirstName="";
       
       if(valid.validateName((String)session.getAttribute("offenderFname")) & 
               valid.validateName((String)session.getAttribute("offenderLname"))){
            oFirstName = (String)session.getAttribute("offenderFname");
            oLastName = (String)session.getAttribute("offenderLname");
       }
       
       
       String 
       int offenderId;
       if(oFirstName!= null & oLastName != null){
            try{
                offenderId = manager.getOffenderIDByName(oFirstName,oLastName);
            }
            catch(Exception e){
                try {
                    manager.addOffenderIncindent(oFirstName, oLastName);
                    offenderId = manager.getOffenderIDByName(oFirstName,oLastName);
                } catch (SQLException ex) {
                    System.out.println("Query Failure");
                }
            }
       }
       //String offender = request.getParameter("offender");
       Venue venue = currentVenue;
       User assignUser = new User("assignedUserEmail","password");
       // Add some validation
       
       //Incident incident = new Incident(venue,type,desc,reporter,offender,assignUser,LocalDateTime.now(),1);
      // session.setAttribute("incident", incident);
       session.setAttribute("venue", venue);
       request.getRequestDispatcher("ViewIncident.jsp").include(request,response);
   }

}
