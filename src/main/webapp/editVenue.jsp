<%-- 
    Document   : editVenue
    Created on : 06/09/2021, 7:05:52 PM
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
	<!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<!-- Card for Demo Purposes, feel free to copy for pages -->
	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
	<div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Venue</h1>
		<div class="card-body">
			<h5 class="card-title">Bondi</h5>
                        <img src="https://upload.wikimedia.org/wikipedia/commons/a/a2/%281%29Westfield_Bondi_Junction-987.jpg" class="card-img-top offenderImg" alt="..." style="width: 500px; height: 500px; padding-bottom: 50px">
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
	</div>
	</div>
	</div>
	

</body>
</html>