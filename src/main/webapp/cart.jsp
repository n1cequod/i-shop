<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stmt" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="loop" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>
<header>
    <jsp:include page="header.jsp"/>
</header>

<content:base>
    <div class="pb-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                    <stmt:if test="${sessionScope.cart != null}">
                    <table class="table table-borderless">

                        <thead class="bg-light text-uppercase">
                        <tr>
                            <th scope="col">Товар</th>
                            <th scope="col" class="text-center">Цена</th>
                            <th scope="col" class="text-center">Количество</th>
                            <th scope="col" class="text-center">Удалить</th>
                        </tr>
                        </thead>

                        <tbody>
                        <loop:forEach var="item" items="${sessionScope.cart}">
                        <tr>
                            <td>
                                <div class="p-2">
                                    <img src="img/${item.product.photo}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                    <div class="ml-3 d-inline-block align-middle">
                                        <h5 class="mb-0">
                                            <a href="#" class="text-dark d-inline-block align-middle">${item.product.label}</a>
                                        </h5>
                                        <span class="text-muted font-weight-normal font-italic d-block">Размер: ${item.product.size}</span>
                                    </div>
                                </div>
                            </td>
                            <td class="align-middle text-center" id="price"><strong>&#8381;${item.product.price}</strong></td>
                            <td class="align-middle text-center" id="qnty">
                                <a href="CartServlet?id=${item.product.id}&action=removeOne"><i class="fa fa-minus"></i></a>
                                <strong>${item.quantity}</strong>
                                <a href="CartServlet?id=${item.product.id}&action=add"><i class="fa fa-plus"></i></a>
                            </td>
                            <td class="align-middle text-center">
                                <a href="CartServlet?id=${item.product.id}&action=removeAll" class="text-dark"><i class="fa fa-trash"></i></a>
                            </td>
                        </tr>
                        </loop:forEach>

<%--                        Сумма товаров--%>
                        <stmt:set var="totalSum" value="${0}"/>
                        <loop:forEach var="item" items="${sessionScope.cart}">
                            <stmt:set var="totalSum" value="${totalSum + (item.quantity * item.product.price)}"/>
                        </loop:forEach>

<%--                        Кнопка "Купить"--%>
                        <stmt:if test="${totalSum != 0}">
                        <tr>
                            <td></td>
                            <td class="align-middle text-center">
                                <strong>Итого:
                                    ${totalSum}
                                </strong>
                            </td>
                            <td></td>
                            <td class="align-middle text-center">
                                <a href="BuyServlet">
                                    <button type="submit" class="btn btn-primary">Купить</button>
                                </a>
                            </td>
                        </tr>
                        </stmt:if>
                        </tbody>
                    </table>
                    </stmt:if>

<%--                    Если корзина пустая--%>
                    <stmt:if test="${totalSum == 0 || sessionScope.cart == null}">
                    <div class="alert alert-info text-center font-weight-normal" role="alert">
                        <span class="align-baseline text-center">Корзина пуста</span>
                    </div>
                    </stmt:if>
                </div>
            </div>
        </div>
    </div>
</content:base>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>
