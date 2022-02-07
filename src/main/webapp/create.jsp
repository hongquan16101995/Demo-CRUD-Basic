<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/24/2022
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope['mess'] != null}">
    <h1>${requestScope['mess']}</h1>
</c:if>
<form action="${pageContext.request.contextPath}/home?action=createPost" method="post">
    <label for="name">Name :
        <input type="text" id="name" name="name">
    </label>
    <label for="price">Price :
        <input type="text" id="price" name="price">
    </label>
    <input type="submit" value="Create">
</form>
<a href="/home">Back to home</a>
</body>
</html>
