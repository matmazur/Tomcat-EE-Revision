<%@ page import="model.Book" %><%--
  Created by IntelliJ IDEA.
  User: matma
  Date: 22.08.2018
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
<h1>Library viewer</h1>
<form action="/book-servlet" method="post">
    <input placeHolder="ISBN" type="text" name="isbn">
    <br>
    Search: <input type="radio" name="option" value="search" checked>
    <br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
