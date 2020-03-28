<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stmt" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
    <head>
        <title>Войти</title>
    </head>
<body>

<header>
    <jsp:include page="header.jsp"/>
</header>

<content:base>

    <div class="container mt-5">
        <div class="jumbotron">

            <stmt:if test="${logOutMessage != null}">
                <div class="alert alert-success" role="alert">
                        ${logOutMessage}
                </div>
            </stmt:if>

            <h1>Форма авторизации</h1>
            <form action="LoginServlet" method="POST">

                <stmt:if test="${message != null}">
                    <div class="alert alert-primary" role="alert">
                            ${message}
                    </div>
                </stmt:if>

                <div class="form-group">
                    <label for="InputEmail">Email address</label>
                    <input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" name="loginEmail">
                </div>
                <div class="form-group">
                    <label for="InputPassword">Password</label>
                    <input type="password" class="form-control" id="InputPassword" name="loginPassword">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</content:base>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
