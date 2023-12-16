<%@page import="in.co.rays.bean.userBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style = "background-color:grey; ">
<%
 userBean bean = (userBean)session.getAttribute("user");
%>
<%
if(bean != null){
%>
    <h3>
      Hi,
		<%=bean.getFirstName()%></h3>
		<a href="UserListCtl.do" >UserList</a>
		<a href="LoginCtl?operation=logout" >Logout</a>
	<%
		} else {
	%>
	<h3>Hi, Guest</h3>
	<%
		}
	%>
	<hr>
      
</body>
</html>