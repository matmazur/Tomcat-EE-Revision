<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: matma
  Date: 27.08.2018
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="WEB-INF/fragments/header.jspf"/>


<c:set var="titles" value="${requestScope.list}" />
<c:forEach items="${titles}" var="title">
    <p><c:out value="${title}"/></p>
</c:forEach>


<c:if test="${ 1==1 }">
    <p><c:out value="EOOO"/></p>
</c:if>

<jsp:include page="WEB-INF/fragments/footer.jspf"/>
</body>
</html>
