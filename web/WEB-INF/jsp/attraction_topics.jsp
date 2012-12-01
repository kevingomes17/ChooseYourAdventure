<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:forEach items="${discussionTopics}" var="topicObj">
    <option value="${topicObj.getId()}">${topicObj.getTitle()}</option>
</c:forEach> 
