<%-- 
    Document   : manageVenues
    Created on : 06/09/2021, 5:25:01 PM
    Author     : christianlopez
--%>

<%@page import="model.Venue"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="./css/offenderDashboard.css">
    <head>
        <title>Incident Reporting System</title>
    </head>
    <body>
        <%
            LinkedList<Venue> venues = (LinkedList<Venue>) session.getAttribute("venues");
            String show = (String) session.getAttribute("show");
            String deleteMessage = (String) session.getAttribute("deleteMessage");
        %>
        <!-- Include the following page for Navbar and Global Style Imports -->
        <jsp:include page="components/navbar.jsp" />

        <!-- Card for Demo Purposes, feel free to copy for pages -->
        <div class="row">
            <div class="col-md-2 col-sm-0"></div>
            <div class="col-md-8 col-sm-12">
                <div class="card" style="margin-top:2rem;">
                    <h1 class="card-header">Manage Venues <span class="message"> <%=(deleteMessage != null ? deleteMessage : "")%></h1>
                    <div class="card-body">
                        
                                <table>

            <tr>
                <th>
                    <b>Venue ID</b>
                </th>
                <th>
                    <b>Venue Name</b>
                </th>
                <th>
                    <b>Venue Address</b>
                </th>
                <th>
                    <b>Venue Latitude</b>
                </th>
                <th>
                    <b>Venue Longitude</b>

                </th>
                <th>
                    <b>Edit Venue</b>
                </th>
                <th>
                    <b>Remove Venue</b>
                </th>
            </tr>


            <%
                if (venues != null) {
                    for (Venue v : venues) {
            %>


            <tr>

                <td><p><%=v.getId()%></p></td>
                <td><p><%=v.getName()%></p></td>
                <td><p><%=v.getAddress()%></p></td>
                <td><p><%=v.getLat()%></p></td>
                <td><p><%=v.getLon()%></p></td>
                <td><a class="button" href="editVenueServlet?venueID=<%= v.getId()%>">Edit</a></td>
                <td><a class="button" href="deleteVenueServlet?venueID=<%= v.getId()%>">Remove</a></td>

                <%}%>   

                                </table>
                                <br> <% } else {%>
                                <span><%=(show != null ? show : "This is not working")%></span>
                                <%}%>
                    </div>

                    <!--
                        <div class="row venue-row">
                            <div class="offender-card col-lg-4">
                            <div class="card col-lg-4" style="width: 18rem;">
                                <img src="https://upload.wikimedia.org/wikipedia/commons/a/a2/%281%29Westfield_Bondi_Junction-987.jpg" class="card-img-top venue-img" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Bondi</h5>
                                    <a href="./editVenue.jsp" class="btn btn-primary">Edit Venue</a>
                                </div>
                            </div>
                                </div>
                            
                            <div class="offender-card col-lg-4">
                            <div class="card col-lg-4" style="width: 18rem;">
                                <img src="https://cdn.newsapi.com.au/image/v1/d4446c630d4ae5eaf17eb5eedf1363ae" class="card-img-top venue-img" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Warringah</h5>
                                    <a href="./editVenue.jsp" class="btn btn-primary">Edit Venue</a>
                                </div>
                            </div>
                                </div>
                            
                            <div class="offender-card col-lg-4">
                            <div class="card col-lg-4" style="width: 18rem;">
                                <img src="https://www.parramattadentist.sydney/wp-content/uploads/2017/10/Westfield-Parramatta-2.jpg" class="card-img-top venue-img" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Parramatta</h5>
                                    <a href="./editVenue.jsp" class="btn btn-primary">Edit Venue</a>
                                </div>
                            </div>
                                </div>
                            <a href="./addVenue.jsp" class="btn btn-dark">Add New Venue</a>
                        </div>   
                        -->
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>