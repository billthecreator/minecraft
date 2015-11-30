<%-- 
    Document   : deleteEvent
    Created on : Nov 30, 2015, 3:34:47 AM
    Author     : William Reithmeyer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="/includes/header.jsp" %>
    <body>
        <section>
            <div class="container">
                <%@include file="/includes/banner.jsp" %>
                <div class="torso">
                    <h2>Delete Event</h2>
                    <h6>Delete this?</h6>
                    <div class="event">
                        <div class="event_header">
                            <div class="event_title">${event.getTitle()}</div>
                            <div class="event_date_day">${event.getDateDay()}</div>
                        </div>
                        <div class="event_body">
                            <div class="event_image"></div>
                            <div class="event_desc">${event.getDescription()}</div>
                        </div>
                        <div class="event_footer">
                            <div class="event_creator">by ${event.getCreator()} at ${event.getDateTime()}</div>
                        </div>
                    </div>
                    <form action="<c:url value="/administrators/processDeletion"/>" method="post">
                    </form>
                </div>
            </div>
        <%@include file="/includes/footer.jsp" %>
    </section>
    </body>
</html>
