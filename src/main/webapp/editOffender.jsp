<%-- 
    Document   : editVenue
    Created on : 06/09/2021, 7:05:52 PM
    Author     : christianlopez
--%>

<%@page import="model.Offender"%>
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
        Offender offender = (Offender) session.getAttribute("offender");
        String updated = (String) session.getAttribute("updated");
    %>
	<!-- Include the following page for Navbar and Global Style Imports -->
	<jsp:include page="components/navbar.jsp" />

	<!-- Card for Demo Purposes, feel free to copy for pages -->
	<div class="row">
	<div class="col-md-2 col-sm-0"></div>
	<div class="col-md-8 col-sm-12">
	<div class="card" style="margin-top:2rem;">
            <h1 class="card-header">Update Offender Information: <span class="message"> <%=(updated != null ? updated : "")%></span></h1>
            <div class="card-body" style="text-align: center">
                <h5 class="card-title">Edit Offender: ${offender.firstName}  ${offender.lastName} <br><br><br></h5>
                        <form method="post" action="updateOffenderServlet">
                            <table align="center" id="form_table">
                                <tr><td>Offender ID:  ${offender.id}</td><td> <input type="hidden" name="offenderID" value="${offender.id}"></td></tr>
                                <tr><td>Offender First Name</td><td> <input type="text" name="offenderFirstName" value="${offender.firstName}"></td></tr>
                                <tr><td>Offender Last Name</td><td> <input type="text" name="offenderLastName" value="${offender.lastName}"></td></tr>
                                <tr><td>Offender Email</td><td> <input type="text" name="offenderEmail" value="${offender.email}"></td></tr>
                                <tr><td>Offender Phone</td><td> <input type="text" name="offenderPhone" value="${offender.phone}"></td></tr>
                                <tr><td>Offender Gender</td><td> 
                                        <input type="radio" name="offenderGender" id="male" value="male">
                                        <label for="male">Male</label><br>
                                        <input type="radio" name="offenderGender" id="female" value="female">
                                        <label for="female">Female</label><br>
                                        <input type="radio" name="offenderGender" id="other" value="other">
                                        <label for="other">Other</label><br>
                                    </td></tr>
                                <tr><td>Offender Banned Status</td><td> <input type="checkbox" id="inputBanned" name="offenderBanned" value="Banned">
                                    <label for="inputBanned">Offender is Banned</label><br>
                                    </td></tr>
                                <tr><td></td>

                                    <td>
                                        <input class="button" type="submit" value="Update">
                                    </td>
                                </tr>
                            </table>
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