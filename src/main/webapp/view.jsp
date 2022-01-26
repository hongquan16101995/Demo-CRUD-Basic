<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/24/2022
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    <style>
        table {
            width: 400px;
        }
    </style>
</head>
<body>
<h1>All Product</h1>
<c:if test="products.isEmpty()">
    <p style="color: red">Không có sản phẩn nào</p>
</c:if>

<c:url value="/home" var="url">
<c:param name="action" value="createGet"/>
</c:url>

<a href="${url}">Create new product</a>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td colspan="2">Action</td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td><a href="/home?action=delete&id=${product.getId()}">Delete</a></td>
            <td><a href="/home?action=editGet&id=${product.getId()}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
