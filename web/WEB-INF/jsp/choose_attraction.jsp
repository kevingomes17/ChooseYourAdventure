<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table width="100%">
    <tr>
        <td valign="top" width="50%">
            <form method="POST" id="fitler-attraction-form">

                <table width="100%">
                    <tr>
                        <td>Select City</td>
                        <td>
                            <select class="required" name="city" id="city">
                                <option value="">-select-</option>
                                <c:forEach items="${cities}" var="cityObj">
                                    <option value="${cityObj.getId()}">${cityObj.getName()}</option>
                                </c:forEach>
                            </select>                
                        </td>
                    </tr>
                    <tr>
                        <td>Select Attraction</td>
                        <td>
                            <span id="attraction-wrapper">
                                <select name="attraction" id="attraction">
                                    <option value="">-select-</option>
                                </select>
                            </span>
                        </td>
                    </tr>
                    <tr>
                        <td>Select Package</td>
                        <td>
                            <span id="package-wrapper">
                                <select name="package" id="package">
                                    <option value="">-select-</option>                    
                                </select>                
                            </span>
                        </td>
                    </tr>
                </table>

                <input type="submit" class="button" value="View"></input>

            </form>
        </td>
        <td valign="top" width="50%">            
            <c:if test="${not empty packages}">
                <strong>Available Packages:</strong>
                <ol>
                <c:forEach items="${packages}" var="pkgObj">
                    <li><a href="${BasePath}/attraction/package-view.htm?package=${pkgObj.getId()}">${pkgObj.getName()}</a></li>
                </c:forEach>
                    </ol>
            </c:if>
        </td>
    </tr>
</table>

<script type="text/javascript">
    $(function() {
        Attraction.initHome();
    });
</script>