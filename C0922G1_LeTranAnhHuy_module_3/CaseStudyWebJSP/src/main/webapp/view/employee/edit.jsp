<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/10/2023
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
</head>
<body>
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
<div class="row container">

    <div class="col-md-10">
        <center>
            <h1 class="font-text-footer">Edit Employee</h1>
            <c:if test="${mess !=null}">
                <h2 class="text-danger">${mess}</h2>
            </c:if>
            <br>
            <div class="container">
                <form action="/employee?action=edit&id=${employee.id}" method="post">
                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input name="name" type="text" class="form-control me-2" value="${employee.name}">

                        <span class="input-group-text">Birthday</span>
                        <input name="birthday" type="date" class="form-control me-2" value="${employee.birthday}">

                        <span class="input-group-text">Id Card</span>
                        <input name="idCard" type="text" class="form-control me-2" value="${employee.idCard}">


                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Salary</span>
                        <input name="salary" type="text" class="form-control me-2" value="${employee.salary}">

                        <span class="input-group-text">Phone</span>
                        <input name="phone" type="text" class="form-control me-2" value="${employee.phone}">

                        <span class="input-group-text">Email</span>
                        <input name="email" type="text" class="form-control me-2" value="${employee.email}">
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Position</span>
                        <select name="positionId" class="me-2">
                            <c:forEach items="${positionList}" var="position">
                                <c:if test="${position.positionId == employee.positionId}">
                                    <option value="${position.positionId}">${position.name}</option>
                                </c:if>
                            </c:forEach>

                            <c:forEach items="${positionList}" var="position">
                                <c:if test="${position.positionId != employee.positionId}">
                                    <option value="${position.positionId}">${position.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>

                        <span class="input-group-text">Education Degree</span>
                        <select name="educationDegreeId" class="me-2">
                            <c:forEach items="${educationDegreeList}" var="educationDegree">
                                <c:if test="${educationDegree.educationDegreeId == employee.educationDegreeId}">
                                    <option value="${educationDegree.educationDegreeId}">${educationDegree.name}</option>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${educationDegreeList}" var="educationDegree">
                                <c:if test="${educationDegree.educationDegreeId != employee.educationDegreeId}">
                                    <option value="${educationDegree.educationDegreeId}">${educationDegree.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>

                        <span class="input-group-text">Division</span>
                        <select name="divisionId" class="me-2">
                            <c:forEach items="${divisionList}" var="division">
                                <c:if test="${division.divisionId == employee.divisionId}">
                                    <option value="${division.divisionId}">${division.name}</option>
                                </c:if>
                            </c:forEach>

                            <c:forEach items="${divisionList}" var="division">
                                <c:if test="${division.divisionId != employee.divisionId}">
                                    <option value="${division.divisionId}">${division.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="input-group mb-3">
                        <span class="input-group-text">Address</span>
                        <input name="address" type="text" class="form-control me-2" value="${employee.address}">
                        
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Edit</button>
                </form>
            </div>
        </center>
    </div>
</div>
<%@include file="/view/interface/footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</html>
