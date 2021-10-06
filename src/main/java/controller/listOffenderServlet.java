/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Incident;
import model.Offender;
import model.dao.*;

/**
 *
 * @author christianlopez
 */
public class listOffenderServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector connector;
    
    @Override //Create and instance of DBConnector for the deployment session
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try
        {
            connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(listOffenderServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try
        {       
            manager = new DBManager(connector.connection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(listOffenderServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();
        
        try {
            LinkedList<Offender> offenders = manager.getOffenders(); // List of offenders using getOffenders from DBManager
            if (offenders != null) {
                session.setAttribute("offenders", offenders);
                request.getRequestDispatcher("offenderDashboard.jsp").include(request, response);
                session.setAttribute("show", "offenderDashboard");
                response.sendRedirect("offenderDashboard.jsp");
            }
            else {
                request.getRequestDispatcher("offenderDashboard.jsp").include(request, response);   // If no offenders are found
                session.setAttribute("show", "There are no offenders");
             //   response.sendRedirect("index.jsp");
            }
            
            } catch (SQLException ex){
            Logger.getLogger(listOffenderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


/*
public class listOffenderServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  // Loads the list of incidents from the database
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        
        LinkedList<Offender> offenders = null;
        try{
            offenders = manager.getOffenders(); // Loads the list of incidents
        }catch(SQLException e){
            Logger.getLogger(listOffenderServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        session.setAttribute("offenders", offenders); // Set list of incidents into session
        request.getRequestDispatcher("offenderDashboard.jsp").forward(request, response); // Dispatch request and response to webpage
    }
}
*/