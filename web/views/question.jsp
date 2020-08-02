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

        <title>JSP Page</title>
        <jsp:include page="/style/bootstrap.html" />
    </head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <body class="container">
        <jsp:useBean id="dateValue" class="java.util.Date" />

        <jsp:include page="navbar.jsp" />

        <jsp:setProperty name="dateValue" property="time" value="${dateValue.time - (86400000 * 7)}" />
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
            </thead>
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


        <c:if test = "${!role.equals('employee')}" >
            <form action="Question" method="post">
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" id="description" name="description" required>
                </div>
                <div class="form-group">
                    <label for="product_id">Product</label>
                    <select class="form-control form-control-lg" name="product_id" id="product_id">
                        <c:forEach items="${products}" var="product">
                            <option value="${product.product_id}">${product.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </c:if>
    </body>
</html>
<jsp:include page="/style/mask.html" />