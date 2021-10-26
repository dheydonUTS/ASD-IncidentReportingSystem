<%-- 
    Document   : Logout
    Created on : 03/10/2021, 3:56:27 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
        body {
            background-image: url('images/background.png');
        }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <% 
                session.invalidate(); 
                response.sendRedirect("index.jsp");    
        %>
            
        <h1></h1>
        <jsp:include page="components/footer.jsp"/>
    </body>
</html>
