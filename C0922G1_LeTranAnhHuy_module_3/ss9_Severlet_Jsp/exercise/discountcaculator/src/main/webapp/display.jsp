<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 12/29/2022
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div style="background: aquamarine;font-family: 'UVN Saigon'">
    <h3>Tên Sản Phẩm: ${name}</h3>
    <h3>Mô Tả Sản Phẩm: ${product}</h3>
    <h3>Giá Sản Phẩm: ${listprice}</h3>
    <h3>Tỉ Lệ Chiết Khấu: ${discountpercent}</h3>
    <h3>Lượng Chiết Khấu: ${discountamount}</h3>
    <h3>Giá Sau Khi Chiết Khấu: ${discountprice}</h3>
</div>
</body>
</html>
