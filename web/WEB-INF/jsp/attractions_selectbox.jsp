<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<select name="attraction" id="attraction">
    <option value="">-select-</option>
    <c:forEach items="${attractions}" var="attObj">
        <option value="${attObj.getId()}">${attObj.getName()}</option>
    </c:forEach>
</select>    