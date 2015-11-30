<%-- 
    Document   : login
    Created on : Nov 30, 2015, 12:45:04 AM
    Author     : William Reithmeyer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../includes/header.jsp" %>
    <body>
        <section>
            <div class="container">
                <%@include file="../includes/banner.jsp" %>
                <div class="torso">
                    <h2>Admin login</h2>
                    <form action="j_security_check" method="get" autocomplete="off">          
                        <input type="text" name="j_username" value="" placeholder="Username">
                        <input type="password" name="j_password" value="" placeholder="Password">
                        <input class="button" type="submit" value="Log in"/>
                    </form>
                </div>
            </div>
        <%@include file="../includes/footer.jsp" %>
    </section>
    </body>
</html>