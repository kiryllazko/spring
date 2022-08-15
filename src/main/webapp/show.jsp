<%@ page import="com.lirik.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
