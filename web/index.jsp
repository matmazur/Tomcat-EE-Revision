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