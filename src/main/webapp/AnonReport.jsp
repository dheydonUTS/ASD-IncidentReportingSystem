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
        <title>Anonymous Tip-Off</title>
    </head>
    <body>  
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
    <div class="container p-5" >
        <h1 class="display-4">Anonymous Tip-Off</h1>
        <hr>
                <div class="card" style="width:80rem; margin: auto; margin-top: 2rem;  ">
            <div class="card-body">
                <form action="TipoffServlet" method="post">
                    <div class="form-group">

                    <label for="type">Type:</label>
                    <select name="cars" id="cars">
                        <option value="Shoplifting">Shoplifting</option>
                        <option value="Argument">Argument</option>
                        <option value="Fight">Fight</option>
                        <option value="Spill">Spill</option>
                        <option value="Other">Other</option>
                    </select>  <br><br>
                    <label for="time">Time:</label>
                    <input type="time" name="time" ><br><br>
                    <label for="date">Date:</label>
                    <input type="date" name="date"><br><br>
                    <label for="desc">Description:</label>
                    <input type="text" name="desc"  size="80"><br><br>
                    <label for="offender">Offender Details:</label>
                    <input type="text" name="offender" size="80"><br><br>
                    
                        
                    </div><br>
                    <input type="submit" value="Submit" class="btn btn-primary">
                    

                </form>
            
            
            </div>
        </div>
    </div>
</div>

    </body>
</html>
