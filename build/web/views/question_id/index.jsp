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
        <c:if test = "${!role.equals('employee')}" >
            <form action="QuestionId" method="post">

            </c:if>
            <c:if test = "${role.equals('employee')}" >
                <form action="QuestionEmployee" method="post">

                </c:if>
                <input type="hidden" class="form-control" id="question_id" name="question_id" required value="${question.question_id}">
                <div class="form-group">
                    <label for="description">Question</label>
                    <input type="text" class="form-control" id="description" name="description" required value="${question.description}"disabled="">
                </div>
                <c:if test = "${role.equals('client') || !question.active}" >
                    <div class="form-group">
                        <label for="solution">Solution</label>
                        <input type="text" class="form-control" id="solution" name="solution" required value="${question.solution}" disabled="">
                    </div>
                </c:if>

                <c:if test = "${role.equals('employee') && question.active}" >
                    <div class="form-group">
                        <label for="solution">Solution</label>
                        <input type="text" class="form-control" id="solution" name="solution" required value="${question.solution}">
                    </div>
                </c:if>
                
                <c:if test = "${role.equals('manager') && question.active}" >
                    <div class="form-group">
                        <label for="solution">Solution</label>
                        <input type="text" class="form-control" id="solution" name="solution" required value="${question.solution}">
                    </div>
                </c:if>

                <div class="form-group">
                    <label for="type">Type</label>
                    <input type="text" class="form-control" id="type" name="type" required value="${question.type}" disabled="">
                </div>

                <c:if test = "${question.active && !role.equals('employee')}">
                    <button type="submit" class="btn btn-danger">Delete</button>
                </c:if>

                <c:if test = "${question.active && !role.equals('client')}">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </c:if>
            </form>
    </body>
</html>
<jsp:include page="/style/mask.html" />