<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Navbar.jsp" />
<%
StudentPOJO pojo = (StudentPOJO) request.getAttribute("Student");
String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
form {
	margin-top: 10px;
}

form table {
	margin: auto;
	width: 100%;
}

tr {
	text-align: center;
}

fieldset table {
	margin: auto;
	text-align: left;
}

fieldset {
	margin: 15px 520px;
	text-align: center;
}

legend {
	color: white;
	background-color: #333;
}

body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}

#data {
	background-color: white;
	border: 1px solid black;
	width: 100%;
	border: 1px solid black;
}

#data td {
	border: 1px solid black;
	text-align: center;
}
</style>
</head>
<body>
	<h1>Search Page</h1>
	<div align="Center">
		<form action="./search" method="post">
			<fieldset>
				<legend>Search Student</legend>

				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</fieldset>
			<input type="Submit" value="Search">
		</form>
		<%
		if (msg != null) {
		%>
		<h1><%=msg%></h1>
		<%
		}
		%>

		<%
		if (pojo != null) {
		%>
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>MOBILE</th>
				<th>ADDRESS</th>
			</tr>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getMobile()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
		</table>
		<%
		}
		%>



	</div>
</body>
</html>