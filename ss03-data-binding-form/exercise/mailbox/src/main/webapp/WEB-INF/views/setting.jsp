<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="/save" method="post" modelAttribute="mailbox">
    <table>
        <tr>
            <td>Languages</td>
            <td colspan="3">
                <form:select path="language">
                    <form:option value="English" label="English"/>
                    <form:option value="Vietnamese" label="Vietnamese"/>
                    <form:option value="Japanese" label="Japanese"/>
                    <form:option value="Chinese" label="Chinese"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>Show</td>
            <td>
                <form:select path="pageSize">
                    <form:option value="25" label="25"/>
                    <form:option value="50" label="50"/>
                    <form:option value="100" label="100"/>
                </form:select>
            </td>
            <td>emails per page</td>
        </tr>
        <tr>
            <td>Spam Filter</td>
            <td colspan="3">
                <form:checkbox path="spamsFilter" value="true" label="Enable Spam Filter"/>
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td colspan="3">
                <form:textarea path="signature"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button style="border: 1px #eee solid;border-radius: 5px;background: #1ba1e2; color: #eeeeee;padding: 5px"
                        type="submit">Update
                </button>
            </td>
            <td>
                <a style="border: 1px #eee solid;border-radius: 5px;padding: 5px" role="button" href="/setting">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
