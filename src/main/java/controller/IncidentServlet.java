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
       String oFirstName = "";
       String oLastName ="";
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
           
       Offender offender = new Offender();
           try {
               offender = findOffender(oFirstName,oLastName,manager);
           } catch (SQLException ex) {
               
           }
       allocateTicket al = new allocateTicket();
       int assignedUserId =0;
       int ticketId=0;
    try {
        assignedUserId = al.nextFreeStaff(manager.getStaff());
    } catch (SQLException ex) {}
       User assignUser = new User();
    try {
        assignUser = manager.getUser(assignedUserId);
    } catch (SQLException ex) {}
    try {
        ticketId = manager.addIncident(venue.getId(),type,desc,user.getId(),offender.getId(),date.toString(),time.toString(),assignedUserId,LocalDateTime.now(),1);
    } catch (SQLException ex) {}
    
    if(!( Boolean.parseBoolean((String)session.getAttribute("offenderErr")) || 
            Boolean.parseBoolean((String)session.getAttribute("descErr")))){
       Incident incident = new 
        Incident(ticketId,venue,type,desc ,reporter,offender,date,time,assignUser,LocalDateTime.now(),1);
       session.setAttribute("incident", incident);
       request.getRequestDispatcher("ViewIncident.jsp").include(request,response);
       
    }
   }
  }

    public Offender findOffender(String Fname, String Lname, DBManager manager) throws SQLException{
        int offenderId = manager.getOffenderIDByName(Fname,Lname);
        if (manager.getOffender(offenderId)!= null ){
            Offender offender = manager.getOffender(offenderId);
            return offender;
            }
        manager.addOffender(Fname, Lname, "N/a", "N/a", "Undisclosed", false);
        offenderId = manager.getOffenderIDByName(Fname,Lname);
        return manager.getOffender(offenderId);
    }
    
}
