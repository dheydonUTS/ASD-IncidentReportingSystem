<%-- 
    Document   : VenueIncidents
    Created on : 06/09/2021, 8:50:42 AM
    Author     : vince
    This page will show the list of incidents
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="model.Incident"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <style>
        body {
            background-image: url('images/background.png');
        }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Incidents</title>
    </head>
    <body>
        <%
            LinkedList<Incident> incidentList = (LinkedList<Incident>)session.getAttribute("incidentList");
        %>
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
            <div class="container p-5">
                <button type="button" class="btn btn primary" onclick="history.back()">< Back</button>
                <h1 class="display-4">List of Incidents</h1>
                <hr>
                <table class="table">
                    <tr>
                        <td>Incident Id</td>
                        <td>Venue</td>
                        <td>Type</td>
                        <td>Date</td>
                        <td>Time</td>
                        <td>Reporter</td>
                        <td></td>
                    </tr>
                <%for(Incident incident: incidentList){%>
                <tr>
                    <td><%=incident.getId()%></td>
                    <td><%=(incident.getVenue() != null ? incident.getVenue().getName() : "not specified")%></td>
                    <td><%=(incident.getType() != null ? incident.getType() : "not specified")%></td>
                    <td><%=(incident.getIncidentDate()!= null ? incident.getIncidentDate() : "not specified")%></td>
                    <td><%=(incident.getIncidentTime() != null ? incident.getIncidentTime() : "not specified")%></td>
                    <td><%=(incident.getReporter() != null ? incident.getReporter().getFirstName() +" " +incident.getReporter().getLastName() : "not specified")%></td>
                    <td><button type="button" class="btn btn-dark" onclick="window.location.href='IncidentDetailServlet?incidentId=<%=incident.getId()%>'">Details</button></td>
                </tr>
                <%}%>
                </table>
            </div>
        </div>
                <jsp:include page="components/footer.jsp"/>
    </body>
</html>