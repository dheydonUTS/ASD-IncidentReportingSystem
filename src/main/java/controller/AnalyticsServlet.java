/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class AnalyticsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DBConnector conn;
    private DBManager manager;
    
    @Override
protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
       initialiseDB();

       LinkedList<Incident> IncidentList = new LinkedList();
        try {
            IncidentList = manager.getIncidentList();
        } catch (SQLException ex) {
            Logger.getLogger(AnalyticsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("IncidentTypeCount", incidentTypeCount(IncidentList));
        request.setAttribute("VenueIncidentCount", venueIncidentCount(IncidentList));
        request.getRequestDispatcher("analytics.jsp").include(request, response);
    }

    public HashMap<String, Integer> incidentTypeCount(LinkedList<Incident> IncidentList) {
        
        HashMap<String, Integer> IncidentCount = new HashMap();
        IncidentList.forEach(incident -> {
            if (IncidentCount.containsKey(incident.getType())) {
                IncidentCount.put(incident.getType(), IncidentCount.get(incident.getType()) + 1);
            } else {
                IncidentCount.put(incident.getType(), 1);
            }
        });
        return IncidentCount;
    }
    

    public HashMap<Venue, Integer> venueIncidentCount(LinkedList<Incident> IncidentList){
        HashMap<Venue, Integer> VenueIncidentCount = new HashMap();
        
        IncidentList.forEach(incident -> {
            if(VenueIncidentCount.containsKey(incident.getVenue())) {
                VenueIncidentCount.put(incident.getVenue(), VenueIncidentCount.get(incident.getVenue()) + 1);
            }
            else{
               VenueIncidentCount.put(incident.getVenue(), 1);
            }
        });
        return VenueIncidentCount;
    }
    
    
   public void initialiseDB (){
    try {
            conn = new DBConnector();
            manager = new DBManager(conn.connection());
        } catch (Exception ex) {
            Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }
