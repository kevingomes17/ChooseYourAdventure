<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="view-attraction-wrapper">
    <div class="attraction-address">
        <strong>Address:</strong>
        ${attraction.getAddress()}
    </div>
    <div class="hours">
        <strong>Hours of Operation:</strong> ${attraction.getTimings()}
    </div>
    <div class="description">
        <strong>Description:</strong>
        ${attraction.getDescription()}
    </div>
    <div id="ticketcost">
        <strong>Ticket Cost:</strong> $${attraction.getCostperticket()}
    </div>
    <div >Likes: ${likescount} &nbsp; Dislikes: ${dislikescount}</div>
</div>
<br>

<c:if test="${not empty discussions}">
    <h4>Discussion Topics/Threads</h4>
    <div id="discussion-topics-wrapper">
    <ul>
        <c:forEach items="${discussions}" var="dobj">
            <li>
                ${dobj.getTitle()} <a class="add-thread" href="${BasePath}/discussion/new_thread.htm?topicId=${dobj.getId()}">Add Thread</a>
                <c:if test="${not empty dThreads.get(dobj.getId().toString())}">
                    <ol>
                        <c:forEach items="${dThreads.get(dobj.getId().toString())}" var="thobj">
                            <li>
                                <a href="${BasePath}/attraction/attraction-comments.htm?attractionId=${attraction.getId()}&topicId=${dobj.getId()}&threadId=${thobj.getId()}" class="discussion-thread-title">${thobj.getTitle()}</a>
                                <div class="thread-comments"></div>
                            </li>
                        </c:forEach>
                    </ol>
                </c:if>
            </li>            
        </c:forEach>
    </ul>
    </div>
</c:if>
    
<script type="text/javascript">
    $(function() {
        Attraction.initView();
    });
</script>    