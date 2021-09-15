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
        <title>Register User</title>
    </head>
    <body>  
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
    <div class="container p-5" >
        <h1 class="display-4">Register User</h1>
        <hr>
                <div class="card" style="width:80rem; margin: auto; margin-top: 2rem;  ">
            <div class="card-body">
                <form action="TipoffServlet" method="post">
                    <div class="form-group">

                    <label for="email">Email Address:</label>
                    <input type="text" name="email"><br><br>
                    <label for="password">Password:</label>
                    <input type="password" name="password"><br><br>
                    <label for="repassword">Re-type Password:</label>
                    <input type="password" name="repassword"><br><br>
                    <label for="dob">Date of Birth:</label>
                    <input type="date" name="dob"><br><br>
                    <label for="gender">Gender:</label>
                    <select name="gender" id="gender">
                        <option value="null">-</option>
                        <option value="Female">Female</option>
                        <option value="Male">Male</option>
                        <option value="Other">Other</option>
                    </select>  <br><br>
                    <label for="phone">Phone Number:</label>
                    <input type="tel" name="phone"><br><br>
                         
                    </div><br>
                    <input type="submit" value="Register" class="btn btn-primary">
                    

                </form>
            
            
            </div>
        </div>
    </div>
</div>

    </body>
</html>
