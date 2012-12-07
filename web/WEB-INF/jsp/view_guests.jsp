<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty users}">
    <table width="100%">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Membership</th>
                <th>Reward Points</th>
                <th>Phone #</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="uobj">
                <tr>
                    <td>${uobj.getUserbase().getDisplayname()}</td>
                    <td>${uobj.getUserbase().getEmail()}</td>
                    <td>${uobj.getMembershiptype().getName()}</td>
                    <td>${uobj.getRewardpoints()}</td>
                    <td>
                        <c:forEach items="${uobj.getUserbase().getUserphonesCollection()}" var="phone">
                            <div>${phone.getPhonenumber()}</div>
                        </c:forEach>            
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>