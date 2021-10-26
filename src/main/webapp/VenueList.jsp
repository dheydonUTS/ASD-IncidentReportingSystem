<%-- 
    Document   : VenueList
    Created on : 06/09/2021, 9:08:56 PM
    Author     : vince
--%>

<%@page import="model.Venue"%>
<%@page import="java.util.LinkedList"%>
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
        <title>Venue List</title>
    </head>
    <body>
        <%
            LinkedList<Venue> venueList = (LinkedList<Venue>)session.getAttribute("venueList");
        %>
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
            <div class="container p-5">
                <button type="button" class="btn btn primary" onclick="history.back()">< Back</button>
                <h1 class="display-4">List of Venues</h1>
                <hr>
                <table class="table">
                    <tr>
                        <td>Venue Id</td>
                        <td>Venue Name</td>
                        <td>Venue Address</td>
                        <td></td>
                    </tr>
                <%for(Venue venue : venueList){%>
                <tr>
                    <td><%=venue.getId()%></td>
                    <td><%=venue.getName()%></td>
                    <td><%=venue.getAddress()%></td>
                    <td><button type="button" class="btn btn-dark" onclick="window.location.href='VenueDetailServlet?venueId=<%=venue.getId()%>'">Details</button></td>
                </tr>
                <%}%>
                </table>
            </div>
        </div>
                <jsp:include page="components/footer.jsp"/>
    </body>
</html>
