<%-- 
    Document   : genReports
    Created on : 05/09/2021, 7:32:27 PM
    Author     : adam
--%>

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
        <title>General Reports Page</title>
    </head>
    <body>
        <!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
	<div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Offender Reports</h1>
		<div class="card-body">
                    <a href="OffenderReport" class="btn btn-primary">Offender Report</a>
			<!-- <h5 class="card-title">Enter Offender Surname to search database</h5>
             <form action="offenderReport.jsp">
                <label for="surname">Surname: </Label>
                <input type="text" id="surname" name="surname">
                <input type="submit" value="Search" class="btn btn-primary">
            </form> -->
		</div>
	</div>
            <div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Incident Location Reports</h1>
		<div class="card-body">
			<a href="IncidentLocationReport" class="btn btn-primary">Incident Location Report</a>
		</div>
	</div>
            <div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Incident Type Reports</h1>
		<div class="card-body">
			<a href="IncidentTypeReport" class="btn btn-primary">Incident Type Report</a>
		</div>
	</div>
	</div>
	</div>
        <jsp:include page="components/footer.jsp"/>
    </body>
</html>
