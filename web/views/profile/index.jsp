<%-- 
    Document   : index
    Created on : Jul 31, 2020, 10:04:07 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/style/bootstrap.html" />

        <title>JSP Page</title>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>
    <body class="container">

        <jsp:include page="../navbar.jsp"/>

        <form action="Profile" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" required value="${user.name}">
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" required value="${user.phone}">
            </div>
            <div class="form-group">
                <label for="street">Street</label>
                <input type="text" class="form-control" id="street" name="street" required value="${user.street}">
            </div>
            <div class="form-group">
                <label for="number">Number</label>
                <input type="text" class="form-control" id="number" name="number" required value="${user.number}">
            </div>
            <div class="form-group">
                <label for="complement">Complement</label>
                <input type="text" class="form-control" id="complement" name="complement" value="${user.complement}">
            </div>
            <div class="form-group">
                <label for="neighborhood">Neighborhood</label>
                <input type="text" class="form-control" id="neighborhood" name="neighborhood" required value="${user.neighborhood}">
            </div>
            <div class="form-group">
                <label for="zipcode">Zipcode</label>
                <input type="text" class="form-control" id="zipcode" name="zipcode" required value="${user.zipcode}">
            </div>
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city" name="city" required value="${user.city}">
            </div>
            <div class="form-group">
                <label for="state">State</label>
                <input type="text" class="form-control" id="state" name="state" required value="${user.state}">
            </div>
            <button type="submit" class="btn btn-primary" value = "NewUser">Submit</button>
        </form>
    </body>
</html>
