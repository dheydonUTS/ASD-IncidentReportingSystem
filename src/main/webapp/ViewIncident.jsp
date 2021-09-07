<%-- 
    Document   : ViewIncident
    Created on : Sep 5, 2021, 6:53:07 PM
    Author     : dheydon
--%>

<%@page import="model.Incident"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
Incident incident = (Incident)session.getAttribute("incident");

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="components/navbar.jsp"/>
        <h1>Type: <%=incident.getType()%></h1><br>
        <h1>Date: <%=incident.getDate()%></h1><br>
        <h1>Time: <%=incident.getTime()%></h1><br>
        <h1>Description: <%=incident.getDescription()%></h1><br>
        <h1>Reporter: <%=incident.getReporter()%></h1><br>
        <h1>Offender: <%=incident.getOffender()%></h1><br>
    </body>
</html>
