<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="eshop.*,model.*,dal.*,java.util.*"%>
<%@ include file="header.jsp"%>
<%
	ArrayList<Book> books = (ArrayList<Book>) request
			.getAttribute("books");
%>
<h4>Books</h4>
<table class="table">
	<thead>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>Price</th>
		</tr>
	</thead>
	<tbody>
		<%
			for (Book book : books) {
		%>
		<tr>
			<td><%=book.getTitle()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getPrice()%></td>
		</tr>
		<%
			}
		%>
	</tbody>
</table>
<%@ include file="footer.jsp"%>