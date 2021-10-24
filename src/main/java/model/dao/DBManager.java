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
 * @author ASD Group 7
 */
public class DBManager {
  private final Statement st;
  private final Connection con;

  public DBManager(Connection con) throws SQLException {
    this.con = con;
    st = con.createStatement(); //Execute statements in the connected database via object con
  }

  /*----------------- User -----------------*/

  // Updated by "Zwe" to get User object from database
  // Return venue object with id, returns null if not found
  public User getUser(int id) throws SQLException {
    ResultSet result = st.executeQuery("SELECT * FROM \"User\" WHERE USER_ID = " + id + "");
    User user = new User();
    while (result.next()) {
      user.setId(result.getInt("USER_ID"));
      user.setEmail(result.getString("EMAIL"));
      user.setFirstName(result.getString("FIRST_NAME"));
      user.setLastName(result.getString("LAST_NAME"));
      user.setPassword(result.getString("PASSWORD"));
      user.setIsStaff(result.getBoolean("IS_STAFF"));
    }
    System.out.println(user.toString());
    return user;
  }

  public void createUser(String email, String password, String fname, String lname) throws SQLException {
    st.executeUpdate("INSERT INTO INCIDENTRS.\"User\" (EMAIL, \"FIRST_NAME\", \"LAST_NAME\", PASSWORD, IS_STAFF) " +
      "VALUES ('" + email + "', '" + fname + "', '" + lname + "', '" + password + "', 'false')");
  }
  //AUTHOR: DHEYDON
  public User findUser(String address, String pass) throws SQLException {
    ResultSet result = st.executeQuery(
      "SELECT * FROM INCIDENTRS.\"User\" WHERE email = '" + address + "' ");
    while (result.next()) {
      String email = result.getString("EMAIL");
      String password = result.getString("PASSWORD");
      int user_id = result.getInt("USER_ID");
      String first_name = result.getString("FIRST_NAME");
      String last_name = result.getString("LAST_NAME");
      boolean is_staff = result.getBoolean("IS_STAFF");
      return new User(user_id, email, password, first_name, last_name,
        is_staff);
    }
    return null;
  }
  public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM INCIDENTRS.\"User\" WHERE EMAIL = '" + email + "'");
    }
    
    public void updateUser(String newEmail, String newPassword, String fname, String lname, String oldEmail) throws SQLException {
        st.executeUpdate("UPDATE INCIDENTRS.\"User\" SET EMAIL= '" + newEmail + "', PASSWORD='"+newPassword+"', FIRST_NAME='"+fname+"', LAST_NAME='"+lname+"' WHERE EMAIL='"+oldEmail+"'");
    }
  /*----------------- Incident Creation  -----------------*/
  /* --- Create --- */
  public int addIncident(int venueid, String type, String description,
    int reporterId, int offenderId, String time, String date, int assignedUserId,
    LocalDateTime createdTime, int priority) throws SQLException {
      
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");   //Set formatting for timestamp
        String formatDateTime = createdTime.format(formatter);                              // Create formatted time
        st.executeUpdate("INSERT INTO \"Incident\"(venue_id,type,description," +
          "reporter_id,offender_id,assigned_user, ticket_created_time," +
          "status,priority,INCIDENT_DATE, INCIDENT_TIME)\n" +
          "VALUES\n" +
          "(" + venueid + ",'" + type + "', '" + description + "', " + reporterId + "," +
          "" + offenderId + "," + assignedUserId + ",'" + formatDateTime +
          "','open'," + priority + ", '" + time + "', '" + date + "' )");                   // SQL Insert Statement to create incident
        ResultSet result = st.executeQuery(
          "SELECT * FROM INCIDENTRS.\"Incident\" order by incident_id desc");
        int id = 0;
        while (result.next()) {
          return result.getInt("incident_id");                                              // Return the incident ID to populate model. 
        }
        return id;
  }

  /* --- Get all members of staff and how many tickets they have  --- */
  public ArrayList < int[] > getStaff() throws SQLException {                   // Returns a list of staff ID's and the number of tickets
    ArrayList < int[] > Staff = new ArrayList < int[] > ();
    ResultSet result = st.executeQuery("SELECT \n" +                            // Query returns a table of staff users
      "ASSIGNED_USER AS UserID,Count(ASSIGNED_USER) AS num \n" +                // and the number of tickets they are 
      "FROM INCIDENTRS.\"Incident\" T1\n" +                                     // assigned to currently
      "where STATUS <> 'closed'\n" +
      "group by ASSIGNED_USER\n" +
      "UNION ALL\n" +
      "SELECT User_ID AS UserID,0 AS num  FROM INCIDENTRS.\"User\" T2 \n" +
      "where IS_Staff AND User_ID NOT IN \n" +
      "    (SELECT distinct ASSIGNED_USER FROM INCIDENTRS.\"Incident\")\n");
    while (result.next()) {                                                     // While there is still rows in the table
      Staff.add(new int[] {                                                     // add the next staff member and their tickets to the arraylist
        result.getInt("UserID"), result.getInt("num")
      });
    }
    return Staff;
  }

  public void addOffenderIncindent(String Fname, String Lname) throws SQLException {
    st.executeUpdate("INSERT INTO INCIDENTRS.\"Offender\"(first_name"           // Adds an offender to the 
            + ",last_name,is_banned)" +                                         // offender table.
      "VALUES ('" + Fname + "','" + Lname + "', " + "false" + ")");
  }

  public int getOffenderIDByName(String Fname, String Lname) throws SQLException {
    ResultSet result = st.executeQuery("SELECT OFFENDER_ID FROM INCIDENTRS."    // Returns an offenders ID 
            + "\"Offender\" where FIRST_NAME = '" + Fname                       // Searches by First Name, Last Name
            + "' AND LAST_NAME = '" + Lname + "'");
    while (result.next()) {
      return result.getInt("OFFENDER_ID");
    }
    return 0;
  }
  public Venue getVenueByName(String name) throws SQLException {
    ResultSet result = st.executeQuery("SELECT * FROM \"Venue\" WHERE VENUE_NAME = '" + name + "'");
    while (result.next()) {                                                     // Searches for a venue by name
      return new Venue(                                                         // Returns the first venue of name 'name'
        result.getInt("VENUE_ID"),                                              // else returns null
        result.getString("VENUE_NAME"),
        result.getString("VENUE_ADDRESS"),
        result.getDouble("VENUE_LAT"),
        result.getDouble("VENUE_LON")
      );
    }
    return null;
  }

  /*-----------------Venue -----------------*/

  // Return venue object with id, returns null if not found (!!** Working **!!)
  public Venue getVenue(int id) throws SQLException {
    ResultSet result = st.executeQuery("SELECT * FROM \"Venue\" WHERE VENUE_ID = " + id + "");
    Venue venue = null;
    while (result.next()) {
      venue = new Venue(
        result.getInt("VENUE_ID"),
        result.getString("VENUE_NAME"),
        result.getString("VENUE_ADDRESS"),
        result.getDouble("VENUE_LAT"),
        result.getDouble("VENUE_LON")
      );
    }
    venue.setIncidents(getIncidentFromVenue(id));
    return venue;
  }

  // List all of the venues
  public LinkedList < Venue > getVenues() throws SQLException {
    String query = "SELECT * FROM INCIDENTRS.\"Venue\"";
    ResultSet rs = st.executeQuery(query);
    LinkedList < Venue > venues = new LinkedList();

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

  public Venue addVenue(String venueName, String venueAddress, double venueLat, double venueLon) throws SQLException {

    String sql = "INSERT INTO INCIDENTRS.\"Venue\"(venue_name,venue_address,venue_lat,venue_lon) " +
      "VALUES ('" + venueName + "','" + venueAddress + "', " + venueLat + ", " + venueLon + ")";
    String[] returnId = {
      "venue_id"
    };
    PreparedStatement stmtInsert = con.prepareStatement(sql, returnId);
    int affectedRows = stmtInsert.executeUpdate();
    try (ResultSet rs = stmtInsert.getGeneratedKeys()) {
      if (rs.next()) {
        return (getVenue(rs.getInt(1)));
      }
      rs.close();
    }
    return null;
  }

  // Update Venue

  public void updateVenue(int venueID, String venueName, String venueAddress, double venueLat, double venueLon) throws SQLException {
    String query = "UPDATE INCIDENTRS.\"Venue\" SET VENUE_NAME='" + venueName + "', VENUE_ADDRESS='" + venueAddress +
      "', VENUE_LAT=" + venueLat + ", VENUE_LON=" + venueLon + " WHERE VENUE_ID=" + venueID + "";

    st.executeUpdate(query);
  }
  //Delete venue

  public void deleteVenue(int venueID) throws SQLException {
    String query = "DELETE FROM INCIDENTRS.\"Venue\" WHERE VENUE_ID =" + venueID + "";
    st.executeUpdate(query);
  }

  // Check Venue

  public boolean checkVenue(int venueID) throws SQLException {
    String fetch = "SELECT * FROM INCIDENTRS.\"Venue\" WHERE VENUE_ID =" + venueID + "";
    ResultSet rs = st.executeQuery(fetch);

    while (rs.next()) {
      int venue_id = rs.getInt(1);

      if (venue_id == venueID) {
        return true;
      }
    }
    return false;
  }

  public Venue findVenue(int venueID) throws SQLException {
    String fetch = "SELECT * FROM INCIDENTRS.\"Venue\" WHERE VENUE_ID =" + venueID + "";
    ResultSet rs = st.executeQuery(fetch);

    while (rs.next()) {
      int venue_id = rs.getInt(1);
      if (venue_id == venueID) {
        String venueName = rs.getString(2);
        String venueAddress = rs.getString(3);
        Double venueLat = rs.getDouble(4);
        Double venueLon = rs.getDouble(5);
        return new Venue(venueID, venueName, venueAddress, venueLat, venueLon);

      }
    }
    return null;
  }

  /*----------------- Offender -----------------*/
  //Return Offender Object, alternatively null if not found
  public Offender getOffender(int id) throws SQLException {
    ResultSet result = st.executeQuery("SELECT * FROM \"Offender\" WHERE OFFENDER_ID = " + id + "");
    while (result.next()) {
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
  public LinkedList < Offender > getOffenders() throws SQLException {
    LinkedList < Offender > offenders = new LinkedList();
    ResultSet result = st.executeQuery("SELECT * FROM \"Offender\"");
    while (result.next()) {
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
    String sql = "INSERT INTO INCIDENTRS.\"Offender\"(first_name,last_name,gender,email,phone,is_banned) " +
      "VALUES ('" + firstName + "','" + lastName + "', '" + gender + "', '" + email + "', '" + phone + "'," + isBanned + ")";
    String[] returnId = {
      "offender_id"
    };
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

  //Read all incidents from Incident table in Database
  public LinkedList < Incident > getIncidentList() throws SQLException {
    LinkedList < Incident > incidentList = new LinkedList < > ();
    ResultSet result = st.executeQuery("SELECT * FROM INCIDENTRS.\"Incident\"");
    while (result.next()) {
      Incident incident = new Incident();
      incident.setId(result.getInt("INCIDENT_ID"));
      Venue venue = new Venue();
      venue.setId(result.getInt("VENUE_ID"));
      incident.setVenue(venue);      
      incident.setType(result.getString("TYPE"));
      User reporter = new User();
      reporter.setId(result.getInt("REPORTER_ID"));
      incident.setReporter(reporter);
      User assigned = new User();
      assigned.setId(result.getInt("ASSIGNED_USER"));
      incident.setAssignedUser(assigned);
      incident.setStatus(result.getString("STATUS"));
      incident.setPriority(result.getInt("PRIORITY"));
      incident.setIncidentDate(LocalDate.parse(result.getString("INCIDENT_DATE")));
      incident.setIncidentTime(LocalTime.parse(result.getString("INCIDENT_TIME")));
      incidentList.add(incident);
      System.out.println("Added: " + incident.toString());
    }
    return getAssignedUser(getReporterForIncident(getVenueForIncident(incidentList)));
  }

  public LinkedList < Incident > getAssignedUser(LinkedList < Incident > incidentList) {
    try {
      for (Incident incident: incidentList) {
        int assignedID = incident.getAssignedUser().getId();
        incident.setAssignedUser(getUser(assignedID));
      }
    } catch (SQLException e) {

    }
    return incidentList;
  }
  // Retrieve Venue objects for list of Incidents
  public LinkedList < Incident > getVenueForIncident(LinkedList < Incident > incidentList) {
    try {
      for (Incident incident: incidentList) {
        int venueId = incident.getVenue().getId();
        incident.setVenue(getVenue(venueId));
      }
    } catch (SQLException e) {

    }
    return incidentList;
  }

  // Retrieve Venue objects for list of Incidents
  public LinkedList < Incident > getReporterForIncident(LinkedList < Incident > incidentList) {
    try {
      for (Incident incident: incidentList) {
        int reporterId = incident.getReporter().getId();
        incident.setReporter(getUser(reporterId));
      }
    } catch (SQLException e) {

    }
    return incidentList;
  }

  // Retrieve incident object from database
  public Incident getIncident(int id) throws SQLException {
    Incident incident = new Incident();
    ResultSet result = st.executeQuery("SELECT * FROM \"Incident\" WHERE INCIDENT_ID = " + id + "");
    int venueId = 0, reporterId = 0, offenderId = 0, assignedUserId = 0;
    while (result.next()) {
      incident.setId(result.getInt("INCIDENT_ID"));
      venueId = result.getInt("VENUE_ID");
      incident.setType(result.getString("TYPE"));
      incident.setDescription(result.getString("DESCRIPTION"));
      incident.setIncidentDate(LocalDate.parse(result.getString("INCIDENT_DATE")));
      incident.setIncidentTime(LocalTime.parse(result.getString("INCIDENT_TIME")));
      reporterId = result.getInt("REPORTER_ID");
      offenderId = result.getInt("OFFENDER_ID");
      assignedUserId = result.getInt("ASSIGNED_USER");
      incident.setCreatedTime(result.getTimestamp("TICKET_CREATED_TIME").toLocalDateTime());
      try {
        incident.setClosedTime(result.getTimestamp("TICKET_CLOSED_TIME").toLocalDateTime());
      } catch (Exception e) {
        System.out.println("Closed time is not set!");
      }
      incident.setStatus(result.getString("STATUS"));
      incident.setPriority(result.getInt("PRIORITY"));
    }
    //Retrieve foreign key attributes from other methods
    incident.setVenue(getVenue(venueId));
    incident.setReporter(getUser(reporterId));
    incident.setOffender(getOffender(offenderId));
    incident.setAssignedUser(getUser(assignedUserId));
    return incident;
  }

  /*-----------------Venue Report Generation-----------------*/

  // Retrieve list of Venues from database
  public LinkedList < Venue > getVenueList() throws SQLException {
    LinkedList < Venue > venueList = new LinkedList < Venue > ();
    ResultSet result = st.executeQuery("SELECT * FROM \"Venue\"");
    while (result.next()) {
      Venue venue = new Venue();
      venue.setId(result.getInt("VENUE_ID"));
      venue.setName(result.getString("VENUE_NAME"));
      venue.setAddress(result.getString("VENUE_ADDRESS"));
      venue.setLat(result.getDouble("VENUE_LAT"));
      venue.setLon(result.getDouble("VENUE_LON"));
      venueList.add(venue);
    }

    return venueList;
  }

  public LinkedList < Incident > getIncidentFromVenue(int venueId) throws SQLException {
    ResultSet result = st.executeQuery("SELECT * FROM \"Incident\" WHERE VENUE_ID=" + venueId + "");
    LinkedList < Incident > incidentList = new LinkedList < Incident > ();
    while (result.next()) {
      Incident incident = new Incident();
      incident.setId(result.getInt("INCIDENT_ID"));
      incident.setType(result.getString("TYPE"));
      incident.setDescription(result.getString("DESCRIPTION"));
      incident.setIncidentDate(LocalDate.parse(result.getString("INCIDENT_DATE")));
      incident.setIncidentTime(LocalTime.parse(result.getString("INCIDENT_TIME")));
      incidentList.add(incident);
      System.out.println("Added: " + incident.toString());
    }
    return incidentList;
  }

  /*-----------------Warning-----------------*/

  public Warning addWarning(int venue_id, String description, int offender_id) throws SQLException {
    String sql = "INSERT INTO INCIDENTRS.\"Warning\"(venue_id, description, offender_id) " +
      "VALUES (" + venue_id + ",'" + description + "', " + offender_id + ")";
    String[] returnId = {
      "warning_id"
    };
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

  public Warning getWarning(int id) throws SQLException {
    ResultSet result = st.executeQuery("SELECT * FROM \"Warning\" WHERE WARNING_ID = " + id + "");
    while (result.next()) {
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
