/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import org.apache.commons.mail.*;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author joeda
 */
@WebServlet(name = "TestEmailServlet", urlPatterns = {"/TestEmailServlet"})
public class TestEmailServlet extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
           try {
               Email email = new SimpleEmail();
               email.setHostName("smtp.gmail.com");
               email.setSmtpPort(465);
               email.setAuthenticator(new DefaultAuthenticator("incidentrs@gmail.com", "IncidentRS!1"));
               email.setSSLOnConnect(true);
               email.setFrom("incidentrs@gmail.com");
               email.setSubject("TestMail");
               email.setMsg("This is a test mail ... :-)");
               email.addTo("joe.drew@yahoo.com.au");
               email.send();
           } catch (EmailException ex) {
               Logger.getLogger(TestEmailServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
       }

}
