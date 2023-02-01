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
        <title>Create Service</title>
        <link rel="stylesheet" href="bootstrap520/css/bootstrap.css">
        <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css">
        <link rel="stylesheet" href="style.css">
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
                <center>
                    <h1 class="font-text-footer">Create Service</h1>
                    <c:if test="${mess !=null}">
                        <h2 class="text-danger">${mess}</h2>
                    </c:if>
                    <br>
                    <div class="container">
                        <form action="/service?action=create" method="post">
                            <div class="input-group mb-3">
                                <span class="input-group-text">Name</span>
                                <input name="name" type="text" class="form-control me-2" placeholder="name service">

                                <span class="input-group-text">Area</span>
                                <input name="area" type="number" class="form-control me-2" placeholder="Area service">

                                <span class="input-group-text">Cost</span>
                                <input name="cost" type="number" class="form-control me-2" placeholder="Cost service">
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Max People</span>
                                <input name="maxPeople" type="number" class="form-control me-2"
                                       placeholder="Max People">

                                <span class="input-group-text">Name Rent Type</span>
                                <select name="rentType" class="me-2">
                                    <option value="">Chọn</option>
                                    <c:forEach items="${rentTypeList}" var="rentType">
                                        <option value="${rentType.id}">${rentType.name} giá: ${rentType.cost}</option>
                                    </c:forEach>
                                </select>

                                <span class="input-group-text">Service Type</span>
                                <select name="serviceType" class="me-2">
                                    <option value="">Chọn</option>
                                    <c:forEach items="${serviceTypeList}" var="serviceType">
                                        <option value="${serviceType.serviceTypeId}">${serviceType.serviceTypeName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Standard Room</span>
                                <select name="standardName" class="me-2">
                                    <option value="">Chọn</option>
                                    <option value="normal">normal</option>
                                    <option value="vip">vip</option>
                                </select>

                                <span class="input-group-text">Description Other Convenience</span>
                                <input name="description" type="text" class="form-control me-2"
                                       placeholder="Description Other Convenience">
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text">Pool Area</span>
                                <input name="poolArea" type="number" class="form-control me-2"
                                       placeholder="Pool Area">

                                <span class="input-group-text">Number Of Floors</span>
                                <input name="numberFloor" type="number" class="form-control me-2"
                                       placeholder="Number Of Floors">
                            </div>
                            <div class="input-group mb-3">
                                <c:if test="${errors!=null}">
                                    <p class="me-2 text-danger"
                                       style="left: 5px; position: absolute; font-weight: bold">${errors.get("numberFloor")}</p>
                                </c:if>
                            </div>
                            <br>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </form>
                    </div>
                </center>
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


