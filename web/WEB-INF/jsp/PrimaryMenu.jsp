<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul id="primary-menu">
<c:forEach items="${PrimaryMenu}" var="entry">
    <li><a href="${entry.value}">${entry.key}</a></li>
</c:forEach>
</ul>