<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<header>
    <jsp:include page="header.jsp"/>
</header>

<content:base>
    <div class="container mt-1">
        <div class="jumbotron">
            <h1>Форма регистрации</h1>
            <form action="RegistrationServlet" method="POST">
                <div class="form-group">
                    <label for="InputName">Email address</label>
                    <input type="text" class="form-control" id="InputName" aria-describedby="emailHelp" name="firstName">
                </div>
                <div class="form-group">
                    <label for="InputEmail">Email address</label>
                    <input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" name="email">
                </div>
                <div class="form-group">
                    <label for="InputPassword">Password</label>
                    <input type="password" class="form-control" id="InputPassword" name="password">
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
