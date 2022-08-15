<%@ page import="com.lirik.model.VehiclePart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lirik.model.Product" %>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="org.springframework.stereotype.Controller" %>
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

        List<Product> products = (List<Product>) request.getAttribute("products");
        for (Product part : products) {

    %>
    <tr>
        <td><%=part.getId()%>
        </td>
        <td><%=part.getTitle()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
