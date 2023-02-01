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
    <title>view customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Customer details</h1>
    <p>
        <a href="/customer">Back to customer list</a>
    </p>
    <table>
        <tr>
            <td>Name:</td>
            <td>${requestScope["customer"].getName()}</td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>${requestScope["customer"].getEmail()}</td>
        </tr>
        <tr>
            <td>Address:</td>
            <td>${requestScope["customer"].getAddress()}</td>
        </tr>
    </table>
</center>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>
