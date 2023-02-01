<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2023
  Time: 2:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Customers</h1>
    <p>
        <a href="/customer?action=create">Create new customer</a>
    </p>
    <table border="1">
        <tr>

            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td><a href="/customer?action=view&id=${customer.id}">${customer.getName()}</a></td>
                <td>${customer.email}</td>
                <td>${customer.getAddress()}</td>
                <td><a href="/customer?action=edit&id=${customer.id}">edit</a></td>
                <td><a href="/customer?action=delete&id=${customer.id}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
