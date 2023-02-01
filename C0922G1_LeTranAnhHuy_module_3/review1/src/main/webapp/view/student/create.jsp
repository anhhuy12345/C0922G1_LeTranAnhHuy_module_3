<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/10/2023
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/student">List All Student</a>
    </h2>
    <a>${mess}</a>
</center>

<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>User Name:</th>
                <td><input type="text" name="name" id="name" size="45"/></td>
            </tr>
            <tr>
                <th>User Birthday:</th>
                <td><input type="text" name="birthday" id="birthday" size="45"/></td>
            </tr>
            <tr>
                <th>Address:</th>
                <td><input type="text" name="address" id="address" size="15"/></td>
            </tr>
            <tr>
                <th>Class:</th>
                <select name="classId">
                    <c:forEach var="class" items="${classList}">
                    <option value="${class.getId()}">${class.getName()}</option>
                    </c:forEach>
                </select>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
