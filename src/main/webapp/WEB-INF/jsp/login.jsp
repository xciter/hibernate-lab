<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<form:form method="POST" action="/register">
    <table>
        <tr>
            <td><form:label path="userInfo.name">User Name</form:label></td>
            <td><form:input path="userInfo.name"/></td>
        </tr>
        <tr>
            <td><form:label path="password">User Name</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="userInfo.email">E-mail</form:label></td>
            <td><form:input path="userInfo.email"/></td>
        </tr>
        <tr>
            <td><form:label path="userInfo.firstName">First Name</form:label></td>
            <td><form:input path="userInfo.firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="userInfo.secondName">Second Name</form:label></td>
            <td><form:input path="userInfo.secondName"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
