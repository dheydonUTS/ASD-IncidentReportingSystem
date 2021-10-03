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
import java.util.ArrayList;
import java.util.LinkedList;
import model.Incident;
import model.Offender;
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
        ResultSet result = st.executeQuery("SELECT * FROM \"Venue\" WHERE VENUE_ID = "+id+"");
        User user = new User("email","password");
        while(result.next()){
            // Retrieve user attributes
        }
        System.out.println(user.toString());
        return user;
    }

    /*-----------------Venue -----------------*/

    // !! Havent tested !!
    // Return venue object with id, returns null if not found
    public Venue getVenue(int id) throws SQLException {
        ResultSet result = st.executeQuery("SELECT * FROM \"Venue\" WHERE VENUE_ID = "+id+"");
        while(result.next()){
            return new Venue(
            result.getInt("VENUE_ID"),
            result.getString("VENUE_NAME"),
            result.getString("VENUE_ADDRESS"),
            result.getDouble("VENUE_LAT"),
            result.getDouble("VENUE_LON")        
            );
        }
        return null;
    }
    
    // List all of the venues
    public LinkedList<Venue> getVenues() throws SQLException {
        String query = "SELECT * FROM INCIDENTRS.\"Venue\"";
        ResultSet rs = st.executeQuery(query);
        LinkedList<Venue> venues = new LinkedList();
        
        while (rs.next()) {
            int venueID = rs.getInt(1);
            String venueName = rs.getString(2);
            String venueAddress = rs.getString(3);
            Double venueLat = rs.getDouble(4);
            Double venueLon = rs.getDouble(5);
            venues.push(new Venue(venueID, venueName, venueAddress, venueLat, venueLon));
        }
        return venues;
    }
    
    // Add venue
    
    public void addVenue(String venueName, String venueAddress, double venueLat, double venueLon) throws SQLException{
        int temp = 0;
    String query = "INSERT INTO INCIDENTRS.\"Venue\" VALUES ("+temp+",'"+venueName+"', '"+venueAddress+"', "+venueLat+", "+venueLon+"')";
    st.executeUpdate(query);

    String getid = "UPDATE INCIDENTRS.\"Venue\" SET Venue_ID = (SELECT MAX(Venue_ID) FROM INCIDENTRS.\"Venue\") + 1 WHERE Venue_ID = 0";
    st.executeUpdate(getid);
    }
    
    // Update Venue
    
   
   public void updateVenue(int venueID, String venueName, String venueAddress, double venueLat, double venueLon) throws SQLException {
       String query = "UPDATE INCIDENTRS.\"Venue\" SET VENUE_ID='" + venueID + "', VENUE_NAME='" + venueName + "', VENUE_ADDRESS='" + venueAddress + 
               "', VENUE_LAT='" + venueLat + "', VENUE_LON='" + venueLon + "'";
       
       st.executeUpdate(query);
   }
    //Delete venue
   
   public void deleteVenue (int venueID) throws SQLException {
       String query = "DELETE FROM INCIDENTRS.\"VENUE\" WHERE VENUE_ID ='" + venueID + "'";
       st.executeUpdate(query);
   }
   
   // Check User


    /*----------------- Offender -----------------*/
    //Return Offender Object, alternatively null if not found
    public Offender getOffender(int id) throws SQLException{
        ResultSet result = st.executeQuery("SELECT * FROM \"Offender\" WHERE OFFENDER_ID = "+id+"");
        while(result.next()){
            return new Offender(
            result.getInt("OFFENDER_ID"),
            result.getString("FIRST_NAME"),
            result.getString("LAST_NAME"),
            result.getString("EMAIL"),
            result.getString("PHONE"),
            result.getString("GENDER"),
            result.getBoolean("IS_BANNED")
            );
        }
        return null;
    }
    
    //Return all recorded offenders
        public LinkedList<Offender> getOffenders() throws SQLException{
        LinkedList<Offender> offenders = new LinkedList();
        ResultSet result = st.executeQuery("SELECT * FROM \"Offender\"");
        while(result.next()){
            offenders.push(new Offender(
            result.getInt("OFFENDER_ID"),
            result.getString("FIRST_NAME"),
            result.getString("LAST_NAME"),
            result.getString("EMAIL"),
            result.getString("PHONE"),
            result.getString("GENDER"),
            result.getBoolean("IS_BANNED")
            ));
        }
        return offenders;
    }

    
    

        /*-----------------Incident Reporting-----------------*/

    // !! Not complete !!
    //Read all incidents from Incident table in Database
    public LinkedList<Incident> getIncidentList() throws SQLException{
        LinkedList<Incident> incidentList = new LinkedList<>();ResultSet result = st.executeQuery("SELECT * FROM INCIDENTRS.\"Incident\"");
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
            int userId = result.getInt("ASSIGNED_USER");
            incident.setAssignedUser(getUser(userId));
            incident.setCreatedTime(result.getTime("TICKET_CREATED_TIME").toLocalTime());
            incident.setClosedTime(result.getTime("TICKET_CLOSED_TIME").toLocalTime());
            incident.setStatus(result.getString("STATUS"));
            incident.setPriority(result.getInt("PRIORITY"));
            incidentList.add(incident);
        }
        return incidentList;
    }
    
    public Incident getIncident(int id) throws SQLException{
        Incident incident = new Incident();
        ResultSet result = st.executeQuery("SELECT * FROM \"Incident\" WHERE INCIDENT_ID = "+id+"");
        while(result.next()){
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
            int userId = result.getInt("ASSIGNED_USER");
            incident.setAssignedUser(getUser(userId));
            incident.setCreatedTime(result.getTime("TICKET_CREATED_TIME").toLocalTime());
            incident.setClosedTime(result.getTime("TICKET_CLOSED_TIME").toLocalTime());
            incident.setStatus(result.getString("STATUS"));
            incident.setPriority(result.getInt("PRIORITY"));
        }
        return incident;
    }
    
    public int getIncidentId(int id) throws SQLException{
        ResultSet result = st.executeQuery("SELECT * FROM \"Incident\" WHERE INCIDENT_ID = "+id+"");
        int incidentId = 0;
        while(result.next()){
            incidentId = result.getInt("INCIDENT_ID");
            System.out.println("Found: " + incidentId);
        }
        return incidentId;
    }
}
