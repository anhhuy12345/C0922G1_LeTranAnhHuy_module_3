<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 13-Jun-22
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Login V1</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="/login/images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/login/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/login/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/login/vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/login/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="/login/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href=/login/css/util.css">
        <link rel="stylesheet" type="text/css" href="/login/css/main.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" href="template/bootstrap/css/bootstrap.css">
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100">
                <div class="wrap-login100" style="padding: 75px">
                    <div class="login100-pic js-tilt" data-tilt>
                        <img src="/login/images/img-01.png" alt="IMG">
                    </div>
                    <%-------------form login----------%>
                    <form class="login100-form validate-form" action="/login" method="post">
					<span class="login100-form-title">
						Member Login
					</span>
                        <p class="text-danger font-weight-bold font-italic">${messLogin}</p>

                        <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
                            <input class="input100" type="text" name="username"
                                   value="${cookie.get("cookieUsername").getValue()}" placeholder="Username">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <input class="input100" type="password" name="password" placeholder="Password">
                            <span class="focus-input100"></span>
                            <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
                        </div>

                        <div class="form-group form-check">
                            <input type="checkbox" name="rememberMe" value="true" class="form-check-input"
                                   id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Remember Me</label>
                        </div>

                        <div class="container-login100-form-btn">
                            <button class="login100-form-btn" type="submit">
                                Login
                            </button>
                        </div>
                        <br>
                        <div class="text-center p-t-12">
						<span class="txt1">
							Forgot
						</span>
                            <a class="txt2" href="#">
                                Username / Password?
                            </a>
                        </div>

                        <div class="text-center p-t-136">
                            <a class="txt2" href="#">
                                Create your Account
                                <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <!--===============================================================================================-->
        <script src="/login/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="/login/vendor/bootstrap/js/popper.js"></script>
        <script src="/login/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="/login/vendor/select2/select2.min.js"></script>
        <!--===============================================================================================-->
        <script src="/login/vendor/tilt/tilt.jquery.min.js"></script>
        <script>
            $('.js-tilt').tilt({
                scale: 1.1
            })
        </script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>
        <script src="template/bootstrap/jquery-3.6.0.min.js"></script>
        <script src="template/bootstrap/js/bootstrap.js"></script>
    </body>
</html>
