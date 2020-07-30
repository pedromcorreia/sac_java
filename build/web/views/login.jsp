<%-- 
    Document   : login
    Created on : Jul 29, 2020, 10:00:33 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <jsp:include page="/style/bootstrap.html" />

        <title>JSP Page</title>
    </head>
    <body>
        <body class="container">
        <form action="../Login" method="post">
            <div class="form-group">
                <label for="login">Login</label>
                <input type="text" class="form-control" id="login" name="login" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary" value = "NewUser">Submit</button>
        </form>
    </body>
    </body>
</html>
