<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<form action="" method="POST"
	class="form form-action form-horizontal">
	<fieldset>
		<legend>Create a new book</legend>
		<label for="">Title <input type="text" name="title"
			value="${param.title }" />
		</label> <label for="">Author <input type="text" name="author"
			value="${param.author }" />
		</label> <label for="">Price <input type="number" name="price"
			value="${param.price }" />
		</label>
		<p>
			<input type="submit" value="Create" class="btn" /> <input
				type="reset" value="Rest" class="btn" />
		</p>
	</fieldset>

</form>
<%@include file="footer.jsp"%>
