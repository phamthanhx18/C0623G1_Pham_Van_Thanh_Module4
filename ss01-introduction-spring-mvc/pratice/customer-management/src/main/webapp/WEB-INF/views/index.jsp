<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pratice 2</title>
</head>
<body>

</style>
There are ${listCustomer.size()} customer(s) in list.
<table border="1px" cellpadding="3px" cellspacing="1px" width="50%" align="center">
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCustomer}" var="listCustomer" varStatus="loop">
        <tr>
            <td>${listCustomer.id}</td>
            <td>${listCustomer.name}</td>
            <td>${listCustomer.email}</td>
            <td>${listCustomer.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>