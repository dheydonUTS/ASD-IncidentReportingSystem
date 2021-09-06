<%-- 
    Document   : manageVenues
    Created on : 06/09/2021, 5:25:01 PM
    Author     : christianlopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="./css/offenderDashboard.css">
    <head>
        <title>Incident Reporting System</title>
    </head>
    <body>
        <!-- Include the following page for Navbar and Global Style Imports -->
        <jsp:include page="components/navbar.jsp" />

        <!-- Card for Demo Purposes, feel free to copy for pages -->
        <div class="row">
            <div class="col-md-2 col-sm-0"></div>
            <div class="col-md-8 col-sm-12">
                <div class="card" style="margin-top:2rem;">
                    <h1 class="card-header">Manage Venues</h1>
                    <div class="card-body">
                        
                        <div class="row venue-row">
                            <div class="offender-card col-lg-4">
                            <div class="card col-lg-4" style="width: 18rem;">
                                <img src="https://upload.wikimedia.org/wikipedia/commons/a/a2/%281%29Westfield_Bondi_Junction-987.jpg" class="card-img-top venue-img" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Bondi</h5>
                                    <a href="./editVenue.jsp" class="btn btn-primary">Edit Venue</a>
                                </div>
                            </div>
                                </div>
                            
                            <div class="offender-card col-lg-4">
                            <div class="card col-lg-4" style="width: 18rem;">
                                <img src="https://cdn.newsapi.com.au/image/v1/d4446c630d4ae5eaf17eb5eedf1363ae" class="card-img-top venue-img" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Warringah</h5>
                                    <a href="./editVenue.jsp" class="btn btn-primary">Edit Venue</a>
                                </div>
                            </div>
                                </div>
                            
                            <div class="offender-card col-lg-4">
                            <div class="card col-lg-4" style="width: 18rem;">
                                <img src="https://www.parramattadentist.sydney/wp-content/uploads/2017/10/Westfield-Parramatta-2.jpg" class="card-img-top venue-img" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">Parramatta</h5>
                                    <a href="./editVenue.jsp" class="btn btn-primary">Edit Venue</a>
                                </div>
                            </div>
                                </div>
                            <a href="./addVenue.jsp" class="btn btn-dark">Add New Venue</a>
                        </div>   
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>