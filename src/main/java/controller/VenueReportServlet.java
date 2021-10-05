/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Incident;
import model.User;
import model.Venue;

/**
 *
 * @author vince
 */
public class VenueReportServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Venue venue = (Venue)session.getAttribute("venue");
        User user = (User)session.getAttribute("user");
        String userName = "";
        if(user!=null){
            userName = user.getFirstName() + " " + user.getLastName(); 
        }else{
            userName = "No user in session!";
        }
        response.setContentType("text/plain");
        // Declared file attachment with specified name to be exported upon servlet activation
        response.setHeader("Content-Disposition", "attachment; filename=\"Venue #"+venue.getId()+" Detailed Report.txt\"");
        try {
            OutputStream outputStream = response.getOutputStream();
            // Build structure of exportable report
            String reportDetails = String.format("%-18s%s%n%-18s%s%n", "Generated by:", userName, "Generated date:", LocalDate.now());
            String reportGrid =      "+----------------------------------------------------------------------------------------+\n";
            String reportHeader =    "|                                  VENUE #"+venue.getId()+" DETAILED REPORT                              |\n";
            String reportSubheader = "|                                    INCIDENTS IN VENUE#3                                |\n";
            String venueRowFormat = "|%-20s|%-67s|%n";
            String incidentRowFormat = "|%-12s|%-12s|%-62s|%n";
            String incidentList = "";
            for(Incident incident : venue.getIncidents()){
                incidentList.concat(String.format(incidentRowFormat, incident.getId(), incident.getType(), incident.getDescription()));
            }
            String outputResult = reportDetails+reportGrid+reportHeader+reportGrid+
                    String.format(venueRowFormat, "Venue ID:", venue.getId())+
                    String.format(venueRowFormat, "Name:", venue.getName())+
                    String.format(venueRowFormat, "Address:", venue.getName())+
                    reportGrid+
                    String.format(incidentRowFormat, "Incident Id", "Type", "Description")+
                    reportGrid+incidentList+reportGrid;
                    
            // Export written file as .txt file
            outputStream.write(outputResult.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            System.out.println("File Export Error");
            Logger.getLogger(IncidentListServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
