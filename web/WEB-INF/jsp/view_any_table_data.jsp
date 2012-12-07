<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="GET">
    <select name="tableName" id="tableName" class="required">
        <option value="">-select-</option>    
        <c:forEach items="${tables}" var="tobj">
            <option value="${tobj.getTableName()}">${tobj.getTableName()}</option>
        </c:forEach>
    </select>
    
    <input type="submit" value="Show Data"/>    
</form>

<c:forEach items="${results}" var="robj">
    <div>${robj.toString()}</div>
</c:forEach>