<%-- 
    Document   : VenueDetail
    Created on : 06/09/2021, 9:11:06 PM
    Author     : vince
--%>

<%@page import="model.Incident"%>
<%@page import="model.Venue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venue Details</title>
    </head>
    <body>
        <%
            Venue venue = (Venue)session.getAttribute("venue");
        %>
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
            <div class="container p-5">
                <button type="button" class="btn btn primary" onclick="history.back()">< Back</button>
                <h1 class="display-4">Venue #<%=venue.getId()%> Details</h1>
                <hr>
                <button type="button" class="btn btn-dark" onclick="window.location.href='VenueReportServlet'">Generate Report</button>
                <table class="table">
                    <tr><td>Venue Id:</td><td><%=venue.getId()%></td></tr>
                    <tr><td>Venue Name:</td><td><%=venue.getName()%></td></tr>
                    <tr><td>Address:</td><td><%=venue.getAddress()%></td></tr>
                    <tr><td>No. of Incidents</td><td><%=venue.getIncidents().size()%></td></tr>
                    </tr>
                </table>
                <hr>
                <h2 class="display-7">Incidents in this Venue</h2>
                <table class="table">
                    <tr>
                        <td>Incident Id</td>
                        <td>Type</td>
                        <td>Date</td>
                        <td>Time</td>
                        <td></td>
                    </tr>
                <%for(Incident incident : venue.getIncidents()){%>
                <tr class="table-secondary">
                    <td><%=incident.getId()%></td>
                    <td><%=incident.getType()%></td>
                    <td><%=incident.getIncidentDate()%></td>
                    <td><%=incident.getIncidentTime()%></td>
                    <td><button type="button" class="btn btn-dark" onclick="window.location.href='IncidentDetailServlet?incidentId=<%=incident.getId()%>'">Details</button></td>
                </tr>
                <%}%>
                </table>
            </div>
        </div>
    </body>
</html>
