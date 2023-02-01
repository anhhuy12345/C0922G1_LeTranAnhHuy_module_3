<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/11/2023
  Time: 1:39 PM
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
+++++++++content++++++++
<div>
    <center>
        <h1 class="font-text-footer">Create Ground</h1>
        <c:if test="${mess !=null}">
            <h2 class="text-danger">${mess}</h2>
        </c:if>
        <br>
        <div class="container">
            <form action="/book?action=create" method="post">
                <div class="input-group mb-3">
                    <span class="input-group-text">Mã mượn sách</span>
                    <input name="id" type="text" class="form-control me-2" placeholder="${book.id}"
                           value="${id}">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Tên sách</span>
                    <input name="name" value="${name}" type="text" class="form-control me-2"
                           placeholder="${book.name}">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">Tên học sinh</span>
                    <select name="studentId" class="me-2">
                        <option value="">Chọn</option>
                        <c:forEach items="${studentList}" var="student">
                            <option value="${student.id}">${student.name}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="input-group mb-3">
                    <span class="input-group-text">Ngày mượn sách</span>
                    <input name="startDate" value="${startDate}" type="date" class="form-control me-2"
                           placeholder="Ngày bắt đầu">
                </div>

                <div class="input-group mb-3">
                    <span class="input-group-text">ngày kết thúc</span>
                    <input name="endDate" value="${endDate}" type="date" class="form-control me-2"
                           placeholder="Ngày bắt kết thúc">
                </div>

                <br>
                <div class="input-group mb-5 d-flex align-content-center justify-content-center">
                    <button type="submit" class="btn btn-primary">Create</button>
                    <button type="button" class="btn btn-primary ms-3"><a style="text-decoration: none"
                                                                          class="text-light"
                                                                          href="/book">Huỷ</a></button>
                </div>
            </form>
        </div>
    </center>
</div>
</body>
<script src="bootstrap520/jquery-3.6.0.min.js"></script>
<script src="bootstrap520/js/bootstrap.js"></script>
