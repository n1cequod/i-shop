<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stmt" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="loop" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Title</title>
</head>
<body>

    <content:base>
        <loop:forEach var="item" items="${ordersIdList}">
            Номер заказа: ${item.orderId}
            Дата заказа: <fmt:formatDate value="${item.orderTime}" pattern="dd.MM.yyyy"/>
        </loop:forEach>
    </content:base>

</body>
</html>
