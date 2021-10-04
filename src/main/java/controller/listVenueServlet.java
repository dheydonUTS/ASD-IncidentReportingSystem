/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Venue;
import model.dao.DBConnector;
import model.dao.DBManager;

/**
 *
 * @author christianlopez
 */
public class listVenueServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector connector;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        try
        {
            connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(listVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try
        {       
            manager = new DBManager(connector.connection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(listVenueServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        //session
        HttpSession session = request.getSession();
        
        try {
            LinkedList<Venue> venues = manager.getVenues();
            if (venues != null) {
                session.setAttribute("venues", venues);
                request.getRequestDispatcher("manageVenues.jsp").include(request, response);
                session.setAttribute("show", "manageVenues");
                response.sendRedirect("manageVenues.jsp");
            }
            else {
                request.getRequestDispatcher("manageVenues.jsp").include(request, response);
                session.setAttribute("show", "There are no offenders");
                response.sendRedirect("index.jsp");
            }
            
            } catch (SQLException ex){
            Logger.getLogger(listVenueServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    