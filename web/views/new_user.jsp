<%-- 
    Document   : user_new
    Created on : Jul 29, 2020, 7:32:37 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/style/bootstrap.html" />
    </head>
    <body class="container">
        <a href="views/login.jsp">Login</a>  
        <form action="../NewUser" method="post">
            <div class="form-group">
                <label for="name">Nome</label>
                <input type="text" class="form-control" id="name" name="name" minlength="3" required>
            </div>
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" class="form-control" id="login" name="login" minlength="5" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" minlength="5" required>
            </div>
            <button type="submit" class="btn btn-primary" value = "NewUser">Submit</button>
        </form>
    </body>
</html>
