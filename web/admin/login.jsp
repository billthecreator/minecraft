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
                        <table class="login">
                            <tr><td><input class="textField" type="text" name="j_username" value="" placeholder="Username"></td></tr>
                            <tr><td><input class="textField" type="password" name="j_password" value="" placeholder="Password"></td></tr>
                            <tr><td><input class="button" type="submit" value="Log in"/></td></tr>
                        </table>
                    </form>
                </div>
            </div>
        <%@include file="../includes/footer.jsp" %>
    </section>
    </body>
</html>