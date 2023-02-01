<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/10/2023
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Employee Create</title>
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
<div class="row">
    <div class="col-md-10 container">
        <center>
            <h1 class="font-text-footer">Create Employee</h1>
            <c:if test="${mess !=null}">
                <h2 class="text-danger">${mess}</h2>
            </c:if>
            <br>
            <div class="container">
                <form action="/employee?action=create" method="post"
                      name="formCreate" onsubmit="return validateForm()">
                    <div class="input-group mb-3">
                        <span class="input-group-text">Name</span>
                        <input name="name" value="${name}" type=" text" class="form-control me-2"
                               placeholder="name employee">

                        <span class="input-group-text">Birthday</span>
                        <input name="birthday" value="${birthday}" type="date" class="form-control me-2"
                               placeholder="birthday">

                        <span class="input-group-text">Id Card</span>
                        <input name="idCard" value="${idCard}" type="text" class="form-control me-2"
                               placeholder="Id Card">
                    </div>

                    <%-- Thông báo không nhập input--%>
                    <div class="input-group mb-5">
                                <span class="me-2 text-danger " style="left: 5px; position: absolute; font-weight: bold"
                                      id="nameNotInput"></span>
                        <span class="me-2 text-danger" id="birthdayNotInput"
                              style="right: 445px; position: absolute; font-weight: bold"></span>
                        <span class="me-2 text-danger" id="idCardNotInput"
                              style="right: 5px; position: absolute; font-weight: bold"></span>
                        <c:if test="${errors!=null}">
                            <p class="me-2 text-danger"
                               style="right: 5px; position: absolute; font-weight: bold">${errors.get("idCard")}</p>
                        </c:if>
                    </div>


                    <div class="input-group mb-3">
                        <span class="input-group-text">Salary</span>
                        <input name="salary" value="${salary}" type=" text" class="form-control me-2"
                               placeholder="Salary">

                        <span class="input-group-text">Phone</span>
                        <input name="phone" value="${phone}" type="text" class="form-control me-2"
                               placeholder="phone number">

                        <span class="input-group-text">Email</span>
                        <input name="email" value="${email}" type="text" class="form-control me-2"
                               placeholder="email">
                    </div>

                    <%-- Thông báo không nhập input--%>
                    <div class="input-group mb-5">
                                <span class="me-2 text-danger " style="left: 5px; position: absolute; font-weight: bold"
                                      id="salaryNotInput"></span>
                        <span class="me-2 text-danger" id="phoneNotInput"
                              style="right: 445px; position: absolute; font-weight: bold"></span>

                        <c:if test="${errors!=null}">
                            <p class="me-2 text-danger"
                               style="left: 5px; position: absolute; font-weight: bold">${errors.get("salary")}</p>
                        </c:if>

                        <c:if test="${errors!=null}">
                            <p class="me-2 text-danger"
                               style="right: 445px; position: absolute; font-weight: bold">${errors.get("phone")}</p>
                        </c:if>

                        <c:if test="${errors!=null}">
                            <p class="me-2 text-danger"
                               style="right: 5px; position: absolute; font-weight: bold">${errors.get("email")}</p>
                        </c:if>

                        <span class="me-2 text-danger" id="emailNotInput"
                              style="right: 5px; position: absolute; font-weight: bold"></span>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Position</span>
                        <select name="positionId" class="me-2">
                            <c:if test="${positionId == null}">
                                <option value="">Chọn</option>
                                <c:forEach items="${positionList}" var="position">
                                    <option value="${position.positionId}">${position.name}</option>
                                </c:forEach>
                            </c:if>

                            <c:if test="${positionId != null}">
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
                            </c:if>
                        </select>

                        <span class="input-group-text">Education Degree</span>
                        <select name="educationDegreeId" class="me-2">
                            <c:if test="${educationDegreeId == null}">
                                <option value="">Chọn</option>
                                <c:forEach items="${educationDegreeList}" var="educationDegree">
                                    <option value="${educationDegree.educationDegreeId}">${educationDegree.name}</option>
                                </c:forEach>
                            </c:if>

                            <c:if test="${educationDegreeId != null}">
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
                            </c:if>
                        </select>


                        <span class="input-group-text">Division</span>
                        <select name="divisionId" class="me-2">
                            <c:if test="${divisionId == null}">
                                <option value="">Chọn</option>
                                <c:forEach items="${divisionList}" var="division">
                                    <option value="${division.divisionId}">${division.name}</option>
                                </c:forEach>
                            </c:if>

                            <c:if test="${divisionId != null}">
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
                            </c:if>
                        </select>
                    </div>

                    <%-- Thông báo không nhập input--%>
                    <div class="input-group mb-5">
                                <span class="me-2 text-danger" style="left: 5px; position: absolute; font-weight: bold"
                                      id="positionIdNotInput"></span>
                        <span class="me-2 text-danger" id="educationDegreeIdNotInput"
                              style="right: 445px; position: absolute; font-weight: bold"></span>
                        <span class="me-2 text-danger" id="divisionIdNotInput"
                              style="right: 5px; position: absolute; font-weight: bold"></span>
                    </div>

                    <div class="input-group mb-3">
                        <span class="input-group-text">Address</span>
                        <input name="address" value="${address}" type="text" class="form-control me-2"
                               placeholder="Address">

                        <span class="input-group-text">Username</span>
                        <input name="username" value="${username}" type="text" class="form-control me-2"
                               placeholder="Username">
                    </div>

                    <%-- Thông báo không nhập input--%>
                    <div class="input-group mb-5">
                                <span class="me-2 text-danger " style="left: 5px; position: absolute; font-weight: bold"
                                      id="addressNotInput"></span>
                        <span class="me-2 text-danger" id="usernameNotInput"
                              style="right: 5px; position: absolute; font-weight: bold"></span>
                    </div>

                    <br>
                    <button type="submit" class="btn btn-primary">Create</button>
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
