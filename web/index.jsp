<%@ page import="beans.User" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <h1><a href="${pageContext.request.contextPath}/random">Random</a></h1>
    <h1><a href="${pageContext.request.contextPath}/hello-servlet">Hello</a></h1>
    <h1><a href="${pageContext.request.contextPath}login.html">Login</a></h1>
    <p>
            <%! User [] name; %>
            <% name = new  User[2]; %>
            <%name[0]=new User("Mike","Pompeo"); %>
            <%name[1]=new User("Donald","Pompeo"); %>

    <%for (int i=0;i<name.length;i++){%>
    <p><%= name[i] %>
    </p>
    <%}%>
</div>
</body>
</html>