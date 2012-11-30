<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="fitler-attraction">
    <table width="40%">
        <tr>
            <td>Select City</td>
            <td>
                <select name="city">
                    <option value="">-select-</option>
                    <c:forEach items="${cities}" var="cityObj">
                        <option value="${cityObj.getId()}">${cityObj.getName()}</option>
                    </c:forEach>
                </select>                
            </td>
        </tr>
        <tr>
            <td>Select Attractions</td>
            <td>
                <select name="attraction">
                    <option value="">-select-</option>
                    <c:forEach items="${attractions}" var="attractionObj">
                        <option value="${attractionObj.getId()}">${attractionObj.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Select Packages</td>
            <td></td>
        </tr>
    </table>

    <input type="submit" value="Search"></input>

</form>