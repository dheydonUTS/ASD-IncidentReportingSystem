<%-- 
   Document   : incident
   Created on : 05/09/2021, 5:06:19 PM
   Author     : dom_h
   --%><%@page import="model.Incident"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@page import="java.util.LinkedList"%><%@page import="model.Venue"%><%@page import="model.dao.DBManager"%><%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
      <style>
        body {
            background-image: url('images/background.png');
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Edit an incident</title>
  </head>
  <%Incident incident = (Incident) session.getAttribute("incident"); %>
  <body>
    <jsp:include page="components/navbar.jsp" />
    <div class="container-fluid p-5">
      <div class="container p-5">
        <div class="row">
          <div class="col-md-2 col-sm-0"></div>
          <div class="col-md-8 col-sm-12">
            <div class="card" style="margin-top:2rem;">
              <h1 class="card-header">Edit an incident</h1>
              <div class="card-body">
                <h5 class="card-title">Edit a report</h5>
                <br>
                <form action="IncidentServlet" method="post" class="form-horizontal">
                  <div class="form-group">
                    <div class="form-group row">
                      <label class="col-sm-2 control-label text-right" for="venueName">Venue:</label>
                      <div class="col-sm-10">
                        <select class="form-control" name="venueName" value="<%=(request.getParameter("venueName") != null ? request.getParameter("venueName") : "")%>" id="type">
                            <%
                                     DBManager manager = (DBManager)session.getAttribute("manager");        // Get Manager from session
                                     LinkedList<Venue> Venues = manager.getVenues();                        // Get Venues from DB
                                     request.setAttribute("Venues", Venues);                                
                                     boolean descErr;
                                     boolean offenderErr;
                                     // Get errors
                                     try{
                                     descErr = Boolean.parseBoolean((String)session.getAttribute("descErr"));
                                     offenderErr = Boolean.parseBoolean((String)session.getAttribute("offenderErr"));
                                     }                                                                      // Catch exception and set errors to false (errors dont exist)
                                     catch(Exception e){ 
                                     descErr = false;
                                     session.setAttribute("descErr","false");
                                     offenderErr = false;
                                     session.setAttribute("offenderErr","false");
                                     }
                                %> <c:forEach items="${Venues}" var="Venue">
                            <option value="${Venue.name}">${Venue.name}</option>
                          </c:forEach>
                        </select>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-sm-2 control-label text-right" for="type">Incident Type:</label>
                      <div class="col-sm-10">
                        <select class="form-control" name="type" id="type">
                          <option value="Theft/Attempted theft">Theft/Attempted theft</option>
                          <option value="Altercation">Altercation</option>
                          <option value="Safety hazard">Safety hazard</option>
                          <option value="Medical Emergency">Medical emergency</option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-sm-2 control-label text-right" for="time" >Time:</label>
                      <div class="col-sm-10">
                        <input class="form-control" type="time" name="time"
                               value="<%=(request.getParameter("time") != null ? request.getParameter("time") : incident.getIncidentTime())%>" required>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label class="col-sm-2 control-label text-right" for="date">Date:</label>
                      <div class="col-sm-10">
                        <input class="form-control" type="date" name="date" 
                               value="<%=(request.getParameter("date") != null ? request.getParameter("date") : incident.getIncidentDate())%>" required>
                      </div>
                    </div>
                    <div class="form-group row ">
                      <label class="col-sm-2 control-label text-right" for="desc">Description:</label>
                      <div class="col-sm-10">
                        <textarea class="form-control <% if(descErr){ %>is-invalid<%}%>" 
                                  id="desc" placeholder="Please provide a description of events" 
                                  name="desc" rows="3" ><%=(request.getParameter("desc") != null ? request.getParameter("desc") :  incident.getDescription())%></textarea>
                        <% if(descErr){%>
                            <div class=" invalid-feedback">
                            Please enter a valid description.
                            </div><%}%>
                      </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label text-right" for="offender">Offender: </label>
                        <div class="col-auto">
                            <input class="form-control <% if(offenderErr){ %>is-invalid<%}%>" 
                                   placeholder="First Name" type="text" name="offenderFname" 
                                   value="<%=(request.getParameter("offenderFname") != null ? request.getParameter("offenderFname") :  incident.getOffender().getFirstName())%>" >
                            <% if(offenderErr){%>
                            <div class=" invalid-feedback">
                            Please enter a valid Name.
                            </div><%}%>
                        </div>
                        <div class="col-auto">
                            <input class="form-control <% if(offenderErr){ %>is-invalid<%}%>" 
                                   placeholder="Last Name"type="text" name="offenderLname" 
                                   value="<%=(request.getParameter("offenderLname") != null ? request.getParameter("offenderLname") : incident.getOffender().getLastName())%>">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="form-group row">
                            <label class="col-sm-2 control-label text-right" for=""></label>
                            <div class="col-sm-10">
                                <input type="submit" value="Submit" class="btn btn-primary">
                            </div>
                        </div>
                        <br>
                    </div>
                    </div>
                </form>
                <br>
                    
                </div>
            </div>
        </div>
        <hr>
        </div>
    </div>
    </div>
                        <jsp:include page="components/footer.jsp"/>
    </body>
</html>