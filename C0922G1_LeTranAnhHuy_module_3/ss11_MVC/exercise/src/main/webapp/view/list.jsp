<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/3/2023
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Product</title>
    <style>
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<center class="container">
    <h1>Product list</h1>
    <%--    thêm product--%>
    <div class="row mt-3">
        <center>
            <a class="btn btn-primary col-md-2" href="/product?action=create">Create new product</a>
        </center>
    </div>
    <form action="/product" method="get" class="mt-3">
        <form>
            <div class="mb-3 col-md-3">
                <span>Tìm kiếm sản phẩm</span>
                <input type="search" class="form-control" aria-describedby="emailHelp" name="inputName">
            </div>
            <%-- ? action = search--%>
            <input type="submit" class="btn btn-primary" name="action" value="search">
        </form>
    </form>

    <p class="bg-danger col-md-3">${productFind}</p>

    <%--    hiển thị danh sách list product--%>
    <table border="1px" class="table table-hover fw-bold">
        <thead class="table-dark align-middle">
        <tr>
            <th style="text-align: center">nameProduct</th>
            <th style="text-align: center">cost</th>
            <th style="text-align: center">describe</th>
            <th style="text-align: center">nameProducer</th>
            <th style="text-align: center">edit</th>
            <th style="text-align: center">delete</th>
        </tr>
        </thead>

        <tbody class="align-middle">
        <c:forEach items="${productList}" var="product">
            <tr>
                <td><a href="/product?action=view&id=${product.id}" class="btn btn-primary" style="width: 100%">${product.name}</a></td>
                <td>${product.cost}</td>
                <td>${product.describe}</td>
                <td>${product.nameProducer}</td>
                <td><a href="/product?action=edit&id=${product.id}" class="btn btn-primary" style="width: 100%">edit</a></td>
                <td><a href="/product?action=delete&id=${product.id}" class="btn btn-primary" style="width: 100%">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
