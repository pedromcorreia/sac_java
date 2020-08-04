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

        <form action="Document" method="post">
            <div class="form-group">
                <label for="name">Generate pdf for all users</label>
                <button type="submit" class="btn btn-primary" value="users" id="pdf" name="pdf">Users</button>
            </div>

            <div class="form-group">
                <label for="name">Generate pdf worst products</label>
                <button type="submit" class="btn btn-primary" value="questions" id="pdf" name="pdf">Top worst products</button>
            </div>

            <div class="form-group">
                <label for="type">Generate pdf for all questions</label>
                <select class="form-control form-control-lg" name="type" id="type">
                    <option value="true">Aberto</option>
                    <option value="false">Finalizado</option>
                    <option value="">Todos</option>
                </select>
                <button type="submit" class="btn btn-primary" value="sac" id="pdf" name="pdf">All Questions</button>
            </div>
            <div class="form-group">

                <label for="type">Generate pdf for all questions</label>
                
                <label for="type">Init date</label>
                
                <input type="text" id="datepicker" name="datepicker">
                
                <label for="type">Final date</label>
                
                <input type="text" id="datepickere" name="datepickere">

                <button type="submit" class="btn btn-primary" value="question_date" id="pdf" name="pdf">All Questions</button>
            </div>

        </form>
    </body>
</html>
<jsp:include page="/style/mask.html" />