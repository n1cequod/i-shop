<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stmt" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<body>

    <header>
        <jsp:include page="../header.jsp"/>
    </header>


    <content:base>
    <div class="pb-5 mt-5">
        <div class="container">
            <ul class="nav nav-tabs" id="myTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="personal-info-tab" data-toggle="tab" href="#personal" role="tab"
                       aria-controls="personal-info-tab" aria-selected="true">Личная информация</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="orders-tab" data-toggle="tab" href="#orders" role="tab"
                       aria-controls="orders-tab" aria-selected="false">Информация о заказах</a>
                </li>
            </ul>


            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="personal" role="tabpanel" aria-labelledby="personal-info-tab">
                    <jsp:include page="personal-info.jsp"/>
                </div>
                <div class="tab-pane fade" id="orders" role="tabpanel" aria-labelledby="orders-tab">
                    <jsp:include page="personal-orders.jsp"/>
                </div>
            </div>

        </div>
    </div>
    </content:base>


    <footer>
        <jsp:include page="../footer.jsp"/>
    </footer>
</body>
</html>
