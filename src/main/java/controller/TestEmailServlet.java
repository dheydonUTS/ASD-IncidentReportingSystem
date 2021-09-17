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
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author joeda
 */
@WebServlet(name = "TestEmailServlet", urlPatterns = {"/TestEmailServlet"})
public class TestEmailServlet extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

String  d_email = "incidentrs@gmail.com",
            d_uname = "Incident Report System",
            d_password = "IncidentRS!1",
            d_host = "smtp.gmail.com",
            d_port  = "465",
            m_to = "joe.drew@yahoo.com.au",
            m_subject = "Hi Joe. Test Java Mail.",
            m_text = "Hi Joe! Testing from Java Mail";
    Properties props = new Properties();
    props.put("mail.smtp.user", d_email);
    props.put("mail.smtp.host", d_host);
    props.put("mail.smtp.port", d_port);
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.debug", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.socketFactory.port", d_port);
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
    
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("incidentrs@gmail.com", "IncidentRS!1");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);
         
         // Set From: header field of the header.
         message.setFrom(new InternetAddress(d_email));
         
         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
         
         // Set Subject: header field
         message.setSubject("This is the Subject Line!");
         
         // Now set the actual message
         message.setText("This is actual message");
         
         // Send message
Transport transport = session.getTransport("smtps");
            transport.connect(d_host, Integer.valueOf(d_port), d_uname, d_password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();



         String title = "Send Email";
         String res = "Sent message successfully....";
         String docType =
            "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
         
         out.println(docType +
            "<html>\n" +
               "<head><title>" + title + "</title></head>\n" +
               "<body bgcolor = \"#f0f0f0\">\n" +
                  "<h1 align = \"center\">" + title + "</h1>\n" +
                  "<p align = \"center\">" + res + "</p>\n" +
               "</body></html>"
         );
      }catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
