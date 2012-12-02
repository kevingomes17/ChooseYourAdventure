<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

${package}

<storng>Number of attractions:</strong> ${package.getPackageattractionCollection().size()}


<c:forEach items="${package.getPackageattractionCollection()}" var="attObj">
    <div>
    ${attObj.getAttraction().getName()}
    </div>
</c:forEach>
