<%-- 
    Document   : category
    Created on : Aug 1, 2020, 2:32:53 PM
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="/style/bootstrap.html" />

        <title>JSP a</title>
    </head>
    <body class="container">
        <jsp:include page="navbar.jsp" />
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <h3>Categories</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Category_ids</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <th><a href='CategoryId?category_id=${category.category_id}'>${category.category_id}</a></th>
                    <td>${category.name}</td>    
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <form action="Category" method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" required minlength="5" maxlength="10">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</body>
</html>
