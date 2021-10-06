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
    DBManager manager = (DBManager) session.getAttribute("manager");            // Get DBManager from Session
    /* ---Get Session Variables ---*/
    User user = new User();
    user = (User) session.getAttribute("user");
    String type = request.getParameter("type");
    LocalDate date = LocalDate.parse(request.getParameter("date"));
    LocalTime time = LocalTime.parse(request.getParameter("time"));
    String venueName = (String) request.getParameter("venueName");
    Venue venue = new Venue();
    System.out.println(venueName);
    try {
      venue = manager.getVenueByName(venueName);                                // Get the venue
    } catch (SQLException ex) {}
    String desc = "";
    User reporter = (User) session.getAttribute("user");                        // Get current user

    /* --- Validation & Initialisation --- */
    Validator valid = new Validator();
    String oFirstName = "";
    String oLastName = "";
    int offenderId = 0;
    // Validate Offender Names
    if (valid.validateName((String) request.getParameter("offenderFname")) &&   // Validate first and last name together
      valid.validateName((String) request.getParameter("offenderLname"))) {
      oFirstName = (String) request.getParameter("offenderFname");              // Set if valid
      oLastName = (String) request.getParameter("offenderLname");
      session.setAttribute("offenderErr", "false");                             // Pass offender to session
    } else {
      session.setAttribute("offenderErr", "true");                              // If not valid set error to true
    }
    if (valid.validateDesc((String) request.getParameter("desc"))) {            // Validate the description
      desc = (String) request.getParameter("desc");
      session.setAttribute("descErr", "false");
    } else {
      session.setAttribute("descErr", "true");
    }
    // If theres an error in validation 
    if (Boolean.parseBoolean((String) session.getAttribute("offenderErr")) ||
      Boolean.parseBoolean((String) session.getAttribute("descErr"))) {
      request.getRequestDispatcher("incident.jsp").include(request, response);  // Return the user to the incident page with the errors
    } else {

      Offender offender = new Offender();
      try {
        offender = findOffender(oFirstName, oLastName, manager);                // Refer to method findOffender
      } catch (SQLException ex) {

      }
      allocateTicket al = new allocateTicket();                                 // Create an instance of the allocate ticket class
      int assignedUserId = 0;   
      int ticketId = 0;
      try {
        assignedUserId = al.nextFreeStaff(manager.getStaff());                  // Get the next free staff user's ID
      } catch (SQLException ex) {}
      User assignUser = new User();
      try {
        assignUser = manager.getUser(assignedUserId);                           // Get the above staff User
      } catch (SQLException ex) {}
      try {                                                                     // Create the incident in SQL, returns the ticket ID
        ticketId = manager.addIncident(venue.getId(), type, desc, user.getId(), offender.getId(), date.toString(), time.toString(), assignedUserId, LocalDateTime.now(), 1);
      } catch (SQLException ex) {}

      if (!(Boolean.parseBoolean((String) session.getAttribute("offenderErr")) ||
          Boolean.parseBoolean((String) session.getAttribute("descErr")))) {
        Incident incident = new                                                 // Create the incident in the session
        Incident(ticketId, venue, type, desc, reporter, offender, date, time, assignUser, LocalDateTime.now(), 1);
        session.setAttribute("incident", incident);
        request.getRequestDispatcher("ViewIncident.jsp").include(request, response);    
                                                                                // Redirect user to viewincident page
      }
    }
  }

  public Offender findOffender(String Fname, String Lname, DBManager manager) throws SQLException {
    int offenderId = manager.getOffenderIDByName(Fname, Lname);
    if (manager.getOffender(offenderId) != null) {                              // Check if the offender exists
      Offender offender = manager.getOffender(offenderId);                      // create and return the offender if they exist
      return offender;
    }
    manager.addOffender(Fname, Lname, "N/a", "N/a", "Undisclosed", false);      // Offender does not exists
    offenderId = manager.getOffenderIDByName(Fname, Lname);                     // Create offender and return them
    return manager.getOffender(offenderId);
  }

}