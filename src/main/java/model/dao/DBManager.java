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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import model.Incident;
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
    
    /*-----------------Venue -----------------*/
    
    // !! Havent tested !!
    // Return venue object with id, returns null if not found
    public Venue getVenue(int id) throws SQLException {
        ResultSet result = st.executeQuery("SELECT * FROM \"Venue\" WHERE VENUE_ID = "+id+"");
        if(result.next()){
            int venueId = result.getInt("VENUE_ID");
            String name = result.getString("VENUE_NAME");
            String address = result.getString("VENUE_ADDRESS");
            double lat = result.getDouble("VENUE_LAT");
            double lon = result.getDouble("VENUE_LON");
            return new Venue(venueId, name, lat, lon, address);
        }
        return null;
    }
    
    /*-----------------Incident Reporting-----------------*/
    
    // !! Havent tested !!
    //Read all incidents from Incident table in Database
    public LinkedList<Incident> getIncidentList() throws SQLException{
        ResultSet result = st.executeQuery("SELECT * FROM INCIDENTRS.\"Incident\"");
        while(result.next()){
            int incidentId = result.getInt("INCIDENT_ID");
            int venueId = result.getInt("VENUE_ID"); // Have to retrieve object
            String type = result.getString("TYPE");
            String description = result.getString("DESCRIPTION");
            Date date = result.getDate("DATE");
            Time time = result.getTime("TIME");
            String reporter = result.getString("REPORTER");
            int offenderId = result.getInt("OFFENDER_ID");
            // Have to retrieve object, Incident uses string "offenderName"
            int ticketId = result.getInt("TICKET_ID"); // Have to retrieve object
        }
        return null;
    }
}
