package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Incident;
import model.User;
import model.Venue;
import model.dao.DBConnector;
import model.dao.DBManager;

/**
 *
 * @author joe
 */
public class GraphsMapsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DBConnector conn;
    private DBManager manager;

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        initialiseDB();
        LinkedList<Incident> IncidentList = new LinkedList();
        //Try and get all incidents from DB 
        try {
            IncidentList = manager.getIncidentList();
        } catch (SQLException ex) {
            Logger.getLogger(GraphsMapsServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        //Calculate the counts of incident types and add to request
        request.setAttribute("IncidentTypeCount", incidentTypeCount(IncidentList));
        //Calculate the counts of incidents at venues and add to request
        request.setAttribute("VenueIncidentCount", venueIncidentCount(IncidentList));
        //Send data to display
        request.getRequestDispatcher("GraphsMaps.jsp").include(request, response);
    }

    public HashMap<String, Integer> incidentTypeCount(LinkedList<Incident> IncidentList) {
        //Store Incident Type as key, and count of that type as an integer
        HashMap<String, Integer> IncidentCount = new HashMap();
        IncidentList.forEach(incident -> {
            //If we already have the incident type in list
            if (IncidentCount.containsKey(incident.getType())) {
                //Increment the count of that incident type
                IncidentCount.put(incident.getType(), IncidentCount.get(incident.getType()) + 1);
            } else {
                //Otherwise start the count for that type
                IncidentCount.put(incident.getType(), 1);
            }
        });
        return IncidentCount;
    }

    public HashMap<Venue, Integer> venueIncidentCount(LinkedList<Incident> IncidentList) {
        //Store the venue as our key, and then the number of incidents at that venue as an integer
        HashMap<Venue, Integer> VenueIncidentCount = new HashMap();
        IncidentList.forEach(incident -> {
            //If we already have this venue in our list
            if (VenueIncidentCount.containsKey(incident.getVenue())) {
                //Increment the count of incidents at that venue
                VenueIncidentCount.put(incident.getVenue(), VenueIncidentCount.get(incident.getVenue()) + 1);
            } else {
                //Otherwise start the count for that venue
                VenueIncidentCount.put(incident.getVenue(), 1);
            }
        });
        return VenueIncidentCount;
    }

    //Create DB Connection and initialise DBManager
    public void initialiseDB() {
        try {
            conn = new DBConnector();
            manager = new DBManager(conn.connection());
        } catch (Exception ex) {
            Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
