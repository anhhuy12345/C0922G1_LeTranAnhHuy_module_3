<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/11/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.css">
</head>
<body>

<div>
    <center>
        <h1 class="font-text-footer" style="color: #cbbe73;">Product List</h1>


        <c:if test="${mess !=null}">
            <h2 class="text-danger">${mess}</h2>
        </c:if>

        <br>
        <br>

        <div class="container d-flex justify-content-center">
            <form action="" method="get">
                <div class="input-group mb-3">
                    <span class="input-group-text">Name</span>
                    <input class="ms-2" name="nameProductSearch" placeholder="enter product's name"
                           value="">
                    <button class="btn btn-success" type="submit" name="action" value="search">Search</button>
                </div>
            </form>
        </div>

    </center>
    <br>
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Category</th>
                <th colspan="2"><a href="/product?action=create">
                    <button class="btn btn-secondary w-100">Create</button>
                </a></th>
            </tr>
            </thead>
            <tbody>
           
            </tbody>
        </table>
    </div>
</div>


<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">

        <form action="/product" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá !</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"
                            aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="text" hidden id="idProduct" name="idDelete">
                    <span>Bạn có muốn xóa Product </span>
                    <span class="text-danger" id="idValueProduct"></span><span> không?</span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" name="action" value="delete">Delele</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="template/bootstrap/jquery-3.6.0.min.js"></script>
<script src="template/bootstrap/js/bootstrap.js"></script>

</html>
