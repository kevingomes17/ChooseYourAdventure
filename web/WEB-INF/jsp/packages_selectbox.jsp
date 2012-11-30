<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<select name="package" id="package">
    <option value="">-select-</option>
    <c:forEach items="${packages}" var="attObj">
        <option value="${attObj.getId()}">${attObj.getName()}</option>
    </c:forEach>
</select>    