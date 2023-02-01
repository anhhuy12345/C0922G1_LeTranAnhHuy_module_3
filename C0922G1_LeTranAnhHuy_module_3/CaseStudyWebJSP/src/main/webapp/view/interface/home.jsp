<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/6/2023
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Furama Resort</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">

</head>
<body>
<!--#E1F5B2-->
<%@include file="/view/interface/header.jsp" %>
<div>
    <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="image/10953_16030216470040397599.jpg"
                     class="d-block w-100" alt="..." height="600px">
            </div>
            <div class="carousel-item">
                <img src="image/0e899b3e41830a0f7088b7b99c0d14cb.jpg" class="d-block w-100"
                     alt="..." height="600px">
            </div>
            <div class="carousel-item">
                <img src="image/Vietnam_Danang_Furama_Resort_Exterior_Beach.jpg" class="d-block w-100"
                     alt="..." height="600px">
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>
<div class="row" style="height: 103%; margin-top: 0%;">
    <div class="col-md-3 px-0">
        <ul class="list-group vh-100 overflow-scroll" style="border: 2px solid #7952b3">
            <li class="list-group-item" aria-current="true">
                <a href="https://www.traveloka.com/vi-vn/explore/destination/30-dia-diem-du-lich-da-nang/57930" style="text-decoration: none;font-family: 'Times New Roman'">
                    Các Địa Điểm Du Lịch Đà Nẵng</a>
            </li>
            <li class="list-group-item">
                <a href="https://furamavietnam.com/vi/culinary/" style="text-decoration: none; font-family: 'Times New Roman'">
                    Ẩm Thực
                </a>
            </li>
            <li class="list-group-item">
                <a href="https://furamavietnam.com/vi/spa-and-fitness/" style="text-decoration: none; font-family: 'Times New Roman'"> SPA</a>
            </li>
            <li class="list-group-item">
                <a href="https://furamavietnam.com/vi/recreation/" style="text-decoration: none; font-family: 'Times New Roman'"> Giải Trí</a>
            </li>

        </ul>
    </div>
</div>
<%@include file="/view/interface/footer.jsp" %>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
