/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class updateOffenderServlet extends HttpServlet {
    
    private DBManager manager;
    private DBConnector Connector;
    
    @Override //Create and instance of DBConnector for the deployment session
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try
        {
            Connector = new DBConnector();
        }catch (ClassNotFoundException | SQLException ex){
            java.util.logging.Logger.getLogger(updateOffenderServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try
        {       
            manager = new DBManager(Connector.connection());  
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(updateOffenderServlet.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        HttpSession session = request.getSession();
    
        int offenderID = Integer.parseInt(request.getParameter("offenderID"));                        // Parameters gathered 
        String offenderFirstName = request.getParameter("offenderFirstName");
        String offenderLastName = request.getParameter("offenderLastName");
        String offenderEmail = request.getParameter("offenderEmail");
        String offenderPhone  = request.getParameter("offenderPhone");
        String offenderGender  = request.getParameter("offenderGender");
        String offenderBanned  = request.getParameter("offenderBanned");
        Boolean isBanned = true;
        String offenderGenders;
      
        if ("male".equals(offenderGender)) {
            offenderGenders = "Male";
        }
        else if ("female".equals(offenderGender)) {
            offenderGenders = "Female";
        }
        else {
            offenderGenders = "Other";
        }
        
        if ("Banned".equals(offenderBanned)) {
           isBanned = true;
        } else {
            isBanned = false;
        }
        
       Offender offender = new Offender(offenderID, offenderFirstName, offenderLastName, offenderEmail, offenderPhone, offenderGenders, isBanned); 
       
       try {
            if (offender != null) {
                if (manager.checkOffender(offenderID)) {           // check offender exists
                session.setAttribute("offender", offender);
                manager.updateOffender(offenderID, offenderFirstName, offenderLastName, offenderEmail, offenderPhone, offenderGenders, isBanned);      //update the offender
                session.setAttribute("updated", "Update was successful");
                request.getRequestDispatcher("editOffender.jsp").include(request, response);
            } else {
                session.setAttribute("updated", "Update was not successful");
                request.getRequestDispatcher("editOffender.jsp").include(request, response);
            }
            } else
            {
                session.setAttribute("updated", "Update was not successful");
            }
        } catch (SQLException ex) {
         Logger.getLogger(updateOffenderServlet.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
}
