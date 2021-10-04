<%-- 
   Document   : incident
   Created on : 05/09/2021, 5:06:19 PM
   Author     : dom_h
   --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.LinkedList"%>
<%@page import="model.Venue"%>
<%@page import="model.dao.DBManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <title>Report an incident</title>
   </head>
   <body>
      <jsp:include page="components/navbar.jsp"/>
      <div class="container-fluid p-5">
         <div class="container p-5">
            <div class="row">
               <div class="col-md-2 col-sm-0"></div>
               <div class="col-md-8 col-sm-12">
                  <div class="card" style="margin-top:2rem;">
                     <h1 class="card-header">Report an incident</h1>
                     <div class="card-body">
                        <h5 class="card-title">Make a report</h5>
                        <form action="IncidentServlet" method="post">
                           <div class="form-group">
                               <div class="form-group row">
                              <label class="col-sm-2 col-form-label" for="venueName">Venue:</label>
                              <select class="form-control" name="venueName" id="type">
                                 <%
                                     DBManager manager = (DBManager)session.getAttribute("manager");
                                     LinkedList<Venue> Venues = manager.getVenues();
                                     request.setAttribute("Venues", Venues);
                                 %>
                                 <c:forEach items="${Venues}" var="Venue"> 
                                     <option value="${Venue.name}">${Venue.name}</option>
                                 </c:forEach>
                              </select>
                              </div>
                              <div class="form-group row">
                              <label class="col-sm-2 col-form-label" for="type">Incident Type:</label>
                              <select class="form-control" name="type" id="type">
                                 <option value="Theft/Attempted theft">Theft/Attempted theft</option>
                                 <option value="Altercation">Altercation</option>
                                 <option value="Safety hazard">Safety hazard</option>
                                 <option value="Medical Emergency">Medical emergency</option>
                              </select>
                              </div>
                              <div class="form-group row">
                              <label class="col-sm-2 col-form-label" for="time">Time:</label>
                               <input class="form-control"type="time" name="time" >
                              </div>
                              <div class="form-group row">
                              <label class="col-sm-2 col-form-label" for="date">Date:</label>
                               <input class="form-control"type="date" name="date" >
                              </div>
                              <div class="form-group row">
                              <label class="col-sm-2 col-form-label" for="desc">Description:</label>
                               <input class="form-control"type="text" name="desc" rows="3" >
                              </div>
                              <div class="form-group row">
                              <label class="col-sm-2 col-form-label" for="reporter">Your Email:</label>
                               <input class="form-control"type="text" name="reporter" >
                              </div>
                              <div class="form-group row">
                              <label class="col-sm-2 col-form-label" for="offender">Offender: </label>
                               <input class="form-control"type="text" name="offender" >
                              </div>
                              <input type="submit" value="Submit" class="btn btn-primary">
                           </div>
                           <br>
                        </form>
                        <br>			
                     </div>
                  </div>
               </div>
            </div>
            <hr>
            
         </div>
      </div>
   </body>
</html>
