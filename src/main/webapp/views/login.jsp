<%--
  Created by IntelliJ IDEA.
  User: bthai
  Date: 5/15/2024
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <title>Login Page!</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Please Login</h1>
        <h3 class="text-danger">${loginErr}</h3>
        <form:form action="login" method="post" modelAttribute="user">
            <table>
                <tr>
                    <td>User name:</td>
                    <td>
                        <form:input path="username" value="${cookie.username.value}"/>
                        <br/><form:errors cssClass="text-danger" path="username"/>
                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <form:password path="password" value="${cookie.password.value}"/>
                        <br/><form:errors cssClass="text-danger" path="password"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="checkbox" name="savePass" value="save" ${cookie.save.value}/>Save Password</td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Login"/>
                        <input type="reset" value="Cancel"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
