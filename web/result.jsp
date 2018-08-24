<%@ page import="model.Book" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result page</title>
</head>
<body>
<% Book book = (Book) request.getAttribute("book"); %>
<h1>Query result <%=request.getAttribute("option")%>
</h1>
<br>
<p><% if (book!=null){%>
    Title <%= book.getTitle() %>
    <br>
    ISBN <%= book.getIsbn() %>
    <br>
    Description <%= book.getDescription() %>
    <%}else{ %>
    <%=response.getWriter().print("Not here")%>
    <%}%>
</p>
</body>
</html>