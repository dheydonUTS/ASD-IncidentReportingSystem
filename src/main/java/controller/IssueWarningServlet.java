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
        try {
            conn = new DBConnector();
            manager = new DBManager(conn.connection());
            offenders = manager.getOffenders();
            conn.closeConnection();
            manager = null;
        } catch (Exception ex) {
            Logger.getLogger(IssueWarningServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        request.setAttribute("Offenders", offenders);
        request.getRequestDispatcher("issuewarning.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));
        Boolean is_banned = Boolean.parseBoolean(request.getParameter("is_banned"));
    }

}
