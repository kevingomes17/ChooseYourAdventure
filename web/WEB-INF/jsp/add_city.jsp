<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="POST">
    <input type="text" name="city" value="Chicago"></input>
    <input type="submit" value="Add"></input>
</form>

<ul>
    <c:forEach items="${cities}" var="cityObj">
        <li>${cityObj.getName()}</li>
    </c:forEach>
</ul>