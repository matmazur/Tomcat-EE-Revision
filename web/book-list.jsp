<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="WEB-INF/fragments/header.jspf"/>


<c:set var="titles" value="${requestScope.list}" />

<c:if test="${not empty titles or titles != null}">

<c:forEach items="${titles}" var="title">
    <p><c:out value="${title}"/></p>
</c:forEach>

</c:if>


<jsp:include page="WEB-INF/fragments/footer.jspf"/>
</body>
</html>
