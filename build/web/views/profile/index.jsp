<%-- 
    Document   : index
    Created on : Jul 31, 2020, 10:04:07 PM
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
    </head>
    <body>

        <h1>Hello World!</h1>
        
        <c:out value="${'aa to javaTpoint'}"/>  
        

<c:out value="${requestScope.user.id }" ></c:out>
    </body>
</html>
