<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2023
  Time: 2:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
<center>
    <h1>Delete customer</h1>
    <form method="post" action="/customer?action=delete&id=${requestScope["customer"].getId()}">
        <h3 style="color: red">Are you sure?</h3>
        <fieldset>
            <legend>Customer information</legend>
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
                <tr>
                    <td><input type="submit" value="Delete customer"></td>
                    <td><a href="/customer">Back to customer list</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
</body>
</html>