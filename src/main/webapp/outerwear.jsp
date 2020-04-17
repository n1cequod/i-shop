<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="loop" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <div class="row row-cols-1 row-cols-md-3">
                <loop:forEach var="item" items="${productList}">
                    <div class="col mb-2">
                        <div class="card border-0 w-75">
                            <img src="img/${item.photo}" class="card-img-top w-75" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">${item.label}</h5>
                                <p class="card-text"><strong>Размер: </strong>${item.size}</p>
                                <p class="card-text"><strong>Описание: </strong>${item.description}</p>
                                <p class="card-text"><strong>Цена: </strong>${item.price} руб.</p>
                                <a href="CartServlet?id=${item.id}&action=add" class="btn btn-primary">Добавить в корзину</a>
                            </div>
                        </div>
                    </div>
                </loop:forEach>
            </div>
        </div>
    </content:base>

    <footer>
        <jsp:include page="footer.jsp"/>
    </footer>

</body>
</html>
