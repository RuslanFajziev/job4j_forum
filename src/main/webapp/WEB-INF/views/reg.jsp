<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация пользователя</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="card-body" style="width: 50%">
    <form name='login' action="<c:url value='/reg'/>" method='POST'>
        <table class="table">
            <tbody>
            <tr>
                <td>
                    <label for="username">username</label>
                    <input required type='text' name='username' id="username">
                </td>
            </tr>
            <tr>
                <td>
                    <label for="Password">Password</label>
                    <input required type='password' name='Password' id="Password">
                </td>
            </tr>
            <tr>
                <td>Роль:</td>
                <td>
                    <select name="authorityId">
                        <c:forEach var="authority" items="${authorities}">
                            <option value="${authority.id}">${authority.authority}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input name="submit" type="submit" value="OK"/></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div class="btn-group btn-group-toggle" data-toggle="buttons">
        <a class="btn btn-secondary" href="<c:url value='/login'/>" role="button">Авторизация</a>
    </div>
</div>
</body>
</html>
