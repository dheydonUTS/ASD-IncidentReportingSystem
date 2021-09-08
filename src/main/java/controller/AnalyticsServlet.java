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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Incident;
import model.Venue;

/**
 *
 * @author joe
 */

public class AnalyticsServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

    @Override
protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        

        LinkedList<Incident> IncidentList = dummyData();
        
        request.setAttribute("IncidentTypeCount", incidentTypeCount(IncidentList));
        request.setAttribute("VenueIncidentCount", venueIncidentCount(IncidentList));
        request.getRequestDispatcher("analytics.jsp").include(request, response);
    }


    public LinkedList<Incident> dummyData() {
        LinkedList<Incident> DummyList = new LinkedList();
        Venue war = new Venue(1, "Warringah", -33.754350, 151.266890);
        Venue bon = new Venue(2, "Bondi", -33.8923427, 151.2508617);
        Venue par = new Venue(3, "Parramatta", -33.817805, 151.0020877);

        DummyList.push(new Incident(war, "Shoplift", LocalDate.now(), LocalTime.now(), "Stole something", "Jeff", "Rachel"));
        DummyList.push(new Incident(bon, "Shoplift", LocalDate.now(), LocalTime.now(), "Stole something again", "Caitlin", "Rachel"));
        DummyList.push(new Incident(par, "Fall", LocalDate.now(), LocalTime.now(), "Someone fell", "Robert", "James"));
        DummyList.push(new Incident(war, "Fall", LocalDate.now(), LocalTime.now(), "Someone also fell", "Melinda", "Tom"));
        DummyList.push(new Incident(bon, "Robbery", LocalDate.now(), LocalTime.now(), "Someone robbed a store", "Robert", "Brendan"));
        DummyList.push(new Incident(bon, "Crash", LocalDate.now(), LocalTime.now(), "Someone crashed", "Susie", "Ned"));
        DummyList.push(new Incident(bon, "Shoplift", LocalDate.now(), LocalTime.now(), "Another steal", "Ahmed", "Alex"));

        return DummyList;
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
    }
