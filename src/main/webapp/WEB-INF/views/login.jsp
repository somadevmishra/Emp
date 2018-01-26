<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/succesful" method="post">
<table>
<tr> <td><label>User name</label></td> <td><input type="text" name="username"></td></tr>
<tr> <td><label>Password</label></td> <td><input type="password" name="password"></td></tr>
<tr><td colspan="2"><input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}"/>  </td> </tr>
<tr><td colspan="2" align="center"><button type="submit">Login</button></td></tr>
</table>

</form>
</body>
</html>