<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/yegor256/tacit@gh-pages/tacit-css.min.css"/>
    <meta charset="UTF-8">
    <title>Form</title>
</head>
<body>
<form action="add" method="POST">
    Id: <input name="Id" title="Id"/>
    <br><br>
    Title: <input name="Title"/>
    <br><br>
<%--    Make: <input name="Make"/>--%>
<%--    <br><br>--%>
<%--    Model: <input name="Model"/>--%>
<%--    <br><br>--%>
<%--    Year: <input name="Year"/>--%>
<%--    <br><br>--%>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>