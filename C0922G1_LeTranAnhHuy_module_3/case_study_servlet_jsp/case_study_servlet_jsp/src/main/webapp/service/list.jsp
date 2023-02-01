<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 08-Jun-22
  Time: 11:42 PM
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
                <div class="col-md-10" style="overflow-x: hidden; overflow-y : hidden;">
                    <center>
                        <h1 class="font-text-footer">Service List</h1>
                        <c:if test="${mess !=null}">
                            <h2 class="text-danger">${mess}</h2>
                        </c:if>
                    </center>
                    <br>
                    <table id="tableService" class="table table-hover">
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>name</th>
                                <th>area</th>
                                <th>cost</th>
                                <th>max people</th>

                                <th>rent type name</th>
                                <th>rent type cost</th>

                                <th>service type name</th>

                                <th>standard room</th>
                                <th>description other convenience</th>
                                <th>pool area</th>
                                <th>number of floors</th>
                                <th></th>
                                <th><a href="/service?action=create">
                                    <button class="btn btn-secondary w-100">Create</button>
                                </a></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="service" items="${serviceList}">
                                <tr>
                                    <td><c:out value="${service.id}"/></td>
                                    <td><c:out value="${service.name}"/></td>
                                    <td><c:out value="${service.area}"/></td>
                                    <td><c:out value="${service.cost}"/></td>
                                    <td><c:out value="${service.maxPeople}"/></td>

                                    <c:forEach items="${rentTypeList}" var="rentType">
                                        <c:if test="${rentType.id == service.rentTypeId}">
                                            <td><c:out value="${rentType.name}"/></td>
                                            <td><c:out value="${rentType.cost}"/></td>
                                        </c:if>
                                    </c:forEach>

                                    <c:forEach items="${serviceTypeList}" var="serviceType">
                                        <c:if test="${serviceType.serviceTypeId == service.serviceTypeId}">
                                            <td><c:out value="${serviceType.serviceTypeName}"/></td>
                                        </c:if>
                                    </c:forEach>

                                    <td><c:out value="${service.standardRoom}"/></td>
                                    <td><c:out value="${service.descriptionOtherConvenience}"/></td>
                                    <td><c:out value="${service.poolArea}"/></td>
                                    <td><c:out value="${service.numberOfFloors}"/></td>

                                    <td>
                                        <a href="/service?action=edit&id=${service.id}">
                                            <button class="btn btn-primary">Edit</button>
                                        </a>
                                    </td>
                                    <td>
                                        <!-- Button trigger modal -->
                                        <button type="button" onclick="showInfo('${service.id}','${service.name}')"
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
            $('#tableService').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 6
            });
        });

        function showInfo(id, name) {
            document.getElementById("idService").value = id;
            document.getElementById("nameService").innerText = name;
        }
    </script>
</html>


