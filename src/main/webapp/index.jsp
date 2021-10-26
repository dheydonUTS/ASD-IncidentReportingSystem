<!DOCTYPE html>
<html>
<head>
    <style>
        body {
            background-image: url('images/background.png');
        }
    </style>
<title>Incident Reporting System</title>
</head>
<body>
<!-- Include the following page for Navbar and Global Style Imports -->
<jsp:include page="components/navbar.jsp"/>
<!-- Creating venue on startup remove later -->



<div class="container-fluid p-5">
    <div class="container p-5">
        <h1 class="display-4" >Incident Reporting System</h1>
        <hr>
        <br>
            <h4 style="padding: 0px 10px 0px 10px">Welcome to the Incident Reporting System. This system manages multiple venues in Sydney and is used to record incidents along with incident details and different venues. Through the NAVBAR at the top of the page, you are able to access the different features that this Incident Reporting System provides highlighted below.</h4><br><br>
            <div style="padding: 10px; border: 2px solid black; background-color: lightgray;"  class="P">
        <p>At the very top right, you will be able to either Log In or Register to the Incident Reporting System. If you are just a user, you will be able to register or you can log in if you have an account already and report certain incidents. If you are a staff user you will also be able to register or log in and report certain incidents. However, if you would not like to log in or register and want to report an incident, you will be able to do so, using the Anonymous Tip-Off tab to save time of creating an account. </p>
        <p>In the reports tab, under Graphs and Maps, you will find a graph that showcases the different types of incidents that occur at the multiple venues. You will also find map of all the venues and the number of incidents that have occurred at the venue. </p>
        <p>Under the reports tab, There are two links, containing the Incident Report Generation, as well as the Venue Report Generation. Under the Incident Report Generation, you will find a list of all the incidents that have occurred and the details for each incident. Similarly, under the Venue Report Generation you will find a list of venues and the details of incidents that have occurred specifically to that venue as well as venue details. With both of these report generation pages, you can also download a txt file of a specific venue or incident details to store or maybe to send to someone else. </p>
        <p>In the Offender Dashboard tab, a list of offenders will be presented on a page. Along with the offender name, their email, phone, gender as well as if they are banned or not will be presented clearly on the page. If you are logged in as a staff, you will also be able to edit the information about offenders.</p>
        <p>If a staff is logged In, they will be able to use the Manage Venues page. From here, they will see a list of the different venues that use the Incident Reporting System. If they need to add a new venue to the system, they can do so by pressing the Add New Venue at the bottom of the page. If they would like to edit details about a venue, they can do so by clicking the edit button next to a specific venue. </p>
        <p>The next page is the Issue Warning page. The Issue Warning page is used to issue a warning to certain offenders to inform them that they have done something wrong. This might just be to let a new offender know that they will be added to the offender list, or to let an existing offender know that they will be banned from a specific venue. </p>
        </div>
    </div>
</div>
<jsp:include page="/ConnServlet" flush="true" />
<jsp:include page="components/footer.jsp"/>
</body>
</html>
