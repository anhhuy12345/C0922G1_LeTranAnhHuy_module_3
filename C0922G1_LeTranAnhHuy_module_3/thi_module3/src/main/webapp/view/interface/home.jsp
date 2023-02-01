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
<div class="row" style="height: 103%; margin-top: 0%;">
    <div class="col-md-3 px-0">
        <ul class="list-group vh-100 overflow-scroll" style="border: 2px solid #7952b3">
            <li class="list-group-item" aria-current="true">
                <a style="text-decoration: none;font-family: 'Times New Roman'">
                    Nội Dung 1</a>
            </li>
            <li class="list-group-item">
                <a style="text-decoration: none; font-family: 'Times New Roman'">
                    Nội Dung 2
                </a>
            </li>
            <li class="list-group-item">
                <a style="text-decoration: none; font-family: 'Times New Roman'"> Nội Dung 3</a>
            </li>
            <li class="list-group-item">
                <a style="text-decoration: none; font-family: 'Times New Roman'"> Nội Dung 4</a>
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
