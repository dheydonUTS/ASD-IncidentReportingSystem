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
        //Look to defining these in a keychain.
        final String username = "incidentrs@gmail.com";
        final String password = "IncidentRS!1";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        MailSSLSocketFactory sf;
        //Define MailSSLSocketFactory
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            prop.put("mail.smtp.ssl.trust", "*");
            prop.put("mail.smtp.ssl.socketFactory", sf);
        } catch (GeneralSecurityException ex) {
            Logger.getLogger(TestEmailServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Create session with password authentication
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        //Try to send message.
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("incidentrs@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("joedahackinbot@gmail.com, joe.drew@yahoo.com.au")
            );
            message.setSubject("Warning from Incident Report System.");
            message.setContent(generateHTML(), "text/html");
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String generateHTML() {
        // <editor-fold defaultstate="collapsed" desc="Minified HTML Email Generation">
        return ("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN' 'http://www.w3.org/TR/REC-html40/loose.dtd'><html> <head> <meta http-equiv='Content-Type' content='text/html; charset=utf-8'> <style type='text/css'> body,table,td{font-family:Helvetica,Arial,sans-serif !important}.ExternalClass{width:100%}.ExternalClass,.ExternalClass p,.ExternalClass span,.ExternalClass font,.ExternalClass td,.ExternalClass div{line-height:150%}a{text-decoration:none}*{color:inherit}a[x-apple-data-detectors],u+#body a,#MessageViewBody a{color:inherit;text-decoration:none;font-size:inherit;font-family:inherit;font-weight:inherit;line-height:inherit}img{-ms-interpolation-mode:bicubic}table:not([class^=s-]){font-family:Helvetica,Arial,sans-serif;mso-table-lspace:0pt;mso-table-rspace:0pt;border-spacing:0px;border-collapse:collapse}table:not([class^=s-]) td{border-spacing:0px;border-collapse:collapse}@media screen and (max-width: 600px){.w-full,.w-full>tbody>tr>td{width:100% !important}*[class*=s-lg-]>tbody>tr>td{font-size:0 !important;line-height:0 !important;height:0 !important}.s-5>tbody>tr>td{font-size:20px !important;line-height:20px !important;height:20px !important}}</style></head> <body class='bg-dark' style='outline: 0; width: 100%; min-width: 100%; height: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; font-family: Helvetica, Arial, sans-serif; line-height: 24px; font-weight: normal; font-size: 16px; -moz-box-sizing: border-box; -webkit-box-sizing: border-box; box-sizing: border-box; color: #000000; margin: 0; padding: 0; border: 0;' bgcolor='#1a202c'><table class='bg-dark body' valign='top' role='presentation' border='0' cellpadding='0' cellspacing='0' style='outline: 0; width: 100%; min-width: 100%; height: 100%; -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; font-family: Helvetica, Arial, sans-serif; line-height: 24px; font-weight: normal; font-size: 16px; -moz-box-sizing: border-box; -webkit-box-sizing: border-box; box-sizing: border-box; color: #000000; margin: 0; padding: 0; border: 0;' bgcolor='#1a202c'> <tbody> <tr> <td valign='top' style='line-height: 24px; font-size: 16px; margin: 0;' align='left' bgcolor='#1a202c'> <table class='container' role='presentation' border='0' cellpadding='0' cellspacing='0' style='width: 100%;'> <tbody> <tr> <td align='center' style='line-height: 24px; font-size: 16px; margin: 0; padding: 0 16px;'><!--[if (gte mso 9)|(IE)]> <table align='center' role='presentation'> <tbody> <tr> <td width='600'><![endif]--> <table align='center' role='presentation' border='0' cellpadding='0' cellspacing='0' style='width: 100%; max-width: 600px; margin: 0 auto;'> <tbody> <tr> <td style='line-height: 24px; font-size: 16px; margin: 0;' align='left'> <table class='s-5 w-full' role='presentation' border='0' cellpadding='0' cellspacing='0' style='width: 100%;' width='100%'> <tbody> <tr> <td style='line-height: 20px; font-size: 20px; width: 100%; height: 20px; margin: 0;' align='left' width='100%' height='20'> &#160; </td></tr></tbody></table><table class='card' role='presentation' border='0' cellpadding='0' cellspacing='0' style='border-radius: 6px; border-collapse: separate !important; width: 100%; overflow: hidden; border: 1px solid #e2e8f0;' bgcolor='#ffffff'> <tbody> <tr> <td style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left' bgcolor='#ffffff'> <table class='card-body' role='presentation' border='0' cellpadding='0' cellspacing='0' style='width: 100%;'> <tbody> <tr> <td style='line-height: 24px; font-size: 16px; width: 100%; margin: 0; padding: 20px;' align='left'> <table class='alert alert-danger' role='presentation' border='0' cellpadding='0' cellspacing='0' style='border-collapse: separate !important; width: 100%; border: 0;'> <tbody> <tr> <td style='line-height: 24px; font-size: 16px; border-radius: 4px; color: #66121a; margin: 0; padding: 12px 20px; border: 1px solid transparent;' align='left' bgcolor='#fae3e5'> <div> <h1 style='padding-top: 0; padding-bottom: 0; font-weight: 500; vertical-align: baseline; font-size: 36px; line-height: 43.2px; margin: 0;' align='left'><strong>Warning Notice</strong></h1></div></td></tr></tbody></table><br><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>Dear (Name),</p><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>Centre Management from the XYZ Shopping Mall has deemed you to be an offender in the following incident;</p><br><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>Venue: XYZ Mall</p><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>Date: 1/1/1901</p><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>Time: 12pm</p><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>Offence type: Shoplift</p><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>Details: You took a fridge from an electronics store. This store was James Electrical</p><br><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>As a consequence, the centre will ban you from the venue unless a successful appeal is lodged within 5 days. Please see the link below for more information on the incident, and how to appeal.</p><br><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>Regards,</p><p style='line-height: 24px; font-size: 16px; width: 100%; margin: 0;' align='left'>Centre Management</p><br><!-- <h5 class='text-muted mb-2'>Dear (NAME),</h5> <h5 class='text-muted mb-2'>Centre Management has deemed you to be an offender in the following incident:</h5> <h5 class='text-muted mb-2'>You have 5 business days to appeal the warning.</h5> <h5 class='text-muted mb-2'>Regards, Centre Management</h5>--> <table class='btn btn-primary' role='presentation' border='0' cellpadding='0' cellspacing='0' style='border-radius: 6px; border-collapse: separate !important;'> <tbody> <tr> <td style='line-height: 24px; font-size: 16px; border-radius: 6px; margin: 0;' align='center' bgcolor='#0d6efd'> <a href='#' style='color: #ffffff; font-size: 16px; font-family: Helvetica, Arial, sans-serif; text-decoration: none; border-radius: 6px; line-height: 20px; display: inline-block; font-weight: normal; white-space: nowrap; background-color: #0d6efd; padding: 8px 12px; border: 1px solid #0d6efd;'>More Information</a> </td></tr></tbody></table> </td></tr></tbody></table> </td></tr></tbody></table><table class='s-5 w-full' role='presentation' border='0' cellpadding='0' cellspacing='0' style='width: 100%;' width='100%'> <tbody> <tr> <td style='line-height: 20px; font-size: 20px; width: 100%; height: 20px; margin: 0;' align='left' width='100%' height='20'> &#160; </td></tr></tbody></table> </td></tr></tbody> </table><!--[if (gte mso 9)|(IE)]> </td></tr></tbody> </table><![endif]--> </td></tr></tbody></table> </td></tr></tbody></table></body></html>");
        // </editor-fold>
    }
}
