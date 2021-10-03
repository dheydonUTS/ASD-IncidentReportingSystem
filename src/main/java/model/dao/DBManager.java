/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import model.Incident;
import model.Offender;
import model.User;
import model.Venue;
import model.Warning;

/**
 *
 * @author vince
 */
public class DBManager {
    private final Statement st;
    private final Connection con;

    public DBManager(Connection con) throws SQLException{
        this.con = con;
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
    
    
    
    /*----------------- Incident Creation  -----------------*/
    /* --- Create --- */
    public void addIncident(int venueid, String type, LocalDate date,
            LocalTime time, String description, int reporterId, int offenderId,
            int assignedUserId, LocalDateTime createdTime,  int priority) 
            throws SQLException{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = createdTime.format(formatter);
        st.executeUpdate("INSERT INTO \"Incident\"(venue_id,type,description,reporter_id,offender_id,assigned_user, ticket_created_time,status,priority)\n" +
"VALUES\n" +
"("+venueid+",'"+type+"', '"+description+"', "+reporterId+","+offenderId+","+assignedUserId+",'"+formatDateTime+"','open',"+priority+")");
    }
    /* --- Read --- */
    public Incident getCreatedIncident(int id) throws SQLException{
    return new Incident() ;
    }
    /* --- Update --- */
    
    /* --- Delete --- */
    
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
        
        public Offender addOffender(String firstName, String lastName, String email, String phone, String gender, boolean isBanned) throws SQLException {
        String sql = "INSERT INTO INCIDENTRS.\"Offender\"(first_name,last_name,gender,email,phone,is_banned) "
                + "VALUES ('" + firstName + "','" + lastName + "', '" + gender + "', '" + email + "', '" + phone + "'," + isBanned + ")";
        String[] returnId = {"offender_id"};
        PreparedStatement stmtInsert = con.prepareStatement(sql, returnId);
        int affectedRows = stmtInsert.executeUpdate();
        try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
            if (rs.next()) {
                return (getOffender(rs.getInt(1)));
            }
            rs.close();
        }
        return null;
    }


        /*-----------------Incident Reporting-----------------*/
/*
    public LinkedList<Incident> getIncidents() throws SQLExcpetion {
        LinkedList<Incident> incidents = new LinkedList();
        ResultSet result = st.executeQuery("SELECT * FROM \"Incident\"");
        while(result.next()){
            incidents.push(new Incident (
            result.getInt("INCIDENT_ID"),
            getVenue(result.getInt("VENUE_ID")),
            result.getString("TYPE")),
                    
            result.getString("FIRST_NAME"),
            result.getString("LAST_NAME"),
            result.getString("EMAIL"),
            result.getString("PHONE"),
            result.getString("GENDER"),
            result.getBoolean("IS_BANNED")
            ));
        }
        return offenders;
    }    */
        
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
            incident.setReporter(result.getString("REPORTER"));
            int offenderId = result.getInt("OFFENDER_ID");
            // Have to retrieve object, Incident uses string "offenderName"
            int userId = result.getInt("ASSIGNED_USER");
            incident.setAssignedUser(getUser(userId));
            incident.setCreatedTime(result.getTimestamp("TICKET_CREATED_TIME").toLocalDateTime());
            incident.setClosedTime(result.getTimestamp("TICKET_CLOSED_TIME").toLocalDateTime());
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
            incident.setReporter(result.getString("REPORTER"));
            int offenderId = result.getInt("OFFENDER_ID");
            // Have to retrieve object, Incident uses string "offenderName"
            int userId = result.getInt("ASSIGNED_USER");
            incident.setAssignedUser(getUser(userId));
            incident.setCreatedTime(result.getTimestamp("TICKET_CREATED_TIME").toLocalDateTime());
            incident.setClosedTime(result.getTimestamp("TICKET_CLOSED_TIME").toLocalDateTime());
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


        /*-----------------Warning-----------------*/

        public Warning addWarning(int venue_id, String description, int offender_id) throws SQLException {
        String sql = "INSERT INTO INCIDENTRS.\"Warning\"(venue_id, description, offender_id) "
                + "VALUES (" + venue_id + ",'" + description + "', " + offender_id + ")";
        String[] returnId = {"warning_id"};
        PreparedStatement stmtInsert = con.prepareStatement(sql, returnId);
        int affectedRows = stmtInsert.executeUpdate();
        try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
            if (rs.next()) {
                return (getWarning(rs.getInt(1)));
            }
            rs.close();
        }
        return null;
        }
        
        public Warning getWarning(int id) throws SQLException{
        ResultSet result = st.executeQuery("SELECT * FROM \"Warning\" WHERE WARNING_ID = "+id+"");
        while(result.next()){
            return new Warning(
            result.getInt("WARNING_ID"),
            result.getInt("VENUE_ID"),
            result.getString("DESCRIPTION"),
            result.getInt("OFFENDER_ID")
            );
        }
        return null;
        }
        
        }