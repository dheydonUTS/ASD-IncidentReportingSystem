/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalTime;
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
import model.Incident;
import model.User;
import model.Venue;

/**
 *
 * @author joe
 */

public class IncidentLocationReportServlet extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        LinkedList<Venue> venueList = dummyData();
        request.setAttribute("venueList", venueList);
        request.getRequestDispatcher("locationReport.jsp").include(request, response);
    }
    
    public LinkedList<Venue> dummyData(){
        LinkedList<Venue> DummyList = new LinkedList();
        LinkedList<Incident> rrInc = new LinkedList();  
        LinkedList<Incident> wmInc = new LinkedList();
        LinkedList<Incident> mmInc = new LinkedList();
        LinkedList<Incident> ewInc = new LinkedList();
        LinkedList<Incident> bjInc = new LinkedList();
        User AssignedUser = new User("assignedUserEmail","Password");
        Venue war = new Venue(1, "Warringah", -33.754350, 151.266890);
        
        
        
        rrInc.push(new Incident(war, "Shoplift", LocalDate.now(), LocalTime.now(), "Stole something", "Jeff", "Rachel",AssignedUser,LocalTime.now(),1));
        /*
        wmInc.push(new Incident("Arson", "Lit something on fire", "Jeff", "Adam"));
        wmInc.push(new Incident("Public Urination", "Peed on a Lady", "Jeff", "Adam"));
        mmInc.push(new Incident("Arson", "Lit something on fire", "Jeff", "Adam"));
        ewInc.push(new Incident("Arson", "Lit something on fire", "Jeff", "Adam"));
        bjInc.push(new Incident("Broke the Escalators", "Jammed a trolly in the escalator", "Jeff", "Adam"));
        bjInc.push(new Incident("Arson", "Lit something on fire", "Jeff", "Adam"));
        bjInc.push(new Incident("Public Urination", "Peed on a Lady", "Jeff", "Adam"));
        bjInc.push(new Incident("Shoplift", "Stole something", "Jeff", "Adam"));*/
        
        
        
        DummyList.push(new Venue(1, "Royal Randwick", "Randwick", "Belmore Rd" ,rrInc));
        DummyList.push(new Venue(2, "Waringah Mall", "Waringah", "Pitwater Rd", wmInc));
        DummyList.push(new Venue(3, "Marickville Metro", "Marickville", "Sidmore Rd", mmInc));
        DummyList.push(new Venue(4, "Eastgardens Westfield", "Eastgardens", "Bunnerong Road ", ewInc));
        DummyList.push(new Venue(5, "Bondi Junction Westfield", "Bondi Junction", "Oxford St", bjInc));
        
        return DummyList;
    }
    }
