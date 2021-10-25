<%@page import="model.User"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<jsp:include page="imports.jsp" />
        <% User user = (User) session.getAttribute("user");%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp">Incident RS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.jsp">Home</a></li>
                                                <%if(user != null){ %>
					<li class="nav-item"><a class="nav-link" href="incident.jsp">Report
							Incident</a></li>
                                                        <li class="nav-item"><a class="nav-link" href="MyIncidentsServlet">My 
							Incidents</a></li><%}%>
                                                <%if(user != null){%>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Reports </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="GraphsMaps">Graphs and Maps</a></li>
							<li><a class="dropdown-item" href="IncidentListServlet">Incident Report
									Generation</a></li>
							<li><a class="dropdown-item" href="VenueListServlet">Venue Report
									Generation</a></li>

						</ul></li><%}%>
					<li class="nav-item"><a class="nav-link" href="listOffenderServlet">Offender
							Dashboard</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Venues </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
							<li><a class="dropdown-item" href="listVenueServlet">Manage Venues</a></li>
							<li><a class="dropdown-item" href="#">View Venue Info</a></li>
						</ul></li>
					<li class="nav-item"><a class="nav-link" href="IssueWarning">Issue
							Warning</a></li>
					<li class="nav-item"><a class="nav-link" href="AnonReport.jsp">Anon Tip
							Off</a></li>

				</ul>
				<ul class="navbar-nav">
				<% if(user == null) {%>
                                    <a class="btn btn-outline-secondary" style="margin-right: 10px"
						href="Login.jsp">Login</a>
					<a class="btn btn-info" href="Register.jsp">Register</a>
                               <%} else {%>
                               <li class="nav-item"><a class="nav-link" href="Account.jsp">User: <%= user.getEmail() %></a></li>    
                               <a class="btn btn-outline-secondary" style="margin-right: 10px"
						href="Logout.jsp">Logout</a>
                               <%}%>
			</div>
		</div>
	</nav>
</body>
</html>
