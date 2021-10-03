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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Offender;
import model.dao.*;

/**
 *
 * @author christianlopez
 */
public class listOffenderServlet {
    
    private DBManager manager;
    private DBConnector connector;
    
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
            LinkedList<Offender> offenders = manager.getOffenders();
            if (offenders != null) {
                session.setAttribute("offenders", offenders);
                request.getRequestDispatcher("offenderDashboard.jsp").include(request, response);
                session.setAttribute("show", "OffenderDashboard");
                response.sendRedirect("offenderDashboard.jsp");
            }
            else {
                request.getRequestDispatcher("offenderDashboard.jsp").include(request, response);
                session.setAttribute("show", "There are no offenders");
                response.sendRedirect("index.jsp");
            }
            
            } catch (SQLException ex){
            Logger.getLogger(listOffenderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

