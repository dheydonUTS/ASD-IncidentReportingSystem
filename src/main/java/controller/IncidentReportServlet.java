/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Incident;

/**
 *
 * @author vince
 */
public class IncidentReportServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Incident incident = (Incident)session.getAttribute("incident");
        response.setContentType("text/plain");
        // Declared file attachment with specified name to be exported upon servlet activation
        response.setHeader("Content-Disposition", "attachment; filename=\"Incident #"+incident.getId()+" Detailed Report.txt\"");
        String ticketClosedTime;
        try{
            ticketClosedTime = incident.getClosedTime().toString();
        }catch(Exception e){
            ticketClosedTime = "not closed yet";
        }
        try {
            OutputStream outputStream = response.getOutputStream();
            // Build structure of exportable report
            String reportGrid =      "+------------------------------------------------------------------------------+\n";
            String reportHeader =    "|                          INCIDENT #"+incident.getId()+" DETAILED REPORT                         |\n";
            String reportSubheader = "|                       ALLOCATED TICKET FOR INCIDENT#"+incident.getId()+"                        |\n";
            String rowFormat = "|%-20s|%-57s|%n";
            String outputResult = reportGrid+reportHeader+reportGrid+
                    String.format(rowFormat, "Incident Id:", incident.getId())+
                    String.format(rowFormat, "Venue:", incident.getVenue().getName())+
                    String.format(rowFormat, "Incident Type:", incident.getType())+
                    String.format(rowFormat, "Description:", incident.getDescription())+
                    String.format(rowFormat, "Date:", incident.getIncidentDate())+
                    String.format(rowFormat, "Time:", incident.getIncidentTime())+
                    String.format(rowFormat, "Reporter:", incident.getReporter().getFirstName()+" "+incident.getReporter().getLastName())+
                    String.format(rowFormat, "Offender:", incident.getOffender().getFirstName()+" "+incident.getOffender().getLastName())+
                    reportGrid+reportSubheader+reportGrid+
                    String.format(rowFormat, "Assigned Staff:", incident.getAssignedUser().getFirstName()+" "+incident.getAssignedUser().getLastName())+
                    String.format(rowFormat, "Created Time:", incident.getCreatedTime())+
                    String.format(rowFormat, "Closed Time:", ticketClosedTime)+
                    String.format(rowFormat, "Status:", incident.getStatus())+
                    String.format(rowFormat, "Priority:", incident.getPriority())+reportGrid;
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