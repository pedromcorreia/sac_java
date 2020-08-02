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
        <jsp:include page="navbar.jsp" />

        <form action="NewUser" method="post">
            <div class="form-group">
                <label for="name">Nome</label>
                <input type="text" class="form-control" id="name" name="name" minlength="3" maxlength="40" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="email" name="email" minlength="5" maxlength="40" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" minlength="5" minlength="10" required>
            </div>
            <div class="form-group">
                <label for="cpf">Cpf</label>
                <input type="text" class="cpf form-control" id="cpf" name="cpf" minlength="11" maxlength="11" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>

<jsp:include page="/style/mask.html" />