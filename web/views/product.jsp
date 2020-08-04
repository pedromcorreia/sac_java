<%-- 
    Document   : product
    Created on : Aug 1, 2020, 2:32:53 PM
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
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <h3>products</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Product_ids</th>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <th><a href='ProductId?product_id=${product.product_id}'>${product.product_id}</a></th>
                        <td>${product.name}</td>    
                        <td>${product.description}</td>    
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="Product" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" required minlength="5" maxlength="10">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" class="form-control" id="description" name="description" required minlength="5" maxlength="50">
            </div>
            <div class="form-group">
                <label for="weight">Weight</label>
                <input type="number" class="form-control" id="weight" name="weight" required minlength="5" maxlength="50">
            </div>
            <div class="form-group">
                <label for="category_id">Category</label>
                <select class="form-control form-control-lg" name="category_id" id="category_id">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.category_id}">${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
<jsp:include page="/style/mask.html" />