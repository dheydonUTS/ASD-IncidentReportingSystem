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
    <style>
        body {
            background-image: url('images/background.png');
        }
        footer {
                position: fixed;
                bottom: 0;
                width: 100%;
                height: 2.5rem;   
                left: 0;
                width: 100%;
                background-color: white;
                color: black;
                text-align: center;
            }    
    </style>
<title>Incident Reporting System</title>
</head>
<body>
    <%
        String added = (String) session.getAttribute("added");
        String lonError = (String) session.getAttribute("lonError");
        String latError = (String) session.getAttribute("latError");
    %>
	<!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<!-- Card for Demo Purposes, feel free to copy for pages -->
	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
	<div class="card" style="margin-top:2rem;">
		<h1 class="card-header"> <span class="message"> <%=(added != null ? added : "Add Venue")%></h1>
		<div class="card-body">
                    <form action= "createVenueServlet" method="post" autocomplete="off">
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Name:</label>
                            <input class="form-control"type="text" id="venueName" name="venueName" required="true" placeholder="Enter Venue Name" >
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Address</label>
                            <input class="form-control"type="text" id="venueAddress" name="venueAddress" required="true" placeholder="Enter Venue Address" >
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Latitude</label>
                            <input class="form-control"type="text" id="venueLat" name="venueLat" required="true"  placeholder="<%=(latError != null ? latError : "Enter Latitude: (0-9).(0.9)")%>" >
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label" for="desc">Longitude</label>
                            <input class="form-control"type="text" id="venueLon" name="venueLon" required="true" placeholder="<%=(lonError != null ? latError : "Enter Longitude: (0-9).(0.9)")%>" >
                        </div>
                        <input type="submit" value="Add New Item">
                        </form>
                </div>
	</div>
	</div>
	</div>
	
<footer>
            <p>Copyright &copy; 2021 | Incident Reporting System </p>
        </footer>
</body>
</html>