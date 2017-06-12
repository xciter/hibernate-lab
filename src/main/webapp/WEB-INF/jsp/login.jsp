<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12.06.2017
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<c:if test="${not empty message}"><p>${message}</p></c:if>
<form:form method="POST" action="/login">
    <table>
        <tr>
            <td><form:label path="userInfo.name">User Name</form:label></td>
            <td><form:input path="userInfo.name"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Login"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
