<%-- 
    Document   : VenueIncidents
    Created on : 06/09/2021, 8:50:42 AM
    Author     : vince
    This page will show the list of incidents
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Incidents</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
            <div class="container p-5">
                <button type="button" class="btn btn primary" onclick="history.back()">< Back</button>
                <h1 class="display-4">List of Incidents</h1>
                <hr>
                <form>
                    <div class="form-group">
                        Venue:<select name="venue">
                            <option value="all" selected>All</option>
                            <option value="v1">Venue 1</option>
                            <option value="v2">Venue 2</option>
                            <option value="v3">Venue 3</option>
                            <option value="v4">Venue 4</option>
                        </select>
                        <input type="button" name="venueFilter" value="Refresh">
                    </div>
                </form>
                <table class="table">
                    <tr><td>Incident Id</td><td>Venue</td><td></td></tr>
                <%for(int i = 1; i <=4; i++){%>
                <tr>
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