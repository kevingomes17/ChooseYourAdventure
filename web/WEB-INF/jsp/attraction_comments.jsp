<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty comments}">
    <strong>Comments</strong>
    <c:forEach items="${comments}" var="cobj">
        <div class="comment">${cobj.getDescription()}</div>
    </c:forEach>
</c:if>

<c:if test="${empty comments}">
    No comments yet!
</c:if>        

<a class="new-comment-link" href="${BasePath}/discussion/new_comment.htm?threadId=${threadId}">Add a Comment</a>
<br><br>
