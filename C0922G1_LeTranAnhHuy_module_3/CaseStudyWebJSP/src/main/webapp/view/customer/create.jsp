<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 08-Jun-22
  Time: 2:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Create Customer</title>
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
                    <h1 class="font-text-footer">Create Customer</h1>
                    <c:if test="${mess !=null}">
                        <h2 class="text-danger">${mess}</h2>
                    </c:if>
                    <br>
                    <div class="container">
                        <form name="formCreate" action="/customer?action=create" method="post"
                              onsubmit="return validateForm()">
                            <div class="input-group mb-3">
                                <span class="input-group-text">Name</span>
                                <input name="name" type="text" class="form-control me-2" placeholder="name customer"
                                       value="${name}">

                                <span class="input-group-text">Gender</span>
                                <select name="gender" class="me-2">
                                    <c:if test="${gender == null}">
                                        <option value="">Chọn</option>
                                        <option value="1">Nam</option>
                                        <option value="0">Nữ</option>
                                    </c:if>

                                    <c:if test="${gender == 1}">
                                        <option value="1">Nam</option>
                                        <option value="0">Nữ</option>
                                    </c:if>

                                    <c:if test="${gender == 0}">
                                        <option value="0">Nữ</option>
                                        <option value="1">Nam</option>
                                    </c:if>
                                </select>
                            </div>
                            <%-- Thông báo không nhập input--%>
                            <div class="input-group mb-5">
                                <span class="me-2 text-danger " style="left: 5px; position: absolute; font-weight: bold"
                                      id="nameNotInput"></span>
                                <span class="me-2 text-danger" id="genderNotInput"
                                      style="right: 5px; position: absolute; font-weight: bold"></span>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Birthday</span>
                                <input name="birthday" value="${birthday}" type="date" class="form-control me-2"
                                       placeholder="birthday">
                                <span class="input-group-text">Type</span>

                                <select name="type" class="me-2">
                                    <c:if test="${type == null}">
                                        <option value="">Chọn</option>
                                        <c:forEach items="${customerTypeList}" var="customerType">
                                            <option value="${customerType.typeId}">${customerType.typeName}</option>
                                        </c:forEach>
                                    </c:if>

                                    <%-- sau khi tạo thất bại--%>
                                    <c:if test="${type != null}">
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
                                    </c:if>
                                </select>
                            </div>

                            <%--Thông báo không nhập input--%>
                            <div class="input-group mb-5">
                                <span class="me-2 text-danger" id="birthdayNotInput"
                                      style="left: 5px; position: absolute; font-weight: bold"></span>
                                <%--                                <c:if test="${errors!=null}">--%>
                                <%--                                    <p class="me-2 text-danger"--%>
                                <%--                                       style="left: 5px; position: absolute; font-weight: bold">${errors.get("birthday")}</p>--%>
                                <%--                                </c:if>--%>

                                <span class="me-2 text-danger" id="typeNotInput"
                                      style="right: 5px; position: absolute; font-weight: bold"></span>
                            </div>


                            <div class="input-group mb-3">
                                <span class="input-group-text">Id Card</span>
                                <input name="idCard" value="${idCard}" type="text" class="form-control me-2"
                                       placeholder="Id Card">

                                <span class="input-group-text">Phone</span>
                                <input name="phone" value="${phone}" type="text" class="form-control me-2"
                                       placeholder="phone number">
                            </div>

                            <%--Thông báo không nhập input--%>
                            <div class="input-group mb-5">
                                <span class="me-2 text-danger " id="idCardNotInput"
                                      style="left: 5px; position: absolute; font-weight: bold"></span>
                                <c:if test="${errors!=null}">
                                    <p class="me-2 text-danger"
                                       style="left: 5px; position: absolute; font-weight: bold">${errors.get("idCard")}</p>
                                </c:if>

                                <span class="me-2 text-danger" id="phoneNotInput"
                                      style="right: 5px; position: absolute; font-weight: bold"></span>
                                <c:if test="${errors!=null}">
                                    <p class="me-2 text-danger"
                                       style="right: 5px; position: absolute; font-weight: bold">${errors.get("phone")}</p>
                                </c:if>
                            </div>


                            <div class="input-group mb-3">
                                <span class="input-group-text">Email</span>
                                <input name="email" value="${email}" type="text" class="form-control me-2"
                                       placeholder="email">

                                <span class="input-group-text">Address</span>
                                <input name="address" value="${address}" type="text" class="form-control me-2"
                                       placeholder="address">
                            </div>

                            <%--Thông báo không nhập input--%>

                            <span class="me-2 text-danger" id="emailNotInput"
                                  style="left: 5px; position: absolute; font-weight: bold"></span>
                            <c:if test="${errors!=null}">
                            <div class="input-group mb-5"><p class="me-2 text-danger"
                                                             style="left: 5px; position: absolute; font-weight: bold">${errors.get("email")}</p>
                                </c:if>

                                <span class="me-2 text-danger" id="addressNotInput"
                                      style="right: 5px; position: absolute; font-weight: bold"></span>
                            </div>

                            <br>
                            <div class="input-group mb-5 d-flex align-content-center justify-content-center">
                                <button type="submit" class="btn btn-primary">Create</button>
                                <button type="button" class="btn btn-primary ms-3"><a style="text-decoration: none"
                                                                                      class="text-light"
                                                                                      href="/customer">Huỷ</a></button>
                            </div>
                        </form>
                    </div>
                </center>
            </div>
        </div>

        <%--+++++footer+++++++--%>

    </body>
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
