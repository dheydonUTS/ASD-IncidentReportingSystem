<%@page import="model.dao.DBManager"%>
<%@page import="model.User"%>
<%@page import="model.Incident"%>
<%@page import="model.Offender"%>
<%@page import="java.util.LinkedList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <title>Incident Reporting System</title>
        <meta charset="utf-8">
    </head>
    <body>
        <%
            LinkedList<Incident> incidents = (LinkedList<Incident>) session.getAttribute("incidents");
            LinkedList<User> userList = (LinkedList<User>) session.getAttribute("users");
                        String show = (String) session.getAttribute("show");
                        User user = (User) session.getAttribute("user");
                        User showUser = (User) session.getAttribute("showUser");
                        DBManager manager = (DBManager)session.getAttribute("manager");
                        
                        if (showUser == null){
                            showUser = user;
                        }
        %>
        
        <!-- Include the following page for Navbar and Global Style Imports -->
<jsp:include page="components/navbar.jsp" />
<div class="row">
    <div class="col-md-2 col-sm-0"></div>
        <div class="col-md-8 col-sm-12">
            <div class="card" style="margin-top:2rem;">
                <h1 class="card-header">My Incidents</h1>
                <form name="showUserForm" method="post" action="updateIncidentListServlet">
                <select name="showUser" onchange="javascript:document.showUserForm.submit();">
                <% if (userList != null){
                        for (User u: userList){%>                      
                            <option value=<%=u.getId()%> <%if (showUser.getId()== u.getId()) {%> selected="selected" <% } %>><%=u.getFirstName()+" "+u.getLastName()%></option>
                        <%}
                    }%>                  
                </select>
                </form>
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
                                <th>
                                    <b>View Ticket</b>
                                </th>
                            </tr>     
                                <%if (incidents != null) {
                                        for (Incident o: incidents){   
                                            if (o.getAssignedUser().getId() == showUser.getId() && !(o.getStatus().equals("Resolved") || o.getStatus().equals("Closed"))){%>
                                                <form name="form<%=o.getId()%>" method="post" action="updateIncidentServlet">
                                                <tr>    
                                                    <td><p><input type="hidden" name="incidentID" value=<%=o.getId()%>><%=o.getId()%></p></td>
                                                    <td><p><%=o.getVenue().getName()%></p></td>
                                                    <td><p><%=o.getType()%></p></td>
                                                    <td>
                                                        <select name="IncidentAssigned" onchange="javascript:document.form<%=o.getId()%>.submit();">
                                                        <% if (userList != null){
                                                            for (User u: userList){%>                      
                                                                <option value=<%=u.getId()%> <%if (showUser.getId()== u.getId()) {%> selected="selected" <% } %>><%=u.getFirstName()%></option>
                                                            <%}
                                                        }%>                  
                                                    </select>
                                                    </td>
                                                    <td>
                                                        <select name="IncidentStatus" onchange="javascript:document.form<%=o.getId()%>.submit();">
                                                                <option value="New" <%if (o.getStatus().equals("New")){%>selected="selected"<%}%>>New</option>
                                                                <option value="Open" <%if (o.getStatus().equals("Open")){%>selected="selected"<%}%>>Open</option>
                                                                <option value="Open" <%if (o.getStatus().equals("open")){%>selected="selected"<%}%>>Open</option>
                                                                <option value="In Progress" <%if (o.getStatus().equals("In Progress")){%>selected="selected"<%}%>>In Progress</option>
                                                                <option value="Resolved" <%if (o.getStatus().equals("Resvoled")){%>selected="selected"<%}%>>Resolved</option>
                                                                <option value="Resolved" <%if (o.getStatus().equals("resvoled")){%>selected="selected"<%}%>>Resolved</option>
                                                                <option value="Created" <%if (o.getStatus().equals("created")){%>selected="selected"<%}%>>Created</option>
                                                                <option value="In Progress" <%if (o.getStatus().equals("In progress")){%>selected="selected"<%}%>>In Progress</option>
                                                                <option value="Created" <%if (o.getStatus().equals("Created")){%>selected="selected"<%}%>>Created</option>
                                                                <option value="In Progress" <%if (o.getStatus().equals("in progress")){%>selected="selected"<%}%>>In Progress</option>
                                                        </select>
                                                    </td>
                                                    <td>
                                                        <select name="IncidentPriority" onchange="javascript:document.form<%=o.getId()%>.submit();">
                                                            <option value="1" <%if (o.getPriority() == 1){%>selected="selected"<%}%>>1</option>
                                                            <option value="2" <%if (o.getPriority() == 2){%>selected="selected"<%}%>>2</option>
                                                            <option value="3" <%if (o.getPriority() == 3){%>selected="selected"<%}%>>3</option>
                                                            <option value="4" <%if (o.getPriority() == 4){%>selected="selected"<%}%>>4</option>
                                                            <option value="5" <%if (o.getPriority() == 5){%>selected="selected"<%}%>>5</option>
                                                        </td>
                                                    <td><p><%=o.getIncidentDate()%></p></td>
                                                    <td><p><%=o.getIncidentTime().toString()%></p></td>
                                                    <td><button type="button" class="btn btn-dark" onclick="window.location.href='IncidentDetailServlet?incidentId=<%=o.getId()%>'">Details</button></td>
                                                </tr>
                                            </form>

                                            <% }} %> 
                                        </table>
                        <%} 
                        else { 
                        %>
                            <span><%=(show != null ? show : "This is not working")%></span>
                        <%}%>
                </div>
            </div>
        </div>
    </div>
</body>

</div> <br><br><br>
<footer>
            <p>Copyright &copy; 2021 | Incident Reporting System </p>
        </footer>
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
