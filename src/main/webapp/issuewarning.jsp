<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Venue"%>
<%@page import="model.Offender"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Incident Reporting System</title>
    </head>
    <body>
        <!-- Include the following page for Navbar and Global Style Imports -->
        <jsp:include page="components/navbar.jsp" />
        <div class="row">
            <div class="col-md-2 col-sm-0"></div>
            <div class="col-md-8 col-sm-12">
                <div class="card" style="margin-top:2rem;">
                    <h1 class="card-header">Issue Warning</h1>
                    <form>
                        <div class="card-body">
                            <h5 class="card-title">Offender Type</h5>
                            <div class="btn-group" role="group">
                                <button type="button" class="btn btn-outline-primary" onclick="toggleView('new')">New</button>
                                <button type="button" class="btn btn-outline-primary" onclick="toggleView('existing')">Existing</button>
                            </div>

                            <!-- REGISTER A NEW OFFENDER -->
                            <div id="newOffender">
                                <br>
                                <div class="mb-3">
                                    <label for="firstName" class="form-label">First Name</label>
                                    <input type="text" class="form-control" id="first_name" name="first_name">
                                </div>
                                <div class="mb-3">
                                    <label for="lastName" class="form-label">Last Name</label>
                                    <input type="text" class="form-control" id="last_name" name="last_name">
                                </div>
                                                                <div class="mb-3">
                                    <label for="gender" class="form-label">Gender</label>
                                    <input type="text" class="form-control" id="gender" name="gender">
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email (if known)</label>
                                    <input type="email" class="form-control" id="email" name="email">
                                </div>
                                <div class="mb-3">
                                    <label for="phone" class="form-label">Phone Number (if known)</label>
                                    <input type="text" class="form-control" id="phone" name="phone">
                                </div>
                                <div class="mb-3 form-check">
                                    <input type="checkbox" class="form-check-input" id="is_banned" name="is_banned">
                                    <label class="form-check-label" for="is_banned">Banned?</label>
                                </div>
                            </div>

                            <!-- USE AN EXISTING OFFENDER -->
                            <div id="existingOffender" style="display: none;">
                                <br>
                                <select class="form-select">
                                <c:forEach var="Offender" items="${Offenders}">
                                    <option value="${Offender.id}">${Offender.firstName} ${Offender.surname}</option>
                                </c:forEach>
                                </select>
                            </div>

                            <br>
                            <h5 class="card-title">Warning Message</h5>
                            <div class="mb-3">
                                <textarea class="form-control" id="message" rows="3"></textarea>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            function toggleView(view) {
                var newOffender = document.getElementById("newOffender");
                var existingOffender = document.getElementById("existingOffender");
                if (view == "new") {
                    existingOffender.style.display = "none";
                    newOffender.style.display = "block";
                }
                if (view == "existing") {
                    existingOffender.style.display = "block";
                    newOffender.style.display = "none";
                }
            }
        </script>
    </body>
</html>
