
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login page</title>
</head>
<body>
<h1>Sign in</h1>

<form action="j_security_check" method="post">
    Login: <label>
    <input type="text" name="j_username">
</label>
    <br>
    Password: <label>
    <input type="password" name="j_password">
</label>
    <input type="submit" value="Login">

</form>
</body>
</html>
