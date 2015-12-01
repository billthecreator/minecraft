<%-- 
    Document   : index
    Created on : Nov 30, 2015, 12:36:02 AM
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
                    <h2>Admin Dashboard</h2>
                    <form action="<c:url value="/administrators/addEvent"/>" method="post">
                        <table class="event_maker">
                            <tr>
                                <td><input class="textField" name="event_title" placeholder="Post Title"></td>
                            </tr>
                            <tr>
                                <td>
                                    <textarea class="textField" name="event_desc" placeholder="Description" style="resize: none; overflow-y: hidden; height: 95px;"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td><input class="textField" name="event_featImage" placeholder="URL to image"></td>
                            </tr>
                            <tr>
                                <td><input class="button" type="submit" value="Add"></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
<%@include file="/includes/footer.jsp" %>
    </section>
    </body>
</html>
