<%-- 
    Document   : editVenue
    Created on : 06/09/2021, 7:05:52 PM
    Author     : christianlopez
--%>

<%@page import="model.User"%>
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
        User user = (User) session.getAttribute("editUser");
    %>
	<!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<!-- Card for Demo Purposes, feel free to copy for pages -->
	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
	<div class="card" style="margin-top:2rem;">
		<h1 class="card-header">Update Account</h1>
		<div class="card-body">
			<h5 class="card-title">Edit User: ${user.firstName} ${user.lastName}</h5>
                        <form method="get" action="EditUsersServlet?editID=${user.id}">
                            <table id="form_table">
                                <tr><td>User ID: </td><td>${user.id}<input type="hidden" name="userID" value="${user.id}"></td></tr>
                                <tr><td>First Name</td><td> <input type="text" name="userFirstName" value="${user.firstName}"></td></tr>
                                <tr><td>Last Name</td><td> <input type="text" name="userLastName" value="${user.lastName}"></td></tr>
                                <tr><td>Email</td><td> <input type="text" name="userEmail" value="${user.email}"></td></tr>
                                <tr><td>Password</td><td> <input type="password" name="userEmail" value="${user.password}"></td></tr>
                                <tr><td>Staff Access</td><td> <input type="checkbox" name="userIsStaff" <%if(user.isIsStaff()){%> checked><%}%></td></tr>
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