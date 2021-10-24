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
        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <jsp:include page="error.jsp" />
            </c:when>
            <c:when test="${!user.isStaff}">
                <jsp:include page="error.jsp" />
            </c:when>
            <c:otherwise>
                <!-- Include the following page for Navbar and Global Style Imports -->
                <jsp:include page="components/navbar.jsp" />

                <div class="container">

                    <div class="row">
                        <div class="col-md-2 col-sm-0"></div>
                        <div class="col-md-8 col-sm-12">
                            <div class="card" style="margin-top:2rem;">
                                <h1 class="card-header">Issue Warning</h1>

                                <!-- Enforce validation -->
                                <form class="row g-3 needs-validation" method="POST" action="IssueWarning" id="warning_form" novalidate>
                                    <div class="card-body">

                                        <!-- Select if offender is new or existing, and display correct form -->
                                        <h5 class="card-title">Offender Type</h5>
                                        <div class="btn-group" role="group">
                                            <input type="radio" class="btn-check" name="offenderType" id="new" value="new" onclick="toggleView('new')" autocomplete="off" checked>
                                            <label class="btn btn-outline-primary" for="new">New</label>
                                            <input type="radio" class="btn-check" name="offenderType" id="existing" value="existing" onclick="toggleView('existing')" autocomplete="off">
                                            <label class="btn btn-outline-primary" for="existing">Existing</label></div>

                                        <!-- REGISTER A NEW OFFENDER -->
                                        <div id="newOffender">
                                            <div class="mb-3">
                                                <label for="validationCustom01" class="form-label">First Name</label>
                                                <input type="text" class="form-control" id="first_name" name="first_name" required>
                                                <div class="invalid-feedback">
                                                    Please enter first name.
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <label for="validationCustom02" class="form-label">Last Name</label>
                                                <input type="text" class="form-control" id="last_name" name="last_name" required>
                                                <div class="invalid-feedback">
                                                    Please enter last name.
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <label for="validationCustom02" class="form-label">Gender</label>
                                                <input type="text" class="form-control" id="gender" name="gender" required>
                                                <div class="invalid-feedback">
                                                    Please enter a gender.
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <label for="validationCustomUsername" class="form-label">Phone Number (if known)</label>
                                                <div class="input-group has-validation">
                                                    <span class="input-group-text" id="inputGroupPrepend">+61</span>
                                                    <input type="number" class="form-control" id="phone" name="phone">
                                                    <div class="invalid-feedback">
                                                        Please enter a phone number.
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="mb-3">
                                                <label for="validationCustom03" class="form-label">Email</label>
                                                <input type="email" class="form-control" id="email" name="email" required>
                                                <div class="invalid-feedback">
                                                    Please provide a valid email.
                                                </div>
                                            </div>
                                            <div class="mb-3 form-check">
                                                <input type="checkbox" class="form-check-input" id="is_banned" name="is_banned">
                                                <label class="form-check-label" for="is_banned">Banned?</label>
                                            </div>
                                        </div>

                                        <!-- USE AN EXISTING OFFENDER -->
                                        <div id="existingOffender" style="display: none;">
                                            <br>
                                            <select class="form-select" name="offender_id">
                                                <!-- For each offender -->
                                                <c:forEach var="Offender" items="${Offenders}">
                                                    <!-- If they have a contactable email, include them -->
                                                    <c:if test="${Offender.email != NULL && Offender.email != \"\"}">
                                                        <option value="${Offender.id}">${Offender.firstName} ${Offender.lastName}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <!-- Enter message for warning email, select venue -->
                                        <br>
                                        <h5 class="card-title">Warning Message</h5>
                                        <div class="mb-3">
                                            <textarea class="form-control" id="description" name="description" rows="3" required></textarea>
                                            <div class="invalid-feedback">
                                                Please enter a message.
                                            </div>
                                        </div>
                                        <h5 class="card-title">Venue</h5>
                                        <select class="form-select" name="venue_id">
                                            <c:forEach var="Venue" items="${Venues}">
                                                <option value="${Venue.id}">${Venue.name}</option>
                                            </c:forEach>
                                        </select>
                                        <br>
                                        <div class="col-12">
                                            <button class="btn btn-primary" type="submit">Send Warning</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!-- Give user feedback while email sends -->
                    <div class="modal" id="sending" tabindex="-1" role="dialog"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h2 class="modal-title" id="exampleModalLabel">Submitting Warning</h2>
                                </div>
                                <div class="modal-body">
                                    <div class="text-center">

                                        <div class="spinner-border spinner-border-lg text-info" style="width: 5rem; height: 5rem;"
                                             role="status">
                                        </div>

                                    </div>
                                    <br>
                                    <p>Please don't navigate away. We are sending an email to the offender.</p>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </c:otherwise>
        </c:choose>


        <script>
            //Function for default Bootstrap input validation
            (function () {
                'use strict'
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.querySelectorAll('.needs-validation')

                // Loop over them and prevent submission
                Array.prototype.slice.call(forms)
                        .forEach(function (form) {
                            form.addEventListener('submit', function (event) {
                                //If we don't pass validation and have a new offender selected, fail
                                if (!form.checkValidity() && document.querySelector('input[name="offenderType"]:checked').value != "existing") {
                                    event.preventDefault()
                                    event.stopPropagation()
                                }
                                //Else if we have an existing offender selected with no warning message, fail
                                else if (document.querySelector('input[name="offenderType"]:checked').value == "existing" && document.getElementById('description').value.length <= 0) {
                                    event.preventDefault()
                                    event.stopPropagation()
                                }
                                //Otherwise pass the test and submit form, give user feedback                        
                                else {
                                    sendWarning();
                                }
                                form.classList.add('was-validated')
                            }, false)
                        })
            })()

            //Display sending email feedback to user
            function sendWarning() {
                var myModal = new bootstrap.Modal(document.getElementById('sending'), {});
                myModal.show();
            }

            //Change between new and existing offender views
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
