/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Offender;
import model.dao.DBConnector;
import model.dao.DBManager;

/**
 *
 * @author christianlopez
 */
public class editOffenderServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector Connector;
    
    @Override //Create and instance of DBConnector for the deployment session
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {
            Connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(editOffenderServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try
        {       
            manager = new DBManager(Connector.connection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(editOffenderServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        // Session 
        HttpSession session = request.getSession();
        int offenderID = Integer.parseInt(request.getParameter("offenderID"));
        
        
        Offender offender = null;
          
        try {
            offender = manager.getOffender(offenderID); // Check if venue exists
            
            if (offender != null) { // If venue exists
                session.setAttribute("offender", offender);                   // Set attribute to venue, for updateVenueServlet to pick up 
                request.getRequestDispatcher("editOffender.jsp").include(request, response);
            } else {
                session.setAttribute("existErr", "Offender does not exist in the Database!");
                request.getRequestDispatcher("editOffender.jsp").include(request, response);
            }
        } catch (SQLException ex) {
             java.util.logging.Logger.getLogger(editOffenderServlet.class.getName()).log(Level.SEVERE,null,ex);
             request.getRequestDispatcher("offenderDashboard.jsp").include(request, response);
        }
}
     }
        