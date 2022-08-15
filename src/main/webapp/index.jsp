<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Date</title>
</head>
<body>
<div class="container-fluid p-5 bg-primary text-white text-center">
    <h1>Today's date: <%=new Date()%>
    </h1>
</div>
<br/>
<div>
    <a href="store/products"><h1 class="display-6">Products</h1></a>
    <a href="store/parts"><h1 class="display-6">Car Parts</h1></a>
    <a href="store/food"><h1 class="display-6">Food</h1></a>
    <a href="store/sql"><h1 class="display-6">DBProducts</h1></a>
    <a href="store/add"><h1 class="display-6">AddProducts</h1>></a>
</div>
</body>
</html>