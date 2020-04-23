<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stmt" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<header>
    <jsp:include page="header.jsp"/>
</header>

<content:base>
    <div class="container mt-5">
        <div class="jumbotron">

            <stmt:if test="${message != null}">
                <div class="alert alert-success" role="alert">
                        ${message}
                </div>
            </stmt:if>

            <h1>Форма регистрации</h1>
            <form action="RegistrationServlet" method="POST">
                <div class="form-group">
                    <label for="InputName">Имя</label>
                    <input type="text" class="form-control" id="InputName" aria-describedby="nameHelp" name="firstName" required>
                </div>
                <div class="form-group">
                    <label for="InputEmail">Электронная почта</label>
                    <input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" name="email" required>
                </div>
                <div class="form-group">
                    <label for="InputPassword">Пароль</label>
                    <input type="password" class="form-control" id="InputPassword" name="pswd" required>
                </div>
                <button type="submit" class="btn btn-primary">Регистрация</button>
            </form>
        </div>
    </div>
</content:base>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>

</body>
</html>
