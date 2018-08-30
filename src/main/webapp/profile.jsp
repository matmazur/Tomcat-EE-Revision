
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>profile page</title>
</head>
<body>
<c:choose>
<c:when test="${not empty param.firstname  && not  empty param.lastname}">
<c:remove var="user" scope="session"/>
<jsp:useBean id="user" class="model.User" scope="session">
    <jsp:setProperty name="user" property="firstname" value="${param.firstname}"/>
    <jsp:setProperty name="user" property="lastname" value="${param.lastname}"/>
</jsp:useBean>
<p>Name :
    <jsp:getProperty name="user" property="firstname"/>
</p>
<p>Last name :
    <jsp:getProperty name="user" property="lastname"/>
</p>
</c:when>
    <c:otherwise>
        <p>Maybe you should write something first before pushing Send button..?</p>
    </c:otherwise>
</c:choose>
</body>
</html>
