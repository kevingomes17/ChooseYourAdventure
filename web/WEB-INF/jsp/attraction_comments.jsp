<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty comments}">
    <c:forEach items="${comments}" var="cobj">
        <div class="comment">${cobj.getTitle()}</div>
    </c:forEach>
</c:if>
        
<c:if test="${empty comments}">
    No comments yet!
</c:if>        
        
<a href="#">Add comment</a>
