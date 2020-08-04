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

        <title>Sac - Bem vindo</title>
    </head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <jsp:useBean id="dateValue" class="java.util.Date" />

    <jsp:include page="navbar.jsp" />

    <jsp:setProperty name="dateValue" property="time" value="${dateValue.time - (86400000 * 7)}" />
    <body class="container">
        <h3>Questions</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Question_id</th>
                    <th>Description</th>
                    <th>Active</th>        
                    <th>Solution</th>
                    <th>Created_at</th>
                </tr>
            <tbody>
                <c:forEach items="${questions}" var="question">
                    <c:if test = "${dateValue > question.created_at}" ><tr class="danger"></c:if>
                    <c:if test = "${dateValue <= question.created_at}" ><tr class="info"></c:if>
                        <th><a href='QuestionId?question_id=${question.question_id}'>${question.question_id}</a></th>
                        <td>${question.description}</td>    
                        <td>${question.active}</td>           
                        <td>${question.solution}</td>
                        <td>${question.created_at}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
<jsp:include page="/style/mask.html" />