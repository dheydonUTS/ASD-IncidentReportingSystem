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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Offender;
import model.Incident;
import model.User;
import model.Venue;

/**
 *
 * @author joe
 */

public class IncidentTypeReportServlet extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        LinkedList<Incident> incidentList = dummyData(); //emulating pulling the data from a db
        request.setAttribute("incidents", incidentList);
        request.setAttribute("typeTally", getTypeCount(incidentList));
        request.getRequestDispatcher("typeReport.jsp").include(request, response);
    }
    
    public LinkedList<Incident> dummyData(){
        LinkedList<Incident> DummyList = new LinkedList();
        User AssignedUser = new User("assignedUserEmail","Password");
        Offender offender = new Offender("Big", "Stooge", "bigChungus@stooge.com", "0449024223", "stooge", true);
        Venue war = new Venue(1, "Warringah", -33.754350, 151.266890);
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
   
        DummyList.push(new Incident(war, "Shoplift",date,time, "Stole something", AssignedUser, offender,AssignedUser,LocalDateTime.now(),1));/*
        DummyList.push(new Incident("Arson", "Lit something on fire", "Jeff", "Adam"));
        DummyList.push(new Incident("Arson", "Lit something on fire", "Jeff", "Adam"));
        DummyList.push(new Incident("Broke the Escalators", "Jammed a trolly in the escalator", "Jeff", "Adam"));
        DummyList.push(new Incident("Arson", "Lit something on fire", "Jeff", "Adam"));
        DummyList.push(new Incident("Public Urination", "Peed on a Lady", "Jeff", "Adam"));
        DummyList.push(new Incident("Shoplift", "Stole something", "Jeff", "Adam"));*/
        
        return DummyList;
    }
    
    public HashMap<String, Integer> getTypeCount(LinkedList<Incident> incidents){
        HashMap<String, Integer> incidentTally = new HashMap();
        
        for (int i = 0; i < incidents.size(); i++){
            String keyT = incidents.get(i).getType();
            if (!incidentTally.containsKey(keyT)){
                incidentTally.put(keyT, 1);
            }
            else {
                incidentTally.put(keyT, incidentTally.get(keyT)+1 );
            }
    }
        ; 
        
        return incidentTally;
    }
    }
