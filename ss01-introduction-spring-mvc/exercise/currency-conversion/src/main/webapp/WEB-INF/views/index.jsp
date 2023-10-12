<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise 1</title>
</head>
<body>
<form action="/convert">
    <label for="usd"> USD</label>
    <input type="number" name="usd" id="usd"> <br><br>
    <input type="submit" value="Chuyển đổi">
    <c:if test="${not empty vnd}">
        <p>
            Kết quả sau khi chuyển đổi là : ${vnd} đ
        </p>
    </c:if>
</form>

</body>
</html>