<%-- 
    Document   : incident
    Created on : 05/09/2021, 5:06:19 PM
    Author     : dom_h
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/script.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Details</title>
    </head>
    <body>  
        <% User user = (User) session.getAttribute("user"); 
            String userChanged = (String) session.getAttribute("userChanged");
        %>
        <jsp:include page="components/navbar.jsp"/>
        <div class="container-fluid p-5">
            <div class="container p-5" >
                <h1 class="display-4">Account Details: <span class="message"> <%=(userChanged != null ? userChanged : "")%></span></h1>
                <hr>
                <div class="card" style="width:80rem; margin: auto; margin-top: 2rem;  ">
                    <div class="card-body">
                        <form action="editAccountServlet" method="post">
                            <div class="form-group">
                                <div class="card-body">
                                    <div class="mb-3">
                                        <label for="email">Email Address:</label>
                                        <input type="email" name="email" value="<%=user.getEmail()%>"><br><br>
                                    </div>
                                    
                                    <div class="mb-3">
                                        <label for="password">Password:</label>
                                        <input type="password" name="password" value="<%=user.getPassword()%>"><br><br>
                                    </div>
                                                         
                                    <input type="submit" value="Update" class="btn btn-primary">
                                </div>


                            </div><br>



                        </form>


                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
