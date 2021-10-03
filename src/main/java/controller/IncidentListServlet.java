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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Incident;
import model.dao.DBManager;

/**
 *
 * @author vince
 */
public class IncidentListServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBManager manager = (DBManager)session.getAttribute("manager");
        LinkedList<Incident> incidentList = null;
        try{
            incidentList = manager.getIncidentList();
        }catch(SQLException e){
            Logger.getLogger(IncidentListServlet.class.getName()).log(Level.SEVERE, null, e);
        }
        session.setAttribute("incidentList", incidentList);
        request.getRequestDispatcher("IncidentList.jsp").forward(request, response);
    }
}