<%-- 
    Document   : Ticket
    Created on : 08/09/2021, 1:35:31 PM
    Author     : dom_h
--%>

<%@page import="model.dao.DBManager"%>
<%@page import="model.User"%>
<%@page import="model.Offender"%>
<%@page import="model.Venue"%>
<%@page import="model.Incident"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Incident incident = (Incident)session.getAttribute("incident");
Venue venue = incident.getVenue();
Offender offender = incident.getOffender();
User reporter = incident.getReporter();
DBManager manager = (DBManager)session.getAttribute("manager");
User assU = incident.getAssignedUser();
%>
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
        <title>View Ticket</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"/>
              <div class="row">
         <div class="col-md-2 col-sm-0"></div>
         <div class="col-md-8 col-sm-12">
            <div class="card" style="margin-top:2rem;">
               <h1 class="card-header">View Ticket</h1>
               <div class="card-body">
                  <h5 class="card-title">Details:</h5>
                  <div>
                      <table class="table">
                          <tr>
                    <td>Ticket ID:</td>
					<td><%=incident.getId()%></td>
				</tr>
                                <tr>
                    <td>Assigned User:</td>
					<td><%=assU.getFirstName()%> <%=assU.getLastName()%></td>
				</tr>
                            <tr>
                    <td>Status:</td>
					<td><%=incident.getStatus()%></td>
				</tr>
                                                            <tr>
                    <td>Ticket Opened:</td>
					<td><%=incident.getCreatedTime()%></td>
				</tr>
                <tr>
                    <td>Venue</td>
					<td><%=venue.getName()%></td>
				</tr>
				<tr>	
                    <td>Incident Type</td>
					<td><%=incident.getType()%></td>
				</tr>
				<tr>
                    <td>Incident Date</td>
					<td><%=incident.getIncidentDate()%></td>
				</tr>
				<tr>
                    <td>Incident Time</td>
					<td><%=incident.getIncidentTime()%></td>
					
				</tr>
				<tr>
                    <td>Description</td>
					<td><%=incident.getDescription()%></td>
					
				</tr>
				<tr>
                    <td>Reported By</td>
					<td><%=reporter.getFirstName()%> <%=reporter.getLastName()%></td>
				</tr>
				<tr>
                    <td>Offender Details</td>
                    <td><%=offender.getFirstName()%> <%=offender.getLastName()%></td>
                </tr>            
                </table>
                  </div>
                <form action="ViewIncident.jsp" method="post">
                        <input type="submit" value="View Incident" class="btn btn-primary">
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
