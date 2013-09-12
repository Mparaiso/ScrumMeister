<%@ include file="header.jsp"%>
<!--  form to send datas to JSP page  -->
<h1>Select a beer</h1>
<form action="SelectBeer" method="POST">
	<p>
		<label for="">Color: <select name="color" id="">
				<option value="0">Blue</option>
				<option value="1">Red</option>
				<option value="2">Green</option>
		</select>
		</label>
	</p>
	<p>
		<input type="submit" value="Submit" />
	</p>
</form>
<%@ include file="footer.jsp"%>