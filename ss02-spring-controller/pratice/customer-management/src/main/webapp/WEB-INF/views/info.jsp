<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/12/2023
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Customer ${customer.name}</h2>

<form action="/update/${customer.id}" method="post">
    <label for="id">ID:</label><br>
    <input type="text" id="id" name="id" value="${customer.id}"><br>
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name" value="${customer.name}"><br>
    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email" value="${customer.email}"><br>
    <label for="address">Address:</label><br>
    <input type="text" id="address" name="address" value="${customer.address}"><br>
    <br>
    <input type="submit" value="Cap nhat">
</form>
</body>
</html>
