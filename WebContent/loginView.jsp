<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >

	<%
		String msg = (String) request.getAttribute("msg");
	%>

	<form action="LoginCtl" method="post">
		<%@ include file="Header.jsp"%>

		<table>
			<tr>
				<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>
			</tr>
			<tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="SignIn">
					<input type="submit" name="operation" value="SignUp"></td>
			</tr>
		</table>
	</form>

</body>
</html>