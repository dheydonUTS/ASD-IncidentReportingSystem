<%-- 
    Document   : offender
    Created on : 06/09/2021, 3:53:32 PM
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
    </style>
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
		<h1 class="card-header">Offender</h1>
		<div class="card-body">
			<h5 class="card-title">John Smith</h5>
                        <img src="https://thumbs.dreamstime.com/z/funny-cartoon-mugshot-illustration-68310548.jpg" class="card-img-top offenderImg" alt="..." style="width: 500px; height: 500px; padding-bottom: 50px">
                        <p class="card-text">Age: 28 </p>
                        <p class="card-text">Gender: Male </p>
			<p class="card-text">Incidents: Tried shoplifting in JB HI FI store as well as MYER store. Harassed Security when asked about stolen property</p>
                        <p class="card-text">Venue: Bondi </p>
                        <p class="card-text">Status: Banned</p>
			<a href="./offenderDashboard.jsp" class="btn btn-primary">Go Back</a>
		</div>
	</div>
	</div>
	</div>
	
<jsp:include page="components/footer.jsp"/>

</body>
</html>