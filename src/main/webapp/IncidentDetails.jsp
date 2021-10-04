<%-- 
    Document   : IncidentDetails
    Created on : 06/09/2021, 8:34:54 PM
    Author     : vince
--%>

<%@page import="model.Incident"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incident Details</title>
    </head>
    <body>
        <%
            Incident incident = (Incident)session.getAttribute("incident");
        %>
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
            <div class="container p-5">
                <button type="button" class="btn btn primary" onclick="history.back()">< Back</button>
                <h1 class="display-4">Incident #<%=incident.getId()%> Details</h1>
                <hr>
                <button type="button" class="btn btn-dark">Generate Report</button>
                <table class="table">
                    <tr><td>Incident Id:</td><td><%=incident.getId()%></td></tr>
                    <tr><td>Venue:</td><td><%=(incident.getVenue() != null ? incident.getVenue().getName() : "not specified")%></td></tr>
                    <tr><td>Incident Type:</td><td><%=(incident.getType() != null ? incident.getType() : "not specified")%></td></tr>
                    <tr><td>Description:</td><td><%=(incident.getDescription() != null ? incident.getDescription() : "not specified")%></td></tr>
                    <tr><td>Date:</td><td><%=(incident.getIncidentDate() != null ? incident.getIncidentDate() : "not specified")%></td></tr>
                    <tr><td>Time:</td><td><%=(incident.getIncidentTime() != null ? incident.getIncidentTime() : "not specified")%></td></tr>
                    <tr>
                        <td>Reporter:</td>
                        <td><%=(incident.getReporter() != null ? incident.getReporter().getFirstName()+" "+incident.getReporter().getLastName(): "not specified")%></td>
                    </tr>
                    <tr>
                        <td>Offender:</td>
                        <td><%=(incident.getOffender() != null ? incident.getOffender().getFirstName()+" "+incident.getOffender().getLastName() : "not specified")%></td>
                    </tr>
                    </tr>
                </table>
                <h2 class="display-7">Allocated Ticket for Incident #<%=incident.getId()%></h2>
                <table class="table">
                    <tr class="table-secondary">
                        <td>Assigned Staff:</td>
                        <td><%=(incident.getAssignedUser()!= null ? incident.getAssignedUser().getFirstName()+" "+incident.getAssignedUser().getLastName() : "not specified")%></td>
                    </tr>
                    <tr class="table-secondary"><td>Created Time:</td><td><%=(incident.getCreatedTime()!= null ? incident.getCreatedTime() : "not specified")%></td></tr>
                    <tr class="table-secondary"><td>Closed Time:</td><td><%=(incident.getClosedTime()!= null ? incident.getClosedTime() : "Not closed yet")%></td></tr>
                    <tr class="table-secondary"><td>Status:</td><td><%=(incident.getStatus()!= null ? incident.getStatus(): "not specified")%></td></tr>
                    <tr class="table-secondary"><td>Priority:</td><td><%=(incident.getPriority()!= 0 ? incident.getPriority(): "not specified")%></td></tr>
                </table>
            </div>
        </div>
    </body>
</html>
