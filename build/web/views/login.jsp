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

        <title>Sac - Bem vindo</title>
    </head>
    <body class="container">

        <jsp:include page="navbar.jsp" />
        <form action="Login" method="post">
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary" value = "NewUser">Submit</button>
        </form>
    </body>
</html>

<jsp:include page="/style/mask.html" />