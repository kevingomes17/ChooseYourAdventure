<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty comments}">
    <ol>
        <br>
        <strong>Comments</strong>
        <c:forEach items="${comments}" var="cobj">
            <li>
                <div class="comment">${cobj.getDescription()}</div>
                Likes: ${commentlikes.get(cobj.getId().toString())} Dislikes: ${commentdislikes.get(cobj.getId().toString())} <a class="likecomm" href="${BasePath}/likes/likecomment.htm?commentId=${cobj.getId()}">Like</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="dislikecomm" href="${BasePath}/likes/dislikecomment.htm?commentId=${cobj.getId()}">Dislike</a>
            </li>
        </c:forEach>
    </ol>
</c:if>

<c:if test="${empty comments}">
    No comments yet!
</c:if>        

<a class="new-comment-link" href="${BasePath}/discussion/new_comment.htm?threadId=${threadId}">Add a Comment</a>
<br><br>
