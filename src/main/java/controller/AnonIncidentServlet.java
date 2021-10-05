/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.Offender;
import model.User;
import model.Venue;
import model.dao.DBManager;

/**
 *
 * @author User
 */
public class AnonIncidentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        Validator validator = new Validator();
        String type = request.getParameter("type");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        LocalTime time = LocalTime.parse(request.getParameter("time"));
        String venueName = (String) request.getParameter("venueName");
        Venue venue = new Venue();
        try {
            venue = manager.getVenueByName(venueName);
        } catch (SQLException ex) {
            Logger.getLogger(IncidentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String desc = request.getParameter("desc");
        if (!validator.validateDesc(desc)) {
            session.setAttribute("descError", "Invalid Description");
            request.getRequestDispatcher("incident.jsp").include(request, response);
        }
        allocateTicket al = new allocateTicket();
        int assignedUserId = 0;
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
        /*try {
            manager.addIncident(venue.getId(), type, desc, 0, 0, date.toString(), time.toString(), assignedUserId, LocalDateTime.now(), 1);
        } catch (SQLException ex) {
            Logger.getLogger(AnonIncidentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        User anonymous = new User(0, "N/A", "N/A", "Anonymous", "Anonymous", false);
        Offender tempOffender = new Offender(0, "N/A", "N/A", "N/A", "N/A", "N/A", false);
        if (!Boolean.parseBoolean((String)session.getAttribute("descError"))) {
            Incident incident = new Incident(venue,type,date,time,desc,anonymous,tempOffender,assignUser,LocalDateTime.now(),1);
            session.setAttribute("incident", incident);
            request.getRequestDispatcher("ViewIncident.jsp").include(request,response);
        }
    }
}
