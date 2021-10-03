/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Offender;
import model.Venue;
import model.dao.DBConnector;
import model.dao.DBManager;

/**
 *
 * @author joe
 */
@WebServlet(name = "IssueWarning", urlPatterns = {"/IssueWarning"})
public class IssueWarningServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DBConnector conn;
    private DBManager manager;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LinkedList<Offender> offenders = new LinkedList();
        LinkedList<Venue> venues = new LinkedList();
        initialiseDB();
        try {
            offenders = manager.getOffenders();
            venues = manager.getVenues();
        } catch (SQLException ex) {
            Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("Offenders", offenders);
        request.setAttribute("Venues", venues);
        request.getRequestDispatcher("issuewarning.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initialiseDB();
        int offenderID = Integer.parseInt(request.getParameter("offender_id"));
        //Create Offender if needed
        System.out.println("We got a type of: " + request.getParameter("offenderType"));
        if ("new".equals(request.getParameter("offenderType"))) {
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            Boolean is_banned = Boolean.parseBoolean(request.getParameter("is_banned"));
            try {
                offenderID = manager.addOffender(first_name, last_name, email, phone, gender, is_banned).getId();
            } catch (SQLException ex) {
                Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Create Warning
        String description = request.getParameter("description");
        int venueID = Integer.parseInt(request.getParameter("venue_id"));
        try {
            manager.addWarning(venueID,description,offenderID);
        } catch (SQLException ex) {
            Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

