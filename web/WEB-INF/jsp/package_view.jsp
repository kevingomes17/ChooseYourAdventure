<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<storng>Number of attractions:</strong> ${package.getPackageattractionCollection().size()}

<c:if test="${not empty package.getPackageattractionCollection()}">
    <ul>
<c:forEach items="${package.getPackageattractionCollection()}" var="attObj">
    <li><a href="${BasePath}/attraction/view-attraction.htm?attraction=${attObj.getAttraction().getId()}&package=${package.getId()}">${attObj.getAttraction().getName()}</a></li>
</c:forEach>
        </ul>
</c:if>

<c:if test="${not empty Username}">
    <a href="${BasePath}/attraction/purchase-package.htm?packageId=${package.getId()}">Purchase Ticket</a>
</c:if>
    <c:if test="${empty Username}">
        <a href="${BasePath}/user/login.htm">Login</a> | <a href="${BasePath}/user/register.htm">Register</a> to purchase ticket.
    </c:if>
<br>