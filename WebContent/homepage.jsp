<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.Beer"%>
<%@ include file="header.jsp"%>
<h3>Enjoy our latest beer</h3>
<%
	Beer beer = (Beer) request.getAttribute("beer");
%>
<table>
	<tr>
		<td>Brand</td>
		<td><%=beer.getBrand()%></td>
	</tr>
	<tr>
		<td>Name</td>
		<td><%=beer.getName()%></td>
	</tr>
</table>
<p>
	<a href="<%=request.getContextPath()%>/SelectBeer">Go to beer
		selector</a>
</p>
<%-- @note @jsp include --%>
<%@ include file="footer.jsp"%>