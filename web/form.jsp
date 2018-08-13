<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Some form</title>
</head>
<body>

<form action="/post-servlet" method="post">

    <input type="text" name="firstname" placeholder="your name" required>name
    <input type="text" name="lastname" placeholder="your lastname" required>lastname
    <input type="email" placeholder="put your email" name="email" required>email
    <input type="password" name="password" placeholder="your password" required>password
    <input type="submit" name="send">
</form>
</body>
</html>
