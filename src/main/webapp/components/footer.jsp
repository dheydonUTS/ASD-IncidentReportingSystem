<%-- 
    Document   : footer
    Created on : 26/10/2021, 5:13:16 PM
    Author     : christianlopez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
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
    </head>
    <body>
        <jsp:include page="imports.jsp" />

        <footer>
            <p>Copyright &copy; 2021 | Incident Reporting System </p>
        </footer>
    </body>

</html>
