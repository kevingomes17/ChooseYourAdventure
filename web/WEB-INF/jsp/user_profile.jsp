<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty message}">
    <div class="message">${message}</div>
</c:if>

<table>
    <tr>
        <td>Name:</td>
        <td>${user.getDisplayname()}</td>
    </tr>
    <tr>
        <td>Phone #:</td>
        <td>
            <form method="POST">
            <c:forEach items="${user.getUserphonesCollection()}" var="phone">
                <input type="text" name="phone" value="${phone.getPhonenumber()}"/> <br/>
            </c:forEach>            
                <input type="submit" value="Edit" />
            </form>
        </td>
    </tr>
    <c:if test="${not empty user.getUserwebsite()}">
    <tr>
        <td>Membership:</td>
        <td>${user.getUserwebsite().getMembershiptype().getName()}</td>
    </tr>
    <tr>
        <td>Reward Points:</td>
        <td>${user.getUserwebsite().getRewardpoints()}</td>
    </tr>
    </c:if>    
    <tr>
        <td>Email:</td>
        <td>${user.getEmail()}</td>
    </tr>
    <tr>
        <td>Address:</td>
        <td>${user.getAddress()}, ${user.getCity()}, ${user.getZipcode()}</td>
    </tr>    
</table>
    
        <c:if test="${not empty transactions}">
            <h4>Transactions</h4>
            <table width="100%">
                <thead>
                    <tr>
                        <th>Amount</th>
                        <th>Created On</th>
                        <th>Credit Card Amount</th>
                        <th>Reward Points Used</th>
                    </tr>
                </thead>
                <tbody>
                    
                
            <c:forEach items="${transactions}" var="tobj">
                <tr>
                    <td>$${tobj.getAmount()}</td>
                    <td>${tobj.getCreatedon()}</td>
                    <td>$${tobj.getCreditcardamount()}</td>
                    <td>${tobj.getRewardpointsused()}</td>
                </tr>
            </c:forEach>
                </tbody>
                </table>
        </c:if>    