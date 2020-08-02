<%-- 
    Document   : index
    Created on : Aug 1, 2020, 11:48:42 AM
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

    <jsp:include page="navbar.jsp"/>
    <body class="container">
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
                        <th><a href='QuestionId?question_id=${question.question_id}'>${question.question_id}</a></th>
                        <td>${question.description}</td>    
                        <td>${question.active}</td>           
                        <td>${question.solution}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
