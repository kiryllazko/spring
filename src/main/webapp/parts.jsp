products.jsp<%@ page import="com.lirik.model.VehiclePart" %>
<%@ page import="java.util.List" %>
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
        <th>Make</th>
        <th>Model</th>
        <th>Year</th>
    </tr>
<%

 List<VehiclePart> parts = (List<VehiclePart>) request.getAttribute("parts");
    for (VehiclePart part : parts) {

%>
    <tr>
        <td><%=part.getId()%></td>
        <td><%=part.getTitle()%></td>
        <td><%=part.getMake()%></td>
        <td><%=part.getModel()%></td>
        <td><%=part.getYear()%></td>
    </tr>
<%
    }
%>
</table>
</body>
</html>
