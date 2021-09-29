/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.LinkedList;
import model.Incident;
import model.Offender;
import model.Ticket;
import model.User;
import model.Venue;

/**
 *
 * @author vince
 */
public class DBManager {
    private final Statement st;

    public DBManager(Connection con) throws SQLException{
        st = con.createStatement(); //Execute statements in the connected database via object con
    }

    /*----------------- User -----------------*/

    // !! Havent tested !!
    // Return venue object with id, returns null if not found
    public User getUser(int id) throws SQLException {
        ResultSet result = st.executeQuery("SELECT * FROM \"Venue\" WHERE VENUE_ID = "+id+";");
        User user = new User("email","password");
        if(result.next()){
            // Retrieve user attributes
        }
        System.out.println(user.toString());
        return user;
    }

    /*-----------------Venue -----------------*/

    // !! Havent tested !!
    // Return venue object with id, returns null if not found
    public Venue getVenue(int id) throws SQLException {
        ResultSet result = st.executeQuery("SELECT * FROM \"Venue\" WHERE VENUE_ID = "+id+";");
        Venue venue = new Venue();
        if(result.next()){
            venue.setID(result.getInt("VENUE_ID"));
            venue.setName(result.getString("VENUE_NAME"));
            venue.setAddress(result.getString("VENUE_ADDRESS"));
            venue.setLat(result.getDouble("VENUE_LAT"));
            venue.setLon(result.getDouble("VENUE_LON"));
        }
        System.out.println(venue.toString());
        return venue;
    }

    /*----------------- Offender -----------------*/

    //!! Havent tested !!
    //Return offender object with id, returns null if not found
    public Offender getOffender(int id) throws SQLException{
        ResultSet result = st.executeQuery("SELECT * FROM \"Offender\" WHERE OFFENDER_ID = "+id+";");
        Offender offender = new Offender();
        if(result.next()){
            offender.setID(result.getString("OFFENDER_ID"));
            offender.setFirstName(result.getString("FIRST_NAME"));
            offender.setSurname(result.getString("LAST_NAME"));
            offender.setEmail(result.getString("EMAIL"));
            offender.setPhone(result.getString("PHONE"));
            offender.setPhone(result.getString("PHONE"));
            offender.setGender(result.getString("GENDER"));
        }
        System.out.println(offender.toString());
        return offender;
    }

    /*----------------- Ticket -----------------*/

    //!! Havent tested !!
    //Return ticket object with id, returns null if not found
    public Ticket getTicket(int id) throws SQLException{
        ResultSet result = st.executeQuery("SELECT * FROM \"Ticket\" WHERE TICKET_ID = "+id+";");
        Ticket ticket = new Ticket();
        if(result.next()){
            ticket.setTicketId(result.getInt("OFFENDER_ID"));
            int userId = result.getInt("ASSIGNED_USER");
            //ticket.setAssignedUser(getUser(userId)); Need to finish getUser() method!
            ticket.setAssignedUser(new User("email","password")); // Placeholder blank attribute for now
            int incidentId = result.getInt("INCIDENT_ID");
            //ticket.setIncident(getIncident(incidentId)); Need to finish getIncident() method!
            ticket.setIncident(new Incident()); // Placeholder blank attribute for now
            ticket.setCreatedTime(result.getTime("CREATED_TIME").toLocalTime());
            ticket.setClosedTime(result.getTime("CLOSED_TIME").toLocalTime());
            ticket.setStatus(result.getString("STATUS"));
            ticket.setPriority(result.getInt("PRIORITY"));
        }
        System.out.println(ticket.toString());
        return ticket;
    }

    /*-----------------Incident Reporting-----------------*/

    // !! Not complete !!
    //Read all incidents from Incident table in Database
    public LinkedList<Incident> getIncidentList() throws SQLException{
        LinkedList<Incident> incidents = new LinkedList<>();
        ResultSet result = st.executeQuery("SELECT * FROM INCIDENTRS.\"Incident\";");
        while(result.next()){
            Incident incident = new Incident();
            incident.setId(result.getInt("INCIDENT_ID"));
            int venueId = result.getInt("VENUE_ID"); // Have to retrieve object
            incident.setVenue(getVenue(venueId));
            incident.setType(result.getString("TYPE"));
            incident.setDescription(result.getString("DESCRIPTION"));
            incident.setDate(result.getDate("DATE").toLocalDate());
            incident.setTime(result.getTime("TIME").toLocalTime());
            incident.setReporter(result.getString("REPORTER"));
            int offenderId = result.getInt("OFFENDER_ID");
            // Have to retrieve object, Incident uses string "offenderName"
            int ticketId = result.getInt("TICKET_ID"); // Have to retrieve object
        }
        return null;
    }
}
