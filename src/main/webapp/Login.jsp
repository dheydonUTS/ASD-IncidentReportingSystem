<%-- 
    Document   : incident
    Created on : 05/09/2021, 5:06:19 PM
    Author     : dom_h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
    </head>
    <body>  
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
    <div class="container p-5" >
        <h1 class="display-4">User Login</h1>
        <hr>
                <div class="card" style="width:20rem; margin: auto; margin-top: 2rem;  ">
            <div class="card-body">
                <form action="LoginServlet" method="post">
                    <div class="form-group">

                    
                    <label for="email">Email Address:</label>
                    <input type="text" name="email" ><br><br>
                    <label for="password">Password:</label>
                    <input type="password" name="password"><br><br>
                    
                        
                    </div><br>
                    <input type="submit" value="Submit" class="btn btn-primary">
                    

                </form>
            
            
            </div>
        </div>
    </div>
</div>

    </body>
</html>