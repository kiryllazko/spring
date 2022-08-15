<%@ page import="com.lirik.model.VehiclePart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lirik.model.Food" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/yegor256/tacit@gh-pages/tacit-css.min.css"/>
</head>
<body>
<table>
    <tr>
        <th>#</th>
        <th>Title</th>
    </tr>
<%

 List<Food> food = (List<Food>) request.getAttribute("food");
    for (Food f : food) {

%>
    <tr>
        <td><%=f.getId()%></td>
        <td><%=f.getTitle()%></td>
    </tr>
<%
    }
%>
</table>
</body>
</html>
