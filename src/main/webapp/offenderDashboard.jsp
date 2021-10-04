<%@page import="model.Offender"%>
<%@page import="java.util.LinkedList"%>
<%@page import="model.dao.DBManager"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="./css/offenderDashboard.css">
    <head>
        <title>Incident Reporting System</title>
    </head>
    <body>
        <!-- Include the following page for Navbar and Global Style Imports -->
        <jsp:include page="components/navbar.jsp" />
        <%
            DBManager manager = (DBManager)session.getAttribute("manager");
            LinkedList<Offender> Offenders = manager.getOffenders();
            request.setAttribute("Offenders", Offenders);
        %>

        <!-- Card for Demo Purposes, feel free to copy for pages -->
        <div class="row">
            <div class="col-md-2 col-sm-0"></div>
            <div class="col-md-8 col-sm-12">
                <div class="card" style="margin-top:2rem;">
                    <h1 class="card-header">Offender Dashboard</h1>
                    <div class="card-body">
                        <c:forEach items="${Offenders}" var="Offender">
                            <div class="row">
                                <div class="offender-card col-lg-4">
                                <div class="card col-lg-4" style="width: 18rem;">
                                    <img src="https://thumbs.dreamstime.com/z/funny-cartoon-mugshot-illustration-68310548.jpg" class="card-img-top" alt="...">
                                    <div class="card-body">
                                        <h5 class="card-title">${Offender.firstName} ,${Offender.lastName} </h5>
                                        <p class="card-text">Venue: Bondi</p>
                                        <p class="card-text">Status: Banned </p>
                                        <a href="./offender.jsp" class="btn btn-primary">View Offender</a>
                                    </div>
                                </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>