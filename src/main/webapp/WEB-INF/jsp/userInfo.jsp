<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11.06.2017
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Information</title>
</head>
<body>
<h2>Hello, ${user.userInfo.name}</h2>
<c:if test="${not empty message}"><p>${message}</p></c:if>
<form:form method="POST" action="/userInfo">
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
                <input type="submit" value="Update"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
