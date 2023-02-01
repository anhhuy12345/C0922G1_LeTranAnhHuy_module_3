<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 07-Jun-22
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Customer List</title>
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
                    <form class="d-flex m-0" action="/customer" method="get">
                        <input class="me-2" name="nameSearch" placeholder="Nhập tên" value="${nameSearch}">
                        <input class="me-2" name="emailSearch" placeholder="Nhập email" value="${emailSearch}">
                        <select class="me-2" name="typeSearch">
                            <option value="">Chọn</option>
                            <c:forEach items="${customerTypeList}" var="customerType">
                                <option value="${customerType.typeId}">${customerType.typeName}</option>
                            </c:forEach>
                        </select>
                        <button class="btn btn-outline-light" type="submit" name="action" value="search">Search
                        </button>
                    </form>
                </div>
            </nav>
        </div>

        <%--+++++++++content++++++++--%>
        <div class="container-fluid">
            <div class="row">
                    <center>
                        <h1 class="font-text-footer">Customer List</h1>
                        <c:if test="${mess !=null}">
                            <h2 class="text-danger">${mess}</h2>
                        </c:if>
                    </center>
                    <br>
                    <table id="tableCustomer" class="table table-hover">
                        <thead>
                            <tr>
                                <th class="col">ID</th>
                                <th class="col">Type Name</th>
                                <th class="col">Name</th>
                                <th class="col">Birthday</th>
                                <th class="col">Gender</th>
                                <th class="col">Id Card</th>
                                <th class="col">Phone</th>
                                <th class="col">Email</th>
                                <th class="col">Address</th>
                                <th></th>
                                <th class="col"><a href="/customer?action=create">
                                    <button class="btn btn-secondary w-100">Create</button>
                                </a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="customer" items="${customerList}">
                                <tr>
                                    <td><c:out value="${customer.id}"/></td>
                                    <c:forEach items="${customerTypeList}" var="customerType">
                                        <c:if test="${customerType.typeId == customer.typeId}">
                                            <td><c:out value="${customerType.typeName}"/></td>
                                        </c:if>
                                    </c:forEach>
                                    <td><c:out value="${customer.name}"/></td>
                                    <td style="width: 90px;"><c:out value="${customer.birthday}"/></td>
                                    <c:if test="${customer.gender == 0}">
                                        <td>Nữ</td>
                                    </c:if>
                                    <c:if test="${customer.gender == 1}">
                                        <td>Nam</td>
                                    </c:if>
                                    <td><c:out value="${customer.idCard}"/></td>
                                    <td><c:out value="${customer.phone}"/></td>
                                    <td style="word-break: break-word;"><c:out value="${customer.email}"/></td>
                                    <td style="word-break: break-word;"><c:out value="${customer.address}"/></td>
                                    <td>
                                        <a href="/customer?action=edit&id=${customer.id}">
                                            <button class="btn btn-primary">Edit</button>
                                        </a>
                                    </td>
                                    <td>
                                        <!-- Button trigger modal -->
                                        <button type="button" onclick="showInfo('${customer.id}','${customer.name}')"
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
                <form action="/customer" method="get">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá !</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                    aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <input type="text" hidden id="idCustomer" name="idDelete">
                            <span>Bạn có muốn xóa Customer </span>
                            <span class="text-danger" id="nameCustomer"></span><span> không?</span>
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


    </body>
    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap5.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#tableCustomer').dataTable({
                dom: 'lrtip',
                lengthChange: false,
                pageLength: 10,
                bInfo: false,
                // "pagingType": 'full_numbers',
            });
        });
    </script>
<script>
        function showInfo(id, name) {
            document.getElementById("idCustomer").value = id;
            document.getElementById("nameCustomer").innerText = name;
        }
    </script>
</html>
