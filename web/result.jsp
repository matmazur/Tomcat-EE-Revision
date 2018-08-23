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
    <title>Result page</title>
</head>
<body>

<% Book book = (Book) request.getAttribute("book"); %>

<h1>Query result<%=request.getAttribute("option")%>
</h1>
<br>
<p><% if (book!=null){%>
    Title <%= book.getTitle() %>
    <br>
    ISBN <%= book.getIsbn() %>
    <br>
    Description <%= book.getDescription() %>
    <%}%>
</p>

</body>
</html>
