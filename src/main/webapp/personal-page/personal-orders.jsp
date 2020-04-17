<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="loop" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
    <div class="pb-5">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                    <table class="table table-borderless">
                        <thead class="bg-light text-uppercase">
                        <tr>
                            <th scope="col" class="text-center">Номер заказа</th>
                            <th scope="col" class="text-center">Дата заказа</th>
                        </tr>
                    </thead>

                    <tbody>
                    <loop:forEach var="item" items="${ordersIdList}">
                    <tr>
                        <td class="align-middle text-center" id="orderId">
                            <a href="${pageContext.request.contextPath}/PersonalOrdersServlet?id=${item.orderId}&action=getOrderDetail">${item.orderId}</a>
                        </td>
                        <td class="align-middle text-center" id="date"><fmt:formatDate value="${item.orderTime}" pattern="dd.MM.yyyy"/></td>
                    </tr>
                    </loop:forEach>

                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

