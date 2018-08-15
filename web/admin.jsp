<%--
  Created by IntelliJ IDEA.
  User: matma
  Date: 13.08.2018
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<h2>Hellor mr Admin</h2>

<h3>Your IP address is <%= request.getRemoteAddr()%></h3>
<a href="/logout-servlet">Logout</a>
</body>
</html>
