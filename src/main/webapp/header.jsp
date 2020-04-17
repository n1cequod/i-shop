<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stmt" uri="http://java.sun.com/jsp/jstl/core" %>



<html>
<body>
<content:base>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">
                <img src="${pageContext.request.contextPath}/img/logo.png" width="170" height="60" class="d-inline-block align-top" alt="">
            </a>
        </nav>
        <div class="collapse navbar-collapse ml-3" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown active">

                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <strong>Каталог товаров</strong>
                    </a>

                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ProductDisplayServlet?category=outerwear">Одежда</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ProductDisplayServlet?category=footwear">Обувь</a>
                    </div>
                </li>
            </ul>

<%--            Если пользователь не авторизован--%>
            <stmt:if test="${user == null}">
                <form class="form-inline my-2 my-lg-0">
                    <button class="btn btn-outline-success my-2 my-sm-0 mr-4" type="button">
                        <a href="${pageContext.request.contextPath}/cart.jsp">
                            <i class="fa fa-shopping-cart" style="font-size:24px"> </i>
                        </a>
                    </button>
                    <button class="btn btn-outline-success my-2 my-sm-0 mr-1" type="button">
                        <a href="${pageContext.request.contextPath}/form-registration.jsp">Регистрация</a>
                    </button>
                    <button class="btn btn-outline-success my-2 my-sm-0" type="button">
                        <a href="${pageContext.request.contextPath}/form-login.jsp">Вход</a>
                    </button>
                </form>
            </stmt:if>

<%--            Если пользователь авторизовался--%>
            <stmt:if test="${user != null}">
                <form class="form-inline my-2 my-lg-0">
                    <button class="btn btn-outline-success my-2 my-sm-0 mr-4" type="button">
                        <a href="${pageContext.request.contextPath}/cart.jsp">
                            <i class="fa fa-shopping-cart" style="font-size:24px"></i>
                        </a>
                    </button>
                    <button class="btn btn-outline-success my-2 my-sm-0 mr-1" type="button">
                        <a href="${pageContext.request.contextPath}/PersonalOrdersServlet?action=getOrdersId">${user.firstName}</a>
                    </button>
                    <button class="btn btn-outline-success my-2 my-sm-0" type="button">
                        <a href="${pageContext.request.contextPath}/LogoutServlet">Выход</a>
                    </button>
                </form>
            </stmt:if>

        </div>
    </nav>
</content:base>

</body>
</html>
