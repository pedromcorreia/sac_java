<%-- 
    Document   : index
    Created on : Aug 1, 2020, 11:12:36 AM
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

        <jsp:include page="navbar.jsp"/>
        <c:if test = "${role.equals('employee')}" >
            <form action="ProductId" method="post">

                <input type="hidden" class="form-control" id="product_id" name="product_id" required value="${product.product_id}">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" id="name" name="name" required value="${product.name}">
                </div>
                <div class="form-group">
                    <label for="weight">Weight</label>
                    <input type="text" class="form-control" id="weight" name="weight" required value="${product.weight}">
                </div>
                <div class="form-group">
                    <label for="category_id">Category</label>
                    <select class="form-control form-control-lg" name="category_id" id="category_id">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.category_id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" id="description" name="description" required value="${product.description}">
                </div>
                <c:if test = "${role.equals('employee')}">
                    <button type="submit" value="delete" name="button" class="btn btn-danger">Delete</button>
                </c:if>

                <c:if test = "${role.equals('employee')}">
                    <button type="submit" value="update" name="button" class="btn btn-primary">Submit</button>
                </c:if>
            </form>
        </c:if>

    </body>
</html>
<jsp:include page="/style/mask.html" />