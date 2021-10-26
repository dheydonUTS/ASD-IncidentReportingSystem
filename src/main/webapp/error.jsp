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
        <jsp:include page="components/navbar.jsp" />

        <div class="container">
            <div class="row">
                <div class="col-md-2 col-sm-0"></div>
                <div class="col-md-8 col-sm-12">
                    <div class="alert alert-danger" style="margin-top:2rem;" role="alert">
                        <h4 class="alert-heading">Operation Unsuccessful</h4>
                        <hr>
                        <a href="index.jsp">Click here to go home.</a>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="components/footer.jsp"/>
    </body>
</html>