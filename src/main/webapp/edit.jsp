<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/24/2022
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/home?action=editPost" method="post">
    <label for="id" hidden>ID :
        <input type="text" id="id" name="id" value="${product.getId()}" hidden>
    </label>
    <label for="name">Name :
        <input type="text" id="name" name="name" value="${product.getName()}">
    </label>
    <label for="price">Price :
        <input type="text" id="price" name="price" value="${product.getPrice()}">
    </label>
    <input type="submit" value="Edit">
</form>
</body>
</html>
