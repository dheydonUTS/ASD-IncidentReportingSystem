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
        footer {
                position: fixed;
                bottom: 0;
                width: 100%;
                height: 2.5rem;   
                left: 0;
                width: 100%;
                background-color: white;
                color: black;
                text-align: center;
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
<footer>
            <p>Copyright &copy; 2021 | Incident Reporting System </p>
        </footer>
    </body>
</html>
