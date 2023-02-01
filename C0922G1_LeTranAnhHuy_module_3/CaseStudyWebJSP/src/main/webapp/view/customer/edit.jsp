<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 08-Jun-22
  Time: 1:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Edit Customer</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
              crossorigin="anonymous">
    </head>
    <body>

        <!--++++++++++++navbar top++++++++++++++++++-->
        <div class="mt-2 sticky-top" style="background: #046056">
            <nav class="navbar navbar-light">
                <div class="container-fluid">
                    <a class="navbar-brand text-light ps-5 click" href="/home">Home</a>
                    <a class="navbar-brand text-light click" href="/employee">Employee</a>
                    <a class="navbar-brand text-light click" href="/customer">Customer</a>
                    <a class="navbar-brand text-light click" href="/service">Service</a>
                    <a class="navbar-brand text-light click" href="/contract">Contract</a>
                    <form class="d-flex m-0">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-light" type="submit">Search</button>
                    </form>
                </div>
            </nav>
        </div>

        <%--+++++++++content++++++++--%>
        <div class="row">
            <div class="col-md-10 container">
                <center>
                    <h1 class="font-text-footer">Edit Customer</h1>
                    <c:if test="${mess !=null}">
                        <h2 class="text-danger">${mess}</h2>
                    </c:if>
                    <br>
                    <div class="container">
                        <form action="/customer?action=edit&id=${customer.id}" method="post">
                            <div class="input-group mb-3">
                                <span class="input-group-text">Name</span>
                                <input name="name" type="text" class="form-control me-2" value="${customer.name}">

                                <span class="input-group-text">Gender</span>
                                <c:if test="${customer.gender == 1}">
                                    <select name="gender" class="me-2">
                                        <option value="1">Nam</option>
                                        <option value="0">Nữ</option>
                                    </select>
                                </c:if>
                                <c:if test="${customer.gender == 0}">
                                    <select name="gender" class="me-2">
                                        <option value="0">Nữ</option>
                                        <option value="1">Nam</option>
                                    </select>
                                </c:if>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Birthday</span>
                                <input name="birthday" type="date" class="form-control me-2"
                                       value="${customer.birthday}">
                                <span class="input-group-text">Type</span>
                                <select name="type" class="me-2">
                                    <c:forEach items="${customerTypeList}" var="customerType">
                                        <c:if test="${customerType.typeId == customer.typeId}">
                                            <option value="${customerType.typeId}">${customerType.typeName}</option>
                                        </c:if>
                                    </c:forEach>

                                    <c:forEach items="${customerTypeList}" var="customerType">
                                        <c:if test="${customer.typeId != customerType.typeId}">
                                            <option value="${customerType.typeId}">${customerType.typeName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Id Card</span>
                                <input name="idCard" type="text" class="form-control me-2"
                                       value="${customer.idCard}">

                                <span class="input-group-text">Phone</span>
                                <input name="phone" type="text" class="form-control me-2"
                                       value="${customer.phone}">
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Email</span>
                                <input name="email" type="text" class="form-control me-2"
                                       value="${customer.email}">

                                <span class="input-group-text">Address</span>
                                <input name="address" type="text" class="form-control me-2"
                                       value="${customer.address}">
                            </div>
                            <br>
                            <button type="submit" class="btn btn-primary">Edit</button>
                        </form>
                    </div>
                </center>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>
    <script>
        $(document).ready(function () {
            $('#tableCustomer').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 6
            });
        });

        function showInfo(id, name) {
            document.getElementById("idCustomer").value = id;
            document.getElementById("nameCustomer").innerText = name;
        }
    </script>
</html>


