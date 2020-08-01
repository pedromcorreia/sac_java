<%-- 
    Document   : index
    Created on : Jul 29, 2020, 11:16:08 PM
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
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <body class="container">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="Profile">Profile</a>
        </nav>
        <h3>Questions</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Question_id</th>
                    <th>Description</th>
                    <th>Active</th>        
                    <th>Solution</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${questions}" var="question">
                    <tr>
                        <th><a href='showuser?id=${question.question_id}'>${question.question_id}</a></th>
                        <td>${question.description}</td>    
                        <td>${question.active}</td>           
                        <td>${question.solution}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <form action="Question" method="post">
            <div class="form-group">
                <label for="description">Description</label>
                <input type="text" class="form-control" id="description" name="description" required>
            </div>
            <div class="form-group">
                <label for="product_id">Product</label>
                <input type="text" class="form-control" id="product_id" name="product_id" required>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>


</html>
