<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="content" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="stmt" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>


        <table class="table table-borderless w-75">
            <tbody class="font-weight-bold">
            <tr>
                <td class="w-25">Имя:</td>
                <td class="text-left">${sessionScope.user.firstName}</td>
            </tr>
            <tr>
                <td class="w-25">Электронный адрес:</td>
                <td class="text-left">${sessionScope.user.email}</td>
            </tr>
            </tbody>
        </table>


</body>
</html>
