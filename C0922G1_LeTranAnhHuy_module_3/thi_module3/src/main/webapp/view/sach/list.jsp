<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 15-Jun-22
  Time: 6:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.css">
</head>
<body>

<div>
    <center>
        <h1 class="font-text-footer">Danh sách sách</h1>
        <c:if test="${mess !=null}">
            <h2 class="text-danger">${mess}</h2>
        </c:if>
    </center>
    <br>
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Mã sách</th>
                <th>Tên sách</th>
                <th>Tác giả</th>
                <th>Số lượng</th>
                <th>Mô tả</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="book" items="${bookList}">
                <tr>
                    <td><c:out value="${book.id}"/></td>
                    <td><c:out value="${book.name}"/></td>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.quantity}"/></td>
                    <td><c:out value="${book.describe}"/></td>
                    <td>
                        <!-- Button trigger modal -->
                        <button>
                            Mượn
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
<script src="bootstrap520/jquery-3.6.0.min.js"></script>
<script src="bootstrap520/js/bootstrap.js"></script>
</html>
