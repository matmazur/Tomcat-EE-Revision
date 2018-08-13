<%--
  Created by IntelliJ IDEA.
  User: matma
  Date: 13.08.2018
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<h2>Login mr Admin</h2>
<form action="/admin-servlet" method="post">
    <input type="text" name="username">
    <input type="submit" value="Login">
</form>
</body>
</html>
