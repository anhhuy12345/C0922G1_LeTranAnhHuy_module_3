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
        <title>Contract List</title>
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
                <div class="col-md-10">
                    <center>
                        <h1 class="font-text-footer">Contract List</h1>
                        <c:if test="${mess !=null}">
                            <h2 class="text-danger">${mess}</h2>
                        </c:if>
                    </center>
                    <br>
                    <table id="tableContract" class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>deposit</th>
                                <th>Total Money</th>
                                <th>Employee Name</th>
                                <th>Customer Name</th>
                                <th>Service Name</th>
                                <th></th>
                                <th><a href="/contract?action=create">
                                    <button class="btn btn-secondary w-100">Create</button>
                                </a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="contract" items="${contractList}">
                                <tr>
                                    <td><c:out value="${contract.id}"/></td>
                                    <td><c:out value="${contract.startDate}"/></td>
                                    <td><c:out value="${contract.endDate}"/></td>
                                    <td><c:out value="${contract.deposit}"/></td>
                                    <td><c:out value="${contract.totalMoney}"/></td>

                                    <c:forEach items="${employeeList}" var="employee">
                                        <c:if test="${employee.id == contract.employeeId}">
                                            <td><c:out value="${employee.name}"/></td>
                                        </c:if>
                                    </c:forEach>

                                    <c:forEach items="${customerList}" var="customer">
                                        <c:if test="${customer.id == contract.customerId}">
                                            <td><c:out value="${customer.name}"/></td>
                                        </c:if>
                                    </c:forEach>

                                    <c:forEach items="${serviceList}" var="service">
                                        <c:if test="${service.id == contract.serviceId}">
                                            <td><c:out value="${service.name}"/></td>
                                        </c:if>
                                    </c:forEach>
                                    <td>
                                        <a href="/contract?action=edit&id=${contract.id}">
                                            <button class="btn btn-primary">Edit</button>
                                        </a>
                                    </td>
                                    <td>
                                        <!-- Button trigger modal -->
                                        <button type="button"
                                                onclick="showInfo('${contract.id}')"
                                                class="btn btn-danger"
                                                data-bs-toggle="modal"
                                                data-bs-target="#deleteModal">
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <%--            ---------thêm thẻ form---------%>
                <form action="/contract" method="get">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá !</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="text" hidden id="idContract" name="idDelete">
                            <span>Bạn có muốn xóa Contract </span>
                            <span class="text-danger" id="nameContract"></span><span> không?</span>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary" name="action" value="delete">Delele
                            </button>
                        </div>
                    </div>
                </form>
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
            $('#tableContract').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 6
            });
        });

        function showInfo(id) {
            document.getElementById("idCustomer").value = id;
        }
    </script>
</html>


