<%-- 
    Document   : VenueDetail
    Created on : 06/09/2021, 9:11:06 PM
    Author     : vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venue Details</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
            <div class="container p-5">
                <button type="button" class="btn btn primary" onclick="history.back()">< Back</button>
                <h1 class="display-4">Venue #1 Details</h1>
                <hr>
                <button type="button" class="btn btn-dark">Generate Report</button>
                <table class="table">
                    <tr><td>Venue Id:</td><td>1</td></tr>
                    <tr><td>Venue Name:</td><td>Venue 1</td></tr>
                    <tr><td>Address</td><td>1, Martin Place</td></tr>
                    <tr><td>No. of Incidents</td><td>1</td></tr>
                    </tr>
                </table>
                <hr>
                <h2 class="display-7">Incidents in this Venue</h2>
                <table class="table">
                    <tr><td>Incident Id</td><td>Venue</td><td></td></tr>
                <%for(int i = 1; i <=1; i++){%>
                <tr class="table-secondary">
                    <td><%out.print(i);%></td>
                    <td>Venue <%out.print(i);%></td>
                    <td><button type="button" class="btn btn-dark" onclick="window.location.href='IncidentDetails.jsp'">Details</button></td>
                </tr>
                <%}%>
                </table>
            </div>
        </div>
    </body>
</html>
