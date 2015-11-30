<%-- 
    Document   : pictures
    Created on : Nov 29, 2015, 9:50:13 PM
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
                    <h2>Pictures</h2>
                    <c:forEach var="item" items="${pictures}">
                        <div class="thumbs">
                            <a target="_blank" href="/minecraft/pictures/${item}">
                                <img src="/minecraft/pictures/thumbs/${item}"/>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        <%@include file="includes/footer.jsp" %>
    </section>
    </body>
</html>
