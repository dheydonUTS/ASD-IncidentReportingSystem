<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                            <!--<div class="btn-group" role="group">
                                <input type="radio" class="btn-check" name="offenderType" id="new" value="new" autocomplete="off" checked>
                                <label class="btn btn-outline-primary" for="new">New</label>
                                <input type="radio" class="btn-check" name="offenderType" id="existing" value="existing" autocomplete="off">
                                <label class="btn btn-outline-primary" for="existing">Existing</label>
                            </div>-->
                            <div class="btn-group" role="group">
                                <button type="button" class="btn btn-outline-primary" onclick="toggleView('new')">New</button>
                                <button type="button" class="btn btn-outline-primary" onclick="toggleView('existing')">Existing</button>
                            </div>

                            <!-- REGISTER A NEW OFFENDER -->
                            <div id="newOffender">
                                <br>
                                <div class="mb-3">
                                    <label for="firstName" class="form-label">First Name</label>
                                    <input type="text" class="form-control" id="first_name">
                                </div>
                                <div class="mb-3">
                                    <label for="lastName" class="form-label">Last Name</label>
                                    <input type="text" class="form-control" id="last_name">
                                </div>
                                <div class="mb-3">
                                    <label for="email" class="form-label">Email (if known)</label>
                                    <input type="email" class="form-control" id="email">
                                </div>
                                <div class="mb-3">
                                    <label for="phone" class="form-label">Phone Number (if known)</label>
                                    <input type="text" class="form-control" id="phone">
                                </div>
                                <div class="mb-3 form-check">
                                    <input type="checkbox" class="form-check-input" id="is_banned">
                                    <label class="form-check-label" for="is_banned">Banned?</label>
                                </div>
                            </div>

                            <!-- USE AN EXISTING OFFENDER -->
                            <div id="existingOffender" style="display: none;">
                                <br>
                                <select class="form-select">
                                    <option selected>Choose an offender</option>
                                    <option value="1">Jeff Bezos</option>
                                    <option value="2">Jon Leg</option>
                                    <option value="3">Michael Test</option>
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
