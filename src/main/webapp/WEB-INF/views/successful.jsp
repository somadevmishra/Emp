<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body>
<h2>Hello. You are successful</h2>

<%--  <a href="${pageContext.request.contextPath}/logout">Logout</a> --%> 
<form action="${pageContext.request.contextPath}/logout" method="post">
	<button type="submit">Logout</button>
	<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}"/>
</form>
<form action="${pageContext.request.contextPath}/upload?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
	<input type="file" name="file" id="file">
	
	<button type="submit">Upload</button>
</form>
</body>
</html>