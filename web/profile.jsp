<%--
  Created by IntelliJ IDEA.
  User: matma
  Date: 25.08.2018
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>profile page</title>
</head>
<body>

<jsp:useBean id="user" class="model.User">
    <jsp:setProperty property="*" name="user"/>
</jsp:useBean>
<p>Name : <jsp:getProperty name="user" property="firstname"/></p>
<p>Last name : <jsp:getProperty name="user" property="lastname"/></p>


</body>
</html>
