<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/4/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/user">List All Users</a>
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
                <th>User Email:</th>
                <td><input type="text" name="email" id="email" size="45"/></td>
            </tr>
            <tr>
                <th>Country:</th>
                <td><input type="text" name="country" id="country" size="15"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
