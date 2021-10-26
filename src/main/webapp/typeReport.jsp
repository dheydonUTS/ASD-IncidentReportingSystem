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
        <style>
        body {
            background-image: url('images/background.png');
        }
    </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Incident Type Report</title>
    </head>
    <body>
        <!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
            <h2>Total Types: <c:out value= "${typeTally.size()}"/></h2>
	<div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Types of Incidents</h1>
		<table class="table table-hover table-striped-rows table-bordered table-condensed">
                    <thead>
                        <tr>
                            <td><b>Type</b></td>
                            <td><b>Occurrences</b></td>
                            <td><b>Last Occurrence (Date?)</b></td>
                            <td><b>View</b><td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="type" items="${typeTally}">
                        <tr>
                            <td><c:out value="${type.key}" /></td>
                            <td><c:out value="${type.value}" /></td>
                            <td></td>
                            <td><a href="#">View</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table>
	</div>
	</div>
	</div>
        <jsp:include page="components/footer.jsp"/>

    </body>
</html>
