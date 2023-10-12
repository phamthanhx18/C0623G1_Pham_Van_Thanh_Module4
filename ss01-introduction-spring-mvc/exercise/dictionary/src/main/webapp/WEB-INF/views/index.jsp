<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercise 2</title>
</head>
<body>
<form action="/convert">
    <label for="eng"> Nhập từ tiếng anh cần tra cứu</label> <br>
    <input type="text" name="eng" id="eng"> <br><br>
    <input type="submit" value="Tra cứu">
    <c:if test="${not empty result}">
        <p>${result}</p>
    </c:if>
</form>
</body>
</html>