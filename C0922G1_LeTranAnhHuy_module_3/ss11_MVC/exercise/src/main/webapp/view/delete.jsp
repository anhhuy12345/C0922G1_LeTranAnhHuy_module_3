<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2023
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<center>
    <h1>Delete product</h1>
    <form method="post" action="/product?action=delete&id=${requestScope["product"].getId()}" style="width: 30%">
        <h3 style="color: red">Are you sure?</h3>
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Name Product:</td>
                    <td>${requestScope["product"].getName()}</td>
                </tr>
                <tr>
                    <td>Cost:</td>
                    <td>${requestScope["product"].getCost()}</td>
                </tr>
                <tr>
                    <td>Describe:</td>
                    <td>${requestScope["product"].getDescribe()}</td>
                </tr>
                <tr>
                    <td>Name Producer:</td>
                    <td>${requestScope["product"].getNameProducer()}</td>
                </tr>
                <tr>
                    <td><input type="submit" value="Delete product"></td>
                    <td><a href="/product">Back to customer list</a></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
</body>
</html>
