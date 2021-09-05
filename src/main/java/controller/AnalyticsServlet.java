/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DummyIncident;
import model.DummyVenue;

/**
 *
 * @author joeda
 */
public class AnalyticsServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;

    @Override
protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        
        LinkedList<DummyIncident> IncidentList = dummyData();
        HashMap<String, Integer> IncidentTypeCount = incidentTypeCount(IncidentList);
        
        
        request.setAttribute("IncidentTypeCount", IncidentTypeCount);
        request.getRequestDispatcher("analytics.jsp").include(request, response);
    }

    public LinkedList<DummyIncident> dummyData() {
        LinkedList<DummyIncident> DummyList = new LinkedList();
        DummyVenue war = new DummyVenue(1, "Warringah", -33.754350, 151.266890);
        DummyVenue bon = new DummyVenue(2, "Bondi", -33.8923427, 151.2508617);
        DummyVenue par = new DummyVenue(3, "Parramatta", -33.817805, 151.0020877);

        DummyList.push(new DummyIncident(war, "Shoplift", new Date(), "Stole something", "Jeff", "Rachel"));
        DummyList.push(new DummyIncident(bon, "Shoplift", new Date(), "Stole something again", "Caitlin", "Rachel"));
        DummyList.push(new DummyIncident(par, "Fall", new Date(), "Someone fell", "Robert", "James"));
        DummyList.push(new DummyIncident(war, "Fall", new Date(), "Someone also fell", "Melinda", "Tom"));
        DummyList.push(new DummyIncident(bon, "Robbery", new Date(), "Someone robbed a store", "Robert", "Brendan"));

        return DummyList;
    }
    
    public HashMap<String, Integer> incidentTypeCount(LinkedList<DummyIncident> IncidentList) {
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
    
    public HashMap<DummyVenue, Integer> venueIncidentCount(LinkedList<DummyIncident> IncidentList){
        HashMap<DummyVenue, Integer> VenueIncidentCount = new HashMap();
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
