<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,javax.sql.*,java.util.*"%>
<%@include file="header.jsp"%>
<h3><%=request.getAttribute("subtitle")%></h3>
<table class="table">
	<tr>
		<%-- @see http://stackoverflow.com/questions/2353141/mysql-jdbc-driver-and-eclipse-classnotfoundexception-com-mysql-jdbc-driver  --%>
		<%
			ResultSetMetaData meta = (ResultSetMetaData) request
					.getAttribute("meta");
			int cols = meta.getColumnCount();
			ResultSet rs = (ResultSet) request.getAttribute("rs");
			for (int i = 1; i <= cols; i++) {
		%>
		<td><%=meta.getColumnName(i)%></td>
		<%
			}
		%>
	</tr>
	<%
		while (rs.next()) {
	%>
	<tr>
		<%
			for (int i = 1; i <= cols; i++) {
					out.print("<td>" + rs.getString(i) + "</td>");
				}
		%>
	</tr>
	<%
		}
	%>
</table>
<%@include file="footer.jsp"%>