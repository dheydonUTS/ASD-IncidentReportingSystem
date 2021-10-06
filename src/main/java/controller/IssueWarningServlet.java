package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashSet;
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
import model.Warning;
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

    //On page load
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LinkedList<Offender> offenders = new LinkedList();
        LinkedList<Venue> venues = new LinkedList();
        initialiseDB();
        try {
            //Get all recorded offenders and venues
            offenders = manager.getOffenders();
            venues = manager.getVenues();
        } catch (SQLException ex) {
            Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        //Store the offeders and venues in the request
        request.setAttribute("Offenders", offenders);
        request.setAttribute("Venues", venues);
        request.getRequestDispatcher("issuewarning.jsp").include(request, response);
    }

    //On form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initialiseDB();
        int offenderID = Integer.parseInt(request.getParameter("offender_id"));
        //If a new offender has been selected, create it
        if ("new".equals(request.getParameter("offenderType"))) {
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String gender = request.getParameter("gender");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            Boolean is_banned = Boolean.parseBoolean(request.getParameter("is_banned"));
            //Try to add offender to database
            try {
                offenderID = manager.addOffender(first_name, last_name, email, phone, gender, is_banned).getId();
            } catch (SQLException ex) {
                request.getRequestDispatcher("error.jsp").include(request, response);
                Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //Create a warning
        String description = request.getParameter("description");
        int venueID = Integer.parseInt(request.getParameter("venue_id"));
        try {
            //Insert warning into DB, and then get inserted Warning object
            Warning warning = manager.addWarning(venueID,description,offenderID);
            //Set type of message we want email servlet to send, and provide with warning object
            request.setAttribute("emailType", "warning");
            request.setAttribute("Warning", warning);
        } catch (SQLException ex) {
            Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("error.jsp").include(request, response);
        }
        //Finally Dispatch to EmailServlet
        request.getRequestDispatcher("EmailServlet").include(request, response);
        }
        
    //Initialise Database connection and manager
   public void initialiseDB (){
    try {
            conn = new DBConnector();
            manager = new DBManager(conn.connection());
        } catch (Exception ex) {
            Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}

