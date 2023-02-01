<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/10/2023
  Time: 8:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
<div class="container-fluid row" style="background-color: #046056; margin: 0 auto;">
    <div class="col-md-3">
        <img src="image/logo.png" style="height: 70px; width: 70px">
    </div>
    <div class="col-md-6">
        <a href="https://furamavietnam.com/vi/" style=" text-decoration: none;font-family: 'Algerian';
        font-size: 300%;font-weight: bold;color: #FEF6F0;margin-left: 200px">
            FURAMA RESORT</a>
    </div>
    <div class="col-md-3">
        <a style="font-family: 'Times New Roman';font-size: 100%;font-weight: bold;margin-left: 120px">Lê Trần Anh Huy
            C0922G1</a>
    </div>
</div>
<div class="mt-2 sticky row" style="background: #046056;margin-top: -0.5rem!important;">
    <nav class="navbar navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand text-light ps-5 click col-l-2" href="">Home</a>
            <a class="navbar-brand text-light click col-l-2" href="/employee">Employee</a>
            <a class="navbar-brand text-light click col-l-2" href="/customer">Customer</a>
            <a class="navbar-brand text-light click col-l-2" href="/service">Service</a>
            <a class="navbar-brand text-light click col-l-2" href="">Contract</a>
            <form class="d-flex m-0 col-l-2">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-light" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
