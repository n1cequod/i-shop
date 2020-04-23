<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stmt" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
    <body>
        <header>
            <jsp:include page="header.jsp"/>
        </header>

            <content:base>
                <div class="pb-5 mt-5">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                                <stmt:if test="${user != null}">
                                    <p class="lead"><strong>Здравствуйте, ${user.firstName}!</strong></p>
                                </stmt:if>
                                <p>
                                    <h5>Добро пожаловать в новый магазин детской одежды <strong>ТВИНСИ КИДС !</strong></h5>
                                </p>
                                <p>
                                    Мы собрали для вас только 100% качественную трикотажную одежду для детей от 0 до 12 лет российских и турецких производителей.
                                </p>
                                <p>
                                    Мы работаем напрямую с фабриками и, поэтому, гарантируем низкие цены и сертифицированное качество 👌.
                                </p>
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
