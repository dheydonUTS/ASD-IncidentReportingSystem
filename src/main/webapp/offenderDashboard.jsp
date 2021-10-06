<%@page import="model.Offender"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <!-- <link rel="stylesheet" href="./css/offenderDashboard.css"> -->
    <head>
        <title>Incident Reporting System</title>
    </head>
    <body>
        <%
            LinkedList<Offender> offenders = (LinkedList<Offender>) session.getAttribute("offenders");
                        String show = (String) session.getAttribute("show");
        %>
        
        <!-- Include the following page for Navbar and Global Style Imports -->
        <jsp:include page="components/navbar.jsp" />
<div class="row">
            <div class="col-md-2 col-sm-0"></div>
            <div class="col-md-8 col-sm-12">
                <div class="card" style="margin-top:2rem;">
                    <h1 class="card-header" style="text-align: center">Offender Dashboard</h1>
        <div class="card-body" style="text-align: center" border="1" >
        <table align="center" width="100%" height="100%" cellpadding="0" cellspacing="0" border="0">

            <tr>
                <th>
                    <b>Offender ID</b>
                </th>
                <th>
                    <b>First Name</b>
                </th>
                <th>
                    <b>Last Name</b>
                </th>
                <th>
                    <b>Email</b>
                </th>
                <th>
                    <b>Phone</b>
                    
                </th>
                <th>
                    <b>Gender</b>
                </th>
                <th>
                    <b>Banned</b>
                    
                </th>
            </tr>
            
            
            <%
                if (offenders != null) {
                    for (Offender o: offenders){    
            %>
            
            
            <tr>
                
                <td><p><%=o.getId()%></p></td>
                <td><p><%=o.getFirstName()%></p></td>
                <td><p><%=o.getLastName()%></p></td>
                <td><p><%=o.getEmail()%></p></td>
                <td><p><%=o.getPhone()%></p></td>
                <td><p><%=o.getGender()%></p></td>
                <td><p><%=o.isIsBanned()%></p></td>
                
                <%}%>   

            </table>
        <br> <% } else { %>
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
