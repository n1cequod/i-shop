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
                        <stmt:if test="${user != null}">
                            <div class="jumbotron">
                                <div class="container">
                                    <p class="lead">Hello In Base ${user.email} ${user.firstName} ${user.id}</p>
                                </div>
                            </div>
                        </stmt:if>

                        <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid aspernatur, dolorem doloremque earum, error exercitationem facilis fuga minus odit pariatur possimus quas quidem sapiente sunt temporibus ut veritatis vero.</p>
                    </div>
                </div>
            </content:base>

        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
