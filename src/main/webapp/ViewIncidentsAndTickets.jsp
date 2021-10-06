<%@page import="model.User"%>
<%@page import="model.Incident"%>
<%@page import="model.Offender"%>
<%@page import="java.util.LinkedList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Incident Reporting System</title>
    </head>
    <body>
        <%
            LinkedList<Incident> incidents = (LinkedList<Incident>) session.getAttribute("incidents");
                        String show = (String) session.getAttribute("show");
                        User user = (User) session.getAttribute("user");
        %>
        
        <!-- Include the following page for Navbar and Global Style Imports -->
        <jsp:include page="components/navbar.jsp" />
<div class="row">
            <div class="col-md-2 col-sm-0"></div>
            <div class="col-md-8 col-sm-12">
                <div class="card" style="margin-top:2rem;">
                    <h1 class="card-header">My Incidents</h1>
        <div class="card-body">
        <table align="center" width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">

            <tr>
                <th>
                    <b>Incident ID</b>
                </th>
                <th>
                    <b>Venue</b>
                </th>
                <th>
                    <b>Type</b>
                </th>
                <th>
                    <b>Assigned User</b>
                </th>
                <th>
                    <b>Status</b>
                    
                </th>
                <th>
                    <b>Priority</b>
                </th>
                <th>
                    <b>Incident Date</b>
                    
                </th>
                <th>
                    <b>Incident Time</b>
                    
                </th>
            </tr>
            
            
            <%
                if (incidents != null) {
                    for (Incident o: incidents){   
                        if (o.getAssignedUser().getId() == user.getId()){
            %>
            
            
            <tr>
                
                <td><p><%=o.getId()%></p></td>
                <td><p><%=o.getVenue().getName()%></p></td>
                <td><p><%=o.getType()%></p></td>
                <td><p><%=o.getAssignedUser().getFirstName()%></p></td>
                <td><p><%=o.getStatus()%></p></td>
                <td><p><%=o.getPriority()%></p></td>
                <td><p><%=o.getIncidentDate()%></p></td>
                <td><p><%=o.getIncidentTime().toString()%></p></td>
              </tr>  
                <%}%>   
            
            </table>
        <br> <% }} else { %>
                <span><%=(show != null ? show : "This is not working")%></span>
        <%}%>
                                </div>
                </div>
            </div>
        </div>

          </body>
</html>

<!--  Card for Demo Purposes, feel free to copy for pages 


        <div class="row">
            <div class="col-md-2 col-sm-0"></div>
            <div class="col-md-8 col-sm-12">
                <div class="card" style="margin-top:2rem;">
                    <h1 class="card-header">Offender Dashboard</h1>
                    <div class="card-body">

                        <div class="row">
                            <div class="offender-card col-lg-4">

                            <div class="card col-lg-4" style="width: 18rem;">
                               
                                <img src="https://thumbs.dreamstime.com/z/funny-cartoon-mugshot-illustration-68310548.jpg" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title"></h5>
                                    <p class="card-text">Venue: Bondi</p>
                                    <p class="card-text">Status: Banned </p>
                                    <a href="./offender.jsp" class="btn btn-primary">View Offender</a>
                                </div>
                            </div>
                                </div>

            </div>
        </div>


    </body>
</html>

--> 
