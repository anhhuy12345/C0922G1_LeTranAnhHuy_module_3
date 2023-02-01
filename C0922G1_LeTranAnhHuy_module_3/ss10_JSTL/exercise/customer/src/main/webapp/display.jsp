<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/30/2022
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title> Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<center>
    <h1 style="font-family: Algerian">Danh sách khách hàng</h1>
    <br>
    <table class="table" style="width: 50%; border: 1px;background-color: blanchedalmond">
        <thead>
        <tr style="font-family: 'UVN Saigon'">
            <th scope="col">Tên</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customerListData}" var="customer">
            <tr>
                <td>${customer.name}</td>
                <td>${customer.birthday}</td>
                <td>${customer.address}</td>
                <td><img src="${customer.picture}" alt="ảnh không đúng" height="100px" width="90px"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
