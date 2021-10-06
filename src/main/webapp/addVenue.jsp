<%-- 
    Document   : addVenue
    Created on : 06/09/2021, 7:22:24 PM
    Author     : christianlopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="./css/offenderDashboard.css">
<head>
<title>Incident Reporting System</title>
</head>
<body>
    <%
        String added = (String) session.getAttribute("added");
    %>
	<!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<!-- Card for Demo Purposes, feel free to copy for pages -->
	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
	<div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Add Venue <span class="message"> <%=(added != null ? added : "")%></h1>
		<div class="card-body">
                    <form action= "createVenueServlet" method="post" autocomplete="off">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Name:</label>
                            <input class="form-control"type="text" id="venueName" name="venueName" >
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Address</label>
                            <input class="form-control"type="text" id="venueAddress" name="venueAddress" >
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Latitude</label>
                            <input class="form-control"type="text" id="venueLat" name="venueLat" >
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Longitude</label>
                            <input class="form-control"type="text" id="venueLon" name="venueLon" >
                        </div>
                        <input type="submit" value="Add New Item">
                        </form>
                </div>
	</div>
	</div>
	</div>
	

</body>
</html>