<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${initParam.title}</title>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="span12">
				<%-- 
        @note @java @jsp utiliser EL à la place d'une expression
        <h1><%=getServletContext().getInitParameter("title")%></h1>
    --%>
				<h1>${initParam.title}</h1>