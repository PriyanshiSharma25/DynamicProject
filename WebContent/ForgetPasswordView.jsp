<%@page import="in.co.rays.bean.userBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ForgetPasswordCtl" method="post">
<h1>Forget Password</h1>
    <% userBean bean = (userBean)request.getAttribute("bean"); %>
     <% String loginId = (String) request.getAttribute("loginId"); %>
    <% String password = (String) request.getAttribute("password"); %>
    <table>
    <tr>
    <% 
    if (password != null){ 
    %>
    <h1> <%=password%> </h1>
    <%
    } 
    %>
    </tr>
   <tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginId"
					value="<%=bean.getLoginId()%>"></td>
			</tr>
    <tr>
				<th>Password :</th>
				<td><input type="password" name="password"
					value="<%=bean.getPassword()%>"></td>
			</tr>
  
   <tr>
   <th></th>
   <td><input type="submit" value="submit"></td>
   </tr>
   </table>
</form>
</body>
</html>