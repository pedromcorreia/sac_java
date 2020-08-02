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

    <jsp:useBean id="dateValue" class="java.util.Date" />

    <jsp:include page="navbar.jsp" />

    <jsp:setProperty name="dateValue" property="time" value="${dateValue.time - (86400000 * 7)}" />
    <body class="container">

        <form action="Document" method="post">
            <button type="submit" class="btn btn-primary" value="users" id="pdf" name="pdf">Users</button>
            <button type="submit" class="btn btn-primary" value="questions" id="pdf" name="pdf">Top worst products</button>
        </form>
    </body>
</html>
<jsp:include page="/style/mask.html" />