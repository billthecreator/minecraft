<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="nav">
                <div class="links">
                    <a href="<c:url value='/pages/'/>">Home</a>
                    <a href="<c:url value='/pages/rules'/>">Server Rules</a>
                    <a href="<c:url value='/pages/pictures'/>">Pictures</a>
                    <a href="<c:url value='/pages/map'/>">Web Map</a>
                    <p class="fR">IP: ${ip}</p>
                </div>
            </div>