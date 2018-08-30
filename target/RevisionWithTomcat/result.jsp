<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="if" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Book" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result page</title>
</head>
<body>
<c:set var="book" value="${requestScope.book}"/>
<h1>Query result <c:out value="${requestScope.option}"/></h1>
<br>


<c:choose>

    <c:when test="${book!=null}">
        <p>Title <c:out value="${book.title}"/></p>
        <p>ISBN <c:out value="${book.isbn}"/></p>
        <p>description <c:out value="${book.description}"/></p>
        <br>
    </c:when>

    <c:otherwise>
        <p>Not here </p>
    </c:otherwise>

</c:choose>

</body>
</html>