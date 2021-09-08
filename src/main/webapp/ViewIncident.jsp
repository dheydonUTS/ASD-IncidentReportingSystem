<%-- 
    Document   : ViewIncident
    Created on : Sep 5, 2021, 6:53:07 PM
    Author     : dheydon
--%>

<%@page import="model.Venue"%>
<%@page import="model.Incident"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Incident incident = (Incident)session.getAttribute("incident");
Venue venue = (Venue)session.getAttribute("venue"); // Get venue from incident in future
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Incident</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"/>
              <div class="row">
         <div class="col-md-2 col-sm-0"></div>
         <div class="col-md-8 col-sm-12">
            <div class="card" style="margin-top:2rem;">
               <h1 class="card-header">View Report</h1>
               <div class="card-body">
                  <h5 class="card-title">Details:</h5>
                  <div>
                      <table class="table">
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
					<td><%=incident.getDate()%></td>
				</tr>
				<tr>
                    <td>Incident Time</td>
					<td><%=incident.getTime()%></td>
					
				</tr>
				<tr>
                    <td>Description</td>
					<td><%=incident.getDescription()%></td>
					
				</tr>
				<tr>
                    <td>Reported By</td>
					<td><%=incident.getReporter()%></td>
				</tr>
				<tr>
                    <td>Offender Details</td>
                    <td><%=incident.getOffender()%></td>
                </tr>            
        </table>
                  </div>
               </div>
            </div>
         </div>
      </div>
    </body>
</html>
