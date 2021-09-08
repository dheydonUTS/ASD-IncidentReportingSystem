<%-- 
    Document   : genReports
    Created on : 05/09/2021, 7:32:27 PM
    Author     : adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incident Location Report</title>
    </head>
    <body>
        <!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
            <h2>Total Venues: <c:out value= "${venueList.size()}"/></h2>
	<div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Venues</h1>
		<table class="table table-hover table-striped-rows table-bordered table-condensed">
                    <thead>
                        <tr>
                            <td><b>Venue ID</b></td>
                            <td><b>Venue Name</b></td>
                            <td><b>Location</b></td>
                            <td><b>Address</b></td>
                            <td><b>Incidents</b></td>
                            <td><b>More Info</b></td>
                        </tr>
                        
                    </thead>
                    <tbody>
                        <c:forEach var="venue" items="${venueList}">
                        <tr>
                            <td><c:out value="${venue.ID}" /></td>
                            <td><c:out value="${venue.name}" /></td>
                            <td><c:out value="${venue.suburb}" /></td>
                            <td><c:out value="${venue.address}" /></td>
                            <td><c:out value="${venue.incidents.size()}" /></td>
                            <td><a href="#">View</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table>
	</div>
	</div>
	</div>
    </body>
</html>
