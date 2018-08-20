<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main Page</title>
</head>
<body>
<h1>City browser</h1>
<form action="/controller-servlet" method="post">
    <input type="text" placeholder="city" name="city">
    <br>
    <input type="text" placeholder="country index" name="country">
    <br>
    <input type="text" placeholder="region" name="district">
    <br>
    <input type="number" placeholder="population" name="population">
    <br>
    Add<input type="radio" name="option" value="add"> Delete <input type="radio" name="option" value="delete">
    <br>
    <input type="submit" value="Send">
</form>
</body>
</html>