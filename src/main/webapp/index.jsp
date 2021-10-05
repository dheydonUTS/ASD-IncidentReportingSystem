<!DOCTYPE html>
<html>
<head>
<title>Incident Reporting System</title>
</head>
<body>
<!-- Include the following page for Navbar and Global Style Imports -->
<jsp:include page="components/navbar.jsp"/>
<!-- Creating venue on startup remove later -->



<div class="container-fluid p-5">
    <div class="container p-5">
        <h1 class="display-4">Incident Reporting System</h1>
        <hr>
        <p>Prototype R1</p>
    </div>
</div>
<jsp:include page="/ConnServlet" flush="true" />
</body>
</html>
