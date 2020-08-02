<%-- 
    Document   : navbar
    Created on : Aug 1, 2020, 9:40:06 AM
    Author     : pedro
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-default navbar-static-top">

    <c:if test ="${role != (null)}" >
        <a class="navbar-brand" href="Question">Questions</a>

    </c:if>
    <c:if test = "${role.equals('manager')}" >
        <a class="navbar-brand" href="UserManager">Users</a>
        <a class="navbar-brand"> <span class="label label-success">Questions ${questions.size()}</span></a>
        <a class="navbar-brand"> <span class="label label-info">Opened ${questions_opened.size()}</span></a>
        <a class="navbar-brand"> <span class="label label-danger">Percentual ${Math.round(percentual)}%</span></a>

    </c:if>
    <c:if test ="${role.equals('employee')}" >
        <a class="navbar-brand" href="Product">Product</a>
        <a class="navbar-brand" href="Category">Category</a>
    </c:if>
    <c:if test ="${role == (null)}" >
        <ul class="nav navbar-nav navbar-right">
            <li><a class="navbar-brand" href="NewUser"></span>Sign Up</a></li>
            <li><a class="navbar-brand" href="Login">Login</a></li>
        </ul>
    </c:if>
    <c:if test ="${role != (null)}" >
        <ul class="nav navbar-nav navbar-right">
            <li><a class="navbar-brand" href="Profile">Profile</a></li>
            <li><a class="navbar-brand" href="Logout">Logout</a></li>
        </ul>
    </c:if>


</nav>