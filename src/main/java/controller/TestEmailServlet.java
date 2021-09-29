package controller;

import com.sun.mail.util.MailSSLSocketFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.GeneralSecurityException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


/**
 *
 * @author joe
 */
@WebServlet(name = "TestEmailServlet", urlPatterns = {"/TestEmailServlet"})
public class TestEmailServlet extends HttpServlet {
       public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
         final String username = "incidentrs@gmail.com";
        final String password = "IncidentRS!1";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        MailSSLSocketFactory sf;
           try {
               sf = new MailSSLSocketFactory();
               sf.setTrustAllHosts(true);
                prop.put("mail.smtp.ssl.trust", "*");
                prop.put("mail.smtp.ssl.socketFactory", sf);
           } catch (GeneralSecurityException ex) {
               Logger.getLogger(TestEmailServlet.class.getName()).log(Level.SEVERE, null, ex);
           }


        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("from@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("joedahackinbot@gmail.com, joe.drew@yahoo.com.au")
            );
            message.setSubject("Testing Gmail TLS");
            message.setText("Dear Mail Crawler,"
                    + "\n\n Please do not spam my email!");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
}
}
