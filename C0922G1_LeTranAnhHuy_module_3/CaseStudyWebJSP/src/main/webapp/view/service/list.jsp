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
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
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
<div class="container-fluid">
    <div class="row">

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
                <th class="col">id</th>
                <th class="col">name</th>
                <th class="col">area</th>
                <th class="col">cost</th>
                <th class="col">max people</th>

                <th class="col">rent type name</th>
                <th class="col">rent type cost</th>

                <th class="col">service type name</th>

                <th class="col">standard room</th>
                <th class="col">description other convenience</th>
                <th class="col">pool area</th>
                <th class="col">number of floors</th>
                <th></th>
                <th class="col"><a href="/service?action=create">
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
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <%--            ---------thêm thẻ form---------%>
            <form action="/service" method="get">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title text-danger" id="exampleModalLabel">Xác nhận xoá !</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="text" hidden id="idService" name="idDelete">
                        <span>Bạn có muốn xóa Service </span>
                        <span class="text-danger" id="nameService"></span><span> không?</span>
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
</div>

</body>
<script src="bootstrap520/jquery-3.6.0.min.js"></script>
<script src="bootstrap520/js/bootstrap.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap4.min.js"></script>

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


