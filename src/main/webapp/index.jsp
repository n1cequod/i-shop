<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>

<html>
    <body>
        <header>
            <jsp:include page="header.jsp"/>
        </header>

        <content:base>
            <div class="jumbotron">
                <div class="container">
                    <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aliquid aspernatur, dolorem doloremque earum, error exercitationem facilis fuga minus odit pariatur possimus quas quidem sapiente sunt temporibus ut veritatis vero.</p>
                </div>
            </div>
        </content:base>

        <footer>
            <jsp:include page="footer.jsp"/>
        </footer>
    </body>
</html>
