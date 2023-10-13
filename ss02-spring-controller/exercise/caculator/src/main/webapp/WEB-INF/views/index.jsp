<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>

<h2>Caculator</h2>
<form method="post">
    <input type="number" name="number-a" required>
    <input type="number" name="number-b" required>
    <br>
    <br>
    <button type="submit" name="type" value="addition">Addition(+)</button>
    <button type="submit" name="type" value="subtraction">Subtraction(-)</button>
    <button type="submit" name="type" value="multiplication">Multiplication(X)</button>
    <button type="submit" name="type" value="division">Division(/)</button>
</form>
    <c:if test="${not empty result}">
        <p>Result Division: ${result}</p>
    </c:if>
    <c:if test="${not empty error}">
        <p>Xảy ra lỗi: ${error}</p>
    </c:if>
</body>
</html>