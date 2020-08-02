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
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <body class="container">
        <jsp:include page="navbar.jsp" />
        <h3>products</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>User_id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <th><a href='UserManagerId?user_id=${user.id}'>${user.id}</a></th>
                        <td>${user.name}</td>    
                        <td>${user.email}</td>
                        <td>${user.role}</td>    
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="UserManager" method="post">
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
                <input type="text" class="form-control" id="cpf" name="cpf" minlength="11" maxlength="11" required>
            </div>
            <div class="form-group">
                <label for="role">Role</label>
                <select class="form-control form-control-lg" name="role" id="role">
                    <option value="manager">Gerente</option>
                    <option value="employee">Funcionario</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
<jsp:include page="/style/mask.html" />