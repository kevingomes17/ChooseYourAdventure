<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <div id="attractionname">
        <h2>${attraction.getName()}</h2>
        <br>
    </div>
    <div id="attractionaddress">
        Address: <br>
        ${attraction.getAddress()}
    </div>
    <br>
    <div id="hours">
        Hours of Operation: ${attraction.getTimings()}
    </div>
    <br>
    <div id="ticketcost">
        Ticket Cost: $${attraction.getCostperticket()}
    </div>
    <div ></div>
</div>
<br><br>
<li><a href="${BasePath}/discussion/attraction_topics.htm?attraction=${attraction.getId()}">View discussions on ${attraction.getName()}</a>