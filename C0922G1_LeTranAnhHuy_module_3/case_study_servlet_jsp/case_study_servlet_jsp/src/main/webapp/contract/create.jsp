<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 10-Jun-22
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Service List</title>
        <link rel="stylesheet" href="template/bootstrap/css/bootstrap.css">
        <link rel="stylesheet" href="template/datatable/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="template/style.css">
    </head>
    <body>
        <%--++++++++++header+++++++++--%>
        <div>
            <%@include file="/template/layout/header.jsp" %>
        </div>
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
        <div class="container-fluid">
            <div class="row">
                <%@include file="/template/layout/sidebar.jsp" %>
                <div class="col-md-10 container">
                    <center>
                        <h1 class="font-text-footer">Create Contract</h1>
                        <c:if test="${mess !=null}">
                            <h2 class="text-danger">${mess}</h2>
                        </c:if>
                        <br>
                        <div class="container">
                            <form action="/contract?action=create" method="post">
                                <div class="input-group mb-3">
                                    <span class="input-group-text">Start Date</span>
                                    <input name="startDate" type="date" class="form-control me-2"
                                           placeholder="Start Date">

                                    <span class="input-group-text">End date</span>
                                    <input name="endDate" type="date" class="form-control me-2" placeholder="End date">

                                    <span class="input-group-text">Deposit</span>
                                    <input name="deposit" type="number" class="form-control me-2" placeholder="deposit">
                                </div>

                                <div class="input-group mb-5">
                                    <c:if test="${errors!=null}">
                                        <p class="me-2 text-danger"
                                           style="right: 5px; position: absolute; font-weight: bold">${errors.get("deposit")}</p>
                                    </c:if>
                                </div>

                                <div class="input-group mb-3">
                                    <span class="input-group-text">Total Money</span>
                                    <input name="totalMoney" type="number" class="form-control me-2"
                                           placeholder="Total Money">

                                    <span class="input-group-text">Employee</span>
                                    <select name="employeeId" class="me-2">
                                        <option value="">Chọn</option>
                                        <c:forEach items="${employeeList}" var="employee">
                                            <option value="${employee.id}">${employee.name}</option>
                                        </c:forEach>
                                    </select>

                                    <span class="input-group-text">Customer</span>
                                    <select name="customerId" class="me-2">
                                        <option value="">Chọn</option>
                                        <c:forEach items="${customerList}" var="customer">
                                            <option value="${customer.id}">${customer.name}</option>
                                        </c:forEach>
                                    </select>

                                    <span class="input-group-text">Service</span>
                                    <select name="serviceId" class="me-2">
                                        <option value="">Chọn</option>
                                        <c:forEach items="${serviceList}" var="service">
                                            <option value="${service.id}">${service.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="input-group mb-3">
                                    <c:if test="${errors!=null}">
                                        <p class="me-2 text-danger"
                                           style="left: 5px; position: absolute; font-weight: bold">${errors.get("totalMoney")}</p>
                                    </c:if>
                                </div>
                                <br>
                                <button type="submit" class="btn btn-primary">Create</button>
                            </form>
                        </div>
                    </center>
                </div>
            </div>
        </div>
        <%--+++++footer+++++++--%>
        <div>
            <%@include file="/template/layout/footer.jsp" %>
        </div>
    </body>
    <script src="template/bootstrap/jquery-3.6.0.min.js"></script>
    <script src="template/bootstrap/js/bootstrap.js"></script>
    <script src="template/datatable/js/jquery.dataTables.min.js"></script>
    <script src="template/datatable/js/dataTables.bootstrap4.min.js"></script>
    <script src="template/main.js"></script>
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

