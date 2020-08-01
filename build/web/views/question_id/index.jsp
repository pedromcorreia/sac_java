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

        <jsp:include page="../navbar.jsp"/>

        <form action="QuestionId" method="post">
             <input type="hidden" class="form-control" id="question_id" name="question_id" required value="${question.question_id}">
            <div class="form-group">
                <label for="description">Question</label>
                <input type="text" class="form-control" id="description" name="description" required value="${question.description}" disabled="">
            </div>
            <div class="form-group">
                <label for="solution">Solution</label>
                <input type="text" class="form-control" id="solution" name="solution" required value="${question.solution}" disabled="">
            </div>
            <div class="form-group">
                <label for="type">Type</label>
                <input type="text" class="form-control" id="type" name="type" required value="${question.type}" disabled="">
            </div>
            <c:if test = "${question.active}">
                <button type="submit" class="btn btn-primary">Delete</button>
            </c:if>
        </form>
    </body>
</html>
