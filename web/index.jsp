<%-- 
    Document   : index
    Created on : Nov 29, 2015, 5:48:01 PM
    Author     : William Reithmeyer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="includes/header.jsp" %>
    <body>
        <section>
            <div class="container">
                <%@include file="includes/banner.jsp" %>
                <div class="torso">
                    <h2>What's new?</h2>
                    
                    <c:forEach var="item" items="${events}">
                        <div class="event">
                            <div class="event_header">
                                <div class="event_title">${item.getTitle()}</div>
                                <div class="event_date_day">${item.getDateDay()}</div>
                            </div>
                            <div class="event_body">
                                <div class="event_image"></div>
                                <div class="event_desc">${item.getDescription()}</div>
                            </div>
                            <div class="event_footer">
                                <div class="event_creator">by ${item.getCreator()} at ${item.getDateTime()}</div>
                                <%if(request.getRemoteUser() != null){%>
                                <div class="event_editor"><a href="<c:url value='/administrators/editEvent'><c:param name='eventId' value='${item.getId()}'/></c:url>">Edit</a><a href="<c:url value='/administrators/deleteEvent'><c:param name='eventId' value='${item.getId()}'/></c:url>">Delete</a></div>
                                <%}%>
                            </div>
                        </div>
                        
                    </c:forEach>
                        
                </div>
            </div>
        <%@include file="includes/footer.jsp" %>
    </section>
    </body>
</html>
