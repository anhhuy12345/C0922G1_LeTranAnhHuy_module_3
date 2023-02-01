<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2023
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
<center>
    <h1>Create new product</h1>
    <p>
        <a href="/product">Back to customer list</a>
    </p>
    <%--    gửi message nếu thêm product thành công--%>
    <p>
        <c:if test="${requestScope['message'] != null}">
            <span style="color: red; font-size: large">${requestScope['message']}</span>
        </c:if>
    </p>
    <form action="/product?action=create" method="post" style="width: 30%">
        <fieldset>
            <legend>Product information</legend>
            <table>
                <tr>
                    <td>Name Product:</td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
                <tr>
                    <td>Cost:</td>
                    <td><input type="text" name="cost" id="cost"></td>
                </tr>
                <tr>
                    <td>Describe:</td>
                    <td><input type="text" name="describe" id="describe"></td>
                </tr>
                <tr>
                    <td>Name Producer:</td>
                    <td><input type="text" name="nameProducer" id="nameProducer"></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Create product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
</body>
</html>