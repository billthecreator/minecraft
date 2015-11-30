<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<% 
    Calendar date = new GregorianCalendar();
    int year = date.get(Calendar.YEAR);  // 2012
%>
        <div class="foot"><p style="text-align: center; padding: 32px;">&copy; Copyright <%=year%> William Reithmeyer All rights reserved.</p></div>
            
