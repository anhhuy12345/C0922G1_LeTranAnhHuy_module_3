<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2023
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit customer</title>
    <style>
        .message {
            color: red;
        }
    </style>
</head>
<body>
<center>
    <h1>Edit customer</h1>
    <p>
        <a href="/customer">Back to customer list</a>
    </p>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <form method="post" action="/customer?action=edit&id=${requestScope["customer"].getId()}">
        <%--    có hiện thông tin khách hàng trước khi edit--%>
        <fieldset>
            <legend>Customer information</legend>
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" id="name" value="${requestScope["customerEdit"].getName()}"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" id="email" value="${requestScope["customerEdit"].getEmail()}">
                    </td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" id="address"
                               value="${requestScope["customerEdit"].getAddress()}">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update customer"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
</body>
</html>
