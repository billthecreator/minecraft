<%-- 
    Document   : map
    Created on : Nov 29, 2015, 6:13:44 PM
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
            <!-- nav -->
                <div class="container">
                    <div class="torso">
                        <iframe class="embededMap" src="http://${ip}:40004" width="100%" height="100%">
                            <p>Your browser does not support iframes.</p>
                        </iframe>
                        <a class="button" href="http://${ip}:40004" target="_Blank">View larger</a>
                    </div>
                </div>
            </div>
                <%@include file="includes/footer.jsp" %>
    </section>
    </body>
</html>
