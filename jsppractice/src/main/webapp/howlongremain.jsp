<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@	page import="howlong.VariableInit"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	VariableInit var = new VariableInit();
	%>
	<table align="center">
		<tr align="center">
			<center>
				<h1>수업 남은 일수 계산기</h1>
			</center>
			<td><h1>
					남은 일수는
					<%=var.remain()%>일 입니다.<br><br><br> 
					진행률<%=var.result()%>%입니다.
				</h1></td>

		</tr>
	</table>
</body>
</html>