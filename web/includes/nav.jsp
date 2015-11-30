<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% String oclass = ""; if(request.getRemoteUser() != null){oclass = "bgRed";}%>
<div class="nav <%=oclass%>">
                <div class="links">
                    <% if(request.getRemoteUser() != null){%>
                    <a href="<c:url value='/administrators/'/>">Dashboard</a>
                    <%}%>
                    <a href="<c:url value='/pages/'/>">Home</a>
                    <a href="<c:url value='/pages/rules'/>">Server Rules</a>
                    <a href="<c:url value='/pages/pictures'/>">Pictures</a>
                    <a href="<c:url value='/pages/map'/>">Web Map</a>
                    <p class="fR">IP: ${ip}</p>
                </div>
            </div>