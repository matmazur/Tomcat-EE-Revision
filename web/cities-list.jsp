<%@ page import="beans.City" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<head>
    <title>Cities list</title>
</head>
<body>
<table style="width:50%" border="1">
    <tr>
        <th>Nazwa</th>
        <th>Populacja</th>
    </tr>

        <%
		List<City> cityList = (List<City>)request.getAttribute("Cities");
		if(cityList != null)
			for(City city: cityList) {
	%>
    <tr>
        <td><%= city.getName() %></td>
        <td><%= city.getPopulation() %></td>
    </tr>
        <%
			}
	%>

</body>
</html>
