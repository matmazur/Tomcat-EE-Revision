<%@ page import="beans.City" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: matma
  Date: 18.08.2018
  Time: 00:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table style="width:50%" border="1">
    <tr>
        <th>Nazwa</th>
    </tr>

    <%
        List<String> cityList = (List<String>) request.getAttribute("Cities");
        if (cityList != null) {
            for (String c : cityList) {

    %>
    <tr>
        <td><%=c%>
        </td>
    </tr>
    <%
            }
        }
    %>

</table>
</body>
</html>
