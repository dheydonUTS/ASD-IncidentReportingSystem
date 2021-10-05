<%-- 
    Document   : editVenue
    Created on : 06/09/2021, 7:05:52 PM
    Author     : christianlopez
--%>

<%@page import="model.Venue"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="./css/offenderDashboard.css">
<head>
<title>Incident Reporting System</title>
</head>
<body>
    
    <%
        Venue venue = (Venue) session.getAttribute("venue");
        String updated = (String) session.getAttribute("updated");
    %>
	<!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<!-- Card for Demo Purposes, feel free to copy for pages -->
	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
	<div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Update Venue Information <span class="message"> <%=(updated != null ? updated : "")%></h1>
		<div class="card-body">
			<h5 class="card-title">Edit Venue: ${venue.name}</h5>
                        <form method="post" action="updateVenueServlet">
                            <table id="form_table">
                                <tr><td>Venue ID:  ${venue.id}</td><td> <input type="hidden" name="venueID" value="${venue.id}"></td></tr>
                                <tr><td>Venue Name</td><td> <input type="text" name="venueName" value="${venue.name}"></td></tr>
                                <tr><td>Venue Address</td><td> <input type="text" name="venueAddress" value="${venue.address}"></td></tr>
                                <tr><td>Venue Latitude</td><td> <input type="text" name="venueLat" value="${venue.lat}"></td></tr>
                                <tr><td>Venue Longitude</td><td> <input type="text" name="venueLon" value="${venue.lon}"></td></tr>
                                <tr><td></td>
                                    <td>
                                        <input class="button" type="submit" value="Update">
                                    </td>
                                </tr>
                            </table>
                        </form>

                        <!--
                        
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Edit Name:</label>
                               <input class="form-control"type="text" name="desc" >
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Edit Longitude:</label>
                               <input class="form-control"type="text" name="desc" >
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Edit Latitude:</label>
                               <input class="form-control"type="text" name="desc" >
                        </div>
                        <a href="./manageVenues.jsp" class="btn btn-primary delete-btn">Confirm changes</a>
			<a href="./manageVenues.jsp" class="btn btn-danger delete-btn">Delete Venue</a>
                </div>
                        -->
	</div>
        </div>
        </div>
        </div>
	

</body>
</html>