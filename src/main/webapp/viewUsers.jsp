<%@page import="model.dao.DBManager"%>
<%@page import="model.User"%>
<%@page import="model.Incident"%>
<%@page import="model.Offender"%>
<%@page import="java.util.LinkedList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Incident Reporting System</title>
        <meta charset="utf-8">
    </head>
    <body>
        <%
            
            LinkedList<User> userList = (LinkedList<User>) session.getAttribute("users");
            User user = (User) session.getAttribute("user");
            DBManager manager = (DBManager)session.getAttribute("manager");
        %>
        
        <!-- Include the following page for Navbar and Global Style Imports -->
<jsp:include page="components/navbar.jsp" />
<div class="row">
    <div class="col-md-2 col-sm-0"></div>
        <div class="col-md-8 col-sm-12">
            <div class="card" style="margin-top:2rem;">
                <h1 class="card-header">User Account Admin Page</h1>
                    <div class="card-body">
                        
                        <table align="center" width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">
                            <tr>
                                <th>
                                    <b>User ID</b>
                                </th>
                                <th>
                                    <b>Email</b>
                                </th>
                                <th>
                                    <b>First Name</b>
                                </th>
                                <th>
                                    <b>Last Name</b>
                                </th>
                                <th>
                                    <b>Is Staff?</b>   
                                </th>
                                <th>
                                    <b>View User</b>
                                </th>     
                            </tr>     
                                <%if (userList != null) {
                                        for (User o: userList){%>
                                                <tr>    
                                                    <td><p><%=o.getId()%></p></td>
                                                    <td><p><%=o.getEmail()%></p></td>
                                                    <td><p><%=o.getFirstName()%></p></td>
                                                    <td><p><%=o.getLastName()%></p></td>
                                                    <td><p><input type="checkbox" name="UserIsStaff" value="true" disabled<%if(o.isIsStaff()){%> checked><%}%></p></td>
                                                    <td><a type="button" class="btn btn-dark" href="EditUsersServlet?editID=<%=o.getId()%>">Details</a></td>
                                                </tr>
                                            <% } %> 
                                        </table>
                        <%} %>
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
