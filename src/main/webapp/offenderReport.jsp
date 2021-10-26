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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Offender Report</title>
    </head>
    <body>
        <!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
            <h2>Total Offenders: <c:out value= "${offenders.size()}"/></h2>
	<div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Offenders</h1>
		<table class="table table-hover table-striped-rows table-bordered table-condensed">
                    <thead>
                        <tr>
                            <td><b>Offender ID</b></td>
                            <td><b>First Name</b></td>
                            <td><b>Surname</b></td>
                            <td><b>Gender</b></td>
                            <td><b>No. of Offences</b></td>
                            <td><b>Last Date of Offence</b></td>
                            <td><b>Banned?</b></td>
                            <td><b>More Info</b></td>
                        </tr>
                        
                    </thead>
                    <tbody>
                        <c:forEach var="offender" items="${offenders}">
                        <tr>
                            <td><c:out value="${offender.ID}" /></td>
                            <td><c:out value="${offender.firstName}" /></td>
                            <td><c:out value="${offender.surname}" /></td>
                            <td><c:out value="${offender.gender}" /></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><a href="#">View</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
                </table>
	</div>
	</div>
	</div>
<footer>
            <p>Copyright &copy; 2021 | Incident Reporting System </p>
        </footer>

    </body>
</html>
