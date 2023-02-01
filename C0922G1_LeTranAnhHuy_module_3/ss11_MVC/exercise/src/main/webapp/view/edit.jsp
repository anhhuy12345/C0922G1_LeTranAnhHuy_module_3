<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2023
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<center>
    <h1>Edit product</h1>
    <p>
        <a href="/product">Back to customer list</a>
    </p>
    <%--    gửi message nếu thêm product thành công--%>
    <p>
        <c:if test="${requestScope['message'] != null}">
            <span style="color: red; font-size: large">${requestScope['message']}</span>
        </c:if>
    </p>

    <form method="post" action="/product?action=edit&id=${requestScope["product"].getId()}" style="width: 30%">
        <%--    hiện thị thông tin khách hàng trước khi edit--%>
        <fieldset>
            <legend>product information</legend>
            <table>
                <tr>
                    <td>Name Product:</td>
                    <td><input type="text" name="name" id="name" value="${requestScope["product"].getName()}"></td>
                </tr>

                <tr>
                    <td>Cost:</td>
                    <td><input type="text" name="cost" id="cost" value="${requestScope["product"].getCost()}"></td>
                </tr>
                <tr>
                    <td>Describe:</td>
                    <td><input type="text" name="describe" id="describe" value="${requestScope["product"].getDescribe()}"></td>
                </tr>
                <tr>
                    <td>Name Producer:</td>
                    <td><input type="text" name="nameProducer" id="nameProducer" value="${requestScope["product"].getNameProducer()}"></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Update product"></td>
                </tr>
            </table>
        </fieldset>
    </form>
</center>
</body>
</html>
