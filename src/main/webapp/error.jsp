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
                <h1>${message}</h1>
            </div>
        </div>
    </div>
</content:base>

<footer>
    <jsp:include page="footer.jsp"/>
</footer>
</body>
</html>

