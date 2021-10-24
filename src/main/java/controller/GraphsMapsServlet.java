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
import model.Offender;
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
    
            LinkedList<Incident> IncidentList = new LinkedList();
        LinkedList<Offender> OffenderList = new LinkedList();
        LinkedList<Venue> VenueList = new LinkedList();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        initialiseDB();


        //Try and get all incidents from DB 
        try {
            IncidentList = manager.getIncidentList();
            VenueList = manager.getVenues();
            OffenderList = manager.getOffenders();

        } catch (SQLException ex) {
            Logger.getLogger(GraphsMapsServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        //Calculate the counts of incident types and add to request
        request.setAttribute("IncidentTypeCount", incidentTypeCount(IncidentList));

        //Set all known offender in request
        request.setAttribute("Venues", VenueList);

        //Set all known venues in request
        request.setAttribute("Offenders", OffenderList);

        //Calculate the counts of incidents at venues of specified type and add to request
        String mapType = request.getParameter("map_type");
        if (mapType != "" && mapType != null) {
            request.setAttribute("MapData", venueSpecificIncidentCount(mapType, IncidentList));
            request.setAttribute("MapType", mapType);
        } else {
            request.setAttribute("MapData", venueIncidentCount(IncidentList));
            request.setAttribute("MapType", "Default");
        }

        String graphType = request.getParameter("graph_type");
        if (graphType != "" && graphType != null) {
            request.setAttribute("GraphData", graphFilter(graphType, IncidentList));
            // request.setAttribute("GraphType", graphType);
        } else {
            request.setAttribute("GraphData", venueIncidentCount(IncidentList));

        }

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

    public HashMap<String, Integer> graphFilter(String graphType, LinkedList<Incident> IncidentList) {
        //Store Incident Type as key, and count of that type as an integer
        HashMap<String, Integer> Count = new HashMap();
        char type = graphType.charAt(0);
        if(type == 'v'){
            return venueIncidentTypeCount(graphType.charAt(1), IncidentList);
        }
        
        if(type == 'o') {
            return offenderIncidentTypeCount(graphType.charAt(1), IncidentList);
        }
        
        //For breakdown by Incident Type (What venues it occured at)
        if(type == '@'){
            return incidentTypeByVenueCount(graphType.substring(1), IncidentList);
        }
        return null;
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

    private HashMap<Venue, Integer> venueSpecificIncidentCount(String mapType, LinkedList<Incident> IncidentList) {
//Store the venue as our key, and then the number of incidents at that venue as an integer
        HashMap<Venue, Integer> VenueIncidentCount = new HashMap();
        IncidentList.forEach(incident -> {
            //If we already have this venue in our list
            if (VenueIncidentCount.containsKey(incident.getVenue()) && incident.getType().equals(mapType)) {
                //Increment the count of incidents at that venue
                VenueIncidentCount.put(incident.getVenue(), VenueIncidentCount.get(incident.getVenue()) + 1);
            } else if (!VenueIncidentCount.containsKey(incident.getVenue()) && incident.getType().equals(mapType)) {
                //Otherwise start the count for that venue
                VenueIncidentCount.put(incident.getVenue(), 1);
            }
        });
        return VenueIncidentCount;
    }

    private HashMap<String, Integer> venueIncidentTypeCount(char id, LinkedList<Incident> IncidentList) {
        //Store Incident Type as key, and count of that type as an integer
        HashMap<String, Integer> IncidentCount = new HashMap();
        IncidentList.forEach(incident -> {
            //If we already have the incident type in list
            if (IncidentCount.containsKey(incident.getType()) && incident.getVenue().getId() == Integer.parseInt(id + "")) {
                //Increment the count of that incident type
                IncidentCount.put(incident.getType(), IncidentCount.get(incident.getType()) + 1);
            } else if (!IncidentCount.containsKey(incident.getType()) && incident.getVenue().getId() == Integer.parseInt(id + "")){
                //Otherwise start the count for that type
                IncidentCount.put(incident.getType(), 1);
            }
        });
        return IncidentCount;
    }

    private HashMap<String, Integer> offenderIncidentTypeCount(char id, LinkedList<Incident> IncidentList) {
        //Store Incident Type as key, and count of that type as an integer
        HashMap<String, Integer> IncidentCount = new HashMap();
        IncidentList.forEach(incident -> {
            //If we already have the incident type in list
            if (IncidentCount.containsKey(incident.getType()) && incident.getOffender().getId() == Integer.parseInt(id + "")) {
                //Increment the count of that incident type
                IncidentCount.put(incident.getType(), IncidentCount.get(incident.getType()) + 1);
            } else if (!IncidentCount.containsKey(incident.getType()) && incident.getOffender().getId() == Integer.parseInt(id + "")){
                //Otherwise start the count for that type
                IncidentCount.put(incident.getType(), 1);
            }
        });
        return IncidentCount;    }

    private HashMap<String, Integer> incidentTypeByVenueCount(String substring, LinkedList<Incident> IncidentList) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
