<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<form action="/save-file" method="post" enctype="multipart/form-data">
    Select File: <input type="file" name="file"/>
    <input type="submit" value="Upload File"/>
</form>
</body>
</html>
