<%-- 
    Document   : VenueList
    Created on : 06/09/2021, 9:08:56 PM
    Author     : vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Venue List</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
            <div class="container p-5">
                <button type="button" class="btn btn primary" onclick="history.back()">< Back</button>
                <h1 class="display-4">List of Venues</h1>
                <hr>
                <table class="table">
                    <tr><td>Venue Id</td><td>Venue Name</td><td></td></tr>
                <%for(int i = 1; i <=4; i++){%>
                <tr>
                    <td><%out.print(i);%></td>
                    <td>Venue <%out.print(i);%></td>
                    <td><button type="button" class="btn btn-dark" onclick="window.location.href='VenueDetails.jsp'">Details</button></td>
                </tr>
                <%}%>
                </table>
            </div>
        </div>
    </body>
</html>
