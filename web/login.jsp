<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h1>Login to continue </h1>
<form action="/login-servlet" method="post">
    Username: <br>
    <input type="text" name="username" ><br>
    <input type="submit" value="Send">
</form>
</body>
</html>