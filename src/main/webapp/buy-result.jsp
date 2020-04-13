<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stmt" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<content:base>
    <div class="jumbotron">
        <div class="container">

                <stmt:if test="${sessionScope.user == null}">
                    <div class="alert alert-warning text-center" role="alert">
                            ${message}
                    </div>
                </stmt:if>

                <stmt:if test="${sessionScope.user != null}">
                    <div class="alert alert-success" role="alert">
                            <h1>Привет! Зареганный</h1>
                    </div>
                </stmt:if>

        </div>
    </div>
</content:base>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>

</body>
</html>
