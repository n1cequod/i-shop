<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="loop" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
<header>
    <jsp:include page="/header.jsp"/>
</header>
<content:base>
<div class="pb-5">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                <table class="table table-borderless">
                    <thead class="bg-light text-uppercase">
                    <tr>
                        <th scope="col">Товар</th>
                        <th scope="col" class="text-center">Цена</th>
                        <th scope="col" class="text-center">Количество</th>
                    </tr>
                    </thead>

                    <tbody>
                    <loop:forEach var="item" items="${productList}">
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
                        <td class="align-middle text-center" id="qnty">${item.quantity}</td>
                    </tr>
                    </loop:forEach>
                </table>
            </div>
        </div>
    </div>
</div>
</content:base>
<footer>
    <jsp:include page="/footer.jsp"/>
</footer>
</body>
</html>

