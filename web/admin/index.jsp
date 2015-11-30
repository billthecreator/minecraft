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
                        <table>
                            <tr>
                                <td>Title</td>
                                <td><input name="event_title"></td>
                            </tr>
                            <tr>
                                <td>Description</td>
                                <td><textarea name="event_desc"></textarea></td>
                            </tr>
                            <tr>
                                <td>Image URL</td>
                                <td><input name="event_featImage"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="submit" value="Add"></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        <%@include file="/includes/footer.jsp" %>
    </section>
    </body>
</html>
