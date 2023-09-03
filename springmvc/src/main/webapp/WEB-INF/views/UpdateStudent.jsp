<%@page import="com.jspider.springmvc.pojo.StudentPOJO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="Navbar.jsp" />
<%
String msg = (String) request.getAttribute("msg");
%>
<%
StudentPOJO pojof = (StudentPOJO) request.getAttribute("pojo");
%>
<%
List<StudentPOJO> pojos = (List<StudentPOJO>) request.getAttribute("pojolist");
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
	<h1>Update Page</h1>
	<div align="center">
		<%
		if (pojof == null) {
		%>
		<form action="./update" method="post">
			<fieldset>
				<legend>Select Student</legend>
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="SELECT">
		</form>
		<%
		if (msg != null) {
		%>
		<h4><%=msg%></h4>
		<%
		}
		%>

		<%
		if (pojos != null) {
		%>
		<table>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>MOBILE</th>
				<th>ADDRESS</th>
			</tr>
			<%
			for (StudentPOJO pojo : pojos) {
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getMobile()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
			<%
			}
			}
			%>
		</table>
		<%
		} else if (pojof != null) {
		%>
		<form action="./updatedata" method="post">
			<fieldset>
				<legend>Update Student Details</legend>
				<table>
					<tr>
						<td>ID</td>
						<td><input type="text" name="id" value="<%=pojof.getId()%>"></td>
					</tr>
					<tr>
						<td>NAME</td>
						<td><input type="text" name="name"
							value="<%=pojof.getName()%>"></td>
					</tr>
					<tr>
						<td>EMAIL</td>
						<td><input type="text" name="email"
							value="<%=pojof.getEmail()%>"></td>
					</tr>
					<tr>
						<td>MOBILE</td>
						<td><input type="text" name="mobile"
							value="<%=pojof.getMobile()%>"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"
							value="<%=pojof.getAddress()%>"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="UPDATE">
		</form>
		<%
		}
		%>
	</div>
</body>
</html>