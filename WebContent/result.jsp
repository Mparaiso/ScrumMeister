<%@ include file="header.jsp"%>
<%@ page import="java.util.*,model.*" %>
<h2>
	You asked for color
	<%=(String) request.getAttribute("color")%></h2>
<h3>Try the following beers:</h3>
<ol>
	<%
		for (String brand : (List<String>) request.getAttribute("beers")) {
	%>
	<!--  expression language  -->
	<li><%=brand %></li>
	<%
		}
	%>
</ol>
<p>
	<a href="SelectBeer">Select another color</a>
</p>
<%@ include file="footer.jsp"%>