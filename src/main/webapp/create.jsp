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
<form action="${pageContext.request.contextPath}/home?action=createPost" method="post">
    <label for="id">ID :
        <input type="text" id="id" name="id">
    </label>
    <label for="name">Name :
        <input type="text" id="name" name="name">
    </label>
    <label for="price">Price :
        <input type="text" id="price" name="price">
    </label>
    <input type="submit" value="Create">
</form>
</body>
</html>
