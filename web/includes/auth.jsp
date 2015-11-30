<%@page import="com.sun.xml.internal.ws.util.StringUtils"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="auth">
    <% if(request.getRemoteUser() == null){%>
    <a onclick="javascript:event.target.port=8443;event.target.protocol = 'https:';" href="/minecraft/admin">Login</a>
    <% } else {%>
    <p>Hello, <%=StringUtils.capitalize(request.getRemoteUser())%></p>
    <a  onclick="javascript:event.target.port=8080;event.target.protocol = 'http:';" href="<c:url value='/administrators/logout'/>">Logout</a>
    
    <% }%>
    
</div>