<%@page import="org.chooseadventure.service.LikesDao"%>
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
    <div><a class="likeatt" href="${BasePath}/likes/likeatt.htm?attId=${attraction.getId()}">Like</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="dislikeatt" href="${BasePath}/likes/dislikeatt.htm?attId=${attraction.getId()}">Dislike</a></div>
    <div >Likes: ${attlikescount}&nbsp;&nbsp;&nbsp;&nbsp;Dislikes: ${attdislikescount}</div>
</div>

<br/>
<c:if test="${not empty Username}">
    <a href="${BasePath}/attraction/purchase-attraction.htm?attractionId=${attraction.getId()}">Purchase Ticket</a>
</c:if>
    <c:if test="${empty Username}">
        <a href="${BasePath}/user/login.htm">Login</a> | <a href="${BasePath}/user/register.htm">Register</a> to purchase ticket.
    </c:if>
<br>

<c:if test="${not empty discussions}">
    <h4>Discussion Topics/Threads</h4>
    <div id="discussion-topics-wrapper">
        <ul>
            <c:forEach items="${discussions}" var="dobj">
                <li>
                    Topic: ${dobj.getTitle()} <a class="add-thread" href="${BasePath}/discussion/new_thread.htm?topicId=${dobj.getId()}">Add Thread</a>
                    <br>
                    Likes: ${topicLikes.get(dobj.getId().toString())} &nbsp;&nbsp;&nbsp; Dislikes: ${topicDislikes.get(dobj.getId().toString())}&nbsp;&nbsp;&nbsp;<a class="liketopic" href="${BasePath}/likes/liketopic.htm?topicId=${dobj.getId().toString()}">Like</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="disliketopic" href="${BasePath}/likes/disliketopic.htm?topicId=${dobj.getId().toString()}">Dislike</a>

                    <br><br>
                    <div><strong>Threads</strong></div>
                    <c:if test="${not empty dThreads.get(dobj.getId().toString())}">
                        <ol>
                            <c:forEach items="${dThreads.get(dobj.getId().toString())}" var="thobj">

                                <!--skgfj-->
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