/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DummyIncident;
import model.DummyVenue;
import model.Offender;

/**
 *
 * @author joe
 */

public class OffenderReportServlet extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        LinkedList<Offender> OffenderList = dummyData();
        request.setAttribute("offenders", OffenderList);
        request.getRequestDispatcher("offenderReport.jsp").include(request, response);
    }
    
    public LinkedList<Offender> dummyData(){
        LinkedList<Offender> DummyList = new LinkedList();
        
        DummyList.push(new Offender("10001", "Adam", "McCaffery", "Male"));
        DummyList.push(new Offender("10002", "Dom", "Heydon", "Male"));
        DummyList.push(new Offender("10003", "Arun", "Mohindra", "Male"));
        DummyList.push(new Offender("10004", "Christian", "Lopez", "Male"));
        DummyList.push(new Offender("10005", "Joe", "Drew", "Male"));
        DummyList.push(new Offender("10006", "Zwe", "Htin Aung", "Male"));
        
        return DummyList;
    }
    }
