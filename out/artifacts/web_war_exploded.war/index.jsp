<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main page</title>
</head>
<body>
<h1>Main index page</h1>
<a href="admin.jsp">admin page</a>
<br>
<a href="user.jsp">user page</a>

<% if (response.getStatus()!=200) {
    response.sendRedirect("index.jsp");
    System.out.println("401");
}
%>
<br><br><br>

<form action="id.jsp">
    Name: <input type="text" name="firstname" placeholder="firstname"/>
    <br>
    Lastname: <input type="text" name="lastname" placeholder="lastname">
    <br>
    <input type="submit" value="Send">
</form>


</body>
</html>