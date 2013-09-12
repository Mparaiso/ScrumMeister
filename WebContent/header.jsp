<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${initParam.title}</title>
</head>
<body>
	<%-- 
        @note @java @jsp utiliser EL à la place d'une expression
        <h1><%=getServletContext().getInitParameter("title")%></h1>
    --%>
	<h1>${initParam.title}</h1>