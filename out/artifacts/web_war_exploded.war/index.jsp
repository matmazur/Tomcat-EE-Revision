<%@ page import="beans.AdvancedUser" %>
<%@ page import="java.util.List" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <h1><a href="${pageContext.request.contextPath}/add-user">Add user</a></h1>
    <h1><a href="${pageContext.request.contextPath}/hello-servlet">Hello</a></h1>
    <h1><a href="${pageContext.request.contextPath}login.jsp">Login</a></h1>
    <h1><a href="${pageContext.request.contextPath}/admin.jsp">Admin login</a></h1>


    <div>

            <% List<AdvancedUser> list = (List<AdvancedUser>) session.getAttribute("users"); %>

            <%if (list!=null){%>
            <%for (AdvancedUser user:list){%>
            <%if (user!=null)%>
        <p><%=user%>
        </p>
            <%}%>
            <%}%>

        <div>
        </div>
</body>
</html>

