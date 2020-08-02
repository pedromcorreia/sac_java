<%-- 
    Document   : navbar
    Created on : Aug 1, 2020, 9:40:06 AM
    Author     : pedro
--%>
<nav class="navbar navbar-default navbar-static-top">

    <a class="navbar-brand" href="Question">Questions</a>
    <a class="navbar-brand" href="../Profile">Profile</a>
    <a class="navbar-brand" href="/sac/views/login.jsp">Login</a>
    <c:if test = "${role.equals('manager')}" >
        <a class="navbar-brand" href="../User">Users</a>
        <a class="navbar-brand"> <span class="label label-success">Questions ${questions.size()}</span></a>
        <a class="navbar-brand"> <span class="label label-info">Opened ${questions_opened.size()}</span></a>
        <a class="navbar-brand"> <span class="label label-danger">Percentual ${Math.round(percentual)}%</span></a>

    </c:if>
    <c:if test ="${role.equals('employee')}" >
        <a class="navbar-brand" href="../Product">Product</a>
        <a class="navbar-brand" href="../Category">Category</a>
    </c:if>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a class="navbar-brand" href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a class="navbar-brand" href="Logout">Logout</a></li>
    </ul>
</nav>