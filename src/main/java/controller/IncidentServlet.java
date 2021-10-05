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
       User user = new User();
       user = (User)session.getAttribute("user");
       String type = request.getParameter("type");
       LocalDate date = LocalDate.parse(request.getParameter("date"));
       LocalTime time = LocalTime.parse(request.getParameter("time"));
       String venueName = (String)request.getParameter("venueName");
       Venue venue = new Venue();
       System.out.println(venueName);
        try {
            venue = manager.getVenueByName(venueName);
        } catch (SQLException ex) {
            Logger.getLogger(IncidentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       String desc = "";
       User reporter = (User)session.getAttribute("user");
       
       /* --- Validation & Initialisation --- */
       Validator valid = new Validator();
       String oFirstName;
       String oLastName;
       int offenderId = 0;
       // Validate Offender Names
       if(valid.validateName((String)request.getParameter("offenderFname"))&& 
            valid.validateName((String)request.getParameter("offenderLname"))){
           oFirstName = (String)request.getParameter("offenderFname");
           oLastName = (String)request.getParameter("offenderLname");
           session.setAttribute("offenderErr","false");
       }
       else{
       session.setAttribute("offenderErr","true");
       }
       if(valid.validateDesc((String)request.getParameter("desc"))){
           desc = (String)request.getParameter("desc");
           session.setAttribute("descErr","false");
       }
       else{
       session.setAttribute("descErr","true");
       }
       
       if( Boolean.parseBoolean((String)session.getAttribute("offenderErr")) || 
           Boolean.parseBoolean((String)session.getAttribute("descErr")) ){
            request.getRequestDispatcher("incident.jsp").include(request,response);
            }
       else{
       /*
       if(valid.validateName((String)request.getParameter("offenderFname")) &       // Check offender first & last name are valid
               valid.validateName((String)request.getParameter("offenderLname"))){
            oFirstName = (String)request.getParameter("offenderFname");
            oLastName = (String)request.getParameter("offenderLname");
            try{                                                                    // Check for offender in DB
                offenderId = manager.getOffenderIDByName(oFirstName,oLastName);
            }
            catch(Exception e){
                try {                                                               // Create Offender if not in DB
                    manager.addOffenderIncindent(oFirstName, oLastName);
                    offenderId = manager.getOffenderIDByName(oFirstName,oLastName);
                } catch (Exception x) {
                    System.out.println("Query Failure");
                }
            }
       }
       Offender offender = new Offender();
    try {
        offender = manager.getOffender(offenderId);
    } catch (SQLException ex) {
        Logger.getLogger(IncidentServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
       //String offender = request.getParameter("offender");*/
       Offender offender = new Offender();
    try {
        offender = manager.getOffender(1);
    } catch (SQLException ex) {
        Logger.getLogger(IncidentServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
       allocateTicket al = new allocateTicket();
       int assignedUserId =0;
    try {
        assignedUserId = al.nextFreeStaff(manager.getStaff());
    } catch (SQLException ex) {
        Logger.getLogger(IncidentServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
       User assignUser = new User();
    try {
        assignUser = manager.getUser(assignedUserId);
    } catch (SQLException ex) {
        Logger.getLogger(IncidentServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        manager.addIncident(venue.getId(),type,desc,user.getId(),offender.getId(),date.toString(),time.toString(),assignedUserId,LocalDateTime.now(),1);
    } catch (SQLException ex) {
        Logger.getLogger(IncidentServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
    if(!( Boolean.parseBoolean((String)session.getAttribute("offenderErr")) || Boolean.parseBoolean((String)session.getAttribute("descErr")))){
       Incident incident = new Incident(venue,type,date,time,desc,reporter,offender,assignUser,LocalDateTime.now(),1);
       session.setAttribute("incident", incident);
       request.getRequestDispatcher("ViewIncident.jsp").include(request,response);
    }
   }
  }

}
