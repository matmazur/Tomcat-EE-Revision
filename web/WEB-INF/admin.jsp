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
    <title>Secret admin-admin adoration page</title>
</head>
<body>
<h1>OOOO Yu So Sexi So sTroooong Mister ADmiinn</h1>
<h1>Library viewer</h1>

<h1><%=response.getStatus()%>
</h1>
<form action="/book-servlet" method="post">
    <input placeHolder="ISBN" type="text" name="isbn">
    <br>
    <input placeHolder="Tytuł" type="text" name="title">
    <br>
    <input placeHolder="Opis" type="text" name="description">
    <br>
    Search: <input type="radio" name="option" value="search" checked> Add: <input type="radio" name="option"
                                                                                  value="add">
    Modify: <input type="radio" name="option" value="update"> Delete: <input type="radio" name="option" value="delete">
    <br>
    <input type="submit" value="Send"/>

</form>
</body>
</html>
