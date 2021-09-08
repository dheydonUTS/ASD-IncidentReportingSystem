<%-- 
    Document   : IncidentDetails
    Created on : 06/09/2021, 8:34:54 PM
    Author     : vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incident Details</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
            <div class="container p-5">
                <button type="button" class="btn btn primary" onclick="history.back()">< Back</button>
                <h1 class="display-4">Incident #1 Details</h1>
                <hr>
                <button type="button" class="btn btn-dark">Generate Report</button>
                <table class="table">
                    <tr><td>Incident Id:</td><td>1</td></tr>
                    <tr><td>Venue:</td><td>Venue 1</td></tr>
                    <tr><td>Incident Type:</td><td>Fight</td></tr>
                    <tr><td>Date:</td><td>06/09/2021</td></tr>
                    <tr><td>Time:</td><td>9:00:00</td></tr>
                    <tr><td>Description:</td><td>Offender punched victim in the face!</td></tr>
                    <tr><td>Offender Description:</td><td>Steve Wonders</td></tr>
                    <tr><td>Reporter Email:</td><td>stevewonders@uts.edu.au</td></tr>
                    </tr>
                </table>
                
            </div>
        </div>
    </body>
</html>
