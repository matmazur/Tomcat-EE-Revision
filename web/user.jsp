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
<jsp:include page="WEB-INF/fragments/header.jspf"/>

<form action="/book-servlet" method="post">
    <input placeHolder="ISBN" type="text" name="isbn">
    <br>
    Search: <input type="radio" name="option" value="search" checked>
    <br>
    Show all: <input type="radio" name="option" value="show-all">
    <br>
    <input type="submit" value="Submit"/>
</form>

<jsp:include page="WEB-INF/fragments/footer.jspf"/>
</body>
</html>
