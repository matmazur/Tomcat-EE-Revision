<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Main page</title>
</head>
<body>
<h1>Main index page</h1>

<jsp:include page="WEB-INF/fragments/header.jspf"/>
<br>
<h4>User agent : ${header['user-agent']}</h4>
<c:forEach var="cookieItem" items="${cookie }">
    <c:out value="${cookieItem.key }"/> : <c:out value="${cookieItem.value.value }"/>
    <br>
</c:forEach>

<c:forEach items="${header}" var="head">
    <c:out value="${head.key}"/> : <c:out value="${head.value}"/>
    <br>
</c:forEach>


<c:set var="foo" value=" helloo  "/>

<c:out value="${fn:toUpperCase(foo)}"/>


<p> Let's see if session scope works, here .. before we bring user let's look at nothing.. come on.. type it in..</p>
<p> name is : ${sessionScope.user.firstname}</p>
<p> surname is : ${sessionScope.user.lastname}</p>


<form action="profile.jsp">
    <input type="text" name="firstname" placeholder="firstname"/>
    <br>
    <input type="text" name="lastname" placeholder="lastname">
    <br>
    <input type="submit" value="Send">
</form>


<br>
<jsp:include page="WEB-INF/fragments/footer.jspf"/>
</body>
</html>